package com.google.android.exoplayer2.source.dash.a;

import java.util.Collections;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f11838a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11839b;

    /* renamed from: c  reason: collision with root package name */
    public final List<f> f11840c;

    /* renamed from: d  reason: collision with root package name */
    public final List<g> f11841d;

    public a(int i, int i2, List<f> list, List<g> list2) {
        List<g> list3;
        this.f11838a = i;
        this.f11839b = i2;
        this.f11840c = Collections.unmodifiableList(list);
        if (list2 == null) {
            list3 = Collections.emptyList();
        } else {
            list3 = Collections.unmodifiableList(list2);
        }
        this.f11841d = list3;
    }
}
