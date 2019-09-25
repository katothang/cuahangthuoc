package com.example.tudienthuoc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tudienthuoc.adapter.CustomAdapter;
import com.example.tudienthuoc.model.Thuoc;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class ThuocActivity extends AppCompatActivity {
    private ListView lvThuoc;
    private StorageReference mStorageRef;
    ArrayList<Thuoc> arrThuocs = new ArrayList<>();
    CustomAdapter customAdaper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thuoc);
        lvThuoc = (ListView) findViewById(R.id.lv);
        arrThuocs = new ArrayList<>();

        customAdaper = new CustomAdapter(this, R.layout.row_listview, arrThuocs);
        lvThuoc.setAdapter(customAdaper);

        CustomAdapter customAdaper = new CustomAdapter(this, R.layout.row_listview, arrThuocs);
        lvThuoc.setAdapter(customAdaper);
        loadThuoc();
        lvThuoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                DatabaseReference DeleteReference = FirebaseDatabase.getInstance().getReference("Thuoc").child(arrThuocs.get(i).getId());
                DeleteReference.removeValue();
                Toast.makeText(getApplicationContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
                loadThuoc();
                return false;
            }
        });

    }

    private void loadThuoc() {
        arrThuocs.clear();
        customAdaper = new CustomAdapter(this, R.layout.row_listview, arrThuocs);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Thuoc/");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot item:dataSnapshot.getChildren())
                {
                    Thuoc thuoc = new Thuoc();
                    thuoc = item.getValue(Thuoc.class);
                    thuoc.setId(item.getKey());
                    arrThuocs.add(thuoc);
                }
                customAdaper.notifyDataSetChanged();
                lvThuoc.setAdapter(customAdaper);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
