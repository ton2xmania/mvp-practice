package com.ton2xmania.mvppractice.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ton2xmania.mvppractice.R;
import com.ton2xmania.mvppractice.model.Country;
import java.util.ArrayList;

/**
 * Created by ton2xmania on 04/11/16.
 */

public class ListCountryAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Country> countries;

    public ListCountryAdapter(Context context, ArrayList<Country> countries) {
        this.context = context;
        this.countries = countries;
    }

    private class ViewHolder {
        TextView tv_name;
        TextView tv_alpha2;
        TextView tv_alpha3;
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public Object getItem(int position) {
        return countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return countries.indexOf(countries.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListCountryAdapter.ViewHolder viewHolder = null;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_country, null);
            viewHolder = new ListCountryAdapter.ViewHolder();
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tv_alpha2 = (TextView) convertView.findViewById(R.id.tv_alpha2);
            viewHolder.tv_alpha3 = (TextView) convertView.findViewById(R.id.tv_alpha3);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ListCountryAdapter.ViewHolder) convertView.getTag();
        }

        Country country = (Country) getItem(position);
        viewHolder.tv_name.setText(String.valueOf(country.getName()));
        viewHolder.tv_alpha2.setText(country.getAlpha2_code());
        viewHolder.tv_alpha3.setText(country.getAlpha3_code());

        return convertView;
    }
}
