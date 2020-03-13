package com.yourself.myinstaapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.yourself.myinstaapp.R
import com.yourself.myinstaapp.di.ComponentInjector
import com.yourself.myinstaapp.model.UserPost
import com.yourself.myinstaapp.repository.UserPostListRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity(),UserPostListFragment.onPostSelected {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction().add(
                R.id.container,
                UserPostListFragment.newInstance(),
                UserPostListFragment.TAG
            ).commitNow()

    }

    override fun onPostSelected(userPost: UserPost) {
        TODO("not implemented")
        // show framgent that shows user name and user picture that are posted by this
    }
}
