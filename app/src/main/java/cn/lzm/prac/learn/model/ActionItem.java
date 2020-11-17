package cn.lzm.prac.learn.model;

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
        actionItem1.actionType = "news";
        actionItem1.actionValue = "news item";
        actionItems.add(actionItem1);

        loadListener.loadSuccess(actionItems);
    }
}
