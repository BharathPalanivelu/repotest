package com.google.a;

public class p extends RuntimeException {
    static final long serialVersionUID = -4086729973971783390L;

    public p(String str) {
        super(str);
    }

    public p(String str, Throwable th) {
        super(str, th);
    }

    public p(Throwable th) {
        super(th);
    }
}
