package com.shopee.app.react.protocol;

public class TextInputData {
    private ButtonData button;
    private boolean isPassword;
    private String placeHolder;

    public String getPlaceholder() {
        return this.placeHolder;
    }

    public boolean isPassword() {
        return this.isPassword;
    }

    public ButtonData getButton() {
        return this.button;
    }
}
