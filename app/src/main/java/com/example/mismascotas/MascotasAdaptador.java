package com.example.mismascotas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotasAdaptador extends RecyclerView.Adapter<MascotasAdaptador.ContactoViewHolder>{
    ArrayList<Mascots> mascotas;

    public MascotasAdaptador(ArrayList<Mascots> contactos){
        this.mascotas = contactos;
    }

    //inflar el layout y lo pasará al viewholder para que el obtenga los view
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent, false);
        return new ContactoViewHolder(v);
    }


    // asocia cada elemento de la vista con cada view
    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewholder, int position) {
        Mascots contacto = mascotas.get(position);
        contactoViewholder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewholder.tvNombreCV.setText(contacto.getNombre());
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;

        public ContactoViewHolder( View itemView) {
            super(itemView);
            imgFoto         = (ImageView) itemView.findViewById(R.id.fotoMascota);
            tvNombreCV      = (TextView) itemView.findViewById(R.id.textMascota);
        }
    }
}
