package com.example.examsqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SinhVienAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<SinhVien> arrayList;

    public SinhVienAdapter(Context context, int layout, ArrayList<SinhVien> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(layout,viewGroup,false);

        TextView ten = view.findViewById(R.id.tvTen);
        TextView masv = view.findViewById(R.id.tvMasv);
        TextView diem = view.findViewById(R.id.tvDiemTB);

        SinhVien sv = arrayList.get(i);

        ten.setText(sv.getTen());
        masv.setText(sv.getMasv());
        diem.setText(sv.getDiem());

        return view;
    }
}
