package com.example.myost;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myost.Adapter.tab01Adapter;
import com.example.myost.DTO.tab01Content;

import java.util.ArrayList;
import java.util.List;


public class tab01Fragment extends Fragment {
    private List<tab01Content> tab01Data = new ArrayList<>();
    //展示内容的数据集
    private Context context;
    //声明上下文
    private RecyclerView recyclerView;
    //声明recyclerView，在后面onCreateView()函数中通过view.findViewById()进行赋值
    private tab01Adapter tab01Adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab01, container, false);
        recyclerView = view.findViewById(R.id.rv_tab01);
        initData();
        initView();
        return view;
    }

    //初始化View，为RecyclerView配置适配器，管理器，为Adapter设置自定义的监听器
    private void initView() {
        context = this.getActivity();
        tab01Adapter = new tab01Adapter(context,tab01Data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        tab01Adapter.setOnItemOnClickListener(new tab01Adapter.OnItemOnClickListener() {
            @Override
            public void onItemOnClick(View view, int position) {
                Toast.makeText(context, "点击"+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongOnClick(View view, int position) {
                showPopMenu(view,position);
            }
        });

        recyclerView.setAdapter(tab01Adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
    }

    //初始化数据
    private void initData() {
        List<String> nameList = new ArrayList<>();
        nameList.add("那年，我们的夏天");
        nameList.add("大鱼海棠");
        nameList.add("请回答1988");
        nameList.add("以你的心诠释我的爱");
        nameList.add("寻梦环游记CoCo");
        nameList.add("你的名字");
        nameList.add("速度与激情");
        nameList.add("国王排名");

        List<String> timeList = new ArrayList<>();
        timeList.add("小朱收藏");
        timeList.add("小朱收藏");
        timeList.add("小朱收藏");
        timeList.add("小朱收藏");
        timeList.add("小朱收藏");
        timeList.add("小朱收藏");
        timeList.add("小朱收藏");
        timeList.add("小朱收藏");

        List<String> ContentList = new ArrayList<>();
        ContentList.add("电视剧");
        ContentList.add("电影");
        ContentList.add("电视剧");
        ContentList.add("电视剧");
        ContentList.add("电影");
        ContentList.add("电影");
        ContentList.add("电影");
        ContentList.add("动画片");

        List<Integer> AvaterIdList = new ArrayList<>();
        AvaterIdList.add(R.drawable.nanian);
        AvaterIdList.add(R.drawable.dahai);
        AvaterIdList.add(R.drawable.huida);
        AvaterIdList.add(R.drawable.yiai);
        AvaterIdList.add(R.drawable.xunm);
        AvaterIdList.add(R.drawable.nide);
        AvaterIdList.add(R.drawable.sudu);
        AvaterIdList.add(R.drawable.guowang);

        for (int i = 0; i < nameList.size(); i++) {
            tab01Content tab01Content = new tab01Content();
            tab01Content.settab01AvaterId(AvaterIdList.get(i));
            tab01Content.settab01Name(nameList.get(i));
            tab01Content.settab01Content(ContentList.get(i));
            tab01Content.settab01Time(timeList.get(i));
            tab01Data.add(tab01Content);
        }
    }
    public void showPopMenu(View view,final int position) {
        PopupMenu popupMenu = new PopupMenu(context, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_item, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                tab01Adapter.onRemoveItem(position);
                return false;
            }
        });
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
                Toast.makeText(context.getApplicationContext(), "关闭PopupMenu", Toast.LENGTH_SHORT).show();
            }
        });
        popupMenu.show();
    }
}