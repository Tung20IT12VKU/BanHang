package com.example.loginfirebase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loginfirebase.R;
import com.example.loginfirebase.model.ThongBao;

import java.util.ArrayList;

public class ThongBaoAdapter extends RecyclerView.Adapter<ThongBaoAdapter.ThongBaoViewHoldel> {
    Context context;
    ArrayList<ThongBao> thongBaos;

    public ThongBaoAdapter(Context context, ArrayList<ThongBao> thongBaos) {
        this.context = context;
        this.thongBaos = thongBaos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ThongBaoViewHoldel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thongbao, parent, false);
        return new ThongBaoViewHoldel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThongBaoViewHoldel holder, int position) {
        ThongBao thongBao = thongBaos.get(position);
        holder.title.setText(thongBao.getTitle());
        holder.chitiet.setText(thongBao.getChitiet());
        Glide.with(context).load(thongBao.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return thongBaos.size();
    }

    public class ThongBaoViewHoldel extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title, chitiet;
        public ThongBaoViewHoldel(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_tb);
            title = itemView.findViewById(R.id.tv_tb);
            chitiet = itemView.findViewById(R.id.tvct_tb);
        }
    }
}
