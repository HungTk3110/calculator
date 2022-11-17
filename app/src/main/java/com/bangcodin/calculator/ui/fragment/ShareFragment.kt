/*
 * *
 *  * Created by Nguyen Van Thai on 9/7/22, 2:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/7/22, 2:55 PM
 *
 */

package com.bangcodin.calculator.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bangcodin.calculator.data.Datasource
import com.bangcodin.calculator.databinding.FragmentShareApplicationDialogBinding
import com.bangcodin.calculator.ui.adapter.ShareAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ShareFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentShareApplicationDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShareApplicationDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setRcvShare()
    }

    private fun setRcvShare(){
        val layoutManager = GridLayoutManager(context,4, RecyclerView.VERTICAL,false)
        binding.rcvShare.layoutManager = layoutManager
        val dataShare = Datasource().loadItemShare()
        binding.rcvShare.adapter = ShareAdapter(dataShare)
    }
}