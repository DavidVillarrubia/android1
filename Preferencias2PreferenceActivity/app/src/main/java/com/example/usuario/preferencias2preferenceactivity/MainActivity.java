package com.example.usuario.preferencias2preferenceactivity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    private Button btnPreferencias;
    private Button btnObtenerPreferencias;
    private TextView dato1;
    private TextView dato2;
    private TextView dato3;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPreferencias = (Button)findViewById(R.id.BtnPreferencias);
        btnObtenerPreferencias = (Button)findViewById(R.id.BtnObtenerPreferencias);
        dato1=(TextView)findViewById(R.id.textView1);
        dato2=(TextView)findViewById(R.id.textView2);
        dato3=(TextView)findViewById(R.id.textView3);

        btnPreferencias.setOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OpcionesActivity.class));
            }
        });

        btnObtenerPreferencias.setOnClickListener(new OnClickListener() {
            @Override public void onClick(View v) {
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                dato1.setText("Preferencia 1: " + pref.getBoolean("opcion1", false));
                dato2.setText("Preferencia 2: " + pref.getString("opcion2", ""));
                dato3.setText("Preferencia 3: " + pref.getString("opcion3", ""));
            }
        });
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}