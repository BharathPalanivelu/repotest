package com.garena.pay.android;

import android.content.Intent;
import com.beetalk.sdk.data.c;
import com.garena.pay.android.a.b;
import com.garena.pay.android.c.f;
import java.io.Serializable;
import java.util.List;

public abstract class d implements Serializable {
    private static final long serialVersionUID = 1;
    private String channelId;
    protected b client;
    protected String displayName;
    protected String iconUri;
    protected int imageResId;
    protected b.C0136b mPaymentChannel;

    public abstract boolean a(c cVar);

    public abstract void h();

    public String a() {
        return this.channelId;
    }

    public void a(String str) {
        this.channelId = str;
    }

    protected d(b bVar) {
        this.client = bVar;
    }

    public b.C0136b b() {
        return this.mPaymentChannel;
    }

    public void a(b.C0136b bVar) {
        this.mPaymentChannel = bVar;
    }

    public List<b.a> c() {
        b.C0136b bVar = this.mPaymentChannel;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    public boolean d() {
        b.C0136b bVar = this.mPaymentChannel;
        if (bVar != null) {
            return bVar.b();
        }
        return false;
    }

    public int e() {
        return this.imageResId;
    }

    public String f() {
        return this.displayName;
    }

    public void b(String str) {
        this.displayName = str;
    }

    public String g() {
        return this.iconUri;
    }

    public void c(String str) {
        this.iconUri = str;
    }

    /* access modifiers changed from: protected */
    public boolean a(int i, int i2, Intent intent, c cVar) {
        if (i2 == 0) {
            this.client.a(c.a(cVar, a.ERROR, "Error Recd."));
            return true;
        } else if (i2 != -1) {
            return true;
        } else {
            this.client.a(c.a(cVar, f.a(intent.getExtras())));
            return true;
        }
    }
}
