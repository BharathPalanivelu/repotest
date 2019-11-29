package com.google.android.libraries.places.internal;

final class lq implements mq {

    /* renamed from: b  reason: collision with root package name */
    private static final lz f12943b = new lr();

    /* renamed from: a  reason: collision with root package name */
    private final lz f12944a;

    public lq() {
        this(new ls(ku.f12901a, a()));
    }

    private lq(lz lzVar) {
        this.f12944a = (lz) kx.a(lzVar, "messageInfoFactory");
    }

    public final <T> mp<T> a(Class<T> cls) {
        mr.a((Class<?>) cls);
        ly b2 = this.f12944a.b(cls);
        if (b2.b()) {
            if (kv.class.isAssignableFrom(cls)) {
                return me.a(mr.f12982c, ko.f12882a, b2.c());
            }
            return me.a(mr.f12980a, ko.a(), b2.c());
        } else if (kv.class.isAssignableFrom(cls)) {
            if (a(b2)) {
                return md.a(b2, mh.f12967b, lm.f12938b, mr.f12982c, ko.f12882a, lx.f12953b);
            }
            return md.a(b2, mh.f12967b, lm.f12938b, mr.f12982c, (kn<?>) null, lx.f12953b);
        } else if (a(b2)) {
            return md.a(b2, mh.f12966a, lm.f12937a, mr.f12980a, ko.a(), lx.f12952a);
        } else {
            return md.a(b2, mh.f12966a, lm.f12937a, mr.f12981b, (kn<?>) null, lx.f12952a);
        }
    }

    private static boolean a(ly lyVar) {
        return lyVar.a() == ml.f12968a;
    }

    private static lz a() {
        try {
            return (lz) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return f12943b;
        }
    }
}
