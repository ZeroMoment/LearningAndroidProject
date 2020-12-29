package cn.lzm.prac.learn.components;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

import cn.lzm.prac.learn.R;

/**
 * 纯净mvvm 无databinding
 */
public class LiveDataActivity extends AppCompatActivity {

    private Button mBtnRefresh;
    private TextView mTvResult;
    private DataViewModel mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livedata);

        mTvResult = findViewById(R.id.livedata_tv);

        mViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        mViewModel.getWatcher().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                Log.d("dataViewmodel", "onChanged");
                String tvDisplay = "";
                for (String result : strings) {
                    tvDisplay += (result + "\n");
                }

                mTvResult.setText(tvDisplay);
            }
        });

        mBtnRefresh = findViewById(R.id.livedata_btn);
        mBtnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.load();
            }
        });
    }

    @Override
    protected void onDestroy() {
//        mViewModel.getWatcher().removeObserver("observer对象");
        super.onDestroy();
    }
}
