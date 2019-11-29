package com.shopee.app.ui.product.b.a;

import com.google.a.a.c;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.network.http.data.ListingConfig;
import com.shopee.app.util.q.g;
import d.d.b.j;
import java.util.List;

public final class d implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final a f24361a = new a((g) null);

    /* renamed from: c  reason: collision with root package name */
    private final b[] f24362c;

    public d(b[] bVarArr) {
        j.b(bVarArr, "constraints");
        this.f24362c = bVarArr;
    }

    public final b[] a() {
        return this.f24362c;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final d a(ListingConfig listingConfig) {
            j.b(listingConfig, "listingConfig");
            for (ListingConfig.ListingAttribute listingAttribute : listingConfig.getListingAttrs()) {
                if (j.a((Object) "category.dts_setting", (Object) listingAttribute.getKey())) {
                    b[] bVarArr = (b[]) com.shopee.web.sdk.bridge.internal.a.f30470a.a(listingAttribute.getValue(), new C0375a().getType());
                    j.a((Object) bVarArr, "dtsConstraints");
                    return new d(bVarArr);
                }
            }
            return new d(new b[0]);
        }

        /* renamed from: com.shopee.app.ui.product.b.a.d$a$a  reason: collision with other inner class name */
        public static final class C0375a extends com.google.a.c.a<b[]> {
            C0375a() {
            }
        }
    }

    private final b a(int i) {
        for (b bVar : this.f24362c) {
            if (bVar.c().contains(Integer.valueOf(i))) {
                return bVar;
            }
        }
        return null;
    }

    public static final class b {
        @c(a = "dts_min")

        /* renamed from: a  reason: collision with root package name */
        private final int f24363a;
        @c(a = "dts_max")

        /* renamed from: b  reason: collision with root package name */
        private final int f24364b;
        @c(a = "cat_ids")

        /* renamed from: c  reason: collision with root package name */
        private final List<Integer> f24365c;

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (this.f24363a == bVar.f24363a) {
                        if (!(this.f24364b == bVar.f24364b) || !j.a((Object) this.f24365c, (Object) bVar.f24365c)) {
                            return false;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = ((Integer.valueOf(this.f24363a).hashCode() * 31) + Integer.valueOf(this.f24364b).hashCode()) * 31;
            List<Integer> list = this.f24365c;
            return hashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "DtsConstraint(minDts=" + this.f24363a + ", maxDts=" + this.f24364b + ", catIds=" + this.f24365c + SQLBuilder.PARENTHESES_RIGHT;
        }

        public final int a() {
            return this.f24363a;
        }

        public final int b() {
            return this.f24364b;
        }

        public final List<Integer> c() {
            return this.f24365c;
        }
    }

    public final b a(List<Integer> list) {
        if (list == null) {
            return null;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            b a2 = a(list.get(size).intValue());
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }
}
