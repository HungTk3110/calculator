/*
 * Created by PS Solutions on 09/18/2017.
 * Copyright © 2017 Softbank. All rights reserved.
 *
 */

package com.bangcodin.calculator.ui.base

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.bangcodin.calculator.R

fun AppCompatActivity.replaceFragment(@IdRes frameId: Int, fragment: Fragment?,
                                      tag: String, addToBackStack: Boolean, enableAnimation: Boolean) {
    if (addToBackStack) {
        if (enableAnimation) {
            supportFragmentManager.transactWithAnimation({
                fragment?.let {
                    replace(frameId, fragment, tag)
                }
            }, tag)
        }
    }
}



fun AppCompatActivity.addFragmentWithAnimationT6(fromFragment: Fragment? = null, toFragment: Fragment?,
                                                 tag: String, @IdRes frameId: Int) {
    supportFragmentManager.transactWithAnimationT6({
        fromFragment?.let {
            hide(it)
        }
        toFragment?.let {
            add(frameId, toFragment, tag)
        }
    }, tag)
}
private inline fun FragmentManager.transactWithAnimationT6(action: FragmentTransaction.() -> Unit, name: String) {
    beginTransaction().setCustomAnimations(R.anim.enter_from_right_t6, R.anim.exit_to_left,
        R.anim.enter_from_left_t6, R.anim.exit_to_right)
        .apply {
            action()
        }.addToBackStack(name).commitAllowingStateLoss()
}
private inline fun FragmentManager.transactWithAnimation(action: FragmentTransaction.() -> Unit, name: String) {
    beginTransaction().setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left,
        R.anim.enter_from_left, R.anim.exit_to_right).apply {
        action()
    }.addToBackStack(name).commitAllowingStateLoss()
}




