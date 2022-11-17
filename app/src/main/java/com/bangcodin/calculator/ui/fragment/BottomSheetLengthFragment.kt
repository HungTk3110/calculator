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
import com.bangcodin.calculator.databinding.FragmentBottomSheetLengthBinding
import com.bangcodin.calculator.ui.adapter.ItemLengthAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetLengthFragment : BottomSheetDialogFragment(), ItemLengthAdapter.OnClickEventLength {
    private lateinit var binding: FragmentBottomSheetLengthBinding
    private val myDataSet = Datasource().loadItemKm()
    private val itemKmAdapter = ItemLengthAdapter()
    var optionConverterKm : OptionConverterKm? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemKmAdapter.listener = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetLengthBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false)
        binding.rcvLength.layoutManager = layoutManager
        itemKmAdapter.submitList(myDataSet)
        binding.rcvLength.adapter = itemKmAdapter
    }
    override fun onClick(position: Int) {
        itemKmAdapter.currentList.forEach{item ->
            item.isCheckStatusLength = false
        }
        itemKmAdapter.currentList[position].isCheckStatusLength = true
        itemKmAdapter.notifyDataSetChanged()
        optionConverterKm?.selectedOptionInPut(position)
        optionConverterKm?.selectedOptionResult(position)
        dismiss()
    }

    interface OptionConverterKm {
        fun selectedOptionInPut(position: Int)
        fun selectedOptionResult(position: Int)
    }
}