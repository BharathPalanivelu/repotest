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
import com.shopee.app.network.d.ao;
import com.shopee.app.network.d.ax;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.bj;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseCommon;
import com.shopee.protocol.shop.Item;
import java.io.File;
import java.io.IOException;

public class b extends c implements com.shopee.app.network.a.a<ResponseCommon> {
    public int a() {
        return 2;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        com.shopee.app.util.k.a d2 = o.a().d(responseCommon.requestid);
        az f2 = o.a().f(responseCommon.requestid);
        if (!(f2 instanceof com.shopee.app.network.d.o) || !((com.shopee.app.network.d.o) f2).e()) {
            if (a(responseCommon)) {
                try {
                    ar.f().e().editItemProcessor().a(responseCommon, d2);
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

    public Pair<String, ResponseCommon> a(byte[] bArr) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseCommon.class);
        return new Pair<>(responseCommon.requestid, responseCommon);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17916a;

        /* renamed from: b  reason: collision with root package name */
        private final bh f17917b;

        /* renamed from: c  reason: collision with root package name */
        private final UserInfo f17918c;

        /* renamed from: d  reason: collision with root package name */
        private final SettingConfigStore f17919d;

        public a(n nVar, bh bhVar, UserInfo userInfo, SettingConfigStore settingConfigStore) {
            this.f17916a = nVar;
            this.f17917b = bhVar;
            this.f17918c = userInfo;
            this.f17919d = settingConfigStore;
        }

        public void a(ResponseCommon responseCommon, com.shopee.app.util.k.a aVar) {
            az f2 = o.a().f(responseCommon.requestid);
            if (f2 != null && (f2 instanceof bj)) {
                new ao().a(this.f17918c.getShopId());
            }
            if (f2 != null && (f2 instanceof com.shopee.app.network.d.o)) {
                Item c2 = ((com.shopee.app.network.d.o) f2).c();
                if (c2.images != null) {
                    String[] split = c2.images.split(",");
                    String str = responseCommon.itemid + split[0] + "_sharing.jpg";
                    new File(com.shopee.app.h.f.a().c(str)).delete();
                    new File(com.shopee.app.h.f.a().d(str)).delete();
                }
            }
            new ax(this.f17918c.getShopId(), responseCommon.itemid.longValue()).g();
            DBShopInfo b2 = this.f17917b.b(this.f17918c.getShopId());
            DBUserInfo a2 = this.f17917b.a(this.f17918c.getUserId());
            ShopDetail shopDetail = new ShopDetail();
            com.shopee.app.d.b.b.a(b2, a2, shopDetail, this.f17919d);
            long longValue = responseCommon.itemid.longValue();
            boolean z = true;
            if (com.shopee.app.d.b.b.a(responseCommon.is_userinfo_complete) != 1) {
                z = false;
            }
            com.shopee.app.ui.product.add.a aVar2 = new com.shopee.app.ui.product.add.a(longValue, z, responseCommon.redirect_url, shopDetail, f2);
            this.f17916a.a("EDIT_ITEM_SUCCESS", (com.garena.android.appkit.b.a) aVar2);
            if (aVar != null) {
                aVar.onSuccess(aVar2);
            }
        }
    }
}
