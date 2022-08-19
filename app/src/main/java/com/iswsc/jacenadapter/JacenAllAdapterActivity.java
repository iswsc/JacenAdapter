package com.iswsc.jacenadapter;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.iswsc.jacenadapter.bean.UserInfoBean;
import com.iswsc.jacenadapter.bean.UserInfoBean2;
import com.iswsc.jacenadapter.bean.UserInfoBean3;
import com.iswsc.jacenadapter.databinding.ActivityMainBinding;
import com.iswsc.jacenadapter.item.UserInfoAllData2Item;
import com.iswsc.jacenadapter.item.UserInfoAllData3Item;
import com.iswsc.jacenadapter.item.UserInfoAllDataItem;
import com.iswsc.jacenadapter.item.UserItem;
import com.iswsc.jacenmultiadapter.JacenAdapter;
import com.iswsc.jacenmultiadapter.JacenAllAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacen
 * @date 2022/8/19 2:58 下午
 * @email jacen@iswsc.com
 */
public class JacenAllAdapterActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding ;

    private JacenAllAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mAdapter = new JacenAllAdapter(this, new UserInfoAllDataItem(),new UserInfoAllData2Item(),new UserInfoAllData3Item());
        mBinding.mRecyclerView.setAdapter(mAdapter);
        mAdapter.addData2(makeList(),0);
        mAdapter.addData2(makeList2(),0);
        mAdapter.addData2(makeList3(),0);
//        mAdapter.updateList2(makeList());
    }

    public List<UserInfoBean> makeList(){
        List<UserInfoBean> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new UserInfoBean(" i = " + i));
        }
        return list;
    }
    public List<UserInfoBean2> makeList2(){
        List<UserInfoBean2> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new UserInfoBean2(" i = " + i));
        }
        return list;
    }
    public List<UserInfoBean3> makeList3(){
        List<UserInfoBean3> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new UserInfoBean3(" i = " + i));
        }
        return list;
    }
}
