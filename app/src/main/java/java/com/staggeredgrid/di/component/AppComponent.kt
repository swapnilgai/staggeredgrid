package java.com.zomato.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import java.com.staggeredgrid.di.module.ActivityBindingModule
import java.com.staggeredgrid.di.module.AppModule
import java.com.staggeredgrid.di.module.NetModule
import java.com.staggeredgrid.di.module.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ActivityBindingModule::class, ViewModelModule::class, AndroidSupportInjectionModule::class, NetModule::class])
interface AppComponent : AndroidInjector<java.com.staggeredgrid.Application> {
  fun injectApp(application: java.com.staggeredgrid.Application)

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun app(application: java.com.staggeredgrid.Application): Builder

    fun build(): AppComponent
  }
}