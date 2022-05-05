package com.example.loginfirebase.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loginfirebase.R;
import com.example.loginfirebase.activity.ChiTietSanPhamActivity;
import com.example.loginfirebase.activity.MainActivity;
import com.example.loginfirebase.interfaces.IClickItemSanPhamListener;
import com.example.loginfirebase.model.SanPham;

import java.util.ArrayList;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.SanPhamViewHolder>{
    private ArrayList<SanPham> sanPhamArrayList;
    private Context context;
    private IClickItemSanPhamListener itemSanPhamListener;

    public SanPhamAdapter(ArrayList<SanPham> sanPhamArrayList, Context context, IClickItemSanPhamListener itemSanPhamListener) {
        this.sanPhamArrayList = sanPhamArrayList;
        this.context = context;
        this.itemSanPhamListener = itemSanPhamListener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanpham, parent, false);
        SanPhamViewHolder viewHolder = new SanPhamViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamViewHolder holder, int position) {
        SanPham sanPham = sanPhamArrayList.get(position);
        if(sanPham == null){
            return;
        }
        holder.textView.setText(sanPham.getTenSanpham());
        Glide.with(context).load(sanPham.getImageSanpham()).into(holder.imageView);
        holder.textViewGia.setText(sanPham.getGiaSanpham()+"00Đ");
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemSanPhamListener.onClickItemSanPham(sanPham);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sanPhamArrayList.size();
    }

    public class SanPhamViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView, textViewGia;
        private LinearLayout linearLayout;
        public SanPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_sanpham);
            textView = itemView.findViewById(R.id.tv_sanpham);
            textViewGia = itemView.findViewById(R.id.gia_sanpham);
            linearLayout = itemView.findViewById(R.id.item_chitietSp);
        }
    }
}
