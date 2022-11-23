package com.proyect.eva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class inicio extends AppCompatActivity {
    Button btnBot1,btnNuevo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        btnBot1 = (Button) findViewById(R.id.btnBot1);
        btnNuevo = (Button) findViewById(R.id.btnNuevo);

        btnBot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(inicio.this, "vas a ajustes", Toast.LENGTH_SHORT).show();
                insertar();
            }
        });


        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(inicio.this, "Porfavor configure el nuevo dispositivo", Toast.LENGTH_SHORT).show();
                insertar5();
            }
        });



    }

    public void insertar(){
        Intent i = new Intent(getApplicationContext(),Ajustes.class);
        startActivity(i);
    }



    public void insertar5(){
        Intent h = new Intent(getApplicationContext(),NuevoBasurero.class);
        startActivity(h);
    }




}