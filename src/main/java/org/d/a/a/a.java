package org.d.a.a;

public class a extends RuntimeException {
    private static final long serialVersionUID = 1;

    public a(String str) {
        super(str, (Throwable) null);
    }

    public a(String str, Exception exc) {
        super(str, exc);
    }
}
