package com.google.android.play.core.missingsplits;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference<Boolean> f6746a = new AtomicReference<>((Object) null);

    public static a a(Context context) {
        return new d(context, Runtime.getRuntime(), new c(context, context.getPackageManager()), f6746a);
    }
}
