package com.garena.pay.android.d;

public class a extends Exception {
    c mResult;

    public a(c cVar) {
        this(cVar, (Exception) null);
    }

    public a(int i, String str) {
        this(new c(i, str));
    }

    public a(c cVar, Exception exc) {
        super(cVar.b(), exc);
        this.mResult = cVar;
    }

    public a(int i, String str, Exception exc) {
        this(new c(i, str), exc);
    }

    public c a() {
        return this.mResult;
    }
}
