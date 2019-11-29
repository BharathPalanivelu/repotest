package com.shopee.app.react.b;

import com.facebook.react.ReactInstanceManager;
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
import com.shopee.app.react.i;
import com.shopee.app.react.modules.app.data.k;
import com.shopee.app.ui.product.add.aj;
import com.shopee.app.ui.product.add.ak;
import com.shopee.app.upload.UploadJob;
import com.shopee.app.upload.UploadJob_MembersInjector;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.upload.UploadStore;
import com.shopee.app.util.am;
import com.shopee.app.util.bi;
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
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class b implements d {

    /* renamed from: a  reason: collision with root package name */
    private UserComponent f18582a;

    /* renamed from: b  reason: collision with root package name */
    private e f18583b;

    /* renamed from: c  reason: collision with root package name */
    private h f18584c;

    /* renamed from: d  reason: collision with root package name */
    private f f18585d;

    /* renamed from: e  reason: collision with root package name */
    private Provider<com.shopee.app.react.a.a> f18586e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<i> f18587f;

    /* renamed from: g  reason: collision with root package name */
    private c f18588g;
    private e h;
    private d i;
    private C0277b j;
    private com.shopee.app.react.b k;
    private f l;
    private Provider<com.garena.reactpush.e.c.a> m;
    private Provider<ReactInstanceManager> n;
    private Provider<com.garena.reactpush.d.a> o;
    private Provider<com.garena.reactpush.b.b> p;
    private g q;
    private Provider<com.garena.reactpush.d.h> r;
    private Provider<com.garena.reactpush.d.c> s;

    public void inject(ShopeeFcmListenerService shopeeFcmListenerService) {
    }

    private b(a aVar) {
        a(aVar);
    }

    public static a a() {
        return new a();
    }

    private com.shopee.app.util.f.a i() {
        return new com.shopee.app.util.f.a((p) b.a.c.a(this.f18582a.serverManager(), "Cannot return null from a non-@Nullable component method"), (UserInfo) b.a.c.a(this.f18582a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
    }

    private aj j() {
        return ak.a((n) b.a.c.a(this.f18582a.dataEventBus(), "Cannot return null from a non-@Nullable component method"), (be) b.a.c.a(this.f18582a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private UploadManager k() {
        return new UploadManager((UploadStore) b.a.c.a(this.f18582a.uploadStore(), "Cannot return null from a non-@Nullable component method"));
    }

    private void a(a aVar) {
        this.f18582a = aVar.f18590b;
        this.f18584c = new h(aVar.f18590b);
        this.f18585d = new f(aVar.f18590b);
        this.f18586e = b.a.a.a(k.a(aVar.f18589a, this.f18584c, this.f18585d));
        this.f18587f = b.a.a.a(l.a(aVar.f18589a));
        this.f18588g = new c(aVar.f18590b);
        this.h = new e(aVar.f18590b);
        this.i = new d(aVar.f18590b);
        this.j = new C0277b(aVar.f18590b);
        this.k = com.shopee.app.react.b.a(this.f18588g, this.f18584c, this.h, this.i, this.j, com.shopee.app.util.e.b.b());
        this.l = f.a(aVar.f18589a);
        this.m = b.a.a.a(i.a(aVar.f18589a, this.f18586e));
        this.n = b.a.a.a(m.a(aVar.f18589a, this.f18586e, this.f18587f, this.k, this.l, this.m));
        this.o = b.a.a.a(j.a(aVar.f18589a, this.f18586e));
        this.f18583b = aVar.f18589a;
        this.p = b.a.a.a(g.a(aVar.f18589a, this.f18586e));
        this.q = new g(aVar.f18590b);
        this.r = b.a.a.a(p.a(aVar.f18589a, this.q, this.p, this.f18586e));
        this.s = b.a.a.a(n.a(aVar.f18589a, this.p, this.o, this.m, this.r));
    }

    public ar inject(ar arVar) {
        return a(arVar);
    }

    public n dataEventBus() {
        return (n) b.a.c.a(this.f18582a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
    }

    public bi uiEventBus() {
        return (bi) b.a.c.a(this.f18582a.uiEventBus(), "Cannot return null from a non-@Nullable component method");
    }

    public al loginStore() {
        return (al) b.a.c.a(this.f18582a.loginStore(), "Cannot return null from a non-@Nullable component method");
    }

    public v crossUserStatusStore() {
        return (v) b.a.c.a(this.f18582a.crossUserStatusStore(), "Cannot return null from a non-@Nullable component method");
    }

    public ae forbiddenZoneStore() {
        return (ae) b.a.c.a(this.f18582a.forbiddenZoneStore(), "Cannot return null from a non-@Nullable component method");
    }

    public ar app() {
        return (ar) b.a.c.a(this.f18582a.app(), "Cannot return null from a non-@Nullable component method");
    }

    public p serverManager() {
        return (p) b.a.c.a(this.f18582a.serverManager(), "Cannot return null from a non-@Nullable component method");
    }

    public q fabricClient() {
        return (q) b.a.c.a(this.f18582a.fabricClient(), "Cannot return null from a non-@Nullable component method");
    }

    public ShareConfigStore shareConfigStore() {
        return (ShareConfigStore) b.a.c.a(this.f18582a.shareConfigStore(), "Cannot return null from a non-@Nullable component method");
    }

    public SettingConfigStore settingConfigStore() {
        return (SettingConfigStore) b.a.c.a(this.f18582a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
    }

    public RegionConfigStore regionConfigStore() {
        return (RegionConfigStore) b.a.c.a(this.f18582a.regionConfigStore(), "Cannot return null from a non-@Nullable component method");
    }

    public aa deviceStore() {
        return (aa) b.a.c.a(this.f18582a.deviceStore(), "Cannot return null from a non-@Nullable component method");
    }

    public bd toolTipStore() {
        return (bd) b.a.c.a(this.f18582a.toolTipStore(), "Cannot return null from a non-@Nullable component method");
    }

    public JobManager jobManager() {
        return (JobManager) b.a.c.a(this.f18582a.jobManager(), "Cannot return null from a non-@Nullable component method");
    }

    public am networkUtil() {
        return (am) b.a.c.a(this.f18582a.networkUtil(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.application.a.b appLifeCycleManager() {
        return (com.shopee.app.application.a.b) b.a.c.a(this.f18582a.appLifeCycleManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.am messageShortcutStore() {
        return (com.shopee.app.data.store.am) b.a.c.a(this.f18582a.messageShortcutStore(), "Cannot return null from a non-@Nullable component method");
    }

    public ThemeStore themeStore() {
        return (ThemeStore) b.a.c.a(this.f18582a.themeStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.garena.sticker.b stickerManager() {
        return (com.garena.sticker.b) b.a.c.a(this.f18582a.stickerManager(), "Cannot return null from a non-@Nullable component method");
    }

    public OkHttpClient okHttpClient() {
        return (OkHttpClient) b.a.c.a(this.f18582a.okHttpClient(), "Cannot return null from a non-@Nullable component method");
    }

    public f.n retrofit() {
        return (f.n) b.a.c.a(this.f18582a.retrofit(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.react.modules.app.data.c provideAppsFlyerStore() {
        return (com.shopee.app.react.modules.app.data.c) b.a.c.a(this.f18582a.provideAppsFlyerStore(), "Cannot return null from a non-@Nullable component method");
    }

    public k rnConfigProvider() {
        return (k) b.a.c.a(this.f18582a.rnConfigProvider(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.datapoint.b.a locationSyncManager() {
        return (com.shopee.app.util.datapoint.b.a) b.a.c.a(this.f18582a.locationSyncManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.navigator.e navigator2() {
        return (com.shopee.navigator.e) b.a.c.a(this.f18582a.navigator2(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.datapoint.a.a deviceInfoHFSyncManager() {
        return (com.shopee.app.util.datapoint.a.a) b.a.c.a(this.f18582a.deviceInfoHFSyncManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.datapoint.a.d deviceInfoMFSyncManager() {
        return (com.shopee.app.util.datapoint.a.d) b.a.c.a(this.f18582a.deviceInfoMFSyncManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.datapoint.a.c deviceInfoLFSyncManager() {
        return (com.shopee.app.util.datapoint.a.c) b.a.c.a(this.f18582a.deviceInfoLFSyncManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.datapoint.a.b deviceInfoInstalledAppSyncManager() {
        return (com.shopee.app.util.datapoint.a.b) b.a.c.a(this.f18582a.deviceInfoInstalledAppSyncManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.b.a deviceInfoCollector() {
        return (com.shopee.b.a) b.a.c.a(this.f18582a.deviceInfoCollector(), "Cannot return null from a non-@Nullable component method");
    }

    public m.a connectedProcessor() {
        return (m.a) b.a.c.a(this.f18582a.connectedProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public g.a logoutProcessor() {
        return (g.a) b.a.c.a(this.f18582a.logoutProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public r.a newActivityProcessor() {
        return (r.a) b.a.c.a(this.f18582a.newActivityProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public u.a newItemProcessor() {
        return (u.a) b.a.c.a(this.f18582a.newItemProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public a.C0268a addItemProcessor() {
        return (a.C0268a) b.a.c.a(this.f18582a.addItemProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public b.a editItemProcessor() {
        return (b.a) b.a.c.a(this.f18582a.editItemProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public b.a chatArrivedProcessor() {
        return (b.a) b.a.c.a(this.f18582a.chatArrivedProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ai.a getItemListByTypeProcessor() {
        return (ai.a) b.a.c.a(this.f18582a.getItemListByTypeProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public f.a sendChatProcessor() {
        return (f.a) b.a.c.a(this.f18582a.sendChatProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public c.a makeOfferProcessor() {
        return (c.a) b.a.c.a(this.f18582a.makeOfferProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public d.a operateOfferProcessor() {
        return (d.a) b.a.c.a(this.f18582a.operateOfferProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public a.C0271a cancelOfferProcessor() {
        return (a.C0271a) b.a.c.a(this.f18582a.cancelOfferProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public h.a orderUpdateProcessor() {
        return (h.a) b.a.c.a(this.f18582a.orderUpdateProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public f.a newLoginProcessor() {
        return (f.a) b.a.c.a(this.f18582a.newLoginProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public f.b newLoginSubProcessor() {
        return (f.b) b.a.c.a(this.f18582a.newLoginSubProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public d.a newBindAccountProcessor() {
        return (d.a) b.a.c.a(this.f18582a.newBindAccountProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public bo.a newUnbindAccountProcessor() {
        return (bo.a) b.a.c.a(this.f18582a.newUnbindAccountProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public bm.a newSetUserInfoProcessor() {
        return (bm.a) b.a.c.a(this.f18582a.newSetUserInfoProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public bh.a newResetPasswordProcess() {
        return (bh.a) b.a.c.a(this.f18582a.newResetPasswordProcess(), "Cannot return null from a non-@Nullable component method");
    }

    public i.a newRegisterProcessor() {
        return (i.a) b.a.c.a(this.f18582a.newRegisterProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public f.a checkoutListProcessor() {
        return (f.a) b.a.c.a(this.f18582a.checkoutListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public n.a unpaidOrdersProcessor() {
        return (n.a) b.a.c.a(this.f18582a.unpaidOrdersProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public d.a newGetCheckoutProcessor() {
        return (d.a) b.a.c.a(this.f18582a.newGetCheckoutProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public d.a newSearchUserProcessor() {
        return (d.a) b.a.c.a(this.f18582a.newSearchUserProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public b.a newActionGetIDListProcessor() {
        return (b.a) b.a.c.a(this.f18582a.newActionGetIDListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public i.a orderListProcessor() {
        return (i.a) b.a.c.a(this.f18582a.orderListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public a.C0267a shopBalanceProcessor() {
        return (a.C0267a) b.a.c.a(this.f18582a.shopBalanceProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public b.a transactionProcessor() {
        return (b.a) b.a.c.a(this.f18582a.transactionProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public y.a newCheckoutOrderProcessor() {
        return (y.a) b.a.c.a(this.f18582a.newCheckoutOrderProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public f.a cancelCheckoutProcess() {
        return (f.a) b.a.c.a(this.f18582a.cancelCheckoutProcess(), "Cannot return null from a non-@Nullable component method");
    }

    public b.a actionSystemMessageProcessor() {
        return (b.a) b.a.c.a(this.f18582a.actionSystemMessageProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public l.a returnListProcessor() {
        return (l.a) b.a.c.a(this.f18582a.returnListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public bp.a updateContactProcessor() {
        return (bp.a) b.a.c.a(this.f18582a.updateContactProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public m.a returnRefundListProcessor() {
        return (m.a) b.a.c.a(this.f18582a.returnRefundListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ak.a myCustomerProcessor() {
        return (ak.a) b.a.c.a(this.f18582a.myCustomerProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ac.a returnUpdateProcessor() {
        return (ac.a) b.a.c.a(this.f18582a.returnUpdateProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public p.a emailVerifiedProcessor() {
        return (p.a) b.a.c.a(this.f18582a.emailVerifiedProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public l.a checkoutPaidProcessor() {
        return (l.a) b.a.c.a(this.f18582a.checkoutPaidProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public k.a checkoutCancelProcessor() {
        return (k.a) b.a.c.a(this.f18582a.checkoutCancelProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ad.a customerOrdersProcessor() {
        return (ad.a) b.a.c.a(this.f18582a.customerOrdersProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public aj.a getMinAppProcessor() {
        return (aj.a) b.a.c.a(this.f18582a.getMinAppProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public j.a orderReturnProcessor() {
        return (j.a) b.a.c.a(this.f18582a.orderReturnProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public o.a orderRateProcessor() {
        return (o.a) b.a.c.a(this.f18582a.orderRateProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public aq.a getRecommendFriendProcessor() {
        return (aq.a) b.a.c.a(this.f18582a.getRecommendFriendProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ah.a getItemBatchProcessor() {
        return (ah.a) b.a.c.a(this.f18582a.getItemBatchProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ag.a getHotHashTagProcessor() {
        return (ag.a) b.a.c.a(this.f18582a.getHotHashTagProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ae.a extractedHashTagProcessor() {
        return (ae.a) b.a.c.a(this.f18582a.extractedHashTagProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ao.a getOrdersnHintProcessor() {
        return (ao.a) b.a.c.a(this.f18582a.getOrdersnHintProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebReturnUpdateProcessor.Processor webReturnUpdateProcessor() {
        return (WebReturnUpdateProcessor.Processor) b.a.c.a(this.f18582a.webReturnUpdateProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebFollowUserUpdateProcessor.Processor webFollowUserUpdate() {
        return (WebFollowUserUpdateProcessor.Processor) b.a.c.a(this.f18582a.webFollowUserUpdate(), "Cannot return null from a non-@Nullable component method");
    }

    public WebOnAddressSetProcessor.Processor webOnAddressSetProcessor() {
        return (WebOnAddressSetProcessor.Processor) b.a.c.a(this.f18582a.webOnAddressSetProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebCancelOrderProcessor.Processor webCancelOrderProcessor() {
        return (WebCancelOrderProcessor.Processor) b.a.c.a(this.f18582a.webCancelOrderProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebOnArchiveReturnProcessor.Processor webOnArchiveReturnProcessor() {
        return (WebOnArchiveReturnProcessor.Processor) b.a.c.a(this.f18582a.webOnArchiveReturnProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebSplitCheckoutProcessor.Processor webSplitCheckoutProcessor() {
        return (WebSplitCheckoutProcessor.Processor) b.a.c.a(this.f18582a.webSplitCheckoutProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebCreateNewCheckoutProcessor.Processor webCreateNewCheckoutProcessor() {
        return (WebCreateNewCheckoutProcessor.Processor) b.a.c.a(this.f18582a.webCreateNewCheckoutProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebBAStatusChangedProcessor.Processor webBAStatusChangedProcessor() {
        return (WebBAStatusChangedProcessor.Processor) b.a.c.a(this.f18582a.webBAStatusChangedProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebUpdateUserAddressProcessor.Processor webUpdateUserAddressProcessor() {
        return (WebUpdateUserAddressProcessor.Processor) b.a.c.a(this.f18582a.webUpdateUserAddressProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebPassDataItemShippingProcessor.Processor webPassDataItemShippingProcessor() {
        return (WebPassDataItemShippingProcessor.Processor) b.a.c.a(this.f18582a.webPassDataItemShippingProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public b.a reactPageDidMountProcessor() {
        return (b.a) b.a.c.a(this.f18582a.reactPageDidMountProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public a.C0278a reactMeFeedsPageUpdateProcessor() {
        return (a.C0278a) b.a.c.a(this.f18582a.reactMeFeedsPageUpdateProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ac.a getContactProcessor() {
        return (ac.a) b.a.c.a(this.f18582a.getContactProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebUpdateUserInfoProcessor.Processor webUpdateUserInfoProcessor() {
        return (WebUpdateUserInfoProcessor.Processor) b.a.c.a(this.f18582a.webUpdateUserInfoProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public WebUpdateMyShopInfoProcessor.Processor webUpdateMyShopInfoProcessor() {
        return (WebUpdateMyShopInfoProcessor.Processor) b.a.c.a(this.f18582a.webUpdateMyShopInfoProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public aw.a getUserInfoProcessor() {
        return (aw.a) b.a.c.a(this.f18582a.getUserInfoProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public bb.a getItemDetailProcessor() {
        return (bb.a) b.a.c.a(this.f18582a.getItemDetailProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public d.a newGetPchatListProcessor() {
        return (d.a) b.a.c.a(this.f18582a.newGetPchatListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public c.a newGetOfferProcessor() {
        return (c.a) b.a.c.a(this.f18582a.newGetOfferProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ap.a newGetRecentItemsProcessor() {
        return (ap.a) b.a.c.a(this.f18582a.newGetRecentItemsProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public a.C0265a newChatBlockUserProcessor() {
        return (a.C0265a) b.a.c.a(this.f18582a.newChatBlockUserProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public b.a newGetBlockUserListProcessor() {
        return (b.a) b.a.c.a(this.f18582a.newGetBlockUserListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ab.a newGetItemCmtListProcessor() {
        return (ab.a) b.a.c.a(this.f18582a.newGetItemCmtListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public af.a newGetFeedsProcessor() {
        return (af.a) b.a.c.a(this.f18582a.newGetFeedsProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public am.a newGetOfferCountProcessor() {
        return (am.a) b.a.c.a(this.f18582a.newGetOfferCountProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public e.a newCallBackendProcessor() {
        return (e.a) b.a.c.a(this.f18582a.newCallBackendProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public k.a newCheckUserBlockedProcessor() {
        return (k.a) b.a.c.a(this.f18582a.newCheckUserBlockedProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public l.a newClearChatMsgProcessor() {
        return (l.a) b.a.c.a(this.f18582a.newClearChatMsgProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public w.a newGetChatItemsProcessor() {
        return (w.a) b.a.c.a(this.f18582a.newGetChatItemsProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public an.a newGetOfferListProcessor() {
        return (an.a) b.a.c.a(this.f18582a.newGetOfferListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public n.a delItemCommentProcessor() {
        return (n.a) b.a.c.a(this.f18582a.delItemCommentProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public i.a getCartGetAllOrdersProcessor() {
        return (i.a) b.a.c.a(this.f18582a.getCartGetAllOrdersProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public a.C0270a offerChangedProcessor() {
        return (a.C0270a) b.a.c.a(this.f18582a.offerChangedProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public bk.a newSetChatLastReadProcessor() {
        return (bk.a) b.a.c.a(this.f18582a.newSetChatLastReadProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public h.a cartAddItemProcessor() {
        return (h.a) b.a.c.a(this.f18582a.cartAddItemProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public h.a chatDeletedProcessor() {
        return (h.a) b.a.c.a(this.f18582a.chatDeletedProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ay.a getUserLastSeenProcessor() {
        return (ay.a) b.a.c.a(this.f18582a.getUserLastSeenProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public at.a newGetSubCategoryProcessor() {
        return (at.a) b.a.c.a(this.f18582a.newGetSubCategoryProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public a.C0269a actionRequiredDeletedProcessor() {
        return (a.C0269a) b.a.c.a(this.f18582a.actionRequiredDeletedProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public i.a chatMarkedUnreadProcessor() {
        return (i.a) b.a.c.a(this.f18582a.chatMarkedUnreadProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public aa.a newGetCoinProcessor() {
        return (aa.a) b.a.c.a(this.f18582a.newGetCoinProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ba.a newGetWalletProcessor() {
        return (ba.a) b.a.c.a(this.f18582a.newGetWalletProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public au.a getUserBriefProcessor() {
        return (au.a) b.a.c.a(this.f18582a.getUserBriefProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ar.a newReqSearchShopCustomerProcessor() {
        return (ar.a) b.a.c.a(this.f18582a.newReqSearchShopCustomerProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public t.a newGetAttributeModelProcessor() {
        return (t.a) b.a.c.a(this.f18582a.newGetAttributeModelProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public bd.a newMatchItemAttributeProcessor() {
        return (bd.a) b.a.c.a(this.f18582a.newMatchItemAttributeProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public x.a newGetChatQuickReplyProcessor() {
        return (x.a) b.a.c.a(this.f18582a.newGetChatQuickReplyProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public bl.a newSetChatQuickReplyProcessor() {
        return (bl.a) b.a.c.a(this.f18582a.newSetChatQuickReplyProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public s.a newGetActivityListProcessor() {
        return (s.a) b.a.c.a(this.f18582a.newGetActivityListProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public u.a newGetBatchItemScoreProcessor() {
        return (u.a) b.a.c.a(this.f18582a.newGetBatchItemScoreProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public be.a removeActivityProcessor() {
        return (be.a) b.a.c.a(this.f18582a.removeActivityProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public b.a checkCaptchaProcessor() {
        return (b.a) b.a.c.a(this.f18582a.checkCaptchaProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.network.c.e.b.b searchProductInShopProcessor() {
        return (com.shopee.app.network.c.e.b.b) b.a.c.a(this.f18582a.searchProductInShopProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public a.C0272a searchHintProcessor() {
        return (a.C0272a) b.a.c.a(this.f18582a.searchHintProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public ab.a promotionCodeProcessor() {
        return (ab.a) b.a.c.a(this.f18582a.promotionCodeProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.b provideActionIdListStore() {
        return (com.shopee.app.data.store.b) b.a.c.a(this.f18582a.provideActionIdListStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.q checkoutIdStore() {
        return (com.shopee.app.data.store.q) b.a.c.a(this.f18582a.checkoutIdStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.c.d returnIdStore() {
        return (com.shopee.app.data.store.c.d) b.a.c.a(this.f18582a.returnIdStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.ap myCustomerIdStore() {
        return (com.shopee.app.data.store.ap) b.a.c.a(this.f18582a.myCustomerIdStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.w customerOrderIdStore() {
        return (com.shopee.app.data.store.w) b.a.c.a(this.f18582a.customerOrderIdStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.d.b.a.d.j orderLogicProcessor() {
        return (com.shopee.app.d.b.a.d.j) b.a.c.a(this.f18582a.orderLogicProcessor(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.h bannerStore() {
        return (com.shopee.app.data.store.h) b.a.c.a(this.f18582a.bannerStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.j blacklistStore() {
        return (com.shopee.app.data.store.j) b.a.c.a(this.f18582a.blacklistStore(), "Cannot return null from a non-@Nullable component method");
    }

    public ActivityCounter activityCounter() {
        return (ActivityCounter) b.a.c.a(this.f18582a.activityCounter(), "Cannot return null from a non-@Nullable component method");
    }

    public FollowCounter followCounter() {
        return (FollowCounter) b.a.c.a(this.f18582a.followCounter(), "Cannot return null from a non-@Nullable component method");
    }

    public MeCounter meCounter() {
        return (MeCounter) b.a.c.a(this.f18582a.meCounter(), "Cannot return null from a non-@Nullable component method");
    }

    public ChatCounter chatCounter() {
        return (ChatCounter) b.a.c.a(this.f18582a.chatCounter(), "Cannot return null from a non-@Nullable component method");
    }

    public ActionRequiredCounter actionRequiredCounter() {
        return (ActionRequiredCounter) b.a.c.a(this.f18582a.actionRequiredCounter(), "Cannot return null from a non-@Nullable component method");
    }

    public UserInfo loggedInUser() {
        return (UserInfo) b.a.c.a(this.f18582a.loggedInUser(), "Cannot return null from a non-@Nullable component method");
    }

    public WebDataStore webStore() {
        return (WebDataStore) b.a.c.a(this.f18582a.webStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.be uiStatusStore() {
        return (com.shopee.app.data.store.be) b.a.c.a(this.f18582a.uiStatusStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.o chatListLoadingStore() {
        return (com.shopee.app.data.store.o) b.a.c.a(this.f18582a.chatListLoadingStore(), "Cannot return null from a non-@Nullable component method");
    }

    public SearchKeywordsStore searchKeywordStore() {
        return (SearchKeywordsStore) b.a.c.a(this.f18582a.searchKeywordStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.ba productUploadStore() {
        return (com.shopee.app.data.store.ba) b.a.c.a(this.f18582a.productUploadStore(), "Cannot return null from a non-@Nullable component method");
    }

    public ReactJobConfigStore reactJobConfigStore() {
        return (ReactJobConfigStore) b.a.c.a(this.f18582a.reactJobConfigStore(), "Cannot return null from a non-@Nullable component method");
    }

    public DataPointJobConfigStore dataPointJobConfigStore() {
        return (DataPointJobConfigStore) b.a.c.a(this.f18582a.dataPointJobConfigStore(), "Cannot return null from a non-@Nullable component method");
    }

    public UploadStore uploadStore() {
        return (UploadStore) b.a.c.a(this.f18582a.uploadStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.k.h productUploader() {
        return (com.shopee.app.util.k.h) b.a.c.a(this.f18582a.productUploader(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.bb ratingShopeeStore() {
        return (com.shopee.app.data.store.bb) b.a.c.a(this.f18582a.ratingShopeeStore(), "Cannot return null from a non-@Nullable component method");
    }

    public ChatBadgeStore chatBadgeStore() {
        return (ChatBadgeStore) b.a.c.a(this.f18582a.chatBadgeStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.instagram.e instagramClient() {
        return (com.shopee.app.instagram.e) b.a.c.a(this.f18582a.instagramClient(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.ui.product.twitter.e twitterClient() {
        return (com.shopee.app.ui.product.twitter.e) b.a.c.a(this.f18582a.twitterClient(), "Cannot return null from a non-@Nullable component method");
    }

    public az productListStore() {
        return (az) b.a.c.a(this.f18582a.productListStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.d activityIdStoreStore() {
        return (com.shopee.app.data.store.d) b.a.c.a(this.f18582a.activityIdStoreStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.tracking.f tracker() {
        return (com.shopee.app.tracking.f) b.a.c.a(this.f18582a.tracker(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.tracking.a actionTracker() {
        return (com.shopee.app.tracking.a) b.a.c.a(this.f18582a.actionTracker(), "Cannot return null from a non-@Nullable component method");
    }

    public bf unreadStore() {
        return (bf) b.a.c.a(this.f18582a.unreadStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.x customerOrderCountStore() {
        return (com.shopee.app.data.store.x) b.a.c.a(this.f18582a.customerOrderCountStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.at orderNotiStore() {
        return (com.shopee.app.data.store.at) b.a.c.a(this.f18582a.orderNotiStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.data.store.c.a orderCountStore() {
        return (com.shopee.app.data.store.c.a) b.a.c.a(this.f18582a.orderCountStore(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.d.c.e cleanTemporaryFilesInteractor() {
        return (com.shopee.app.d.c.e) b.a.c.a(this.f18582a.cleanTemporaryFilesInteractor(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.d.c.f clearNotificationInteractor() {
        return (com.shopee.app.d.c.f) b.a.c.a(this.f18582a.clearNotificationInteractor(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.util.s featureToggleManager() {
        return (com.shopee.app.util.s) b.a.c.a(this.f18582a.featureToggleManager(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.ui.tracklog.b shopeeTrackLogger() {
        return (com.shopee.app.ui.tracklog.b) b.a.c.a(this.f18582a.shopeeTrackLogger(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.ui.follow.following.i getContactInteractor() {
        return (com.shopee.app.ui.follow.following.i) b.a.c.a(this.f18582a.getContactInteractor(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.network.http.a.h logoutAPI() {
        return (com.shopee.app.network.http.a.h) b.a.c.a(this.f18582a.logoutAPI(), "Cannot return null from a non-@Nullable component method");
    }

    public com.shopee.app.react.modules.app.data.g dataBridgeHandler() {
        return (com.shopee.app.react.modules.app.data.g) b.a.c.a(this.f18582a.dataBridgeHandler(), "Cannot return null from a non-@Nullable component method");
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

    public ReactInstanceManager b() {
        return this.n.get();
    }

    public com.shopee.app.react.g c() {
        return h.a(this.f18583b);
    }

    public com.garena.reactpush.e.c.a d() {
        return this.m.get();
    }

    public com.garena.reactpush.d.c e() {
        return this.s.get();
    }

    public com.garena.reactpush.d.f f() {
        return o.a(this.f18583b, (OkHttpClient) b.a.c.a(this.f18582a.okHttpClient(), "Cannot return null from a non-@Nullable component method"), this.f18586e.get(), this.p.get(), this.m.get(), f.b(this.f18583b));
    }

    public com.garena.reactpush.b.b g() {
        return this.p.get();
    }

    public com.shopee.app.react.a.a h() {
        return this.f18586e.get();
    }

    private com.shopee.app.application.ar a(com.shopee.app.application.ar arVar) {
        as.a(arVar, (com.shopee.app.react.modules.app.data.c) b.a.c.a(this.f18582a.provideAppsFlyerStore(), "Cannot return null from a non-@Nullable component method"));
        return arVar;
    }

    private ActivityCounter a(ActivityCounter activityCounter) {
        ActivityCounter_MembersInjector.injectMStore(activityCounter, (bf) b.a.c.a(this.f18582a.unreadStore(), "Cannot return null from a non-@Nullable component method"));
        ActivityCounter_MembersInjector.injectMEventBus(activityCounter, (com.shopee.app.util.n) b.a.c.a(this.f18582a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        return activityCounter;
    }

    private FollowCounter a(FollowCounter followCounter) {
        FollowCounter_MembersInjector.injectMStore(followCounter, (bf) b.a.c.a(this.f18582a.unreadStore(), "Cannot return null from a non-@Nullable component method"));
        return followCounter;
    }

    private MeCounter a(MeCounter meCounter) {
        MeCounter_MembersInjector.injectMStore(meCounter, (bf) b.a.c.a(this.f18582a.unreadStore(), "Cannot return null from a non-@Nullable component method"));
        MeCounter_MembersInjector.injectMEventBus(meCounter, (com.shopee.app.util.n) b.a.c.a(this.f18582a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        return meCounter;
    }

    private ChatCounter a(ChatCounter chatCounter) {
        ChatCounter_MembersInjector.injectMStore(chatCounter, (bf) b.a.c.a(this.f18582a.unreadStore(), "Cannot return null from a non-@Nullable component method"));
        return chatCounter;
    }

    private ActionRequiredCounter a(ActionRequiredCounter actionRequiredCounter) {
        ActionRequiredCounter_MembersInjector.injectMStore(actionRequiredCounter, (bf) b.a.c.a(this.f18582a.unreadStore(), "Cannot return null from a non-@Nullable component method"));
        ActionRequiredCounter_MembersInjector.injectMEventBus(actionRequiredCounter, (com.shopee.app.util.n) b.a.c.a(this.f18582a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        ActionRequiredCounter_MembersInjector.injectMSettings(actionRequiredCounter, (SettingConfigStore) b.a.c.a(this.f18582a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        return actionRequiredCounter;
    }

    private com.shopee.app.util.k.c a(com.shopee.app.util.k.c cVar) {
        com.shopee.app.util.k.d.a(cVar, (com.shopee.app.util.n) b.a.c.a(this.f18582a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, (bi) b.a.c.a(this.f18582a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, i());
        com.shopee.app.util.k.d.a(cVar, (com.shopee.app.data.store.ba) b.a.c.a(this.f18582a.productUploadStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, (com.shopee.app.data.store.be) b.a.c.a(this.f18582a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, (com.shopee.app.ui.product.twitter.e) b.a.c.a(this.f18582a.twitterClient(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, (com.shopee.app.util.k.h) b.a.c.a(this.f18582a.productUploader(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, (UserInfo) b.a.c.a(this.f18582a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, (ShareConfigStore) b.a.c.a(this.f18582a.shareConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, (SettingConfigStore) b.a.c.a(this.f18582a.settingConfigStore(), "Cannot return null from a non-@Nullable component method"));
        com.shopee.app.util.k.d.a(cVar, j());
        return cVar;
    }

    private com.shopee.app.util.g.b a(com.shopee.app.util.g.b bVar) {
        com.shopee.app.util.g.c.a(bVar, new com.shopee.app.data.store.p());
        com.shopee.app.util.g.c.a(bVar, (UserInfo) b.a.c.a(this.f18582a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        return bVar;
    }

    private com.shopee.app.util.g.d a(com.shopee.app.util.g.d dVar) {
        com.shopee.app.util.g.e.a(dVar, i());
        return dVar;
    }

    private UploadJob a(UploadJob uploadJob) {
        UploadJob_MembersInjector.injectMEventBus(uploadJob, (com.shopee.app.util.n) b.a.c.a(this.f18582a.dataEventBus(), "Cannot return null from a non-@Nullable component method"));
        UploadJob_MembersInjector.injectUiEventBus(uploadJob, (bi) b.a.c.a(this.f18582a.uiEventBus(), "Cannot return null from a non-@Nullable component method"));
        UploadJob_MembersInjector.injectMFileUploader(uploadJob, i());
        UploadJob_MembersInjector.injectMUploadStore(uploadJob, (UploadStore) b.a.c.a(this.f18582a.uploadStore(), "Cannot return null from a non-@Nullable component method"));
        UploadJob_MembersInjector.injectMUIStore(uploadJob, (com.shopee.app.data.store.be) b.a.c.a(this.f18582a.uiStatusStore(), "Cannot return null from a non-@Nullable component method"));
        UploadJob_MembersInjector.injectMTwitterClient(uploadJob, (com.shopee.app.ui.product.twitter.e) b.a.c.a(this.f18582a.twitterClient(), "Cannot return null from a non-@Nullable component method"));
        UploadJob_MembersInjector.injectMUploadManger(uploadJob, k());
        UploadJob_MembersInjector.injectMUser(uploadJob, (UserInfo) b.a.c.a(this.f18582a.loggedInUser(), "Cannot return null from a non-@Nullable component method"));
        UploadJob_MembersInjector.injectShareConfigStore(uploadJob, (ShareConfigStore) b.a.c.a(this.f18582a.shareConfigStore(), "Cannot return null from a non-@Nullable component method"));
        UploadJob_MembersInjector.injectPostToFacebookPageInteractor(uploadJob, j());
        UploadJob_MembersInjector.injectFabricClient(uploadJob, (q) b.a.c.a(this.f18582a.fabricClient(), "Cannot return null from a non-@Nullable component method"));
        return uploadJob;
    }

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public e f18589a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public UserComponent f18590b;

        private a() {
        }

        public d a() {
            if (this.f18589a == null) {
                throw new IllegalStateException(e.class.getCanonicalName() + " must be set");
            } else if (this.f18590b != null) {
                return new b(this);
            } else {
                throw new IllegalStateException(UserComponent.class.getCanonicalName() + " must be set");
            }
        }

        public a a(e eVar) {
            this.f18589a = (e) b.a.c.a(eVar);
            return this;
        }

        public a a(UserComponent userComponent) {
            this.f18590b = (UserComponent) b.a.c.a(userComponent);
            return this;
        }
    }

    private static class h implements Provider<SettingConfigStore> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f18597a;

        h(UserComponent userComponent) {
            this.f18597a = userComponent;
        }

        /* renamed from: a */
        public SettingConfigStore get() {
            return (SettingConfigStore) b.a.c.a(this.f18597a.settingConfigStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class f implements Provider<al> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f18595a;

        f(UserComponent userComponent) {
            this.f18595a = userComponent;
        }

        /* renamed from: a */
        public al get() {
            return (al) b.a.c.a(this.f18595a.loginStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class c implements Provider<com.shopee.app.util.n> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f18592a;

        c(UserComponent userComponent) {
            this.f18592a = userComponent;
        }

        /* renamed from: a */
        public com.shopee.app.util.n get() {
            return (com.shopee.app.util.n) b.a.c.a(this.f18592a.dataEventBus(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class e implements Provider<UserInfo> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f18594a;

        e(UserComponent userComponent) {
            this.f18594a = userComponent;
        }

        /* renamed from: a */
        public UserInfo get() {
            return (UserInfo) b.a.c.a(this.f18594a.loggedInUser(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class d implements Provider<com.shopee.app.data.store.aa> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f18593a;

        d(UserComponent userComponent) {
            this.f18593a = userComponent;
        }

        /* renamed from: a */
        public com.shopee.app.data.store.aa get() {
            return (com.shopee.app.data.store.aa) b.a.c.a(this.f18593a.deviceStore(), "Cannot return null from a non-@Nullable component method");
        }
    }

    /* renamed from: com.shopee.app.react.b.b$b  reason: collision with other inner class name */
    private static class C0277b implements Provider<com.shopee.app.react.modules.app.data.g> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f18591a;

        C0277b(UserComponent userComponent) {
            this.f18591a = userComponent;
        }

        /* renamed from: a */
        public com.shopee.app.react.modules.app.data.g get() {
            return (com.shopee.app.react.modules.app.data.g) b.a.c.a(this.f18591a.dataBridgeHandler(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class g implements Provider<OkHttpClient> {

        /* renamed from: a  reason: collision with root package name */
        private final UserComponent f18596a;

        g(UserComponent userComponent) {
            this.f18596a = userComponent;
        }

        /* renamed from: a */
        public OkHttpClient get() {
            return (OkHttpClient) b.a.c.a(this.f18596a.okHttpClient(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
