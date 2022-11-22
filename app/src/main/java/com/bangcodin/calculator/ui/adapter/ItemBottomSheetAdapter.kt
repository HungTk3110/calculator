/*
 * *
 *  * Created by Nguyen Van Thai on 8/30/22, 9:35 AM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 8/30/22, 9:35 AM
 *
 */

package com.bangcodin.calculator.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bangcodin.calculator.R
import com.bangcodin.calculator.data.models.ItemBottomSheet


class ItemBottomSheetAdapter: ListAdapter<ItemBottomSheet, ItemBottomSheetAdapter.ItemViewHd>(DiffCallBack()) {
    var listener: OnClickEvent?= null
    class ItemViewHd(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_conversion)
        val imgView: ImageView = view.findViewById(R.id.img_converter)
        val imgViewCheck: ImageView = view.findViewById(R.id.img_check)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHd {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_conversion, parent, false)
        return ItemViewHd(adapterLayout)
    }
    override fun onBindViewHolder(holder: ItemViewHd, position: Int) {
        val item = getItem(position)
        holder.textView.setText(item.stringResourceId)
        holder.imgView.setImageResource(item.imageResourceId)
        holder.itemView.setOnClickListener {
            listener?.onClick(position)
        }
        if (item.isCheckStatus) {
            holder.imgViewCheck.visibility = View.VISIBLE
        } else {
            holder.imgViewCheck.visibility = View.GONE
        }
    }


    interface OnClickEvent {
        fun onClick(position: Int)
    }
}

private class DiffCallBack: DiffUtil.ItemCallback<ItemBottomSheet>() {
    override fun areItemsTheSame(oldItem: ItemBottomSheet, newItem: ItemBottomSheet): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ItemBottomSheet, newItem: ItemBottomSheet): Boolean {
        return oldItem == newItem
    }

}