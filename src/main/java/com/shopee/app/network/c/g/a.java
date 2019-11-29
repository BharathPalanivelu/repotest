package com.shopee.app.network.c.g;

import android.util.Pair;
import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.database.orm.bean.DBShopInfo;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.h.o;
import com.shopee.app.network.c.c;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.b;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class a extends c implements com.shopee.app.network.a.a<ResponseCommon> {
    public int a() {
        return 1;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        b bVar = (b) o.a().f(responseCommon.requestid);
        if (bVar == null || !bVar.c()) {
            com.shopee.app.util.k.a d2 = o.a().d(responseCommon.requestid);
            if (a(responseCommon)) {
                try {
                    ar.f().e().addItemProcessor().a(responseCommon, d2);
                } catch (Exception e2) {
                    ar.f().e().fabricClient().a((Throwable) e2, "");
                    if (d2 != null) {
                        ResponseCommon.Builder builder = new ResponseCommon.Builder();
                        builder.errcode(7);
                        d2.onFailed(builder.build());
                    }
                }
            } else if (d2 != null) {
                d2.onFailed(responseCommon);
            }
        } else if (a(responseCommon)) {
            com.garena.android.appkit.b.b.a("ADD_ITEM_RESULT_VALIDATE", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    }

    public Pair<String, ResponseCommon> a(byte[] bArr) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseCommon.class);
        return new Pair<>(responseCommon.requestid, responseCommon);
    }

    /* renamed from: com.shopee.app.network.c.g.a$a  reason: collision with other inner class name */
    public static class C0268a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17912a;

        /* renamed from: b  reason: collision with root package name */
        private final bh f17913b;

        /* renamed from: c  reason: collision with root package name */
        private final UserInfo f17914c;

        /* renamed from: d  reason: collision with root package name */
        private final SettingConfigStore f17915d;

        public C0268a(n nVar, bh bhVar, UserInfo userInfo, SettingConfigStore settingConfigStore) {
            this.f17912a = nVar;
            this.f17913b = bhVar;
            this.f17914c = userInfo;
            this.f17915d = settingConfigStore;
        }

        public void a(ResponseCommon responseCommon, com.shopee.app.util.k.a aVar) {
            az f2 = o.a().f(responseCommon.requestid);
            DBShopInfo b2 = this.f17913b.b(this.f17914c.getShopId());
            DBUserInfo a2 = this.f17913b.a(this.f17914c.getUserId());
            ShopDetail shopDetail = new ShopDetail();
            com.shopee.app.d.b.b.a(b2, a2, shopDetail, this.f17915d);
            com.shopee.app.ui.product.add.a aVar2 = new com.shopee.app.ui.product.add.a(responseCommon.itemid.longValue(), com.shopee.app.d.b.b.a(responseCommon.is_userinfo_complete) == 1, responseCommon.redirect_url, shopDetail, f2);
            this.f17912a.a("ADD_ITEM_RESULT_SUCCESS", (com.garena.android.appkit.b.a) aVar2);
            if (aVar != null) {
                aVar.onSuccess(aVar2);
            }
        }
    }

    private boolean a(ResponseCommon responseCommon) {
        if (responseCommon.errcode.intValue() == 0) {
            return true;
        }
        b(responseCommon);
        return false;
    }

    private void b(ResponseCommon responseCommon) {
        com.garena.android.appkit.b.b.a("ADD_ITEM_RESULT_ERROR", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)), b.a.NETWORK_BUS);
    }

    public void a(String str) {
        com.shopee.app.util.k.a d2 = o.a().d(str);
        if (d2 != null) {
            ResponseCommon.Builder builder = new ResponseCommon.Builder();
            builder.errcode(-100);
            d2.onFailed(builder.build());
        }
        ResponseCommon.Builder builder2 = new ResponseCommon.Builder();
        builder2.errcode = -100;
        b(builder2.build());
    }
}
