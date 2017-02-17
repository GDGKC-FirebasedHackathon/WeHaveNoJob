package com.wehavenojob.wehavenojob.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wehavenojob.wehavenojob.R;
import com.wehavenojob.wehavenojob.domain.ClassModel;

import java.util.ArrayList;

/**
 * Created by judepark on 2017. 2. 18..
 */

public class ClassArrayAdapter extends ArrayAdapter<ClassModel> {

    public ClassArrayAdapter(Context context, int resource, ArrayList<ClassModel> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.class_listview, parent, false);

        TextView date = (TextView) v.findViewById(R.id.date);
        TextView className = (TextView) v.findViewById(R.id.class_name);
        TextView classContent = (TextView) v.findViewById(R.id.class_content);

        ClassModel classModel = getItem(position);

        date.setText(classModel.getDate());
        className.setText(classModel.getClassName());
        classContent.setText(classModel.getClassContent());

        return v;
    }

}
