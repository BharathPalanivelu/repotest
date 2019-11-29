package com.shopee.app.i.a;

import b.a.c;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.application.ar;
import com.shopee.app.application.as;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.RegionConfigStore;
import com.shopee.app.data.store.SearchKeywordsStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ShareConfigStore;
import com.shopee.app.data.store.WebDataStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.ae;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.az;
import com.shopee.app.data.store.bd;
import com.shopee.app.data.store.be;
import com.shopee.app.data.store.bf;
import com.shopee.app.data.store.jobdispatcher.DataPointJobConfigStore;
import com.shopee.app.data.store.jobdispatcher.ReactJobConfigStore;
import com.shopee.app.data.store.theme.ThemeStore;
import com.shopee.app.data.store.v;
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
import com.shopee.app.network.c.ay;
import com.shopee.app.network.c.b.b;
import com.shopee.app.network.c.b.f;
import com.shopee.app.network.c.ba;
import com.shopee.app.network.c.bb;
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
import com.shopee.app.react.modules.app.data.k;
import com.shopee.app.ui.product.add.aj;
import com.shopee.app.ui.product.add.ak;
import com.shopee.app.upload.UploadJob;
import com.shopee.app.upload.UploadJob_MembersInjector;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.upload.UploadStore;
import com.shopee.app.util.am;
import com.shopee.app.util.bi;
import com.shopee.app.util.datapoint.a.d;
import com.shopee.app.util.n;
import com.shopee.app.util.q;
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
import com.shopee.navigator.e;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f17707a;

    /* renamed from: b  reason: collision with root package name */
    private b f17708b;

    /* renamed from: c  reason: collision with root package name */
    private Provider<com.shopee.sdk.modules.ui.b.a> f17709c;

    /* renamed from: d  reason: collision with root package name */
    private Provider<com.shopee.sdk.modules.ui.navigator.b> f17710d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.sdk.modules.a> f17711e;

    public void inject(ShopeeFcmListenerService shopeeFcmListenerService) {
    }

    private a(C0262a aVar) {
        a(aVar);
    }

    public static C0262a a() {
        return new C0262a();
    }

    private com.shopee.app.util.f.a b() {
        return new com.shopee.app.util.f.a((p) c.a(this.f17707a.serverManager(), "Cannot return null from a non-@Nullable component method"), (UserInfo) c.a(this.f17707a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private aj c() {
        return ak.a((n) c.a(this.f17707a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (be) c.a(this.f17707a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private UploadManager d() {
        return new UploadManager((UploadStore) c.a(this.f17707a.uploadStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(C0262a aVar) {
        this.f17707a = aVar.f17713b;
        this.f17708b = new b(aVar.f17713b);
        this.f17709c = b.a.a.a(d.a(aVar.f17712a, this.f17708b));
        this.f17710d = b.a.a.a(e.a(aVar.f17712a));
        this.f17711e = b.a.a.a(f.a(aVar.f17712a, this.f17709c, this.f17710d));
    }

    public ar inject(ar arVar) {
        return a(arVar);
    }

    public n dataEventBus() {
        return (n) c.a(this.f17707a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
    }

    public bi uiEventBus() {
        return (bi) c.a(this.f17707a.uiEventBus(), "Cannot return null from a non-@Nullable component method");
    }

    public al loginStore() {
        return (al) c.a(this.f17707a.loginStore(), "Cannot return null from a non-@Nullable component method");
    }

    public v crossUserStatusStore() {
        return (v) c.a(this.f17707a.crossUserStatusStore(), "Cannot return null from a non-@Nullable component method");
    }

    public ae forbiddenZoneStore() {
        return (ae) c.a(this.f17707a.forbiddenZoneStore(), "Cannot return null from a non-@Nullable component method");
    }

    public ar app() {
        return (ar) c.a(this.f17707a.app(), "Cannot return null from a non-@Nullable component method");
    }

    public p serverManager() {
        return (p) c.a(this.f17707a.serverManager(), "Cannot return null from a non-@Nullable component method");
    }

    public q fabricClient() {
        return (q) c.a(this.f17707a.fabricClient(), "Cannot return null from a non-@Nullable component method");
    }

    public ShareConfigStore shareConfigStore() {
        return (ShareConfigStore) c.a(this.f17707a.shareConfigStore(), "Cannot return null from a non-@Nullable component method");
    }

    public SettingConfigStore settingConfigStore() {
        return (SettingConfigStore) c.a(this.f17707a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
    }

    public RegionConfigStore regionConfigStore() {
        return (RegionConfigStore) c.a(this.f17707a.regionConfigStore(), "Cannot return null from a non-@Nullable component method");
    }

    public aa deviceStore() {
        return (aa) c.a(this.f17707a.deviceStore(), "Cannot return null from a non-@Nullable component method");
    }

    public bd toolTipStore() {
        return (bd) c.a(this.f17707a.toolTipStore(), "Cannot return null from a non-@Nullable component method");
    }

    public JobManager jobManager() {
        return (JobManager) c.a(this.f17707a.jobManager(), "Cannot return null from a non-@Nullable component method");
    }

    public am networkUtil() {
        return (am) c.a(this.f17707a.networkUtil(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.application.a.b appLifeCycleManager() {
        return (com.shopee.app.application.a.b) c.a(this.f17707a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.am messageShortcutStore() {
        return (com.shopee.app.data.store.am) c.a(this.f17707a.messageShortcutStore(), "Cannot return null from a non-@Nullable component method");
    }

    public ThemeStore themeStore() {
        return (ThemeStore) c.a(this.f17707a.themeStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.garena.sticker.b stickerManager() {
        return (com.garena.sticker.b) c.a(this.f17707a.stickerManager(), "Cannot return null from a non-@Nullable component method");
    }

    public OkHttpClient okHttpClient() {
        return (OkHttpClient) c.a(this.f17707a.okHttpClient(), "Cannot return null from a non-@Nullable component method");
    }

    public f.n retrofit() {
        return (f.n) c.a(this.f17707a.retrofit(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.react.modules.app.data.c provideAppsFlyerStore() {
        return (com.shopee.app.react.modules.app.data.c) c.a(this.f17707a.provideAppsFlyerStore(), "Cannot return null from a non-@Nullable component method");
    }

    public k rnConfigProvider() {
        return (k) c.a(this.f17707a.rnConfigProvider(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.datapoint.b.a locationSyncManager() {
        return (com.shopee.app.util.datapoint.b.a) c.a(this.f17707a.locationSyncManager(), "Cannot return null from a non-@Nullable component method");
    }

    public e navigator2() {
        return (e) c.a(this.f17707a.navigator2(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.datapoint.a.a deviceInfoHFSyncManager() {
        return (com.shopee.app.util.datapoint.a.a) c.a(this.f17707a.deviceInfoHFSyncManager(), "Cannot return null from a non-@Nullable component method");
    }

    public d deviceInfoMFSyncManager() {
        return (d) c.a(this.f17707a.deviceInfoMFSyncManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.datapoint.a.c deviceInfoLFSyncManager() {
        return (com.shopee.app.util.datapoint.a.c) c.a(this.f17707a.deviceInfoLFSyncManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.datapoint.a.b deviceInfoInstalledAppSyncManager() {
        return (com.shopee.app.util.datapoint.a.b) c.a(this.f17707a.deviceInfoInstalledAppSyncManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.b.a deviceInfoCollector() {
        return (com.shopee.b.a) c.a(this.f17707a.deviceInfoCollector(), "Cannot return null from a non-@Nullable component method");
    }

    public m.a connectedProcessor() {
        return (m.a) c.a(this.f17707a.connectedProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public g.a logoutProcessor() {
        return (g.a) c.a(this.f17707a.logoutProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public r.a newActivityProcessor() {
        return (r.a) c.a(this.f17707a.newActivityProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public u.a newItemProcessor() {
        return (u.a) c.a(this.f17707a.newItemProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public a.C0268a addItemProcessor() {
        return (a.C0268a) c.a(this.f17707a.addItemProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public b.a editItemProcessor() {
        return (b.a) c.a(this.f17707a.editItemProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public b.a chatArrivedProcessor() {
        return (b.a) c.a(this.f17707a.chatArrivedProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ai.a getItemListByTypeProcessor() {
        return (ai.a) c.a(this.f17707a.getItemListByTypeProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public f.a sendChatProcessor() {
        return (f.a) c.a(this.f17707a.sendChatProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public c.a makeOfferProcessor() {
        return (c.a) b.a.c.a(this.f17707a.makeOfferProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public d.a operateOfferProcessor() {
        return (d.a) b.a.c.a(this.f17707a.operateOfferProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public a.C0271a cancelOfferProcessor() {
        return (a.C0271a) b.a.c.a(this.f17707a.cancelOfferProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public h.a orderUpdateProcessor() {
        return (h.a) b.a.c.a(this.f17707a.orderUpdateProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public f.a newLoginProcessor() {
        return (f.a) b.a.c.a(this.f17707a.newLoginProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public f.b newLoginSubProcessor() {
        return (f.b) b.a.c.a(this.f17707a.newLoginSubProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public d.a newBindAccountProcessor() {
        return (d.a) b.a.c.a(this.f17707a.newBindAccountProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public bo.a newUnbindAccountProcessor() {
        return (bo.a) b.a.c.a(this.f17707a.newUnbindAccountProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public bm.a newSetUserInfoProcessor() {
        return (bm.a) b.a.c.a(this.f17707a.newSetUserInfoProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public bh.a newResetPasswordProcess() {
        return (bh.a) b.a.c.a(this.f17707a.newResetPasswordProcess(), "Cannot return null from a non-@Nullable component method");
    }

    public i.a newRegisterProcessor() {
        return (i.a) b.a.c.a(this.f17707a.newRegisterProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public f.a checkoutListProcessor() {
        return (f.a) b.a.c.a(this.f17707a.checkoutListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public n.a unpaidOrdersProcessor() {
        return (n.a) b.a.c.a(this.f17707a.unpaidOrdersProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public d.a newGetCheckoutProcessor() {
        return (d.a) b.a.c.a(this.f17707a.newGetCheckoutProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public d.a newSearchUserProcessor() {
        return (d.a) b.a.c.a(this.f17707a.newSearchUserProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public b.a newActionGetIDListProcessor() {
        return (b.a) b.a.c.a(this.f17707a.newActionGetIDListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public i.a orderListProcessor() {
        return (i.a) b.a.c.a(this.f17707a.orderListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public a.C0267a shopBalanceProcessor() {
        return (a.C0267a) b.a.c.a(this.f17707a.shopBalanceProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public b.a transactionProcessor() {
        return (b.a) b.a.c.a(this.f17707a.transactionProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public y.a newCheckoutOrderProcessor() {
        return (y.a) b.a.c.a(this.f17707a.newCheckoutOrderProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public f.a cancelCheckoutProcess() {
        return (f.a) b.a.c.a(this.f17707a.cancelCheckoutProcess(), "Cannot return null from a non-@Nullable component method");
    }

    public b.a actionSystemMessageProcessor() {
        return (b.a) b.a.c.a(this.f17707a.actionSystemMessageProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public l.a returnListProcessor() {
        return (l.a) b.a.c.a(this.f17707a.returnListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public bp.a updateContactProcessor() {
        return (bp.a) b.a.c.a(this.f17707a.updateContactProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public m.a returnRefundListProcessor() {
        return (m.a) b.a.c.a(this.f17707a.returnRefundListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ak.a myCustomerProcessor() {
        return (ak.a) b.a.c.a(this.f17707a.myCustomerProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ac.a returnUpdateProcessor() {
        return (ac.a) b.a.c.a(this.f17707a.returnUpdateProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public p.a emailVerifiedProcessor() {
        return (p.a) b.a.c.a(this.f17707a.emailVerifiedProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public l.a checkoutPaidProcessor() {
        return (l.a) b.a.c.a(this.f17707a.checkoutPaidProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public k.a checkoutCancelProcessor() {
        return (k.a) b.a.c.a(this.f17707a.checkoutCancelProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ad.a customerOrdersProcessor() {
        return (ad.a) b.a.c.a(this.f17707a.customerOrdersProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public aj.a getMinAppProcessor() {
        return (aj.a) b.a.c.a(this.f17707a.getMinAppProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public j.a orderReturnProcessor() {
        return (j.a) b.a.c.a(this.f17707a.orderReturnProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public o.a orderRateProcessor() {
        return (o.a) b.a.c.a(this.f17707a.orderRateProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public aq.a getRecommendFriendProcessor() {
        return (aq.a) b.a.c.a(this.f17707a.getRecommendFriendProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ah.a getItemBatchProcessor() {
        return (ah.a) b.a.c.a(this.f17707a.getItemBatchProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ag.a getHotHashTagProcessor() {
        return (ag.a) b.a.c.a(this.f17707a.getHotHashTagProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ae.a extractedHashTagProcessor() {
        return (ae.a) b.a.c.a(this.f17707a.extractedHashTagProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ao.a getOrdersnHintProcessor() {
        return (ao.a) b.a.c.a(this.f17707a.getOrdersnHintProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebReturnUpdateProcessor.Processor webReturnUpdateProcessor() {
        return (WebReturnUpdateProcessor.Processor) b.a.c.a(this.f17707a.webReturnUpdateProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebFollowUserUpdateProcessor.Processor webFollowUserUpdate() {
        return (WebFollowUserUpdateProcessor.Processor) b.a.c.a(this.f17707a.webFollowUserUpdate(), "Cannot return null from a non-@Nullable component method");
    }

    public WebOnAddressSetProcessor.Processor webOnAddressSetProcessor() {
        return (WebOnAddressSetProcessor.Processor) b.a.c.a(this.f17707a.webOnAddressSetProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebCancelOrderProcessor.Processor webCancelOrderProcessor() {
        return (WebCancelOrderProcessor.Processor) b.a.c.a(this.f17707a.webCancelOrderProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebOnArchiveReturnProcessor.Processor webOnArchiveReturnProcessor() {
        return (WebOnArchiveReturnProcessor.Processor) b.a.c.a(this.f17707a.webOnArchiveReturnProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebSplitCheckoutProcessor.Processor webSplitCheckoutProcessor() {
        return (WebSplitCheckoutProcessor.Processor) b.a.c.a(this.f17707a.webSplitCheckoutProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebCreateNewCheckoutProcessor.Processor webCreateNewCheckoutProcessor() {
        return (WebCreateNewCheckoutProcessor.Processor) b.a.c.a(this.f17707a.webCreateNewCheckoutProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebBAStatusChangedProcessor.Processor webBAStatusChangedProcessor() {
        return (WebBAStatusChangedProcessor.Processor) b.a.c.a(this.f17707a.webBAStatusChangedProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebUpdateUserAddressProcessor.Processor webUpdateUserAddressProcessor() {
        return (WebUpdateUserAddressProcessor.Processor) b.a.c.a(this.f17707a.webUpdateUserAddressProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebPassDataItemShippingProcessor.Processor webPassDataItemShippingProcessor() {
        return (WebPassDataItemShippingProcessor.Processor) b.a.c.a(this.f17707a.webPassDataItemShippingProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public b.a reactPageDidMountProcessor() {
        return (b.a) b.a.c.a(this.f17707a.reactPageDidMountProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public a.C0278a reactMeFeedsPageUpdateProcessor() {
        return (a.C0278a) b.a.c.a(this.f17707a.reactMeFeedsPageUpdateProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ac.a getContactProcessor() {
        return (ac.a) b.a.c.a(this.f17707a.getContactProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebUpdateUserInfoProcessor.Processor webUpdateUserInfoProcessor() {
        return (WebUpdateUserInfoProcessor.Processor) b.a.c.a(this.f17707a.webUpdateUserInfoProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebUpdateMyShopInfoProcessor.Processor webUpdateMyShopInfoProcessor() {
        return (WebUpdateMyShopInfoProcessor.Processor) b.a.c.a(this.f17707a.webUpdateMyShopInfoProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public aw.a getUserInfoProcessor() {
        return (aw.a) b.a.c.a(this.f17707a.getUserInfoProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public bb.a getItemDetailProcessor() {
        return (bb.a) b.a.c.a(this.f17707a.getItemDetailProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public d.a newGetPchatListProcessor() {
        return (d.a) b.a.c.a(this.f17707a.newGetPchatListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public c.a newGetOfferProcessor() {
        return (c.a) b.a.c.a(this.f17707a.newGetOfferProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ap.a newGetRecentItemsProcessor() {
        return (ap.a) b.a.c.a(this.f17707a.newGetRecentItemsProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public a.C0265a newChatBlockUserProcessor() {
        return (a.C0265a) b.a.c.a(this.f17707a.newChatBlockUserProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public b.a newGetBlockUserListProcessor() {
        return (b.a) b.a.c.a(this.f17707a.newGetBlockUserListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ab.a newGetItemCmtListProcessor() {
        return (ab.a) b.a.c.a(this.f17707a.newGetItemCmtListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public af.a newGetFeedsProcessor() {
        return (af.a) b.a.c.a(this.f17707a.newGetFeedsProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public am.a newGetOfferCountProcessor() {
        return (am.a) b.a.c.a(this.f17707a.newGetOfferCountProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public e.a newCallBackendProcessor() {
        return (e.a) b.a.c.a(this.f17707a.newCallBackendProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public k.a newCheckUserBlockedProcessor() {
        return (k.a) b.a.c.a(this.f17707a.newCheckUserBlockedProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public l.a newClearChatMsgProcessor() {
        return (l.a) b.a.c.a(this.f17707a.newClearChatMsgProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public w.a newGetChatItemsProcessor() {
        return (w.a) b.a.c.a(this.f17707a.newGetChatItemsProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public an.a newGetOfferListProcessor() {
        return (an.a) b.a.c.a(this.f17707a.newGetOfferListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public n.a delItemCommentProcessor() {
        return (n.a) b.a.c.a(this.f17707a.delItemCommentProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public i.a getCartGetAllOrdersProcessor() {
        return (i.a) b.a.c.a(this.f17707a.getCartGetAllOrdersProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public a.C0270a offerChangedProcessor() {
        return (a.C0270a) b.a.c.a(this.f17707a.offerChangedProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public bk.a newSetChatLastReadProcessor() {
        return (bk.a) b.a.c.a(this.f17707a.newSetChatLastReadProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public h.a cartAddItemProcessor() {
        return (h.a) b.a.c.a(this.f17707a.cartAddItemProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public h.a chatDeletedProcessor() {
        return (h.a) b.a.c.a(this.f17707a.chatDeletedProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ay.a getUserLastSeenProcessor() {
        return (ay.a) b.a.c.a(this.f17707a.getUserLastSeenProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public at.a newGetSubCategoryProcessor() {
        return (at.a) b.a.c.a(this.f17707a.newGetSubCategoryProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public a.C0269a actionRequiredDeletedProcessor() {
        return (a.C0269a) b.a.c.a(this.f17707a.actionRequiredDeletedProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public i.a chatMarkedUnreadProcessor() {
        return (i.a) b.a.c.a(this.f17707a.chatMarkedUnreadProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public aa.a newGetCoinProcessor() {
        return (aa.a) b.a.c.a(this.f17707a.newGetCoinProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ba.a newGetWalletProcessor() {
        return (ba.a) b.a.c.a(this.f17707a.newGetWalletProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public au.a getUserBriefProcessor() {
        return (au.a) b.a.c.a(this.f17707a.getUserBriefProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ar.a newReqSearchShopCustomerProcessor() {
        return (ar.a) b.a.c.a(this.f17707a.newReqSearchShopCustomerProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public t.a newGetAttributeModelProcessor() {
        return (t.a) b.a.c.a(this.f17707a.newGetAttributeModelProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public bd.a newMatchItemAttributeProcessor() {
        return (bd.a) b.a.c.a(this.f17707a.newMatchItemAttributeProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public x.a newGetChatQuickReplyProcessor() {
        return (x.a) b.a.c.a(this.f17707a.newGetChatQuickReplyProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public bl.a newSetChatQuickReplyProcessor() {
        return (bl.a) b.a.c.a(this.f17707a.newSetChatQuickReplyProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public s.a newGetActivityListProcessor() {
        return (s.a) b.a.c.a(this.f17707a.newGetActivityListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public u.a newGetBatchItemScoreProcessor() {
        return (u.a) b.a.c.a(this.f17707a.newGetBatchItemScoreProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public be.a removeActivityProcessor() {
        return (be.a) b.a.c.a(this.f17707a.removeActivityProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public b.a checkCaptchaProcessor() {
        return (b.a) b.a.c.a(this.f17707a.checkCaptchaProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.network.c.e.b.b searchProductInShopProcessor() {
        return (com.shopee.app.network.c.e.b.b) b.a.c.a(this.f17707a.searchProductInShopProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public a.C0272a searchHintProcessor() {
        return (a.C0272a) b.a.c.a(this.f17707a.searchHintProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ab.a promotionCodeProcessor() {
        return (ab.a) b.a.c.a(this.f17707a.promotionCodeProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.b provideActionIdListStore() {
        return (com.shopee.app.data.store.b) b.a.c.a(this.f17707a.provideActionIdListStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.q checkoutIdStore() {
        return (com.shopee.app.data.store.q) b.a.c.a(this.f17707a.checkoutIdStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.c.d returnIdStore() {
        return (com.shopee.app.data.store.c.d) b.a.c.a(this.f17707a.returnIdStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.ap myCustomerIdStore() {
        return (com.shopee.app.data.store.ap) b.a.c.a(this.f17707a.myCustomerIdStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.w customerOrderIdStore() {
        return (com.shopee.app.data.store.w) b.a.c.a(this.f17707a.customerOrderIdStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.d.b.a.d.j orderLogicProcessor() {
        return (com.shopee.app.d.b.a.d.j) b.a.c.a(this.f17707a.orderLogicProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.h bannerStore() {
        return (com.shopee.app.data.store.h) b.a.c.a(this.f17707a.bannerStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.j blacklistStore() {
        return (com.shopee.app.data.store.j) b.a.c.a(this.f17707a.blacklistStore(), "Cannot return null from a non-@Nullable component method");
    }

    public ActivityCounter activityCounter() {
        return (ActivityCounter) b.a.c.a(this.f17707a.activityCounter(), "Cannot return null from a non-@Nullable component method");
    }

    public FollowCounter followCounter() {
        return (FollowCounter) b.a.c.a(this.f17707a.followCounter(), "Cannot return null from a non-@Nullable component method");
    }

    public MeCounter meCounter() {
        return (MeCounter) b.a.c.a(this.f17707a.meCounter(), "Cannot return null from a non-@Nullable component method");
    }

    public ChatCounter chatCounter() {
        return (ChatCounter) b.a.c.a(this.f17707a.chatCounter(), "Cannot return null from a non-@Nullable component method");
    }

    public ActionRequiredCounter actionRequiredCounter() {
        return (ActionRequiredCounter) b.a.c.a(this.f17707a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method");
    }

    public UserInfo loggedInUser() {
        return (UserInfo) b.a.c.a(this.f17707a.loggedInUser(), "Cannot return null from a non-@Nullable component method");
    }

    public WebDataStore webStore() {
        return (WebDataStore) b.a.c.a(this.f17707a.webStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.be uiStatusStore() {
        return (com.shopee.app.data.store.be) b.a.c.a(this.f17707a.uiStatusStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.o chatListLoadingStore() {
        return (com.shopee.app.data.store.o) b.a.c.a(this.f17707a.chatListLoadingStore(), "Cannot return null from a non-@Nullable component method");
    }

    public SearchKeywordsStore searchKeywordStore() {
        return (SearchKeywordsStore) b.a.c.a(this.f17707a.searchKeywordStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.ba productUploadStore() {
        return (com.shopee.app.data.store.ba) b.a.c.a(this.f17707a.productUploadStore(), "Cannot return null from a non-@Nullable component method");
    }

    public ReactJobConfigStore reactJobConfigStore() {
        return (ReactJobConfigStore) b.a.c.a(this.f17707a.reactJobConfigStore(), "Cannot return null from a non-@Nullable component method");
    }

    public DataPointJobConfigStore dataPointJobConfigStore() {
        return (DataPointJobConfigStore) b.a.c.a(this.f17707a.dataPointJobConfigStore(), "Cannot return null from a non-@Nullable component method");
    }

    public UploadStore uploadStore() {
        return (UploadStore) b.a.c.a(this.f17707a.uploadStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.k.h productUploader() {
        return (com.shopee.app.util.k.h) b.a.c.a(this.f17707a.productUploader(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.bb ratingShopeeStore() {
        return (com.shopee.app.data.store.bb) b.a.c.a(this.f17707a.ratingShopeeStore(), "Cannot return null from a non-@Nullable component method");
    }

    public ChatBadgeStore chatBadgeStore() {
        return (ChatBadgeStore) b.a.c.a(this.f17707a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.instagram.e instagramClient() {
        return (com.shopee.app.instagram.e) b.a.c.a(this.f17707a.instagramClient(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.ui.product.twitter.e twitterClient() {
        return (com.shopee.app.ui.product.twitter.e) b.a.c.a(this.f17707a.twitterClient(), "Cannot return null from a non-@Nullable component method");
    }

    public az productListStore() {
        return (az) b.a.c.a(this.f17707a.productListStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.d activityIdStoreStore() {
        return (com.shopee.app.data.store.d) b.a.c.a(this.f17707a.activityIdStoreStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.tracking.f tracker() {
        return (com.shopee.app.tracking.f) b.a.c.a(this.f17707a.tracker(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.tracking.a actionTracker() {
        return (com.shopee.app.tracking.a) b.a.c.a(this.f17707a.actionTracker(), "Cannot return null from a non-@Nullable component method");
    }

    public bf unreadStore() {
        return (bf) b.a.c.a(this.f17707a.unreadStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.x customerOrderCountStore() {
        return (com.shopee.app.data.store.x) b.a.c.a(this.f17707a.customerOrderCountStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.at orderNotiStore() {
        return (com.shopee.app.data.store.at) b.a.c.a(this.f17707a.orderNotiStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.c.a orderCountStore() {
        return (com.shopee.app.data.store.c.a) b.a.c.a(this.f17707a.orderCountStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.d.c.e cleanTemporaryFilesInteractor() {
        return (com.shopee.app.d.c.e) b.a.c.a(this.f17707a.cleanTemporaryFilesInteractor(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.d.c.f clearNotificationInteractor() {
        return (com.shopee.app.d.c.f) b.a.c.a(this.f17707a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.s featureToggleManager() {
        return (com.shopee.app.util.s) b.a.c.a(this.f17707a.featureToggleManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.ui.tracklog.b shopeeTrackLogger() {
        return (com.shopee.app.ui.tracklog.b) b.a.c.a(this.f17707a.shopeeTrackLogger(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.ui.follow.following.i getContactInteractor() {
        return (com.shopee.app.ui.follow.following.i) b.a.c.a(this.f17707a.getContactInteractor(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.network.http.a.h logoutAPI() {
        return (com.shopee.app.network.http.a.h) b.a.c.a(this.f17707a.logoutAPI(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.react.modules.app.data.g dataBridgeHandler() {
        return (com.shopee.app.react.modules.app.data.g) b.a.c.a(this.f17707a.dataBridgeHandler(), "Cannot return null from a non-@Nullable component method");
    }

    public void inject(ActivityCounter activityCounter) {
        a(activityCounter);
    }

    public void inject(FollowCounter followCounter) {
        a(followCounter);
    }

    public void inject(MeCounter meCounter) {
        a(meCounter);
    }

    public void inject(ChatCounter chatCounter) {
        a(chatCounter);
    }

    public void inject(ActionRequiredCounter actionRequiredCounter) {
        a(actionRequiredCounter);
    }

    public void inject(com.shopee.app.util.k.c cVar) {
        a(cVar);
    }

    public void inject(com.shopee.app.util.g.b bVar) {
        a(bVar);
    }

    public void inject(com.shopee.app.util.g.d dVar) {
        a(dVar);
    }

    public void inject(UploadJob uploadJob) {
        a(uploadJob);
    }

    public void a(com.shopee.app.i.a aVar) {
        b(aVar);
    }

    private com.shopee.app.application.ar a(com.shopee.app.application.ar arVar) {
        as.a(arVar, (com.shopee.app.react.modules.app.data.c) b.a.c.a(this.f17707a.provideAppsFlyerStore(), "Cannot return null from a non-@Nullable component method"));
        return arVar;
    }

    private ActivityCounter a(ActivityCounter activityCounter) {
        ActivityCounter_MembersInjector.injectMStore(activityCounter, (bf) b.a.c.a(this.f17707a.unreadStore(), "Cannot return null from a non-@Nullable component method"));
        ActivityCounter_MembersInjector.injectMEventBus(activityCounter, (com.shopee.app.util.n) b.a.c.a(this.f17707a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        return activityCounter;
    }

    private FollowCounter a(FollowCounter followCounter) {
        FollowCounter_MembersInjector.injectMStore(followCounter, (bf) b.a.c.a(this.f17707a.unreadStore(), "Cannot return null from a non-@Nullable component method"));
        return followCounter;
    }

    private MeCounter a(MeCounter meCounter) {
        MeCounter_MembersInjector.injectMStore(meCounter, (bf) b.a.c.a(this.f17707a.unreadStore(), "Cannot return null from a non-@Nullable component method"));
        MeCounter_MembersInjector.injectMEventBus(meCounter, (com.shopee.app.util.n) b.a.c.a(this.f17707a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        return meCounter;
    }

    private ChatCounter a(ChatCounter chatCounter) {
        ChatCounter_MembersInjector.injectMStore(chatCounter, (bf) b.a.c.a(this.f17707a.unreadStore(), "Cannot return null from a non-@Nullable component method"));
        return chatCounter;
    }

    private ActionRequiredCounter a(ActionRequiredCounter actionRequiredCounter) {
        ActionRequiredCounter_MembersInjector.injectMStore(actionRequiredCounter, (bf) b.a.c.a(this.f17707a.unreadStore(), "Cannot return null from a non-@Nullable component method"));
        ActionRequiredCounter_MembersInjector.injectMEventBus(actionRequiredCounter, (com.shopee.app.util.n) b.a.c.a(this.f17707a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        ActionRequiredCounter_MembersInjector.injectMSettings(actionRequiredCounter, (SettingConfigStore) b.a.c.a(this.f17707a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return actionRequiredCounter;
    }

    private com.shopee.app.util.k.c a(com.shopee.app.util.k.c cVar) {
        com.shopee.app.util.k.d.a(cVar, (com.shopee.app.util.n) b.a.c.a(this.f17707a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, (bi) b.a.c.a(this.f17707a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, b());
        com.shopee.app.util.k.d.a(cVar, (com.shopee.app.data.store.ba) b.a.c.a(this.f17707a.productUploadStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, (com.shopee.app.data.store.be) b.a.c.a(this.f17707a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, (com.shopee.app.ui.product.twitter.e) b.a.c.a(this.f17707a.twitterClient(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, (com.shopee.app.util.k.h) b.a.c.a(this.f17707a.productUploader(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, (UserInfo) b.a.c.a(this.f17707a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, (ShareConfigStore) b.a.c.a(this.f17707a.shareConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, (SettingConfigStore) b.a.c.a(this.f17707a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, c());
        return cVar;
    }

    private com.shopee.app.util.g.b a(com.shopee.app.util.g.b bVar) {
        com.shopee.app.util.g.c.a(bVar, new com.shopee.app.data.store.p());
        com.shopee.app.util.g.c.a(bVar, (UserInfo) b.a.c.a(this.f17707a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return bVar;
    }

    private com.shopee.app.util.g.d a(com.shopee.app.util.g.d dVar) {
        com.shopee.app.util.g.e.a(dVar, b());
        return dVar;
    }

    private UploadJob a(UploadJob uploadJob) {
        UploadJob_MembersInjector.injectMEventBus(uploadJob, (com.shopee.app.util.n) b.a.c.a(this.f17707a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        UploadJob_MembersInjector.injectUiEventBus(uploadJob, (bi) b.a.c.a(this.f17707a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        UploadJob_MembersInjector.injectMFileUploader(uploadJob, b());
        UploadJob_MembersInjector.injectMUploadStore(uploadJob, (UploadStore) b.a.c.a(this.f17707a.uploadStore(), "Cannot return null from a non-@Nullable component method"));
        UploadJob_MembersInjector.injectMUIStore(uploadJob, (com.shopee.app.data.store.be) b.a.c.a(this.f17707a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        UploadJob_MembersInjector.injectMTwitterClient(uploadJob, (com.shopee.app.ui.product.twitter.e) b.a.c.a(this.f17707a.twitterClient(), "Cannot return null from a non-@Nullable component method"));
        UploadJob_MembersInjector.injectMUploadManger(uploadJob, d());
        UploadJob_MembersInjector.injectMUser(uploadJob, (UserInfo) b.a.c.a(this.f17707a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        UploadJob_MembersInjector.injectShareConfigStore(uploadJob, (ShareConfigStore) b.a.c.a(this.f17707a.shareConfigStore(), "Cannot return null from a non-@Nullable component method"));
        UploadJob_MembersInjector.injectPostToFacebookPageInteractor(uploadJob, c());
        UploadJob_MembersInjector.injectFabricClient(uploadJob, (q) b.a.c.a(this.f17707a.fabricClient(), "Cannot return null from a non-@Nullable component method"));
        return uploadJob;
    }

    private com.shopee.app.i.a b(com.shopee.app.i.a aVar) {
        com.shopee.app.i.b.a(aVar, this.f17711e.get());
        com.shopee.app.i.b.a(aVar, (com.shopee.app.application.ar) b.a.c.a(this.f17707a.app(), "Cannot return null from a non-@Nullable component method"));
        return aVar;
    }

    /* renamed from: com.shopee.app.i.a.a$a  reason: collision with other inner class name */
    public static final class C0262a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public c f17712a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f17713b;

        private C0262a() {
        }

        public b a() {
            if (this.f17712a == null) {
                throw new IllegalStateException(c.class.getCanonicalName() + " must be set");
            } else if (this.f17713b != null) {
                return new a(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public C0262a a(c cVar) {
            this.f17712a = (c) b.a.c.a(cVar);
            return this;
        }

        public C0262a a(UserComponent userComponent) {
            this.f17713b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class b implements Provider<com.shopee.app.application.a.b> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f17714a;

        b(UserComponent userComponent) {
            this.f17714a = userComponent;
        }

        /* renamed from: a */
        public com.shopee.app.application.a.b get() {
            return (com.shopee.app.application.a.b) b.a.c.a(this.f17714a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
