package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class FormActivity extends AppCompatActivity {

    TextInputEditText inputAlamat, inputNoHP, inputEmail;
    RadioGroup radioJenisKelamin;
    Spinner spinnerKelas;
    CheckBox cbAMCC, cbHIMSSI, cbKOMA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        inputAlamat = findViewById(R.id.input_alamat);
        inputNoHP = findViewById(R.id.input_no_hp);
        inputEmail = findViewById(R.id.input_email);
        radioJenisKelamin = findViewById(R.id.radio_jenis_kelamin);
        spinnerKelas = findViewById(R.id.spinner_kelas);
        cbAMCC = findViewById(R.id.cb_amcc);
        cbHIMSSI = findViewById(R.id.cb_himssi);
        cbKOMA = findViewById(R.id.cb_koma);

        findViewById(R.id.btn_simpan_form).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String alamatValue = inputAlamat.getText().toString();
                if (alamatValue.isEmpty()) {
                    Toast.makeText(getApplication(), "Alamat harus diisi", Toast.LENGTH_SHORT).show();
                    return;
                }

                String noHPValue = inputNoHP.getText().toString();
                if (noHPValue.isEmpty()) {
                    Toast.makeText(getApplication(), "No HP harus diisi", Toast.LENGTH_SHORT).show();
                    return;
                }

                String emailValue = inputEmail.getText().toString();
                if (emailValue.isEmpty()) {
                    Toast.makeText(getApplication(), "Email harus diisi", Toast.LENGTH_SHORT).show();
                    return;
                }

                int idCheckedJenisKelamin = radioJenisKelamin.getCheckedRadioButtonId();
                if (idCheckedJenisKelamin == -1) {
                    Toast.makeText(getApplication(), "Jenis kelamin harus diisi", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton checkedRadioJenisKelamin = findViewById(idCheckedJenisKelamin);
                String jenisKelaminValue = checkedRadioJenisKelamin.getText().toString();

                String kelasValue = spinnerKelas.getSelectedItem().toString();

                String ukmValue = "";
                if (cbAMCC.isChecked()) {
                    ukmValue += cbAMCC.getText().toString();
                }
                if (cbHIMSSI.isChecked()) {
                    if (!ukmValue.isEmpty())
                        ukmValue += ",";
                    ukmValue += cbHIMSSI.getText().toString();
                }
                if (cbKOMA.isChecked()) {
                    if (!ukmValue.isEmpty())
                        ukmValue += ",";
                    ukmValue += cbKOMA.getText().toString();
                }

                Bundle bundle = new Bundle();
                bundle.putString("alamatValue", alamatValue);
                bundle.putString("noHPValue", noHPValue);
                bundle.putString("emailValue", emailValue);
                bundle.putString("jenisKelaminValue", jenisKelaminValue);
                bundle.putString("kelasValue", kelasValue);
                bundle.putString("ukmValue", ukmValue);

                startActivity(new Intent(FormActivity.this, DisplayFormActivity.class).putExtras(bundle));
            }
        });
    }
}