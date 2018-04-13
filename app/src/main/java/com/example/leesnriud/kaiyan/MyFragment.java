package com.example.leesnriud.kaiyan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class MyFragment extends Fragment {

    private RecyclerView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, null);
        lv = (RecyclerView) view.findViewById(R.id.lv);

        //检查title
        initView(view);

        // 创建线性布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //布局管理器
        lv.setLayoutManager(layoutManager);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            list.add(i + "");
        }
        lv.setAdapter(new MyAdapter(list));
        return view;
    }

    private void initView(View view) {
        String title= (String) getArguments().get("title");
        Log.e("title",title);
        //预加载导致作品只会打印一次（中间位置）
    }
}
