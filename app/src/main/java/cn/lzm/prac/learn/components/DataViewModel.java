package cn.lzm.prac.learn.components;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class DataViewModel extends ViewModel {

    private static final String TAG = DataViewModel.class.getSimpleName();

    private MutableLiveData<List<String>> mWatcher;

    private DataRepository dataRepository;

    public DataViewModel() {
        Log.e("lzm", "dataviewmodel  constuct");
        dataRepository = DataRepository.getInstance();
        mWatcher = dataRepository.getListData();
    }

    public void load() {
        dataRepository.loadReal();
    }

    /**
     * 获取数据的监控者
     * @return 监控者
     */
    public MutableLiveData<List<String>> getWatcher() {
        Log.d(TAG, "Call getWatcher");
        return mWatcher;
    }

}
