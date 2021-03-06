package com.example.checkapartment.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.checkapartment.databinding.ActivityLoginBinding;
import com.example.checkapartment.presenter.Ivalidalogin;
import com.example.checkapartment.presenter.Presentador;

public class LoginActivity extends AppCompatActivity implements Ivalidalogin {
    private ActivityLoginBinding binding;
    private Presentador presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presentador = new Presentador(this);

        binding.btIngresar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               // binding.loading.setVisibility(View.VISIBLE);
                String vnombre =  binding.username.getText().toString();
                String vpassword = binding.password.getText().toString();
                Boolean isLoginOK = presentador.validaLoginUsuario( vnombre, vpassword);
                Log.d("muestra",vpassword);
              if ( isLoginOK ) {
                     Intent actividadSiguiente = new Intent(LoginActivity.this,SecondActivity.class);
                     startActivity(actividadSiguiente);
                }else {
                  Log.d("muestra",vpassword);
              }

            }

        });
    }

    @Override
    public void shoMessageValid() {
        Toast.makeText(this, "Login Valido", Toast.LENGTH_LONG).show();

     }

    @Override
    public void showMessageInvalid() {
         Toast.makeText(this, "Nombre o password no válido", Toast.LENGTH_LONG).show();
    }
}