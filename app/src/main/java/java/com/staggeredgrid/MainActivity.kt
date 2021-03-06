package java.com.staggeredgrid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


open class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

  @Inject
  lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    AndroidInjection.inject(this)
  }

  override fun supportFragmentInjector(): AndroidInjector<Fragment> {
    return supportFragmentInjector
  }
}