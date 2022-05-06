package com.example.loginfirebase.activity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.loginfirebase.R;
import com.example.loginfirebase.adapter.SanPhamAdapter;
import com.example.loginfirebase.interfaces.IClickItemSanPhamListener;
import com.example.loginfirebase.model.SanPham;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChiTietSanPhamActivity extends AppCompatActivity {
    ImageView back,imageViewSp;
    ImageButton btn_left, btn_right;
    TextView loaisanpham,tv_soluong, textView_giaSp;
    Button btn_ThemGioHang,btn_MuaHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AnhXa();

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        SanPham sanPham = (SanPham) bundle.get("object_sanpham");

        Glide.with(getBaseContext()).load(sanPham.getImageSanpham()).into(imageViewSp);
        loaisanpham.setText(sanPham.getTenSanpham());
        textView_giaSp.setText(sanPham.getGiaSanpham()+"00Đ");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = Integer.parseInt(tv_soluong.getText().toString());
                i += 1;
                tv_soluong.setText(i+"");
            }
        });

        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soluong  = Integer.parseInt(String.valueOf(tv_soluong.getText()));
                if (soluong == 0) return;
                soluong -= 1;
                tv_soluong.setText(String.valueOf(soluong));
            }
        });

        btn_ThemGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("GioHang");
                String gioHang = mDatabase.push().getKey();
                sanPham.setKey(gioHang);
                mDatabase.child(gioHang).setValue(sanPham);
                Toast.makeText(ChiTietSanPhamActivity.this, "Thêm giỏ hàng thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btn_MuaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private void AnhXa() {
        setContentView(R.layout.activity_chi_tiet_san_pham);
        back = findViewById(R.id.icon_back);
        imageViewSp = findViewById(R.id.image_chitietSp);
        btn_left = findViewById(R.id.Btn_left);
        btn_right = findViewById(R.id.Btn_right);
        loaisanpham = findViewById(R.id.loaiSp);
        textView_giaSp = findViewById(R.id.tv_giaSp);
        tv_soluong = findViewById(R.id.soluong);
        btn_ThemGioHang = findViewById(R.id.Btn_themgiohang);
        btn_MuaHang = findViewById(R.id.Btn_muahang);
    }
}