package com.anantduhan.firebookmessenger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.anantduhan.firebookmessenger.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    val pager by lazy {
        findViewById<ViewPager2>(R.id.viewPager)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        pager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(findViewById(R.id.tabs), pager,
            TabLayoutMediator.TabConfigurationStrategy { tab, pos ->
                when(pos) {
                    0 -> tab.text = "Chats"
                    1 -> tab.text = "Users"
                }
        }).attach()
    }
}