package java.com.staggeredgrid.feature.photoGallery


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dagger.android.support.AndroidSupportInjection
import java.com.staggeredgrid.databinding.PhotoGalleryDb
import java.com.staggeredgrid.di.ViewModelFactory
import java.com.staggeredgrid.feature.photoDetailPage.DetailActivity
import java.com.staggeredgrid.model.PhotoData
import java.com.staggeredgrid.util.SpacesItemDecoration
import javax.inject.Inject


class PhotoGalleryFragment : Fragment(), GalleryItemNavigator {

  private var photoGalleryViewModel: PhotoGalleryViewModel? = null

  @Inject
  lateinit var viewModelFactory: ViewModelFactory

  override fun onClick(photoData: PhotoData) {
    val intent = Intent(context, DetailActivity::class.java)
    intent.putExtra("EXTRA_SESSION_ID", photoData)
    startActivity(intent)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val binding = PhotoGalleryDb.inflate(inflater, container, false)
    binding.rvMain.addItemDecoration(SpacesItemDecoration(16, 16))
    binding.rvMain.adapter = PhotoGalleryRecyclerAdapter(this)
    binding.rvMain.layoutManager =
        StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    binding.viewModel = photoGalleryViewModel
    binding.swipeRefreshLayout.setOnRefreshListener { photoGalleryViewModel?.getSearchResult() }
    return binding.root
  }

  override fun onAttach(context: Context) {
    AndroidSupportInjection.inject(this)
    photoGalleryViewModel = activity?.let {
      ViewModelProviders.of(it, viewModelFactory)
        .get(PhotoGalleryViewModel::class.java)
    }
    super.onAttach(context)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    photoGalleryViewModel?.getSearchResult()
  }

}
