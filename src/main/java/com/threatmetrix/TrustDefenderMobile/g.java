package com.threatmetrix.TrustDefenderMobile;

import android.net.http.AndroidHttpClient;
import android.util.Log;
import com.threatmetrix.TrustDefenderMobile.aa;
import com.threatmetrix.TrustDefenderMobile.i;
import java.io.IOException;
import java.util.Map;

class g extends i {

    /* renamed from: e  reason: collision with root package name */
    private static final String f32576e = "com.threatmetrix.TrustDefenderMobile.g";

    /* renamed from: a  reason: collision with root package name */
    public w f32577a = null;

    public g(AndroidHttpClient androidHttpClient, String str, h hVar, Map<String, String> map, aa aaVar) {
        super(androidHttpClient, i.a.GET, str, hVar, map, aaVar);
    }

    public void run() {
        String str = f32576e;
        Log.d(str, "starting retrieval: " + this.f32582c + "?" + this.f32583d.a());
        this.f32577a = null;
        super.run();
        if (b() == 200) {
            this.f32577a = new w();
            try {
                this.f32577a.a(c().d().getEntity().getContent());
            } catch (IOException e2) {
                Log.e(f32576e, "IO Error", e2);
            }
        }
    }

    public aa.b a() {
        if (this.f32581b.f() != aa.b.THM_OK) {
            return super.a();
        }
        w wVar = this.f32577a;
        return (wVar == null || !wVar.a()) ? aa.b.THM_ConfigurationError : aa.b.THM_OK;
    }
}
