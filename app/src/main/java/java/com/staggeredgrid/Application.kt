package java.com.staggeredgrid

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

open class Application : Application(), HasActivityInjector {

  @Inject
  lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

  override fun onCreate() {
    super.onCreate()
  }

  override fun activityInjector(): AndroidInjector<Activity> {
    return dispatchingAndroidInjector
  }
}