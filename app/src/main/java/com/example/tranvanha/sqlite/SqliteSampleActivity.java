package com.example.tranvanha.sqlite;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class SqliteSampleActivity  extends Activity {
    EditText edtmasp;
    EditText edttensp;
    EditText edtgiatien;
    Button btnluu, btnview;
    RecyclerView recyclerView;
    ArrayList<Sanpham> list = new ArrayList<>();
    MyDatabase myDatabase = new MyDatabase(this, "", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_insert);


        edtmasp = (EditText) findViewById(R.id.edt_masp);
        edttensp = (EditText) findViewById(R.id.edt_tensp);
        edtgiatien = (EditText) findViewById(R.id.edt_giatien);
        btnluu = (Button) findViewById(R.id.btn_luu);
        btnview = (Button) findViewById(R.id.btn_view);
        recyclerView=(RecyclerView) findViewById(R.id.recyclerview) ;



        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabase.insertSanpham(edtmasp.getText().toString(), edttensp.getText().toString(), Integer.parseInt(edtgiatien.getText().toString()));
                edtmasp.setText("");
                edttensp.setText("");
                edtgiatien.getText().clear();


            }
        });
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Sanpham> list = myDatabase.getSanpham1();
                CustomAdapter adapter=new CustomAdapter(this,R.layout.item_recyclerview,list);
//                for (int i = 0; i < list.size(); i++) {
//                    Log.d("Masp", list.get(i).getMasp());
//                    Log.d("Tensp", list.get(i).getTensp());
//                    Log.d("Giatien", list.get(i).getGiatien() + "");

                }
            }
        });
    }
//    CustomAdapter adapter= new CustomAdapter(this,R.layout.item_recyclerview,list);
}






