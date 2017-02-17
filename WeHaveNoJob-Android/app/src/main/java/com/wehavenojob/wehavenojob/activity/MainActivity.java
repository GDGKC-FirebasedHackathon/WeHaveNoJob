package com.wehavenojob.wehavenojob.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.wehavenojob.wehavenojob.R;
import com.wehavenojob.wehavenojob.adapter.ClassArrayAdapter;
import com.wehavenojob.wehavenojob.domain.ClassModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ClassArrayAdapter mAdapter;
    private ArrayList<ClassModel> mClassModels = new ArrayList<>();

    private ListView mClassListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mClassListView = (ListView) findViewById(R.id.class_list);

        mClassModels.add(new ClassModel("2017-01-01", "선형대수학", "여러분이 살면서 공학수학보다 선형대수학을 더 중요시여기게 될 걸요 ?"));
        mClassModels.add(new ClassModel("2017-01-01", "선형대수학", "여러분이 살면서 공학수학보다 선형대수학을 더 중요시여기게 될 걸요 ?"));
        mClassModels.add(new ClassModel("2017-01-01", "선형대수학", "여러분이 살면서 공학수학보다 선형대수학을 더 중요시여기게 될 걸요 ?"));
        mClassModels.add(new ClassModel("2017-01-01", "선형대수학", "여러분이 살면서 공학수학보다 선형대수학을 더 중요시여기게 될 걸요 ?"));
        mClassModels.add(new ClassModel("2017-01-01", "선형대수학", "여러분이 살면서 공학수학보다 선형대수학을 더 중요시여기게 될 걸요 ?"));
        mClassModels.add(new ClassModel("2017-01-01", "선형대수학", "여러분이 살면서 공학수학보다 선형대수학을 더 중요시여기게 될 걸요 ?"));
        mClassModels.add(new ClassModel("2017-01-01", "선형대수학", "여러분이 살면서 공학수학보다 선형대수학을 더 중요시여기게 될 걸요 ?"));
        mClassModels.add(new ClassModel("2017-01-01", "선형대수학", "여러분이 살면서 공학수학보다 선형대수학을 더 중요시여기게 될 걸요 ?"));

        mAdapter = new ClassArrayAdapter(this, R.layout.class_listview, mClassModels);
        mClassListView.setAdapter(mAdapter);
        mClassListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(MainActivity.this, ChatActivity.class));

    }
}
