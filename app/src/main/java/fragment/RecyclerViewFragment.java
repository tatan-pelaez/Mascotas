package fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mismascotas.R;

import java.util.ArrayList;

import Adapter.MascotasAdaptador;
import pojo.Mascots;

public class RecyclerViewFragment extends Fragment {
    ArrayList<Mascots> mascotas;
    private RecyclerView listaMascotas;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
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
