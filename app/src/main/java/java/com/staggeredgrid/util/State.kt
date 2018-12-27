package java.com.staggeredgrid.util

import java.com.staggeredgrid.model.PhotoData


sealed class GetPhotoResultState {
  object Loading : GetPhotoResultState()
  class Error(val throwable: Throwable) : GetPhotoResultState()
  class Success(val list: List<PhotoData>) : GetPhotoResultState()
}

