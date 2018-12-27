package java.com.staggeredgrid.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class SpacesItemDecoration(private val horizontalSpace: Int, private val verticalSpace: Int) :
  RecyclerView.ItemDecoration() {

  override fun getItemOffsets(
    outRect: Rect,
    view: View,
    parent: RecyclerView,
    state: RecyclerView.State
  ) {
    outRect.left = horizontalSpace
    outRect.right = horizontalSpace
    outRect.bottom = verticalSpace

    // Add top margin only for the first item to avoid double space between items
    if (parent.getChildAdapterPosition(view) == 0)
      outRect.top = verticalSpace
  }
}