package cn.lzm.prac.learn.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import cn.lzm.prac.learn.R;

public class CommonRecyclerFragment extends Fragment {

    String mTitle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("lzm", "CommonRecyclerFragment--onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("lzm", "CommonRecyclerFragment-onActivityCreated=");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle argument = getArguments();
        Log.e("lzm", "888888-argument="+argument);
        if(argument != null) {
            mTitle = argument.getString("title");
        }
        return inflater.inflate(R.layout.fragment_common_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("lzm", "CommonRecyclerFragment-onViewCreated=");
        TextView testTv = view.findViewById(R.id.test_common_tv);
        testTv.setText(mTitle);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("lzm", "CommonRecyclerFragment-onStop=");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("lzm", "CommonRecyclerFragment-onDestroyView=");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("lzm", "CommonRecyclerFragment-onDestroy=");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("lzm", "CommonRecyclerFragment-onDetach=");
    }

    public static CommonRecyclerFragment newInstance(String title) {
        CommonRecyclerFragment fragment = new CommonRecyclerFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }
}
