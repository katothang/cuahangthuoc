package com.example.tudienthuoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tudienthuoc.adapter.CustomAdapter;
import com.example.tudienthuoc.model.Thuoc;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class LoaiThuocActivity extends AppCompatActivity {
    private ListView lvLoaiThuoc;
    private StorageReference mStorageRef;
    ArrayList<Thuoc> arrThuocs = new ArrayList<>();
    CustomAdapter customAdaper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loai_thuoc);


        lvLoaiThuoc = (ListView) findViewById(R.id.lv);
        customAdaper = new CustomAdapter(this, R.layout.row_listview, arrThuocs);
        lvLoaiThuoc.setAdapter(customAdaper);
        loadThuoc();
        lvLoaiThuoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(LoaiThuocActivity.this,ThuocActivity.class);
                startActivity(intent);
            }
        });

    }

    private void loadThuoc() {
        arrThuocs.clear();
        customAdaper = new CustomAdapter(this, R.layout.row_listview, arrThuocs);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("LoaiThuoc/");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot item:dataSnapshot.getChildren())
                {

                    Thuoc thuoc = new Thuoc();
                    thuoc = item.getValue(Thuoc.class);
                    arrThuocs.add(thuoc);

                }

                customAdaper.notifyDataSetChanged();
                lvLoaiThuoc.setAdapter(customAdaper);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
