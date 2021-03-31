package com.iswsc.jacenadapter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iswsc.jacenmultiadapter.BaseViewHolder;
import com.iswsc.jacenmultiadapter.JacenMultiAdapter;
import com.iswsc.jacenmultiadapter.SimpleItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    JacenMultiAdapter<UserInfoBean> mAdapter;

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
        mAdapter = new JacenMultiAdapter<>(this, list, new SimpleItem<UserInfoBean>(R.layout.item_text) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, UserInfoBean data, int position) {
                holder.setText(R.id.content,data.getUserInfo() + " position = " + position);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }
}
