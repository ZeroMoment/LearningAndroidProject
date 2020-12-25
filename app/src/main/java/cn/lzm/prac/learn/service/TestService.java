package cn.lzm.prac.learn.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import cn.lzm.prac.learn.aidl.IProcessInfo;
import cn.lzm.prac.learn.aidl.IProcessInfoImpl;
import cn.lzm.prac.learn.helper.MyBinder;

public class TestService extends Service {
    IProcessInfoImpl mProcessInfo = new IProcessInfoImpl();

//    IProcessInfo.Stub mStub = new IProcessInfo.Stub() {
//        @Override
//        public int getProcessId() throws RemoteException {
//            return android.os.Process.myPid();
//        }
//    };

    MyBinder myBinder = new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();

        myBinder.mProcessId = android.os.Process.myPid();
        Log.e("lzm", "service ondcreate.....");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("lzm", "service onbind------");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("lzm", "service onununun  -unbind------");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("lzm", "service onStartCommand------");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.e("lzm", "service 销毁.....");
        super.onDestroy();
    }
}
