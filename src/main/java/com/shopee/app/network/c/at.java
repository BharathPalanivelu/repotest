package com.shopee.app.network.c;

import android.util.Pair;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.m;
import com.shopee.app.database.orm.bean.DBCategory;
import com.shopee.app.h.o;
import com.shopee.app.network.d.az;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseCategoryList;
import com.shopee.protocol.shop.Category;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class at extends c implements com.shopee.app.network.a.a<ResponseCategoryList> {
    public int a() {
        return 219;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCategoryList responseCategoryList = (ResponseCategoryList) f.f18486a.parseFrom(bArr, 0, i, ResponseCategoryList.class);
        c(responseCategoryList.requestid);
        c().a(responseCategoryList);
    }

    public void a(String str) {
        c().a();
    }

    private a c() {
        return ar.f().e().newGetSubCategoryProcessor();
    }

    public Pair<String, ResponseCategoryList> a(byte[] bArr) throws IOException {
        ResponseCategoryList responseCategoryList = (ResponseCategoryList) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseCategoryList.class);
        return new Pair<>(responseCategoryList.requestid, responseCategoryList);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f17824a;

        /* renamed from: b  reason: collision with root package name */
        private m f17825b;

        public a(n nVar, m mVar) {
            this.f17824a = nVar;
            this.f17825b = mVar;
        }

        public void a(ResponseCategoryList responseCategoryList) {
            if (b(responseCategoryList)) {
                boolean z = true;
                az f2 = o.a().f(responseCategoryList.requestid);
                if (f2 instanceof com.shopee.app.network.d.ar) {
                    z = ((com.shopee.app.network.d.ar) f2).c();
                }
                if (z) {
                    this.f17825b.b();
                }
                ArrayList arrayList = new ArrayList();
                for (Category a2 : responseCategoryList.category) {
                    DBCategory dBCategory = new DBCategory();
                    b.a(a2, dBCategory);
                    arrayList.add(dBCategory);
                }
                this.f17825b.a((List<DBCategory>) arrayList);
                this.f17824a.a("CMD_GET_SUBCATEGORY_SUCCESS", new com.garena.android.appkit.b.a());
            }
        }

        private boolean b(ResponseCategoryList responseCategoryList) {
            if (responseCategoryList.errcode.intValue() == 0) {
                return true;
            }
            this.f17824a.a("CMD_GET_SUBCATEGORY_ERROR", new com.garena.android.appkit.b.a(responseCategoryList.errcode));
            return false;
        }

        public void a() {
            this.f17824a.a("CMD_GET_SUBCATEGORY_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
