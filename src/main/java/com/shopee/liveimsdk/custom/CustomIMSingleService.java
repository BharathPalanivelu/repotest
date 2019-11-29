package com.shopee.liveimsdk.custom;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.shopee.liveimsdk.custom.a.a;

public class CustomIMSingleService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private com.shopee.liveimsdk.custom.c.a f29547a;

    public interface a {
        void a(a.d dVar);

        void a(com.shopee.liveimsdk.custom.a.a aVar);

        void a(String str);

        void a(String str, int i);

        void a(String str, String str2);

        void a(String str, String str2, int i);

        void b(String str);

        void b(String str, int i);
    }

    public void onCreate() {
        super.onCreate();
        this.f29547a = new com.shopee.liveimsdk.custom.c.a();
        this.f29547a.a();
    }

    public IBinder onBind(Intent intent) {
        return this.f29547a.a(intent);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f29547a.b();
        this.f29547a = null;
    }
}
