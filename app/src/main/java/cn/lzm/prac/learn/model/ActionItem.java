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
        ActionItem actionItem4 = new ActionItem();
        actionItem4.actionType = "service_test";
        actionItem4.actionValue = "service test item";
        actionItems.add(actionItem4);
        ActionItem actionItem5 = new ActionItem();
        actionItem5.actionType = "fragment_test";
        actionItem5.actionValue = "fragment test item";
        actionItems.add(actionItem5);
        ActionItem actionItem6 = new ActionItem();
        actionItem6.actionType = "components_test";
        actionItem6.actionValue = "components test item";
        actionItems.add(actionItem6);
        ActionItem actionItem7 = new ActionItem();
        actionItem7.actionType = "tab_fragment";
        actionItem7.actionValue = "tab fragment item";
        actionItems.add(actionItem7);

        loadListener.loadSuccess(actionItems);
    }
}
