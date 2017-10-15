package com.example.eslamwael74.mvpexample.Login.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ProgressBar;

import com.example.eslamwael74.mvpexample.Login.Presenter.LoginPresenter;
import com.example.eslamwael74.mvpexample.Login.Presenter.LoginPresenterImpl;
import com.example.eslamwael74.mvpexample.Main.View.MainActivity;
import com.example.eslamwael74.mvpexample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eslamwael74 on 26/08/17.
 */

public class LoginActivity extends Activity implements LoginView, View.OnClickListener {

    @BindView(R.id.name)TextInputEditText userName;
    @BindView(R.id.inputName)TextInputLayout inputName;
    @BindView(R.id.password)TextInputEditText password;
    @BindView(R.id.inputPass)TextInputLayout inputPass;
    @BindView(R.id.btnLogin)AppCompatButton btnLogin;
    @BindView(R.id.progress)ProgressBar progress;

    private LoginPresenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        btnLogin.setOnClickListener(this);

        presenter = new LoginPresenterImpl(this);

    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        String mUserName = userName.getText().toString().trim();
        String mPassword = password.getText().toString().trim();

        presenter.validateCredentails(mUserName,mPassword);
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError() {
        inputName.setError("User Name is Empty");
    }

    @Override
    public void setPasswoerdError() {
        inputPass.setError("Password is Empty");

    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
