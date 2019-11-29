package com.squareup.a;

import android.content.Context;
import android.net.Uri;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.squareup.a.j;
import java.io.File;
import java.io.IOException;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class u implements j {

    /* renamed from: a  reason: collision with root package name */
    private final Call.Factory f30580a;

    /* renamed from: b  reason: collision with root package name */
    private final Cache f30581b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f30582c;

    public u(Context context) {
        this(aj.b(context));
    }

    public u(File file) {
        this(file, aj.a(file));
    }

    public u(File file, long j) {
        this(new OkHttpClient.Builder().cache(new Cache(file, j)).build());
        this.f30582c = false;
    }

    public u(OkHttpClient okHttpClient) {
        this.f30582c = true;
        this.f30580a = okHttpClient;
        this.f30581b = okHttpClient.cache();
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
        Response execute = FirebasePerfOkHttpClient.execute(this.f30580a.newCall(url.build()));
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
