package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class Confirmacion extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFechanac;
    private TextView tvTel;
    private TextView tvEmail;
    private TextView tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        Bundle datos_formulario = getIntent().getExtras();

        String nombre = datos_formulario.getString(getResources().getString(R.string.formnombre));
        String fechaNac = datos_formulario.getString(getResources().getString(R.string.formfechanac));
        String tel = datos_formulario.getString(getResources().getString(R.string.formtel));
        String email = datos_formulario.getString(getResources().getString(R.string.formemail));
        String descripcion = datos_formulario.getString(getResources().getString(R.string.formdesc));

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFechanac = (TextView) findViewById(R.id.tvFechaNac);
        tvTel = (TextView) findViewById(R.id.tvTel);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDesc = (TextView) findViewById(R.id.tvDesc);

        tvNombre.setText(nombre);
        tvFechanac.setText(fechaNac);
        tvTel.setText(tel);
        tvEmail.setText(email);
        tvDesc.setText(descripcion);

    }

    public void editar(View v){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("nombre", tvNombre.getText().toString());
        intent.putExtra("fechanac", tvFechanac.getText().toString());
        intent.putExtra("tel", tvTel.getText().toString());
        intent.putExtra("email", tvEmail.getText().toString());
        intent.putExtra("desc", tvDesc.getText().toString());
        startActivity(intent);
        finish();
    }
}