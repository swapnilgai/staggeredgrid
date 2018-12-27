package java.com.staggeredgrid.feature.photoGallery

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableList
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.com.staggeredgrid.model.PhotoData
import java.com.staggeredgrid.util.GetPhotoResultState
import java.util.concurrent.TimeUnit.MILLISECONDS
import javax.inject.Inject

class PhotoGalleryViewModel @Inject constructor(private val photoApiAccess: PhotoApiAccess) :
  ViewModel() {

  private val compositeDisposable = CompositeDisposable()
  val list: ObservableList<PhotoData> = ObservableArrayList()
  val loading: ObservableBoolean = ObservableBoolean(false)
  val error: ObservableBoolean = ObservableBoolean(false)
  private val intentReceiver: PublishSubject<String> = PublishSubject.create()

  companion object {
    private const val DEBOUNCE_INTERVAL: Long = 200
    private const val DUMMY_TRIGGER: String = ""
  }

  init {
    intentReceiver
      .debounce(DEBOUNCE_INTERVAL, MILLISECONDS)
      .observeOn(Schedulers.io())
      .switchMap { photoApiAccess.getSearchResult() }
      .distinctUntilChanged()
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe { t: GetPhotoResultState -> handelResponse(t) }
      .let { compositeDisposable.add(it) }
  }

  fun getSearchResult() {
    intentReceiver.onNext(DUMMY_TRIGGER)
  }

  private fun handelResponse(getPhotoResultState: GetPhotoResultState) {
    when (getPhotoResultState) {
      is GetPhotoResultState.Success -> {
        renderSuccess(getPhotoResultState.list)
      }
      is GetPhotoResultState.Loading -> {
        renderLoading()
      }
      is GetPhotoResultState.Error -> {
        renderError(getPhotoResultState.throwable.message)
      }
      else -> throw IllegalStateException()
    }
  }

  private fun renderSuccess(listItems: List<PhotoData>) {
    list.clear()
    list.addAll(listItems)
    loading.set(false)
  }

  private fun renderLoading() {
    error.set(false)
    loading.set(true)
  }

  private fun renderError(message: String?) {
    list.clear()
    loading.set(false)
    error.set(true)
  }

  override fun onCleared() {
    super.onCleared()
    compositeDisposable.clear()
  }
}