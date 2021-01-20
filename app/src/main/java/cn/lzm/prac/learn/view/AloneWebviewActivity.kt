package cn.lzm.prac.learn.view

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import cn.lzm.prac.learn.R

class AloneWebviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        var webUrl = intent.getStringExtra("alone_weburl")

        Log.e("lzm", "跨进程："+webUrl)

        var webView = findViewById<WebView>(R.id.page_webview)

        webView.settings.javaScriptEnabled = true
        webView.loadUrl(webUrl)

    }

}