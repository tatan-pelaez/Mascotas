package com.example.mismascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascots> mascotas;
    private RecyclerView listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void irSegundaActividad(View v){
        Intent inte = new Intent(this,Mascotas_Favoritas.class);
        startActivity(inte);
    }

    public void inicializarAdaptador(){
        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascots("Lucas",R.drawable.adorable_perro_sentado_dibujos_animados_74769_13,"5"));
        mascotas.add(new Mascots("Copito",R.drawable.c2b775993bc259703cc20f244091a84e,"3"));
        mascotas.add(new Mascots("Naruto",R.drawable.el_gato_de_pinocho_figaro_nombre_gato_dibujo_animado_300x300_1,"3"));
        mascotas.add(new Mascots("Simon",R.drawable.perro1,"3"));
        mascotas.add(new Mascots("Winstong",R.drawable.f36883f77619c6563f50ebf0a3f89c2e,"4"));
    }
}