package com.shopee.app.h;

import android.text.TextUtils;
import com.garena.android.appkit.d.a;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.ak;
import com.shopee.app.util.i;
import com.shopee.shopeetracker.ShopeeTracker;
import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class s {

    /* renamed from: a  reason: collision with root package name */
    private UserInfo f6973a;

    public s(UserInfo userInfo) {
        this.f6973a = userInfo;
    }

    public void a() {
        ak a2 = ak.a();
        String str = (String) a2.t().b("");
        String str2 = (String) a2.s().b("");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            OkHttpClient okHttpClient = new OkHttpClient();
            FirebasePerfOkHttpClient.enqueue(okHttpClient.newCall(new Request.Builder().url(i.f7040c + "api/v2/user/login_status").addHeader("Set-Cookie", "userid=" + this.f6973a.getUserId() + "; shopid=" + this.f6973a.getShopId() + "; shopee_token=" + this.f6973a.getToken() + "; username=" + this.f6973a.getUsername() + "; domain=" + i.f7042e + "; path=/;").build()), new Callback() {
                public void onFailure(Call call, IOException iOException) {
                }

                public void onResponse(Call call, Response response) throws IOException {
                    if (response != null && response.isSuccessful()) {
                        List<String> headers = response.headers("Set-Cookie");
                        if (headers != null && !headers.isEmpty()) {
                            String str = null;
                            String str2 = null;
                            for (String next : headers) {
                                a.b("[Tracker][Cookie]" + next, new Object[0]);
                                for (String trim : next.split(";")) {
                                    String trim2 = trim.trim();
                                    if (trim2.startsWith("SPC_T_IV")) {
                                        str = trim2.substring(9, trim2.length());
                                    }
                                    if (trim2.startsWith("SPC_T_ID")) {
                                        str2 = trim2.substring(9, trim2.length());
                                    }
                                }
                                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                    ak.a().t().a(str).v();
                                    ak.a().s().a(str2).v();
                                    if (ShopeeTracker.isInitialized()) {
                                        ShopeeTracker.getInstance().updateSPCCookie(str, str2);
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                    }
                }
            });
        } else if (ShopeeTracker.isInitialized()) {
            a.b("[Tracker][SPC_ID]:" + str2 + "[SPC_IV]" + str, new Object[0]);
            ShopeeTracker.getInstance().updateSPCCookie(str, str2);
        }
    }
}
