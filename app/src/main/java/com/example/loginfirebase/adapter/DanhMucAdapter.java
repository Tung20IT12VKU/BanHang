package com.example.loginfirebase.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loginfirebase.R;
import com.example.loginfirebase.activity.MainActivity;
import com.example.loginfirebase.activity.SanPhamActivity;
import com.example.loginfirebase.model.DanhMuc;

import java.util.ArrayList;

public class DanhMucAdapter extends RecyclerView.Adapter<DanhMucAdapter.DanhMucViewHolder> {
    ArrayList<DanhMuc> listdanhmuc;
    Context context;

    public DanhMucAdapter(ArrayList<DanhMuc> listdanhmuc, Context context) {
        this.listdanhmuc = listdanhmuc;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DanhMucViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_danhmuc, parent, false);
        return new DanhMucViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhMucViewHolder holder, int position) {
        DanhMuc danhMuc = listdanhmuc.get(position);
        if(danhMuc == null){
            return;
        }
//        holder.imagedanhmuc.setImageResource(danhMuc.getImage());
        Glide.with(context).load(danhMuc.getImage()).into(holder.imagedanhmuc);
        holder.textView.setText(danhMuc.getTendanhmuc());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickItemDanhMuc(danhMuc);
            }
        });
    }

    private void OnClickItemDanhMuc(DanhMuc danhMuc) {
        Intent intent = new Intent(context, SanPhamActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_danhmuc", danhMuc);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if(listdanhmuc != null){
            return listdanhmuc.size();
        }
        return 0;
    }

    public class DanhMucViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagedanhmuc;
        private TextView textView;
        private CardView cardView;
        public DanhMucViewHolder(@NonNull View itemView) {
            super(itemView);
            imagedanhmuc = itemView.findViewById(R.id.item_danhmuc_img);
            textView = itemView.findViewById(R.id.item_danhmuc_tv);
            cardView= itemView.findViewById(R.id.layout_item);
        }

    }
}
