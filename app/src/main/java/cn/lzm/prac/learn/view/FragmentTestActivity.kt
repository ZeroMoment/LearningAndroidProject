package cn.lzm.prac.learn.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import cn.lzm.prac.learn.R
import cn.lzm.prac.learn.utils.LogUtil
import cn.lzm.prac.learn.view.fragment.TestFragment

class FragmentTestActivity : AppCompatActivity() {

    lateinit var mShowBtn: Button
    lateinit var mHideBtn: Button

    lateinit var mFragment: TestFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_test)

        mShowBtn = findViewById(R.id.show_btn)
        mHideBtn = findViewById(R.id.hide_btn)

        mFragment = TestFragment()
        var fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_containter, mFragment)
        fragmentTransaction.commitAllowingStateLoss()

        mShowBtn.setOnClickListener(View.OnClickListener {
            LogUtil.redPrint("show--ishidden:"+mFragment.isHidden)
            if(mFragment.isHidden) {
                var tempTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
                tempTransaction.show(mFragment)
                tempTransaction.commit()
            }
        })

        mHideBtn.setOnClickListener(View.OnClickListener {
            LogUtil.redPrint("hide--ishidden:"+mFragment.isHidden)
            if(!mFragment.isHidden) {
                var tempTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
                tempTransaction.hide(mFragment)
                tempTransaction.commit()
            }
        })

    }

}