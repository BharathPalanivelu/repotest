package com.shopee.app.web.protocol;

import com.google.a.o;

public class NavigateAppPath {
    o params;
    String path;
    boolean popSelf;

    public String getPath() {
        return this.path;
    }

    public o getParams() {
        return this.params;
    }

    public boolean isPopSelf() {
        return this.popSelf;
    }

    public boolean isTransparentPopup() {
        String str = this.path;
        return str != null && str.contains("navigationType=3");
    }
}
