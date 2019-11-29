package com.shopee.app.ui.chat.cell;

import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.util.bm;
import com.shopee.app.util.i;
import com.shopee.app.util.j.a;
import java.util.List;
import java.util.Map;

public class al {

    /* renamed from: a  reason: collision with root package name */
    private static al f20071a;

    /* renamed from: b  reason: collision with root package name */
    private String f20072b;

    /* renamed from: c  reason: collision with root package name */
    private a<String, Float> f20073c = new a<>(ar.a("store_key_chat_type"), 50, "chat_item_type_store", new com.google.a.c.a<Map<String, Float>>() {
    });

    private al() {
    }

    public static al a() {
        if (f20071a == null) {
            f20071a = new al();
        }
        return f20071a;
    }

    public void a(String str, float f2) {
        this.f20073c.a(str, Float.valueOf(f2));
    }

    public Float a(String str) {
        return this.f20073c.b(str);
    }

    public void a(List<ChatMessage> list) {
        if (list != null) {
            boolean z = false;
            for (ChatMessage next : list) {
                if (next.getType() == 8) {
                    String str = (String) next.getData();
                    UserInfo loggedInUser = ar.f().e().loggedInUser();
                    CookieManager instance = CookieManager.getInstance();
                    instance.setAcceptCookie(true);
                    String str2 = "userid=" + loggedInUser.getUserId() + "; shopid=" + loggedInUser.getShopId() + "; shopee_token=" + loggedInUser.getToken() + "; domain=" + i.f7042e + "; path=/;";
                    String str3 = "shopee_token=" + loggedInUser.getToken() + "; domain=" + i.f7042e + "; path=/;";
                    instance.setCookie(str, str2);
                    instance.setCookie(str, str3);
                    instance.setCookie(str, "username=" + loggedInUser.getUsername() + "; domain=" + i.f7042e + "; path=/;");
                    instance.setCookie(str, "UA=" + bm.a(b()) + "; domain=" + i.f7042e + "; path=/;");
                    z = true;
                }
            }
            if (z) {
                CookieSyncManager.getInstance().sync();
            }
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.f20072b)) {
            this.f20072b = "Shopee" + " Beeshop" + " locale/" + ar.f().e().deviceStore().b() + " version=" + 297;
        }
        return this.f20072b;
    }
}
