/*
 * *
 *  * Created by Nguyen Van Thai on 8/26/22, 11:00 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 8/26/22, 11:00 PM
 *
 */

package com.bangcodin.calculator.ui.adapter

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["current_language","label"])
fun setCurrentLanguage(imageButton: ImageView, currentLanguage: String, label: String){
    if (currentLanguage == label){
        imageButton.visibility = View.VISIBLE
    }else{
        imageButton.visibility = View.GONE
    }
}

@BindingAdapter("src")
fun setImageFromResource(imageView: ImageView, src: Int){
    imageView.setImageResource(src)
}