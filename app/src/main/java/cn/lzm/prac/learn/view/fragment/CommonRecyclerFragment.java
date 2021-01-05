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
        TextView testTv = view.findViewById(R.id.test_common_tv);
        testTv.setText(mTitle);
    }

    public static CommonRecyclerFragment newInstance(String title) {
        CommonRecyclerFragment fragment = new CommonRecyclerFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }
}
