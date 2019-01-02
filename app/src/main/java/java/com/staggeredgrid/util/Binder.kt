package java.com.staggeredgrid.util


import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.load.engine.DiskCacheStrategy
import java.com.staggeredgrid.R


object Binder {

  @JvmStatic
  @BindingAdapter("imageUrl")
  fun loadImage(imageView: ImageView, imageUrl: String?) {
    GlideApp.with(imageView.context)
      .load(imageUrl)
      .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
      .error(R.drawable.ic_launcher_background) // TODO update error image
      .fallback(R.drawable.ic_launcher_background) // TODO update fallback image
      .into(imageView)
  }

  @JvmStatic
  @BindingAdapter("setError")
  fun setError(view: View, isLoading: Boolean) {
    if (isLoading)
      view.visibility = View.VISIBLE
    else
      view.visibility = View.GONE
  }

  @JvmStatic
  @BindingAdapter("setLoading")
  fun setLoading(view: SwipeRefreshLayout, isLoading: Boolean) {
    if (isLoading)
      view.isRefreshing = true
    else
      view.isRefreshing = false
  }
}