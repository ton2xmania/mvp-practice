package com.ton2xmania.mvppractice.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.pixplicity.easyprefs.library.Prefs;
import com.ton2xmania.mvppractice.R;
import com.ton2xmania.mvppractice.ifc.LoginPresenter;
import com.ton2xmania.mvppractice.ifc.LoginView;
import com.ton2xmania.mvppractice.imp.LoginPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {
    @BindView(R.id.email)
    EditText etUsername;
    @BindView(R.id.password)
    EditText etPassword;
    private LoginPresenter loginPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImpl(this);
        progressDialog = new ProgressDialog(this);

        if (Prefs.getBoolean("isLogin", true)) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
    }

    @OnClick(R.id.email_sign_in_button)
    void signin() {
        loginPresenter.login(etUsername.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void onLoginFailure() {
        Toast.makeText(this, "Login Failure", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showValidationError() {
        Toast.makeText(this, "Please enter valid username and password", Toast.LENGTH_SHORT).show();
    }
}