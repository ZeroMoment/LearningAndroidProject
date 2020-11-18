package cn.lzm.prac.learn.viewmodel;

import java.util.List;

import cn.lzm.prac.learn.listener.LoadListener;
import cn.lzm.prac.learn.model.News;
import cn.lzm.prac.learn.model.NewsItem;
import cn.lzm.prac.learn.view.NewsActivity;

public class NewsViewModel {

    private  static final String TAG = "NewsViewModel";

    private NewsActivity mActivity;

    public NewsViewModel(NewsActivity activity) {
        this.mActivity = activity;
    }

    public void loadNews() {
        News news = new News();
        news.loadData(new LoadListener<NewsItem>() {
            @Override
            public void loadSuccess(List<NewsItem> list) {
                mActivity.itemList.addAll(list);
                mActivity.mNewsAdapter.notifyDataSetChanged();
            }

            @Override
            public void loadFailure(String message) {

            }
        });
    }

}
