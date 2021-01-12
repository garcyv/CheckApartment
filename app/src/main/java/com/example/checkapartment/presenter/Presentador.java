package com.example.checkapartment.presenter;

import com.example.checkapartment.model.LoginViewModel;

public class Presentador {
    private LoginViewModel modelo;
    private Ivalidalogin view;

    public Presentador(Ivalidalogin view) {
        this.view = view;
        this.modelo = new LoginViewModel();
    }

    public Boolean validaLoginUsuario(String pNombre, String pPassword){
        Boolean loginOK =modelo.isUsuarioValido(pNombre, pPassword);

        if (loginOK){
             view.shoMessageValid();
        }else {
            view.showMessageInvalid();
        }

        return loginOK;
    }

}
