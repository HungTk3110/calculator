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
fun setImageFromResource(imageView: ImageView, src: Int): Int? {
    imageView.setImageResource(src)
}