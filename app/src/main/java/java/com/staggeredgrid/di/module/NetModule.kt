package java.com.staggeredgrid.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.com.staggeredgrid.R
import java.com.staggeredgrid.network.ApiAccess
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [AppModule::class])
class NetModule {

  @Module
  companion object {

    @JvmStatic
    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
      HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @JvmStatic
    @Singleton
    @Provides
    fun provideOkHttp(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
      OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .build()

    @Singleton
    @JvmStatic
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, context: Context): Retrofit =
      Retrofit.Builder()
        .baseUrl(context.getString(R.string.base_url))
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()

    @JvmStatic
    @Singleton
    @Provides
    fun provideApiAccess(retrofit: Retrofit): ApiAccess =
      retrofit.create(ApiAccess::class.java)
  }
}
