package java.com.staggeredgrid.feature.PhotoGallery

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import java.com.staggeredgrid.model.PhotoData

object PhotoItemBinder {

  @JvmStatic
  @BindingAdapter("items")
  fun setSearchList(view: RecyclerView, list: List<PhotoData>) {
    //TODO update as adapter update
  }
}