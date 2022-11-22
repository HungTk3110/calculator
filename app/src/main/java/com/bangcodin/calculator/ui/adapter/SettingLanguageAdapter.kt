/*
 * *
 *  * Created by Nguyen Van Thai on 9/7/22, 1:23 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 9/7/22, 1:23 PM
 *
 */

package com.bangcodin.calculator.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bangcodin.calculator.R
import com.bangcodin.calculator.data.models.ItemLanguage

class SettingLanguageAdapter(
    private val dataLanguage: List<ItemLanguage>,
    private val onItemClicked: (ItemLanguage) -> Unit,
) : RecyclerView.Adapter<SettingLanguageAdapter.ItemViewHolder>() {

    var temp = 0

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView: TextView = view.findViewById(R.id.tv_language)
        private val imageView: ImageView = view.findViewById(R.id.img_language)
        val layout: CardView = view.findViewById(R.id.layout)
        val check: ImageView = view.findViewById(R.id.img_check)

        fun onBind(itemLanguage: ItemLanguage) {
            textView.setText(itemLanguage.stringLanguage)
            imageView.setImageResource(itemLanguage.imageLanguage)
//            check.setOnClickListener {onItemClicked(itemLanguage)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutLanguage = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_rcv_language, parent, false)
        return ItemViewHolder(layoutLanguage)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val lang = dataLanguage[position]
        holder.onBind(dataLanguage[position])
        holder.layout.setOnClickListener {
            for (item in dataLanguage) {
                if (lang.id == item.id && lang.id == temp) {
                    holder.check.visibility = View.VISIBLE
                }else{
                    Log.d("zzz", "test ")
                }
            }
        }
//        holder.check.visibility = View.VISIBLE
    }

    override fun getItemCount(): Int {
        if (dataLanguage.isNotEmpty()) {
            return dataLanguage.size
        }
        return -1
    }

}