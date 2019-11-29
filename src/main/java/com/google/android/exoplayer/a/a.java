package com.google.android.exoplayer.a;

import android.os.Build;
import java.util.regex.Pattern;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f8946a = ((Build.VERSION.SDK_INT == 23 && Build.VERSION.CODENAME.charAt(0) == 'N') ? 24 : Build.VERSION.SDK_INT);

    /* renamed from: b  reason: collision with root package name */
    public static final String f8947b = Build.DEVICE;

    /* renamed from: c  reason: collision with root package name */
    public static final String f8948c = Build.MANUFACTURER;

    /* renamed from: d  reason: collision with root package name */
    public static final String f8949d = Build.MODEL;

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f8950e = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)(\\.(\\d+))?([Zz]|((\\+|\\-)(\\d\\d):(\\d\\d)))?");

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f8951f = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f8952g = Pattern.compile("%([A-Fa-f0-9]{2})");

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }
}
