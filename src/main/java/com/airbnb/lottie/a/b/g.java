package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.c.b.l;
import java.util.ArrayList;
import java.util.List;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<l, Path>> f3470a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a<Integer, Integer>> f3471b;

    /* renamed from: c  reason: collision with root package name */
    private final List<com.airbnb.lottie.c.b.g> f3472c;

    public g(List<com.airbnb.lottie.c.b.g> list) {
        this.f3472c = list;
        this.f3470a = new ArrayList(list.size());
        this.f3471b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f3470a.add(list.get(i).b().a());
            this.f3471b.add(list.get(i).c().a());
        }
    }

    public List<com.airbnb.lottie.c.b.g> a() {
        return this.f3472c;
    }

    public List<a<l, Path>> b() {
        return this.f3470a;
    }

    public List<a<Integer, Integer>> c() {
        return this.f3471b;
    }
}
