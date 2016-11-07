package com.ton2xmania.mvppractice.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ton2xmania.mvppractice.R;
import com.ton2xmania.mvppractice.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ton2xmania on 25/10/16.
 */

public class ListUserAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<User> users;

    public ListUserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    private class ViewHolder {
        TextView tv_id_user;
        TextView tv_nama_user;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return users.indexOf(users.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_user, null);
            viewHolder = new ViewHolder();
            viewHolder.tv_id_user = (TextView) convertView.findViewById(R.id.tv_id_user);
            viewHolder.tv_nama_user = (TextView) convertView.findViewById(R.id.tv_nama_user);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        User user = (User) getItem(position);
        viewHolder.tv_id_user.setText(String.valueOf(user.getId()));
        viewHolder.tv_nama_user.setText(user.getName());

        return convertView;
    }
}
