package com.example.myost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myost.Adapter.Myadapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity4 extends AppCompatActivity {
    RecyclerView recyclerView;
    private ArrayList<HashMap<String,Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        MyDao myDao=new MyDao(this);
        myDao.delAll();
        myDao.put();
        myDao.update();
        TextView textView=findViewById(R.id.textView);
        textView.setText("数据库记录数量是："+myDao.getCount());
        recyclerView=findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        list=new ArrayList<>();
        list=myDao.selectAll();
        Myadapter myadapter=new Myadapter(this,list);
        recyclerView.setAdapter(myadapter);
    }
}