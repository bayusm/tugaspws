package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BiodataActivity extends AppCompatActivity {

    TextView tvNamaValue, tvNimValue, tvProdiValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);

        tvNamaValue = findViewById(R.id.tvNamaValue);
        tvNimValue = findViewById(R.id.tvNimValue);
        tvProdiValue = findViewById(R.id.tvProdiValue);

        //Opsi 1
        Bundle bundle = getIntent().getExtras();
        tvNamaValue.setText(bundle.getString("keyNama"));
        tvNimValue.setText(bundle.getString("keyNim"));
        tvProdiValue.setText(bundle.getString("keyProdi"));

        //Opsi 2
//        Intent data = getIntent();
//        String nama = data.getStringExtra("keyNama");
//        String nim = data.getStringExtra("keyNim");
//        String prodi = data.getStringExtra("keyProdi");
//
//        tvNamaValue.setText(nama);
//        tvNimValue.setText(nim);
//        tvProdiValue.setText(prodi);

        findViewById(R.id.btn_isi_form).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BiodataActivity.this, FormActivity.class));
            }
        });
    }
}