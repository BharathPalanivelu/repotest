package com.shopee.livequiz.c;

import com.garena.android.appkit.d.a;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private Runnable f29696a = new Runnable() {
        public void run() {
            try {
                e.this.a();
            } catch (Exception e2) {
                a.a(e2);
            }
        }
    };

    public abstract void a() throws Exception;

    public Runnable b() {
        return this.f29696a;
    }
}
