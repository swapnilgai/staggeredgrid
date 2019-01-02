package java.com.staggeredgrid.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import java.com.staggeredgrid.MainActivity
import java.com.staggeredgrid.di.scope.ActivityScope
import java.com.staggeredgrid.feature.photoGallery.PhotoGalleryActivity
import java.com.staggeredgrid.feature.photoGallery.PhotoGalleryFragment

@Module
abstract class ActivityBindingModule {

  @ActivityScope
  @ContributesAndroidInjector
  abstract fun contributePhotoGalleryActivity(): PhotoGalleryActivity

  @ActivityScope
  @ContributesAndroidInjector
  abstract fun contributePhotoGalleryFragment(): PhotoGalleryFragment

  @ActivityScope
  @ContributesAndroidInjector
  abstract fun contributeRdpActivity(): MainActivity
}