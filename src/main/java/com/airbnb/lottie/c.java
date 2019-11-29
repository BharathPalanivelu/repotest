package com.airbnb.lottie;

import android.util.Log;
import androidx.core.d.f;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.HashSet;
import java.util.Set;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3502a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f3503b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private static boolean f3504c = false;

    /* renamed from: d  reason: collision with root package name */
    private static String[] f3505d;

    /* renamed from: e  reason: collision with root package name */
    private static long[] f3506e;

    /* renamed from: f  reason: collision with root package name */
    private static int f3507f = 0;

    /* renamed from: g  reason: collision with root package name */
    private static int f3508g = 0;

    public static void a(String str) {
        if (f3502a) {
            Log.d("LOTTIE", str);
        }
    }

    public static void b(String str) {
        if (!f3503b.contains(str)) {
            Log.w("LOTTIE", str);
            f3503b.add(str);
        }
    }

    public static void c(String str) {
        if (f3504c) {
            int i = f3507f;
            if (i == 20) {
                f3508g++;
                return;
            }
            f3505d[i] = str;
            f3506e[i] = System.nanoTime();
            f.a(str);
            f3507f++;
        }
    }

    public static float d(String str) {
        int i = f3508g;
        if (i > 0) {
            f3508g = i - 1;
            return BitmapDescriptorFactory.HUE_RED;
        } else if (!f3504c) {
            return BitmapDescriptorFactory.HUE_RED;
        } else {
            f3507f--;
            int i2 = f3507f;
            if (i2 == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (str.equals(f3505d[i2])) {
                f.a();
                return ((float) (System.nanoTime() - f3506e[f3507f])) / 1000000.0f;
            } else {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f3505d[f3507f] + ".");
            }
        }
    }
}
