package com.example.svbloglib;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class ToastParams {
    public Context context;
    public String message;
    public Drawable icon;
    boolean isLongToast;
    public int cornerRadius;
    public int[] gradientColors;
    public int positionX;
    public int positionY;
    public int textColor;

    public ToastParams(Context context){
        this.context = context;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public boolean isLongToast() {
        return isLongToast;
    }

    public void setLongToast(boolean longToast) {
        isLongToast = longToast;
    }

    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    public int[] getGradientColors() {
        return gradientColors;
    }

    public void setGradientColors(int[] gradientColors) {
        this.gradientColors = gradientColors;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }
}


