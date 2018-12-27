package java.com.staggeredgrid.feature.photoGallery

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import java.com.staggeredgrid.model.PhotoData

object PhotoItemBinder {

  @JvmStatic
  @BindingAdapter("items")
  fun setSearchList(view: RecyclerView, list: List<PhotoData>) {
    if (view.adapter is PhotoGalleryRecyclerAdapter) {
      val adapter = (view.adapter as PhotoGalleryRecyclerAdapter)
      adapter.let {
        it.clear()
        it.addAll(list)
        it.notifyDataSetChanged()
      }
    }
  }
}