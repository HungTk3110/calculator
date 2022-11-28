/*
 * *
 *  * Created by Trịnh Khắc Hùng on 8/25/22, 3:21 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 8/25/22, 3:20 PM
 *
 */

package com.bangcodin.calculator.ui.fragment

import android.app.AlertDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.content.DialogInterface
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.view.get
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.bangcodin.calculator.R
import com.bangcodin.calculator.data.models.History
import com.bangcodin.calculator.databinding.FragmentHistoryBinding
import com.bangcodin.calculator.ui.adapter.HistoryAdapter
import com.bangcodin.calculator.ui.base.BaseFragment
import com.bangcodin.calculator.ui.viewmodel.HistoryViewModel
import javax.inject.Inject


class HistoryFragment : BaseFragment() {

    @Inject
    lateinit var viewmodelFactory: ViewModelProvider.Factory
    private lateinit var historyViewModel: HistoryViewModel
    private lateinit var binding: FragmentHistoryBinding
    private var historyAdapter: HistoryAdapter? = null

    override fun initView(viewBinding: ViewBinding) {
        this.binding = viewBinding as FragmentHistoryBinding
        initViewModel()
        setRcvHistory(historyViewModel.listData)
        if (!checkNull()) {
            binding.btnDeleteAllHistory.setOnClickListener {
                val builder = AlertDialog.Builder(requireContext())
                with(builder) {
                    setTitle("Confirm delete all History")
                    setMessage("Are you sure")
                    setNegativeButton("No", null)
                    setPositiveButton("OK", DialogInterface.OnClickListener { builder, which ->
                        historyViewModel.deleteAllHistory()
                        setRcvHistory(historyViewModel.listData)
                        checkNull()
                    })
                        .show()
                }
                historyAdapter?.notifyDataSetChanged()
            }
        }

    }

    private fun initViewModel() {
        historyViewModel =
            ViewModelProvider(this, viewmodelFactory)[HistoryViewModel::class.java]
    }

    override fun getLayout() = R.layout.fragment_history

    private fun setRcvHistory(list: MutableList<History>) {
        historyAdapter = HistoryAdapter(onItemClickListener)
        historyAdapter?.setListData(list)
        historyAdapter?.notifyDataSetChanged()
        binding.rcvHistory.adapter = historyAdapter
        binding.rcvHistory.layoutManager = LinearLayoutManager(activity)
    }

    private val onItemClickListener: (history: History, position: Int) -> Unit =
        { history, position ->
            val popupMenu = PopupMenu(
                context,
                binding.rcvHistory[position].findViewById(R.id.img_ShowMenu)
            )
            popupMenu.inflate(R.menu.history_menu)
            popupMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    when (item?.itemId) {
                        R.id.delete -> {
                            historyViewModel.deleteHistory(history)
                            historyAdapter?.setListData(historyViewModel.listData)
                            checkNull()
                            Toast.makeText(
                                requireContext(),
                                "Delete successful",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                            return true
                        }
                        R.id.copy -> {
                            val clipboardManager =
                                activity?.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                            val clipData = ClipData.newPlainText("text", history.result)
                            clipboardManager.setPrimaryClip(clipData)
                            Toast.makeText(requireContext(), "Copy", Toast.LENGTH_SHORT)
                                .show()
                            return true
                        }
                    }
                    return false
                }
            })
            popupMenu.show()
        }

    private fun checkNull(): Boolean {
        return if (historyViewModel.listData.isEmpty()) {
            binding.rcvHistory.visibility = View.GONE
            binding.cstNull.visibility = View.VISIBLE
            true
        } else {
            binding.rcvHistory.visibility = View.VISIBLE
            binding.cstNull.visibility = View.GONE
            false
        }
    }
}
