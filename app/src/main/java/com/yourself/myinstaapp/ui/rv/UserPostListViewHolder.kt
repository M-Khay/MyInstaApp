package com.yourself.myinstaapp.ui.rv

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yourself.myinstaapp.databinding.UserPostListItemBinding
import com.yourself.myinstaapp.model.UserPost

class UserPostListViewHolder constructor(userPostItemView: View,
                                         private val userPostListItemBinding: UserPostListItemBinding):RecyclerView.ViewHolder( userPostItemView){
    fun setData(userPost:UserPost){
        userPostListItemBinding.userPost = userPost
    }
}