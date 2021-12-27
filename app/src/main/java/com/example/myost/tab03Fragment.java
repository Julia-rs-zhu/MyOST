package com.example.myost;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class tab03Fragment extends Fragment {


    public tab03Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab03, container, false);
    }
//    public class FcircleCard {
//        public int touxiangid; // 头像id
//        public String name; //昵称
//        public String text; //文本
//        public FcircleCard(){
//            this.touxiangid=touxiangid;
//            this.name=name;
//            this.text=text;
//        }
//        public String getName(){
//            return name;
//        }
//        public int getTouxiangid(){
//            return touxiangid;
//        }
//        public String getText(){return text;}
//    }
//public class FcircleAdapter extends RecyclerView.Adapter<FcircleAdapter.MyViewHolder> {
//    private Context context;
//    public  View itemView;
//    ArrayList<FcircleCard> list=new ArrayList<>();
//    //构造函数
//    public FcircleAdapter(Context context, ArrayList<FcircleCard> list) {
//        this.context=context;
//        this.list=list;
//    }
//
//    //创建ViewHolder,返回每一项的布局
//    @NonNull
//    @Override
//    public FcircleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        itemView= LayoutInflater.from(context).inflate(R.layout.fcircle,parent,false);
//        MyViewHolder myViewHolder=new MyViewHolder(itemView);
//        return myViewHolder;
//    }
//
//    //将数据与 item 视图进行绑定
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        FcircleCard fcircleCard=list.get(position);
//        //绑定item每一个控件对应的数据
//        holder.imageView1.setImageResource(fcircleCard.getTouxiangid());
//        holder.textView1.setText(fcircleCard.name);
//        holder.textView2.setText(fcircleCard.text);
//    }
//    //返回item总条数
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    //内部类，绑定控件
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        private ImageView imageView1;
//        private TextView textView1,textView2;
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            imageView1=itemView.findViewById(R.id.imageView_touxiang);
//            textView1=itemView.findViewById(R.id.textView_name);
//            textView2=itemView.findViewById(R.id.textView_wenben);
//        }
//    }
//}
}