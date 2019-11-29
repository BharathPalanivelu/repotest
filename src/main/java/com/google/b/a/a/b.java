package com.google.b.a.a;

import com.google.b.a.i;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final c f13579a = new c(100);

    public static a a() {
        return new b();
    }

    private b() {
    }

    public boolean a(CharSequence charSequence, i.d dVar, boolean z) {
        String a2 = dVar.a();
        if (a2.length() == 0) {
            return false;
        }
        return a(charSequence, this.f13579a.a(a2), z);
    }

    private static boolean a(CharSequence charSequence, Pattern pattern, boolean z) {
        Matcher matcher = pattern.matcher(charSequence);
        if (!matcher.lookingAt()) {
            return false;
        }
        if (matcher.matches()) {
            return true;
        }
        return z;
    }
}
