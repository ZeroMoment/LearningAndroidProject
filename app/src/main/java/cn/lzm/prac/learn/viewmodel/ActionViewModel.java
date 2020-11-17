package cn.lzm.prac.learn.viewmodel;

import android.util.Log;

import java.util.List;

import cn.lzm.prac.learn.MainActivity;
import cn.lzm.prac.learn.listener.LoadListener;
import cn.lzm.prac.learn.model.ActionItem;

public class ActionViewModel {

    private  static final String TAG = "ActionViewModel";

    private MainActivity mActivity;

    public ActionViewModel(MainActivity activity) {
        this.mActivity = activity;
    }

    public void loadActions() {
        ActionItem item = new ActionItem();
        item.loadData(new LoadListener<ActionItem>() {
            @Override
            public void loadSuccess(List<ActionItem> list) {
                mActivity.mActionList.addAll(list);
                mActivity.mMainActionAdapter.notifyDataSetChanged();
            }

            @Override
            public void loadFailure(String message) {
                Log.e("lzm", "error-net:"+message);
            }
        });
    }

}
