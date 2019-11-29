package com.shopee.app.network.c.l;

import android.util.Pair;
import beeshop.curatedsearch.CuratedModuleData;
import beeshop.curatedsearch.CuratedModuleMeta;
import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.viewmodel.CuratedHint;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.h.o;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.web.WebRegister;
import com.shopee.protocol.action.HintRecord;
import com.shopee.protocol.action.HintRecordType;
import com.shopee.protocol.action.ResponseSearchHint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class a extends c implements com.shopee.app.network.a.a<ResponseSearchHint> {
    public int a() {
        return 66;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseSearchHint responseSearchHint = (ResponseSearchHint) f.f18486a.parseFrom(bArr, 0, i, ResponseSearchHint.class);
        if (a(responseSearchHint)) {
            ar.f().e().searchHintProcessor().a(responseSearchHint);
        }
    }

    /* renamed from: com.shopee.app.network.c.l.a$a  reason: collision with other inner class name */
    public static class C0272a {
        C0272a() {
        }

        public void a(ResponseSearchHint responseSearchHint) {
            com.shopee.app.network.d.i.a aVar = (com.shopee.app.network.d.i.a) o.a().f(responseSearchHint.requestid);
            if (aVar != null) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                String d2 = aVar.d();
                if (!af.a(responseSearchHint.hints)) {
                    for (HintRecord next : responseSearchHint.hints) {
                        int i = -1;
                        if (next.record_type == HintRecordType.CuratedSearch) {
                            try {
                                CuratedHint curatedHint = (CuratedHint) WebRegister.GSON.a(((CuratedModuleData) f.f18486a.parseFrom(next.data.curated_search_module_data.i(), CuratedModuleData.class)).data, CuratedHint.class);
                                curatedHint.setOrder(((com.google.a.o) WebRegister.GSON.a(((CuratedModuleMeta) f.f18486a.parseFrom(next.data.curated_search_module_meta.i(), CuratedModuleMeta.class)).data, com.google.a.o.class)).c("order").g());
                                SearchProductItem searchProductItem = new SearchProductItem();
                                searchProductItem.setKeyword(next.keyword);
                                searchProductItem.setCount(next.rnum.intValue());
                                searchProductItem.setOriginalKeyword(d2);
                                searchProductItem.setExtra(curatedHint);
                                searchProductItem.setType(14);
                                searchProductItem.setTrackingId(b.a(next.trackingid));
                                if (next.keyword_source_type != null) {
                                    i = next.keyword_source_type.getValue();
                                }
                                searchProductItem.setHintSourceType(i);
                                arrayList2.add(searchProductItem);
                            } catch (Exception e2) {
                                com.garena.android.appkit.d.a.a(e2);
                            }
                        } else {
                            SearchProductItem create = SearchProductItem.create(aVar.c());
                            create.setKeyword(next.keyword);
                            create.setOriginalKeyword(d2);
                            create.setCount(b.a(next.rnum));
                            create.setCategoryName(next.cat_name);
                            create.setCateId(b.a(next.catid));
                            create.setTrackingId(b.a(next.trackingid));
                            if (next.keyword_source_type != null) {
                                i = next.keyword_source_type.getValue();
                            }
                            create.setHintSourceType(i);
                            arrayList.add(create);
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    Collections.sort(arrayList2, new Comparator<SearchProductItem>() {
                        /* renamed from: a */
                        public int compare(SearchProductItem searchProductItem, SearchProductItem searchProductItem2) {
                            CuratedHint curatedHint = (CuratedHint) searchProductItem.getExtra();
                            CuratedHint curatedHint2 = (CuratedHint) searchProductItem2.getExtra();
                            if (curatedHint.getOrder() > curatedHint2.getOrder()) {
                                return 1;
                            }
                            return curatedHint.getOrder() < curatedHint2.getOrder() ? -1 : 0;
                        }
                    });
                }
                com.garena.android.appkit.b.b.a("SEARCH_HINT_LOAD", (com.garena.android.appkit.b.a) new com.shopee.app.ui.product.newsearch.b(aVar.c(), d2, arrayList, arrayList2), b.a.NETWORK_BUS);
            }
        }
    }

    private boolean a(ResponseSearchHint responseSearchHint) {
        if (responseSearchHint.errcode.intValue() == 0) {
            return true;
        }
        com.garena.android.appkit.b.b.a("SEARCH_HINT_ERROR", new com.garena.android.appkit.b.a("Search hint Error:" + responseSearchHint.errcode), b.a.NETWORK_BUS);
        return false;
    }

    public Pair<String, ResponseSearchHint> a(byte[] bArr) throws IOException {
        ResponseSearchHint responseSearchHint = (ResponseSearchHint) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseSearchHint.class);
        return new Pair<>(responseSearchHint.requestid, responseSearchHint);
    }
}
