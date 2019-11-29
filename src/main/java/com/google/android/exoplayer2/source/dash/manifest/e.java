package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f12017a;

    /* renamed from: b  reason: collision with root package name */
    public final long f12018b;

    /* renamed from: c  reason: collision with root package name */
    public final List<a> f12019c;

    public e(String str, long j, List<a> list) {
        this.f12017a = str;
        this.f12018b = j;
        this.f12019c = Collections.unmodifiableList(list);
    }

    public int a(int i) {
        int size = this.f12019c.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f12019c.get(i2).f11993b == i) {
                return i2;
            }
        }
        return -1;
    }
}
