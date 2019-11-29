package com.google.android.exoplayer2.source.c.a;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.exoplayer2.j;
import java.util.Collections;
import java.util.List;

public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    public final List<C0186a> f11591a;

    /* renamed from: b  reason: collision with root package name */
    public final List<C0186a> f11592b;

    /* renamed from: c  reason: collision with root package name */
    public final List<C0186a> f11593c;

    /* renamed from: d  reason: collision with root package name */
    public final j f11594d;

    /* renamed from: e  reason: collision with root package name */
    public final List<j> f11595e;

    /* renamed from: com.google.android.exoplayer2.source.c.a.a$a  reason: collision with other inner class name */
    public static final class C0186a {

        /* renamed from: a  reason: collision with root package name */
        public final String f11596a;

        /* renamed from: b  reason: collision with root package name */
        public final j f11597b;

        public static C0186a a(String str) {
            return new C0186a(str, j.b(AppEventsConstants.EVENT_PARAM_VALUE_NO, "application/x-mpegURL", (String) null, (String) null, -1, 0, (String) null));
        }

        public C0186a(String str, j jVar) {
            this.f11596a = str;
            this.f11597b = jVar;
        }
    }

    public a(String str, List<C0186a> list, List<C0186a> list2, List<C0186a> list3, j jVar, List<j> list4) {
        super(str);
        this.f11591a = Collections.unmodifiableList(list);
        this.f11592b = Collections.unmodifiableList(list2);
        this.f11593c = Collections.unmodifiableList(list3);
        this.f11594d = jVar;
        this.f11595e = list4 != null ? Collections.unmodifiableList(list4) : null;
    }

    public static a a(String str) {
        List singletonList = Collections.singletonList(C0186a.a(str));
        List emptyList = Collections.emptyList();
        return new a((String) null, singletonList, emptyList, emptyList, (j) null, (List<j>) null);
    }
}
