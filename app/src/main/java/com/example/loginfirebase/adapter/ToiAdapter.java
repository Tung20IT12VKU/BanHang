package com.example.loginfirebase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginfirebase.R;
import com.example.loginfirebase.interfaces.IClickItemToiListener;
import com.example.loginfirebase.model.Toi;

import java.util.ArrayList;

public class ToiAdapter extends RecyclerView.Adapter<ToiAdapter.ToiViewHolder> {
    ArrayList<Toi> arrayListToi;
    Context context;
    IClickItemToiListener iClickItemToiListener;

    public ToiAdapter(ArrayList<Toi> arrayListToi, Context context, IClickItemToiListener iClickItemToiListener) {
        this.arrayListToi = arrayListToi;
        this.context = context;
        this.iClickItemToiListener = iClickItemToiListener;
//        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ToiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_toi,parent,false);
        ToiViewHolder toiViewHolder = new ToiViewHolder(view);
        return toiViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ToiViewHolder holder, int position) {
        Toi toi = arrayListToi.get(position);
        if(toi == null) return;
        holder.imageView.setImageResource(toi.getImage());
        holder.textView.setText(toi.getTen());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickItemToiListener.OnClickItemToi(toi);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayListToi.size();
    }

    class ToiViewHolder extends RecyclerView.ViewHolder{
        LinearLayout linearLayout;
        ImageView imageView;
        TextView textView;
        public ToiViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.item_linearlayout_toi);
            imageView = itemView.findViewById(R.id.image_toi);
            textView = itemView.findViewById(R.id.textView_toi);
        }
    }
}
