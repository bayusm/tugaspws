package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class DisplayFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_form);

        TextView tvAlamat = findViewById(R.id.tv_alamat);
        TextView tvNoHP = findViewById(R.id.tv_no_hp);
        TextView tvEmail = findViewById(R.id.tv_email);
        TextView tvJenisKelamin = findViewById(R.id.tv_jenis_kelamin);
        TextView tvKelas = findViewById(R.id.tv_kelas);
        TextView tvUKM = findViewById(R.id.tv_ukm);

        Bundle bundle = getIntent().getExtras();

        tvAlamat.setText(bundle.getString("alamatValue"));
        tvNoHP.setText(bundle.getString("noHPValue"));
        tvEmail.setText(bundle.getString("emailValue"));
        tvJenisKelamin.setText(bundle.getString("jenisKelaminValue"));
        tvKelas.setText(bundle.getString("kelasValue"));
        tvUKM.setText(bundle.getString("ukmValue"));
    }
}