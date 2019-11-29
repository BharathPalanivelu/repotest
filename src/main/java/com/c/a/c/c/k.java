package com.c.a.c.c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.c.a.c.a.b;
import com.c.a.c.c.n;
import com.c.a.c.j;
import com.c.a.g;
import java.io.File;
import java.io.FileNotFoundException;

public final class k implements n<Uri, File> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5938a;

    k(Context context) {
        this.f5938a = context;
    }

    public n.a<File> a(Uri uri, int i, int i2, j jVar) {
        return new n.a<>(new com.c.a.h.b(uri), new b(this.f5938a, uri));
    }

    public boolean a(Uri uri) {
        return com.c.a.c.a.a.b.a(uri);
    }

    private static class b implements com.c.a.c.a.b<File> {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f5940a = {"_data"};

        /* renamed from: b  reason: collision with root package name */
        private final Context f5941b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f5942c;

        public void a() {
        }

        public void b() {
        }

        b(Context context, Uri uri) {
            this.f5941b = context;
            this.f5942c = uri;
        }

        public void a(g gVar, b.a<? super File> aVar) {
            Cursor query = this.f5941b.getContentResolver().query(this.f5942c, f5940a, (String) null, (String[]) null, (String) null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                aVar.a((Exception) new FileNotFoundException("Failed to find file path for: " + this.f5942c));
                return;
            }
            aVar.a(new File(str));
        }

        public Class<File> d() {
            return File.class;
        }

        public com.c.a.c.a c() {
            return com.c.a.c.a.LOCAL;
        }
    }

    public static final class a implements o<Uri, File> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f5939a;

        public a(Context context) {
            this.f5939a = context;
        }

        public n<Uri, File> a(r rVar) {
            return new k(this.f5939a);
        }
    }
}
