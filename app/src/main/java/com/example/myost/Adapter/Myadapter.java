package com.example.myost.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myost.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Myadapter  extends RecyclerView.Adapter<Myadapter.MyViewHolder>{
    private ArrayList<HashMap<String,Object>> list;
    private  View inflater;
    private Context context;

    public Myadapter(Context context, ArrayList<HashMap<String,Object>> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        inflater= LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);
        MyViewHolder myViewHolder=new MyViewHolder(inflater);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView1.setText(list.get(position).get("id").toString());
        holder.textView2.setText(list.get(position).get("name").toString());
        holder.textView3.setText(list.get(position).get("age").toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void onItemDismiss(int adapterPosition) {
        if (adapterPosition < 0 || adapterPosition > getItemCount()) {
            return;
        }
        list.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
        /*如果移除的是最后一个，忽略。
         * 避免下标错误
         * */
        if (adapterPosition != list.size()){
            notifyItemRangeChanged(adapterPosition ,list.size() - adapterPosition);
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1=(TextView)itemView.findViewById(R.id.id);
            textView2=itemView.findViewById(R.id.name);
            textView3=itemView.findViewById(R.id.age);
        }
    }
}