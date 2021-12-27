package com.example.myost.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myost.DTO.tab01Content;
import com.example.myost.R;
import com.example.myost.details.detail_tab01Activity;

import java.util.List;


public class tab01Adapter extends RecyclerView.Adapter<tab01Adapter.tab01ViewHolder> {
    private Context context;   //上下文
    private List<tab01Content> tab01Data;   //展示聊天列表的list数组
    private LayoutInflater inflater;

    //添加了一个接口
    public interface OnItemOnClickListener {
        void onItemOnClick(View view, int position);

        void onItemLongOnClick(View view, int position);
    }

    private OnItemOnClickListener mOnItemOnClickListener;

    //供外部来设置监听
    public void setOnItemOnClickListener(OnItemOnClickListener listener) {
        this.mOnItemOnClickListener = listener;
    }

    public tab01Adapter(Context context, List<tab01Content> tab01Data) {
        this.context = context;
        this.tab01Data = tab01Data;
    }


    @NonNull
    @Override
    public tab01ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.tab01_content1, parent, false);
        return new tab01ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull tab01ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tab01AvaterView.setImageResource(tab01Data.get(position).gettab01AvaterId());
        holder.tab01NameView.setText(tab01Data.get(position).gettab01Name());
        holder.tab01ContentView.setText(tab01Data.get(position).gettab01Content());
        holder.tab01TimeView.setText(tab01Data.get(position).gettab01Time());

        //在ViewBinder里进行绑定
        if (mOnItemOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "你点击的是：" + tab01Data.get(position).gettab01Name(), Toast.LENGTH_SHORT).show();
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mOnItemOnClickListener.onItemLongOnClick(holder.itemView, position);
                    return false;
                }
            });
        }
        holder.tab01NameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, detail_tab01Activity.class);
                intent.putExtra("name",tab01Data.get(position).gettab01Name());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tab01Data == null ? 0 : tab01Data.size();
    }

    //根据位置删除wechatDate里的数据
    public void onRemoveItem(int position) {
        if (position < 0 || position > getItemCount()) {
            return;
        }

        tab01Data.remove(position);
        notifyItemRemoved(position);
        /*如果移除的是最后一个，忽略。
         * 避免下标错误
         * */
        if (position != tab01Data.size()) {
            notifyItemRangeChanged(position, tab01Data.size() - position);
        }
    }


    public class tab01ViewHolder extends RecyclerView.ViewHolder {
        TextView tab01NameView, tab01ContentView, tab01TimeView;
        ImageView tab01AvaterView;


        public tab01ViewHolder(@NonNull View itemView) {
            super(itemView);
            tab01AvaterView = itemView.findViewById(R.id.tv_avatar);
            tab01NameView = itemView.findViewById(R.id.tv_tab01_name);
            tab01ContentView = itemView.findViewById(R.id.tv_tab01_content);
            tab01TimeView = itemView.findViewById(R.id.tv_tab01_time);

        }
    }

}
