package com.example.svbloglib;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SvbToast {
    private static Toast toast;
    private static Handler handler = new Handler();

    public static void showToast(ToastParams toastParams){
        createCustomToast(toastParams);
    }

    public static void createCustomToast(ToastParams toastParams){
        toast = new Toast(toastParams.context);
        LayoutInflater inflater = (LayoutInflater)toastParams.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.layout_custom_toast, null);
        ImageView image = layout.findViewById(R.id.image);
        TextView text = layout.findViewById(R.id.text);
        LinearLayout rootLayout = layout.findViewById(R.id.toast_layout_root);
        GradientDrawable gd;
        int[] color = new int[]{};
        int toastLength, positionX=0, positionY=0, timeInMillis=0, cornerRadius = 30;

        //If Text is provided then show that text by setting it to text view. Else set ""
        if (toastParams.getMessage() == null || toastParams.getMessage().equals("")) {
            text.setText("");
        } else {
            text.setText(toastParams.getMessage());
        }

        //If Drawable image provided with the model then set it to toast else set visibility to GONE
        if (toastParams.getIcon() == null) {
            image.setVisibility(View.GONE);
        } else {
            image.setImageDrawable(toastParams.getIcon());
        }

        //If Array of colors and corner radius provided apply those params else apply default
        if(toastParams.getGradientColors()!= null && toastParams.getGradientColors().length > 0) {
            if(toastParams.getGradientColors().length == 1){
                color = new int[]{color[0], color[0]};
                toastParams.setGradientColors(color);
            }
        }
        else {
            color = new int[]{Color.parseColor("#EDEDED"),Color.parseColor("#EDEDED")};
            toastParams.setGradientColors(color);
        }

        //If Corner radius is provided then set else set default 30
        if (toastParams.getCornerRadius() != 0) {
            cornerRadius = toastParams.getCornerRadius();
        }

        //If Text color is provided then apply the color else apply default color
        if(toastParams.getTextColor() == 0){
            text.setTextColor(Color.parseColor("#1F1F1F"));
        }
        else {
            text.setTextColor(toastParams.getTextColor());
        }

        //If Long toast set to true then set long toast else set Short toast
        if(toastParams.isLongToast){
            toastLength = Toast.LENGTH_LONG;
        }
        else {
            toastLength = Toast.LENGTH_SHORT;
        }

        //If Position for X axis is given then set position else keep default 0
        if(toastParams.getPositionX() != 0){
            positionX = toastParams.getPositionX();
        }

        //If Position for Y axis is given then set position else keep default 0
        if(toastParams.getPositionY() != 0){
            positionY = toastParams.getPositionY();
        }

        if(toastParams.getTimeInMillis() != 0){
            timeInMillis = toastParams.getTimeInMillis();
        }

        gd = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, toastParams.getGradientColors());
        gd.setCornerRadius(cornerRadius);
        rootLayout.setBackgroundDrawable(gd);

        toast.setGravity(Gravity.CENTER|Gravity.BOTTOM, positionX, positionY);
        toast.setDuration(toastLength);
        toast.setView(layout);
        toast.show();
    }
}
