package java.com.staggeredgrid.network

import io.reactivex.Single
import retrofit2.http.GET
import java.com.staggeredgrid.model.PhotoData


interface ApiAccess {
  @GET("photos")
  fun getPhotoList(): Single<List<PhotoData?>?>
}