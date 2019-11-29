package com.google.android.libraries.places.internal;

public abstract class gj {
    protected gj() {
    }

    public abstract boolean a(char c2);

    public int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        go.b(i, length);
        while (i < length) {
            if (a(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    gj(byte b2) {
        this();
    }
}
