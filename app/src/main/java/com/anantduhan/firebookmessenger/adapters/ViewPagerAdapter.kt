package com.anantduhan.firebookmessenger.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.anantduhan.firebookmessenger.fragments.ChatsFragment
import com.anantduhan.firebookmessenger.fragments.UsersFragment

class ViewPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment = when(position) {
        0 -> ChatsFragment()
        else -> UsersFragment()
    }
}