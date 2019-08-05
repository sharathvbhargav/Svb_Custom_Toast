package com.example.svbloglib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SvbToast {
    public static void showToast(Context context, String message, Drawable icon, int cornerRadius, int[] color, boolean isLongToast){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.layout_custom_toast, null);
        ImageView image = layout.findViewById(R.id.image);
        if(icon != null) {
            image.setImageDrawable(icon);
        }
        else {
            image.setVisibility(View.GONE);
        }

        if(color.length == 1){
            color = new int[]{color[0], color[0]};
        }

        TextView text = layout.findViewById(R.id.text);
        text.setText("Hello! This is a custom toast!");
        LinearLayout rootLayout = layout.findViewById(R.id.toast_layout_root);

        GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, color);
        gd.setCornerRadius(cornerRadius);
        rootLayout.setBackgroundDrawable(gd);

        final Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER|Gravity.BOTTOM, 0, 10);
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
