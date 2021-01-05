package cn.lzm.prac.learn.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import cn.lzm.prac.learn.R;

public class ExchangeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_common_withtab, container, false);
    }

    public static ExchangeFragment newInstance() {
        ExchangeFragment fragment = new ExchangeFragment();
        return fragment;
    }
}
