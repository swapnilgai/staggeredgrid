package java.com.staggeredgrid.di.module


import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import java.com.staggeredgrid.di.ViewModelFactory


@Module
abstract class ViewModelModule {

  @Binds
  abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}