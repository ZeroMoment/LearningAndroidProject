package cn.lzm.prac.learn.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

import cn.lzm.prac.learn.view.fragment.CommonRecyclerFragment;

public class FragmentAdapter extends FragmentPagerAdapter {
    private List<CommonRecyclerFragment> mFragmentList;
    private List<String> mTitles;

    public FragmentAdapter(@NonNull FragmentManager fm, List<CommonRecyclerFragment> fragments, List<String> titles) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mFragmentList = fragments;
        mTitles = titles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
