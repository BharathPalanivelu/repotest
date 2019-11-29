package com.shopee.app.react;

import android.content.Context;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.react.modules.app.FirebasePerf.FirebasePerfModule;
import com.shopee.app.react.modules.app.LRUCache.LRUCacheModule;
import com.shopee.app.react.modules.app.appmanager.AppManagerModule;
import com.shopee.app.react.modules.app.bundle.BundleManagerModule;
import com.shopee.app.react.modules.app.checker.AppInstallationCheckerModule;
import com.shopee.app.react.modules.app.data.DataBridge;
import com.shopee.app.react.modules.app.data.g;
import com.shopee.app.react.modules.app.datapoint.DataPointModule;
import com.shopee.app.react.modules.app.datastore.DataStoreModule;
import com.shopee.app.react.modules.app.devicescreen.ReactDeviceAutoLockModule;
import com.shopee.app.react.modules.app.fileloader.FileLoaderModule;
import com.shopee.app.react.modules.app.logging.LoggingModule;
import com.shopee.app.react.modules.app.networkinfo.NetworkInfoModule;
import com.shopee.app.react.modules.app.notification.NotiRegisterModule;
import com.shopee.app.react.modules.app.notify.NotifyModule;
import com.shopee.app.react.modules.app.phone.PhoneModule;
import com.shopee.app.react.modules.app.shake.ShakeDetectionModule;
import com.shopee.app.react.modules.app.sms.SMSCodeListenerModule;
import com.shopee.app.react.modules.app.statusbar.StatusBarModule;
import com.shopee.app.react.modules.app.tongdun.ReactTongDunModule;
import com.shopee.app.react.modules.app.tracker.BITrackerModule;
import com.shopee.app.react.modules.app.tracker.BITrackerModuleV2;
import com.shopee.app.react.modules.app.tracker.FacebookTrackerModule;
import com.shopee.app.react.modules.app.tracker.FirebaseTrackerModule;
import com.shopee.app.react.modules.app.tracker.TrackerModule;
import com.shopee.app.react.modules.app.userinfo.UserInfoModule;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.app.react.modules.ui.actionsheet.ActionSheetModule;
import com.shopee.app.react.modules.ui.airpay.ReactAirPayModule;
import com.shopee.app.react.modules.ui.contactpicker.ContactPickerModule;
import com.shopee.app.react.modules.ui.datepicker.DatePickerModule;
import com.shopee.app.react.modules.ui.email.EmailModule;
import com.shopee.app.react.modules.ui.iccamera.ReactIcCamera3Module;
import com.shopee.app.react.modules.ui.imagepicker.ImagePickerModule;
import com.shopee.app.react.modules.ui.location.LocationModule;
import com.shopee.app.react.modules.ui.login.LoginModule;
import com.shopee.app.react.modules.ui.materialdialog.MaterialDialogModule;
import com.shopee.app.react.modules.ui.mediabrowser.MediaBrowserModule;
import com.shopee.app.react.modules.ui.navbar.NavbarModule;
import com.shopee.app.react.modules.ui.navigator.NavigateModule;
import com.shopee.app.react.modules.ui.product.AddToCartModule;
import com.shopee.app.react.modules.ui.product.CoinAnimationModule;
import com.shopee.app.react.modules.ui.progress.ProgressModule;
import com.shopee.app.react.modules.ui.search.SearchModule;
import com.shopee.app.react.modules.ui.share.ShareModule;
import com.shopee.app.react.modules.ui.tab.TabModule;
import com.shopee.app.react.modules.ui.video.VideoPlayerModule;
import com.shopee.app.react.view.bigimage.RNBigImageViewManager;
import com.shopee.app.react.view.effectimage.RNEffectImageViewManager;
import com.shopee.app.react.view.grayscale.RNGrayScaleViewManager;
import com.shopee.app.react.view.mediabrowserview.MediaBrowserViewManager;
import com.shopee.app.react.view.modiface.ModiFaceImageViewManager;
import com.shopee.app.react.view.modiface.ModiFaceViewManager;
import com.shopee.app.react.view.pager.RNViewPagerItemViewManager;
import com.shopee.app.react.view.pager.RNViewPagerManager;
import com.shopee.app.react.view.qrview.QRViewManager;
import com.shopee.app.react.view.rnreturnlistview.RNReturnListViewManager;
import com.shopee.app.react.view.sketchview.SketchViewManager;
import com.shopee.app.react.view.video.VideoViewManager;
import com.shopee.app.react.view.video.live.LiveVideoViewManager;
import com.shopee.app.tracking.d;
import com.shopee.app.tracking.e;
import com.shopee.app.util.n;
import com.shopee.react.sdk.bridge.modules.app.cookie.CookieModule;
import com.shopee.react.sdk.bridge.modules.app.edcprinter.EDCPrinterModule;
import com.shopee.react.sdk.bridge.modules.app.permissions.AppPermissionModule;
import com.shopee.react.sdk.bridge.modules.app.toast.ToastModule;
import com.shopee.react.sdk.bridge.modules.app.toast.b;
import java.util.ArrayList;
import java.util.List;

public class a implements ReactPackage {

    /* renamed from: a  reason: collision with root package name */
    private n f18550a;

    /* renamed from: b  reason: collision with root package name */
    private SettingConfigStore f18551b;

    /* renamed from: c  reason: collision with root package name */
    private UserInfo f18552c;

    /* renamed from: d  reason: collision with root package name */
    private aa f18553d;

