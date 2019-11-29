package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.a;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1590a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static String f1591b;

    /* renamed from: c  reason: collision with root package name */
    private static Set<String> f1592c = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private static final Object f1593f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static d f1594g;

    /* renamed from: d  reason: collision with root package name */
    private final Context f1595d;

    /* renamed from: e  reason: collision with root package name */
    private final NotificationManager f1596e = ((NotificationManager) this.f1595d.getSystemService("notification"));

    private interface e {
        void a(android.support.v4.app.a aVar) throws RemoteException;
    }

    public static l a(Context context) {
        return new l(context);
    }

    private l(Context context) {
        this.f1595d = context;
    }

    public void a(int i) {
        a((String) null, i);
    }

    public void a(String str, int i) {
        this.f1596e.cancel(str, i);
        if (Build.VERSION.SDK_INT <= 19) {
            a((e) new a(this.f1595d.getPackageName(), i, str));
        }
    }

    public void a() {
        this.f1596e.cancelAll();
        if (Build.VERSION.SDK_INT <= 19) {
            a((e) new a(this.f1595d.getPackageName()));
        }
    }

    public void a(int i, Notification notification) {
        a((String) null, i, notification);
    }

    public void a(String str, int i, Notification notification) {
        if (a(notification)) {
            a((e) new b(this.f1595d.getPackageName(), i, str, notification));
            this.f1596e.cancel(str, i);
            return;
        }
        this.f1596e.notify(str, i, notification);
    }

    public boolean b() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f1596e.areNotificationsEnabled();
        }
        if (Build.VERSION.SDK_INT < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f1595d.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f1595d.getApplicationInfo();
        String packageName = this.f1595d.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            if (((Integer) cls.getMethod("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public static Set<String> b(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f1590a) {
            if (string != null) {
                if (!string.equals(f1591b)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String unflattenFromString : split) {
                        ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                        if (unflattenFromString2 != null) {
                            hashSet.add(unflattenFromString2.getPackageName());
                        }
                    }
                    f1592c = hashSet;
                    f1591b = string;
                }
            }
            set = f1592c;
        }
        return set;
    }

    private static boolean a(Notification notification) {
        Bundle a2 = i.a(notification);
        return a2 != null && a2.getBoolean("android.support.useSideChannel");
    }

    private void a(e eVar) {
        synchronized (f1593f) {
            if (f1594g == null) {
                f1594g = new d(this.f1595d.getApplicationContext());
            }
            f1594g.a(eVar);
        }
    }

    private static class d implements ServiceConnection, Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final Context f1607a;

        /* renamed from: b  reason: collision with root package name */
        private final HandlerThread f1608b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f1609c;

        /* renamed from: d  reason: collision with root package name */
        private final Map<ComponentName, a> f1610d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private Set<String> f1611e = new HashSet();

        d(Context context) {
            this.f1607a = context;
            this.f1608b = new HandlerThread("NotificationManagerCompat");
            this.f1608b.start();
            this.f1609c = new Handler(this.f1608b.getLooper(), this);
        }

        public void a(e eVar) {
            this.f1609c.obtainMessage(0, eVar).sendToTarget();
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                b((e) message.obj);
                return true;
            } else if (i == 1) {
                c cVar = (c) message.obj;
                a(cVar.f1605a, cVar.f1606b);
                return true;
            } else if (i == 2) {
                a((ComponentName) message.obj);
                return true;
            } else if (i != 3) {
                return false;
            } else {
                b((ComponentName) message.obj);
                return true;
            }
        }

        private void b(e eVar) {
            a();
            for (a next : this.f1610d.values()) {
                next.f1615d.add(eVar);
                d(next);
            }
        }

        private void a(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f1610d.get(componentName);
            if (aVar != null) {
                aVar.f1614c = a.C0001a.a(iBinder);
                aVar.f1616e = 0;
                d(aVar);
            }
        }

        private void a(ComponentName componentName) {
            a aVar = this.f1610d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        private void b(ComponentName componentName) {
            a aVar = this.f1610d.get(componentName);
            if (aVar != null) {
                d(aVar);
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f1609c.obtainMessage(1, new c(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f1609c.obtainMessage(2, componentName).sendToTarget();
        }

        private void a() {
            Set<String> b2 = l.b(this.f1607a);
            if (!b2.equals(this.f1611e)) {
                this.f1611e = b2;
                List<ResolveInfo> queryIntentServices = this.f1607a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                HashSet<ComponentName> hashSet = new HashSet<>();
                for (ResolveInfo next : queryIntentServices) {
                    if (b2.contains(next.serviceInfo.packageName)) {
                        ComponentName componentName = new ComponentName(next.serviceInfo.packageName, next.serviceInfo.name);
                        if (next.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.f1610d.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        this.f1610d.put(componentName2, new a(componentName2));
                    }
                }
                Iterator<Map.Entry<ComponentName, a>> it = this.f1610d.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry next2 = it.next();
                    if (!hashSet.contains(next2.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + next2.getKey());
                        }
                        b((a) next2.getValue());
                        it.remove();
                    }
                }
            }
        }

        private boolean a(a aVar) {
            if (aVar.f1613b) {
                return true;
            }
            aVar.f1613b = this.f1607a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f1612a), this, 33);
            if (aVar.f1613b) {
                aVar.f1616e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f1612a);
                this.f1607a.unbindService(this);
            }
            return aVar.f1613b;
        }

        private void b(a aVar) {
            if (aVar.f1613b) {
                this.f1607a.unbindService(this);
                aVar.f1613b = false;
            }
            aVar.f1614c = null;
        }

        private void c(a aVar) {
            if (!this.f1609c.hasMessages(3, aVar.f1612a)) {
                aVar.f1616e++;
                if (aVar.f1616e > 6) {
                    Log.w("NotifManCompat", "Giving up on delivering " + aVar.f1615d.size() + " tasks to " + aVar.f1612a + " after " + aVar.f1616e + " retries");
                    aVar.f1615d.clear();
                    return;
                }
                int i = (1 << (aVar.f1616e - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i + " ms");
                }
                this.f1609c.sendMessageDelayed(this.f1609c.obtainMessage(3, aVar.f1612a), (long) i);
            }
        }

        private void d(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f1612a + ", " + aVar.f1615d.size() + " queued tasks");
            }
            if (!aVar.f1615d.isEmpty()) {
                if (!a(aVar) || aVar.f1614c == null) {
                    c(aVar);
                    return;
                }
                while (true) {
                    e peek = aVar.f1615d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + peek);
                        }
                        peek.a(aVar.f1614c);
                        aVar.f1615d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + aVar.f1612a);
                        }
                    } catch (RemoteException e2) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f1612a, e2);
                    }
                }
                if (!aVar.f1615d.isEmpty()) {
                    c(aVar);
                }
            }
        }

        private static class a {

            /* renamed from: a  reason: collision with root package name */
            final ComponentName f1612a;

            /* renamed from: b  reason: collision with root package name */
            boolean f1613b = false;

            /* renamed from: c  reason: collision with root package name */
            android.support.v4.app.a f1614c;

            /* renamed from: d  reason: collision with root package name */
            ArrayDeque<e> f1615d = new ArrayDeque<>();

            /* renamed from: e  reason: collision with root package name */
            int f1616e = 0;

            a(ComponentName componentName) {
                this.f1612a = componentName;
            }
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        final ComponentName f1605a;

        /* renamed from: b  reason: collision with root package name */
        final IBinder f1606b;

        c(ComponentName componentName, IBinder iBinder) {
            this.f1605a = componentName;
            this.f1606b = iBinder;
        }
    }

    private static class b implements e {

        /* renamed from: a  reason: collision with root package name */
        final String f1601a;

        /* renamed from: b  reason: collision with root package name */
        final int f1602b;

        /* renamed from: c  reason: collision with root package name */
        final String f1603c;

        /* renamed from: d  reason: collision with root package name */
        final Notification f1604d;

        b(String str, int i, String str2, Notification notification) {
            this.f1601a = str;
            this.f1602b = i;
            this.f1603c = str2;
            this.f1604d = notification;
        }

        public void a(android.support.v4.app.a aVar) throws RemoteException {
            aVar.a(this.f1601a, this.f1602b, this.f1603c, this.f1604d);
        }

        public String toString() {
            return "NotifyTask[" + "packageName:" + this.f1601a + ", id:" + this.f1602b + ", tag:" + this.f1603c + "]";
        }
    }

    private static class a implements e {

        /* renamed from: a  reason: collision with root package name */
        final String f1597a;

        /* renamed from: b  reason: collision with root package name */
        final int f1598b;

        /* renamed from: c  reason: collision with root package name */
        final String f1599c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f1600d;

        a(String str) {
            this.f1597a = str;
            this.f1598b = 0;
            this.f1599c = null;
            this.f1600d = true;
        }

        a(String str, int i, String str2) {
            this.f1597a = str;
            this.f1598b = i;
            this.f1599c = str2;
            this.f1600d = false;
        }

        public void a(android.support.v4.app.a aVar) throws RemoteException {
            if (this.f1600d) {
                aVar.a(this.f1597a);
            } else {
                aVar.a(this.f1597a, this.f1598b, this.f1599c);
            }
        }

        public String toString() {
            return "CancelTask[" + "packageName:" + this.f1597a + ", id:" + this.f1598b + ", tag:" + this.f1599c + ", all:" + this.f1600d + "]";
        }
    }
}
