package com.garena.android.appkit.b;

import com.garena.android.appkit.b.b;

public abstract class g implements e {
    private int mReferenceCount = 0;

    public b.C0122b getOption() {
        return b.C0122b.MAIN_THREAD;
    }

    public void onRegister() {
        this.mReferenceCount++;
    }

    public void onDismiss() {
        this.mReferenceCount--;
    }

    public boolean isValid() {
        return this.mReferenceCount > 0;
    }
}
