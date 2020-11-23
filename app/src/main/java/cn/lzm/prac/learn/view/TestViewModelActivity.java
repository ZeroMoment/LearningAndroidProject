package cn.lzm.prac.learn.view;

import android.net.Network;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import cn.lzm.prac.learn.R;
import cn.lzm.prac.learn.databinding.ActivityTestViewmodelBinding;
import cn.lzm.prac.learn.livedata.NetworkLiveData;
import cn.lzm.prac.learn.viewmodel.TestViewModel;

public class TestViewModelActivity extends AppCompatActivity {

    private ActivityTestViewmodelBinding mTestViewmodelBinding;

    private TestViewModel mTestViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTestViewmodelBinding = DataBindingUtil.setContentView(this, R.layout.activity_test_viewmodel);

        mTestViewModel = ViewModelProviders.of(this, new TestViewModel.Factory("呵呵key")).get(TestViewModel.class);
        MutableLiveData<String> nameEvent = mTestViewModel.getmNameEvent();
        nameEvent.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("lzm", "onChangeed:s="+s);
                mTestViewmodelBinding.testViewmodelTv.setText(s);
            }
        });

        mTestViewmodelBinding.testViewmodelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeName();
            }
        });

        NetworkLiveData.getInstance(this).observe(this, new Observer<Network>() {
            @Override
            public void onChanged(Network network) {
                Log.e("lzm", "网络-onChangeed:snetwork="+network);
            }
        });

    }

    private void changeName() {
       String editTxt = mTestViewmodelBinding.testViewmodelEdit.getText().toString();
       if(TextUtils.isEmpty(editTxt)) {
           editTxt = "没有输入";
       }

       mTestViewModel.getmNameEvent().setValue(editTxt);
    }
}
