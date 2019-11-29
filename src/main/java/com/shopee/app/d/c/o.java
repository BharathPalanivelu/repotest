package com.shopee.app.d.c;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.perf.network.FirebasePerfHttpClient;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.h.b.a;
import com.shopee.app.h.f;
import com.shopee.app.h.m;
import com.shopee.app.network.d.bu;
import com.shopee.app.network.g;
import com.shopee.app.ui.auth.signup.c;
import com.shopee.app.util.n;
import com.shopee.protocol.shop.Shop;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class o extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final n f17105c;

    /* renamed from: d  reason: collision with root package name */
    private String f17106d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public SettingConfigStore f17107e;

    /* access modifiers changed from: protected */
    public String d() {
        return "DownloadFBCoverInteractor";
    }

    public o(n nVar, SettingConfigStore settingConfigStore) {
        super(nVar);
        this.f17105c = nVar;
        this.f17107e = settingConfigStore;
    }

    public void a(String str) {
        this.f17106d = str;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        try {
            HttpResponse execute = FirebasePerfHttpClient.execute(new DefaultHttpClient(), new HttpGet("https://graph.facebook.com/me?fields=cover&access_token=" + this.f17106d));
            String str = null;
            if (execute.getStatusLine().getStatusCode() == 200) {
                JSONObject jSONObject = new JSONObject(EntityUtils.toString(execute.getEntity()));
                if (jSONObject.has(PlaceFields.COVER)) {
                    if (!jSONObject.getString(PlaceFields.COVER).equals("null")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject(PlaceFields.COVER);
                        if (optJSONObject.has(ShareConstants.FEED_SOURCE_PARAM)) {
                            str = optJSONObject.getString(ShareConstants.FEED_SOURCE_PARAM);
                        }
                    }
                }
            }
            if (str != null) {
                a.a().a(str, "fb_cover.jpg", new Runnable() {
                    public void run() {
                        String str = "file:///" + f.a().b("fb_cover.jpg");
                        if (!TextUtils.isEmpty(str)) {
                            String a2 = c.a(Uri.parse(str), o.this.f17107e.getCoverImageConfig());
                            if (a2 != null) {
                                HashSet hashSet = new HashSet();
                                hashSet.add(a2);
                                hashSet.add(a2 + "_tn");
                                a.a().a((Set<String>) hashSet, new g());
                                o.this.f17105c.a("FACEBOOK_COVER_GRABBED", new com.garena.android.appkit.b.a(a2));
                                int intValue = new m().g().intValue();
                                if (intValue != 0) {
                                    bu buVar = new bu();
                                    Shop.Builder builder = new Shop.Builder();
                                    builder.shopid(Integer.valueOf(intValue)).cover(a2);
                                    buVar.a(builder.build());
                                }
                            }
                        }
                    }
                });
            }
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}
