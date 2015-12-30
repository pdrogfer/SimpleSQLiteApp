package com.pgfmusic.simplesqliteapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {

    EditText et_name,et_passw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_main);

        et_name = (EditText) findViewById(R.id.et_name);
        et_passw = (EditText) findViewById(R.id.et_passw);

    }

    // fired by button GuardarDatos
    public void GuardarDatos(View v) {
        String name = et_name.getText().toString();
        String password = et_passw.getText().toString();

        MyDBHelper myDBHelper = new MyDBHelper(this, "MY_DATABASE", null, 1);
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        if (db != null) {
            ContentValues registroNuevo = new ContentValues();
            registroNuevo.put("Name", name);
            registroNuevo.put("Password", password);
            Long i = db.insert("Usuarios", null, registroNuevo);
            if (i > 0) {
                Toast.makeText(this, "Registro insertado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void MostrarListado(View v) {
        startActivity(new Intent(this, MostrarListado.class));
    }
}
