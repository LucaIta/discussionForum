package com.epicodus.discussionforum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryDetailActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.categoryTextView) TextView mCategoryTextView;
    @Bind(R.id.newQuestionEditText) TextView mNewQuestionEditText;
    @Bind(R.id.newQuestionButton) TextView mNewQuestionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        mCategoryTextView.setText(category);
        mNewQuestionButton.setOnClickListener()
    }

    @Override
    protected void onClick() {

    }

}
