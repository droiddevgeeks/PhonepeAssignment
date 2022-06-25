package com.example.phonepeassignment.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(FrameLayout(this))
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, MovieFragment.getInstance())
            .commit()
    }
}