package com.maite.semana4.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.maite.semana4.adaptadores.ContactoAdapter;
import com.maite.semana4.R;

import java.util.ArrayList;

public class MisContactos extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    public ContactoAdapter adaptador1;
    private RecyclerView FavoritosMascotas;
    //String like1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_contactos);
        Toolbar tootb = findViewById(R.id.actionbar);
        setSupportActionBar(tootb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tootb.setLogo(R.drawable.pataperro);




       /* Bundle paramentros = getIntent().getExtras();
        int like    = paramentros.getInt("like");
        like1   = String.valueOf(like);*/

        FavoritosMascotas = findViewById(R.id.FavoritosMascotas);
        GridLayoutManager glm = new GridLayoutManager(this ,2 );
        FavoritosMascotas.setLayoutManager(glm);
        inicializardatos();
        inicializarAdaptador();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return (true);
    }
    @Override
    public boolean onKeyDown (int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent= new Intent(MisContactos.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
    public void inicializarAdaptador (){
        //asigan a contacto adaptador a la lista contactos
        adaptador1 = new ContactoAdapter(contactos,this);
        FavoritosMascotas.setAdapter(adaptador1);

    }
    public void inicializardatos() {
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.gato,"Patas","099999999","5"));
        contactos.add(new Contacto(R.drawable.gato,"Tomy","0989991992","3"));
        contactos.add(new Contacto(R.drawable.ternero,"Seis ","098333254","3"));
        contactos.add(new Contacto(R.drawable.perro,"Chico","093326549","2"));
        contactos.add(new Contacto(R.drawable.perro,"Nina","094556489","1"));
    }

}
