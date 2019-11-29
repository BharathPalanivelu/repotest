package com.squareup.a;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

public interface j {
    a a(Uri uri, int i) throws IOException;

    public static class b extends IOException {
        final boolean localCacheOnly;
        final int responseCode;

        public b(String str, int i, int i2) {
            super(str);
            this.localCacheOnly = s.isOfflineOnly(i);
            this.responseCode = i2;
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final InputStream f30566a;

        /* renamed from: b  reason: collision with root package name */
        final Bitmap f30567b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f30568c;

        /* renamed from: d  reason: collision with root package name */
        final long f30569d;

        public a(InputStream inputStream, boolean z, long j) {
            if (inputStream != null) {
                this.f30566a = inputStream;
                this.f30567b = null;
                this.f30568c = z;
                this.f30569d = j;
                return;
            }
            throw new IllegalArgumentException("Stream may not be null.");
        }

        public InputStream a() {
            return this.f30566a;
        }

        @Deprecated
        public Bitmap b() {
            return this.f30567b;
        }

        public long c() {
            return this.f30569d;
        }
    }
}
