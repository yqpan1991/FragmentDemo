package com.edus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.edus.fragment.ViewFragment;
import com.example.main.R;

/**
 * Created by panda on 2017/4/23.
 */

public class ViewInnerFragmentActivity extends AppCompatActivity {
    private ViewFragment mViewFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_inner);
        mViewFragment = (ViewFragment) getSupportFragmentManager().findFragmentById(R.id.vf_fragment);
    }


}
