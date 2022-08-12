package com.iswsc.jacenadapter;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iswsc.jacenadapter.bean.UserInfoBean;
import com.iswsc.jacenadapter.bean.UserInfoBean2;
import com.iswsc.jacenadapter.bean.UserInfoBean3;
import com.iswsc.jacenadapter.item.UserInfoAllData2Item;
import com.iswsc.jacenadapter.item.UserInfoAllData3Item;
import com.iswsc.jacenadapter.item.UserInfoAllDataItem;
import com.iswsc.jacenmultiadapter.AbsBaseViewItem;
import com.iswsc.jacenmultiadapter.BaseViewHolder;
import com.iswsc.jacenmultiadapter.BaseViewItem;
import com.iswsc.jacenmultiadapter.BaseAdapter;
import com.iswsc.jacenmultiadapter.JacenAdapter;
import com.iswsc.jacenmultiadapter.JacenAllAdapter;
import com.iswsc.jacenmultiadapter.JacenMultiAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    JacenAdapter<UserInfoBean> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView mRecyclerView = findViewById(R.id.mRecyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<UserInfoBean> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new UserInfoBean("wsc"));
        }
        mAdapter = new JacenAdapter<>(this, list, new BaseViewItem<UserInfoBean, BaseViewHolder>() {
            @Override
            public int getViewHolderLayoutId() {
                return 0;
            }

            @Override
            public void onBindViewHolder(BaseViewHolder holder, UserInfoBean data, int position) {

            }
        });
        JacenAllAdapter adapter = new JacenAllAdapter(this,new UserInfoAllDataItem(),new UserInfoAllData2Item(),new UserInfoAllData3Item());
        adapter.addData(new UserInfoBean("1"));
        adapter.addData(new UserInfoBean2("2"));
        adapter.addData(new UserInfoBean3("3"));
        mRecyclerView.setAdapter(adapter);
        JacenMultiAdapter<String> asd = new JacenMultiAdapter<>(this, null, new AbsBaseViewItem<String,BaseViewHolder>() {
            @Override
            public int getViewHolderLayoutId() {
                return 0;
            }

            @Override
            public void onBindViewHolder(BaseViewHolder holder, String data, int position) {

            }
        });
    }
}
