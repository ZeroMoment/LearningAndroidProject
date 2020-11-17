package cn.lzm.prac.learn.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import cn.lzm.prac.learn.R;
import cn.lzm.prac.learn.adapter.NewsAdapter;
import cn.lzm.prac.learn.databinding.ActivityNewsBinding;
import cn.lzm.prac.learn.model.NewsItem;
import cn.lzm.prac.learn.viewmodel.NewsViewModel;

public class NewsActivity extends AppCompatActivity {

    public ActivityNewsBinding mActivityNewsBinding;
    private NewsViewModel mViewModel;

    public NewsAdapter mNewsAdapter;
    public List<NewsItem> itemList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityNewsBinding = DataBindingUtil.setContentView(this, R.layout.activity_news);

        mViewModel = new NewsViewModel(this);
        mActivityNewsBinding.setViewModel(mViewModel);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mActivityNewsBinding.newsRecyclerview.setLayoutManager(layoutManager);

        mNewsAdapter = new NewsAdapter(this, itemList);
        mActivityNewsBinding.newsRecyclerview.setAdapter(mNewsAdapter);

        //加载数据
        mViewModel.loadNews();

    }
}
