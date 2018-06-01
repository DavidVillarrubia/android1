package com.example.usuario.bd3;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText txtCodigo;
    private EditText txtNombre;
    private TextView txtResultado;
    private Button btnInsertar;
    private Button btnActualizar;
    private Button btnEliminar;
    private Button btnConsultar;
    private SQLiteDatabase db;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCodigo = (EditText)findViewById(R.id.txtReg);
        txtNombre = (EditText)findViewById(R.id.txtVal);
        txtResultado = (TextView)findViewById(R.id.txtResultado);
        btnInsertar = (Button)findViewById(R.id.btnInsertar);
        btnActualizar = (Button)findViewById(R.id.btnActualizar);
        btnEliminar = (Button)findViewById(R.id.btnEliminar);
        btnConsultar = (Button)findViewById(R.id.btnConsultar);
        UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);
        db = usdbh.getWritableDatabase();

        btnInsertar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String cod = txtCodigo.getText().toString();
                String nom = txtNombre.getText().toString();

                //Forma 1: sqlExec()
                //String sql = "INSERT INTO Usuarios (codigo,nombre) VALUES ('" + cod + "','" + nom + "') ";
                //db.execSQL(sql);

                //Forma 2: insert()
                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("codigo", cod);
                nuevoRegistro.put("nombre", nom);
                db.insert("Usuarios", null, nuevoRegistro);
            }
        });

        btnActualizar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String cod = txtCodigo.getText().toString();
                String nom = txtNombre.getText().toString();

                //Forma 1: sqlExec()
                //String sql = "UPDATE Usuarios SET nombre='" + nom + "' WHERE codigo=" + cod;
                //db.execSQL(sql);

                //Forma 2: update()
                ContentValues valores = new ContentValues();
                valores.put("nombre", nom);
                db.update("Usuarios", valores, "codigo=" + cod, null);
            }
        });

        btnEliminar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String cod = txtCodigo.getText().toString();

                //Forma 1: método sqlExec()
                //String sql = "DELETE FROM Usuarios WHERE codigo=" + cod;
                //db.execSQL(sql);

                //Forma 2: método delete()
                db.delete("Usuarios", "codigo=" + cod, null);
            }
        });

        btnConsultar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                //Forma 1: rawQuery()
                //Cursor c = db.rawQuery("SELECT codigo, nombre FROM Usuarios", null);

                //Forma 2: delete()
                String[] campos = new String[] {"codigo", "nombre"};
                Cursor c = db.query("Usuarios", campos, null, null, null, null, null);

                //Recorremos los resultados para mostrarlos en pantalla
                txtResultado.setText("");
                if (c.moveToFirst()) {
                    while(c.moveToNext()) {
                        String cod = c.getString(0);
                        String nom = c.getString(1);
                        txtResultado.append(" " + cod + " - " + nom + "\n");
                    }
                }
            }
        });
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}