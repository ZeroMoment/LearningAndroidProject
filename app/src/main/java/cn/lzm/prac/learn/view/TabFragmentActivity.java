package cn.lzm.prac.learn.view;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;

import cn.lzm.prac.learn.R;
import cn.lzm.prac.learn.view.fragment.ExchangeFragment;
import cn.lzm.prac.learn.view.fragment.FollowFragment;
import cn.lzm.prac.learn.view.fragment.HomeFragment;
import cn.lzm.prac.learn.view.fragment.MeFragment;

public class TabFragmentActivity extends AppCompatActivity {

    private ArrayList<Fragment> mFragments;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    private HomeFragment mHomeFragment;
    private FollowFragment mFollowFragment;
    private ExchangeFragment mExchangeFragment;
    private MeFragment mMeFragment;

    private BottomNavigationBar mBottomNavigationBar;
    int lastSelectedPosition = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tabfragment);

        mBottomNavigationBar = findViewById(R.id.tab_bottom_navigation_bar);

        init();

    }

    private void init() {
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.setActiveColor("#ac564f");

        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_font_m, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.ic_font_o, "关注"))
                .addItem(new BottomNavigationItem(R.drawable.ic_font_o, "交流"))
                .addItem(new BottomNavigationItem(R.drawable.ic_font_n, "我"))
                .setFirstSelectedPosition(lastSelectedPosition)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                Log.e("lzm", "on tab selected ---"+position);
                mFragmentManager = getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                switch (position) {
                    case 0:
                        if(mHomeFragment == null) {
                            mHomeFragment = HomeFragment.newInstance();
                        }
                        mFragmentTransaction.replace(R.id.tab_fragment_container, mHomeFragment);
                        break;
                    case 1:
                        if(mFollowFragment == null) {
                            mFollowFragment = FollowFragment.newInstance();
                        }
                        mFragmentTransaction.replace(R.id.tab_fragment_container, mFollowFragment);
                        break;
                    case 2:
                        if(mExchangeFragment == null) {
                            mExchangeFragment = ExchangeFragment.newInstance();
                        }
                        mFragmentTransaction.replace(R.id.tab_fragment_container, mExchangeFragment);
                        break;
                    case 3:
                        if(mMeFragment == null) {
                            mMeFragment = MeFragment.newInstance();
                        }
                        mFragmentTransaction.replace(R.id.tab_fragment_container, mMeFragment);
                        break;
                    default:
                        break;
                }
                mFragmentTransaction.commit();
                lastSelectedPosition = position;
            }

            @Override
            public void onTabUnselected(int position) {
                Log.e("lzm", "on onTabUnselected 222 ---"+position);
            }

            @Override
            public void onTabReselected(int position) {
                Log.e("lzm", "on onTabReselected 3333 ---"+position);
            }
        });

        setDefaultFragment();
    }

    private void setDefaultFragment() {
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.tab_fragment_container, HomeFragment.newInstance());
        mFragmentTransaction.commit();
    }
}
