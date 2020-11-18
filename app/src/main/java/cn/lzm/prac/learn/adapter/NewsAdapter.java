package cn.lzm.prac.learn.adapter;


import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.lzm.prac.learn.R;
import cn.lzm.prac.learn.databinding.ItemNewsBinding;
import cn.lzm.prac.learn.model.NewsItem;
import cn.lzm.prac.learn.view.WebviewActivity;

public class NewsAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<NewsItem> mNewsItemList;

    public NewsAdapter(Context context, List<NewsItem> newsItems) {
        this.mContext = context;
        this.mNewsItemList = newsItems;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNewsBinding itemNewsBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_news, parent, false);
        return new ViewHolder(itemNewsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        NewsItem newsItem = mNewsItemList.get(position);
        // dataBinding绑定
        viewHolder.mItemNewsBinding.setNews(newsItem);

        viewHolder.mItemNewsBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newsUrl = newsItem.getUrl();
                Log.e("lzm", "newsUrl:"+newsUrl);
                if(TextUtils.isEmpty(newsUrl)) {
                    Toast.makeText(mContext, "新闻内容异常", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(mContext, WebviewActivity.class);
                intent.putExtra(WebviewActivity.KEY_URL, newsUrl);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNewsItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemNewsBinding mItemNewsBinding;

        public ViewHolder(ItemNewsBinding itemNewsBinding) {
            super(itemNewsBinding.getRoot());
            this.mItemNewsBinding = itemNewsBinding;
        }
    }
}
