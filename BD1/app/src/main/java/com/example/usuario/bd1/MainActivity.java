package com.example.usuario.bd1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends Activity {

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);
        SQLiteDatabase db = usdbh.getWritableDatabase();
        if(db != null) {
            for(int i=1; i<=5; i++){
                int codigo = i;
                String nombre = "Usuario" + i;
                db.execSQL("INSERT INTO Usuarios (codigo, nombre) " + "VALUES (" + codigo + ", '" + nombre +"')");
            }
            db.close();
        }
    }
}