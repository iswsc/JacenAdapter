package com.iswsc.jacenadapter;

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
        final JacenAllAdapter adapter = new JacenAllAdapter(this,new UserInfoAllDataItem(),new UserInfoAllData2Item(),new UserInfoAllData3Item());
        adapter.addData(new UserInfoBean("1"));
        adapter.addData(new UserInfoBean2("2"));
        adapter.addData(new UserInfoBean3("3"));

//        adapter.updateList(new ArrayList<IViewItem>(list));
        adapter.updateList2(list);
        mRecyclerView.setAdapter(adapter);
        List<TextView> aaa= new ArrayList<>();
        asd(aaa);
    }

    private <T extends View>void asd(List<T> list){

    }

}
