package androidx.d.a;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.g.w;
import androidx.d.a.a;
import androidx.d.a.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;

public abstract class b<T extends b<T>> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public static final d f1954a = new d("translationX") {
        public void a(View view, float f2) {
            view.setTranslationX(f2);
        }

        public float a(View view) {
            return view.getTranslationX();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final d f1955b = new d("translationY") {
        public void a(View view, float f2) {
            view.setTranslationY(f2);
        }

        public float a(View view) {
            return view.getTranslationY();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final d f1956c = new d("translationZ") {
        public void a(View view, float f2) {
            w.c(view, f2);
        }

        public float a(View view) {
            return w.p(view);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final d f1957d = new d("scaleX") {
        public void a(View view, float f2) {
            view.setScaleX(f2);
        }

        public float a(View view) {
            return view.getScaleX();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final d f1958e = new d("scaleY") {
        public void a(View view, float f2) {
            view.setScaleY(f2);
        }

        public float a(View view) {
            return view.getScaleY();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static final d f1959f = new d("rotation") {
        public void a(View view, float f2) {
            view.setRotation(f2);
        }

        public float a(View view) {
            return view.getRotation();
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static final d f1960g = new d("rotationX") {
        public void a(View view, float f2) {
            view.setRotationX(f2);
        }

        public float a(View view) {
            return view.getRotationX();
        }
    };
    public static final d h = new d("rotationY") {
        public void a(View view, float f2) {
            view.setRotationY(f2);
        }

        public float a(View view) {
            return view.getRotationY();
        }
    };
    public static final d i = new d("x") {
        public void a(View view, float f2) {
            view.setX(f2);
        }

        public float a(View view) {
            return view.getX();
        }
    };
    public static final d j = new d("y") {
        public void a(View view, float f2) {
            view.setY(f2);
        }

        public float a(View view) {
            return view.getY();
        }
    };
    public static final d k = new d("z") {
        public void a(View view, float f2) {
            w.d(view, f2);
        }

        public float a(View view) {
            return w.B(view);
        }
    };
    public static final d l = new d("alpha") {
        public void a(View view, float f2) {
            view.setAlpha(f2);
        }

        public float a(View view) {
            return view.getAlpha();
        }
    };
    public static final d m = new d("scrollX") {
        public void a(View view, float f2) {
            view.setScrollX((int) f2);
        }

        public float a(View view) {
            return (float) view.getScrollX();
        }
    };
    public static final d n = new d("scrollY") {
        public void a(View view, float f2) {
            view.setScrollY((int) f2);
        }

        public float a(View view) {
            return (float) view.getScrollY();
        }
    };
    float o = BitmapDescriptorFactory.HUE_RED;
    float p = Float.MAX_VALUE;
    boolean q = false;
    final Object r;
    final c s;
    boolean t = false;
    float u = Float.MAX_VALUE;
    float v = (-this.u);
    private long w = 0;
    private float x;
    private final ArrayList<C0041b> y = new ArrayList<>();
    private final ArrayList<c> z = new ArrayList<>();

    /* renamed from: androidx.d.a.b$b  reason: collision with other inner class name */
    public interface C0041b {
        void a(b bVar, boolean z, float f2, float f3);
    }

    public interface c {
        void a(b bVar, float f2, float f3);
    }

    /* access modifiers changed from: package-private */
    public abstract boolean a(float f2, float f3);

    /* access modifiers changed from: package-private */
    public abstract boolean b(long j2);

    public static abstract class d extends c<View> {
        private d(String str) {
            super(str);
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        float f1961a;

        /* renamed from: b  reason: collision with root package name */
        float f1962b;

        a() {
        }
    }

    <K> b(K k2, c<K> cVar) {
        this.r = k2;
        this.s = cVar;
        c cVar2 = this.s;
        if (cVar2 == f1959f || cVar2 == f1960g || cVar2 == h) {
            this.x = 0.1f;
        } else if (cVar2 == l) {
            this.x = 0.00390625f;
        } else if (cVar2 == f1957d || cVar2 == f1958e) {
            this.x = 0.00390625f;
        } else {
            this.x = 1.0f;
        }
    }

    private static <T> void a(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (!this.t) {
            d();
        }
    }

    public void b() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        } else if (this.t) {
            a(true);
        }
    }

    private void d() {
        if (!this.t) {
            this.t = true;
            if (!this.q) {
                this.p = e();
            }
            float f2 = this.p;
            if (f2 > this.u || f2 < this.v) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            a.a().a(this, 0);
        }
    }

    public boolean a(long j2) {
        long j3 = this.w;
        if (j3 == 0) {
            this.w = j2;
            a(this.p);
            return false;
        }
        this.w = j2;
        boolean b2 = b(j2 - j3);
        this.p = Math.min(this.p, this.u);
        this.p = Math.max(this.p, this.v);
        a(this.p);
        if (b2) {
            a(false);
        }
        return b2;
    }

    private void a(boolean z2) {
        this.t = false;
        a.a().a((a.b) this);
        this.w = 0;
        this.q = false;
        for (int i2 = 0; i2 < this.y.size(); i2++) {
            if (this.y.get(i2) != null) {
                this.y.get(i2).a(this, z2, this.p, this.o);
            }
        }
        a(this.y);
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        this.s.a(this.r, f2);
        for (int i2 = 0; i2 < this.z.size(); i2++) {
            if (this.z.get(i2) != null) {
                this.z.get(i2).a(this, this.p, this.o);
            }
        }
        a(this.z);
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.x * 0.75f;
    }

    private float e() {
        return this.s.a(this.r);
    }
}
