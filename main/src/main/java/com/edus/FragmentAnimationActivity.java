package com.edus;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.edus.fragment.EnterFragment;
import com.example.main.R;

/**
 * Created by panda on 2017/5/7.
 */

public class FragmentAnimationActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtEnter;
    private Button mBtExit;
    private FragmentManager mFragmentManager;
    private EnterFragment mEnterFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        mBtEnter = (Button) findViewById(R.id.bt_enter);
        mBtEnter.setOnClickListener(this);
        mBtExit = (Button) findViewById(R.id.bt_exit);
        mBtExit.setOnClickListener(this);


        initData();
    }

    private void initData() {
        mFragmentManager = getSupportFragmentManager();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_enter:
                handleBtEnterClicked();
                break;
            case R.id.bt_exit:
                handleBtExitClicked();
                break;
        }
    }

    private void handleBtExitClicked() {
        if(mEnterFragment != null){
            mFragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .setCustomAnimations(R.anim.h_fragment_enter, R.anim.h_fragment_exit, R.anim.h_fragment_pop_enter, R.anim.h_fragment_pop_exit)
                    .remove(mEnterFragment).commitAllowingStateLoss();
            mEnterFragment = null;
        }
    }

    private void handleBtEnterClicked() {
        if (mEnterFragment == null) {
            mEnterFragment = new EnterFragment();
            mFragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .setCustomAnimations(R.anim.h_fragment_enter, R.anim.h_fragment_exit, R.anim.h_fragment_pop_enter, R.anim.h_fragment_pop_exit)
                    .add(R.id.fl_container, mEnterFragment)/*.addToBackStack(null)*/.commitAllowingStateLoss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mEnterFragment = null;
    }
}

