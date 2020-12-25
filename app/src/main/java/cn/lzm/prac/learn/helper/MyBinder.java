package cn.lzm.prac.learn.helper;

import android.os.Binder;

//定义用于通信的对象，在Service的onBind()中返回的对象。
public class MyBinder extends Binder {

    public int mProcessId;

}
