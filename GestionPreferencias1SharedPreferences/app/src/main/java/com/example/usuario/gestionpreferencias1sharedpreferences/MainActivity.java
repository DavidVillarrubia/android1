package com.example.usuario.gestionpreferencias1sharedpreferences;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    private Button btnGuardar;
    private Button btnCargar;
    private TextView texto;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGuardar = (Button)findViewById(R.id.BtnGuardar);
        btnCargar = (Button)findViewById(R.id.BtnCargar);

        texto=(TextView)findViewById(R.id.texto);

        btnGuardar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("email", "modificado@email.com");
                editor.putString("nombre", "Prueba");
                editor.commit();
                texto.setText("GUARDAR");
            }
        });

        btnCargar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                String correo = prefs.getString("email", "por_defecto@email.com");
                String nombre = prefs.getString("nombre", "nombre_por_defecto");
                String otra = prefs.getString("otra", "otra_por_defecto");

                texto.setText("CARGAR");

                Log.i("Preferencias", "Correo: " + correo);
                Log.i("Preferencias", "Nombre: " + nombre);
                Log.i("Preferenciass", "Otra: " + otra);
            }
        });
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
