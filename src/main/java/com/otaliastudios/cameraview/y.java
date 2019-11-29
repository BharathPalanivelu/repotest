package com.otaliastudios.cameraview;

import android.os.Build;
import com.facebook.react.uimanager.ViewProps;
import java.util.HashMap;

abstract class y {
    /* access modifiers changed from: package-private */
    public abstract <T> o a(T t);

    /* access modifiers changed from: package-private */
    public abstract <T> T a(ao aoVar);

    /* access modifiers changed from: package-private */
    public abstract <T> T a(n nVar);

    /* access modifiers changed from: package-private */
    public abstract <T> T a(o oVar);

    /* access modifiers changed from: package-private */
    public abstract <T> T a(x xVar);

    /* access modifiers changed from: package-private */
    public abstract <T> n b(T t);

    /* access modifiers changed from: package-private */
    public abstract <T> ao c(T t);

    /* access modifiers changed from: package-private */
    public abstract <T> x d(T t);

    y() {
    }

    static class a extends y {

        /* renamed from: a  reason: collision with root package name */
        private static final HashMap<o, String> f15688a = new HashMap<>();

        /* renamed from: b  reason: collision with root package name */
        private static final HashMap<ao, String> f15689b = new HashMap<>();

        /* renamed from: c  reason: collision with root package name */
        private static final HashMap<n, Integer> f15690c = new HashMap<>();

        /* renamed from: d  reason: collision with root package name */
        private static final HashMap<x, String> f15691d = new HashMap<>();

        a() {
        }

        static {
            f15688a.put(o.OFF, "off");
            f15688a.put(o.ON, ViewProps.ON);
            f15688a.put(o.AUTO, "auto");
            f15688a.put(o.TORCH, "torch");
            f15690c.put(n.BACK, 0);
            f15690c.put(n.FRONT, 1);
            f15689b.put(ao.AUTO, "auto");
            f15689b.put(ao.INCANDESCENT, "incandescent");
            f15689b.put(ao.FLUORESCENT, "fluorescent");
            f15689b.put(ao.DAYLIGHT, "daylight");
            f15689b.put(ao.CLOUDY, "cloudy-daylight");
            f15691d.put(x.OFF, "auto");
            if (Build.VERSION.SDK_INT >= 17) {
                f15691d.put(x.ON, "hdr");
            } else {
                f15691d.put(x.ON, "hdr");
            }
        }

        /* access modifiers changed from: package-private */
        public <T> T a(o oVar) {
            return f15688a.get(oVar);
        }

        /* access modifiers changed from: package-private */
        public <T> T a(n nVar) {
            return f15690c.get(nVar);
        }

        /* access modifiers changed from: package-private */
        public <T> T a(ao aoVar) {
            return f15689b.get(aoVar);
        }

        /* access modifiers changed from: package-private */
        public <T> T a(x xVar) {
            return f15691d.get(xVar);
        }

        private <T> T a(HashMap<T, ?> hashMap, Object obj) {
            for (T next : hashMap.keySet()) {
                if (hashMap.get(next).equals(obj)) {
                    return next;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public <T> o a(T t) {
            return (o) a(f15688a, t);
        }

        /* access modifiers changed from: package-private */
        public <T> n b(T t) {
            return (n) a(f15690c, t);
        }

        /* access modifiers changed from: package-private */
        public <T> ao c(T t) {
            return (ao) a(f15689b, t);
        }

        /* access modifiers changed from: package-private */
        public <T> x d(T t) {
            return (x) a(f15691d, t);
        }
    }
}
