package com.example.tudienthuoc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.tudienthuoc.adapter.CustomAdapter;
import com.example.tudienthuoc.model.Thuoc;

import java.util.ArrayList;

public class ThuocCuaToiActivity extends AppCompatActivity {
    private ListView lvThuocCuaToi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thuoc_cua_toi);
        lvThuocCuaToi = (ListView) findViewById(R.id.lv);
        ArrayList<Thuoc> arrThuocs = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            arrThuocs.add(new Thuoc("ten thuoc "+ i, "http://hinhnendepnhat.net/wp-content/uploads/2017/11/Hinh-anh-dep-girl-xinh-de-thuong-nhat-nam-mau-tuat-2018.jpg","abc"));
        }

        CustomAdapter customAdaper = new CustomAdapter(this, R.layout.row_listview, arrThuocs);
        lvThuocCuaToi.setAdapter(customAdaper);
    }
}
