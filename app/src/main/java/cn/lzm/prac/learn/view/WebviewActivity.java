package cn.lzm.prac.learn.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import cn.lzm.prac.learn.R;

public class WebviewActivity extends AppCompatActivity {
    public static final String KEY_URL = "key_url";

    private String expHtml = "<html><head><title>网页异常</title></head><body><h1>源数据异常</h1><p>请检查服务数据</p></body></html>";

    private WebView mWebview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        mWebview = findViewById(R.id.page_webview);

        setData();
    }

    private void setData() {
        WebSettings webSettings = mWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小


        String pageUrl = getIntent().getStringExtra(KEY_URL);
        if(TextUtils.isEmpty(pageUrl)) {
            try {
                mWebview.loadData(URLEncoder.encode(expHtml, "utf-8"), "text/html","utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return;
        }

        mWebview.loadUrl(pageUrl);
    }
}
