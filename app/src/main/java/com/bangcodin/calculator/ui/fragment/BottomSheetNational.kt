/*
 * *
 *  * Created by Nguyen Van Thai on 9/15/22, 4:47 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/15/22, 4:47 PM
 *
 */

package com.bangcodin.calculator.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangcodin.calculator.R
import com.bangcodin.calculator.data.Datasource
import com.bangcodin.calculator.databinding.FragmentBottomSheetConversionBinding
import com.bangcodin.calculator.ui.adapter.ItemBottomSheetAdapter
import com.bangcodin.calculator.utils.Constants
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetNational : BottomSheetDialogFragment(), ItemBottomSheetAdapter.OnClickEvent {

    private lateinit var binding: FragmentBottomSheetConversionBinding
    private val myDataset = Datasource().loadItemNational()
    private val itemBottomSheetAdapter = ItemBottomSheetAdapter()
    var optionConverter : OptionConverter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemBottomSheetAdapter.listener = this
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetConversionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rcvConversion.layoutManager = layoutManager
        itemBottomSheetAdapter.submitList(myDataset)
        binding.rcvConversion.adapter = itemBottomSheetAdapter
    }

    override fun onClick(position: Int) {
        itemBottomSheetAdapter.currentList.forEach { item ->
            item.isCheckStatus = false
        }
        itemBottomSheetAdapter.currentList[position].isCheckStatus = true
        itemBottomSheetAdapter.notifyDataSetChanged()
        optionConverter?.selectedOptionConverter(position)
        optionConverter?.selectedOptionConverted(position)
        dismiss()
    }

    interface OptionConverter {
        fun selectedOptionConverter(position: Int)
        fun selectedOptionConverted(position: Int)
    }
}