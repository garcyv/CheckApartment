package com.example.checkapartment.model;

import android.util.Patterns;

public class LoginViewModel {

    private boolean isPasswordValid(String password) {
        return password != null && password.equals("123pass");
    }

    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    public boolean isUsuarioValido(String nombre, String password){

        return isUserNameValid(nombre) && isPasswordValid(password);
    }
}
