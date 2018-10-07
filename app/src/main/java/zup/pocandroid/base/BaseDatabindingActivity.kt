package zup.pocandroid.base

import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle

abstract class BaseDatabindingActivity<DB : ViewDataBinding, VM : ViewModel> : BaseActivity<VM>() {

    protected lateinit var mDataBinding: DB
    override val shouldSetContentView: Boolean get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        if (getLayoutId() != null) {
            mDataBinding = DataBindingUtil.setContentView(this, getLayoutId()!!)
        }

        super.onCreate(savedInstanceState)
    }
}
