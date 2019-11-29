package com.c.a.c.b.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final int f5741a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5742b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f5743c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5744d;

    interface c {
        int a();

        int b();
    }

    i(a aVar) {
        int i;
        this.f5743c = aVar.f5746b;
        if (b(aVar.f5747c)) {
            i = aVar.i / 2;
        } else {
            i = aVar.i;
        }
        this.f5744d = i;
        int a2 = a(aVar.f5747c, aVar.f5751g, aVar.h);
        float a3 = (float) (aVar.f5748d.a() * aVar.f5748d.b() * 4);
        int round = Math.round(aVar.f5750f * a3);
        int round2 = Math.round(a3 * aVar.f5749e);
        int i2 = a2 - this.f5744d;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.f5742b = round2;
            this.f5741a = round;
        } else {
            float g2 = ((float) i2) / (aVar.f5750f + aVar.f5749e);
            this.f5742b = Math.round(aVar.f5749e * g2);
            this.f5741a = Math.round(g2 * aVar.f5750f);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(a(this.f5742b));
            sb.append(", pool size: ");
            sb.append(a(this.f5741a));
            sb.append(", byte array size: ");
            sb.append(a(this.f5744d));
            sb.append(", memory class limited? ");
            sb.append(i3 > a2);
            sb.append(", max size: ");
            sb.append(a(a2));
            sb.append(", memoryClass: ");
            sb.append(aVar.f5747c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(b(aVar.f5747c));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    public int a() {
        return this.f5742b;
    }

    public int b() {
        return this.f5741a;
    }

    public int c() {
        return this.f5744d;
    }

    private static int a(ActivityManager activityManager, float f2, float f3) {
        boolean b2 = b(activityManager);
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (b2) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    private String a(int i) {
        return Formatter.formatFileSize(this.f5743c, (long) i);
    }

    /* access modifiers changed from: private */
    public static boolean b(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return false;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final int f5745a = (Build.VERSION.SDK_INT < 26 ? 4 : 1);
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final Context f5746b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public ActivityManager f5747c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public c f5748d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public float f5749e = 2.0f;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public float f5750f = ((float) f5745a);
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public float f5751g = 0.4f;
        /* access modifiers changed from: private */
        public float h = 0.33f;
        /* access modifiers changed from: private */
        public int i = 4194304;

        public a(Context context) {
            this.f5746b = context;
            this.f5747c = (ActivityManager) context.getSystemService("activity");
            this.f5748d = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && i.b(this.f5747c)) {
                this.f5750f = BitmapDescriptorFactory.HUE_RED;
            }
        }

        public i a() {
            return new i(this);
        }
    }

    private static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayMetrics f5752a;

        public b(DisplayMetrics displayMetrics) {
            this.f5752a = displayMetrics;
        }

        public int a() {
            return this.f5752a.widthPixels;
        }

        public int b() {
            return this.f5752a.heightPixels;
        }
    }
}
