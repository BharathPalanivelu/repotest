package com.garena.videolib.uploader;

import android.text.TextUtils;
import com.garena.videolib.a.a;
import com.garena.videolib.uploader.e;
import com.google.a.f;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qcloud.core.http.HttpConstants;
import java.util.Locale;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final com.garena.videolib.a.c f8718a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final b f8719b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8720c;

    /* renamed from: d  reason: collision with root package name */
    private final OkHttpClient f8721d;

    /* renamed from: e  reason: collision with root package name */
    private final a f8722e;

    /* renamed from: f  reason: collision with root package name */
    private final f f8723f;

    public c(com.garena.videolib.a.c cVar, a aVar, String str, b bVar, OkHttpClient okHttpClient, f fVar) {
        this.f8718a = cVar;
        this.f8722e = aVar;
        this.f8720c = str;
        this.f8719b = bVar;
        this.f8721d = okHttpClient;
        this.f8723f = fVar;
    }

    public void a() {
        if (!TextUtils.isEmpty(this.f8720c)) {
            b();
        }
    }

    private void b() {
        Locale locale = Locale.ENGLISH;
        String format = String.format(locale, com.garena.videolib.a.f6702a + "?upload_id=%1$s", new Object[]{this.f8720c});
        long length = this.f8718a.a().length();
        int a2 = a(format, length);
        if (a2 != -1) {
            String format2 = String.format(Locale.ENGLISH, "bytes %d-%d/%d", new Object[]{Integer.valueOf(a2), Long.valueOf(length - 1), Long.valueOf(length)});
            try {
                ServerResponse serverResponse = (ServerResponse) this.f8723f.a(FirebasePerfOkHttpClient.execute(this.f8721d.newCall(new Request.Builder().url(format).header(HttpConstants.Header.CONTENT_RANGE, format2).put(new e(this.f8718a.a(), COSRequestHeaderKey.APPLICATION_OCTET_STREAM, new e.a() {
                    public void a(int i) {
                        c.this.f8719b.onProgress(i);
                    }
                }, a2)).build())).body().string(), ServerResponse.class);
                if (serverResponse.getStatus() == 0) {
                    this.f8719b.onFinish(serverResponse.getMessage());
                    return;
                }
                b bVar = this.f8719b;
                bVar.onError(new RuntimeException("Server Error:" + serverResponse));
            } catch (Exception e2) {
                this.f8719b.onError(e2);
            }
        }
    }

    private int a(String str, long j) {
        try {
            ServerResponse serverResponse = (ServerResponse) this.f8723f.a(FirebasePerfOkHttpClient.execute(this.f8721d.newCall(new Request.Builder().url(str).header(HttpConstants.Header.CONTENT_RANGE, String.format(Locale.ENGLISH, "bytes */%d", new Object[]{Long.valueOf(j)})).put(RequestBody.create(MediaType.parse("text/html"), str)).build())).body().string(), ServerResponse.class);
            if (serverResponse.getStatus() == 3) {
                return Integer.parseInt(serverResponse.getMessage().split("-")[1]) + 1;
            }
            return -1;
        } catch (Exception e2) {
            this.f8719b.onError(e2);
            return -1;
        }
    }
}
