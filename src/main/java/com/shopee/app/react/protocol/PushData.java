package com.shopee.app.react.protocol;

public class PushData {
    private Navbar navbar;
    private int popCount = 0;
    private String propsString;

    public PushData() {
    }

    public PushData(String str) {
        this.propsString = str;
    }

    public Navbar getNavbar() {
        return this.navbar;
    }

    public String getPropsString() {
        return this.propsString;
    }

    public int getPopCount() {
        return this.popCount;
    }
}
