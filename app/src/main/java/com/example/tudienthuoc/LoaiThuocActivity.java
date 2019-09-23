package com.example.tudienthuoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tudienthuoc.adapter.CustomAdapter;
import com.example.tudienthuoc.model.Thuoc;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class LoaiThuocActivity extends AppCompatActivity {
    private ListView lvLoaiThuoc;
    private StorageReference mStorageRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loai_thuoc);


        lvLoaiThuoc = (ListView) findViewById(R.id.lv);
        ArrayList<Thuoc> arrThuocs = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            arrThuocs.add(new Thuoc("Loai Thuoc  "+ i, "http://hinhnendepnhat.net/wp-content/uploads/2017/11/Hinh-anh-dep-girl-xinh-de-thuong-nhat-nam-mau-tuat-2018.jpg","Đây là thuốc độc rất độc uống chết cmn mày"));
        }

        CustomAdapter customAdaper = new CustomAdapter(this, R.layout.row_listview, arrThuocs);
        lvLoaiThuoc.setAdapter(customAdaper);

        lvLoaiThuoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(LoaiThuocActivity.this,ThuocActivity.class);
                startActivity(intent);
            }
        });

    }
}
