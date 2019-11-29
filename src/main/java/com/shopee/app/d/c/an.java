package com.shopee.app.d.c;

import com.google.firebase.perf.network.FirebasePerfHttpClient;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.f.a;
import com.shopee.app.util.n;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class an extends a {

    /* renamed from: c  reason: collision with root package name */
    private final n f16492c;

    /* renamed from: d  reason: collision with root package name */
    private String f16493d;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetFbInfoInteractor";
    }

    public an(n nVar) {
        super(nVar);
        this.f16492c = nVar;
    }

    public void a(String str) {
        this.f16493d = str;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        try {
            HttpResponse execute = FirebasePerfHttpClient.execute(new DefaultHttpClient(), new HttpGet(String.format("https://graph.facebook.com/?id=%1$s&access_token=%2$s", new Object[]{this.f16493d, a.a().d()})));
            String str = null;
            if (execute.getStatusLine().getStatusCode() == 200) {
                JSONObject jSONObject = new JSONObject(EntityUtils.toString(execute.getEntity()));
                if (jSONObject.has("last_name")) {
                    str = jSONObject.getString("last_name");
                }
                if (jSONObject.has("first_name")) {
                    str = str + SQLBuilder.BLANK + jSONObject.getString("first_name");
                }
                if (str == null && jSONObject.has("name")) {
                    str = jSONObject.getString("name");
                }
            }
            this.f16492c.a("FACEBOOK_INFO_GET", new com.garena.android.appkit.b.a(str));
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}
