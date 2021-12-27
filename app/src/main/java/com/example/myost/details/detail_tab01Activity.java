package com.example.myost.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myost.Adapter.tab01detailAdapter;
import com.example.myost.DTO.tab01detailContent;
import com.example.myost.R;

import java.util.ArrayList;
import java.util.List;

public class detail_tab01Activity extends AppCompatActivity {
    private List<tab01detailContent> tab01Data2 = new ArrayList<>();
    //展示内容的数据集
    private Context context;
    //声明上下文
    private RecyclerView recyclerView;
    //声明recyclerView，在后面onCreateView()函数中通过view.findViewById()进行赋值
    private tab01detailAdapter tab01detailAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detail_tab01);
        Log.d("life","detail_caoActivity is onCreate...");
        Toast.makeText(this, "detail_caoActivity is onCreate...", Toast.LENGTH_SHORT).show();

        initData();
        initView();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("life","activity3 is onPostResume...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("life","activity3 is onStart...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("life","activity3 is onRestart...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("life","activity3 is onStop...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("life","activity3 is onDestroy...");
    }

    @Override
    public void finish(){
        super.finish();
        Log.d("life","activity3 is finish...");
    }
    @Override
    public void finishActivity(int requestCode){
        super.finishActivity(requestCode);
        Log.d("life","detail_caoActivity...");
    }

    //初始化数据
    private void initData() {

        context = this;
        recyclerView = (RecyclerView) findViewById(R.id.rv_tab01detail);

        TextView textView6 = findViewById(R.id.textView6);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        textView6.setText(name);

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
        ContentList.add("电视剧11111111111");
        ContentList.add("国家地区：中国\n" +
                "发行时间：2016\n" +
                "   所有活着的人类，都是海里一条巨大的鱼；出生的时候他们从海的此岸出发。他们的生命就像横越大海，有时相遇，有时分开……死的时候，他们便到了岸，各去各的世界。\n" +
                "四十五亿年前，这个星球上，只有一片汪洋大海，和一群古老的大鱼。在与人类世界平行的空间里，生活着一个规规矩矩、遵守秩序的族群，他们为神工作，掌管世界万物运行规律，也掌管人类的灵魂。他们的天空与人类世界的大海相连。他们既不是神，也不是人，他们是“其他人”。\n" +
                "十六岁生日那天，居住在“神之围楼”里的一个名叫椿的女孩变作一条海豚到人间巡礼，被大海中的一张网困住，一个人类男孩因为救她而落入深海死去。为了报恩，为了让人类男孩复活，她需要在自己的世界里，历经种种困难与阻碍，帮助死后男孩的灵魂——一条拇指那么大的小鱼，成长为一条比鲸更巨大的鱼并回归大海。");
        ContentList.add("电视剧111111111111");
        ContentList.add("电视剧111111111111");
        ContentList.add("国家地区：Spain\n" +
                "发行时间：2017\n" +
                "　　热爱音乐的米格尔不幸地出生在一个视音乐为洪水猛兽的大家庭之中，一家人只盼着米格尔快快长大，好继承家里传承了数代的制鞋产业。一年一度的亡灵节即将来临，每逢这一天，去世的亲人们的魂魄便可凭借着摆在祭坛上的照片返回现世和生者团圆。\n" +
                "　　在一场意外中，米格尔竟然穿越到了亡灵国度之中，在太阳升起之前，他必须得到一位亲人的祝福，否则就将会永远地留在这个世界里。米格尔决定去寻找已故的歌神德拉库斯，因为他很有可能就是自己的祖父。途中，米格尔邂逅了落魄乐手埃克托，也渐渐发现了德拉库斯隐藏已久的秘密。");
        ContentList.add("歌手：RADWIMPS\n" +
                "发行时间：2016-08-24\n" +
                "　　在远离大都会的小山村，住着巫女世家出身的高中女孩宫水三叶（上白石萌音 配音）。校园和家庭的原因本就让她充满烦恼，而近一段时间发生的奇怪事件，又让三叶摸不清头脑。不知从何时起，三叶在梦中就会变成一个住在东京的高中男孩。那里有陌生的同学和朋友，有亲切的前辈和繁华的街道，一切都是如此诱人而真实。另一方面，住在东京的高中男孩立花泷（神木隆之介 配音）则总在梦里来到陌生的小山村，以女孩子的身份过着全新的生活。许是受那颗神秘彗星的影响，立花和三叶在梦中交换了身份。他们以他者的角度体验着对方的人生，这期间有愤怒、有欢笑也有暖心。只是两人并不知道，身份交换的背后隐藏着重大而锥心的秘密……");
        ContentList.add("国家地区：USA\n" +
                "发行时间：2017\n" +
                "   故事将延续上一部剧情，多米尼克与莱蒂共度蜜月，布莱恩与米娅退出了赛车界，众人的生活渐趋平淡，而查理兹·塞隆饰演的神秘女子Cipher的出现却打乱了所有平静，她引诱多米尼克走上犯罪道路，令整个队伍卷入信任与背叛的危机，生死患难的情义面临瓦解崩溃，前所未有的灾难考验着飞车家族。");
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

        for (int i=0;i<nameList.size();i++){
            if(nameList.get(i).equals(name)) {
                tab01detailContent tab01detailContent = new tab01detailContent();
                tab01detailContent.settab01detailAvaterId(AvaterIdList.get(i));
                tab01detailContent.settab01detailContent(ContentList.get(i));
                tab01detailContent.settab01detailTime(timeList.get(i));
                tab01Data2.add(tab01detailContent);
            }
        }
    }


    //初始化View，为RecyclerView配置适配器，管理器，为Adapter设置自定义的监听器
    private void initView() {
        context = this;
        tab01detailAdapter = new tab01detailAdapter(context,tab01Data2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        tab01detailAdapter.setOnItemOnClickListener(new tab01detailAdapter.OnItemOnClickListener() {
            @Override
            public void onItemOnClick(View view, int position) {
                Toast.makeText(context, "点击"+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongOnClick(View view, int position) {
                showPopMenu(view,position);
            }
        });

        recyclerView.setAdapter(tab01detailAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
    }


    public void showPopMenu(View view,final int position) {
        PopupMenu popupMenu = new PopupMenu(context, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_item, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                tab01detailAdapter.onRemoveItem(position);
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
