package com.shopee.app.network.c.i;

import android.util.Pair;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.a.o;
import com.shopee.app.application.ar;
import com.shopee.app.network.c.c;
import com.shopee.app.network.c.i.b.d;
import com.shopee.app.network.c.i.b.e;
import com.shopee.app.network.d.b.b;
import com.shopee.app.network.f;
import com.shopee.app.react.g;
import com.shopee.app.react.modules.app.notification.NotiRegisterModule;
import com.shopee.app.web.WebRegister;
import com.shopee.protocol.action.Notification;
import java.io.IOException;
import java.util.HashMap;

public class w extends c implements com.shopee.app.network.a.a<Notification> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public HashMap<Integer, a> f17990a = new HashMap<>();

    public interface a {
        void a(Notification notification);
    }

    public int a() {
        return 24;
    }

    public w() {
        c();
    }

    public void c(byte[] bArr, int i) throws IOException {
        Notification notification = (Notification) f.f18486a.parseFrom(bArr, 0, i, Notification.class);
        com.garena.android.appkit.d.a.b("CMD_Notification: " + notification.noticode, new Object[0]);
        a(notification);
    }

    private void a(final Notification notification) {
        org.a.a.a.a(new Runnable() {
            public void run() {
                int i = 0;
                com.garena.android.appkit.d.a.b("NotificationProcessor: NOTI_CODE:" + notification.noticode, new Object[0]);
                a aVar = (a) w.this.f17990a.get(notification.noticode);
                if (aVar != null) {
                    aVar.a(notification);
                }
                if (notification.ctime != null) {
                    i = notification.ctime.intValue();
                }
                ar.f().e().uiStatusStore().d(i);
                new b().a(notification.id, 0L);
                g a2 = g.a();
                if (a2.b()) {
                    ReactInstanceManager b2 = a2.e().b();
                    if (b2 != null) {
                        ReactContext currentReactContext = b2.getCurrentReactContext();
                        if (currentReactContext != null && ((NotiRegisterModule) currentReactContext.getNativeModule(NotiRegisterModule.class)).getNotifications().contains(notification.noticode)) {
                            o oVar = new o();
                            oVar.a("type", (Number) notification.noticode);
                            oVar.a("data", WebRegister.GSON.b((Object) notification));
                            ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("didReceiveServerEvent", oVar.toString());
                        }
                    }
                }
            }
        }, "NotificationProcessor", "low_priority_processor");
    }

    private void c() {
        this.f17990a.put(1, new com.shopee.app.network.c.i.b.a());
        this.f17990a.put(5, new e());
        this.f17990a.put(15, new com.shopee.app.network.c.i.b.b());
        this.f17990a.put(7, new x());
        this.f17990a.put(22, new y());
        this.f17990a.put(24, new com.shopee.app.network.c.i.b.g());
        this.f17990a.put(25, new com.shopee.app.network.c.i.b.f());
        this.f17990a.put(39, new d());
        this.f17990a.put(26, new com.shopee.app.network.c.i.b.c());
        this.f17990a.put(18, new l());
        this.f17990a.put(20, new k());
        this.f17990a.put(21, new m());
        this.f17990a.put(12, new com.shopee.app.network.c.i.a.a());
        this.f17990a.put(19, new ac());
        this.f17990a.put(23, new p());
        this.f17990a.put(11, new r());
        this.f17990a.put(13, new d());
        this.f17990a.put(2, new z());
        this.f17990a.put(30, new aa());
        this.f17990a.put(3, new o());
        this.f17990a.put(14, new u());
        this.f17990a.put(16, new e());
        this.f17990a.put(4, new q());
        this.f17990a.put(17, new f());
        this.f17990a.put(207, new n());
        this.f17990a.put(27, new ae());
        this.f17990a.put(28, new t());
        this.f17990a.put(29, new ad());
        this.f17990a.put(34, new g());
        this.f17990a.put(33, new j());
        this.f17990a.put(35, new h());
        this.f17990a.put(36, new a());
        this.f17990a.put(37, new i());
        this.f17990a.put(99, new b());
        this.f17990a.put(530, new af());
        this.f17990a.put(147, new ab());
    }

    public Pair<String, Notification> a(byte[] bArr) throws IOException {
        Notification notification = (Notification) f.f18486a.parseFrom(bArr, 0, bArr.length, Notification.class);
        a aVar = this.f17990a.get(notification.noticode);
        if (aVar != null) {
            return new Pair<>(aVar.getClass().getSimpleName(), notification);
        }
        return new Pair<>("UNKNOWN", notification);
    }
}
