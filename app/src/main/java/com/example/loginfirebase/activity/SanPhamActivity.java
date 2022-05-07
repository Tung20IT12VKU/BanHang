package com.example.loginfirebase.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginfirebase.R;
import com.example.loginfirebase.adapter.SanPhamAdapter;
import com.example.loginfirebase.interfaces.IClickItemSanPhamListener;
import com.example.loginfirebase.model.DanhMuc;
import com.example.loginfirebase.model.SanPham;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SanPhamActivity extends AppCompatActivity {
    private TextView textView;
    private RecyclerView recyclerView;
    private ArrayList<SanPham> sanPhamArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham);
        textView = findViewById(R.id.tv);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null) return;
        DanhMuc danhMuc = (DanhMuc) bundle.get("object_danhmuc");
        textView.setText(danhMuc.getTendanhmuc());
//        String i = String.valueOf(danhMuc.getId());

        recyclerView = findViewById(R.id.recyclersanpham);
        sanPhamArrayList = new ArrayList<>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        switch (danhMuc.getId())
        {
            case 1:
                GetSanPham("ThoiTrangNam");
                break;
            case 2:
                GetSanPham("DienThoai");
                break;
            case 3:
                GetSanPham("MayTinh");
                break;
            case 4:
                GetSanPham("DongHo");
                break;
        }
    }

    private void OnclickItemSanPham(SanPham sanPham) {
        Intent intent = new Intent(SanPhamActivity.this, ChiTietSanPhamActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_sanpham", sanPham);
        intent.putExtras(bundle);
        startActivity(intent);
//        finish();
    }

    private void GetSanPham(String tenSp) {
//        sanPhamArrayList.clear();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();
        databaseReference.child("SanPham").child(tenSp).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    SanPham sanPham = dataSnapshot.getValue(SanPham.class);
                    sanPhamArrayList.add(sanPham);
                }
                SanPhamAdapter sanPhamAdapter = new SanPhamAdapter(sanPhamArrayList, getApplicationContext(), new IClickItemSanPhamListener() {
                    @Override
                    public void onClickItemSanPham(SanPham sanPham) {
                        OnclickItemSanPham(sanPham);
                    }
                });
                recyclerView.setAdapter(sanPhamAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}