package com.shopee.app.web.bridge.modules;

import android.content.Context;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.application.ar;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import com.shopee.b.a;
import com.shopee.b.a.c;
import d.d.b.j;
import loan.data_point.DeviceLFInfo;

public final class DeviceInfoModule extends WebBridgeModule {
    public a deviceInfoCollector;

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "getDeviceInfo";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceInfoModule(Context context) {
        super(context);
        j.b(context, "context");
    }

    public final a getDeviceInfoCollector() {
        a aVar = this.deviceInfoCollector;
        if (aVar == null) {
            j.b("deviceInfoCollector");
        }
        return aVar;
    }

    public final void setDeviceInfoCollector(a aVar) {
        j.b(aVar, "<set-?>");
        this.deviceInfoCollector = aVar;
    }

    /* access modifiers changed from: protected */
    public void onInit() {
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        a deviceInfoCollector2 = f2.e().deviceInfoCollector();
        j.a((Object) deviceInfoCollector2, "ShopeeApplication.get().…ent.deviceInfoCollector()");
        this.deviceInfoCollector = deviceInfoCollector2;
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        a aVar = this.deviceInfoCollector;
        if (aVar == null) {
            j.b("deviceInfoCollector");
        }
        c a2 = aVar.a();
        DeviceLFInfo build = new DeviceLFInfo.Builder().device_name(a2.f()).android_id(a2.i()).bluetooth_mac_address(a2.h()).brand(a2.e()).build_time(Integer.valueOf((int) a2.j())).hardware(a2.c()).mac_address(a2.g()).manufacturer(a2.a()).model(a2.b()).product(a2.d()).screen_height(Integer.valueOf(a2.n())).screen_width(Integer.valueOf(a2.m())).total_memory(Long.valueOf(a2.k())).total_storage(Long.valueOf(a2.l())).build();
        j.a((Object) build, "deviceLfInfo");
        resolvePromise(new RootBean(build));
    }

    public final void resolvePromise(RootBean rootBean) {
        j.b(rootBean, AbTestingModule.KEY_RESULT);
        WebPromise promise = getPromise();
        if (promise != null) {
            promise.resolve(BridgeResult.Companion.success(rootBean).toJson());
        }
    }

    public static final class RootBean {
        private final DeviceLFInfo deviceinfo_LF;

        public static /* synthetic */ RootBean copy$default(RootBean rootBean, DeviceLFInfo deviceLFInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                deviceLFInfo = rootBean.deviceinfo_LF;
            }
            return rootBean.copy(deviceLFInfo);
        }

        public final DeviceLFInfo component1() {
            return this.deviceinfo_LF;
        }

        public final RootBean copy(DeviceLFInfo deviceLFInfo) {
            j.b(deviceLFInfo, "deviceinfo_LF");
            return new RootBean(deviceLFInfo);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof RootBean) && j.a((Object) this.deviceinfo_LF, (Object) ((RootBean) obj).deviceinfo_LF);
            }
            return true;
        }

        public int hashCode() {
            DeviceLFInfo deviceLFInfo = this.deviceinfo_LF;
            if (deviceLFInfo != null) {
                return deviceLFInfo.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "RootBean(deviceinfo_LF=" + this.deviceinfo_LF + SQLBuilder.PARENTHESES_RIGHT;
        }

        public RootBean(DeviceLFInfo deviceLFInfo) {
            j.b(deviceLFInfo, "deviceinfo_LF");
            this.deviceinfo_LF = deviceLFInfo;
        }

        public final DeviceLFInfo getDeviceinfo_LF() {
            return this.deviceinfo_LF;
        }
    }
}
