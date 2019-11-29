package com.squareup.a;

import android.content.Context;
import android.net.Uri;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.salesforce.android.service.common.utilities.threading.Timer;
import com.squareup.a.j;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class v implements j {

    /* renamed from: a  reason: collision with root package name */
    private final OkHttpClient f30583a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f30584b;

    private static OkHttpClient a() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(Timer.DEFAULT_TIMER_DELAY_MS, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(20000, TimeUnit.MILLISECONDS);
        okHttpClient.setWriteTimeout(20000, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    public v(Context context) {
        this(aj.b(context));
    }

    public v(File file) {
        this(file, aj.a(file));
    }

    public v(File file, long j) {
        this(a());
        this.f30584b = false;
        this.f30583a.setCache(new Cache(file, j));
    }

    public v(OkHttpClient okHttpClient) {
        this.f30584b = true;
        this.f30583a = okHttpClient;
    }

    public j.a a(Uri uri, int i) throws IOException {
        CacheControl cacheControl;
        if (i == 0) {
            cacheControl = null;
        } else if (s.isOfflineOnly(i)) {
            cacheControl = CacheControl.FORCE_CACHE;
        } else {
            CacheControl.Builder builder = new CacheControl.Builder();
            if (!s.shouldReadFromDiskCache(i)) {
                builder.noCache();
            }
            if (!s.shouldWriteToDiskCache(i)) {
                builder.noStore();
            }
            cacheControl = builder.build();
        }
        Request.Builder url = new Request.Builder().url(uri.toString());
        if (cacheControl != null) {
            url.cacheControl(cacheControl);
        }
        Response execute = this.f30583a.newCall(url.build()).execute();
        int code = execute.code();
        if (code < 300) {
            boolean z = execute.cacheResponse() != null;
            ResponseBody body = execute.body();
            return new j.a(body.byteStream(), z, body.contentLength());
        }
        execute.body().close();
        throw new j.b(code + SQLBuilder.BLANK + execute.message(), i, code);
    }
}
