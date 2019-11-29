package com.c.a;

import com.c.a.g.b.a;
import com.c.a.g.b.c;
import com.c.a.k;

public abstract class k<CHILD extends k<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private c<? super TranscodeType> f6271a = a.a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final CHILD clone() {
        try {
            return (k) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final c<? super TranscodeType> b() {
        return this.f6271a;
    }
}
