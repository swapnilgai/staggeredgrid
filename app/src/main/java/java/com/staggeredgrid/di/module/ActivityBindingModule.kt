package java.com.staggeredgrid.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import java.com.staggeredgrid.MainActivity
import java.com.staggeredgrid.di.scope.ActivityScope

@Module
abstract class ActivityBindingModule {

  @ActivityScope
  @ContributesAndroidInjector
  abstract fun contributeRdpActivity(): MainActivity
}