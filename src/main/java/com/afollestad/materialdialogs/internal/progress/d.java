package com.afollestad.materialdialogs.internal.progress;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

@TargetApi(14)
class d {

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final Interpolator f3218a = new LinearInterpolator();
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final Interpolator f3212a = androidx.core.g.b.b.a(f3213b);

        /* renamed from: b  reason: collision with root package name */
        private static final Path f3213b = new Path();

        static {
            f3213b.moveTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            f3213b.lineTo(0.2f, BitmapDescriptorFactory.HUE_RED);
            f3213b.cubicTo(0.39583334f, BitmapDescriptorFactory.HUE_RED, 0.47484508f, 0.20679761f, 0.59166664f, 0.41708294f);
            f3213b.cubicTo(0.715161f, 0.6393796f, 0.81625f, 0.9745569f, 1.0f, 1.0f);
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final Interpolator f3210a = androidx.core.g.b.b.a(f3211b);

        /* renamed from: b  reason: collision with root package name */
        private static final Path f3211b = new Path();

        static {
            f3211b.moveTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            f3211b.lineTo(0.3665f, BitmapDescriptorFactory.HUE_RED);
            f3211b.cubicTo(0.4725262f, 0.06240991f, 0.6154161f, 0.5f, 0.68325f, 0.5f);
            f3211b.cubicTo(0.7547506f, 0.5f, 0.7572583f, 0.8145101f, 1.0f, 1.0f);
        }
    }

    /* renamed from: com.afollestad.materialdialogs.internal.progress.d$d  reason: collision with other inner class name */
    public static class C0067d {

        /* renamed from: a  reason: collision with root package name */
        public static final Interpolator f3216a = androidx.core.g.b.b.a(f3217b);

        /* renamed from: b  reason: collision with root package name */
        private static final Path f3217b = new Path();

        static {
            f3217b.moveTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            f3217b.cubicTo(0.0375f, BitmapDescriptorFactory.HUE_RED, 0.12876461f, 0.0895381f, 0.25f, 0.21855351f);
            f3217b.cubicTo(0.32241032f, 0.2956106f, 0.43666667f, 0.41759142f, 0.48333332f, 0.48982617f);
            f3217b.cubicTo(0.69f, 0.80972296f, 0.79333335f, 0.95001614f, 1.0f, 1.0f);
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final Interpolator f3214a = androidx.core.g.b.b.a(f3215b);

        /* renamed from: b  reason: collision with root package name */
        private static final Path f3215b = new Path();

        static {
            f3215b.moveTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            f3215b.cubicTo(0.06834272f, 0.019925667f, 0.19220331f, 0.15855429f, 0.33333334f, 0.3492616f);
            f3215b.cubicTo(0.38410434f, 0.41477913f, 0.5494579f, 0.6813603f, 0.6666667f, 0.68279964f);
            f3215b.cubicTo(0.75258625f, 0.6817962f, 0.73725396f, 0.8788962f, 1.0f, 1.0f);
        }
    }

    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public static final Interpolator f3221a = androidx.core.g.b.b.a(f3222b);

        /* renamed from: b  reason: collision with root package name */
        private static final Path f3222b = new Path();

        static {
            f3222b.lineTo(0.5f, BitmapDescriptorFactory.HUE_RED);
            f3222b.cubicTo(0.7f, BitmapDescriptorFactory.HUE_RED, 0.6f, 1.0f, 1.0f, 1.0f);
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public static final Interpolator f3219a = androidx.core.g.b.b.a(f3220b);

        /* renamed from: b  reason: collision with root package name */
        private static final Path f3220b = new Path();

        static {
            f3220b.cubicTo(0.2f, BitmapDescriptorFactory.HUE_RED, 0.1f, 1.0f, 0.5f, 1.0f);
            f3220b.lineTo(1.0f, 1.0f);
        }
    }
}
