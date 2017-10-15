package com.example.eslamwael74.mvpexample.Login.Presenter;

/**
 * Created by eslamwael74 on 26/08/17.
 */

public interface LoginPresenter {

    void validateCredentails(String userName, String password);

    void onDestroy();
}
