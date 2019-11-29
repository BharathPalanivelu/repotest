package com.shopee.d.a;

import com.shopee.d.a.a.c;
import com.shopee.d.a.a.d;
import com.shopee.shopeetracker.Injection;

public class a {
    public static void a(final c cVar) {
        Injection.provideScheduleService().execute(new Runnable() {
            public void run() {
                try {
                    new d(cVar).log();
                } catch (Exception unused) {
                }
            }
        });
    }
}
