package cn.lzm.prac.learn.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class TestViewModel extends ViewModel {

    private final String mKey;

    private MutableLiveData<String> mNameEvent = new MutableLiveData<>();

    public TestViewModel(String key) {
        Log.e("lzm", "getKey:"+key);
        mKey = key;
    }

    public MutableLiveData<String> getmNameEvent() {
        return mNameEvent;
    }

    public static class Factory implements ViewModelProvider.Factory {

        private String mKey;
        public Factory(String key) {
            mKey = key;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T)new TestViewModel(mKey);
        }
    }

    public String getKey() {
        return mKey;
    }
}
