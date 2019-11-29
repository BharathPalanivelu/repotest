package com.shopee.scanner.camera;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.OrientationEventListener;

abstract class d {

    /* renamed from: b  reason: collision with root package name */
    static final SparseIntArray f30304b = new SparseIntArray();

    /* renamed from: a  reason: collision with root package name */
    private final OrientationEventListener f30305a;

    /* renamed from: c  reason: collision with root package name */
    Display f30306c;

    /* renamed from: d  reason: collision with root package name */
    private int f30307d = 0;

    public abstract void a(int i);

    static {
        f30304b.put(0, 0);
        f30304b.put(1, 90);
        f30304b.put(2, 180);
        f30304b.put(3, 270);
    }

    public d(Context context) {
        this.f30305a = new OrientationEventListener(context) {

            /* renamed from: b  reason: collision with root package name */
            private int f30309b = -1;

            public void onOrientationChanged(int i) {
                if (i != -1 && d.this.f30306c != null) {
                    int rotation = d.this.f30306c.getRotation();
                    if (this.f30309b != rotation) {
                        this.f30309b = rotation;
                        d.this.b(d.f30304b.get(rotation));
                    }
                }
            }
        };
    }

    public void a(Display display) {
        this.f30306c = display;
        this.f30305a.enable();
        b(f30304b.get(display.getRotation()));
    }

    public void a() {
        this.f30305a.disable();
        this.f30306c = null;
    }

    public int b() {
        return this.f30307d;
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        this.f30307d = i;
        a(i);
    }
}
