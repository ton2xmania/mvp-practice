package com.ton2xmania.mvppractice.ifc;

import com.ton2xmania.mvppractice.model.Country;
import java.util.ArrayList;

/**
 * Created by ton2xmania on 25/10/16.
 */

public interface MainView {
    void setList(ArrayList<Country> countries);

    void showProgress();

    void hideProgress();
}
