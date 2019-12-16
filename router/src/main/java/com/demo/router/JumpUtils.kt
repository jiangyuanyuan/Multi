package com.demo.router

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import com.alibaba.android.arouter.launcher.ARouter
import me.yokeyword.fragmentation.ISupportFragment
import me.yokeyword.fragmentation.SupportActivity
import me.yokeyword.fragmentation.SupportFragment

import java.io.Serializable
import kotlin.collections.ArrayList

/**
 * Activity Fragment 跳转封装 ARtouer夸模块   单Activity多Fragment库Api跳转
 */
object JumpUtils {

    private const val FIRSTTAG = "FIRSTTAG"

    private const val SECENDTAG = "SECENDTAG"

    private const val THIRDATG = "THIRDTAG"

    private const val FOUR = "FOUR"

    fun <T : Activity> JumpActivity(context: Context, toActivity: Class<T>) {
        val intent = Intent(context, toActivity)
        context.startActivity(intent)
    }

    fun <T : Activity> JumpActivity(context: Context, toActivity: Class<T>, tag: String) {
        val intent = Intent(context, toActivity)
        intent.putExtra(FIRSTTAG, tag)
        context.startActivity(intent)
    }

    fun <T : Activity> JumpActivity(context: Context, toActivity: Class<T>, tag: Int) {
        val intent = Intent(context, toActivity)
        intent.putExtra(FIRSTTAG, tag)
        context.startActivity(intent)

    }

    fun <T : Activity> JumpActivity(context: Context, toActivity: Class<T>, tag: Int, tag2: Int) {
        val intent = Intent(context, toActivity)
        intent.putExtra(FIRSTTAG, tag)
        intent.putExtra(SECENDTAG, tag2)
        context.startActivity(intent)

    }

    fun <T : Activity> JumpActivity(context: Context, toActivity: Class<T>, tag: String, tag2: Int) {
        val intent = Intent(context, toActivity)
        intent.putExtra(FIRSTTAG, tag)
        intent.putExtra(SECENDTAG, tag2)
        context.startActivity(intent)

    }

    fun <T : Activity> JumpActivity(context: Context, toActivity: Class<T>, tag: String, tag2: String) {
        val intent = Intent(context, toActivity)
        intent.putExtra(FIRSTTAG, tag)
        intent.putExtra(SECENDTAG, tag2)
        context.startActivity(intent)

    }

    fun <T : Activity> JumpActivity(context: Context, toActivity: Class<T>, tag: Int, tag2: Int, tag3: Int) {
        val intent = Intent(context, toActivity)
        intent.putExtra(FIRSTTAG, tag)
        intent.putExtra(SECENDTAG, tag2)
        intent.putExtra(THIRDATG, tag3)
        context.startActivity(intent)
    }

    fun <T : Activity> JumpActivityWithParceble(activity: Activity, toActivity: Class<T>, data: Parcelable) {
        val intent = Intent(activity, toActivity)
        intent.putExtra(FIRSTTAG, data)
        activity.startActivity(intent)
    }

    fun <T : Activity> JumpActivityWithParceble(activity: Context, toActivity: Class<T>, data: Parcelable, type: Int) {
        val intent = Intent(activity, toActivity)
        intent.putExtra(FIRSTTAG, data)
        intent.putExtra(SECENDTAG, type)
        activity.startActivity(intent)
    }

    fun <T : Activity> JumpActivityWithData3(context: Context, toActivity: Class<T>, tag: String, tag1: String, tag2: String) {
        val intent = Intent(context, toActivity)
        intent.putExtra(FIRSTTAG, tag)
        intent.putExtra(SECENDTAG, tag1)
        intent.putExtra(THIRDATG, tag2)
        context.startActivity(intent)
    }

    fun <T : Activity> JumpActivityWithSerial(activity: Activity, toActivity: Class<T>, data: Serializable) {
        val intent = Intent(activity, toActivity)
        intent.putExtra(FIRSTTAG, data)
        activity.startActivity(intent)
    }

    fun JumpActivity(path: String) {
        ARouter.getInstance().build(path).navigation()
    }

    fun JumpActivityWithParceble(path: String, data: Parcelable?) {
//    fun JumpActivityWithParceble(path: String, data: Parcelable?) {
        ARouter.getInstance().build(path).withParcelable(FIRSTTAG, data).navigation()
    }

    fun JumpActivity(path: String, tag: String?, tag2: String?) {
        ARouter.getInstance().build(path)
                .withString(FIRSTTAG, tag)
                .withString(SECENDTAG, tag2)
                .navigation()
    }

    fun JumpActivity(path: String, tag: String?, tag2: String?, data: Parcelable?) {
        ARouter.getInstance().build(path)
                .withString(FIRSTTAG, tag)
                .withString(SECENDTAG, tag2)
                .withParcelable(THIRDATG, data)
                .navigation()
    }

