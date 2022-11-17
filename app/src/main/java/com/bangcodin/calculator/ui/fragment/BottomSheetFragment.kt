/*
 * *
 *  * Created by Nguyen Van Thai on 8/30/22, 9:27 AM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 8/30/22, 9:27 AM
 *
 */

package com.bangcodin.calculator.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangcodin.calculator.R
import com.bangcodin.calculator.data.Datasource
import com.bangcodin.calculator.databinding.FragmentBottomSheetNationalBinding
import com.bangcodin.calculator.ui.adapter.ItemBottomSheetAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetFragment : BottomSheetDialogFragment(), ItemBottomSheetAdapter.OnClickEvent {
    private lateinit var binding: FragmentBottomSheetNationalBinding
    private val myDataset = Datasource().loadItem()
    private val itemBottomSheetAdapter = ItemBottomSheetAdapter()
    private val currencyConverter = CurrencyConversionFragment()
    private val lengthConverter = LengthFragment()
    private val weightConverter = WeightFragment()
    private val temperatureConverter = TemperatureFragment()
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
        binding = FragmentBottomSheetNationalBinding.inflate(inflater,container,false)
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
        optionConverter?.selectedOption(position)
        when (position) {
            0 -> {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.frame_layout, currencyConverter)
                    ?.commit()
                dismiss()
            }
            1 -> {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.frame_layout,lengthConverter)
                    ?.commit()
                dismiss()
            }
            2 -> {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.frame_layout,weightConverter)
                    ?.commit()
                dismiss()
            }
            3 -> {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.frame_layout,temperatureConverter)
                    ?.commit()
                dismiss()
            }
        }
    }

    interface OptionConverter {
        fun selectedOption(position: Int)
    }



}