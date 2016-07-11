package com.epicodus.discussionforum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewCategoryActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.newCategoryButton) Button mNewCategoryButton;
    @Bind(R.id.newCategoryView) EditText mNewCategoryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_category);
        ButterKnife.bind(this);
        mNewCategoryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mNewCategoryButton) {
            String newCategory = mNewCategoryView.getText().toString();
            Toast.makeText(NewCategoryActivity.this, newCategory, Toast.LENGTH_LONG).show();
        }
    }



}
