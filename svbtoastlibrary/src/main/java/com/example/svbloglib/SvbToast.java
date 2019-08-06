package com.example.svbloglib;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SvbToast {
    //Hi
    public static void showToast(Context context, String message){
        if(message != null){
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "", Toast.LENGTH_LONG).show();
        }
    }

    public static void showToast(Context context, String message, boolean isLingToast){
        if(message != null){
            if(isLingToast) {
                Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "", Toast.LENGTH_LONG).show();
        }
    }

    public static void showToast(Context context, String message, Drawable icon, int cornerRadius, int[] color, boolean isLongToast){
        createCustomToast(context, message, icon, cornerRadius, color, isLongToast, 0, 0);
    }

    public static void showToast(Context context, String message, Drawable icon, int cornerRadius, int[] color, boolean isLongToast, int positionX, int positionY) {
        createCustomToast(context, message, icon, cornerRadius, color, isLongToast, positionX, positionY);
    }

    private static void createCustomToast(Context context, String message, Drawable icon, int cornerRadius, int[] color, boolean isLongToast, int positionX, int positionY){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.layout_custom_toast, null);
        ImageView image = layout.findViewById(R.id.image);

        if(icon != null) {
            image.setImageDrawable(icon);
        }
        else {
            image.setVisibility(View.GONE);
        }

        //If only 1 color sent keep second color also as same as first one
        if(color.length == 1){
            color = new int[]{color[0], color[0]};
        }

        TextView text = layout.findViewById(R.id.text);
        text.setText(message);
        LinearLayout rootLayout = layout.findViewById(R.id.toast_layout_root);

        GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, color);
        gd.setCornerRadius(cornerRadius);
        rootLayout.setBackgroundDrawable(gd);

        final Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER|Gravity.BOTTOM, positionX, positionY);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        if(isLongToast) {
            toast.setDuration(Toast.LENGTH_LONG);
        }
        else {
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }
}
