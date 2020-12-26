package cn.lzm.prac.learn.view.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cn.lzm.prac.learn.R
import cn.lzm.prac.learn.utils.LogUtil

class TestFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        LogUtil.redPrint("onAttach---")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.redPrint("onCreate---")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        LogUtil.redPrint("onCreateView---")
        return inflater.inflate(R.layout.fragment_test, null, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        LogUtil.redPrint("onActivityCreated---")
    }

    override fun onStart() {
        super.onStart()
        LogUtil.redPrint("onStart---")
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        LogUtil.redPrint("onHiddenChanged---hidden:$hidden")
    }

    override fun onResume() {
        super.onResume()
        LogUtil.redPrint("onResume---")
    }

    override fun onPause() {
        super.onPause()
        LogUtil.redPrint("onPause---")
    }

    override fun onStop() {
        super.onStop()
        LogUtil.redPrint("onStop---")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        LogUtil.redPrint("onDestroyView---")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtil.redPrint("onDestroy---")
    }

    override fun onDetach() {
        super.onDetach()
        LogUtil.redPrint("onDetach---")
    }
}