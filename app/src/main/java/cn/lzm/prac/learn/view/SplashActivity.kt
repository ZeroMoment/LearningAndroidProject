package cn.lzm.prac.learn.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import cn.lzm.prac.learn.MainActivity
import cn.lzm.prac.learn.R
import dalvik.system.PathClassLoader
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

    private lateinit var treeView :View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        treeView = findViewById(R.id.test_viewtreee)

        var tempH : Int = treeView.height
        Log.e("lzm", "oncretet-tree_--height:"+tempH)


        var viewObserver : ViewTreeObserver = treeView.viewTreeObserver

        viewObserver.addOnGlobalLayoutListener {
            var treeHeight :Int = treeView.height
            Log.e("lzm", "tree_--observer-height:"+treeHeight)
        }

        Log.e("lzm","协程前---")
        val job = GlobalScope.launch {
            delay(3000L)
            Log.e("lzm","协程---内---")
            var mainIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(mainIntent)

            finish()
        }

        Log.e("lzm","协程后---")

    }

    suspend fun testSusMethod() {
       withContext(Dispatchers.IO) {

       }
    }

    override fun onResume() {
        super.onResume()
        var tempH : Int = treeView.height
        Log.e("lzm", "onResume-tree_--height:"+tempH)
    }

}