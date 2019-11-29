package com.garena.videolib.uploader;

import android.net.Uri;
import android.text.TextUtils;
import com.garena.videolib.a.c;
import com.garena.videolib.uploader.e;
import com.google.a.f;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import java.util.Locale;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final c f8712a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final d f8713b;

    /* renamed from: c  reason: collision with root package name */
    private final com.garena.videolib.a.a f8714c;

    /* renamed from: d  reason: collision with root package name */
    private final OkHttpClient f8715d;

    /* renamed from: e  reason: collision with root package name */
    private final f f8716e;

    public a(OkHttpClient okHttpClient, f fVar, c cVar, com.garena.videolib.a.a aVar, d dVar) {
        this.f8715d = okHttpClient;
        this.f8716e = fVar;
        this.f8712a = cVar;
        this.f8714c = aVar;
        this.f8713b = dVar;
    }

    public void a() {
        String b2 = b();
        if (!TextUtils.isEmpty(b2)) {
            a(b2);
        }
    }

    private String b() {
        String str;
        if (this.f8714c != null) {
            str = String.format(Locale.ENGLISH, "token=%1$s&userid=%2$s&size=%3$s", new Object[]{this.f8714c.a(), this.f8714c.b(), this.f8712a.b()});
        } else {
            str = String.format(Locale.ENGLISH, "size=%1$s", new Object[]{this.f8712a.b()});
        }
        try {
            Response execute = FirebasePerfOkHttpClient.execute(this.f8715d.newCall(new Request.Builder().url(com.garena.videolib.a.f6702a).post(RequestBody.create(MediaType.parse("text/html"), str)).build()));
            if (execute.isSuccessful()) {
                ServerResponse serverResponse = (ServerResponse) this.f8716e.a(execute.body().string(), ServerResponse.class);
                if (serverResponse.getStatus() == 0) {
                    String queryParameter = Uri.parse(serverResponse.getMessage()).getQueryParameter("upload_id");
                    this.f8713b.onSessionSuccess(queryParameter);
                    return queryParameter;
                }
                d dVar = this.f8713b;
                dVar.onError(new RuntimeException("Server Error:" + serverResponse));
                return null;
            }
            d dVar2 = this.f8713b;
            dVar2.onError(new RuntimeException("Upload Error: " + execute));
            return null;
        } catch (Exception e2) {
            this.f8713b.onError(e2);
            return null;
        }
    }

    private void a(String str) {
        Locale locale = Locale.ENGLISH;
        String format = String.format(locale, com.garena.videolib.a.f6702a + "?upload_id=%1$s", new Object[]{str});
        try {
            Response execute = FirebasePerfOkHttpClient.execute(this.f8715d.newCall(new Request.Builder().url(format).put(new e(this.f8712a.a(), COSRequestHeaderKey.APPLICATION_OCTET_STREAM, new e.a() {
                public void a(int i) {
                    a.this.f8713b.onProgress(i);
                }
            })).tag("upload").build()));
            if (execute.isSuccessful()) {
                ServerResponse serverResponse = (ServerResponse) this.f8716e.a(execute.body().string(), ServerResponse.class);
                if (serverResponse.getStatus() == 0) {
                    this.f8713b.onFinish(serverResponse.getMessage());
                    return;
                }
                d dVar = this.f8713b;
                dVar.onError(new RuntimeException("Server Error:" + serverResponse));
                return;
            }
            d dVar2 = this.f8713b;
            dVar2.onError(new RuntimeException("Upload Error: " + execute));
        } catch (Exception e2) {
            this.f8713b.onError(e2);
        }
    }
}
