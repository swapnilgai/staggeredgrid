package java.com.staggeredgrid.feature.photoGallery

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_photo_gallery.container
import java.com.staggeredgrid.MainActivity
import java.com.staggeredgrid.R

class PhotoGalleryActivity : MainActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_photo_gallery)
    supportFragmentManager.beginTransaction().add(container.id, PhotoGalleryFragment()).commit()
  }
}
