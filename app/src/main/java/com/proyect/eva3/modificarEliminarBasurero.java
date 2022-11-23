package com.proyect.eva3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.proyect.eva3.Modelo.Basurero;

public class modificarEliminarBasurero extends AppCompatActivity {
    EditText et2Nombre,etPorcentaje,etTamaño,etNombreModificar,etPorcentajeModificar,etTamañojeModificar;
    FirebaseDatabase database;
    Basurero d;
    Button btnModificar,btnEliminar,btnVolver2;
    ListView lvUsuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_eliminar_basurero);


        obtenerBasurero();
        cargarBasurero();
        btnVolver2= (Button) findViewById(R.id.btnVolver2);
        btnVolver2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Volver();
            }
        });



    }
    public void obtenerBasurero(){
        Bundle b = this.getIntent().getExtras();
        String basureroString = b.getString("basurero");
        Gson gson = new Gson();
        this.d = (Basurero) gson.fromJson(basureroString,Basurero.class);
        System.out.println(this.d.nombre);
    }
    public void cargarBasurero(){
        et2Nombre = (EditText) findViewById(R.id.etNombreModificar);
        etPorcentaje = (EditText) findViewById(R.id.etPorcentajeModificar);
        etTamaño = (EditText) findViewById(R.id.etTamañojeModificar);
        btnModificar = (Button) findViewById(R.id.btnModificar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        //System.out.println("NOMBRE: "+this.d.nombre);
        et2Nombre.setText(this.d.nombre);
        etPorcentaje.setText(this.d.porcentaje);
        etTamaño.setText(this.d.tamaño);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = FirebaseDatabase.getInstance();
                DatabaseReference basureroRef = database.getReference("basurero");

                basureroRef.child(d.getKey()).removeValue();


                Toast.makeText(modificarEliminarBasurero.this, "se logro", Toast.LENGTH_SHORT).show();
            }
        });

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = FirebaseDatabase.getInstance();
                DatabaseReference basureroRef = database.getReference("basurero");
                d.setNombre(et2Nombre.getText().toString().trim());
                d.setPorcentaje(etPorcentaje.getText().toString().trim());
                d.setTamaño(etTamaño.getText().toString().trim());

                basureroRef.child(d.getKey()).setValue(d);


                Toast.makeText(modificarEliminarBasurero.this, "se logro", Toast.LENGTH_SHORT).show();
            }
        });





    }
    public void Volver(){
        Intent i = new Intent(getApplicationContext(),inicio.class);
        startActivity(i);

    }











}


