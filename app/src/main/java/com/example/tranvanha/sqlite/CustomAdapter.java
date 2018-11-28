package com.example.tranvanha.sqlite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<Sanpham> arrayList;
    private Context context;
        public CustomAdapter( Context context) {
        this.context=context;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview,viewGroup,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
            myViewHolder.masp.setText(arrayList.get(position).getMasp());
            myViewHolder.tensp.setText(arrayList.get(position).getTensp());
            myViewHolder.giasp.setText(arrayList.get(position).getGiatien());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView masp;
        TextView tensp;
        TextView giasp;
        Button edit;
        Button delete;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        masp= itemView.findViewById(R.id.tv_masp);
        tensp= itemView.findViewById(R.id.tv_tensp);
        giasp= itemView.findViewById(R.id.tv_giasp);
        edit= itemView.findViewById(R.id.btn_edit);
        delete= itemView.findViewById(R.id.btn_delete);
    }
}
}

