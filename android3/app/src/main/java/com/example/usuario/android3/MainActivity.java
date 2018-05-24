package com.example.usuario.android3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    ControlLogin ctlLogin;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ctlLogin = (ControlLogin)findViewById(R.id.CtlLogin);
        ctlLogin.setOnLoginListener(new OnLoginListener() {
            @Override public void onLogin(String usuario, String password) {
                //Validamos el usuario y la contraseña
                if (usuario.equals("demo") && password.equals("demo")) {ctlLogin.setMensaje("Login correcto!");}
                else {ctlLogin.setMensaje("Vuelva a intentarlo.");}
            }
        });
    }
}
