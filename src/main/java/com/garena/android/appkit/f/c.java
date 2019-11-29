package com.garena.android.appkit.f;

import com.garena.android.appkit.d.a;

public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Runnable f7674a;

    public c(Runnable runnable) {
        this.f7674a = runnable;
    }

    public void run() {
        try {
            if (this.f7674a != null) {
                this.f7674a.run();
            }
        } catch (Exception e2) {
            a.a(e2);
        } catch (Error e3) {
            a.a(e3);
        }
        this.f7674a = null;
    }
}
