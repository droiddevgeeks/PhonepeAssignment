package com.example.phonepeassignment.helper

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.domainmodule.common.IFailure
import com.example.phonepeassignment.R

fun ImageView.loadImage(url: String?) {
    Glide.with(this.context)
        .load(url)
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
        .transform(RoundedCorners(24))
        .into(this)
}

fun View.visibility(show: Boolean) {
    if (show) this.visibility = View.VISIBLE
    else this.visibility = View.GONE
}

fun IFailure.showToast(context: Context?) {
    Toast.makeText(context, this.errorModel.errorMsg, Toast.LENGTH_SHORT).show()
}