    /* renamed from: e  reason: collision with root package name */
    private g f18554e;

    /* renamed from: f  reason: collision with root package name */
    private com.shopee.app.util.e.a f18555f;

    a(n nVar, SettingConfigStore settingConfigStore, UserInfo userInfo, aa aaVar, g gVar, com.shopee.app.util.e.a aVar) {
        this.f18550a = nVar;
        this.f18551b = settingConfigStore;
        this.f18552c = userInfo;
        this.f18553d = aaVar;
        this.f18554e = gVar;
        this.f18555f = aVar;
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NavigateModule(reactApplicationContext));
        arrayList.add(new NetworkInfoModule(reactApplicationContext));
        arrayList.add(new MaterialDialogModule(reactApplicationContext));
        arrayList.add(new DataStoreModule(reactApplicationContext));
        arrayList.add(new EmailModule(reactApplicationContext));
        arrayList.add(new UserInfoModule(reactApplicationContext));
        arrayList.add(new TrackerModule(reactApplicationContext));
        arrayList.add(new AppManagerModule(reactApplicationContext));
        arrayList.add(new NavbarModule(reactApplicationContext));
        arrayList.add(new CookieModule(reactApplicationContext, new com.shopee.react.sdk.bridge.modules.app.cookie.a(reactApplicationContext)));
        arrayList.add(new ActionSheetModule(reactApplicationContext));
        arrayList.add(new ToastModule(reactApplicationContext, new b()));
        arrayList.add(new DatePickerModule(reactApplicationContext));
        arrayList.add(new ContactPickerModule(reactApplicationContext));
        arrayList.add(new PhoneModule(reactApplicationContext));
        arrayList.add(new ProgressModule(reactApplicationContext));
        arrayList.add(new ImagePickerModule(reactApplicationContext));
        arrayList.add(new FileLoaderModule(reactApplicationContext));
        arrayList.add(new MediaBrowserModule(reactApplicationContext));
        arrayList.add(new SearchModule(reactApplicationContext));
        arrayList.add(new ShareModule(reactApplicationContext));
        arrayList.add(new LoginModule(reactApplicationContext));
        arrayList.add(new VideoPlayerModule(reactApplicationContext));
        arrayList.add(new LocationModule(reactApplicationContext));
        arrayList.add(new LoggingModule(reactApplicationContext));
        arrayList.add(new NotiRegisterModule(reactApplicationContext));
        arrayList.add(new AddToCartModule(reactApplicationContext));
        arrayList.add(new NotifyModule(reactApplicationContext));
        arrayList.add(new TabModule(reactApplicationContext));
        arrayList.add(new BundleManagerModule(reactApplicationContext));
        arrayList.add(new ReactTongDunModule(reactApplicationContext));
        arrayList.add(new AppInstallationCheckerModule(reactApplicationContext));
        arrayList.add(new StatusBarModule(reactApplicationContext));
        arrayList.add(new ReactIcCamera3Module(reactApplicationContext));
        arrayList.add(new AbTestingModule(reactApplicationContext, com.shopee.app.react.modules.ui.abtesting.b.f18796a));
        arrayList.add(new DataBridge(reactApplicationContext, this.f18554e));
        arrayList.add(new SMSCodeListenerModule(reactApplicationContext, this.f18550a));
        arrayList.add(new ShakeDetectionModule(reactApplicationContext));
        arrayList.add(new AppPermissionModule(reactApplicationContext, new com.shopee.app.react.modules.app.permissions.a()));
        arrayList.add(new DataPointModule(reactApplicationContext));
        arrayList.add(new CoinAnimationModule(this.f18551b, reactApplicationContext));
        arrayList.add(new LRUCacheModule(reactApplicationContext));
        arrayList.add(new FirebasePerfModule(reactApplicationContext, new com.shopee.app.react.modules.app.FirebasePerf.a()));
        com.shopee.app.tracking.a aVar = new com.shopee.app.tracking.a(this.f18551b, this.f18552c, this.f18553d);
        arrayList.add(new BITrackerModule(reactApplicationContext, aVar));
        arrayList.add(new BITrackerModuleV2(reactApplicationContext, aVar));
        arrayList.add(new FirebaseTrackerModule(reactApplicationContext, e.a((Context) reactApplicationContext)));
        arrayList.add(new FacebookTrackerModule(reactApplicationContext, d.a((Context) reactApplicationContext)));
        arrayList.add(new ReactDeviceAutoLockModule(reactApplicationContext, this.f18555f));
        arrayList.add(new ReactAirPayModule(reactApplicationContext));
        arrayList.add(new EDCPrinterModule(reactApplicationContext, new com.shopee.app.react.modules.app.a.b(reactApplicationContext)));
        return arrayList;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VideoViewManager());
        arrayList.add(new RNViewPagerManager());
        arrayList.add(new RNViewPagerItemViewManager());
        arrayList.add(new RNBigImageViewManager());
        arrayList.add(new RNGrayScaleViewManager());
        arrayList.add(new RNEffectImageViewManager());
        arrayList.add(new QRViewManager());
        arrayList.add(new RNReturnListViewManager(reactApplicationContext));
        arrayList.add(new SketchViewManager());
        arrayList.add(new ModiFaceViewManager());
        arrayList.add(new ModiFaceImageViewManager());
        arrayList.add(new MediaBrowserViewManager());
        arrayList.add(new LiveVideoViewManager());
        return arrayList;
    }
}
