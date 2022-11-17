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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.R
import com.bangcodin.calculator.databinding.FragmentHistoryBinding
import com.bangcodin.calculator.ui.adapter.HistoryAdapter
import com.bangcodin.calculator.ui.base.BaseFragment
import com.bangcodin.calculator.ui.database.HistoryDatabase
import com.bangcodin.calculator.ui.model.History
import kotlin.concurrent.thread


class HistoryFragment : BaseFragment(), HistoryAdapter.RowClickListener {

    private lateinit var binding: FragmentHistoryBinding
    private val historyAdapter = HistoryAdapter()
    private lateinit var historyapp : HistoryDatabase
    private val listData:ArrayList<History> = ArrayList()
//    private lateinit var myDataList: MutableList<History>

    override fun initView(viewBinding: ViewBinding) {
        this.binding = viewBinding as FragmentHistoryBinding

        historyapp = HistoryDatabase.getDatabase(requireContext())
        thread {
            listData.clear()
            listData.addAll(historyapp.historyDao().getAllHistory())
        }

        setRcvHistory(listData)
        binding.btnDeleteAllHistory.setOnClickListener{
            val builder = AlertDialog.Builder(requireContext())
            with(builder){
                setTitle("Confirm delete all History")
                setMessage("Are you sure")
                setPositiveButton("OK" , DialogInterface.OnClickListener{builder , which ->
                    thread {
                        historyapp.historyDao().deleteAllHistory()
                        listData.clear()
                    }
                    listData.clear()
                    historyAdapter.notifyDataSetChanged()
                })
                setNegativeButton("No" , null)
                    .show()
            }
            historyAdapter.notifyDataSetChanged()
        }
    }

    override fun getLayout() = R.layout.fragment_history

    private fun setRcvHistory(list : ArrayList<History>){

        historyAdapter.setListData(list)
        historyAdapter.notifyDataSetChanged()
        binding.rcvHistory.adapter = historyAdapter
        binding.rcvHistory.layoutManager = LinearLayoutManager(activity)
        }

    override fun onItemClickListener(history: History) {
        TODO("Not yet implemented")
    }


}
