package com.example.latihanmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.latihanmvp.MVPClass.MainPresenterImp;
import com.example.latihanmvp.MVPClass.MainView;

public class MainActivity extends AppCompatActivity implements MainView {
    private EditText etAlas,etTinggi,etPanjang,etLebar;
    private Button btnHitungLuas,btnHitungKeliling;
    private TextView tvHasilLuas,tvHasilKeliling;
    private MainPresenterImp presenterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        etAlas = findViewById(R.id.etAlas);
        etTinggi = findViewById(R.id.etTinggi);
        etPanjang = findViewById(R.id.etPanjang);
        etLebar = findViewById(R.id.etLebar);
        btnHitungKeliling = findViewById(R.id.btn_hitungkel);
        btnHitungLuas = findViewById(R.id.btn_hitung);
        tvHasilKeliling = findViewById(R.id.tvHasilkel);
        tvHasilLuas = findViewById(R.id.tvHasil);
        
        initPresenter();
        btnHitungLuas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double alas = Double.valueOf(etAlas.getText().toString());
                Double tinggi = Double.valueOf(etTinggi.getText().toString());

                presenterImp.hitungLuas(alas,tinggi);
            }
        });

        btnHitungKeliling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double panjang = Double.valueOf(etPanjang.getText().toString());
                Double lebar = Double.valueOf(etLebar.getText().toString());

                presenterImp.hitungKeliling(panjang,lebar);
            }
        });
    }


    private void initPresenter() {
        presenterImp = new MainPresenterImp(this);
    }

    @Override
    public void updateTextHasilLuas(Double luas) {
        tvHasilLuas.setText(luas.toString());

    }

    @Override
    public void updateTextHasilKeliling(Double keliling) {
        tvHasilKeliling.setText(keliling.toString());
    }


}