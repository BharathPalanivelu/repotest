package com.shopee.app.application;

import com.garena.android.appkit.b.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SearchKeywordsStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.bb;
import com.shopee.app.data.viewmodel.ChatCounter;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.util.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final SettingConfigStore f15798a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final b.a<bb> f15799b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final ChatCounter f15800c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ChatBadgeStore f15801d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final UserInfo f15802e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final b.a<SearchKeywordsStore> f15803f;

    /* renamed from: g  reason: collision with root package name */
    private am f15804g = new am(46, 51) {
        public void a() {
            for (Map.Entry next : a.this.f15800c.getCounter().entrySet()) {
                int i = 0;
                while (i < ((ChatCounter.ChatCount) next.getValue()).count) {
                    i++;
                    a.this.f15801d.incrementChatCount(((Integer) next.getKey()).intValue(), (long) i);
                }
            }
        }
    };
    private am h = new am(47, 54) {
        public void a() {
            if (c.b() && a.this.f15802e.isLoggedIn() && a.this.f15802e.isAllNotiOn()) {
                b.a("APP_UPGRADE_XIAOMI_POPUP", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
            }
        }
    };
    private am i = new am(0, 66) {
        public void a() {
            ((bb) a.this.f15799b.get()).c(0);
            ((bb) a.this.f15799b.get()).a(-1);
            ((bb) a.this.f15799b.get()).b(-1);
        }
    };
    private am j = new am(70, 90) {
        public void a() {
            SearchKeywordsStore searchKeywordsStore = (SearchKeywordsStore) a.this.f15803f.get();
            List<String> prevSearchHistory = searchKeywordsStore.getPrevSearchHistory();
            if (prevSearchHistory != null) {
                for (String from : prevSearchHistory) {
                    searchKeywordsStore.addProductHistory(SearchProductItem.from(from, 0), 0);
                }
            }
        }
    };

    public a(SettingConfigStore settingConfigStore, ChatCounter chatCounter, ChatBadgeStore chatBadgeStore, UserInfo userInfo, b.a<bb> aVar, b.a<SearchKeywordsStore> aVar2) {
        this.f15798a = settingConfigStore;
        this.f15799b = aVar;
        this.f15800c = chatCounter;
        this.f15802e = userInfo;
        this.f15801d = chatBadgeStore;
        this.f15803f = aVar2;
    }

    /* access modifiers changed from: private */
    public void a(List<am> list) {
        list.add(this.f15804g);
        list.add(this.h);
        list.add(this.i);
        list.add(this.j);
    }

    public void a() {
        org.a.a.a.a((Runnable) new Runnable() {
            public void run() {
                int previousVersion = a.this.f15798a.getPreviousVersion();
                if (!(previousVersion == 297 || previousVersion == 0)) {
                    ArrayList<am> arrayList = new ArrayList<>();
                    a.this.a((List<am>) arrayList);
                    for (am amVar : arrayList) {
                        if (amVar.a(previousVersion, 297)) {
                            amVar.a();
                        }
                    }
                    a.this.f15798a.fetchEditConfig();
                    a.this.f15798a.setUpgradeDotDismissed(false);
                }
                a.this.f15798a.setPreviousVersion();
            }
        });
    }
}
