package com.iswsc.jacenadapter;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.iswsc.jacenadapter.bean.UserInfoBean;
import com.iswsc.jacenadapter.databinding.ActivityMainBinding;
import com.iswsc.jacenadapter.item.UserItem;
import com.iswsc.jacenmultiadapter.JacenAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacen
 * @date 2022/8/19 2:58 下午
 * @email jacen@iswsc.com
 */
public class JacenAdapterActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding ;

    private JacenAdapter<UserInfoBean> mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
//        mAdapter = new JacenAdapter<>(this, makeList(), new UserItem());
        mAdapter = new JacenAdapter<>(this, new UserItem());
        mBinding.mRecyclerView.setAdapter(mAdapter);
        mAdapter.updateList(makeList());
    }

    public List<UserInfoBean> makeList(){
        List<UserInfoBean> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new UserInfoBean(" i = " + i));
        }
        return list;
    }
}
