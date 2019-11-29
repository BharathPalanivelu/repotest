package com.garena.reactpush.f.d;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.appsflyer.share.Constants;
import com.garena.reactpush.c.d;
import com.garena.reactpush.c.f;
import com.garena.reactpush.d.e;
import com.garena.reactpush.data.Manifest;
import com.garena.reactpush.data.ManifestDiff;
import com.garena.reactpush.data.ReactAsset;
import com.garena.reactpush.data.ReactBundle;
import com.garena.reactpush.data.ReactPack;
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

public class b extends com.garena.reactpush.e.d.a {

    /* renamed from: b  reason: collision with root package name */
    private static final int f8508b = (com.garena.reactpush.b.f6699b ? IjkMediaCodecInfo.RANK_LAST_CHANCE : 0);

    /* renamed from: c  reason: collision with root package name */
    private com.garena.reactpush.b.b f8509c;

    /* renamed from: d  reason: collision with root package name */
    private OkHttpClient f8510d;

    /* renamed from: e  reason: collision with root package name */
    private String f8511e;

    /* renamed from: f  reason: collision with root package name */
    private String f8512f;

    /* renamed from: g  reason: collision with root package name */
    private String f8513g;

    public b(OkHttpClient okHttpClient, com.garena.reactpush.b.b bVar, float f2, String str, String str2, com.garena.reactpush.e.c.a aVar) {
        super(okHttpClient, bVar, f2, str, str2, aVar);
        this.f8509c = bVar;
        this.f8510d = okHttpClient;
        this.f8511e = str2;
        this.f8512f = com.garena.reactpush.b.a(f2);
        this.f8513g = str;
    }

    public void a(e eVar) {
        final a aVar = new a(eVar);
        com.garena.reactpush.c.a.a(new Runnable() {
            public void run() {
                if (b.this.f8441a.b() && !b.this.f8441a.c()) {
                    aVar.a(false);
                    return;
                }
                try {
                    b.this.b(aVar);
                } catch (Exception e2) {
                    aVar.a(e2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(e eVar) throws IOException {
        if (this.f8509c.c().isSyncLocalSucccess()) {
            com.garena.reactpush.b.f6701d.a("Manifest Requested");
            Response execute = FirebasePerfOkHttpClient.execute(this.f8510d.newCall(new Request.Builder().url(this.f8511e).header(HttpConstants.Header.CONNECTION, "close").build()));
            ResponseBody body = execute.body();
            if (!execute.isSuccessful() || body == null) {
                eVar.a((Exception) new RuntimeException(String.valueOf(execute.code())));
                return;
            }
            com.garena.reactpush.b.f6701d.a("Manifest Downloaded");
            Manifest manifest = (Manifest) com.garena.reactpush.b.f6698a.a(body.string(), Manifest.class);
            if (!a(manifest)) {
                eVar.a((Exception) new RuntimeException("Invalid Manifest"));
            } else if (b(manifest)) {
                Manifest a2 = this.f8509c.a();
                HashMap hashMap = new HashMap();
                hashMap.put("drawable_" + this.f8512f, "drawable-" + this.f8512f + Constants.URL_PATH_DELIMITER);
                hashMap.put("strings", "");
                ManifestDiff a3 = new com.garena.reactpush.f.a.a(new ArrayList(hashMap.keySet())).a(a2, manifest);
                if (a3.isEmpty()) {
                    com.garena.reactpush.b.f6701d.b("Manifest Not Changed");
                    eVar.a(false);
                    return;
                }
                com.garena.reactpush.b.f6701d.b("Manifest Changed");
                new a(this.f8510d, this.f8513g, this.f8509c, eVar, hashMap).a(a2, manifest, a3);
            } else {
                eVar.a(false);
            }
        } else {
            eVar.a(false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(Manifest manifest) {
        if (manifest != null && !manifest.isEmpty()) {
            List<ReactBundle> bundles = manifest.getBundles();
            if (!(bundles == null || bundles.size() == 0)) {
                for (ReactBundle a2 : bundles) {
                    if (!a(a2)) {
                        return false;
                    }
                }
            }
            List<ReactAsset> assetList = manifest.getAssetList("drawable_" + this.f8512f);
            if (URLUtil.isValidUrl(manifest.getAssetsBaseURL()) && assetList != null && !assetList.isEmpty()) {
                for (ReactPack next : manifest.getPacks().values()) {
                    if (next != null) {
                        if (!URLUtil.isValidUrl(next.getPackURL(this.f8512f))) {
                        }
                    }
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean a(ReactBundle reactBundle) {
        if (reactBundle != null && URLUtil.isValidUrl(reactBundle.getUrl()) && !TextUtils.isEmpty(reactBundle.getName()) && !TextUtils.isEmpty(reactBundle.getMd5()) && reactBundle.getPriority() >= 0) {
            return true;
        }
        return false;
    }

    private boolean b(Manifest manifest) {
        return manifest.getManifestVersion() + ((long) f8508b) < System.currentTimeMillis() / 1000;
    }

    private static class a implements e {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public e f8516a;

        public a(e eVar) {
            this.f8516a = eVar;
        }

        public void a(final boolean z) {
            d dVar = com.garena.reactpush.b.f6701d;
            dVar.a("Sync Complete. Changed=" + z);
            if (this.f8516a != null) {
                f.a(new Runnable() {
                    public void run() {
                        a.this.f8516a.a(z);
                    }
                });
            }
        }

        public void a(final Exception exc) {
            com.garena.reactpush.b.f6701d.a("Sync Failed");
            com.garena.reactpush.b.f6701d.a(exc);
            if (this.f8516a != null) {
                f.a(new Runnable() {
                    public void run() {
                        a.this.f8516a.a(exc);
                    }
                });
            }
        }
    }
}
