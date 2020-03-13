package com.yourself.myinstaapp.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName

data class UserPost(var likes: Int, var user: String,@SerializedName("webformatURL") var imageURL: String,var userImageURL :String) {
    companion object {
        @JvmStatic
        @BindingAdapter("imageURL")
        fun loadImage(imageView: ImageView, imageURL: String) {
            Glide.with(imageView.context)
                .setDefaultRequestOptions(
                    RequestOptions()
                        .fitCenter()
                )
                .load(imageURL)
                .into(imageView)
        }
    }

}
