package com.example.svbloginglib;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.svbloglib.SvbToast;
import com.example.svbloglib.ToastParams;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button regularToast, regularToastWithLength, customToast, customToastWithPosition;
    private int[] color;
    ToastParams toastParams;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        regularToast = findViewById(R.id.btn_regular_toast);
        regularToastWithLength = findViewById(R.id.btn_regular_toast_with_length);
        customToast = findViewById(R.id.btn_custom_toast);
        customToastWithPosition = findViewById(R.id.btn_custom_toast_with_position);

        color = new int[] {
                Color.parseColor("#b5b6d2"),
                Color.parseColor("#112233"),
                Color.parseColor("#b5b6d2")};

        regularToast.setOnClickListener(this);
        regularToastWithLength.setOnClickListener(this);
        customToast.setOnClickListener(this);
        customToastWithPosition.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        toastParams = new ToastParams(MainActivity.this);
        switch (v.getId()){
            case R.id.btn_regular_toast:
                //SvbToast.showToast(MainActivity.this, "Am your regular toast");
                toastParams.setMessage("Hi am your Regular Toast");
                SvbToast.showToast(toastParams);
                break;

            case R.id.btn_regular_toast_with_length:
                //SvbToast.showToast(MainActivity.this, "Am your regular toast with Length", true);
                toastParams.setMessage("Hi am your Regular Toast with length");
                toastParams.setLongToast(false);
                SvbToast.showToast(toastParams);
                break;

            case R.id.btn_custom_toast:
                //SvbToast.showToast(MainActivity.this, "Am your custom toast", getResources().getDrawable(R.drawable.error), 50, color, true);
                toastParams.setMessage("Hi am your Custom Toast");
                toastParams.setIcon(getResources().getDrawable(R.drawable.error));
                toastParams.setCornerRadius(50);
                toastParams.setGradientColors(color);
                toastParams.setTextColor(Color.WHITE);
                toastParams.setLongToast(true);
                SvbToast.showToast(toastParams);
                break;

            case R.id.btn_custom_toast_with_position:
                //SvbToast.showToast(MainActivity.this, "Am your custom toast with Position", null, 30, color, true, -120, 500);
                toastParams.setMessage("Hi am your Custom Toast with Position");
                toastParams.setCornerRadius(50);
                toastParams.setGradientColors(color);
                toastParams.setTextColor(Color.WHITE);
                toastParams.setLongToast(true);
                toastParams.setPositionX(-120);
                toastParams.setPositionY(500);
                SvbToast.showToast(toastParams);
                break;
        }
    }
}
