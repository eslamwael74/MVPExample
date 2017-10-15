package com.example.eslamwael74.mvpexample.Login.Interactor;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by eslamwael74 on 26/08/17.
 */

public class LoginInteractorImpl implements LoginInteractor {


    @Override
    public void login(final String userName, final String password, final onLoginFinsgedListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                boolean error = false;

                if(TextUtils.isEmpty(userName)){
                    listener.onUserNameError();
                    error = true;
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    listener.onPasswordError();
                    error = true;
                    return;
                }
                if(!error){
                    listener.onSuccess();
                }


            }
        },2000);

    }
}
