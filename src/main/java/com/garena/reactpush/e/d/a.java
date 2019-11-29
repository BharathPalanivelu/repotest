package com.garena.reactpush.e.d;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.appsflyer.share.Constants;
import com.garena.reactpush.b;
import com.garena.reactpush.c.d;
import com.garena.reactpush.d.e;
import com.garena.reactpush.d.f;
import com.garena.reactpush.data.BundleDiff;
import com.garena.reactpush.data.Manifest;
import com.garena.reactpush.data.ReactBundle;
import com.garena.reactpush.e.b.c;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.tencent.ijk.media.player.IjkMediaCodecInfo;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class a implements f {

    /* renamed from: b  reason: collision with root package name */
    private static final int f8440b = (b.f6699b ? IjkMediaCodecInfo.RANK_LAST_CHANCE : 0);

    /* renamed from: a  reason: collision with root package name */
    protected final com.garena.reactpush.e.c.a f8441a;

    /* renamed from: c  reason: collision with root package name */
    private com.garena.reactpush.b.b f8442c;

    /* renamed from: d  reason: collision with root package name */
    private OkHttpClient f8443d;

    /* renamed from: e  reason: collision with root package name */
    private String f8444e;

    /* renamed from: f  reason: collision with root package name */
    private String f8445f;

    /* renamed from: g  reason: collision with root package name */
    private String f8446g;

    public a(OkHttpClient okHttpClient, com.garena.reactpush.b.b bVar, float f2, String str, String str2, com.garena.reactpush.e.c.a aVar) {
        this.f8442c = bVar;
        this.f8443d = okHttpClient;
        this.f8444e = str2;
        this.f8445f = b.a(f2);
        this.f8446g = str;
        this.f8441a = aVar;
    }

    public void a(e eVar) {
        final C0145a aVar = new C0145a(eVar);
        com.garena.reactpush.c.a.a(new Runnable() {
            public void run() {
                if (a.this.f8441a.b() && !a.this.f8441a.c()) {
                    aVar.a((Exception) new RuntimeException("We don't sync when partially loaded"));
                    return;
                }
                try {
                    a.this.b(aVar);
                } catch (Exception e2) {
                    aVar.a(e2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(e eVar) throws IOException {
        if (this.f8442c.c().isSyncLocalSucccess()) {
            b.f6701d.a("Manifest Requested");
            Response execute = FirebasePerfOkHttpClient.execute(this.f8443d.newCall(new Request.Builder().url(this.f8444e).header(HttpConstants.Header.CONNECTION, "close").build()));
            ResponseBody body = execute.body();
            if (!execute.isSuccessful() || body == null) {
                eVar.a((Exception) new RuntimeException(String.valueOf(execute.code())));
                return;
            }
            b.f6701d.a("Manifest Downloaded");
            Manifest manifest = (Manifest) b.f6698a.a(body.string(), Manifest.class);
            if (!a(manifest)) {
                eVar.a((Exception) new RuntimeException("Invalid Manifest"));
            } else if (b(manifest)) {
                Manifest a2 = this.f8442c.a();
                HashMap hashMap = new HashMap();
                hashMap.put("drawable_" + this.f8445f, "drawable-" + this.f8445f + Constants.URL_PATH_DELIMITER);
                hashMap.put("strings", "");
                List<BundleDiff> a3 = new com.garena.reactpush.e.a.a(new ArrayList(hashMap.keySet())).a(a2, manifest);
                if (a3.size() == 0) {
                    eVar.a(false);
                } else {
                    new c(this.f8443d, this.f8445f, this.f8446g, hashMap).a(a3, (com.garena.reactpush.e.b.b) new com.garena.reactpush.e.f.a(a2, manifest, this.f8442c, eVar));
                }
            } else {
                eVar.a(false);
            }
        } else {
            eVar.a(false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(Manifest manifest) {
        if (manifest == null || manifest.isEmpty()) {
            return false;
        }
        List<ReactBundle> bundles = manifest.getBundles();
        if (bundles == null || bundles.size() == 0) {
            return true;
        }
        for (ReactBundle a2 : bundles) {
            if (!a(a2)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean a(ReactBundle reactBundle) {
        if (reactBundle == null || !URLUtil.isValidUrl(reactBundle.getAssetBaseURL()) || !URLUtil.isValidUrl(reactBundle.getUrl()) || TextUtils.isEmpty(reactBundle.getMd5()) || TextUtils.isEmpty(reactBundle.getName())) {
            return false;
        }
        for (float a2 : b.f6700c) {
            if (!URLUtil.isValidUrl(reactBundle.getZipUrl(b.a(a2)))) {
                return false;
            }
        }
        for (float a3 : b.f6700c) {
            if (!URLUtil.isValidUrl(reactBundle.getDrawableZip(b.a(a3)))) {
                return false;
            }
        }
        return true;
    }

    private boolean b(Manifest manifest) {
        return manifest.getManifestVersion() + ((long) f8440b) < System.currentTimeMillis() / 1000;
    }

    /* renamed from: com.garena.reactpush.e.d.a$a  reason: collision with other inner class name */
    private static class C0145a implements e {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public e f8449a;

        public C0145a(e eVar) {
            this.f8449a = eVar;
        }

        public void a(final boolean z) {
            d dVar = b.f6701d;
            dVar.a("Sync Complete. Changed=" + z);
            if (this.f8449a != null) {
                com.garena.reactpush.c.f.a(new Runnable() {
                    public void run() {
                        C0145a.this.f8449a.a(z);
                    }
                });
            }
        }

        public void a(final Exception exc) {
            b.f6701d.a("Sync Failed");
            b.f6701d.a(exc);
            if (this.f8449a != null) {
                com.garena.reactpush.c.f.a(new Runnable() {
                    public void run() {
                        C0145a.this.f8449a.a(exc);
                    }
                });
            }
        }
    }
}
