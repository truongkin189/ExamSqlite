package com.example.examsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText ten, diem,masv;
    Button them,xoa,sua,btnHt4 ,btnShowAll;
    ListView lv;
     SqliteHelper sqliteHelper;
    SinhVienAdapter sinhVienAdapter;
    ArrayList<SinhVien> arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.list);
        ten = findViewById(R.id.edtTen);
        diem = findViewById(R.id.edtDiem);
        masv = findViewById(R.id.edtMasv);
        them = findViewById(R.id.btnThem);
        xoa = findViewById(R.id.btnXoa);
        sua = findViewById(R.id.btnSua);
        btnHt4 = findViewById(R.id.btnHt4);
        btnShowAll = findViewById(R.id.btnShowAll);

        sqliteHelper = new SqliteHelper(this);
        loadData();
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinhVien sv = new SinhVien();
                sv.ten = ten.getText().toString();
                sv.masv = masv.getText().toString();
                sv.diem = diem.getText().toString();
                if( sv.ten.trim().length()==0 ||  sv.masv.trim().length()==0 ||  sv.diem.trim().length()==0 ){
                    Toast.makeText(MainActivity.this, "Hãy điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else{
                    sqliteHelper.InsertData(sv);
                    loadData();
                    ten.setText("");
                    masv.setText("");
                    diem.setText("");
                    Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
                
            }
        });
        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadData();
            }
        });
        btnHt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDatamax4();
            }
        });
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqliteHelper.Deldata("dtc001");
//                sqliteHelper.Delall();
                Toast.makeText(MainActivity.this, "Xóa sinh viên dtc001 thành công", Toast.LENGTH_SHORT).show();
                loadData();
            }
        });


        // sửa dữ liệu

        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinhVien sv = new SinhVien();
                sv.ten = ten.getText().toString();
                sv.masv = masv.getText().toString();
                sv.diem = diem.getText().toString();
                if( sv.ten.trim().length()==0 ||  sv.masv.trim().length()==0 ||  sv.diem.trim().length()==0 ){
                    Toast.makeText(MainActivity.this, "Hãy điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else{
                    sqliteHelper.UpdateData(sv,"dtc010");
                    loadData();
                    Toast.makeText(MainActivity.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void loadData() {
        ArrayList<SinhVien> arr = sqliteHelper.ShowData();

        SinhVienAdapter sinhVienAdapter = new SinhVienAdapter(this,R.layout.list_item,arr);
        lv.setAdapter(sinhVienAdapter);
    }
    private void loadDatamax4() {
        ArrayList<SinhVien> arr = sqliteHelper.ShowDataMax4();

        SinhVienAdapter sinhVienAdapter = new SinhVienAdapter(this,R.layout.list_item,arr);
        lv.setAdapter(sinhVienAdapter);
    }
}
