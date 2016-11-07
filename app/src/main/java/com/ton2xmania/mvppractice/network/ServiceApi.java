package com.ton2xmania.mvppractice.network;

import com.ton2xmania.mvppractice.model.CountryModel;
import com.ton2xmania.mvppractice.model.LoginData;
import com.ton2xmania.mvppractice.model.LoginModel;
import com.ton2xmania.mvppractice.utility.Constanta;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by ton2xmania on 14/10/16.
 */

public interface ServiceApi {
    @POST(Constanta.LOGIN_URL)
    Call<LoginModel> login(@Body LoginData loginData);

    @GET(Constanta.COUNTRY_URL)
    Call<CountryModel> loadCountry();
}