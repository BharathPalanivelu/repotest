package com.shopee.app.application;

import android.content.Context;
import android.os.Build;
import com.facebook.share.internal.ShareConstants;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ak;
import com.shopee.app.util.i;
import com.shopee.app.util.l;
import com.shopee.shopeetracker.ShopeeTracker;
import com.shopee.shopeetracker.bimodel.TrackingCookie;
import com.shopee.shopeetracker.bimodel.TrackingMeta;
import com.shopee.shopeetracker.utils.ExceptionHandler;
import d.d.b.j;
import d.d.b.k;

public final class au {
    public static final void a(Context context, SettingConfigStore settingConfigStore) {
        j.b(context, "context");
        j.b(settingConfigStore, "configStore");
        ShopeeTracker.initialize(new ShopeeTracker.Builder(context, i.f7038a, "/batchrecord", "/batchtracking").setConfigUrl("http://content.garena.com/shopee/track_config/conf.json").addConfig(ShareConstants.FEED_SOURCE_PARAM, "android_app").addConfig("url", l.A).setTrackingUrlV2(i.f7044g).setEnabled(settingConfigStore.biEnabled()).setMonitorEnabled(true).setHandler(a.f15872a));
        a();
    }

    static final class a implements ExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        public static final a f15872a = new a();

        a() {
        }

        public final void onException(Throwable th) {
            com.garena.android.appkit.d.a.a(th);
        }
    }

    static final class b extends k implements d.d.a.a<TrackingMeta> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f15873a = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final TrackingMeta invoke() {
            TrackingMeta trackingMeta = new TrackingMeta();
            trackingMeta.app_version = com.shopee.app.react.modules.app.appmanager.a.d();
            trackingMeta.locale = "ID";
            trackingMeta.finger_print = com.shopee.app.react.modules.app.appmanager.a.h();
            trackingMeta.advertising_id = com.shopee.app.react.modules.app.appmanager.a.i();
            trackingMeta.brand = Build.MANUFACTURER;
            trackingMeta.model = Build.MODEL;
            trackingMeta.os = "android";
            trackingMeta.os_version = com.shopee.app.react.modules.app.appmanager.a.j();
            Integer num = (Integer) ak.a().d().b(0);
            String str = null;
            if (num != null && num.intValue() == 0) {
                num = null;
            }
            trackingMeta.userid = num;
            TrackingCookie trackingCookie = new TrackingCookie();
            if (trackingMeta.userid != null) {
                str = String.valueOf(trackingMeta.userid.intValue());
            }
            trackingCookie.SPC_U = str;
            trackingCookie.SPC_F = trackingMeta.finger_print;
            trackingCookie.SPC_T_ID = (String) ak.a().s().b("");
            trackingCookie.SPC_T_IV = (String) ak.a().t().b("");
            trackingMeta.cookies = trackingCookie;
            return trackingMeta;
        }
    }

    public static final void a() {
        ShopeeTracker.getInstance().setTrackingMetaFunction(b.f15873a);
    }
}
