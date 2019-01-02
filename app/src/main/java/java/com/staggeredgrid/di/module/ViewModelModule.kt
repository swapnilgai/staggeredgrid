package java.com.staggeredgrid.di.module


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import java.com.staggeredgrid.di.ViewModelFactory
import java.com.staggeredgrid.di.ViewModelKey
import java.com.staggeredgrid.feature.photoGallery.PhotoGalleryViewModel


@Module
abstract class ViewModelModule {

  @IntoMap
  @ViewModelKey(PhotoGalleryViewModel::class)
  @Binds
  abstract fun bindPhotoGalleryViewModel(photoGalleryViewModel: PhotoGalleryViewModel): ViewModel

  @Binds
  abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}