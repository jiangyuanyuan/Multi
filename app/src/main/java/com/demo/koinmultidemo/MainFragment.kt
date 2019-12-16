package com.demo.koinmultidemo



import android.view.MenuItem
import com.alibaba.android.arouter.facade.annotation.Route


import me.yokeyword.fragmentation.SupportFragment
import androidx.viewpager.widget.ViewPager
import com.demo.base.helper.ViewPagerAdapter
import com.demo.koinmultidemo.common.HomeBaseFragment
import com.demo.router.JumpUtils
import com.demo.router.RouterPath
import kotlinx.android.synthetic.main.fragment_main.*


@Route(path = RouterPath.Home.PATH_MAIN)
class MainFragment : HomeBaseFragment() {
    private val mList = mutableListOf<SupportFragment>()
    private var menuItem: MenuItem? = null



    override fun initView() {
        mNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_home -> {
                    mMainViewPager.currentItem = 0
                }
                R.id.item_quotation -> {
                    mMainViewPager.currentItem = 1
                }

            }
            false
        }
        mMainViewPager?.currentItem= 0
        mMainViewPager?.offscreenPageLimit = 2
        mMainViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }
            override fun onPageSelected(position: Int) {
                if (menuItem != null) {
                    menuItem?.isChecked = false
                } else {
                    mNavigation?.menu?.getItem(0)?.isChecked = false
                }
                menuItem = mNavigation.menu.getItem(position)
                menuItem?.isChecked = true
            }
            override fun onPageScrollStateChanged(state: Int) {}
        })

        mList.add(JumpUtils.BuildFragment(RouterPath.Order.PATH_ORDER))
        mList.add(JumpUtils.BuildFragment(RouterPath.User.PATH_LOGIN))
        mMainViewPager.adapter = ViewPagerAdapter(childFragmentManager, mList)

    }

    override fun initData() {
        //网络请求数据
    }

    override fun initEvent() {
        //事件监听

    }

    override fun getLayoutId() = R.layout.fragment_main


}