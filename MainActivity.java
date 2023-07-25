package com.example.viewmodletest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    TextView textView;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        textView = findViewById(R.id.textView);
        textView.setText(String.valueOf(myViewModel.number));

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(v -> {
            myViewModel.number++;
            textView.setText(String.valueOf(myViewModel.number));
        });

        button2.setOnClickListener(v -> {
            myViewModel.number += 2;
            textView.setText(String.valueOf(myViewModel.number));
        });
    }
}