package com.edus;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
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

public class ViewPagerFragmentStatedActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    private ViewPager mVpContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_pager);
        initView();
        initData();
    }

    private void initData() {
        mVpContent.setAdapter(new StatedAdapter(getSupportFragmentManager()));
    }

    private void initView() {
        mVpContent = (ViewPager) findViewById(R.id.vp_content);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
//        super.onSaveInstanceState(outState, outPersistentState);
    }

    private class StatedAdapter extends FragmentStatePagerAdapter{

        private final int INDEX_TITLE = 0;
        private final int INDEX_CONTENT = 1;
        private final int INDEX_FRAGMENT_CONTENT1 = 2;
        private final int INDEX_FRAGMENT_CONTENT2 = 3;
        private final int INDEX_FRAGMENT_CONTENT3 = 4;
        private final int INDEX_COUNT = 5;

        public StatedAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Log.e(TAG, "instantiateItem position:"+position);
            return super.instantiateItem(container, position);
        }

        @Override
        public Fragment getItem(int position) {
            //init fragment data here
            Log.e(TAG, "getItem position:"+position);
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
        public void destroyItem(ViewGroup container, int position, Object object) {
            Log.e(TAG, "destroyItem position:"+position);
            super.destroyItem(container, position, object);
        }

        @Override
        public int getCount() {
            return INDEX_COUNT;
        }
    }

    //方式1,ViewPager+FragmentPagerAdapter+Fragment
    //方式2,ViewPager+FragmentStatedPagerAdapter+Fragment
}
