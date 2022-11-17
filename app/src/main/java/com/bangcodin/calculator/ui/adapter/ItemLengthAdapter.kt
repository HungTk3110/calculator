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
import com.bangcodin.calculator.models.ItemLength

class ItemLengthAdapter : ListAdapter<ItemLength, ItemLengthAdapter.ItemViewHDLength>(DiffCallBackItemLength()){
    var listener: OnClickEventLength? = null
    class ItemViewHDLength(private val view: View) : RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.tv_length)
        val imgCheck: ImageView = view.findViewById(R.id.img_checkLenght)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHDLength {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_km, parent,false)
        return ItemViewHDLength(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHDLength, position: Int) {
        val item = getItem(position)
        holder.textView.setText(item.stringResourceId)
        holder.itemView.setOnClickListener{
            listener?.onClick(position)
        }
        if (item.isCheckStatusLength){
            holder.imgCheck.visibility = View.VISIBLE
        }else{
            holder.imgCheck.visibility = View.GONE
        }
    }

    interface OnClickEventLength {
        fun onClick(position: Int)
    }

}

class DiffCallBackItemLength : DiffUtil.ItemCallback<ItemLength>(){
    override fun areItemsTheSame(oldItem: ItemLength, newItem: ItemLength): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ItemLength, newItem: ItemLength): Boolean {
        return oldItem == newItem
    }
}

