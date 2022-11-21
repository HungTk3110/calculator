/*
 * *
 *  * Created by Nguyen Van Thai on 9/7/22, 12:28 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/7/22, 12:28 PM
 *
 */

package com.bangcodin.calculator.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangcodin.calculator.data.Datasource
import com.bangcodin.calculator.databinding.FragmentLanguageBinding
import com.bangcodin.calculator.models.ItemLanguage

import com.bangcodin.calculator.ui.adapter.SettingLanguageAdapter
import com.bangcodin.calculator.ui.viewmodel.LanguageViewModel
import com.bangcodin.calculator.utils.SharePreference
import com.bangcodin.calculator.utils.setAppLocale


class LanguageFragment : Fragment(){

    private lateinit var binding: FragmentLanguageBinding
    private lateinit var languageViewModel: LanguageViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        checkCurrentLanguage()
        binding = FragmentLanguageBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setRcvLanguage()
        onBackStack()
    }
    private fun setRcvLanguage(){
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rcvLanguageSetting.layoutManager = layoutManager
        val dataSet = Datasource().loadItemLanguage()
        binding.rcvLanguageSetting.adapter = SettingLanguageAdapter(dataSet , onItemClicked)

    }
    private fun onBackStack(){
        binding.btnOke.setOnClickListener{
            activity?.onBackPressed()
        }
    }

    private fun checkCurrentLanguage(){
        val currentLanguage =
            SharePreference.getStringPref(requireContext(), SharePreference.CURRENT_LANGUAGE)
        if(currentLanguage.isNullOrEmpty()){
            setAppLocale(requireContext() ,"en")
        }else{
            setAppLocale(requireContext(),currentLanguage)
        }
    }

    private val onItemClicked : (ItemLanguage) -> Unit = {

    }

}