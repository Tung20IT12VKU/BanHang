package com.example.loginfirebase.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginfirebase.R;
import com.example.loginfirebase.adapter.GioHangAdapter;
import com.example.loginfirebase.fragment.HomeFragment;
import com.example.loginfirebase.interfaces.IClickItemGioHangListener;
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

    private void ClickItemGioHang(SanPham sanPham) {
        Intent intent = new Intent(GioHangActivity.this, ChiTietSanPhamActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_sanpham", sanPham);
        intent.putExtras(bundle);
        startActivity(intent);
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
                GioHangAdapter gioHangAdapter = new GioHangAdapter(arrayList, getBaseContext(), new IClickItemGioHangListener() {
                    @Override
                    public void OnClickItemGioHang(SanPham sanPham) {
                        ClickItemGioHang(sanPham);
                    }

                    @Override
                    public void OnLongClickItemGioHang(SanPham sanPham) {
                        ClickLongItemGioHang(sanPham);
                    }
                });
                recyclerView_giohang.setAdapter(gioHangAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void ClickLongItemGioHang(SanPham sanPham) {
//
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Xác nhận");
        dialog.setMessage("Bạn có muốn xóa sản phẩm khỏi giỏ hàng không?");
        dialog.setIcon(R.drawable.ic_person);
        dialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("GioHang");
                mDatabase.child(sanPham.getKey()).removeValue();
                Toast.makeText(GioHangActivity.this, "Xóa Thành công", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(getIntent());
            }
        });
        dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog dialog1 = dialog.create();
        dialog1.show();
    }


    private void AnhXa() {
        imageViewback = findViewById(R.id.iconback);
        recyclerView_giohang = findViewById(R.id.recycler_giohang);
        bt_sua = findViewById(R.id.Bt_sua);
        arrayList = new ArrayList<>();
    }


}