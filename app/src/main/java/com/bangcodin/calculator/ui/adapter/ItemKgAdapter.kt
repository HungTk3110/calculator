/*
 * *
 *  * Created by Nguyen Van Thai on 9/18/22, 5:56 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/18/22, 5:56 PM
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
import com.bangcodin.calculator.data.models.ItemKg


class ItemKgAdapter : ListAdapter<ItemKg, ItemKgAdapter.ItemViewHD>(DiffCallBackItemKg()) {
    var listener: OnClickEventKg? = null

    class ItemViewHD(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_title)
        val imgCheck: ImageView = view.findViewById(R.id.img_check1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHD {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_kg, parent, false)
        return ItemViewHD(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHD, position: Int) {
        val item = getItem(position)
        holder.textView.setText(item.stringResourceId)
        holder.itemView.setOnClickListener {
            listener?.onClick(position)
        }
        if (item.isCheckStatusKg) {
            holder.imgCheck.visibility = View.VISIBLE
        } else {
            holder.imgCheck.visibility = View.GONE
        }
    }

    interface OnClickEventKg {
        fun onClick(position: Int)
    }

}

class DiffCallBackItemKg : DiffUtil.ItemCallback<ItemKg>() {
    override fun areItemsTheSame(oldItem: ItemKg, newItem: ItemKg): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ItemKg, newItem: ItemKg): Boolean {
        return oldItem == newItem
    }
}