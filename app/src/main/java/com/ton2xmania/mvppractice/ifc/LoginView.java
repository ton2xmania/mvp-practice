package com.ton2xmania.mvppractice.ifc;

/**
 * Created by ton2xmania on 13/10/16.
 */

public interface LoginView {
    void onLoginSuccess();

    void onLoginFailure();

    void showProgress();

    void hideProgress();

    void showValidationError();
}
