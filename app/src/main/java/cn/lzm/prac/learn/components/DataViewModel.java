package cn.lzm.prac.learn.components;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class DataViewModel extends ViewModel {

    private static final String TAG = DataViewModel.class.getSimpleName();

    private MutableLiveData<List<String>> mWatcher;
    private Handler mWorkHandler;

    /**
     * 获取数据的监控者
     * @return 监控者
     */
    public MutableLiveData<List<String>> getWatcher() {
        Log.d(TAG, "Call getWatcher");
        if(mWatcher == null) {
            mWatcher = new MutableLiveData<>();
        }
        return mWatcher;
    }

    /**
     * 加载数据，在实际当中，加载数据的操作要放在Repository中进行，而不要放在model中，
     * 它只是负责数据和UI的交互过程
     */
    public void load() {

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

        Log.d(TAG, "Call setResults");

        if(Looper.getMainLooper() == Looper.myLooper()) {
            getWatcher().setValue(results);
        } else {
            getWatcher().postValue(results);
        }

    }

}
