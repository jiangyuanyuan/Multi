package com.demo.base.common


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.launcher.ARouter
import com.demo.base.data.ApiViewModel
import me.yokeyword.fragmentation.SupportFragment
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*


abstract class BaseFragment : SupportFragment() {
    val mBaseApiViewModel: ApiViewModel by viewModel()//当很多个模块   用到同一个接口时  可以将接口定义在base中
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
//        initLocaleLanguage()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
        initEvent()
    }

    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun initData()

    abstract fun initEvent()

    override fun onDestroy() {
        super.onDestroy()
        hideSoftInput()
    }

//    private fun initLocaleLanguage() {
//        val resources = this.resources
//        val configuration = resources.configuration
//        configuration.locale = Hawk.get(LANGUAGE, Locale.getDefault())
//        resources.updateConfiguration(configuration, resources.displayMetrics)
//    }

}