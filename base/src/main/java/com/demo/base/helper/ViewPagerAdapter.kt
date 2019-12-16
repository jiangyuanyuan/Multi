package com.demo.base.helper

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

open class ViewPagerAdapter(
    private val fm: FragmentManager,
    private var fragments: List<Fragment> = emptyList(),
    private var titles: List<String> = emptyList()
) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (titles.isEmpty()) null else titles[position]
    }

}