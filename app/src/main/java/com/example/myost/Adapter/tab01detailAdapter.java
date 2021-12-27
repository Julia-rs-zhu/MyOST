package com.example.myost.Adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myost.DTO.tab01detailContent;
import com.example.myost.R;

import java.util.List;

public class tab01detailAdapter extends RecyclerView.Adapter<tab01detailAdapter.tab01detailViewHolder> {
    private Context context;   //上下文
    private List<tab01detailContent> tab01Data2;   //展示聊天列表的list数组
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

    public tab01detailAdapter(Context context, List<tab01detailContent> tab01Data2) {
        this.context = context;
        this.tab01Data2 = tab01Data2;
    }


    @NonNull
    @Override
    public tab01detailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.detail_tab01, parent, false);
        return new tab01detailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull tab01detailViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tab01detailAvaterView.setImageResource(tab01Data2.get(position).gettab01detailAvaterId());
        holder.tab01detaiContentView.setText(tab01Data2.get(position).gettab01detailContent());
        holder.tab01detailTimeView.setText(tab01Data2.get(position).gettab01detailTime());


    }

    @Override
    public int getItemCount() {
        return tab01Data2 == null ? 0 : tab01Data2.size();
    }

    //根据位置删除wechatDate里的数据
    public void onRemoveItem(int position) {
        if (position < 0 || position > getItemCount()) {
            return;
        }

        tab01Data2.remove(position);
        notifyItemRemoved(position);
        /*如果移除的是最后一个，忽略。
         * 避免下标错误
         * */
        if (position != tab01Data2.size()) {
            notifyItemRangeChanged(position, tab01Data2.size() - position);
        }
    }


    public class tab01detailViewHolder extends RecyclerView.ViewHolder {
        TextView tab01detaiContentView, tab01detailTimeView;
        ImageView tab01detailAvaterView;


        public tab01detailViewHolder(@NonNull View itemView) {
            super(itemView);
            tab01detailAvaterView = itemView.findViewById(R.id.detail_img);
            tab01detaiContentView = itemView.findViewById(R.id.detail_content);
            tab01detailTimeView = itemView.findViewById(R.id.detail_time);

        }
    }

}