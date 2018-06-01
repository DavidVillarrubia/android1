package com.example.usuario.bd2;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.TextViewCompat;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    private EditText txtCodigo;
    private EditText txtNombre;
    private Button btnInsertar;
    private Button btnActualizar;
    private Button btnEliminar;
    private SQLiteDatabase db;
    private TextView texto;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCodigo = (EditText)findViewById(R.id.txtReg);
        txtNombre = (EditText)findViewById(R.id.txtVal);
        btnInsertar = (Button)findViewById(R.id.btnInsertar);
        btnActualizar = (Button)findViewById(R.id.btnActualizar);
        btnEliminar = (Button)findViewById(R.id.btnEliminar);
        texto=(TextView)findViewById(R.id.textView0);
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
                texto.setText("INSERTADO");
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
                texto.setText("ACTUALIZADO");
            }
        });

        btnEliminar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String cod = txtCodigo.getText().toString();

                //Forma 1: sqlExec()
                //String sql = "DELETE FROM Usuarios WHERE codigo=" + cod;
                //db.execSQL(sql);

                //Forma 2: delete()
                db.delete("Usuarios", "codigo=" + cod, null);
                texto.setText("ELIMINADO");
            }
        });
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
