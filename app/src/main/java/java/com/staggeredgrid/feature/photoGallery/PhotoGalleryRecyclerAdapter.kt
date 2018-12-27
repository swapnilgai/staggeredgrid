package java.com.staggeredgrid.feature.photoGallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.com.staggeredgrid.R
import java.com.staggeredgrid.databinding.PhotoItemDb
import java.com.staggeredgrid.model.PhotoData
import java.com.staggeredgrid.util.ArrayRecyclerAdapter

class PhotoGalleryRecyclerAdapter(private val galleryItemNavigator: GalleryItemNavigator) :
  ArrayRecyclerAdapter<PhotoData, ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    val viewBinding = DataBindingUtil.inflate<PhotoItemDb>(
      LayoutInflater.from(parent.context),
      R.layout.photo_item,
      parent,
      false
    )
    return DataResultHolder(viewBinding)
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    if (holder is DataResultHolder) {
      val navigator = object : GalleryItemNavigator {
        override fun onClick(photoData: PhotoData) {
          galleryItemNavigator.onClick(photoData)
        }
      }
      holder.binding.item = getItem(position)
      holder.binding.navigator = navigator
    }
  }

  override fun getItemViewType(position: Int): Int {
    return position
  }

  inner class DataResultHolder(val binding: PhotoItemDb) :
    RecyclerView.ViewHolder(binding.root)
}