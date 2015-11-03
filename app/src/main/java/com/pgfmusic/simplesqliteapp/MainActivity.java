package com.pgfmusic.simplesqliteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_name, tv_passw;
    Button btn_guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_name = (TextView) findViewById(R.id.tv_name);
        TextView tv_passw = (TextView) findViewById(R.id.tv_passw);

    }

    private void Guardar(View v) {
        String name = tv_name.getText().toString();
        String password = tv_passw.getText().toString();

    }
}
