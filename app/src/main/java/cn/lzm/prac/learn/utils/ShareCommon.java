package cn.lzm.prac.learn.utils;

import android.text.TextUtils;
import android.util.Log;

import java.util.LinkedHashMap;

public class ShareCommon {

    private String title; //必填
    private String desc; //选填 描述
    private String link; //选填 分享链接

    private ShareCommon(Builder builder){
        this.title = builder.title;
        this.desc = builder.desc;
        this.link = builder.link;
    }

    public static class Builder{
        private String title; //必填
        private String desc; //选填 描述
        private String link; //选填 分享链接

        public Builder(String title) {
            this.title = title;
        }

        public Builder setDesc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder setLink(String link) {
            this.link = link;
            return this;
        }


        public ShareCommon build() {
            return new ShareCommon(this);
        }
    }

    public void share() {

        if(TextUtils.isEmpty(desc)) {
            Log.e("lzm", "没有传描述，使用默认描述赋值");
        }

        if(TextUtils.isEmpty(link)) {
            Log.e("lzm", "没有传分享链接，使用默认链接赋值");
        }

        Log.e("lzm", "走分享去");
    }

}
