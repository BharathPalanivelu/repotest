package com.google.android.exoplayer2.source.c.b;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.exoplayer2.Format;
import java.util.Collections;
import java.util.List;

public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    public final List<C0187a> f11637a;

    /* renamed from: b  reason: collision with root package name */
    public final List<C0187a> f11638b;

    /* renamed from: c  reason: collision with root package name */
    public final List<C0187a> f11639c;

    /* renamed from: d  reason: collision with root package name */
    public final Format f11640d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Format> f11641e;

    /* renamed from: com.google.android.exoplayer2.source.c.b.a$a  reason: collision with other inner class name */
    public static final class C0187a {

        /* renamed from: a  reason: collision with root package name */
        public final String f11642a;

        /* renamed from: b  reason: collision with root package name */
        public final Format f11643b;

        public static C0187a a(String str) {
            return new C0187a(str, Format.b(AppEventsConstants.EVENT_PARAM_VALUE_NO, "application/x-mpegURL", (String) null, (String) null, -1, 0, (String) null));
        }

        public C0187a(String str, Format format) {
            this.f11642a = str;
            this.f11643b = format;
        }
    }

    public a(String str, List<String> list, List<C0187a> list2, List<C0187a> list3, List<C0187a> list4, Format format, List<Format> list5) {
        super(str, list);
        this.f11637a = Collections.unmodifiableList(list2);
        this.f11638b = Collections.unmodifiableList(list3);
        this.f11639c = Collections.unmodifiableList(list4);
        this.f11640d = format;
        this.f11641e = list5 != null ? Collections.unmodifiableList(list5) : null;
    }

    public static a a(String str) {
        List singletonList = Collections.singletonList(C0187a.a(str));
        List emptyList = Collections.emptyList();
        return new a((String) null, Collections.emptyList(), singletonList, emptyList, emptyList, (Format) null, (List<Format>) null);
    }
}
