package com.google.android.exoplayer2.source.dash.a;

import java.util.Collections;
import java.util.List;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f11859a;

    /* renamed from: b  reason: collision with root package name */
    public final long f11860b;

    /* renamed from: c  reason: collision with root package name */
    public final List<a> f11861c;

    public d(String str, long j, List<a> list) {
        this.f11859a = str;
        this.f11860b = j;
        this.f11861c = Collections.unmodifiableList(list);
    }

    public int a(int i) {
        int size = this.f11861c.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f11861c.get(i2).f11839b == i) {
                return i2;
            }
        }
        return -1;
    }
}
