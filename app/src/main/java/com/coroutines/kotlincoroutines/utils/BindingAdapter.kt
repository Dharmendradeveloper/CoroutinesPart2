package com.coroutines.kotlincoroutines.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.coroutines.kotlincoroutines.R

class BindingAdapter {
    companion object{
        @BindingAdapter("imgUrl")
        @JvmStatic
        fun setImage(imageView: ImageView,url:String){
            Glide.with(imageView.context).load(url).placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_mood_bad).into(imageView)
        }
        @BindingAdapter("text")
        @JvmStatic
        fun setText(text:TextView,name:String){
            text.setText(name)
        }
    }
}