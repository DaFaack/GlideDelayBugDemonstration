package com.example.delaybug;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String buttonNormal1 = "https://i.ibb.co/WGJBjVy/image1.png";
        String buttonPressed1 = "https://i.ibb.co/gmBqNDZ/image2.png";
        String buttonNormal2 = "https://i.ibb.co/x2mYfnW/image3.png";
        String buttonPressed2 = "https://i.ibb.co/4F4wKzn/image4.png";

        ArrayList<Item> mArrayList = new ArrayList<>();
        mArrayList.add(new Item(buttonNormal1, buttonPressed1));
        mArrayList.add(new Item(buttonNormal2, buttonPressed2));

        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(MainActivity.this, mArrayList);
        mRecyclerView.setAdapter(mAdapter);
    }



}