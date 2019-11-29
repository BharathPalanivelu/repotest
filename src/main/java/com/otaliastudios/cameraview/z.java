package com.otaliastudios.cameraview;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

class z {

    /* renamed from: a  reason: collision with root package name */
    final OrientationEventListener f15692a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final a f15693b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f15694c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f15695d = -1;

    interface a {
        void a(int i);
    }

    z(Context context, a aVar) {
        this.f15693b = aVar;
        this.f15692a = new OrientationEventListener(context.getApplicationContext(), 3) {
            public void onOrientationChanged(int i) {
                int i2 = 0;
                if (i != -1 && i < 315 && i >= 45) {
                    if (i >= 45 && i < 135) {
                        i2 = 90;
                    } else if (i >= 135 && i < 225) {
                        i2 = 180;
                    } else if (i >= 225 && i < 315) {
                        i2 = 270;
                    }
                }
                if (i2 != z.this.f15694c) {
                    int unused = z.this.f15694c = i2;
                    z.this.f15693b.a(z.this.f15694c);
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 0) {
            this.f15695d = 0;
        } else if (rotation == 1) {
            this.f15695d = 90;
        } else if (rotation == 2) {
            this.f15695d = 180;
        } else if (rotation != 3) {
            this.f15695d = 0;
        } else {
            this.f15695d = 270;
        }
        this.f15692a.enable();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f15692a.disable();
        this.f15695d = -1;
        this.f15694c = -1;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f15695d;
    }
}
