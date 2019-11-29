package com.shopee.app.data.store;

import android.content.SharedPreferences;
import c.a.a.a.b;
import com.google.a.c.a;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.shopee.app.data.viewmodel.BlackListData;
import com.shopee.app.util.ad;
import java.util.ArrayList;
import java.util.List;

public class j extends ay {

    /* renamed from: a  reason: collision with root package name */
    private ad<BlackListData> f17312a;

    /* renamed from: b  reason: collision with root package name */
    private b f17313b;

    public j(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.f17312a = new ad<>(sharedPreferences, "blacklist_data", ServiceLogger.PLACEHOLDER, new a<BlackListData>() {
        });
        this.f17313b = new b(sharedPreferences, "last_sync_time");
    }

    public List<String> a() {
        List<String> chat = this.f17312a.a().getChat();
        return chat == null ? new ArrayList() : chat;
    }

    public int b() {
        return this.f17313b.a();
    }

    public void a(BlackListData blackListData) {
        this.f17312a.a(blackListData);
    }
}
