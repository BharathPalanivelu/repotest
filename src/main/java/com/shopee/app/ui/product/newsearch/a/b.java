package com.shopee.app.ui.product.newsearch.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.s;
import com.facebook.share.internal.ShareConstants;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.google.a.i;
import com.google.a.o;
import com.shopee.app.data.viewmodel.HotWordData;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.g.d;
import com.shopee.app.react.util.f;
import com.shopee.app.ui.a.y;
import com.shopee.app.ui.common.NPALinearLayoutManager;
import com.shopee.app.ui.product.search.h;
import com.shopee.app.ui.product.search.j;
import com.shopee.app.ui.product.search.k;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.SearchConfig;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class b extends com.garena.android.uikit.a.a.a implements y.a<SearchProductItem> {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f24661a;

    /* renamed from: b  reason: collision with root package name */
    View f24662b;

    /* renamed from: c  reason: collision with root package name */
    TextView f24663c;

    /* renamed from: d  reason: collision with root package name */
    bi f24664d;

    /* renamed from: e  reason: collision with root package name */
    Activity f24665e;

    /* renamed from: f  reason: collision with root package name */
    com.shopee.app.ui.actionbar.a f24666f;

    /* renamed from: g  reason: collision with root package name */
    a f24667g;
    /* access modifiers changed from: private */
    public final SearchConfig h;
    private a i;
    private TextView j;
    /* access modifiers changed from: private */
    public String k = "";
    private e l = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            b.this.a((String) aVar.data, "");
        }
    };
    private e m = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            b.this.f24665e.finish();
        }
    };
    private e n = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            String unused = b.this.k = (String) aVar.data;
            if (!TextUtils.isEmpty(b.this.k.trim())) {
                b bVar = b.this;
                bVar.a((List<SearchProductItem>) bVar.f());
                return;
            }
            b bVar2 = b.this;
            bVar2.a((List<SearchProductItem>) bVar2.e());
        }
    };

    public b(Context context, String str, SearchConfig searchConfig) {
        super(context);
        ((com.shopee.app.ui.product.newsearch.e) ((x) context).b()).a(this);
        this.h = searchConfig;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f24661a.setLayoutManager(new NPALinearLayoutManager(getContext()));
        ((s) this.f24661a.getItemAnimator()).setSupportsChangeAnimations(false);
        this.i = new a(new C0378b());
        e();
        this.f24661a.setAdapter(this.i);
        this.f24663c.setText(this.h.getEmptyViewText());
        d.a(this.f24661a, this.f24662b, this.i);
        this.i.a(this);
        a(e());
        this.j = (TextView) inflate(getContext(), R.layout.search_history_item_layout, (ViewGroup) null);
    }

    /* access modifiers changed from: private */
    public void a(List<SearchProductItem> list) {
        this.i.a(list);
        this.i.notifyItemRangeChanged(0, list.size());
    }

    /* access modifiers changed from: private */
    public List<SearchProductItem> e() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        if (this.h.getSearchHotwords() != null && this.h.getSearchHotwords().b("3")) {
            ArrayList arrayList2 = new ArrayList();
            i n2 = this.h.getSearchHotwords().c("3").n();
            for (int i3 = 0; i3 < n2.a(); i3++) {
                arrayList2.add(n2.a(i3).c());
            }
            arrayList.add(com.shopee.app.ui.follow.search.e.a((List<String>) arrayList2, com.garena.android.appkit.tools.b.e(R.string.sp_label_top_hits_header)));
        }
        if (this.h.getSearchDefaultSuggestions() != null && this.h.getSearchDefaultSuggestions().b("list")) {
            o searchDefaultSuggestions = this.h.getSearchDefaultSuggestions();
            if (!searchDefaultSuggestions.b("type") || searchDefaultSuggestions.c("type").g() != 1) {
                if (searchDefaultSuggestions.b("title")) {
                    SearchProductItem searchProductItem = new SearchProductItem();
                    searchProductItem.setType(-2);
                    searchProductItem.setKeyword(searchDefaultSuggestions.c("title").c());
                    arrayList.add(searchProductItem);
                }
                i n3 = searchDefaultSuggestions.c("list").n();
                while (i2 < n3.a()) {
                    o m2 = n3.a(i2).m();
                    SearchProductItem searchProductItem2 = new SearchProductItem();
                    searchProductItem2.setType(8);
                    searchProductItem2.setKeyword(m2.c("text").c());
                    arrayList.add(searchProductItem2);
                    i2++;
                }
            } else {
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                i n4 = searchDefaultSuggestions.c("list").n();
                while (i2 < n4.a()) {
                    o m3 = n4.a(i2).m();
                    arrayList3.add(m3.c("text").c());
                    arrayList4.add(WebRegister.GSON.a(m3.toString(), HotWordData.class));
                    i2++;
                }
                arrayList.add(com.shopee.app.ui.follow.search.e.a((List<String>) arrayList3, searchDefaultSuggestions.b("title") ? searchDefaultSuggestions.c("title").c() : "", 1, (List<HotWordData>) arrayList4));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public List<SearchProductItem> f() {
        ArrayList arrayList = new ArrayList();
        com.shopee.app.ui.follow.search.e.a(arrayList, this.h.getSearchScope(), 3, this.k, this.j);
        return arrayList;
    }

    public void a() {
        this.f24664d.a("SEARCH_TEXT_CHANGED", this.n);
        this.f24664d.a("SEARCH_TEXT_DONE", this.l);
        this.f24664d.a("SEARCH_TEXT_CANCELLED", this.m);
    }

    public void b() {
        this.f24664d.b("SEARCH_TEXT_CHANGED", this.n);
        this.f24664d.b("SEARCH_TEXT_DONE", this.l);
        this.f24664d.b("SEARCH_TEXT_CANCELLED", this.m);
    }

    public void a(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("keyword", str);
        intent.putExtra("type", 3);
        intent.putExtra("defaultSuggestionsIndex", -1);
        intent.putExtra("scopeListIndex", -1);
        intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, str2);
        intent.putExtra("tracking", f.a(this.k).toString());
        this.f24665e.setResult(-1, intent);
        this.f24665e.finish();
    }

    public void a(int i2) {
        Intent intent = new Intent();
        intent.putExtra("keyword", this.k);
        intent.putExtra("type", 3);
        intent.putExtra("defaultSuggestionsIndex", i2);
        intent.putExtra("scopeListIndex", -1);
        intent.putExtra("tracking", f.a(this.k).toString());
        this.f24665e.setResult(-1, intent);
        this.f24665e.finish();
    }

    public void a(View view, SearchProductItem searchProductItem, int i2) {
        Intent intent = new Intent();
        int type = searchProductItem.getType();
        if (type == 6) {
            intent.putExtra("type", 3);
            intent.putExtra("keyword", this.k);
            intent.putExtra("scopeListIndex", i2);
            intent.putExtra("defaultSuggestionsIndex", -1);
            intent.putExtra("tracking", f.a(this.k).toString());
            this.f24665e.setResult(-1, intent);
            this.f24665e.finish();
        } else if (type == 8) {
            a(i2);
        }
    }

    private static class a extends y<SearchProductItem> {
        public a(com.shopee.app.ui.a.s<SearchProductItem> sVar) {
            super(sVar);
        }
    }

    /* renamed from: com.shopee.app.ui.product.newsearch.a.b$b  reason: collision with other inner class name */
    private class C0378b implements com.shopee.app.ui.a.s<SearchProductItem>, j.b {
        public int a() {
            return 2;
        }

        private C0378b() {
        }

        public int a(SearchProductItem searchProductItem, int i) {
            return searchProductItem.getType();
        }

        public View a(Context context, int i) {
            if (i == -2) {
                return com.shopee.app.ui.chat2.product.b.a(context);
            }
            if (i != 1) {
                h a2 = com.shopee.app.ui.product.search.i.a(context);
                a2.setBackgroundResource(R.drawable.bottom_border_white_background_highlight);
                return a2;
            }
            j a3 = k.a(context);
            a3.setOnItemClickListener(this);
            return a3;
        }

        public void a(View view, String str, int i, SearchProductItem searchProductItem) {
            com.shopee.app.c.a.a(view);
            b.this.f24667g.a(b.this.h, str, i, searchProductItem);
            int extraAsInt = searchProductItem.getExtraAsInt();
            if (extraAsInt == 0) {
                b.this.a(str, "hotwords");
            } else if (extraAsInt == 1) {
                b.this.a(i);
            }
        }
    }
}
