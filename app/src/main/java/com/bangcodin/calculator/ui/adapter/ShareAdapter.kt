/*
 * *
 *  * Created by Nguyen Van Thai on 9/7/22, 3:00 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/7/22, 3:00 PM
 *
 */

package com.bangcodin.calculator.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bangcodin.calculator.R
import com.bangcodin.calculator.data.models.ItemShare

class ShareAdapter(
    private val dataShare: List<ItemShare>
) : RecyclerView.Adapter<ShareAdapter.ItemViewHd>(){
    class ItemViewHd(private val view: View) : RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.tv_icon_share)
        val imageView: ImageView = view.findViewById(R.id.img_icon_share)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHd {
        val layoutShare = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_rcv_share_app, parent , false)
        return ItemViewHd(layoutShare)
    }

    override fun onBindViewHolder(holder: ItemViewHd, position: Int) {
        val itemShare = dataShare[position]
        holder.textView.setText(itemShare.stringShare)
        holder.imageView.setImageResource(itemShare.imageShare)
    }

    override fun getItemCount(): Int {
        if(dataShare.isNotEmpty()){
            return dataShare.size
        }
        return -1
    }
}