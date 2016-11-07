package com.ton2xmania.mvppractice.imp;

import android.text.TextUtils;

import com.pixplicity.easyprefs.library.Prefs;
import com.ton2xmania.mvppractice.ifc.LoginPresenter;
import com.ton2xmania.mvppractice.ifc.LoginView;
import com.ton2xmania.mvppractice.model.LoginData;
import com.ton2xmania.mvppractice.model.LoginModel;
import com.ton2xmania.mvppractice.network.ServiceApi;
import com.ton2xmania.mvppractice.network.ServiceGenerator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ton2xmania on 13/10/16.
 */

public class LoginPresenterImpl implements LoginPresenter {
    private LoginView loginView;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void login(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || !isEmailValid(username)) {
            loginView.showValidationError();
        } else {
            loginView.showProgress();

            LoginData loginData = new LoginData(username, password);
            ServiceApi serviceApi = ServiceGenerator.createService(ServiceApi.class);
            Call<LoginModel> loginModel = serviceApi.login(loginData);

            loginModel.enqueue(new Callback<LoginModel>() {
                @Override
                public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                    loginView.hideProgress();
                    if (response.isSuccessful()) {
                        LoginModel login = response.body();

                        if (login.getStat().equals("ok")) {
                            loginView.onLoginSuccess();
                            Prefs.putString("token", login.getResponse().getAccess_token());
                            Prefs.putBoolean("isLogin", true);
                        } else {
                            loginView.onLoginFailure();
                        }
                    }
                }

                @Override
                public void onFailure(Call<LoginModel> call, Throwable t) {
                    loginView.hideProgress();
                    t.printStackTrace();
                }
            });
        }
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
}
