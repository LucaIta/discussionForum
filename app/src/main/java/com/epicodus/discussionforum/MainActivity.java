package com.epicodus.discussionforum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.newCategoryButton) Button mNewCategoryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mNewCategoryButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == mNewCategoryButton) {
            Intent intent = new Intent (MainActivity.this, NewCategoryActivity.class);
            startActivity(intent);
        }
    }
}
