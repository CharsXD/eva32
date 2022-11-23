package com.proyect.eva3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.proyect.eva3.Modelo.Basurero;


import org.json.JSONObject;


import java.util.ArrayList;

public class Ajustes extends AppCompatActivity {
    Button btnVolver;
    FirebaseDatabase database;
    ListView lvUsuarios;
    ArrayList<Basurero> basureros;
    ArrayAdapter<Basurero> adaptadorbasurero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Volver();
            }
        });
        lvUsuarios = (ListView) findViewById(R.id.lvUsuarios);
        basureros = new ArrayList<Basurero>();

        cargarBd();
    }

    public void Volver(){
        Intent i = new Intent(getApplicationContext(),inicio.class);
        startActivity(i);
    }

    private void cargarBd() {
        database = FirebaseDatabase.getInstance();
        DatabaseReference basureroRef = database.getReference("basurero");
        ValueEventListener basureroListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot d: snapshot.getChildren()) {
                    String key = d.child("key").getValue().toString();
                    String nombre = d.child("nombre").getValue().toString();
                    String tamaño = d.child("tamaño").getValue().toString();
                    String porcentaje = d.child("porcentaje").getValue().toString();
                    Basurero a = new Basurero(key,nombre,porcentaje,tamaño);
                    basureros.add(a);
                }
                adaptadorbasurero = new ArrayAdapter<Basurero>(getApplicationContext(), android.R.layout.simple_list_item_1,basureros);
                lvUsuarios.setAdapter(adaptadorbasurero);
                lvUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Basurero a = (Basurero) adapterView.getItemAtPosition(i);
                        Intent intencion = new Intent(getApplicationContext(),modificarEliminarBasurero.class);
                        Gson gson = new Gson();
                        String basurero = gson.toJson(a);
                        intencion.putExtra("basurero",basurero);

                        startActivity(intencion);
                    }
                });


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Un error");
            }
        };
        basureroRef.addValueEventListener(basureroListener);

    }



}