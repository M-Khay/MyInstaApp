package com.yourself.myinstaapp.ui.rv

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yourself.myinstaapp.databinding.UserPostListItemBinding
import com.yourself.myinstaapp.model.UserPost

class UserPostListAdapter(context: Context) :
    RecyclerView.Adapter<UserPostListViewHolder>() {
    private var userPostList = emptyList<UserPost>()
    private val layoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserPostListViewHolder {
        val userPostListItemBinding = UserPostListItemBinding.inflate(layoutInflater, parent, false)
        return UserPostListViewHolder(userPostListItemBinding.root, userPostListItemBinding)
    }

    override fun getItemCount(): Int {
        return userPostList.size
    }

    override fun onBindViewHolder(holder: UserPostListViewHolder, position: Int) {
        val userPost = userPostList[position]
        holder.setData(userPost)

        //simple mechanisam to be implemented to keep fetching more images once user reaches end of list.
//        if (position == userPostList.size - 1)
//        {
//           fetchMoreImages.fetchMoreImages()
//        }
    }

    fun setUserPostList(userPostList: List<UserPost>) {
        this.userPostList = userPostList
        notifyDataSetChanged()
    }

    interface FetchMoreImages {
        fun fetchMoreImages()
    }
}
