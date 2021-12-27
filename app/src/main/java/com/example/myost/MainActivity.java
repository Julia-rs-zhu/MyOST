package com.example.myost;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Fragment tab01Fragment=new tab01Fragment();
    private Fragment tab02Fragment=new tab02Fragment();
    private Fragment tab03Fragment=new tab03Fragment();
    private Fragment tab04Fragment=new tab04Fragment();
    private FragmentManager fragmentManager;

    private View LinearLayout1,LinearLayout2,LinearLayout3,LinearLayout4;
    private ImageView imagetab01,imagetab02,imagetab03,imagetab04;
    private TextView textView;
    private View listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.textView2);

        LinearLayout1 = findViewById(R.id.tab_tab01);
        LinearLayout2 = findViewById(R.id.tab_tab02);
        LinearLayout3 = findViewById(R.id.tab_tab03);
        LinearLayout4 = findViewById(R.id.tab_tab04);

        imagetab01 = findViewById(R.id.imageView);
        imagetab02 = findViewById(R.id.imageView1);
        imagetab03 = findViewById(R.id.imageView2);
        imagetab04 = findViewById(R.id.imageView3);

        LinearLayout1.setOnClickListener(this);
        LinearLayout2.setOnClickListener(this);
        LinearLayout3.setOnClickListener(this);
        LinearLayout4.setOnClickListener(this);

        initFragment();
        showfragment(0);

    }
    private void initFragment(){
        fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.content,tab01Fragment);
        transaction.add(R.id.content,tab02Fragment);
        transaction.add(R.id.content,tab03Fragment);
        transaction.add(R.id.content,tab04Fragment);
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(tab01Fragment);
        transaction.hide(tab02Fragment);
        transaction.hide(tab03Fragment);
        transaction.hide(tab04Fragment);
    }


    @Override
    public void onClick(View v) {
        resetImage();
        switch (v.getId()){
            case R.id.tab_tab01:
                showfragment(0);
                break;
            case R.id.tab_tab02:
                showfragment(1);
                break;
            case R.id.tab_tab03:
                showfragment(2);
                break;
            case R.id.tab_tab04:
                showfragment(3);
                break;
            default:
                break;
        }

    }

    private void showfragment(int i){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                textView.setText("TV收藏");
                transaction.show(tab01Fragment);
                imagetab01.setImageResource(R.drawable.tv);
                break;

            case 1:
                textView.setText("OST播放");
                transaction.show(tab02Fragment);
                imagetab02.setImageResource(R.drawable.yinyue);
                break;

            case 2:
                textView.setText("分享圈");
                transaction.show(tab03Fragment);
                imagetab03.setImageResource(R.drawable.fenxiang);
                break;

            case 3:
                textView.setText("个人信息");
                transaction.show(tab04Fragment);
                imagetab04.setImageResource(R.drawable.geren);
                break;

            default:
                break;
        }
        transaction.commit();
    }

    public void resetImage(){
        imagetab01.setImageResource(R.drawable.tv);
        imagetab02.setImageResource(R.drawable.yinyue);
        imagetab03.setImageResource(R.drawable.fenxiang);
        imagetab04.setImageResource(R.drawable.geren);

    }

}