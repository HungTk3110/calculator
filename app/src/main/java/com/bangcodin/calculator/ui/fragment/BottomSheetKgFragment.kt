/*
 * *
 *  * Created by Nguyen Van Thai on 9/18/22, 5:56 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/18/22, 5:56 PM
 *
 */

package com.bangcodin.calculator.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangcodin.calculator.data.Datasource
import com.bangcodin.calculator.databinding.FragmentBottomSheetWeightBinding
import com.bangcodin.calculator.ui.adapter.ItemKgAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetKgFragment : BottomSheetDialogFragment(), ItemKgAdapter.OnClickEventKg {
    private lateinit var binding: FragmentBottomSheetWeightBinding
    private val myData = Datasource().loadItemKg()
    private val itemKgAdapter = ItemKgAdapter()
    var optionConverterKg : OptionConverterKg? = null
    override fun onClick(position: Int) {
        itemKgAdapter.currentList.forEach{ item ->
            item.isCheckStatusKg = false
        }
        itemKgAdapter.currentList[position].isCheckStatusKg = true
        itemKgAdapter.notifyDataSetChanged()
        optionConverterKg?.selectedOptionInput(position)
        optionConverterKg?.selectedOptionResult(position)
        dismiss()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemKgAdapter.listener = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetWeightBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false)
        binding.rcvKg.layoutManager = layoutManager
        itemKgAdapter.submitList(myData)
        binding.rcvKg.adapter = itemKgAdapter
    }


    interface OptionConverterKg {
        fun selectedOptionInput(position: Int)
        fun selectedOptionResult(position: Int)
    }






}