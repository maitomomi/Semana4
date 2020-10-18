package com.maite.semana4.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maite.semana4.menus.Contacto;
import com.maite.semana4.adaptadores.ContactoAdapter;
import  com.maite.semana4.R;

import java.util.ArrayList;


public class FragmentRecylcerView extends Fragment {
    private RecyclerView ListaMascotas;
    ArrayList<Contacto> contactos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_reciclerview,container,false);

        ListaMascotas = v.findViewById(R.id.ListaMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //    GridLayoutManager glm = new GridLayoutManager(this ,2 );
        ListaMascotas.setLayoutManager(llm);
        inicializardatos();
        inicializarAdaptador();
        return v;

    }

    public void inicializardatos() {
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.gato,"Patas","099999999","5"));
        contactos.add(new Contacto(R.drawable.gato,"Tomy","0989991992","3"));
        contactos.add(new Contacto(R.drawable.ternero,"Seis ","098333254","3"));
        contactos.add(new Contacto(R.drawable.perro,"Chico","093326549","2"));
        contactos.add(new Contacto(R.drawable.perro,"Nina","094556489","1"));
    }
    public ContactoAdapter adaptador;
    public void inicializarAdaptador (){
        //asigan a contacto adaptador a la lista contactos
        adaptador = new ContactoAdapter(contactos,getActivity());
        ListaMascotas.setAdapter(adaptador);

    }
}