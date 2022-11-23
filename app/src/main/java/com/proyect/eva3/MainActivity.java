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
import com.proyect.eva3.Modelo.Usuario;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    Button btnAgregar,btnMostrarAlumnos;
    EditText etNombre,etApellido,etCorreo,etContra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        etCorreo = (EditText)  findViewById(R.id.etCorreo);
        etContra = (EditText) findViewById(R.id.etContra);

        btnAgregar = (Button) findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hola", Toast.LENGTH_SHORT).show();
                insertar();
            }
        });


    }

    public void insertar(){
        String nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String correo = etCorreo.getText().toString();
        String Contra = etContra.getText().toString();
        String key = UUID.randomUUID().toString();
        Usuario a = new Usuario(key,correo,nombre,apellido,Contra);
        Intent i = new Intent(getApplicationContext(),inicio.class);
        startActivity(i);

        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Usuario");
        myRef.child(key).setValue(a);
    }



}