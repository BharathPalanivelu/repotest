package com.shopee.app.ui.video;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.garena.videolib.uploader.d;
import com.garena.videolib.uploader.f;
import com.shopee.app.ui.image.MediaData;
import com.shopee.app.web.WebRegister;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, c> f25765a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final MediaData f25766b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f25767c;

    /* renamed from: d  reason: collision with root package name */
    private int f25768d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f25769e;

    public interface a {
        void a(int i);
    }

    private c(MediaData mediaData) {
        this.f25766b = mediaData;
    }

    public static c a(MediaData mediaData) {
        if (!b(mediaData)) {
            return null;
        }
        if (f25765a.containsKey(mediaData.getPath())) {
            return f25765a.get(mediaData.getPath());
        }
        c cVar = new c(mediaData);
        f25765a.put(mediaData.getPath(), cVar);
        return cVar;
    }

    public boolean a() {
        return b(this.f25766b);
    }

    private static boolean b(MediaData mediaData) {
        if (mediaData == null || TextUtils.isEmpty(mediaData.getPath())) {
            return false;
        }
        return new File(Uri.parse(mediaData.getPath()).getPath()).exists();
    }

    public String a(a aVar) {
        return a(new com.garena.videolib.a.c(Uri.parse(this.f25766b.getPath()).getPath()), aVar);
    }

    private String a(com.garena.videolib.a.c cVar, final a aVar) {
        new f(new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(300, TimeUnit.SECONDS).build(), WebRegister.GSON, cVar, (com.garena.videolib.a.a) null).a(new d() {
            public void onSessionSuccess(String str) {
                Log.d("TEST1", "SESSION: " + str);
                String unused = c.this.f25769e = str;
            }

            public void onProgress(int i) {
                aVar.a(i);
            }

            public void onFinish(String str) {
                String unused = c.this.f25767c = Uri.parse(str).getLastPathSegment();
            }

            public void onError(Exception exc) {
                Log.d("TEST1", "PROGRESS: " + exc.getMessage());
            }
        });
        return this.f25767c;
    }
}
