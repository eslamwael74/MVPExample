package com.example.eslamwael74.mvpexample.Login.Interactor;

/**
 * Created by eslamwael74 on 26/08/17.
 */

public interface LoginInteractor {

    interface onLoginFinsgedListener{

        void onUserNameError();

        void onPasswordError();

        void onSuccess();

    }

    void login(String userName, String password, onLoginFinsgedListener listener);

}
