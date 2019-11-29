package com.c.a.c.c;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.c.a.c.a.f;
import com.c.a.c.a.k;
import com.c.a.c.c.n;
import com.c.a.c.j;
import com.facebook.common.util.UriUtil;
import java.io.InputStream;

public class a<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f5890a = 22;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f5891b;

    /* renamed from: c  reason: collision with root package name */
    private final C0102a<Data> f5892c;

    /* renamed from: com.c.a.c.c.a$a  reason: collision with other inner class name */
    public interface C0102a<Data> {
        com.c.a.c.a.b<Data> a(AssetManager assetManager, String str);
    }

    public a(AssetManager assetManager, C0102a<Data> aVar) {
        this.f5891b = assetManager;
        this.f5892c = aVar;
    }

    public n.a<Data> a(Uri uri, int i, int i2, j jVar) {
        return new n.a<>(new com.c.a.h.b(uri), this.f5892c.a(this.f5891b, uri.toString().substring(f5890a)));
    }

    public boolean a(Uri uri) {
        if (!UriUtil.LOCAL_FILE_SCHEME.equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }

    public static class c implements C0102a<InputStream>, o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f5899a;

        public c(AssetManager assetManager) {
            this.f5899a = assetManager;
        }

        public n<Uri, InputStream> a(r rVar) {
            return new a(this.f5899a, this);
        }

        public com.c.a.c.a.b<InputStream> a(AssetManager assetManager, String str) {
            return new k(assetManager, str);
        }
    }

    public static class b implements C0102a<ParcelFileDescriptor>, o<Uri, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f5896a;

        public b(AssetManager assetManager) {
            this.f5896a = assetManager;
        }

        public n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new a(this.f5896a, this);
        }

        public com.c.a.c.a.b<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new f(assetManager, str);
        }
    }
}
