package cn.lzm.prac.learn.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import cn.lzm.prac.learn.MainActivity
import cn.lzm.prac.learn.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Log.e("lzm","协程前---")
        GlobalScope.launch {
            delay(3000L)
            Log.e("lzm","协程---内---")
            var mainIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(mainIntent)

            finish()
        }
        Log.e("lzm","协程后---")
    }

}