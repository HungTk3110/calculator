/*
 * *
 *  * Created by Trinh Khac Hung on 15:24, 23/08/2022
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 15:18, 23/08/2022
 *
 */

package com.bangcodin.calculator.ui.activity

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.R
import com.bangcodin.calculator.databinding.ActivityMainBinding
import com.bangcodin.calculator.ui.base.BaseActivity
import com.bangcodin.calculator.ui.fragment.CalculatorFragment
import com.bangcodin.calculator.ui.fragment.ConverterFragment
import com.bangcodin.calculator.ui.fragment.HistoryFragment
import com.bangcodin.calculator.ui.fragment.SettingFragment

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun setLayout(): ViewBinding =
        ActivityMainBinding.inflate(layoutInflater) as ViewBinding



    override fun initView(binding: ViewBinding) {
        this.binding = binding as ActivityMainBinding
        replaceFragment(CalculatorFragment())
        this.binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.calculatorFragment -> replaceFragment(CalculatorFragment())
                R.id.settingFragment -> replaceFragment(SettingFragment())
                R.id.historyFragment -> replaceFragment(HistoryFragment())
                R.id.conversionFragment -> replaceFragment(ConverterFragment())
                else ->{}
            }
            true
        }


    }


    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frame_layout, fragment)
        fragmentTransition.commit()
    }
}