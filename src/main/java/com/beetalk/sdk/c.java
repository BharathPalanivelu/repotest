package com.beetalk.sdk;

import android.content.Intent;
import com.beetalk.sdk.b;
import java.io.Serializable;

public abstract class c implements Serializable {
    private static final long serialVersionUID = 1;
    protected b client;

    /* access modifiers changed from: package-private */
    public boolean a(int i, int i2, Intent intent, b.a aVar) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean a(b.a aVar);

    protected c(b bVar) {
        this.client = bVar;
    }
}
