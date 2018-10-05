package zup.pocandroid

import android.os.Bundle
import android.support.annotation.LayoutRes
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity(){

    @LayoutRes
    protected abstract fun getLayout(): Int?
    protected abstract fun initialize(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (getLayout() != null) {
            setContentView(getLayout()!!)
        }

        initialize(savedInstanceState)
    }

}