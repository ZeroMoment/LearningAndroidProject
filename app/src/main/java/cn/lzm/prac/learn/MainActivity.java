package cn.lzm.prac.learn;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import cn.lzm.prac.learn.adapter.MainActionAdapter;
import cn.lzm.prac.learn.databinding.ActivityMainBinding;
import cn.lzm.prac.learn.model.ActionItem;
import cn.lzm.prac.learn.viewmodel.ActionViewModel;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding mActivityMainBinding;
    private ActionViewModel mViewModel;

    public MainActionAdapter mMainActionAdapter;
    public List<ActionItem> mActionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = new ActionViewModel(this);
        mActivityMainBinding.setViewModel(mViewModel);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mActivityMainBinding.actionRecyclerview.setLayoutManager(layoutManager);

        mMainActionAdapter = new MainActionAdapter(this, mActionList);
        mActivityMainBinding.actionRecyclerview.setAdapter(mMainActionAdapter);

        //加载数据
        mViewModel.loadActions();

//        TestTask testTask = new TestTask();
//        testTask.execute(10, 20);
    }

    class TestTask extends AsyncTask<Integer, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.e("lzm", "mytask---showDialog");
        }

        @Override
        protected String doInBackground(Integer... integers) {
            int firtv = integers[0];
            int sendv = integers[1];

            Log.e("lzm", "mytask---doInBackground-fv:"+firtv+"--dnv:"+sendv);

            return ""+(firtv+sendv);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.e("lzm", "mytask---onPostExecute-result:"+s);

        }
    }
}