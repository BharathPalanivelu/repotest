package com.c.a.c.c;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.c.a.c.a.g;
import com.c.a.c.a.l;
import com.c.a.c.c.n;
import com.c.a.c.j;
import com.facebook.common.util.UriUtil;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class w<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f5983a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{UriUtil.LOCAL_FILE_SCHEME, UriUtil.QUALIFIED_RESOURCE_SCHEME, UriUtil.LOCAL_CONTENT_SCHEME})));

    /* renamed from: b  reason: collision with root package name */
    private final b<Data> f5984b;

    public interface b<Data> {
        com.c.a.c.a.b<Data> a(Uri uri);
    }

    public w(b<Data> bVar) {
        this.f5984b = bVar;
    }

    public n.a<Data> a(Uri uri, int i, int i2, j jVar) {
        return new n.a<>(new com.c.a.h.b(uri), this.f5984b.a(uri));
    }

    public boolean a(Uri uri) {
        return f5983a.contains(uri.getScheme());
    }

    public static class c implements o<Uri, InputStream>, b<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f5986a;

        public c(ContentResolver contentResolver) {
            this.f5986a = contentResolver;
        }

        public com.c.a.c.a.b<InputStream> a(Uri uri) {
            return new l(this.f5986a, uri);
        }

        public n<Uri, InputStream> a(r rVar) {
            return new w(this);
        }
    }

    public static class a implements o<Uri, ParcelFileDescriptor>, b<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f5985a;

        public a(ContentResolver contentResolver) {
            this.f5985a = contentResolver;
        }

        public com.c.a.c.a.b<ParcelFileDescriptor> a(Uri uri) {
            return new g(this.f5985a, uri);
        }

        public n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new w(this);
        }
    }
}
