package com.shopee.app.a;

import android.app.Activity;
import android.content.Context;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.RegionConfigStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.network.http.a.d;
import com.shopee.app.network.http.a.f;
import com.shopee.app.network.http.a.g;
import com.shopee.app.network.http.a.j;
import com.shopee.app.network.http.a.k;
import com.shopee.app.tracking.c;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.common.i;
import com.shopee.app.ui.common.r;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.n;
import com.shopee.app.web.bridge.WebBridge;
import com.shopee.app.web.bridge.modules.AddReminderModule_;
import com.shopee.app.web.bridge.modules.CancelReminderModule_;
import com.shopee.app.web.bridge.modules.DataPointModule_;
import com.shopee.app.web.bridge.modules.DeviceAutoLockModule;
import com.shopee.app.web.bridge.modules.DeviceInfoModule;
import com.shopee.app.web.bridge.modules.FacebookConnectAccountModule_;
import com.shopee.app.web.bridge.modules.FacebookConnectStatusModule_;
import com.shopee.app.web.bridge.modules.FileDownloaderModule;
import com.shopee.app.web.bridge.modules.GetDataModule;
import com.shopee.app.web.bridge.modules.ICCameraModule3_;
import com.shopee.app.web.bridge.modules.ICImageModule1_;
import com.shopee.app.web.bridge.modules.ICImageModule_;
import com.shopee.app.web.bridge.modules.NavigateAppRLModule;
import com.shopee.app.web.bridge.modules.NfcCommandSendingModule;
import com.shopee.app.web.bridge.modules.NfcSupportDetectingModule;
import com.shopee.app.web.bridge.modules.PermissionCheckModule_;
import com.shopee.app.web.bridge.modules.PermissionRequestModule_;
import com.shopee.app.web.bridge.modules.PostDataModule;
import com.shopee.app.web.bridge.modules.PutFirebaseTraceMetric;
import com.shopee.app.web.bridge.modules.RequestAuthCodeFromCoreAuthModule;
import com.shopee.app.web.bridge.modules.SaveMediaToDeviceAlbumModule_;
import com.shopee.app.web.bridge.modules.SharingModule_;
import com.shopee.app.web.bridge.modules.SharingPanelModule_;
import com.shopee.app.web.bridge.modules.StartFirebaseTrace;
import com.shopee.app.web.bridge.modules.StartShakeDetectionModule;
import com.shopee.app.web.bridge.modules.StopFirebaseTrace;
import com.shopee.app.web.bridge.modules.StopShakeDetectionModule;
import com.shopee.app.web.bridge.modules.TongDunModule_;
import com.shopee.web.sdk.bridge.internal.a;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final com.shopee.app.ui.a.b f15757a;

    public b(com.shopee.app.ui.a.b bVar) {
        this.f15757a = bVar;
    }

    /* access modifiers changed from: package-private */
    public Activity a() {
        return this.f15757a;
    }

    /* access modifiers changed from: package-private */
    public Context b() {
        return this.f15757a;
    }

    public a c() {
        return this.f15757a.v();
    }

    public i d() {
        return this.f15757a.w();
    }

    /* access modifiers changed from: package-private */
    public bc e() {
        return this.f15757a;
    }

    /* access modifiers changed from: package-private */
    public ak f() {
        return new ak(this.f15757a);
    }

    /* access modifiers changed from: package-private */
    public r g() {
        return new r(this.f15757a);
    }

    /* access modifiers changed from: package-private */
    public com.shopee.app.ui.common.a a(n nVar) {
        return new com.shopee.app.ui.common.a(nVar);
    }

    /* access modifiers changed from: package-private */
    public RegionConfig a(RegionConfigStore regionConfigStore) {
        return regionConfigStore.getRegionConfig();
    }

    /* access modifiers changed from: package-private */
    public c a(SettingConfigStore settingConfigStore) {
        return new c(settingConfigStore.biEnabled(), this.f15757a.A(), this.f15757a.j());
    }

    /* access modifiers changed from: package-private */
    public com.shopee.app.tracking.trackingv3.b b(SettingConfigStore settingConfigStore) {
        return settingConfigStore.biEnabled() ? new com.shopee.app.tracking.trackingv3.b(this.f15757a.A(), this.f15757a.j()) : new com.shopee.app.tracking.trackingv3.c();
    }

    /* access modifiers changed from: package-private */
    public com.shopee.app.network.http.a.a a(f.n nVar) {
        return (com.shopee.app.network.http.a.a) nVar.a(com.shopee.app.network.http.a.a.class);
    }

    /* access modifiers changed from: package-private */
    public com.shopee.app.network.http.a.b b(f.n nVar) {
        return (com.shopee.app.network.http.a.b) nVar.a(com.shopee.app.network.http.a.b.class);
    }

    /* access modifiers changed from: package-private */
    public k c(f.n nVar) {
        return (k) nVar.a(k.class);
    }

    /* access modifiers changed from: package-private */
    public f d(f.n nVar) {
        return (f) nVar.a(f.class);
    }

    /* access modifiers changed from: package-private */
    public j e(f.n nVar) {
        return (j) nVar.a(j.class);
    }

    /* access modifiers changed from: package-private */
    public d f(f.n nVar) {
        return (d) nVar.a(d.class);
    }

    /* access modifiers changed from: package-private */
    public g g(f.n nVar) {
        return (g) nVar.a(g.class);
    }

    /* access modifiers changed from: package-private */
    public com.shopee.app.network.http.a.i h(f.n nVar) {
        return (com.shopee.app.network.http.a.i) nVar.a(com.shopee.app.network.http.a.i.class);
    }

    /* access modifiers changed from: package-private */
    public WebBridge a(com.shopee.app.react.modules.app.FirebasePerf.a aVar, com.shopee.app.react.modules.app.data.g gVar, com.shopee.app.util.i.c cVar, com.shopee.app.util.e.a aVar2) {
        return new WebBridge.Builder().addModule(ICImageModule_.getInstance_(this.f15757a)).addModule(ICImageModule1_.getInstance_(this.f15757a)).addModule(ICCameraModule3_.getInstance_(this.f15757a)).addModule(PermissionCheckModule_.getInstance_(this.f15757a)).addModule(PermissionRequestModule_.getInstance_(this.f15757a)).addModule(FacebookConnectStatusModule_.getInstance_(this.f15757a)).addModule(FacebookConnectAccountModule_.getInstance_(this.f15757a)).addModule(SharingModule_.getInstance_(this.f15757a)).addModule(SharingPanelModule_.getInstance_(this.f15757a)).addModule(DataPointModule_.getInstance_(this.f15757a)).addModule(AddReminderModule_.getInstance_(this.f15757a)).addModule(CancelReminderModule_.getInstance_(this.f15757a)).addModule(new RequestAuthCodeFromCoreAuthModule(this.f15757a)).addModule(new StartShakeDetectionModule(this.f15757a)).addModule(new StopShakeDetectionModule(this.f15757a)).addModule(new FileDownloaderModule(this.f15757a)).addModule(TongDunModule_.getInstance_(this.f15757a)).addModule(new StartFirebaseTrace(this.f15757a, aVar)).addModule(new StopFirebaseTrace(this.f15757a, aVar)).addModule(new PutFirebaseTraceMetric(this.f15757a, aVar)).addModule(new NfcSupportDetectingModule(this.f15757a, cVar)).addModule(new NfcCommandSendingModule(this.f15757a, cVar)).addModule(new GetDataModule(this.f15757a, gVar)).addModule(new PostDataModule(this.f15757a, gVar)).addModule(new DeviceAutoLockModule(this.f15757a, aVar2)).addModule(SaveMediaToDeviceAlbumModule_.getInstance_(this.f15757a)).addModule(new DeviceInfoModule(this.f15757a)).addModule(new NavigateAppRLModule(this.f15757a)).build();
    }

    /* access modifiers changed from: package-private */
    public com.shopee.app.a.a.a h() {
        return new com.shopee.app.a.a.a(this.f15757a);
    }

    /* access modifiers changed from: package-private */
    public com.shopee.app.util.m.a i() {
        return new com.shopee.app.util.m.a(this.f15757a);
    }

    /* access modifiers changed from: package-private */
    public com.shopee.app.util.i.c j() {
        return new com.shopee.app.util.i.c(this.f15757a);
    }

    /* access modifiers changed from: package-private */
    public a.C0476a k() {
        return new a.C0476a().a((com.shopee.web.sdk.bridge.internal.b) new com.shopee.web.sdk.bridge.a.c.a(this.f15757a)).a((com.shopee.web.sdk.bridge.internal.b) new com.shopee.app.web2.b.b.a(this.f15757a)).a((com.shopee.web.sdk.bridge.internal.b) new com.shopee.app.web2.b.f.a(this.f15757a)).a((com.shopee.web.sdk.bridge.internal.b) new com.shopee.app.web2.b.f.b(this.f15757a)).a((com.shopee.web.sdk.bridge.internal.b) new com.shopee.app.web2.b.g.a(this.f15757a)).a((com.shopee.web.sdk.bridge.internal.b) new com.shopee.app.web2.b.a.a(this.f15757a)).a((com.shopee.web.sdk.bridge.internal.b) new com.shopee.app.web2.b.c.a(this.f15757a)).a((com.shopee.web.sdk.bridge.internal.b) new com.shopee.app.web2.b.d.c(this.f15757a)).a((com.shopee.web.sdk.bridge.internal.b) new com.shopee.app.web2.b.d.a(this.f15757a)).a((com.shopee.web.sdk.bridge.internal.b) new com.shopee.app.web2.b.e.a(this.f15757a)).a((com.shopee.web.sdk.bridge.internal.b) new com.shopee.app.web2.b.e.c(this.f15757a));
    }
}
