package com.wehavenojob.wehavenojob.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.wehavenojob.wehavenojob.R;
import com.wehavenojob.wehavenojob.adapter.ChatArrayAdapter;
import com.wehavenojob.wehavenojob.domain.ChatModel;

import java.util.ArrayList;

public class ChatActivity extends BaseActivity {

    private EditText mMessageInput;
    private Button mMessageSend;
    private ChatArrayAdapter mAdapter;
    private ListView mMessageListView;
    private ArrayList<ChatModel> mChatModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mMessageInput = (EditText) findViewById(R.id.message);
        mMessageSend = (Button) findViewById(R.id.send);
        mMessageListView = (ListView) findViewById(R.id.message_view);
        mAdapter = new ChatArrayAdapter(this, R.layout.chat_listview, mChatModels);
        mMessageListView.setAdapter(mAdapter);

        mMessageSend.setOnClickListener(v -> databaseReference.child("message").child("960628").push().setValue(new ChatModel(mMessageInput.getText().toString())));

        databaseReference.child("message").child("960628").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ChatModel chatModel = dataSnapshot.getValue(ChatModel.class);
                mAdapter.add(chatModel);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
