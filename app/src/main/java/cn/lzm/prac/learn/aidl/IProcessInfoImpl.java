package cn.lzm.prac.learn.aidl;

import android.os.RemoteException;

public class IProcessInfoImpl extends IProcessInfo.Stub {
    @Override
    public int getProcessId() throws RemoteException {
        return android.os.Process.myPid();
    }
}
