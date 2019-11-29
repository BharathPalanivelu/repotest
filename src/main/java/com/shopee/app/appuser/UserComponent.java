package com.shopee.app.appuser;

import com.shopee.app.application.b;
import com.shopee.app.d.c.e;
import com.shopee.app.d.c.f;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SearchKeywordsStore;
import com.shopee.app.data.store.WebDataStore;
import com.shopee.app.data.store.at;
import com.shopee.app.data.store.az;
import com.shopee.app.data.store.ba;
import com.shopee.app.data.store.bb;
import com.shopee.app.data.store.be;
import com.shopee.app.data.store.bf;
import com.shopee.app.data.store.d;
import com.shopee.app.data.store.h;
import com.shopee.app.data.store.j;
import com.shopee.app.data.store.jobdispatcher.DataPointJobConfigStore;
import com.shopee.app.data.store.jobdispatcher.ReactJobConfigStore;
import com.shopee.app.data.store.o;
import com.shopee.app.data.store.x;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.data.viewmodel.ChatCounter;
import com.shopee.app.data.viewmodel.FollowCounter;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.pushnotification.fcm.ShopeeFcmListenerService;
import com.shopee.app.react.modules.app.data.g;
import com.shopee.app.tracking.a;
import com.shopee.app.ui.follow.following.i;
import com.shopee.app.upload.UploadJob;
import com.shopee.app.upload.UploadStore;
import com.shopee.app.util.k.c;
import com.shopee.app.util.s;

@UserScope
public interface UserComponent extends b, IdListHelperAPI, OrderLogicAPI, ProcessorAPI {
    ActionRequiredCounter actionRequiredCounter();

    a actionTracker();

    ActivityCounter activityCounter();

    d activityIdStoreStore();

    h bannerStore();

    j blacklistStore();

    ChatBadgeStore chatBadgeStore();

    ChatCounter chatCounter();

    o chatListLoadingStore();

    e cleanTemporaryFilesInteractor();

    f clearNotificationInteractor();

    x customerOrderCountStore();

    g dataBridgeHandler();

    DataPointJobConfigStore dataPointJobConfigStore();

    s featureToggleManager();

    FollowCounter followCounter();

    i getContactInteractor();

    void inject(ActionRequiredCounter actionRequiredCounter);

    void inject(ActivityCounter activityCounter);

    void inject(ChatCounter chatCounter);

    void inject(FollowCounter followCounter);

    void inject(MeCounter meCounter);

    void inject(ShopeeFcmListenerService shopeeFcmListenerService);

    void inject(UploadJob uploadJob);

    void inject(com.shopee.app.util.g.b bVar);

    void inject(com.shopee.app.util.g.d dVar);

    void inject(c cVar);

    com.shopee.app.instagram.e instagramClient();

    UserInfo loggedInUser();

    com.shopee.app.network.http.a.h logoutAPI();

    MeCounter meCounter();

    com.shopee.app.data.store.c.a orderCountStore();

    at orderNotiStore();

    az productListStore();

    ba productUploadStore();

    com.shopee.app.util.k.h productUploader();

    bb ratingShopeeStore();

    ReactJobConfigStore reactJobConfigStore();

    SearchKeywordsStore searchKeywordStore();

    com.shopee.app.ui.tracklog.b shopeeTrackLogger();

    com.shopee.app.tracking.f tracker();

    com.shopee.app.ui.product.twitter.e twitterClient();

    be uiStatusStore();

    bf unreadStore();

    UploadStore uploadStore();

    WebDataStore webStore();
}
