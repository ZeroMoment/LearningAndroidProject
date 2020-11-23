package cn.lzm.prac.learn.model;

import androidx.databinding.BaseObservable;

import java.util.ArrayList;
import java.util.List;

import cn.lzm.prac.learn.listener.LoadListener;

public class ActionItem {
    private String actionType;
    private String actionValue;

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getActionValue() {
        return actionValue;
    }

    public void setActionValue(String actionValue) {
        this.actionValue = actionValue;
    }

    public void loadData(final LoadListener<ActionItem> loadListener) {

        List<ActionItem> actionItems = new ArrayList<>();
        ActionItem actionItem1 = new ActionItem();
        actionItem1.actionType = "news_top";
        actionItem1.actionValue = "news top item";
        actionItems.add(actionItem1);
        ActionItem actionItem2 = new ActionItem();
        actionItem2.actionType = "news_junshi";
        actionItem2.actionValue = "news junshi item";
        actionItems.add(actionItem2);
        ActionItem actionItem3 = new ActionItem();
        actionItem3.actionType = "livedate_test";
        actionItem3.actionValue = "livedate test item";
        actionItems.add(actionItem3);

        loadListener.loadSuccess(actionItems);
    }
}
