package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f11992a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11993b;

    /* renamed from: c  reason: collision with root package name */
    public final List<g> f11994c;

    /* renamed from: d  reason: collision with root package name */
    public final List<d> f11995d;

    /* renamed from: e  reason: collision with root package name */
    public final List<d> f11996e;

    public a(int i, int i2, List<g> list, List<d> list2, List<d> list3) {
        List<d> list4;
        List<d> list5;
        this.f11992a = i;
        this.f11993b = i2;
        this.f11994c = Collections.unmodifiableList(list);
        if (list2 == null) {
            list4 = Collections.emptyList();
        } else {
            list4 = Collections.unmodifiableList(list2);
        }
        this.f11995d = list4;
        if (list3 == null) {
            list5 = Collections.emptyList();
        } else {
            list5 = Collections.unmodifiableList(list3);
        }
        this.f11996e = list5;
    }
}
