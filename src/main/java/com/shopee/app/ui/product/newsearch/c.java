package com.shopee.app.ui.product.newsearch;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.garena.android.appkit.d.a;
import com.google.a.i;
import com.google.a.o;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.data.viewmodel.HotWordData;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.follow.search.g;
import com.shopee.app.util.s;
import com.shopee.app.util.x;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.SearchConfig;
import com.shopee.app.web.protocol.SearchConfigExtInfo;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class c extends b implements x<e> {

    /* renamed from: a  reason: collision with root package name */
    String f24689a;

    /* renamed from: b  reason: collision with root package name */
    String f24690b = SearchConfig.defaultConfig();

    /* renamed from: c  reason: collision with root package name */
    int f24691c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f24692d;

    /* renamed from: e  reason: collision with root package name */
    s f24693e;

    /* renamed from: f  reason: collision with root package name */
    com.shopee.app.tracking.trackingv3.b f24694f;

    /* renamed from: g  reason: collision with root package name */
    private e f24695g;
    private SearchConfig h;

    public String j() {
        return "pre_search";
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a.b("SEARCH_TAB: " + this.f24690b, new Object[0]);
        f a2 = h.a(this, this.f24689a, this.h, this.f24692d);
        a((View) a2);
        a2.setSelectedIndex(this.f24691c);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        String str;
        if (TextUtils.isEmpty(this.f24689a)) {
            str = this.f24689a;
        } else {
            str = this.f24689a + SQLBuilder.BLANK;
        }
        this.h = (SearchConfig) WebRegister.GSON.a(this.f24690b, SearchConfig.class);
        aVar.f(2).b(com.garena.android.appkit.tools.b.e(R.string.sp_search_products_and_shops)).a(this.f24693e.a("image_search") && this.h.getSearchType() == 0).c(str);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f24695g = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f24695g.a(this);
    }

    /* renamed from: c */
    public e b() {
        return this.f24695g;
    }

    public SearchConfig l() {
        return this.h;
    }

    /* access modifiers changed from: protected */
    public void b(boolean z) {
        if (z) {
            SearchConfig searchConfig = this.h;
            if (searchConfig != null && searchConfig.getExtInfo() != null && this.h.getSearchDefaultSuggestions() != null) {
                ArrayList arrayList = new ArrayList();
                o searchDefaultSuggestions = this.h.getSearchDefaultSuggestions();
                SearchConfigExtInfo extInfo = this.h.getExtInfo();
                if (searchDefaultSuggestions.b("type") && searchDefaultSuggestions.c("type").g() == 1) {
                    i n = searchDefaultSuggestions.c("list").n();
                    for (int i = 0; i < n.a(); i++) {
                        HotWordData hotWordData = (HotWordData) WebRegister.GSON.a(n.a(i).m().toString(), HotWordData.class);
                        arrayList.add(g.a(i, hotWordData.getText(), hotWordData, extInfo.getDomainType()));
                    }
                }
                this.f24694f.a("keyword", "popular_searches", (List<o>) arrayList);
            }
        }
    }
}
