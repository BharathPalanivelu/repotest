package com.shopee.app.network.c;

import android.util.Pair;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.af;
import com.shopee.app.data.store.an;
import com.shopee.app.database.orm.bean.DBItemAttribute;
import com.shopee.app.database.orm.bean.DBModelAttrIdMap;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseAttributeModel;
import com.shopee.protocol.shop.ItemAttribute;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class t extends c implements com.shopee.app.network.a.a<ResponseAttributeModel> {
    public int a() {
        return 237;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseAttributeModel responseAttributeModel = (ResponseAttributeModel) f.f18486a.parseFrom(bArr, 0, i, ResponseAttributeModel.class);
        c(responseAttributeModel.requestid);
        c().a(responseAttributeModel);
    }

    public void a(String str) {
        c().a();
    }

    private a c() {
        return ar.f().e().newGetAttributeModelProcessor();
    }

    public Pair<String, ResponseAttributeModel> a(byte[] bArr) throws IOException {
        ResponseAttributeModel responseAttributeModel = (ResponseAttributeModel) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseAttributeModel.class);
        return new Pair<>(responseAttributeModel.requestid, responseAttributeModel);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f18049a;

        /* renamed from: b  reason: collision with root package name */
        private final af f18050b;

        /* renamed from: c  reason: collision with root package name */
        private final an f18051c;

        public a(n nVar, af afVar, an anVar) {
            this.f18049a = nVar;
            this.f18050b = afVar;
            this.f18051c = anVar;
        }

        public void a(ResponseAttributeModel responseAttributeModel) {
            if (b(responseAttributeModel)) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (ItemAttribute next : responseAttributeModel.attrs) {
                    DBItemAttribute dBItemAttribute = new DBItemAttribute();
                    b.a(next, dBItemAttribute);
                    arrayList.add(dBItemAttribute);
                    arrayList2.add(next.attr_id);
                }
                int i = 0;
                if (responseAttributeModel.modelid != null) {
                    i = b.a(responseAttributeModel.modelid);
                }
                if (!com.shopee.app.util.af.a(arrayList)) {
                    this.f18050b.b(arrayList);
                }
                if (i > 0) {
                    DBModelAttrIdMap dBModelAttrIdMap = new DBModelAttrIdMap();
                    b.a(Integer.valueOf(i), (List<Integer>) arrayList2, dBModelAttrIdMap);
                    this.f18051c.a(dBModelAttrIdMap);
                    this.f18049a.a("CMD_GET_ATTRIBUTE_MODEL_SUCCESS", new com.garena.android.appkit.b.a(Integer.valueOf(i)));
                }
            }
        }

        private boolean b(ResponseAttributeModel responseAttributeModel) {
            if (responseAttributeModel.errcode.intValue() == 0) {
                return true;
            }
            this.f18049a.a("CMD_GET_ATTRIBUTE_MODEL_ERROR", new com.garena.android.appkit.b.a(responseAttributeModel.errcode));
            return false;
        }

        public void a() {
            this.f18049a.a("CMD_GET_ATTRIBUTE_MODEL_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
