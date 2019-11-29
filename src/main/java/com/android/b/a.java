package com.android.b;

import android.content.Intent;

public class a extends s {
    private Intent mResolutionIntent;

    public a() {
    }

    public a(i iVar) {
        super(iVar);
    }

    public String getMessage() {
        if (this.mResolutionIntent != null) {
            return "User needs to (re)enter credentials.";
        }
        return super.getMessage();
    }
}
