/*
 * *
 *  * Created by Trinh Khac Hung on 11/30/22, 2:35 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 11/30/22, 2:35 PM
 *
 */

package com.bangcodin.calculator.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bangcodin.calculator.ui.fragment.CalculatorFragment
import com.bangcodin.calculator.ui.fragment.ConverterFragment
import com.bangcodin.calculator.ui.fragment.HistoryFragment
import com.bangcodin.calculator.ui.fragment.SettingFragment

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> CalculatorFragment()
            1 -> ConverterFragment()
            2 -> HistoryFragment()
            3 -> SettingFragment()
            else -> HistoryFragment()
        }
    }

}