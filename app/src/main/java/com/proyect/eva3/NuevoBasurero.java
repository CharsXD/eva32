package com.proyect.eva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.proyect.eva3.Modelo.Basurero;
import com.proyect.eva3.Modelo.Usuario;

import java.util.Random;
import java.util.UUID;

public class NuevoBasurero extends AppCompatActivity {
    FirebaseDatabase database;
    Button btnConectar,btnVolver3;
    EditText et2Nombre,etPorcentaje,etTamaño;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_basurero);
        et2Nombre = (EditText) findViewById(R.id.et2Nombre);
        etPorcentaje = (EditText) findViewById(R.id.etPorcentaje);
        etTamaño = (EditText)  findViewById(R.id.etTamaño);

        btnConectar = (Button) findViewById(R.id.btnConectar);
        btnConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertar2();
            }
        });

        btnVolver3 = (Button) findViewById(R.id.btnVolver3);
        btnVolver3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertar3();
            }
        });


    }

    public void insertar3(){
        Intent k = new Intent(getApplicationContext(),inicio.class);
        startActivity(k);

    }


    public void insertar2(){
        String nombre = et2Nombre.getText().toString();
        String porcentaje = etPorcentaje.getText().toString();
        String tamaño = etTamaño.getText().toString();
        String key = UUID.randomUUID().toString();
        Basurero c = new Basurero(key,nombre,porcentaje,tamaño);
        Intent i = new Intent(getApplicationContext(),inicio.class);
        startActivity(i);


        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("basurero");
        myRef.child(key).setValue(c);
    }


}