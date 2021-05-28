package com.example.mismascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Mascotas_Favoritas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}