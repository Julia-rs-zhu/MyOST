package com.example.myost;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class MyDao {
    private MyopenHelper openHelper;
    private SQLiteDatabase database;
    private String name;
    private int id;
    private int age;
    Cursor cursor;
    ArrayList<HashMap<String,Object>> list;


    public MyDao(Context context){
        openHelper=new MyopenHelper(context,"text.db",null,1);
        database=openHelper.getWritableDatabase();
    }

    public void put(){
        database=openHelper.getWritableDatabase();
        ContentValues value1=new ContentValues();
        value1.put("name","Zhang");
        value1.put("age",21);
        database.insert("person",null,value1);
        ContentValues value2=new ContentValues();
        value2.put("name","Roner");
        value2.put("age",18);
        database.insert("person",null,value2);
        ContentValues value3=new ContentValues();
        value3.put("name","Maggie");
        value3.put("age",17);
        database.insert("person",null,value3);
        ContentValues value4=new ContentValues();
        value4.put("name","Amily");
        value4.put("age",19);
        database.insert("person",null,value4);
        ContentValues value5=new ContentValues();
        value5.put("name","Aber");
        value5.put("age",17);
        database.insert("person",null,value5);
    }
    public void update(){
        database = openHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("age", 21);
        database.update("person", cv, "name=?", new String[]{"Aber"});
    }


    public int getCount(){
        database=openHelper.getReadableDatabase();
        String sql="SELECT * FROM person";
        cursor=database.rawQuery(sql,null);
        cursor.moveToFirst();
        int count= cursor.getCount();
        Log.v("zrs","记录数量是："+cursor.getCount());
        cursor.close();
        return count;
    }
    public ArrayList<HashMap<String,Object>> selectAll()
    {
        database=openHelper.getWritableDatabase();
        String sql="SELECT * FROM person";
        cursor=database.rawQuery(sql,null);
        cursor.moveToFirst();
        list=new ArrayList<HashMap<String, Object>>();
        int get1=cursor.getColumnIndex("name");
        int get2=cursor.getColumnIndex("id");
        int get3=cursor.getColumnIndex("age");
        while (!cursor.isAfterLast()){
            if(get1>=0){
                name=cursor.getString(get1);
                Log.d("sqlite",name);
            }
            if(get2>=0){
                id=cursor.getInt(get2);
                Log.d("sqlite", String.valueOf(id));
            }
            if(get3>=0){
                age=cursor.getInt(get3);
                Log.d("sqlite", String.valueOf(age));
            }

            HashMap<String,Object> map=new HashMap<String, Object>();
            map.put("id",id);
            map.put("name",name);
            map.put("age",age);
            list.add(map);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public void delAll(){
        database=openHelper.getWritableDatabase();
        database.delete("person",null,null);
    }
}
