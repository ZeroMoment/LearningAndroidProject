package cn.lzm.prac.learn.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import cn.lzm.prac.learn.R

class NewsJunshiAcitivty : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_junshi)
        findViewById<Button>(R.id.button).setOnClickListener(View.OnClickListener {
            val intent = Intent(this, WebviewActivity::class.java)
            intent.putExtra(WebviewActivity.KEY_URL, "http://www.baidu.com")
            startActivity(intent)
        })

    }
}