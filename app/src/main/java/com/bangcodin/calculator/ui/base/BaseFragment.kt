package com.bangcodin.calculator.ui.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.R
import com.bangcodin.calculator.utils.setAppLocale
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {
    private lateinit var binding: ViewBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(layoutInflater, getLayout(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(binding)
    }

    protected abstract fun initView(viewBinding: ViewBinding)

    abstract fun getLayout(): Int

    open fun openActivity(destinationClass: Class<*>?) {
        startActivity(Intent(activity, destinationClass))
    }
    fun pushScreenAsNormalWithT6(
        fragment: Fragment,
        tag: String,
        @IdRes frameId: Int = R.id.frame_layout,
        fromFragment: Fragment? = null
    ) {
        (activity as? AppCompatActivity)?.addFragmentWithAnimationT6(
            fromFragment ?: this,
            fragment,
            tag,
            frameId
        )
    }

}



