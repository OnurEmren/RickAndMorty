package com.onuremren.rickandmorty

import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


fun ImageView.downloadFromUrl(url: String?){
    Glide.with(context)
        .load(url)
        .into(this)

}