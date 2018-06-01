package com.example.usuario.contentprovider1;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ClientesSqliteHelper extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Clientes " + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " + " nombre TEXT, " + " telefono TEXT, " + " email TEXT )";

    public ClientesSqliteHelper(Context contexto, String nombre, CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
        //Insertamos 5 clientes de ejemplo
        for(int i=1; i<=15; i++) {
            String nombre = "Cliente" + i;
            String telefono = "900-123-00" + i;
            String email = "email" + i + "@mail.com";
            db.execSQL("INSERT INTO Clientes (nombre, telefono, email) " + "VALUES ('" + nombre + "', '" + telefono +"', '" + email + "')");
        }
    }

    @Override public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS Clientes");
        db.execSQL(sqlCreate);
    }
}