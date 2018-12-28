package java.com.staggeredgrid.feature.photoDetailPage

import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import java.com.staggeredgrid.R
import java.com.staggeredgrid.databinding.PhotoDetailDb
import java.com.staggeredgrid.model.PhotoData

class DetailActivity : Activity() {

  private lateinit var photoDetailDb: PhotoDetailDb

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)
    photoDetailDb = DataBindingUtil.setContentView(this, R.layout.activity_detail)

    intent.getParcelableExtra<PhotoData>("EXTRA_SESSION_ID")?.let {
      photoDetailDb.item = it
    }
  }
}
