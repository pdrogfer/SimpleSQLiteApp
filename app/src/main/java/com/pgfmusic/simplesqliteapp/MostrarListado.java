package com.pgfmusic.simplesqliteapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MostrarListado extends AppCompatActivity {

    ListView listView;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_listado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.listView);

        // Cargar should be used in background, in a different thread
        Cargar();
    }

    public void Cargar() {
        MyDBHelper myDBHelper = new MyDBHelper(this, "MY_DATABASE", null, 1);
        SQLiteDatabase db = myDBHelper.getReadableDatabase();
        if (db != null) {
            Cursor c = db.rawQuery("SELECT * FROM Usuarios", null);
            int numUsuarios = c.getCount();
            ArrayList<String> listado = new ArrayList<>();
            if (c.moveToFirst()) {
                do {
                    // form a string with id, name and password from each register
                    String row = c.getInt(0) + " " + c.getString(1) + " " + c.getString(2);
                    listado.add(row);
                } while (c.moveToNext());
            }
            arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
            listView.setAdapter(arrayAdapter);
        }


    }

}
