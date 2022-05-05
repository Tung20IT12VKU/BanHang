package com.example.loginfirebase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loginfirebase.R;
import com.example.loginfirebase.model.SanPham;

import java.util.ArrayList;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.GioHangViewHolder> {
    ArrayList<SanPham> sanPhamArrayList;
    Context context;

    public GioHangAdapter(ArrayList<SanPham> sanPhamArrayList, Context context) {
        this.sanPhamArrayList = sanPhamArrayList;
        this.context = context;
//        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GioHangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_giohang, parent, false);
        GioHangAdapter.GioHangViewHolder viewHolder = new GioHangAdapter.GioHangViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GioHangViewHolder holder, int position) {
        SanPham sanPham = sanPhamArrayList.get(position);
        if (sanPham == null) return;
        holder.textView.setText(sanPham.getTenSanpham());
        Glide.with(context).load(sanPham.getImageSanpham()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return sanPhamArrayList.size();
    }

    public class GioHangViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        ImageView imageView;
        TextView textView;
        public GioHangViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkbox_giohang);
            imageView = itemView.findViewById(R.id.image_sp_giohang);
            textView = itemView.findViewById(R.id.tv_loaiSp_goihang);
        }
    }
}
