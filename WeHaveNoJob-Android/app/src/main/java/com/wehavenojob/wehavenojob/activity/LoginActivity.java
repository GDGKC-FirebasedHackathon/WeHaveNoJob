package com.wehavenojob.wehavenojob.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.wehavenojob.wehavenojob.R;

public class LoginActivity extends BaseActivity {

    private String TAG = this.getClass().getSimpleName();
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private Button mAnonymousLoginButton;
    private EditText mClassNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = (firebaseAuth) -> {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user != null) {
                Toast.makeText(getApplicationContext(), user.getUid(), Toast.LENGTH_SHORT).show();
            } else {
//                Toast.makeText(getApplicationContext(), "가입이 되지 않았습니다.", Toast.LENGTH_SHORT).show();
            }
        };

        mAnonymousLoginButton = (Button) findViewById(R.id.anonymous_login_button);
        mClassNumber = (EditText) findViewById(R.id.class_number);

        mAnonymousLoginButton.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();

            // TODO -> 집가서 Google Play Service 버전으로 인화여 Auth가 되지 않는 문제 해결할 것
//            signInAnonymously();
//            mAuth.signOut();
//            databaseReference.child("class").child(mClassNumber.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    ClassModel classModel = dataSnapshot.getValue(ClassModel.class);
//                    if (classModel != null) {
//                        mAuth.signInAnonymously().addOnCompleteListener(LoginActivity.this, task -> {
//                            if (task.isSuccessful()) {
//                                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
//                            } else {
//                                Log.d(TAG, task.getException().toString());
//                            }
//                        });
//                    } else {
//                        Toast.makeText(getApplicationContext(), "해당 강의를 불러올 수 없습니다.", Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//                    databaseError.toException().printStackTrace();
//                    Toast.makeText(getApplicationContext(), "데이터를 불러올 수 없습니다.", Toast.LENGTH_SHORT).show();
//                }
//            });
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void signInAnonymously() {
        mAuth.signInAnonymously().addOnCompleteListener(LoginActivity.this, task -> {
            Log.d(TAG, "signInAnonymously:onComplete:" + task.isSuccessful());

            // If sign in fails, display a message to the user. If sign in succeeds
            // the auth state listener will be notified and logic to handle the
            // signed in user can be handled in the listener.
            if (!task.isSuccessful()) {
                Log.w(TAG, "signInAnonymously", task.getException());
                Toast.makeText(LoginActivity.this, "Authentication failed.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
