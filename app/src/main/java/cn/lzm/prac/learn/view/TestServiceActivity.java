package cn.lzm.prac.learn.view;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import cn.lzm.prac.learn.R;
import cn.lzm.prac.learn.aidl.IProcessInfo;
import cn.lzm.prac.learn.helper.MyBinder;
import cn.lzm.prac.learn.service.TestService;

public class TestServiceActivity extends Activity {

    private Intent mServiceIntent;
    private boolean isNeedUnbind = false;

    private ServiceConnection mServiceConnection;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_service);

        mServiceIntent = new Intent(TestServiceActivity.this, TestService.class);

        mServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.e("lzm", "onbind--connection");
                //和服务绑定成功后，服务会回调该方法
                //服务异常中断后重启，也会重新调用改方法
                MyBinder myBinder = (MyBinder) service;
                Log.e("lzm", "mybinder pid="+myBinder.mProcessId);

//                IProcessInfo processInfo = IProcessInfo.Stub.asInterface(service);
//                try {
//                    int remotePid = processInfo.getProcessId();
//                    Log.e("lzm", "remote pid="+remotePid);
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.e("lzm", "onbind--断链");

                // 当服务异常终止时会调用。
                // 注意，unbindService时不会调用
            }

            @Override
            public void onNullBinding(ComponentName name) {
                //Service的onBind()返回null时将会调用这个方法，并不会调用onServiceConnected()
                Log.e("lzm", "onbind--null");
            }
        };
    }

    public void startService(View view) {
        startService(mServiceIntent);
    }

    public void bindServ(View view) {
        int mainPid = android.os.Process.myPid();
        Log.e("lzm", "main主- pid="+mainPid);
        isNeedUnbind = bindService(mServiceIntent, mServiceConnection, BIND_AUTO_CREATE);

    }

    public void unbindServ(View view) {
        if(isNeedUnbind) {
            isNeedUnbind = false;
            unbindService(mServiceConnection);
        }
    }

    public void stopService(View view) {
        stopService(mServiceIntent);
    }

    @Override
    protected void onDestroy() {
        if(isNeedUnbind) {
            isNeedUnbind = false;
            unbindService(mServiceConnection);
        }
        super.onDestroy();
    }
}
