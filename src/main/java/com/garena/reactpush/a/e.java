package com.garena.reactpush.a;

import android.content.Context;
import java.util.HashSet;
import java.util.Set;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f8333a = new HashSet();

    static {
        f8333a.add("GetContactInteractor");
    }

    public static void a(Context context) {
        context.getSharedPreferences("dev_support_pref", 0).edit().putStringSet("ignored_tags", f8333a).apply();
    }
}
