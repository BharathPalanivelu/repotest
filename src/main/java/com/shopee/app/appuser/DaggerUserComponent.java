package com.shopee.app.appuser;

import b.a.c;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.application.ar;
import com.shopee.app.application.b;
import com.shopee.app.d.c.am;
import com.shopee.app.d.c.f.n;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.RegionConfigStore;
import com.shopee.app.data.store.SearchKeywordsStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ShareConfigStore;
import com.shopee.app.data.store.WebDataStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.ae;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.aj;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.ap;
import com.shopee.app.data.store.as;
import com.shopee.app.data.store.au;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.az;
import com.shopee.app.data.store.ba;
import com.shopee.app.data.store.bb;
import com.shopee.app.data.store.bd;
import com.shopee.app.data.store.be;
import com.shopee.app.data.store.bf;
import com.shopee.app.data.store.bg;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.d;
import com.shopee.app.data.store.h;
import com.shopee.app.data.store.j;
import com.shopee.app.data.store.jobdispatcher.DataPointJobConfigStore;
import com.shopee.app.data.store.jobdispatcher.ReactJobConfigStore;
import com.shopee.app.data.store.o;
import com.shopee.app.data.store.q;
import com.shopee.app.data.store.t;
import com.shopee.app.data.store.theme.ThemeStore;
import com.shopee.app.data.store.v;
import com.shopee.app.data.store.w;
import com.shopee.app.data.store.x;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActionRequiredCounter_MembersInjector;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.data.viewmodel.ActivityCounter_MembersInjector;
import com.shopee.app.data.viewmodel.ChatCounter;
import com.shopee.app.data.viewmodel.ChatCounter_MembersInjector;
import com.shopee.app.data.viewmodel.FollowCounter;
import com.shopee.app.data.viewmodel.FollowCounter_MembersInjector;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.data.viewmodel.MeCounter_MembersInjector;
import com.shopee.app.h.p;
import com.shopee.app.instagram.e;
import com.shopee.app.network.c.a.b;
import com.shopee.app.network.c.aa;
import com.shopee.app.network.c.ab;
import com.shopee.app.network.c.ac;
import com.shopee.app.network.c.ad;
import com.shopee.app.network.c.ae;
import com.shopee.app.network.c.af;
import com.shopee.app.network.c.ag;
import com.shopee.app.network.c.ah;
import com.shopee.app.network.c.ai;
import com.shopee.app.network.c.aj;
import com.shopee.app.network.c.ak;
import com.shopee.app.network.c.am;
import com.shopee.app.network.c.an;
import com.shopee.app.network.c.ao;
import com.shopee.app.network.c.ap;
import com.shopee.app.network.c.aq;
import com.shopee.app.network.c.ar;
import com.shopee.app.network.c.at;
import com.shopee.app.network.c.au;
import com.shopee.app.network.c.aw;
import com.shopee.app.network.c.ax;
import com.shopee.app.network.c.ay;
import com.shopee.app.network.c.b.b;
import com.shopee.app.network.c.b.f;
import com.shopee.app.network.c.ba;
import com.shopee.app.network.c.bb;
import com.shopee.app.network.c.bc;
import com.shopee.app.network.c.bd;
import com.shopee.app.network.c.be;
import com.shopee.app.network.c.bh;
import com.shopee.app.network.c.bk;
import com.shopee.app.network.c.bl;
import com.shopee.app.network.c.bm;
import com.shopee.app.network.c.bo;
import com.shopee.app.network.c.bp;
import com.shopee.app.network.c.c.a;
import com.shopee.app.network.c.c.b;
import com.shopee.app.network.c.c.c;
import com.shopee.app.network.c.c.d;
import com.shopee.app.network.c.d;
import com.shopee.app.network.c.e;
import com.shopee.app.network.c.f;
import com.shopee.app.network.c.f.a;
import com.shopee.app.network.c.f.b;
import com.shopee.app.network.c.g.a;
import com.shopee.app.network.c.g.b;
import com.shopee.app.network.c.h;
import com.shopee.app.network.c.h.b;
import com.shopee.app.network.c.h.f;
import com.shopee.app.network.c.h.g;
import com.shopee.app.network.c.h.i;
import com.shopee.app.network.c.i;
import com.shopee.app.network.c.i.a;
import com.shopee.app.network.c.i.a.a;
import com.shopee.app.network.c.i.ab;
import com.shopee.app.network.c.i.ac;
import com.shopee.app.network.c.i.b;
import com.shopee.app.network.c.i.b.h;
import com.shopee.app.network.c.i.h;
import com.shopee.app.network.c.i.i;
import com.shopee.app.network.c.i.k;
import com.shopee.app.network.c.i.l;
import com.shopee.app.network.c.i.p;
import com.shopee.app.network.c.i.r;
import com.shopee.app.network.c.i.u;
import com.shopee.app.network.c.j.a;
import com.shopee.app.network.c.j.c;
import com.shopee.app.network.c.j.d;
import com.shopee.app.network.c.k;
import com.shopee.app.network.c.k.f;
import com.shopee.app.network.c.k.i;
import com.shopee.app.network.c.k.j;
import com.shopee.app.network.c.k.l;
import com.shopee.app.network.c.k.m;
import com.shopee.app.network.c.k.n;
import com.shopee.app.network.c.k.o;
import com.shopee.app.network.c.l;
import com.shopee.app.network.c.l.a;
import com.shopee.app.network.c.l.d;
import com.shopee.app.network.c.m;
import com.shopee.app.network.c.n;
import com.shopee.app.network.c.s;
import com.shopee.app.network.c.t;
import com.shopee.app.network.c.u;
import com.shopee.app.network.c.w;
import com.shopee.app.network.c.x;
import com.shopee.app.network.c.y;
import com.shopee.app.network.d;
import com.shopee.app.pushnotification.fcm.ShopeeFcmListenerService;
import com.shopee.app.react.f.a;
import com.shopee.app.react.f.b;
import com.shopee.app.react.modules.app.data.g;
import com.shopee.app.react.modules.app.data.k;
import com.shopee.app.react.modules.app.data.m;
import com.shopee.app.tracking.a;
import com.shopee.app.tracking.f;
import com.shopee.app.ui.product.add.ak;
import com.shopee.app.upload.UploadJob;
import com.shopee.app.upload.UploadJob_MembersInjector;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.upload.UploadStore;
import com.shopee.app.util.bi;
import com.shopee.app.util.s;
import com.shopee.app.web.processor.WebBAStatusChangedProcessor;
import com.shopee.app.web.processor.WebCancelOrderProcessor;
import com.shopee.app.web.processor.WebCreateNewCheckoutProcessor;
import com.shopee.app.web.processor.WebFollowUserUpdateProcessor;
import com.shopee.app.web.processor.WebOnAddressSetProcessor;
import com.shopee.app.web.processor.WebOnArchiveReturnProcessor;
import com.shopee.app.web.processor.WebPassDataItemShippingProcessor;
import com.shopee.app.web.processor.WebReturnUpdateProcessor;
import com.shopee.app.web.processor.WebSplitCheckoutProcessor;
import com.shopee.app.web.processor.WebUpdateMyShopInfoProcessor;
import com.shopee.app.web.processor.WebUpdateUserAddressProcessor;
import com.shopee.app.web.processor.WebUpdateUserInfoProcessor;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class DaggerUserComponent implements UserComponent {
    private com_shopee_app_application_ApplicationComponent_app appProvider;
    private b applicationComponent;
    private Provider<x> customerOrderCountStoreProvider;
    private com_shopee_app_application_ApplicationComponent_dataEventBus dataEventBusProvider;
    private com_shopee_app_application_ApplicationComponent_deviceStore deviceStoreProvider;
    private com_shopee_app_application_ApplicationComponent_loginStore loginStoreProvider;
    private Provider<com.shopee.app.data.store.b> provideActionIdListStoreProvider;
    private Provider<ActionRequiredCounter> provideActionRequiredCounterProvider;
    private Provider<a> provideActionTrackerProvider;
    private Provider<ActivityCounter> provideActivityCounterProvider;
    private Provider<d> provideActivityIdStoreProvider;
    private Provider<h> provideBannerStoreProvider;
    private Provider<j> provideBlacklistStoreProvider;
    private Provider<ChatBadgeStore> provideChatBadgeStoreProvider;
    private Provider<ChatCounter> provideChatCounterProvider;
    private Provider<o> provideChatListLoadingStoreProvider;
    private Provider<q> provideCheckoutIdStoreProvider;
    private Provider<w> provideCustomerOrderIdStoreProvider;
    private Provider<g> provideDataBridgeHelperProvider;
    private Provider<DataPointJobConfigStore> provideDataPointJobConfigStoreProvider;
    private Provider<s> provideFeatureToggleManagerProvider;
    private Provider<FollowCounter> provideFollowCounterProvider;
    private Provider<e> provideInstagramClientProvider;
    private Provider<UserInfo> provideLoggedInUserProvider;
    private Provider<com.shopee.app.network.http.a.h> provideLogoutAPIProvider;
    private Provider<MeCounter> provideMeCounterProvider;
    private Provider<ap> provideMyCustomerIdStoreProvider;
    private Provider<com.shopee.app.data.store.c.a> provideOrderCountStoreProvider;
    private Provider<az> provideProductIdListStoreProvider;
    private Provider<com.shopee.app.util.k.h> provideProductUploadMangerProvider;
    private Provider<ba> provideProductUploadStoreProvider;
    private Provider<bb> provideRatingShopeeStoreProvider;
    private Provider<ReactJobConfigStore> provideReactJobConfigStoreProvider;
    private Provider<com.shopee.app.data.store.c.d> provideReturnIdStoreProvider;
    private Provider<SearchKeywordsStore> provideSearchKeywordsStoreProvider;
    private Provider<com.shopee.app.ui.tracklog.b> provideTrackTrakLoggerProvider;
    private Provider<f> provideTrackerProvider;
    private Provider<com.shopee.app.ui.product.twitter.e> provideTwitterClientProvider;
    private Provider<be> provideUIStatusStoreProvider;
    private Provider<UploadStore> provideUploadStoreProvider;
    private Provider<WebDataStore> provideWebDataStoreProvider;
    private com_shopee_app_application_ApplicationComponent_retrofit retrofitProvider;
    private com_shopee_app_application_ApplicationComponent_settingConfigStore settingConfigStoreProvider;
    private m themeConfigUpdaterProvider;
    private com_shopee_app_application_ApplicationComponent_themeStore themeStoreProvider;
    private Provider<bf> unreadStoreProvider;

    public void inject(ShopeeFcmListenerService shopeeFcmListenerService) {
    }

    private DaggerUserComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private com.shopee.app.d.c.f.m getRequestPChatListInteractor() {
        return n.a((com.shopee.app.util.n) c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.provideChatListLoadingStoreProvider.get());
    }

    private am getGetFBFriendListInteractor() {
        return new am((com.shopee.app.util.n) c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (aa) c.a(this.applicationComponent.deviceStore(), "Cannot return null from a non-@Nullable component method"), this.provideUIStatusStoreProvider.get(), new aj());
    }

    private com.shopee.app.util.f.a getFileUploader() {
        return new com.shopee.app.util.f.a((p) c.a(this.applicationComponent.serverManager(), "Cannot return null from a non-@Nullable component method"), this.provideLoggedInUserProvider.get());
    }

    private com.shopee.app.ui.product.add.aj getPostToFacebookPageInteractor() {
        return ak.a((com.shopee.app.util.n) c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.provideUIStatusStoreProvider.get());
    }

    private UploadManager getUploadManager() {
        return new UploadManager(this.provideUploadStoreProvider.get());
    }

    private void initialize(Builder builder) {
        this.applicationComponent = builder.applicationComponent;
        this.provideLoggedInUserProvider = b.a.a.a(UserModule_ProvideLoggedInUserFactory.create(builder.userModule));
        this.provideActivityCounterProvider = b.a.a.a(UserModule_ProvideActivityCounterFactory.create(builder.userModule));
        this.provideFollowCounterProvider = b.a.a.a(UserModule_ProvideFollowCounterFactory.create(builder.userModule));
        this.provideChatBadgeStoreProvider = b.a.a.a(UserModule_ProvideChatBadgeStoreFactory.create(builder.userModule));
        this.provideChatListLoadingStoreProvider = b.a.a.a(UserModule_ProvideChatListLoadingStoreFactory.create(builder.userModule));
        this.provideProductIdListStoreProvider = b.a.a.a(UserModule_ProvideProductIdListStoreFactory.create(builder.userModule));
        this.provideUIStatusStoreProvider = b.a.a.a(UserModule_ProvideUIStatusStoreFactory.create(builder.userModule));
        this.provideMeCounterProvider = b.a.a.a(UserModule_ProvideMeCounterFactory.create(builder.userModule));
        this.provideCheckoutIdStoreProvider = b.a.a.a(UserModule_ProvideCheckoutIdStoreFactory.create(builder.userModule));
        this.provideActionIdListStoreProvider = b.a.a.a(UserModule_ProvideActionIdListStoreFactory.create(builder.userModule));
        this.provideOrderCountStoreProvider = b.a.a.a(UserModule_ProvideOrderCountStoreFactory.create(builder.userModule));
        this.appProvider = new com_shopee_app_application_ApplicationComponent_app(builder.applicationComponent);
        this.loginStoreProvider = new com_shopee_app_application_ApplicationComponent_loginStore(builder.applicationComponent);
        this.provideTrackerProvider = b.a.a.a(UserModule_ProvideTrackerFactory.create(builder.userModule, this.appProvider, this.loginStoreProvider));
        this.provideActionRequiredCounterProvider = b.a.a.a(UserModule_ProvideActionRequiredCounterFactory.create(builder.userModule));
        this.provideReturnIdStoreProvider = b.a.a.a(UserModule_ProvideReturnIdStoreFactory.create(builder.userModule));
        this.provideMyCustomerIdStoreProvider = b.a.a.a(UserModule_ProvideMyCustomerIdStoreFactory.create(builder.userModule));
        this.customerOrderCountStoreProvider = b.a.a.a(UserModule_CustomerOrderCountStoreFactory.create(builder.userModule));
        this.provideCustomerOrderIdStoreProvider = b.a.a.a(UserModule_ProvideCustomerOrderIdStoreFactory.create(builder.userModule));
        this.provideRatingShopeeStoreProvider = b.a.a.a(UserModule_ProvideRatingShopeeStoreFactory.create(builder.userModule));
        this.provideSearchKeywordsStoreProvider = b.a.a.a(UserModule_ProvideSearchKeywordsStoreFactory.create(builder.userModule));
        this.provideActivityIdStoreProvider = b.a.a.a(UserModule_ProvideActivityIdStoreFactory.create(builder.userModule));
        this.provideBannerStoreProvider = b.a.a.a(UserModule_ProvideBannerStoreFactory.create(builder.userModule));
        this.provideBlacklistStoreProvider = b.a.a.a(UserModule_ProvideBlacklistStoreFactory.create(builder.userModule));
        this.provideChatCounterProvider = b.a.a.a(UserModule_ProvideChatCounterFactory.create(builder.userModule));
        this.provideWebDataStoreProvider = b.a.a.a(UserModule_ProvideWebDataStoreFactory.create(builder.userModule));
        this.provideProductUploadStoreProvider = b.a.a.a(UserModule_ProvideProductUploadStoreFactory.create(builder.userModule));
        this.settingConfigStoreProvider = new com_shopee_app_application_ApplicationComponent_settingConfigStore(builder.applicationComponent);
        this.provideReactJobConfigStoreProvider = b.a.a.a(UserModule_ProvideReactJobConfigStoreFactory.create(builder.userModule, this.settingConfigStoreProvider));
        this.provideDataPointJobConfigStoreProvider = b.a.a.a(UserModule_ProvideDataPointJobConfigStoreFactory.create(builder.userModule, this.settingConfigStoreProvider));
        this.provideUploadStoreProvider = b.a.a.a(UserModule_ProvideUploadStoreFactory.create(builder.userModule));
        this.provideProductUploadMangerProvider = b.a.a.a(UserModule_ProvideProductUploadMangerFactory.create(builder.userModule, this.provideProductUploadStoreProvider));
        this.provideInstagramClientProvider = b.a.a.a(UserModule_ProvideInstagramClientFactory.create(builder.userModule));
        this.provideTwitterClientProvider = b.a.a.a(UserModule_ProvideTwitterClientFactory.create(builder.userModule));
        this.deviceStoreProvider = new com_shopee_app_application_ApplicationComponent_deviceStore(builder.applicationComponent);
        this.provideActionTrackerProvider = b.a.a.a(UserModule_ProvideActionTrackerFactory.create(builder.userModule, this.settingConfigStoreProvider, this.deviceStoreProvider));
        this.unreadStoreProvider = b.a.a.a(UserModule_UnreadStoreFactory.create(builder.userModule));
        this.retrofitProvider = new com_shopee_app_application_ApplicationComponent_retrofit(builder.applicationComponent);
        this.provideFeatureToggleManagerProvider = b.a.a.a(UserModule_ProvideFeatureToggleManagerFactory.create(builder.userModule, this.retrofitProvider, this.provideLoggedInUserProvider));
        this.provideTrackTrakLoggerProvider = b.a.a.a(UserModule_ProvideTrackTrakLoggerFactory.create(builder.userModule));
        this.provideLogoutAPIProvider = b.a.a.a(UserModule_ProvideLogoutAPIFactory.create(builder.userModule, this.retrofitProvider));
        this.themeStoreProvider = new com_shopee_app_application_ApplicationComponent_themeStore(builder.applicationComponent);
        this.dataEventBusProvider = new com_shopee_app_application_ApplicationComponent_dataEventBus(builder.applicationComponent);
        this.themeConfigUpdaterProvider = m.a(this.themeStoreProvider, this.dataEventBusProvider);
        this.provideDataBridgeHelperProvider = b.a.a.a(UserModule_ProvideDataBridgeHelperFactory.create(builder.userModule, au.b(), this.provideChatBadgeStoreProvider, this.unreadStoreProvider, this.settingConfigStoreProvider, this.provideFeatureToggleManagerProvider, this.themeConfigUpdaterProvider));
    }

    public ar inject(ar arVar) {
        return injectShopeeApplication(arVar);
    }

    public com.shopee.app.util.n dataEventBus() {
        return (com.shopee.app.util.n) c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method");
    }

    public bi uiEventBus() {
        return (bi) c.a(this.applicationComponent.uiEventBus(), "Cannot return null from a non-@Nullable component method");
    }

    public al loginStore() {
        return (al) c.a(this.applicationComponent.loginStore(), "Cannot return null from a non-@Nullable component method");
    }

    public v crossUserStatusStore() {
        return (v) c.a(this.applicationComponent.crossUserStatusStore(), "Cannot return null from a non-@Nullable component method");
    }

    public ae forbiddenZoneStore() {
        return (ae) c.a(this.applicationComponent.forbiddenZoneStore(), "Cannot return null from a non-@Nullable component method");
    }

    public ar app() {
        return (ar) c.a(this.applicationComponent.app(), "Cannot return null from a non-@Nullable component method");
    }

    public p serverManager() {
        return (p) c.a(this.applicationComponent.serverManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.q fabricClient() {
        return (com.shopee.app.util.q) c.a(this.applicationComponent.fabricClient(), "Cannot return null from a non-@Nullable component method");
    }

    public ShareConfigStore shareConfigStore() {
        return (ShareConfigStore) c.a(this.applicationComponent.shareConfigStore(), "Cannot return null from a non-@Nullable component method");
    }

    public SettingConfigStore settingConfigStore() {
        return (SettingConfigStore) c.a(this.applicationComponent.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
    }

    public RegionConfigStore regionConfigStore() {
        return (RegionConfigStore) c.a(this.applicationComponent.regionConfigStore(), "Cannot return null from a non-@Nullable component method");
    }

    public aa deviceStore() {
        return (aa) c.a(this.applicationComponent.deviceStore(), "Cannot return null from a non-@Nullable component method");
    }

    public bd toolTipStore() {
        return (bd) c.a(this.applicationComponent.toolTipStore(), "Cannot return null from a non-@Nullable component method");
    }

    public JobManager jobManager() {
        return (JobManager) c.a(this.applicationComponent.jobManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.am networkUtil() {
        return (com.shopee.app.util.am) c.a(this.applicationComponent.networkUtil(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.application.a.b appLifeCycleManager() {
        return (com.shopee.app.application.a.b) c.a(this.applicationComponent.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.am messageShortcutStore() {
        return (com.shopee.app.data.store.am) c.a(this.applicationComponent.messageShortcutStore(), "Cannot return null from a non-@Nullable component method");
    }

    public ThemeStore themeStore() {
        return (ThemeStore) c.a(this.applicationComponent.themeStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.garena.sticker.b stickerManager() {
        return (com.garena.sticker.b) c.a(this.applicationComponent.stickerManager(), "Cannot return null from a non-@Nullable component method");
    }

    public OkHttpClient okHttpClient() {
        return (OkHttpClient) c.a(this.applicationComponent.okHttpClient(), "Cannot return null from a non-@Nullable component method");
    }

    public f.n retrofit() {
        return (f.n) c.a(this.applicationComponent.retrofit(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.react.modules.app.data.c provideAppsFlyerStore() {
        return (com.shopee.app.react.modules.app.data.c) c.a(this.applicationComponent.provideAppsFlyerStore(), "Cannot return null from a non-@Nullable component method");
    }

    public k rnConfigProvider() {
        return (k) c.a(this.applicationComponent.rnConfigProvider(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.datapoint.b.a locationSyncManager() {
        return (com.shopee.app.util.datapoint.b.a) c.a(this.applicationComponent.locationSyncManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.navigator.e navigator2() {
        return (com.shopee.navigator.e) c.a(this.applicationComponent.navigator2(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.datapoint.a.a deviceInfoHFSyncManager() {
        return (com.shopee.app.util.datapoint.a.a) c.a(this.applicationComponent.deviceInfoHFSyncManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.datapoint.a.d deviceInfoMFSyncManager() {
        return (com.shopee.app.util.datapoint.a.d) c.a(this.applicationComponent.deviceInfoMFSyncManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.datapoint.a.c deviceInfoLFSyncManager() {
        return (com.shopee.app.util.datapoint.a.c) c.a(this.applicationComponent.deviceInfoLFSyncManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.datapoint.a.b deviceInfoInstalledAppSyncManager() {
        return (com.shopee.app.util.datapoint.a.b) c.a(this.applicationComponent.deviceInfoInstalledAppSyncManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.b.a deviceInfoCollector() {
        return (com.shopee.b.a) c.a(this.applicationComponent.deviceInfoCollector(), "Cannot return null from a non-@Nullable component method");
    }

    public m.a connectedProcessor() {
        return new m.a((v) c.a(this.applicationComponent.crossUserStatusStore(), "Cannot return null from a non-@Nullable component method"), this.provideLoggedInUserProvider.get(), (SettingConfigStore) c.a(this.applicationComponent.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), (aa) c.a(this.applicationComponent.deviceStore(), "Cannot return null from a non-@Nullable component method"));
    }

    public g.a logoutProcessor() {
        return new g.a((v) c.a(this.applicationComponent.crossUserStatusStore(), "Cannot return null from a non-@Nullable component method"));
    }

    public r.a newActivityProcessor() {
        return com.shopee.app.network.c.i.s.a(this.provideActivityCounterProvider.get(), (com.shopee.app.util.n) c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public u.a newItemProcessor() {
        return com.shopee.app.network.c.i.v.a(this.provideFollowCounterProvider.get(), (RegionConfigStore) c.a(this.applicationComponent.regionConfigStore(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.util.n) c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public a.C0268a addItemProcessor() {
        return new a.C0268a((com.shopee.app.util.n) c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh(), this.provideLoggedInUserProvider.get(), (SettingConfigStore) c.a(this.applicationComponent.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    public b.a editItemProcessor() {
        return new b.a((com.shopee.app.util.n) c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bh(), this.provideLoggedInUserProvider.get(), (SettingConfigStore) c.a(this.applicationComponent.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    public b.a chatArrivedProcessor() {
        return new b.a((com.shopee.app.util.n) c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.p(), new av(), this.provideChatBadgeStoreProvider.get(), getRequestPChatListInteractor(), this.provideLoggedInUserProvider.get());
    }

    public ai.a getItemListByTypeProcessor() {
        return new ai.a((com.shopee.app.util.n) c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new ah(), this.provideProductIdListStoreProvider.get(), new ao());
    }

    public f.a sendChatProcessor() {
        return new f.a(new com.shopee.app.data.store.p(), new av());
    }

    public c.a makeOfferProcessor() {
        return new c.a(new com.shopee.app.data.store.p(), new av(), (com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public d.a operateOfferProcessor() {
        return new d.a(new com.shopee.app.data.store.p(), new av(), this.provideLoggedInUserProvider.get(), (com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public a.C0271a cancelOfferProcessor() {
        return new a.C0271a(new com.shopee.app.data.store.p(), new av(), this.provideLoggedInUserProvider.get(), (com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public h.a orderUpdateProcessor() {
        return new h.a(new com.shopee.app.data.store.c.b(), orderNotiStore());
    }

    public f.a newLoginProcessor() {
        return new f.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (al) b.a.c.a(this.applicationComponent.loginStore(), "Cannot return null from a non-@Nullable component method"), this.provideLoggedInUserProvider.get(), (JobManager) b.a.c.a(this.applicationComponent.jobManager(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.util.am) b.a.c.a(this.applicationComponent.networkUtil(), "Cannot return null from a non-@Nullable component method"), (ar) b.a.c.a(this.applicationComponent.app(), "Cannot return null from a non-@Nullable component method"));
    }

    public f.b newLoginSubProcessor() {
        return new f.b(this.provideLoggedInUserProvider.get(), (aa) b.a.c.a(this.applicationComponent.deviceStore(), "Cannot return null from a non-@Nullable component method"), (al) b.a.c.a(this.applicationComponent.loginStore(), "Cannot return null from a non-@Nullable component method"), getGetFBFriendListInteractor(), getContactInteractor(), (SettingConfigStore) b.a.c.a(this.applicationComponent.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), getRequestPChatListInteractor(), this.provideChatBadgeStoreProvider.get(), this.provideMeCounterProvider.get(), (com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public d.a newBindAccountProcessor() {
        return new d.a((al) b.a.c.a(this.applicationComponent.loginStore(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.provideLoggedInUserProvider.get(), this.provideUIStatusStoreProvider.get());
    }

    public bo.a newUnbindAccountProcessor() {
        return new bo.a((al) b.a.c.a(this.applicationComponent.loginStore(), "Cannot return null from a non-@Nullable component method"), this.provideLoggedInUserProvider.get());
    }

    public bm.a newSetUserInfoProcessor() {
        return new bm.a((al) b.a.c.a(this.applicationComponent.loginStore(), "Cannot return null from a non-@Nullable component method"), this.provideLoggedInUserProvider.get());
    }

    public bh.a newResetPasswordProcess() {
        return new bh.a((al) b.a.c.a(this.applicationComponent.loginStore(), "Cannot return null from a non-@Nullable component method"), this.provideLoggedInUserProvider.get());
    }

    public i.a newRegisterProcessor() {
        return new i.a((aa) b.a.c.a(this.applicationComponent.deviceStore(), "Cannot return null from a non-@Nullable component method"));
    }

    public f.a checkoutListProcessor() {
        return new f.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.r(), this.provideCheckoutIdStoreProvider.get());
    }

    public n.a unpaidOrdersProcessor() {
        return new n.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.r(), this.provideCheckoutIdStoreProvider.get(), new com.shopee.app.data.store.c.c());
    }

    public d.a newGetCheckoutProcessor() {
        return new d.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.c.c(), new com.shopee.app.data.store.r());
    }

    public d.a newSearchUserProcessor() {
        return new d.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public b.a newActionGetIDListProcessor() {
        return new b.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.provideActionIdListStoreProvider.get(), new com.shopee.app.data.store.a(), new com.shopee.app.data.store.c());
    }

    public i.a orderListProcessor() {
        return new i.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.c.c(), new com.shopee.app.data.store.c.b(), this.provideOrderCountStoreProvider.get());
    }

    public a.C0267a shopBalanceProcessor() {
        return new a.C0267a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (al) b.a.c.a(this.applicationComponent.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    public b.a transactionProcessor() {
        return new b.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.a.a());
    }

    public y.a newCheckoutOrderProcessor() {
        return new y.a(new com.shopee.app.data.store.c.c());
    }

    public f.a cancelCheckoutProcess() {
        return new f.a(this.provideCheckoutIdStoreProvider.get(), new com.shopee.app.data.store.r(), new com.shopee.app.data.store.c.c(), new com.shopee.app.data.store.c.b(), orderNotiStore(), this.provideTrackerProvider.get());
    }

    public b.a actionSystemMessageProcessor() {
        return com.shopee.app.network.c.i.c.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.provideActionIdListStoreProvider.get(), this.provideActionRequiredCounterProvider.get());
    }

    public l.a returnListProcessor() {
        return new l.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.c.e(), this.provideReturnIdStoreProvider.get());
    }

    public bp.a updateContactProcessor() {
        return new bp.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public m.a returnRefundListProcessor() {
        return new m.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.c.e(), this.provideReturnIdStoreProvider.get());
    }

    public ak.a myCustomerProcessor() {
        return com.shopee.app.network.c.al.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.provideMyCustomerIdStoreProvider.get(), new bg());
    }

    public ac.a returnUpdateProcessor() {
        return new ac.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), orderNotiStore(), this.provideReturnIdStoreProvider.get());
    }

    public p.a emailVerifiedProcessor() {
        return new p.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.provideLoggedInUserProvider.get(), new com.shopee.app.data.store.bh());
    }

    public l.a checkoutPaidProcessor() {
        return new l.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.r(), orderNotiStore(), this.provideCheckoutIdStoreProvider.get());
    }

    public k.a checkoutCancelProcessor() {
        return new k.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.r(), orderNotiStore(), this.provideCheckoutIdStoreProvider.get());
    }

    public ad.a customerOrdersProcessor() {
        return new ad.a(this.customerOrderCountStoreProvider.get(), this.provideCustomerOrderIdStoreProvider.get());
    }

    public aj.a getMinAppProcessor() {
        return new aj.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (SettingConfigStore) b.a.c.a(this.applicationComponent.settingConfigStore(), "Cannot return null from a non-@Nullable component method"), this.provideUIStatusStoreProvider.get());
    }

    public j.a orderReturnProcessor() {
        return com.shopee.app.network.c.k.k.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.c.c(), new com.shopee.app.data.store.c.e(), new com.shopee.app.data.store.c.b());
    }

    public o.a orderRateProcessor() {
        return new o.a(this.provideRatingShopeeStoreProvider.get());
    }

    public aq.a getRecommendFriendProcessor() {
        return new aq.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new ah());
    }

    public ah.a getItemBatchProcessor() {
        return new ah.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.ah(), new ao());
    }

    public ag.a getHotHashTagProcessor() {
        return new ag.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public ae.a extractedHashTagProcessor() {
        return new ae.a(this.provideSearchKeywordsStoreProvider.get());
    }

    public ao.a getOrdersnHintProcessor() {
        return new ao.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.c.c());
    }

    public WebReturnUpdateProcessor.Processor webReturnUpdateProcessor() {
        return new WebReturnUpdateProcessor.Processor((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.c.e(), orderNotiStore());
    }

    public WebFollowUserUpdateProcessor.Processor webFollowUserUpdate() {
        return new WebFollowUserUpdateProcessor.Processor((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new t());
    }

    public WebOnAddressSetProcessor.Processor webOnAddressSetProcessor() {
        return new WebOnAddressSetProcessor.Processor((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public WebCancelOrderProcessor.Processor webCancelOrderProcessor() {
        return new WebCancelOrderProcessor.Processor((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.provideTrackerProvider.get(), new com.shopee.app.data.store.c.c(), orderNotiStore());
    }

    public WebOnArchiveReturnProcessor.Processor webOnArchiveReturnProcessor() {
        return new WebOnArchiveReturnProcessor.Processor((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.c.e());
    }

    public WebSplitCheckoutProcessor.Processor webSplitCheckoutProcessor() {
        return new WebSplitCheckoutProcessor.Processor((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.r(), this.provideCheckoutIdStoreProvider.get(), orderNotiStore());
    }

    public WebCreateNewCheckoutProcessor.Processor webCreateNewCheckoutProcessor() {
        return new WebCreateNewCheckoutProcessor.Processor((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), orderNotiStore());
    }

    public WebBAStatusChangedProcessor.Processor webBAStatusChangedProcessor() {
        return new WebBAStatusChangedProcessor.Processor((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.provideLoggedInUserProvider.get(), (al) b.a.c.a(this.applicationComponent.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    public WebUpdateUserAddressProcessor.Processor webUpdateUserAddressProcessor() {
        return new WebUpdateUserAddressProcessor.Processor((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public WebPassDataItemShippingProcessor.Processor webPassDataItemShippingProcessor() {
        return new WebPassDataItemShippingProcessor.Processor((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public b.a reactPageDidMountProcessor() {
        return new b.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public a.C0278a reactMeFeedsPageUpdateProcessor() {
        return new a.C0278a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public ac.a getContactProcessor() {
        return new ac.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new t());
    }

    public WebUpdateUserInfoProcessor.Processor webUpdateUserInfoProcessor() {
        return new WebUpdateUserInfoProcessor.Processor(this.provideLoggedInUserProvider.get());
    }

    public WebUpdateMyShopInfoProcessor.Processor webUpdateMyShopInfoProcessor() {
        return new WebUpdateMyShopInfoProcessor.Processor(this.provideLoggedInUserProvider.get());
    }

    public aw.a getUserInfoProcessor() {
        return ax.a(this.provideLoggedInUserProvider.get(), (com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.bh());
    }

    public bb.a getItemDetailProcessor() {
        return bc.a(new com.shopee.app.data.store.ah(), (com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.ao());
    }

    public d.a newGetPchatListProcessor() {
        return new d.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.provideChatListLoadingStoreProvider.get(), this.provideChatBadgeStoreProvider.get(), new av());
    }

    public c.a newGetOfferProcessor() {
        return new c.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), as.b());
    }

    public ap.a newGetRecentItemsProcessor() {
        return new ap.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.ah(), new com.shopee.app.data.store.ao(), this.provideProductIdListStoreProvider.get());
    }

    public a.C0265a newChatBlockUserProcessor() {
        return new a.C0265a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), com.shopee.app.data.store.l.b());
    }

    public b.a newGetBlockUserListProcessor() {
        return new b.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), com.shopee.app.data.store.l.b());
    }

    public ab.a newGetItemCmtListProcessor() {
        return new ab.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.s());
    }

    public af.a newGetFeedsProcessor() {
        return new af.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.bh());
    }

    public am.a newGetOfferCountProcessor() {
        return new am.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.customerOrderCountStoreProvider.get());
    }

    public e.a newCallBackendProcessor() {
        return new e.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public k.a newCheckUserBlockedProcessor() {
        return new k.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), com.shopee.app.data.store.l.b());
    }

    public l.a newClearChatMsgProcessor() {
        return new l.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new av(), new com.shopee.app.data.store.p());
    }

    public w.a newGetChatItemsProcessor() {
        return new w.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.ah(), new com.shopee.app.data.store.ao(), this.provideProductIdListStoreProvider.get());
    }

    public an.a newGetOfferListProcessor() {
        return new an.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), as.b(), this.provideProductIdListStoreProvider.get());
    }

    public n.a delItemCommentProcessor() {
        return new n.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.s());
    }

    public i.a getCartGetAllOrdersProcessor() {
        return new i.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.provideMeCounterProvider.get(), this.provideProductIdListStoreProvider.get());
    }

    public a.C0270a offerChangedProcessor() {
        return new a.C0270a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), as.b(), this.provideTrackerProvider.get());
    }

    public bk.a newSetChatLastReadProcessor() {
        return new bk.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.provideChatBadgeStoreProvider.get());
    }

    public h.a cartAddItemProcessor() {
        return new h.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public h.a chatDeletedProcessor() {
        return new h.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new av(), new com.shopee.app.data.store.p());
    }

    public ay.a getUserLastSeenProcessor() {
        return com.shopee.app.network.c.az.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public at.a newGetSubCategoryProcessor() {
        return new at.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.m());
    }

    public a.C0269a actionRequiredDeletedProcessor() {
        return new a.C0269a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.provideActivityCounterProvider.get(), this.provideActionRequiredCounterProvider.get(), new com.shopee.app.data.store.e(), new com.shopee.app.data.store.c(), new com.shopee.app.data.store.a());
    }

    public i.a chatMarkedUnreadProcessor() {
        return new i.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.provideChatBadgeStoreProvider.get());
    }

    public aa.a newGetCoinProcessor() {
        return new aa.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.provideMeCounterProvider.get());
    }

    public ba.a newGetWalletProcessor() {
        return new ba.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public au.a getUserBriefProcessor() {
        return com.shopee.app.network.c.av.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bg());
    }

    public ar.a newReqSearchShopCustomerProcessor() {
        return new ar.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new bg());
    }

    public t.a newGetAttributeModelProcessor() {
        return new t.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), com.shopee.app.data.store.ag.b(), new com.shopee.app.data.store.an());
    }

    public bd.a newMatchItemAttributeProcessor() {
        return new bd.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (bi) b.a.c.a(this.applicationComponent.uiEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.g());
    }

    public x.a newGetChatQuickReplyProcessor() {
        return new x.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.data.store.am) b.a.c.a(this.applicationComponent.messageShortcutStore(), "Cannot return null from a non-@Nullable component method"));
    }

    public bl.a newSetChatQuickReplyProcessor() {
        return new bl.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.data.store.am) b.a.c.a(this.applicationComponent.messageShortcutStore(), "Cannot return null from a non-@Nullable component method"));
    }

    public s.a newGetActivityListProcessor() {
        return new s.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.e(), this.provideActivityIdStoreProvider.get());
    }

    public u.a newGetBatchItemScoreProcessor() {
        return new u.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), new com.shopee.app.data.store.ah());
    }

    public be.a removeActivityProcessor() {
        return new be.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.provideActivityCounterProvider.get(), this.provideActionRequiredCounterProvider.get(), new com.shopee.app.data.store.c(), new com.shopee.app.data.store.c(), new com.shopee.app.data.store.a());
    }

    public b.a checkCaptchaProcessor() {
        return new b.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public com.shopee.app.network.c.e.b.b searchProductInShopProcessor() {
        return new com.shopee.app.network.c.e.b.b((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public a.C0272a searchHintProcessor() {
        return com.shopee.app.network.c.l.b.b();
    }

    public ab.a promotionCodeProcessor() {
        return new ab.a((bi) b.a.c.a(this.applicationComponent.uiEventBus(), "Cannot return null from a non-@Nullable component method"), this.provideLoggedInUserProvider.get(), (al) b.a.c.a(this.applicationComponent.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    public com.shopee.app.data.store.b provideActionIdListStore() {
        return this.provideActionIdListStoreProvider.get();
    }

    public q checkoutIdStore() {
        return this.provideCheckoutIdStoreProvider.get();
    }

    public com.shopee.app.data.store.c.d returnIdStore() {
        return this.provideReturnIdStoreProvider.get();
    }

    public com.shopee.app.data.store.ap myCustomerIdStore() {
        return this.provideMyCustomerIdStoreProvider.get();
    }

    public com.shopee.app.data.store.w customerOrderIdStore() {
        return this.provideCustomerOrderIdStoreProvider.get();
    }

    public com.shopee.app.d.b.a.d.j orderLogicProcessor() {
        return com.shopee.app.d.b.a.d.k.a((SettingConfigStore) b.a.c.a(this.applicationComponent.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
    }

    public com.shopee.app.data.store.h bannerStore() {
        return this.provideBannerStoreProvider.get();
    }

    public com.shopee.app.data.store.j blacklistStore() {
        return this.provideBlacklistStoreProvider.get();
    }

    public ActivityCounter activityCounter() {
        return this.provideActivityCounterProvider.get();
    }

    public FollowCounter followCounter() {
        return this.provideFollowCounterProvider.get();
    }

    public MeCounter meCounter() {
        return this.provideMeCounterProvider.get();
    }

    public ChatCounter chatCounter() {
        return this.provideChatCounterProvider.get();
    }

    public ActionRequiredCounter actionRequiredCounter() {
        return this.provideActionRequiredCounterProvider.get();
    }

    public UserInfo loggedInUser() {
        return this.provideLoggedInUserProvider.get();
    }

    public WebDataStore webStore() {
        return this.provideWebDataStoreProvider.get();
    }

    public com.shopee.app.data.store.be uiStatusStore() {
        return this.provideUIStatusStoreProvider.get();
    }

    public com.shopee.app.data.store.o chatListLoadingStore() {
        return this.provideChatListLoadingStoreProvider.get();
    }

    public SearchKeywordsStore searchKeywordStore() {
        return this.provideSearchKeywordsStoreProvider.get();
    }

    public com.shopee.app.data.store.ba productUploadStore() {
        return this.provideProductUploadStoreProvider.get();
    }

    public ReactJobConfigStore reactJobConfigStore() {
        return this.provideReactJobConfigStoreProvider.get();
    }

    public DataPointJobConfigStore dataPointJobConfigStore() {
        return this.provideDataPointJobConfigStoreProvider.get();
    }

    public UploadStore uploadStore() {
        return this.provideUploadStoreProvider.get();
    }

    public com.shopee.app.util.k.h productUploader() {
        return this.provideProductUploadMangerProvider.get();
    }

    public com.shopee.app.data.store.bb ratingShopeeStore() {
        return this.provideRatingShopeeStoreProvider.get();
    }

    public ChatBadgeStore chatBadgeStore() {
        return this.provideChatBadgeStoreProvider.get();
    }

    public com.shopee.app.instagram.e instagramClient() {
        return this.provideInstagramClientProvider.get();
    }

    public com.shopee.app.ui.product.twitter.e twitterClient() {
        return this.provideTwitterClientProvider.get();
    }

    public az productListStore() {
        return this.provideProductIdListStoreProvider.get();
    }

    public com.shopee.app.data.store.d activityIdStoreStore() {
        return this.provideActivityIdStoreProvider.get();
    }

    public com.shopee.app.tracking.f tracker() {
        return this.provideTrackerProvider.get();
    }

    public com.shopee.app.tracking.a actionTracker() {
        return this.provideActionTrackerProvider.get();
    }

    public bf unreadStore() {
        return this.unreadStoreProvider.get();
    }

    public com.shopee.app.data.store.x customerOrderCountStore() {
        return this.customerOrderCountStoreProvider.get();
    }

    public com.shopee.app.data.store.at orderNotiStore() {
        return new com.shopee.app.data.store.at();
    }

    public com.shopee.app.data.store.c.a orderCountStore() {
        return this.provideOrderCountStoreProvider.get();
    }

    public com.shopee.app.d.c.e cleanTemporaryFilesInteractor() {
        return new com.shopee.app.d.c.e((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), this.provideUIStatusStoreProvider.get());
    }

    public com.shopee.app.d.c.f clearNotificationInteractor() {
        return com.shopee.app.d.c.g.a((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
    }

    public com.shopee.app.util.s featureToggleManager() {
        return this.provideFeatureToggleManagerProvider.get();
    }

    public com.shopee.app.ui.tracklog.b shopeeTrackLogger() {
        return this.provideTrackTrakLoggerProvider.get();
    }

    public com.shopee.app.ui.follow.following.i getContactInteractor() {
        return new com.shopee.app.ui.follow.following.i((com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (com.shopee.app.data.store.aa) b.a.c.a(this.applicationComponent.deviceStore(), "Cannot return null from a non-@Nullable component method"), this.provideUIStatusStoreProvider.get(), new com.shopee.app.data.store.aj(), (al) b.a.c.a(this.applicationComponent.loginStore(), "Cannot return null from a non-@Nullable component method"));
    }

    public com.shopee.app.network.http.a.h logoutAPI() {
        return this.provideLogoutAPIProvider.get();
    }

    public com.shopee.app.react.modules.app.data.g dataBridgeHandler() {
        return this.provideDataBridgeHelperProvider.get();
    }

    public void inject(ActivityCounter activityCounter) {
        injectActivityCounter(activityCounter);
    }

    public void inject(FollowCounter followCounter) {
        injectFollowCounter(followCounter);
    }

    public void inject(MeCounter meCounter) {
        injectMeCounter(meCounter);
    }

    public void inject(ChatCounter chatCounter) {
        injectChatCounter(chatCounter);
    }

    public void inject(ActionRequiredCounter actionRequiredCounter) {
        injectActionRequiredCounter(actionRequiredCounter);
    }

    public void inject(com.shopee.app.util.k.c cVar) {
        injectPostProductJob(cVar);
    }

    public void inject(com.shopee.app.util.g.b bVar) {
        injectSendChatJob(bVar);
    }

    public void inject(com.shopee.app.util.g.d dVar) {
        injectUploadImageJob(dVar);
    }

    public void inject(UploadJob uploadJob) {
        injectUploadJob(uploadJob);
    }

    private com.shopee.app.application.ar injectShopeeApplication(com.shopee.app.application.ar arVar) {
        com.shopee.app.application.as.a(arVar, (com.shopee.app.react.modules.app.data.c) b.a.c.a(this.applicationComponent.provideAppsFlyerStore(), "Cannot return null from a non-@Nullable component method"));
        return arVar;
    }

    private ActivityCounter injectActivityCounter(ActivityCounter activityCounter) {
        ActivityCounter_MembersInjector.injectMStore(activityCounter, this.unreadStoreProvider.get());
        ActivityCounter_MembersInjector.injectMEventBus(activityCounter, (com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        return activityCounter;
    }

    private FollowCounter injectFollowCounter(FollowCounter followCounter) {
        FollowCounter_MembersInjector.injectMStore(followCounter, this.unreadStoreProvider.get());
        return followCounter;
    }

    private MeCounter injectMeCounter(MeCounter meCounter) {
        MeCounter_MembersInjector.injectMStore(meCounter, this.unreadStoreProvider.get());
        MeCounter_MembersInjector.injectMEventBus(meCounter, (com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        return meCounter;
    }

    private ChatCounter injectChatCounter(ChatCounter chatCounter) {
        ChatCounter_MembersInjector.injectMStore(chatCounter, this.unreadStoreProvider.get());
        return chatCounter;
    }

    private ActionRequiredCounter injectActionRequiredCounter(ActionRequiredCounter actionRequiredCounter) {
        ActionRequiredCounter_MembersInjector.injectMStore(actionRequiredCounter, this.unreadStoreProvider.get());
        ActionRequiredCounter_MembersInjector.injectMEventBus(actionRequiredCounter, (com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        ActionRequiredCounter_MembersInjector.injectMSettings(actionRequiredCounter, (SettingConfigStore) b.a.c.a(this.applicationComponent.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return actionRequiredCounter;
    }

    private com.shopee.app.util.k.c injectPostProductJob(com.shopee.app.util.k.c cVar) {
        com.shopee.app.util.k.d.a(cVar, (com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, (bi) b.a.c.a(this.applicationComponent.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, getFileUploader());
        com.shopee.app.util.k.d.a(cVar, this.provideProductUploadStoreProvider.get());
        com.shopee.app.util.k.d.a(cVar, this.provideUIStatusStoreProvider.get());
        com.shopee.app.util.k.d.a(cVar, this.provideTwitterClientProvider.get());
        com.shopee.app.util.k.d.a(cVar, this.provideProductUploadMangerProvider.get());
        com.shopee.app.util.k.d.a(cVar, this.provideLoggedInUserProvider.get());
        com.shopee.app.util.k.d.a(cVar, (ShareConfigStore) b.a.c.a(this.applicationComponent.shareConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, (SettingConfigStore) b.a.c.a(this.applicationComponent.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, getPostToFacebookPageInteractor());
        return cVar;
    }

    private com.shopee.app.util.g.b injectSendChatJob(com.shopee.app.util.g.b bVar) {
        com.shopee.app.util.g.c.a(bVar, new com.shopee.app.data.store.p());
        com.shopee.app.util.g.c.a(bVar, this.provideLoggedInUserProvider.get());
        return bVar;
    }

    private com.shopee.app.util.g.d injectUploadImageJob(com.shopee.app.util.g.d dVar) {
        com.shopee.app.util.g.e.a(dVar, getFileUploader());
        return dVar;
    }

    private UploadJob injectUploadJob(UploadJob uploadJob) {
        UploadJob_MembersInjector.injectMEventBus(uploadJob, (com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        UploadJob_MembersInjector.injectUiEventBus(uploadJob, (bi) b.a.c.a(this.applicationComponent.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        UploadJob_MembersInjector.injectMFileUploader(uploadJob, getFileUploader());
        UploadJob_MembersInjector.injectMUploadStore(uploadJob, this.provideUploadStoreProvider.get());
        UploadJob_MembersInjector.injectMUIStore(uploadJob, this.provideUIStatusStoreProvider.get());
        UploadJob_MembersInjector.injectMTwitterClient(uploadJob, this.provideTwitterClientProvider.get());
        UploadJob_MembersInjector.injectMUploadManger(uploadJob, getUploadManager());
        UploadJob_MembersInjector.injectMUser(uploadJob, this.provideLoggedInUserProvider.get());
        UploadJob_MembersInjector.injectShareConfigStore(uploadJob, (ShareConfigStore) b.a.c.a(this.applicationComponent.shareConfigStore(), "Cannot return null from a non-@Nullable component method"));
        UploadJob_MembersInjector.injectPostToFacebookPageInteractor(uploadJob, getPostToFacebookPageInteractor());
        UploadJob_MembersInjector.injectFabricClient(uploadJob, (com.shopee.app.util.q) b.a.c.a(this.applicationComponent.fabricClient(), "Cannot return null from a non-@Nullable component method"));
        return uploadJob;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public com.shopee.app.application.b applicationComponent;
        /* access modifiers changed from: private */
        public UserModule userModule;

        private Builder() {
        }

        public UserComponent build() {
            if (this.userModule == null) {
                throw new IllegalStateException(UserModule.class.getCanonicalName() + " must be set");
            } else if (this.applicationComponent != null) {
                return new DaggerUserComponent(this);
            } else {
                throw new IllegalStateException(com.shopee.app.application.b.class.getCanonicalName() + " must be set");
            }
        }

        public Builder userModule(UserModule userModule2) {
            this.userModule = (UserModule) b.a.c.a(userModule2);
            return this;
        }

        public Builder applicationComponent(com.shopee.app.application.b bVar) {
            this.applicationComponent = (com.shopee.app.application.b) b.a.c.a(bVar);
            return this;
        }
    }

    private static class com_shopee_app_application_ApplicationComponent_app implements Provider<com.shopee.app.application.ar> {
        private final com.shopee.app.application.b applicationComponent;

        com_shopee_app_application_ApplicationComponent_app(com.shopee.app.application.b bVar) {
            this.applicationComponent = bVar;
        }

        public com.shopee.app.application.ar get() {
            return (com.shopee.app.application.ar) b.a.c.a(this.applicationComponent.app(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_shopee_app_application_ApplicationComponent_loginStore implements Provider<al> {
        private final com.shopee.app.application.b applicationComponent;

        com_shopee_app_application_ApplicationComponent_loginStore(com.shopee.app.application.b bVar) {
            this.applicationComponent = bVar;
        }

        public al get() {
            return (al) b.a.c.a(this.applicationComponent.loginStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_shopee_app_application_ApplicationComponent_settingConfigStore implements Provider<SettingConfigStore> {
        private final com.shopee.app.application.b applicationComponent;

        com_shopee_app_application_ApplicationComponent_settingConfigStore(com.shopee.app.application.b bVar) {
            this.applicationComponent = bVar;
        }

        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.applicationComponent.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_shopee_app_application_ApplicationComponent_deviceStore implements Provider<com.shopee.app.data.store.aa> {
        private final com.shopee.app.application.b applicationComponent;

        com_shopee_app_application_ApplicationComponent_deviceStore(com.shopee.app.application.b bVar) {
            this.applicationComponent = bVar;
        }

        public com.shopee.app.data.store.aa get() {
            return (com.shopee.app.data.store.aa) b.a.c.a(this.applicationComponent.deviceStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_shopee_app_application_ApplicationComponent_retrofit implements Provider<f.n> {
        private final com.shopee.app.application.b applicationComponent;

        com_shopee_app_application_ApplicationComponent_retrofit(com.shopee.app.application.b bVar) {
            this.applicationComponent = bVar;
        }

        public f.n get() {
            return (f.n) b.a.c.a(this.applicationComponent.retrofit(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_shopee_app_application_ApplicationComponent_themeStore implements Provider<ThemeStore> {
        private final com.shopee.app.application.b applicationComponent;

        com_shopee_app_application_ApplicationComponent_themeStore(com.shopee.app.application.b bVar) {
            this.applicationComponent = bVar;
        }

        public ThemeStore get() {
            return (ThemeStore) b.a.c.a(this.applicationComponent.themeStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_shopee_app_application_ApplicationComponent_dataEventBus implements Provider<com.shopee.app.util.n> {
        private final com.shopee.app.application.b applicationComponent;

        com_shopee_app_application_ApplicationComponent_dataEventBus(com.shopee.app.application.b bVar) {
            this.applicationComponent = bVar;
        }

        public com.shopee.app.util.n get() {
            return (com.shopee.app.util.n) b.a.c.a(this.applicationComponent.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
