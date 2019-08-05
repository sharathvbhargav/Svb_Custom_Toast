package com.example.svbloginglib;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.svbloglib.Svb;
import com.example.svbloglib.SvbToast;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        final int[] color = new int[] {
                Color.parseColor("#b5b6d2"),
                Color.parseColor("#112233"),
                Color.parseColor("#b5b6d2")};
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SvbToast.showToast(
                    MainActivity.this,
                    "Am your custom toast",
                    getResources().getDrawable(R.drawable.error),
                    50,
                    color,
                    true);
            }
        });
    }
}
