package com.example.tudienthuoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    LinearLayout lnLoaiThuoc,lnPhongKham, lnCongTyDuoc,lnBenhVien, lnNhaThuoc, lnThuocCuaToi,lnThemThuoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        initView();

        //Intent intent = new Intent(HomeActivity.this,ThemThuocActivity.class);
        //startActivity(intent);

        lnLoaiThuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // XỬ CHUYỂN MÀN HÌNH
                Intent intent = new Intent(HomeActivity.this,LoaiThuocActivity.class);
                startActivity(intent);
            }
        });
        lnPhongKham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // XỬ CHUYỂN MÀN HÌNH
                Intent intent = new Intent(HomeActivity.this,PhongKhamActivity.class);
                startActivity(intent);
            }
        });

        lnCongTyDuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // XỬ CHUYỂN MÀN HÌNH
                Intent intent = new Intent(HomeActivity.this,CongTyDuocActivity.class);
                startActivity(intent);
            }
        });

        lnBenhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // XỬ CHUYỂN MÀN HÌNH
                Intent intent = new Intent(HomeActivity.this,BenhVienActivity.class);
                startActivity(intent);
            }
        });

        lnNhaThuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // XỬ CHUYỂN MÀN HÌNH
                Intent intent = new Intent(HomeActivity.this,NhaThuocActivity.class);
                startActivity(intent);
            }
        });

        lnThuocCuaToi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // XỬ CHUYỂN MÀN HÌNH
                Intent intent = new Intent(HomeActivity.this,ThuocCuaToiActivity.class);
                startActivity(intent);
            }
        });

        lnThemThuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // XỬ CHUYỂN MÀN HÌNH
                Intent intent = new Intent(HomeActivity.this,ThemDuLieuActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        lnLoaiThuoc = (LinearLayout) findViewById(R.id.ln_thuoc);
        lnPhongKham = (LinearLayout) findViewById(R.id.ln_phongkham);
        lnCongTyDuoc = (LinearLayout) findViewById(R.id.ln_congtyduoc);
        lnBenhVien = (LinearLayout) findViewById(R.id.ln_benhvien);
        lnNhaThuoc = (LinearLayout) findViewById(R.id.ln_nhathuoc);
        lnThuocCuaToi = (LinearLayout) findViewById(R.id.ln_thuoccuatoi);
        lnThemThuoc = (LinearLayout) findViewById(R.id.ln_themdl);
    }
}