    fun JumpActivity(path: String, tag: String?, tag2: String?, tag3: String?) {
        ARouter.getInstance().build(path)
                .withString(FIRSTTAG, tag)
                .withString(SECENDTAG, tag2)
                .withString(FOUR, tag3)
                .navigation()
    }


    fun BuildFragment(path: String): SupportFragment {
        return ARouter.getInstance().build(path).navigation() as SupportFragment
    }

    fun BuildFragment(path: String,tag: String?): SupportFragment {
        return ARouter.getInstance().build(path).withString(FIRSTTAG, tag).navigation() as SupportFragment
    }

    fun BuildFragment(path: String,tag: Int): SupportFragment {
        return ARouter.getInstance().build(path).withInt(FIRSTTAG, tag).navigation() as SupportFragment
    }
    fun JumpFragment(supportActivity: Activity, path: String) {
        (supportActivity as? SupportActivity)?.start(ARouter.getInstance().build(path).navigation() as? SupportFragment, ISupportFragment.SINGLETASK)
    }

    fun JumpFragmentWithPop(supportActivity: Activity, path: String) {
        (supportActivity as? SupportActivity)?.startWithPop(ARouter.getInstance().build(path).navigation() as? SupportFragment)
    }


    fun JumpFragment(supportActivity: Activity, path: String, tag: String?) {
        (supportActivity as? SupportActivity)?.start(ARouter.getInstance().build(path)
                .withString(FIRSTTAG, tag)
                .navigation() as? SupportFragment, ISupportFragment.SINGLETASK)
    }

    fun JumpFragmentWithPop(supportActivity: Activity, path: String, tag: String?) {
        (supportActivity as? SupportActivity)?.startWithPop(ARouter.getInstance().build(path)
                .withString(FIRSTTAG, tag)
                .navigation() as? SupportFragment)
    }

    fun JumpFragment(supportActivity: Activity, path: String, tag: Int) {
        (supportActivity as? SupportActivity)?.start(ARouter.getInstance().build(path)
                .withInt(FIRSTTAG, tag)
                .navigation() as? SupportFragment, ISupportFragment.SINGLETASK)
    }

    fun JumpFragmentWithPop(supportActivity: Activity, path: String, tag: Int) {
        (supportActivity as? SupportActivity)?.startWithPop(ARouter.getInstance().build(path)
                .withInt(FIRSTTAG, tag)
                .navigation() as? SupportFragment)
    }

    fun JumpFragment(supportActivity: Activity, path: String, tag: Int, tag2: Int) {
        (supportActivity as? SupportActivity)?.start(ARouter.getInstance().build(path)
                .withInt(FIRSTTAG, tag)
                .withInt(SECENDTAG, tag2)
                .navigation() as? SupportFragment, ISupportFragment.SINGLETASK)
    }

    fun JumpFragmentWithPop(supportActivity: Activity, path: String, tag: Int, tag2: Int) {
        (supportActivity as? SupportActivity)?.startWithPop(ARouter.getInstance().build(path)
                .withInt(FIRSTTAG, tag)
                .withInt(SECENDTAG, tag2)
                .navigation() as? SupportFragment)
    }


    fun JumpFragment(supportActivity: Activity, path: String?, tag: String?, tag2: String?) {
        (supportActivity as? SupportActivity)?.start(ARouter.getInstance().build(path)
                .withString(FIRSTTAG, tag?:"")
                .withString(SECENDTAG, tag2?:"")
                .navigation() as? SupportFragment, ISupportFragment.SINGLETASK)
    }

    fun JumpFragment(supportActivity: Activity, path: String, tag: String?, tag2: Int) {
        (supportActivity as? SupportActivity)?.start(ARouter.getInstance().build(path)
                .withString(FIRSTTAG, tag)
                .withInt(SECENDTAG, tag2)
                .navigation() as? SupportFragment, ISupportFragment.SINGLETASK)
    }

    fun JumpFragmentWithPop(supportActivity: Activity, path: String, tag: String?, tag2: String) {
        (supportActivity as? SupportActivity)?.startWithPop(ARouter.getInstance().build(path)
                .withString(FIRSTTAG, tag)
                .withString(SECENDTAG, tag2)
                .navigation() as? SupportFragment)
    }


    fun JumpFragment(supportActivity: Activity, path: String, tag: Int, tag2: Int, tag3: Int) {
        (supportActivity as? SupportActivity)?.start(ARouter.getInstance().build(path)
                .withInt(FIRSTTAG, tag)
                .withInt(SECENDTAG, tag2)
                .withInt(THIRDATG, tag3)
                .navigation() as? SupportFragment, ISupportFragment.SINGLETASK)
    }

