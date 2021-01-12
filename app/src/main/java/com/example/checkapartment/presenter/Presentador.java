package com.example.checkapartment.presenter;

import com.example.checkapartment.model.LoginViewModel;

public class Presentador {
    private LoginViewModel modelo;
    private Ivalidalogin view;

    public Presentador(Ivalidalogin view) {
        this.view = view;
        this.modelo = new LoginViewModel();
    }

    public void validaLoginUsuario(String pNombre, String pPassword){

        if (modelo.isUsuarioValido(pNombre, pPassword)){
             view.shoMessageValid();
        }else {view.showMessageInvalid();}
    }

}
