package com.edus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.edus.fragment.ContentFragment;
import com.edus.fragment.TitleFragment;
import com.edus.fragment.ViewFragment;
import com.example.main.R;

/**
 * Created by panda on 2017/4/23.
 */

public class ProgramFragmentActivity extends AppCompatActivity {
    private FrameLayout mFlTitle;
    private FrameLayout mFlContent;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_program);
        mFlTitle = (FrameLayout) findViewById(R.id.fl_title);
        mFlContent = (FrameLayout) findViewById(R.id.fl_content);
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().add(mFlContent.getId(), new ContentFragment())
                .add(mFlTitle.getId(), new TitleFragment()).commitAllowingStateLoss();
    }


}
