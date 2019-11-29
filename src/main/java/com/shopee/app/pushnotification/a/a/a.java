package com.shopee.app.pushnotification.a.a;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import com.garena.android.appkit.f.e;
import com.shopee.app.pushnotification.NotificationData;
import com.shopee.app.pushnotification.b;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f18498a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final b.C0275b f18499b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final NotificationManager f18500c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public List<NotificationData> f18501d = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Object f18502e = new Object();

    public a(Context context, b.C0275b bVar, NotificationManager notificationManager) {
        this.f18498a = context;
        this.f18499b = bVar;
        this.f18500c = notificationManager;
    }

    public void a(NotificationData notificationData) {
        e.a().a(new b(notificationData));
    }

    /* renamed from: com.shopee.app.pushnotification.a.a.a$a  reason: collision with other inner class name */
    private class C0274a implements Runnable {
        private C0274a() {
        }

        public void run() {
            LinkedHashMap<Integer, Notification> a2;
            synchronized (a.this.f18502e) {
                a2 = a.this.f18499b.a((List<NotificationData>) a.this.f18501d).a(a.this.f18498a);
                a.this.f18501d.clear();
            }
            for (Map.Entry next : a2.entrySet()) {
                a.this.f18500c.notify(((Integer) next.getKey()).intValue(), (Notification) next.getValue());
            }
        }
    }

    private class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private NotificationData f18505b;

        b(NotificationData notificationData) {
            this.f18505b = notificationData;
        }

        public void run() {
            synchronized (a.this.f18502e) {
                a.this.f18501d.add(this.f18505b);
            }
            org.a.a.a.a("BatchGroupCreator", false);
            org.a.a.a.a(new C0274a(), "BatchGroupCreator", 1000, "NOTIFICATION_JOB_SERIAL");
        }
    }
}