    fun JumpFragment(supportActivity: Activity, path: String, tag: String?, tag2: String?, tag3: String?) {
        (supportActivity as? SupportActivity)?.start(ARouter.getInstance().build(path)
                .withString(FIRSTTAG, tag)
                .withString(SECENDTAG, tag2)
                .withString(THIRDATG, tag3)
                .navigation() as? SupportFragment, ISupportFragment.SINGLETASK)
    }

    fun JumpFragmentWithPop(supportActivity: Activity, path: String, tag: Int, tag2: Int, tag3: Int) {
        (supportActivity as? SupportActivity)?.startWithPop(ARouter.getInstance().build(path)
                .withInt(FIRSTTAG, tag)
                .withInt(SECENDTAG, tag2)
                .withInt(THIRDATG, tag3)
                .navigation() as? SupportFragment)
    }


    fun JumpFragmentWithParceble(supportActivity: Activity, path: String, data: Parcelable?) {
        (supportActivity as? SupportActivity)?.start(ARouter.getInstance().build(path)
                .withParcelable(FIRSTTAG, data)
                .navigation() as? SupportFragment, ISupportFragment.SINGLETASK)
    }

    fun JumpFragmentWithParcebleWithPop(supportActivity: Activity, path: String, data: Parcelable?) {
        (supportActivity as? SupportActivity)?.startWithPop(ARouter.getInstance().build(path)
                .withParcelable(FIRSTTAG, data)
                .navigation() as? SupportFragment)
    }


    fun JumpFragmentWithParcebleWithPop(supportActivity: Activity, path: String, tag: String?, tag2: String?, data: Parcelable?) {
        (supportActivity as? SupportActivity)?.startWithPop(ARouter.getInstance().build(path)
                .withString(FIRSTTAG, tag)
                .withString(SECENDTAG, tag2)
                .withParcelable(THIRDATG, data)
                .navigation() as? SupportFragment)
    }

    fun JumpFragmentWithParceble(supportActivity: Activity, path: String, data: Parcelable?, tag: Int) {
        (supportActivity as? SupportActivity)?.start(ARouter.getInstance().build(path)
                .withParcelable(FIRSTTAG, data)
                .withInt(SECENDTAG, tag)
                .navigation() as? SupportFragment, ISupportFragment.SINGLETASK)
    }

    fun JumpFragmentWithParceble(supportActivity: Activity, path: String, tag: String?, data: Parcelable?) {
        (supportActivity as? SupportActivity)?.start(ARouter.getInstance().build(path)
                .withParcelable(SECENDTAG, data)
                .withString(FIRSTTAG, tag)
                .navigation() as? SupportFragment, ISupportFragment.SINGLETASK)
    }

    fun JumpFragmentWithParceble(supportActivity: Activity, path: String, tag: Parcelable?, data: Parcelable?) {
        (supportActivity as? SupportActivity)?.start(ARouter.getInstance().build(path)
            .withParcelable(SECENDTAG, data)
            .withParcelable(FIRSTTAG, tag)
            .navigation() as? SupportFragment, ISupportFragment.SINGLETASK)
    }

    fun JumpFragmentWithParcebleWithPop(supportActivity: Activity, path: String, data: Parcelable?, tag: Int) {
        (supportActivity as? SupportActivity)?.startWithPop(ARouter.getInstance().build(path)
                .withParcelable(FIRSTTAG, data)
                .withInt(SECENDTAG, tag)
                .navigation() as? SupportFragment)
    }

    fun JumpFragmentWithParceble(supportActivity: Activity, path: String, tag: String?, tag2: String?, data: Parcelable?) {
        (supportActivity as? SupportActivity)?.start(ARouter.getInstance().build(path)
                .withParcelable(THIRDATG, data)
                .withString(SECENDTAG, tag2)
                .withString(FIRSTTAG, tag)
                .navigation() as? SupportFragment, ISupportFragment.SINGLETASK)
    }

    fun JumpFragmentWithParceble(supportActivity: Activity, path: String, tag: String?, tag2: String?, tag3: String?, data: Parcelable?) {
        (supportActivity as? SupportActivity)?.start(ARouter.getInstance().build(path)
                .withParcelable(FOUR, data)
                .withString(THIRDATG, tag3)
                .withString(SECENDTAG, tag2)
                .withString(FIRSTTAG, tag)
                .navigation() as? SupportFragment, ISupportFragment.SINGLETASK)
    }

    fun JumpFragmentWithList(supportActivity: Activity, path: String, tag: ArrayList<out Parcelable>) {
        (supportActivity as? SupportActivity)?.start(ARouter.getInstance().build(path)
            .withParcelableArrayList(FIRSTTAG, tag)
            .navigation() as? SupportFragment, ISupportFragment.SINGLETASK)
    }

}