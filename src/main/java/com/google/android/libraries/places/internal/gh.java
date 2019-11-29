package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class gh<T> implements Iterator<T> {

    /* renamed from: a  reason: collision with root package name */
    public gi f6704a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f6705b;

    /* renamed from: c  reason: collision with root package name */
    public final gj f6706c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f6707d;

    /* renamed from: e  reason: collision with root package name */
    public int f6708e;

    /* renamed from: f  reason: collision with root package name */
    public int f6709f;
    @NullableDecl

    /* renamed from: g  reason: collision with root package name */
    private T f6710g;

    protected gh() {
        this.f6704a = gi.NOT_READY;
    }

    /* access modifiers changed from: package-private */
    public abstract int a(int i);

    /* access modifiers changed from: package-private */
    public abstract int b(int i);

    public final boolean hasNext() {
        go.b(this.f6704a != gi.FAILED);
        int ordinal = this.f6704a.ordinal();
        if (ordinal == 0) {
            return true;
        }
        if (ordinal != 2) {
            this.f6704a = gi.FAILED;
            this.f6710g = a();
            if (this.f6704a != gi.DONE) {
                this.f6704a = gi.READY;
                return true;
            }
        }
        return false;
    }

    public final T next() {
        if (hasNext()) {
            this.f6704a = gi.NOT_READY;
            T t = this.f6710g;
            this.f6710g = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    protected gh(gq gqVar, CharSequence charSequence) {
        this();
        this.f6708e = 0;
        this.f6706c = gqVar.f12629a;
        this.f6707d = gqVar.f12630b;
        this.f6709f = gqVar.f12632d;
        this.f6705b = charSequence;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String a() {
        int i;
        int i2 = this.f6708e;
        while (true) {
            int i3 = this.f6708e;
            if (i3 != -1) {
                int a2 = a(i3);
                if (a2 == -1) {
                    a2 = this.f6705b.length();
                    this.f6708e = -1;
                } else {
                    this.f6708e = b(a2);
                }
                int i4 = this.f6708e;
                if (i4 == i2) {
                    this.f6708e = i4 + 1;
                    if (this.f6708e > this.f6705b.length()) {
                        this.f6708e = -1;
                    }
                } else {
                    while (i2 < a2 && this.f6706c.a(this.f6705b.charAt(i2))) {
                        i2++;
                    }
                    while (i > i2 && this.f6706c.a(this.f6705b.charAt(i - 1))) {
                        a2 = i - 1;
                    }
                    if (!this.f6707d || i2 != i) {
                        int i5 = this.f6709f;
                    } else {
                        i2 = this.f6708e;
                    }
                }
            } else {
                this.f6704a = gi.DONE;
                return null;
            }
        }
        int i52 = this.f6709f;
        if (i52 == 1) {
            i = this.f6705b.length();
            this.f6708e = -1;
            while (i > i2 && this.f6706c.a(this.f6705b.charAt(i - 1))) {
                i--;
            }
        } else {
            this.f6709f = i52 - 1;
        }
        return this.f6705b.subSequence(i2, i).toString();
    }
}
