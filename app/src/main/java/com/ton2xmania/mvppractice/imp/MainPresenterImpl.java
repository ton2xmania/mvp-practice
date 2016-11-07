package com.ton2xmania.mvppractice.imp;

import android.util.Log;

import com.ton2xmania.mvppractice.ifc.MainPresenter;
import com.ton2xmania.mvppractice.ifc.MainView;
import com.ton2xmania.mvppractice.model.Country;
import com.ton2xmania.mvppractice.model.CountryModel;
import com.ton2xmania.mvppractice.model.User;
import com.ton2xmania.mvppractice.network.ServiceApi;
import com.ton2xmania.mvppractice.network.ServiceGenerator;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ton2xmania on 25/10/16.
 */

public class MainPresenterImpl implements MainPresenter {
    private MainView mainView;
    private ArrayList<Country> countries = new ArrayList<>();

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void initData() {
        mainView.showProgress();

        ServiceApi serviceApi = ServiceGenerator.createService(ServiceApi.class);
        Call<CountryModel> countryCall = serviceApi.loadCountry();

        countryCall.enqueue(new Callback<CountryModel>() {
            @Override
            public void onResponse(Call<CountryModel> call, Response<CountryModel> response) {
                mainView.hideProgress();

                if (response.isSuccessful()) {
                    CountryModel countryModel = response.body();

                    for (int i = 0; i < countryModel.getRestResponse().getResult().size(); i++) {
                        countries.add(i, new Country(countryModel.getRestResponse().getResult().get(i).getName(),
                                countryModel.getRestResponse().getResult().get(i).getAlpha2_code(),
                                countryModel.getRestResponse().getResult().get(i).getAlpha3_code()));
                    }

                    mainView.setList(countries);

                    mainView.hideProgress();
                }
            }

            @Override
            public void onFailure(Call<CountryModel> call, Throwable t) {
                mainView.hideProgress();
                t.printStackTrace();
            }
        });
    }
}
