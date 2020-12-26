package cn.lzm.prac.learn.utils

import android.util.Log

/**
 * 公用日志类
 */
class LogUtil {

    companion object{

        val logTag: String = "lzm"

        fun redPrint(msg: String) {
            Log.e(logTag, msg)
        }

        fun normalPrint(msg: String) {
            Log.d(logTag, msg)
        }

    }

}