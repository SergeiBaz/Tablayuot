package com.example.tablayuot.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewAdapter(fragActiv: FragmentActivity, private val listFragment: List<Fragment>): FragmentStateAdapter(fragActiv) {
    override fun getItemCount(): Int {
        return listFragment.size
    }

    override fun createFragment(position: Int): Fragment {
        return listFragment[position]
    }
}