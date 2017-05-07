package com.edus;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.main.R;
import com.edus.utils.DensityUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mLvContent;
    private Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLvContent = (ListView) findViewById(R.id.lv_content);
        mAdapter = new Adapter(this);
        mLvContent.setAdapter(mAdapter);
        initData();
    }

    private void initData() {
        List<ItemInfo> list = new ArrayList<>();
        ItemInfo info = new ItemInfo("布局中存在fragment", new Intent(this, ViewInnerFragmentActivity.class));
        list.add(info);
        info = new ItemInfo("手工添加fragment", new Intent(this, ProgramFragmentActivity.class));
        list.add(info);
        info = new ItemInfo("ViewPager+FragmentAdapter", new Intent(this, ViewPagerFragmentActivity.class));
        list.add(info);
        info = new ItemInfo("ViewPager+FragmentStatedAdapter", new Intent(this, ViewPagerFragmentStatedActivity.class));
        list.add(info);
        info = new ItemInfo("Fragment动画", new Intent(this, FragmentAnimationActivity.class));
        list.add(info);
        mAdapter.setDataList(list);
    }


    private class Adapter extends BaseAdapter{
        private List<ItemInfo> mDataList;
        private Context mContext;
        private LayoutInflater mInflater;
        private final int mPadding;

        public Adapter(Context context){
            mContext = context;
            mDataList = new ArrayList<>();
            mInflater = LayoutInflater.from(mContext);
            mPadding = DensityUtils.dp2Px(mContext, 10);
        }

        public void setDataList(List<ItemInfo> list){
            mDataList.clear();
            if(list != null && !list.isEmpty()){
                mDataList.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mDataList.size();
        }

        @Override
        public ItemInfo getItem(int position) {
            return mDataList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = null;
            if(convertView == null){
               textView = new TextView(mContext);
                textView.setPadding(mPadding, mPadding, mPadding, mPadding);
            }else{
                textView = (TextView) convertView;
            }
            final ItemInfo itemInfo = mDataList.get(position);
            textView.setText(itemInfo.text);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(itemInfo.intent != null){
                        mContext.startActivity(itemInfo.intent);
                    }
                }
            });

            return textView;
        }
    }

    private class ItemInfo{
        String text;
        Intent intent;

        public ItemInfo(String text, Intent intent){
            this.text = text;
            this.intent = intent;
        }
    }
}
