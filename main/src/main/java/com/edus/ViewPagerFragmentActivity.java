package com.edus;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;

import com.edus.fragment.ContentFragment;
import com.edus.fragment.Fragment1;
import com.edus.fragment.Fragment2;
import com.edus.fragment.Fragment3;
import com.edus.fragment.TitleFragment;
import com.example.main.R;

/**
 * Created by panda on 2017/4/25.
 */

public class ViewPagerFragmentActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();

    private ViewPager mVpContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_pager);
        initView();
        initData(savedInstanceState);
    }

    private void initData(Bundle savedInstanceState) {
        mVpContent.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
    }

    private void initView() {
        mVpContent = (ViewPager) findViewById(R.id.vp_content);
//        mVpContent.setOffscreenPageLimit(3);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
//        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
    }

    private class FragmentAdapter extends FragmentPagerAdapter {
        private final int INDEX_TITLE = 0;
        private final int INDEX_CONTENT = 1;
        private final int INDEX_FRAGMENT_CONTENT1 = 2;
        private final int INDEX_FRAGMENT_CONTENT2 = 3;
        private final int INDEX_FRAGMENT_CONTENT3 = 4;
        private final int INDEX_COUNT = 5;


        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public Fragment getItem(int position) {
            //init fragment data here
            Fragment fragment = null;
            switch (position) {
                case INDEX_CONTENT:
                    fragment = new ContentFragment();
                    break;
                case INDEX_TITLE:
                    fragment = new TitleFragment();
                    break;
                case INDEX_FRAGMENT_CONTENT1:
                    fragment = new Fragment1();
                    break;
                case INDEX_FRAGMENT_CONTENT2:
                    fragment = new Fragment2();
                    break;
                case INDEX_FRAGMENT_CONTENT3:
                    fragment = new Fragment3();
                    break;
                default:
                    fragment = new TitleFragment();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return INDEX_COUNT;
        }
    }

    @Override
    protected void onDestroy() {
        mVpContent.setAdapter(null);
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e(TAG, "onConfigurationChanged"+this);
    }

    //方式1,ViewPager+FragmentPagerAdapter+Fragment
    //方式2,ViewPager+FragmentStatedPagerAdapter+Fragment
}
