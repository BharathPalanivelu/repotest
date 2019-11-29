package com.shopee.app.network.c;

import android.util.Pair;
import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.database.orm.bean.DBShopInfo;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.network.a.a;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseShop;
import com.shopee.protocol.shop.Account;
import com.shopee.protocol.shop.Shop;
import java.io.IOException;

public class as extends c implements a<ResponseShop> {
    public int a() {
        return 8;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseShop responseShop = (ResponseShop) f.f18486a.parseFrom(bArr, 0, i, ResponseShop.class);
        c(responseShop.requestid);
        if (!a(responseShop)) {
            b.a("SHOP_INFO_FETCHED_FAIL", new com.garena.android.appkit.b.a(responseShop.errcode), b.a.NETWORK_BUS);
            return;
        }
        bh bhVar = new bh();
        Shop shop = responseShop.shop;
        DBShopInfo dBShopInfo = new DBShopInfo();
        com.shopee.app.d.b.b.a(shop, responseShop.score.intValue(), responseShop.followed.booleanValue(), responseShop.max_image_count, dBShopInfo);
        bhVar.a(dBShopInfo);
        Account account = responseShop.user;
        DBUserInfo dBUserInfo = new DBUserInfo();
        com.shopee.app.d.b.b.a(account, dBUserInfo);
        bhVar.a(dBUserInfo);
        UserData userData = new UserData();
        com.shopee.app.d.b.b.a(dBUserInfo, userData);
        ShopDetail shopDetail = new ShopDetail();
        UserComponent e2 = ar.f().e();
        com.shopee.app.d.b.b.a(dBShopInfo, dBUserInfo, shopDetail, e2.settingConfigStore());
        UserInfo loggedInUser = e2.loggedInUser();
        if (shop.userid.intValue() == loggedInUser.getUserId()) {
            loggedInUser.setMall(shopDetail.isMall());
            loggedInUser.setSeller(shopDetail.isSeller());
            e2.loginStore().a(loggedInUser);
        }
        b.a("USER_INFO_UPDATED", new com.garena.android.appkit.b.a(userData), b.a.NETWORK_BUS);
        b.a("SHOP_INFO_FETCHED", new com.garena.android.appkit.b.a(shopDetail), b.a.NETWORK_BUS);
        b.a("SHOP_EDIT_INFO_FETCHED", new com.garena.android.appkit.b.a(responseShop.requestid), b.a.NETWORK_BUS);
    }

    private boolean a(ResponseShop responseShop) {
        return responseShop.errcode.intValue() == 0;
    }

    public void a(String str) {
        b.a("SHOP_INFO_FETCHED_FAIL", new com.garena.android.appkit.b.a(-100), b.a.NETWORK_BUS);
    }

    public Pair<String, ResponseShop> a(byte[] bArr) throws IOException {
        ResponseShop responseShop = (ResponseShop) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseShop.class);
        return new Pair<>(responseShop.requestid, responseShop);
    }
}
