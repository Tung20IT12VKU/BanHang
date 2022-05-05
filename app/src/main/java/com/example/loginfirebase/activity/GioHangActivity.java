package com.example.loginfirebase.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loginfirebase.R;
import com.example.loginfirebase.adapter.GioHangAdapter;
import com.example.loginfirebase.fragment.HomeFragment;
import com.example.loginfirebase.model.SanPham;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GioHangActivity extends AppCompatActivity {
    ImageView imageViewback;
    TextView bt_sua;
    RecyclerView recyclerView_giohang;
    ArrayList<SanPham> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        AnhXa();
        recyclerView_giohang.setLayoutManager(new LinearLayoutManager(getBaseContext(),
                LinearLayoutManager.VERTICAL,false));
        GetGioHang();
        imageViewback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        bt_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void GetGioHang() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();
        databaseReference.child("GioHang").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    SanPham sanPham = dataSnapshot.getValue(SanPham.class);
                    arrayList.add(sanPham);
                }
                GioHangAdapter gioHangAdapter = new GioHangAdapter(arrayList, getBaseContext());
                recyclerView_giohang.setAdapter(gioHangAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void AnhXa() {
        imageViewback = findViewById(R.id.iconback);
        recyclerView_giohang = findViewById(R.id.recycler_giohang);
        bt_sua = findViewById(R.id.Bt_sua);
        arrayList = new ArrayList<>();
    }
}