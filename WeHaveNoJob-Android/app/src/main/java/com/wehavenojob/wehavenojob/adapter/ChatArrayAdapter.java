package com.wehavenojob.wehavenojob.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wehavenojob.wehavenojob.R;
import com.wehavenojob.wehavenojob.domain.ChatModel;

import java.util.ArrayList;

/**
 * Created by judepark on 2017. 2. 18..
 */

public class ChatArrayAdapter extends ArrayAdapter<ChatModel> {

    public ChatArrayAdapter(Context context, int resource, ArrayList<ChatModel> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.chat_listview, parent, false);

        TextView content = (TextView) v.findViewById(R.id.content);
        content.setText(getItem(position).getText());

        return v;
    }
}
