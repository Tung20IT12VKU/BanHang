package com.example.loginfirebase.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loginfirebase.R;
import com.example.loginfirebase.interfaces.IClickItemGioHangListener;
import com.example.loginfirebase.model.SanPham;

import java.util.ArrayList;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.GioHangViewHolder> {
    ArrayList<SanPham> sanPhamArrayList;
    Context context;
    IClickItemGioHangListener clickItemGioHangListener;
    public GioHangAdapter(ArrayList<SanPham> sanPhamArrayList, Context context,  IClickItemGioHangListener clickItemGioHangListener) {
        this.sanPhamArrayList = sanPhamArrayList;
        this.context = context;
        this.clickItemGioHangListener = clickItemGioHangListener;
        notifyDataSetChanged();
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
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickItemGioHangListener.OnClickItemGioHang(sanPham);
            }
        });
        holder.constraintLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                clickItemGioHangListener.OnLongClickItemGioHang(sanPham);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return sanPhamArrayList.size();
    }

    public class GioHangViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        ImageView imageView;
        TextView textView;
        ConstraintLayout constraintLayout;
        public GioHangViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkbox_giohang);
            imageView = itemView.findViewById(R.id.image_sp_giohang);
            textView = itemView.findViewById(R.id.tv_loaiSp_goihang);
            constraintLayout = itemView.findViewById(R.id.constrain_giohang);
        }
    }
}
