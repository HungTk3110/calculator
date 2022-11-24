/*
 * *
 *  * Created by Nguyen Van Thai on 8/26/22, 11:17 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 8/26/22, 11:17 PM
 *
 */

package com.bangcodin.calculator.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bangcodin.calculator.R
import com.bangcodin.calculator.data.models.Language
import com.bangcodin.calculator.databinding.ItemsRcvLanguageBinding
import com.bangcodin.calculator.ui.viewmodel.LanguageViewModel

class ComparatorLanguage : DiffUtil.ItemCallback<Language>() {
    override fun areItemsTheSame(oldItem: Language, newItem: Language): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Language, newItem: Language): Boolean {
        return oldItem.countryCode == newItem.countryCode
    }

}

class LanguageAdapter(
    private val viewModel: LanguageViewModel,
    private val lifecycleOwner: LifecycleOwner
) : ListAdapter<Language, LanguageAdapter.LanguageVH>(ComparatorLanguage()) {

    class LanguageVH(val binding: ItemsRcvLanguageBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        lateinit var callback: Callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageVH {
        return LanguageVH(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.items_rcv_language,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LanguageVH, position: Int) {
        val alpha = AlphaAnimation(0f,1f)
        alpha.duration = 300
        alpha.fillAfter = true
        holder.binding.root.animation = alpha
        holder.binding.language = getItem(position)
        viewModel.currentLanguage.observe(lifecycleOwner){
            holder.binding.currentLanguage = it
        }

        holder.binding.root.setOnClickListener {
            callback.onLanguageChange(getItem(position))
            alpha.startNow()
        }
        holder.binding.executePendingBindings()
    }
}

interface Callback {
    fun onLanguageChange(language: Language)
}


