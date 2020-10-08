package com.example.formulario;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edNombre;
    EditText edTel;
    EditText edEmail;
    DatePicker edFechaNac;
    EditText edDesc;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Bundle edit_datos = getIntent().getExtras();

            String nombre = edit_datos.getString("nombre");
            String tel = edit_datos.getString("tel");
            String fechaNac = edit_datos.getString("fechanac");
            String email = edit_datos.getString("email");
            String descripcion = edit_datos.getString("desc");

            edNombre = (EditText) findViewById(R.id.edNombre);
            edTel = (EditText) findViewById(R.id.edTel);
            edEmail = (EditText) findViewById(R.id.edEmail);
            edFechaNac = (DatePicker) findViewById(R.id.dpCalendario);
            edDesc = (EditText) findViewById(R.id.edDesc);

            edNombre.setText(nombre);
            edTel.setText(tel);
            edEmail.setText(email);
            edDesc.setText(descripcion);
            String[] fecha = fechaNac.split("/",0);
            int dia = Integer.valueOf(fecha[0]);
            int mes = Integer.valueOf(fecha[1]);
            int año = Integer.valueOf(fecha[2]);
            edFechaNac.init(año, mes-1, dia, null);

        } catch (Exception e){

        }

        Button btn = (Button) findViewById(R.id.btnSiguiente);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText edNombre = (EditText) findViewById(R.id.edNombre);
                EditText edTel = (EditText) findViewById(R.id.edTel);
                EditText edEmail = (EditText) findViewById(R.id.edEmail);
                DatePicker dpCalendario = (DatePicker) findViewById(R.id.dpCalendario);
                EditText edDesc = (EditText) findViewById(R.id.edDesc);

                Intent intent = new Intent(MainActivity.this, Confirmacion.class);
                intent.putExtra(getResources().getString(R.string.formnombre),edNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.formtel),edTel.getText().toString());
                intent.putExtra(getResources().getString(R.string.formfechanac),dpCalendario.getDayOfMonth() + "/" + Integer.parseInt(String.valueOf(dpCalendario.getMonth()+1)) + "/" + dpCalendario.getYear());
                intent.putExtra(getResources().getString(R.string.formemail),edEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.formdesc),edDesc.getText().toString());

                startActivity(intent);
                finish();

            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();


    }
}