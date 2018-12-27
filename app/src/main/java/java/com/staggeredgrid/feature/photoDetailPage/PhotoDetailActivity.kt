package java.com.staggeredgrid.feature.photoDetailPage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_photo_detail.fab
import kotlinx.android.synthetic.main.activity_photo_detail.toolbar
import java.com.staggeredgrid.R
import java.com.staggeredgrid.model.PhotoData

class PhotoDetailActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_photo_detail)
    setSupportActionBar(toolbar)
    val photoData = getIntent().getParcelableExtra<PhotoData>("EXTRA_SESSION_ID");
    fab.setOnClickListener { view ->
      Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        .setAction("Action", null).show()
    }
  }
}
