package com.shopee.app.application;

import com.path.android.jobqueue.JobManager;
import com.shopee.app.data.store.RegionConfigStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ShareConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.ae;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.am;
import com.shopee.app.data.store.bd;
import com.shopee.app.data.store.theme.ThemeStore;
import com.shopee.app.data.store.v;
import com.shopee.app.h.p;
import com.shopee.app.react.modules.app.data.k;
import com.shopee.app.util.bi;
import com.shopee.app.util.datapoint.a.c;
import com.shopee.app.util.datapoint.a.d;
import com.shopee.app.util.n;
import com.shopee.app.util.q;
import com.shopee.b.a;
import com.shopee.navigator.e;
import okhttp3.OkHttpClient;

public interface b {
    ar app();

    com.shopee.app.application.a.b appLifeCycleManager();

    v crossUserStatusStore();

    n dataEventBus();

    a deviceInfoCollector();

    com.shopee.app.util.datapoint.a.a deviceInfoHFSyncManager();

    com.shopee.app.util.datapoint.a.b deviceInfoInstalledAppSyncManager();

    c deviceInfoLFSyncManager();

    d deviceInfoMFSyncManager();

    aa deviceStore();

    q fabricClient();

    ae forbiddenZoneStore();

    ar inject(ar arVar);

    JobManager jobManager();

    com.shopee.app.util.datapoint.b.a locationSyncManager();

    al loginStore();

    am messageShortcutStore();

    e navigator2();

    com.shopee.app.util.am networkUtil();

    OkHttpClient okHttpClient();

    com.shopee.app.react.modules.app.data.c provideAppsFlyerStore();

    RegionConfigStore regionConfigStore();

    f.n retrofit();

    k rnConfigProvider();

    p serverManager();

    SettingConfigStore settingConfigStore();

    ShareConfigStore shareConfigStore();

    com.garena.sticker.b stickerManager();

    ThemeStore themeStore();

    bd toolTipStore();

    bi uiEventBus();
}
