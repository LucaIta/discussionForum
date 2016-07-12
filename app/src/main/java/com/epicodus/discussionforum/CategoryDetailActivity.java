package com.epicodus.discussionforum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryDetailActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.categoryTextView) TextView mCategoryTextView;
    @Bind(R.id.newQuestionEditText) TextView mNewQuestionEditText;
    @Bind(R.id.newQuestionButton) TextView mNewQuestionButton;
    private DatabaseReference mCategoryReference;
    private ValueEventListener mCategoryReferenceEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        mCategoryTextView.setText(category);
        mNewQuestionButton.setOnClickListener(this);

//        String ID = intent.getStringExtra("key");
//        Log.d("Whatever", ID);
//        mCategoryReference = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_CHILD_CATEGORY).child(ID);

//        mCategoryReferenceEventListener = mCategoryReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Log.d("Whatever", dataSnapshot.getValue().toString());
//                //for (DataSnapshot categorySnapshot : dataSnapshot.getChildren()) {
////                    mCategoryList.add(categorySnapshot.getValue().toString());
////                    Log.v("Key:",categorySnapshot.getKey().toString());
////                    ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, mCategoryList);
////                    mListView.setAdapter(adapter);
//                //}
//            }
//
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        if (view == mNewQuestionButton) {
            String questionText = mNewQuestionEditText.getText().toString();
            String category = getIntent().getStringExtra("category");
            Question newQuestion = new Question(questionText, "USER", category);

        }
    }

}