package cn.lzm.prac.learn.listener;

import java.util.List;

public interface LoadListener<T> {

    void loadSuccess(List<T> list);
    void loadFailure(String message);

}
