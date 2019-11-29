package com.shopee.app.ui.product.b;

import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.data.viewmodel.AddProductInfo;
import com.shopee.app.network.http.data.ListingConfig;
import com.shopee.app.util.q.d;
import com.shopee.app.util.q.e;
import com.shopee.app.util.q.f;
import d.d.b.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class c extends com.shopee.app.util.q.a {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(com.shopee.app.util.q.c cVar) {
        super(cVar);
        j.b(cVar, "messageSupplier");
    }

    /* access modifiers changed from: protected */
    public List<e.C0408e> a() {
        return d.a.j.a((T[]) new e.C0408e[]{e.C0408e.BRAND, e.C0408e.CATEGORY, e.C0408e.DESCRIPTION, e.C0408e.DTS, e.C0408e.IMAGE_COUNT, e.C0408e.PRICE, e.C0408e.STOCK, e.C0408e.TITLE});
    }

    public final a a(AddProductInfo addProductInfo, int i) {
        Object obj;
        boolean z;
        j.b(addProductInfo, "productInfo");
        Map linkedHashMap = new LinkedHashMap();
        boolean z2 = true;
        linkedHashMap.put(e.C0408e.IMAGE_COUNT, a(new e.c(i), true));
        e.C0408e eVar = e.C0408e.TITLE;
        String name = addProductInfo.getName();
        j.a((Object) name, "productInfo.name");
        linkedHashMap.put(eVar, a(new e.d(name), true));
        e.C0408e eVar2 = e.C0408e.DESCRIPTION;
        String description = addProductInfo.getDescription();
        j.a((Object) description, "productInfo.description");
        linkedHashMap.put(eVar2, a(new e.a(description), true));
        linkedHashMap.put(e.C0408e.DTS, a(new e.b(addProductInfo.getCategoryIdPath(), addProductInfo.isPreOrder(), addProductInfo.getShippingDays()), true));
        Iterator it = linkedHashMap.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!(((d) obj) instanceof d.b)) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        d dVar = (d) obj;
        if (dVar != null) {
            z2 = false;
        }
        return new a(z2, dVar instanceof d.a ? ((d.a) dVar).a() : "", linkedHashMap);
    }

    public final List<f> a(ListingConfig listingConfig) {
        j.b(listingConfig, "listingConfig");
        n nVar = new n(listingConfig);
        List<f> arrayList = new ArrayList<>();
        for (e.C0408e a2 : a()) {
            f a3 = nVar.a(a2);
            if (a3 != null) {
                arrayList.add(a3);
            }
        }
        return arrayList;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f24381a;

        /* renamed from: b  reason: collision with root package name */
        private final String f24382b;

        /* renamed from: c  reason: collision with root package name */
        private final Map<e.C0408e, d> f24383c;

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (!(this.f24381a == aVar.f24381a) || !j.a((Object) this.f24382b, (Object) aVar.f24382b) || !j.a((Object) this.f24383c, (Object) aVar.f24383c)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.f24381a;
            if (z) {
                z = true;
            }
            int i = (z ? 1 : 0) * true;
            String str = this.f24382b;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            Map<e.C0408e, d> map = this.f24383c;
            if (map != null) {
                i2 = map.hashCode();
            }
            return hashCode + i2;
        }

        public String toString() {
            return "AddProductValidateResult(isSuccess=" + this.f24381a + ", errorMessage=" + this.f24382b + ", componentMap=" + this.f24383c + SQLBuilder.PARENTHESES_RIGHT;
        }

        public a(boolean z, String str, Map<e.C0408e, ? extends d> map) {
            j.b(str, "errorMessage");
            j.b(map, "componentMap");
            this.f24381a = z;
            this.f24382b = str;
            this.f24383c = map;
        }

        public final boolean a() {
            return this.f24381a;
        }

        public final String b() {
            return this.f24382b;
        }

        public final Map<e.C0408e, d> c() {
            return this.f24383c;
        }
    }
}
