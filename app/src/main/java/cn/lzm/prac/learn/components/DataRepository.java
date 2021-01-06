package cn.lzm.prac.learn.components;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class DataRepository {

    private static DataRepository sInstance;
    private MutableLiveData<List<String>> mDatas;

    private Handler mWorkHandler;

    private DataRepository() {
        mDatas = new MutableLiveData<>();
    }

    public static DataRepository getInstance() {
        if (sInstance == null) {
            synchronized (DataRepository.class) {
                if (sInstance == null) {
                    sInstance = new DataRepository();
                }
            }
        }
        return sInstance;
    }

    public void loadReal() {

        if(mWorkHandler == null) {
            HandlerThread thread = new HandlerThread("DataViewModel");
            thread.start();
            mWorkHandler = new Handler(thread.getLooper());
        }

        mWorkHandler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                List<String> result = makeResult();
                setResult(result);
            }
        });

    }

    private List<String> makeResult() {

        List<String> result = new ArrayList<>();

        result.add("apple - 1");
        result.add("apple - 2");
        result.add("apple - 3");
        result.add("apple - 4");
        result.add("apple - 5");
        result.add("apple - 6");

        return result;

    }

    private void setResult(List<String> results) {

        Log.d("lzm", "Call setResults");

        if(Looper.getMainLooper() == Looper.myLooper()) {
            mDatas.setValue(results);
        } else {
            mDatas.postValue(results);
        }

    }

    public MutableLiveData<List<String>> getListData() {
        return mDatas;
    }

}
