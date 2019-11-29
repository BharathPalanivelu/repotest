package com.google.android.exoplayer2.source.c.b;

import java.util.Collections;
import java.util.List;

public abstract class c {
    public final String o;
    public final List<String> p;

    protected c(String str, List<String> list) {
        this.o = str;
        this.p = Collections.unmodifiableList(list);
    }
}
