package com.shopee.liveimsdk.custom.c;

import android.os.Handler;

public class c {
    public static void a(b bVar) {
        try {
            bVar.a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(Handler handler, final b bVar) {
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    c.a(bVar);
                }
            });
        }
    }

    public static void a(Handler handler, final b bVar, long j) {
        if (handler != null) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    c.a(bVar);
                }
            }, j);
        }
    }
}
