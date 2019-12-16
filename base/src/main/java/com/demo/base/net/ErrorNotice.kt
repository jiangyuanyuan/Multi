package com.demo.base.net

class ErrorNotice private constructor() {


    private var mErrorListener: ErrorListener? = null

    fun reg(listener: ErrorListener) {
        this.mErrorListener = listener
    }

    fun notifyError(code: Int, msg: String) {
        if (null != mErrorListener) {
            mErrorListener!!.onNotify(code, msg)
        }
    }

    interface ErrorListener {
        fun onNotify(code: Int, msg: String)
    }

    companion object {

        val INSTANCE : ErrorNotice by lazy {
            ErrorNotice()
        }

    }
}
