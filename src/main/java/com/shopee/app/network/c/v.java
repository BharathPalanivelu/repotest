package com.shopee.app.network.c;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.data.store.m;
import com.shopee.app.database.orm.bean.DBCategory;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCategoryList;
import com.shopee.protocol.shop.Category;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class v extends c {
    public int a() {
        return 65;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCategoryList responseCategoryList = (ResponseCategoryList) f.f18486a.parseFrom(bArr, 0, i, ResponseCategoryList.class);
        c(responseCategoryList.requestid);
        if (!a(responseCategoryList)) {
            b.a("ITEM_CATEGORY_FAIL", new a(), b.a.NETWORK_BUS);
            return;
        }
        m mVar = new m();
        ArrayList arrayList = new ArrayList();
        for (Category a2 : responseCategoryList.category) {
            DBCategory dBCategory = new DBCategory();
            com.shopee.app.d.b.b.a(a2, dBCategory);
            arrayList.add(dBCategory);
        }
        mVar.b();
        mVar.a((List<DBCategory>) arrayList);
        b.a("ITEM_CATEGORY_SUCCESS", new a(), b.a.NETWORK_BUS);
    }

    private boolean a(ResponseCategoryList responseCategoryList) {
        boolean z = responseCategoryList.errcode.intValue() == 0;
        if (!z) {
            responseCategoryList.errcode.intValue();
        }
        return z;
    }

    public void a(String str) {
        b.a("ITEM_CATEGORY_FAIL", new a(), b.a.NETWORK_BUS);
    }
}
