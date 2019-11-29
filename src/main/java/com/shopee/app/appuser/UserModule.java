package com.shopee.app.appuser;

import android.content.Context;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SearchKeywordsStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.WebDataStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.ac;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.ap;
import com.shopee.app.data.store.at;
import com.shopee.app.data.store.az;
import com.shopee.app.data.store.b;
import com.shopee.app.data.store.ba;
import com.shopee.app.data.store.bb;
import com.shopee.app.data.store.be;
import com.shopee.app.data.store.bf;
import com.shopee.app.data.store.c.a;
import com.shopee.app.data.store.c.d;
import com.shopee.app.data.store.h;
import com.shopee.app.data.store.j;
import com.shopee.app.data.store.jobdispatcher.DataPointJobConfigStore;
import com.shopee.app.data.store.jobdispatcher.ReactJobConfigStore;
import com.shopee.app.data.store.o;
import com.shopee.app.data.store.q;
import com.shopee.app.data.store.w;
import com.shopee.app.data.store.x;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActionRequiredCounter_;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.data.viewmodel.ActivityCounter_;
import com.shopee.app.data.viewmodel.ChatCounter;
import com.shopee.app.data.viewmodel.ChatCounter_;
import com.shopee.app.data.viewmodel.FollowCounter;
import com.shopee.app.data.viewmodel.FollowCounter_;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.data.viewmodel.MeCounter_;
import com.shopee.app.react.modules.app.data.g;
import com.shopee.app.react.modules.app.data.i;
import com.shopee.app.react.modules.app.data.l;
import com.shopee.app.react.modules.app.data.p;
import com.shopee.app.react.modules.app.data.r;
import com.shopee.app.tracking.e;
import com.shopee.app.tracking.f;
import com.shopee.app.upload.UploadStore;
import com.shopee.app.util.s;
import f.n;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class UserModule {
    private final UserInfo mUser;

    public UserModule(UserInfo userInfo) {
        this.mUser = userInfo;
    }

    private String getKey(String str) {
        return str + "_" + this.mUser.getUserId();
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public UserInfo provideLoggedInUser() {
        return this.mUser;
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public h provideBannerStore() {
        return new h(ar.a(getKey("banner_data_store")));
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public j provideBlacklistStore() {
        return new j(ar.a(getKey("blacklist_data_store")));
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public az provideProductIdListStore() {
        return new az(ar.a(getKey("product_id_store")));
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public bf unreadStore() {
        return new bf(ar.a(getKey("unread")));
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public x customerOrderCountStore() {
        return new x(ar.a("customer_order_count"));
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public a provideOrderCountStore() {
        return new a(ar.a("order_count_store"));
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public ActivityCounter provideActivityCounter() {
        return ActivityCounter_.getInstance_(ar.a());
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public ReactJobConfigStore provideReactJobConfigStore(b.a<SettingConfigStore> aVar) {
        return new ReactJobConfigStore(ar.a(getKey("react_job_config_store")), aVar);
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public DataPointJobConfigStore provideDataPointJobConfigStore(b.a<SettingConfigStore> aVar) {
        return new DataPointJobConfigStore(ar.a(getKey("data_point_job_config_store")), aVar);
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public FollowCounter provideFollowCounter() {
        return FollowCounter_.getInstance_(ar.a());
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public MeCounter provideMeCounter() {
        return MeCounter_.getInstance_(ar.a());
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public ActionRequiredCounter provideActionRequiredCounter() {
        return ActionRequiredCounter_.getInstance_(ar.a());
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public b provideActionIdListStore() {
        return new b(ar.a(getKey("parent_action_id_list")));
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public q provideCheckoutIdStore() {
        return new q(ar.a(getKey("checkout_id_list")));
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public d provideReturnIdStore() {
        return new d(ar.a(getKey("parent_return_id_list_store")));
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public com.shopee.app.data.store.d provideActivityIdStore() {
        return new com.shopee.app.data.store.d(ar.a(getKey("activity_id_list")));
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public ap provideMyCustomerIdStore() {
        return new ap(ar.a(getKey("my_customer_id_list")));
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public w provideCustomerOrderIdStore() {
        return new w(ar.a(getKey("customer_orders_id_list")));
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public ChatCounter provideChatCounter() {
        return ChatCounter_.getInstance_(ar.a());
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public f provideTracker(ar arVar, al alVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.shopee.app.tracking.b());
        arrayList.add(e.a((Context) arVar));
        return new f(alVar, arrayList);
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public com.shopee.app.tracking.a provideActionTracker(SettingConfigStore settingConfigStore, aa aaVar) {
        return new com.shopee.app.tracking.a(settingConfigStore, this.mUser, aaVar);
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public SearchKeywordsStore provideSearchKeywordsStore() {
        return new SearchKeywordsStore(ar.a(getKey("search_keyword")));
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public ChatBadgeStore provideChatBadgeStore() {
        return new ChatBadgeStore(ar.a(getKey("chat_badge_store")));
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public ba provideProductUploadStore() {
        return new ba(ar.a(getKey("upload_data")));
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public UploadStore provideUploadStore() {
        return new UploadStore(ar.a(getKey("upload_data2")));
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public be provideUIStatusStore() {
        return new be(ar.a(getKey("app_status")));
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public o provideChatListLoadingStore() {
        return new o.a(ar.f()).a();
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public bb provideRatingShopeeStore() {
        return new bb(ar.a(getKey("rating_shopee")));
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public com.shopee.app.ui.tracklog.b provideTrackTrakLogger() {
        return new com.shopee.app.ui.tracklog.b(ar.a(getKey("shopee_track_logger")));
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public WebDataStore provideWebDataStore() {
        com.shopee.app.util.d.a aVar;
        try {
            aVar = com.shopee.app.util.d.a.a(new File(com.shopee.app.h.f.a().b(), "cache"), 1, 4194304);
        } catch (IOException unused) {
            aVar = null;
        }
        return new WebDataStore(aVar);
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public com.shopee.app.instagram.e provideInstagramClient() {
        return com.shopee.app.instagram.f.b((Context) ar.f());
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public com.shopee.app.ui.product.twitter.e provideTwitterClient() {
        return com.shopee.app.ui.product.twitter.f.c(ar.f());
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public com.shopee.app.util.k.h provideProductUploadManger(ba baVar) {
        return new com.shopee.app.util.k.h(baVar);
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public s provideFeatureToggleManager(n nVar, UserInfo userInfo) {
        return new s((com.shopee.app.network.http.a.e) nVar.a(com.shopee.app.network.http.a.e.class), new ac.a(ar.a(getKey("feature_toggles"))).a(), userInfo);
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public com.shopee.app.network.http.a.h provideLogoutAPI(n nVar) {
        return (com.shopee.app.network.http.a.h) nVar.a(com.shopee.app.network.http.a.h.class);
    }

    /* access modifiers changed from: package-private */
    @UserScope
    public g provideDataBridgeHelper(at atVar, ChatBadgeStore chatBadgeStore, bf bfVar, SettingConfigStore settingConfigStore, s sVar, l lVar) {
        com.shopee.app.react.modules.app.data.b bVar = new com.shopee.app.react.modules.app.data.b();
        return new g.a().a((i) new p(atVar)).a((com.shopee.app.react.modules.app.data.h) new com.shopee.app.react.modules.app.data.n(chatBadgeStore)).a((com.shopee.app.react.modules.app.data.h) new com.shopee.app.react.modules.app.data.o(atVar)).a((com.shopee.app.react.modules.app.data.h) new com.shopee.app.react.modules.app.data.e(bfVar)).a((com.shopee.app.react.modules.app.data.h) new com.shopee.app.react.modules.app.data.q()).a((com.shopee.app.react.modules.app.data.h) new com.shopee.app.react.modules.app.data.f()).a((com.shopee.app.react.modules.app.data.h) new r()).a((com.shopee.app.react.modules.app.data.h) new com.shopee.app.react.modules.app.data.d(settingConfigStore)).a((com.shopee.app.react.modules.app.data.h) bVar).a((i) bVar).a((i) ar.f().e().rnConfigProvider()).a((com.shopee.app.react.modules.app.data.h) new com.shopee.app.react.modules.app.data.j(sVar)).a((i) lVar).a();
    }
}
