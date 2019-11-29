package com.shopee.app.pushnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import com.garena.android.appkit.f.f;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.aq;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f18522a;

    /* renamed from: b  reason: collision with root package name */
    private aq f18523b = new aq(ar.f().getSharedPreferences("notification_list", 4));
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final NotificationManager f18524c;

    /* renamed from: d  reason: collision with root package name */
    private com.shopee.app.pushnotification.a.a.a f18525d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public C0275b f18526e = new C0275b() {
        public com.shopee.app.pushnotification.a.c.a a(NotificationData notificationData, List<NotificationData> list) {
            return new com.shopee.app.pushnotification.a.c.a(notificationData, list, list.size());
        }

        public com.shopee.app.pushnotification.a.b.a a(NotificationData notificationData) {
            return new com.shopee.app.pushnotification.a.b.a(notificationData);
        }

        public com.shopee.app.pushnotification.a.a.b a(List<NotificationData> list) {
            return new com.shopee.app.pushnotification.a.a.b(list);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public a f18527f = new a() {
        public void run() {
            if (this.f18536c != null) {
                b.this.f18524c.notify(this.f18535b, this.f18536c);
                this.f18536c = null;
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final List<NotificationData> f18528g = new CopyOnWriteArrayList();

    /* renamed from: com.shopee.app.pushnotification.b$b  reason: collision with other inner class name */
    public interface C0275b {
        com.shopee.app.pushnotification.a.a.b a(List<NotificationData> list);

        com.shopee.app.pushnotification.a.b.a a(NotificationData notificationData);

        com.shopee.app.pushnotification.a.c.a a(NotificationData notificationData, List<NotificationData> list);
    }

    b(Context context) {
        this.f18522a = context;
        this.f18524c = (NotificationManager) context.getSystemService("notification");
        this.f18525d = new com.shopee.app.pushnotification.a.a.a(this.f18522a, this.f18526e, this.f18524c);
        a.a(context, this.f18524c);
    }

    public void a(NotificationData notificationData) {
        b(notificationData);
    }

    private void b(final NotificationData notificationData) {
        if (this.f18526e == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            notificationData.setInGroup(true);
            this.f18525d.a(notificationData);
            return;
        }
        final ArrayList arrayList = new ArrayList();
        final boolean a2 = a(notificationData, (List<NotificationData>) arrayList);
        org.a.a.a.a(new Runnable() {
            public void run() {
                if (a2 || !notificationData.isStacked()) {
                    Notification d2 = b.this.f18526e.a(notificationData).d(b.this.f18522a);
                    b.this.a(d2);
                    b.this.f18527f.a(notificationData.getId(), d2);
                    return;
                }
                Notification b2 = b.this.f18526e.a(notificationData, arrayList).b(b.this.f18522a);
                b.this.a(b2);
                b.this.f18527f.a(notificationData.getId(), b2);
            }
        }, "", "NOTIFICATION_JOB_SERIAL");
        this.f18528g.add(notificationData);
        a(this.f18528g);
    }

    private boolean a(NotificationData notificationData, List<NotificationData> list) {
        boolean z = true;
        for (NotificationData next : b()) {
            if (next.getId() == notificationData.getId()) {
                list.add(next);
                z = false;
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    public void a(Notification notification) {
        notification.ledARGB = -33275;
        notification.flags |= 1;
        notification.ledOnMS = 800;
        notification.ledOffMS = 1600;
        if (Build.VERSION.SDK_INT >= 21) {
            notification.priority = 1;
        }
    }

    private List<NotificationData> b() {
        this.f18528g.clear();
        this.f18528g.addAll(d());
        return this.f18528g;
    }

    public void a() {
        for (NotificationData id : this.f18528g) {
            this.f18524c.cancel(id.getId());
        }
        this.f18528g.clear();
        a((List<NotificationData>) null);
    }

    private void a(List<NotificationData> list) {
        if (list == null || list.isEmpty()) {
            this.f18523b.a((List<String>) null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (NotificationData notificationData : list) {
            arrayList.add(notificationData.toString());
        }
        this.f18523b.a(arrayList);
    }

    private aq c() {
        return new aq(ar.f().getSharedPreferences("notification_list", 4));
    }

    private List<NotificationData> d() {
        this.f18523b = c();
        List<String> a2 = this.f18523b.a();
        if (a2 == null || a2.size() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (String fromString : a2) {
                arrayList.add(NotificationData.fromString(fromString));
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    private static abstract class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        protected int f18535b;

        /* renamed from: c  reason: collision with root package name */
        protected Notification f18536c;

        private a() {
            this.f18535b = 0;
        }

        public void a(int i) {
            this.f18535b = i;
        }

        public void a(Notification notification) {
            this.f18536c = notification;
        }

        public void a(int i, Notification notification) {
            if (!(i == this.f18535b || this.f18536c == null)) {
                run();
            }
            a(i);
            a(notification);
            f.a().b(this);
            f.a().a(this, 1000);
        }
    }
}
