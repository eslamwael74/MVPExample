package com.example.eslamwael74.mvpexample.Login.View;

/**
 * Created by eslamwael74 on 26/08/17.
 */

public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUserNameError();

    void setPasswoerdError();

    void navigateToHome();

}
