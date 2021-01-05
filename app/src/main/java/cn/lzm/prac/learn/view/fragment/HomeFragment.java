package cn.lzm.prac.learn.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import cn.lzm.prac.learn.R;
import cn.lzm.prac.learn.adapter.FragmentAdapter;

public class HomeFragment extends Fragment {

    private ViewPager mPager;
    private FragmentAdapter mFragmentAdapter;
    private List<CommonRecyclerFragment> mFragmentList;

    private TabLayout mTabLayout;
    private CommonRecyclerFragment recommonFragment, exploreFragment;
    private List<String> mTitles;

    private String[] titles={"推荐", "探索"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e("lzm","home--onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("lzm","home--onCreateView");
        return inflater.inflate(R.layout.fragment_common_withtab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.e("lzm","home--onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        ImageView searchIv = view.findViewById(R.id.tag_search_iv);
        searchIv.setVisibility(View.VISIBLE);

        mTabLayout = view.findViewById(R.id.fragment_top_tablayout);
        mPager = view.findViewById(R.id.tab_viewpager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("lzm","home--onActivityCreated");
        mFragmentList = new ArrayList<>();
        mTitles = new ArrayList<>();
        for (int i=0; i<titles.length; i++) {
            mTitles.add(titles[i]);
            mFragmentList.add(CommonRecyclerFragment.newInstance(titles[i]));
        }

        mFragmentAdapter = new FragmentAdapter(getActivity().getSupportFragmentManager(), mFragmentList, mTitles);
        mPager.setAdapter(mFragmentAdapter);
        mTabLayout.setupWithViewPager(mPager);
    }

    @Override
    public void onStop() {
        Log.e("lzm","home--onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.e("lzm","home--onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e("lzm","home--onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.e("lzm","home--onDetach");
        super.onDetach();
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }
}
