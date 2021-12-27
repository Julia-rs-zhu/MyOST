package com.example.myost;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class tab02Fragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    // 获取界面中显示歌曲标题、作者文本框
    TextView title, musicname;
    // 上一曲、播放/暂停、停止、下一曲按钮
    ImageButton last, play, stop, next;
    ImageView photo;

    MediaPlayer mediaPlayer;
    ActivityReceiver activityReceiver;
    public static final String CTL_ACTION = "org.zmj.action.CTL_ACTION";
    public static final String UPDATE_ACTION = "org.zmj.action.UPDATE_ACTION";
    // 定义音乐的播放状态，0x11代表没有播放；0x12代表正在播放；0x13代表暂停
    int status = 0x11;
    String[] titleStrs = new String[] {  "国王排名片尾曲", "大鱼海棠片尾曲", "以你的心诠释我的爱的主题曲", "速度与激情8的片尾曲" };
    String[] musicnameStrs = new String[] { "yama『Oz.』",  "大鱼", "无法诠释", "11" };



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab02, container, false);

        mediaPlayer = new MediaPlayer();
        // 获取程序界面界面中的四个按钮
        last = view.findViewById(R.id.last);
        play = view.findViewById(R.id.play);
        stop = view.findViewById(R.id.stop);
        next = view.findViewById(R.id.next);

        photo = view.findViewById(R.id.photo);
        title = view.findViewById(R.id.title);
        musicname = view.findViewById(R.id.musicname);
        // 为四个按钮的单击事件添加监听器
        last.setOnClickListener(this);
        play.setOnClickListener(this);
        stop.setOnClickListener(this);
        next.setOnClickListener(this);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        activityReceiver = new ActivityReceiver();
        IntentFilter filter = new IntentFilter(UPDATE_ACTION);
        getActivity().getApplicationContext().registerReceiver(activityReceiver, filter);


        Intent intent = new Intent(getActivity(), MusicService.class);

        getActivity().startService(intent);
    }

    // 自定义的BroadcastReceiver，负责监听从Service传回来的广播
    public class ActivityReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            // 获取Intent中的update消息，update代表播放状态
            int update = intent.getIntExtra("update", -1);
            // 获取Intent中的current消息，current代表当前正在播放的歌曲
            int current = intent.getIntExtra("current", -1);
            if (current >= 0)
            {
                title.setText(titleStrs[current]);
                musicname.setText(musicnameStrs[current]);
            }
            switch (update)
            {
                case 0x11:
                    play.setImageResource(R.drawable.play);
                    status = 0x11;
                    break;
                // 控制系统进入播放状态
                case 0x12:
                    // 播放状态下设置使用暂停图标
                    play.setImageResource(R.drawable.pause);
                    // 设置当前状态
                    status = 0x12;
                    break;
                // 控制系统进入暂停状态
                case 0x13:
                    // 暂停状态下设置使用播放图标
                    play.setImageResource(R.drawable.play);
                    // 设置当前状态
                    status = 0x13;
                    break;
            }
        }
    }
    @Override
    public void onClick(View source)
    {
        // 创建Intent
        Intent intent = new Intent("org.zmj.action.CTL_ACTION");
        switch (source.getId())
        {
            // 按下播放/暂停按钮
            case R.id.play:
                intent.putExtra("control", 1);
                break;
            // 按下停止按钮
            case R.id.stop:
                intent.putExtra("control", 2);
                break;
            //上一曲
            case R.id.last:
                intent.putExtra("control", 3);
                break;
            //下一曲
            case R.id.next:
                intent.putExtra("control", 4);
                break;
        }
        // 发送广播，将被Service组件中的BroadcastReceiver接收到
        getActivity().sendBroadcast(intent);
    }
}



