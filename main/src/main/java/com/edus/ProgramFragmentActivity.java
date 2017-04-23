package com.edus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.edus.fragment.ContentFragment;
import com.edus.fragment.TitleFragment;
import com.edus.fragment.ViewFragment;
import com.example.main.R;

/**
 * Created by panda on 2017/4/23.
 */

public class ProgramFragmentActivity extends AppCompatActivity implements View.OnClickListener {
    private FrameLayout mFlTitle;
    private FrameLayout mFlContent;
    private FragmentManager mFragmentManager;
    private Button mBtnShowTitle;
    private Button mBtnHideTitle;
    private Button mBtnShowContent;
    private Button mBtnHideContent;
    private TitleFragment mTitleFragment;
    private ContentFragment mContentFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_program);
        mFlTitle = (FrameLayout) findViewById(R.id.fl_title);
        mFlContent = (FrameLayout) findViewById(R.id.fl_content);
        mBtnShowTitle = (Button) findViewById(R.id.bt_show_title);
        mBtnShowTitle.setOnClickListener(this);
        mBtnHideTitle = (Button) findViewById(R.id.bt_hide_title);
        mBtnHideTitle.setOnClickListener(this);
        mBtnShowContent = (Button) findViewById(R.id.bt_show_content);
        mBtnShowContent.setOnClickListener(this);
        mBtnHideContent = (Button) findViewById(R.id.bt_hide_content);
        mBtnHideContent.setOnClickListener(this);
        initData(savedInstanceState);

    }

    private void initData(Bundle savedInstanceState) {
        mFragmentManager = getSupportFragmentManager();
        mTitleFragment = (TitleFragment) mFragmentManager.findFragmentById(mFlTitle.getId());
        mContentFragment = (ContentFragment) mFragmentManager.findFragmentById(mFlContent.getId());
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if(mTitleFragment == null){
            mTitleFragment = new TitleFragment();
            fragmentTransaction.add(mFlTitle.getId(), mTitleFragment);
        }
        if(mContentFragment == null){
            mContentFragment = new ContentFragment();
            fragmentTransaction.add(mFlContent.getId(), mContentFragment);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_show_title:
                mFragmentManager.beginTransaction().show(mTitleFragment).commitAllowingStateLoss();
                break;
            case R.id.bt_hide_title:
                mFragmentManager.beginTransaction().hide(mTitleFragment).commitAllowingStateLoss();
                break;
            case R.id.bt_show_content:
                mFragmentManager.beginTransaction().show(mContentFragment).commitAllowingStateLoss();
                break;
            case R.id.bt_hide_content:
                mFragmentManager.beginTransaction().hide(mContentFragment).commitAllowingStateLoss();
                break;
        }
    }
}
