package com.iswsc.jacenadapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iswsc.jacenadapter.bean.UserInfoBean;
import com.iswsc.jacenadapter.bean.UserInfoBean2;
import com.iswsc.jacenadapter.bean.UserInfoBean3;
import com.iswsc.jacenadapter.item.UserInfoAllData2Item;
import com.iswsc.jacenadapter.item.UserInfoAllData3Item;
import com.iswsc.jacenadapter.item.UserInfoAllDataItem;
import com.iswsc.jacenmultiadapter.BaseViewHolder;
import com.iswsc.jacenmultiadapter.BaseViewItem;
import com.iswsc.jacenmultiadapter.IViewItem;
import com.iswsc.jacenmultiadapter.JacenAdapter;
import com.iswsc.jacenmultiadapter.JacenAllAdapter;
import com.iswsc.jacenmultiadapter.OnItemClickListener;
import com.iswsc.jacenmultiadapter.SimpleItem;
import com.iswsc.jacenmultiadapter.SimpleViewItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    JacenAdapter<UserInfoBean> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView mRecyclerView = findViewById(R.id.mRecyclerView);

        mAdapter = new JacenAdapter<>(this, new SimpleItem<UserInfoBean>(R.layout.item_text) {

            @Override
            public void onBindViewHolder(BaseViewHolder holder, UserInfoBean data, int position) {
                holder.setText(R.id.content,data.getUserInfo());
            }

            @Override
            public int[] addOnClickViewIds() {
                return new int[]{R.id.content};
            }

            @Override
            public void onViewClick(View view, UserInfoBean data, int position) {
                startActivity(new Intent(context,data.getClazz()));
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.addData(new UserInfoBean("JacenAdapter",JacenAdapterActivity.class));
        mAdapter.addData(new UserInfoBean("JacenAllAdapterActivity",JacenAllAdapterActivity.class));
    }

}
