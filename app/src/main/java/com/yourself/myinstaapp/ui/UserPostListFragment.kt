package com.yourself.myinstaapp.ui

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.yourself.myinstaapp.R
import com.yourself.myinstaapp.di.ComponentInjector
import com.yourself.myinstaapp.model.*
import com.yourself.myinstaapp.ui.rv.UserPostListAdapter
import kotlinx.android.synthetic.main.user_post_list_fragment.*

class UserPostListFragment : Fragment(),UserPostListAdapter.FetchMoreImages {
    lateinit var adapter : UserPostListAdapter

    companion object {
        val TAG = UserPostListFragment::class.java.name
        fun newInstance() = UserPostListFragment()
    }

    private lateinit var viewModel: UserPostListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_post_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserPostListViewModel::class.java).also {
            ComponentInjector.component.inject(it)
        }
        val activity = activity as Context
        viewModel.stateLiveData.observe(this.viewLifecycleOwner, userPostListObeserver)
        viewModel.getUserPostList("photo",50,true)
        adapter = UserPostListAdapter(activity)
        user_post_list_rv.adapter= adapter
        user_post_list_rv.layoutManager = LinearLayoutManager(activity)


    }

    private val userPostListObeserver = Observer<UserPostListState> { state ->
        state?.let {
            when (state) {
                is DefaultState -> {
                    adapter.setUserPostList(state.data)
                }
                is LoadingState -> {

                }
                is ErrorState -> {

                }
            }
        }

    }

    interface onPostSelected {
        fun onPostSelected(userPost: UserPost)
    }

    override fun fetchMoreImages() {
//        viewModel.getUserPostList("photo",20,true)
    }

}

