package com.example.eslamwael74.mvpexample.Login.Presenter;

import com.example.eslamwael74.mvpexample.Login.Interactor.LoginInteractor;
import com.example.eslamwael74.mvpexample.Login.Interactor.LoginInteractorImpl;
import com.example.eslamwael74.mvpexample.Login.View.LoginView;

/**
 * Created by eslamwael74 on 26/08/17.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.onLoginFinsgedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;


    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentails(String userName, String password) {
            if(loginView != null){
                loginView.showProgress();
            }
            loginInteractor.login(userName,password,this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUserNameError() {
        if(loginView != null){
            loginView.setUserNameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null){
            loginView.setPasswoerdError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null){
            loginView.navigateToHome();
        }
    }
}
