package java.com.staggeredgrid.di.module

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import java.com.staggeredgrid.Application
import javax.inject.Singleton

@Module
class AppModule {

  @Provides
  @Singleton
  fun providesPreferenceUtils(application: Application): SharedPreferences =
    PreferenceManager.getDefaultSharedPreferences(application)

  @Provides
  @Singleton
  fun providesContext(application: Application): Context = application.applicationContext
}
