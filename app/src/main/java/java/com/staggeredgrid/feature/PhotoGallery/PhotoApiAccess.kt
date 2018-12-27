package java.com.staggeredgrid.feature.PhotoGallery

import android.content.Context
import io.reactivex.Observable
import io.reactivex.Single
import java.com.staggeredgrid.R
import java.com.staggeredgrid.network.ApiAccess
import java.com.staggeredgrid.util.GetPhotoResultState
import javax.inject.Inject

class PhotoApiAccess @Inject constructor(
  private val apiAccess: ApiAccess,
  private val context: Context
) {


  /**
   * Function get list of photo
   * @return Observable<GetPhotoResultState> and observable which describes state for
   */
  fun getSearchResult(input: String): Observable<GetPhotoResultState> {
    return apiAccess.getPhotoList().flatMap { body ->
      if (body == null)
        Single.just(GetPhotoResultState.Error(Throwable(context.getString(R.string.empty_list_error))))
      else
        Single.just(GetPhotoResultState.Success(body.filterNotNull()))
    }
      .onErrorReturn { throwable: Throwable ->
        GetPhotoResultState.Error(throwable)
      }
      .toObservable()
      .startWith(GetPhotoResultState.Loading)
  }
}