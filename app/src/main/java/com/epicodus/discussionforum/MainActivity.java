package com.epicodus.discussionforum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.newCategoryButton) Button mNewCategoryButton;
    private DatabaseReference mCategoryReference;
    private ValueEventListener mCategoryReferenceEventListener;
    private ArrayList<String> mCategoryList = new ArrayList<>();
    private String key;
    @Bind(R.id.categoryListView) ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mNewCategoryButton.setOnClickListener(this);

        Map<String, Object> map23 = new HashMap<>();
        map23.put("0", "sports");
        map23.put("1", "technology");

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("test");

        ref.updateChildren(map23);


        DatabaseReference ref2 = FirebaseDatabase.getInstance().getReference("test").child("0");
        ref2.push().setValue("business");









        mCategoryReference = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_CHILD_CATEGORY);

        mCategoryReferenceEventListener = mCategoryReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mCategoryList = new ArrayList<>();
                for (DataSnapshot categorySnapshot : dataSnapshot.getChildren()) {
                    mCategoryList.add(categorySnapshot.getValue().toString());
                    ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, mCategoryList);
                    mListView.setAdapter(adapter);
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String category = ((TextView)view).getText().toString();
                Intent intent = new Intent(MainActivity.this, CategoryDetailActivity.class);
                intent.putExtra("category", category);
                getKey(category);
//                intent.putExtra("key", key);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCategoryReference.removeEventListener(mCategoryReferenceEventListener);
    }

    @Override
    public void onClick(View view) {
        if (view == mNewCategoryButton) {
            Intent intent = new Intent (MainActivity.this, NewCategoryActivity.class);
            startActivity(intent);
        }
    }

    public String getKey(final String categoryName) {

        mCategoryReference = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_CHILD_CATEGORY);


        mCategoryReferenceEventListener = mCategoryReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot categorySnapshot : dataSnapshot.getChildren()) {
                    if (categoryName.equals(categorySnapshot.getValue().toString())) {
                        key = categorySnapshot.getKey().toString();
                        Log.v("Key:", "the key is this : " +  key);
                    }
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        Log.v("returned key","the key in the method is :" + key);
        return key;
    }




}
