package com.ton2xmania.mvppractice.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.ton2xmania.mvppractice.R;
import com.ton2xmania.mvppractice.adapter.ListCountryAdapter;
import com.ton2xmania.mvppractice.adapter.ListUserAdapter;
import com.ton2xmania.mvppractice.ifc.MainPresenter;
import com.ton2xmania.mvppractice.ifc.MainView;
import com.ton2xmania.mvppractice.imp.MainPresenterImpl;
import com.ton2xmania.mvppractice.model.Country;
import com.ton2xmania.mvppractice.model.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {
    @BindView(R.id.listView)
    ListView listView;
    private MainPresenter mainPresenter;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainPresenter = new MainPresenterImpl(this);
        pDialog = new ProgressDialog(this);

        mainPresenter.initData();
    }

    @Override
    public void setList(ArrayList<Country> countries) {
        ListCountryAdapter listCountryAdapter = new ListCountryAdapter(getApplicationContext(), countries);
        listView.setAdapter(listCountryAdapter);
    }

    @Override
    public void showProgress() {
        pDialog.show();
    }

    @Override
    public void hideProgress() {
        pDialog.dismiss();
    }
}
