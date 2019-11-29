package com.android.b;

public class s extends Exception {
    public final i networkResponse;

    public s() {
        this.networkResponse = null;
    }

    public s(i iVar) {
        this.networkResponse = iVar;
    }

    public s(Throwable th) {
        super(th);
        this.networkResponse = null;
    }
}
