/*
 * *
 *  * Created by Trịnh Khắc Hùng on 8/25/22, 3:21 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 8/25/22, 3:20 PM
 *
 */

package com.bangcodin.calculator.ui.fragment


import android.app.AlertDialog
import android.content.DialogInterface
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.R
import com.bangcodin.calculator.databinding.FragmentHistoryBinding
import com.bangcodin.calculator.data.models.History
import com.bangcodin.calculator.ui.adapter.HistoryAdapter
import com.bangcodin.calculator.ui.base.BaseFragment
import com.bangcodin.calculator.ui.viewmodel.HistoryViewModel
import javax.inject.Inject


class HistoryFragment : BaseFragment(), HistoryAdapter.RowClickListener {

    @Inject
    lateinit var viewmodelFactory: ViewModelProvider.Factory
    private lateinit var historyViewModel: HistoryViewModel
    private lateinit var binding: FragmentHistoryBinding
    private val historyAdapter = HistoryAdapter()

    override fun initView(viewBinding: ViewBinding) {
        this.binding = viewBinding as FragmentHistoryBinding
        initViewModel()
        setRcvHistory(historyViewModel.listData)
        binding.btnDeleteAllHistory.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            with(builder) {
                setTitle("Confirm delete all History")
                setMessage("Are you sure")
                setPositiveButton("OK", DialogInterface.OnClickListener { builder, which ->
                    historyViewModel.deleteHistory()
                    historyAdapter.notifyDataSetChanged()
                })
                setNegativeButton("No", null)
                    .show()
            }
            historyAdapter.notifyDataSetChanged()
        }
    }

    fun initViewModel() {
        historyViewModel =
            ViewModelProvider(this, viewmodelFactory)[HistoryViewModel::class.java]
    }

    override fun getLayout() = R.layout.fragment_history

    private fun setRcvHistory(list: MutableList<History>) {

        historyAdapter.setListData(list)
        historyAdapter.notifyDataSetChanged()
        binding.rcvHistory.adapter = historyAdapter
        binding.rcvHistory.layoutManager = LinearLayoutManager(activity)
    }

    override fun onItemClickListener(history: History) {
        TODO("Not yet implemented")
    }

}
