package cn.lzm.prac.learn.adapter;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import cn.lzm.prac.learn.R;
import cn.lzm.prac.learn.components.LiveDataActivity;
import cn.lzm.prac.learn.databinding.ItemActionsBinding;
import cn.lzm.prac.learn.model.ActionItem;
import cn.lzm.prac.learn.view.AloneWebviewActivity;
import cn.lzm.prac.learn.view.FragmentTestActivity;
import cn.lzm.prac.learn.view.NewsActivity;
import cn.lzm.prac.learn.view.NewsJunshiAcitivty;
import cn.lzm.prac.learn.view.TabFragmentActivity;
import cn.lzm.prac.learn.view.TestServiceActivity;
import cn.lzm.prac.learn.view.TestViewModelActivity;

public class MainActionAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<ActionItem> mActionItemList;

    public MainActionAdapter(Context context, List<ActionItem> actionItems) {
        this.mContext = context;
        this.mActionItemList = actionItems;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemActionsBinding itemActionsBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_actions, parent, false);
        return new ViewHolder(itemActionsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        ActionItem actionItem = mActionItemList.get(position);
        // dataBinding绑定
        viewHolder.mItemActionsBinding.setActions(actionItem);

        viewHolder.mItemActionsBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String actionType = actionItem.getActionType();
                Log.e("lzm", "aciton:"+actionType);
                if("news_top".equals(actionType)) {
                    Intent intent = new Intent(mContext, NewsActivity.class);
                    mContext.startActivity(intent);
                } else if("news_junshi".equals(actionType)) {
                    Intent junshiIntent = new Intent(mContext, NewsJunshiAcitivty.class);
                    mContext.startActivity(junshiIntent);
                } else if("livedate_test".equals(actionType)) {
                    Intent livedataIntent = new Intent(mContext, TestViewModelActivity.class);
                    mContext.startActivity(livedataIntent);
                } else if("service_test".equals(actionType)) {
                    Intent serviceTestIntent = new Intent(mContext, TestServiceActivity.class);
                    mContext.startActivity(serviceTestIntent);
                } else if("fragment_test".equals(actionType)) {
                    Intent fragmentIntent = new Intent(mContext, FragmentTestActivity.class);
                    mContext.startActivity(fragmentIntent);
                } else if("components_test".equals(actionType)) {
                    Intent componetsIntent = new Intent(mContext, LiveDataActivity.class);
                    mContext.startActivity(componetsIntent);
                } else if("tab_fragment".equals(actionType)) {
                    Intent tabIntent = new Intent(mContext, TabFragmentActivity.class);
                    mContext.startActivity(tabIntent);
                } else if("web_process".equals(actionType)) {
                    Intent webIntent = new Intent(mContext, AloneWebviewActivity.class);
                    webIntent.putExtra("alone_weburl", "https://www.baidu.com");
                    mContext.startActivity(webIntent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mActionItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemActionsBinding mItemActionsBinding;

        public ViewHolder(ItemActionsBinding itemActionsBinding) {
            super(itemActionsBinding.getRoot());
            this.mItemActionsBinding = itemActionsBinding;
        }
    }
}
