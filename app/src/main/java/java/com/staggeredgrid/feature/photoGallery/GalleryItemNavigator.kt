package java.com.staggeredgrid.feature.photoGallery

import java.com.staggeredgrid.model.PhotoData

interface GalleryItemNavigator {
  fun onClick(photoData: PhotoData)
}