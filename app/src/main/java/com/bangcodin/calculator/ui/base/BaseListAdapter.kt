/*
 *  Created by Nguyễn Kim Khánh on 10:06, 08/08/2022
 *     dtako.developer@gmail.com
 *     Last modified 10:06, 08/08/2022
 *     Copyright (c) 2022.
 *     All rights reserved.
 */

package com.bangcodin.calculator.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import android.viewbinding.ViewBinding
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.util.concurrent.Executors


abstract class BaseListAdapter<T : Any>(Comparator: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, RecyclerView.ViewHolder>(
        AsyncDifferConfig.Builder(Comparator)
            .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
            .build()
    ) {

    open class DViewHolder(open val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    abstract fun getLayoutResource(viewType: Int): Int

    abstract fun onBindData(holder: RecyclerView.ViewHolder, T: Any, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                getLayoutResource(viewType),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBindData(holder, getItem(position), position)
    }
}