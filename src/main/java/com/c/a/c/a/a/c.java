package com.c.a.c.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.c.a.c.a.b;
import com.c.a.c.a.e;
import com.c.a.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class c implements com.c.a.c.a.b<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f5642a;

    /* renamed from: b  reason: collision with root package name */
    private final e f5643b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f5644c;

    public void b() {
    }

    public static c a(Context context, Uri uri) {
        return a(context, uri, new a(context.getContentResolver()));
    }

    public static c b(Context context, Uri uri) {
        return a(context, uri, new b(context.getContentResolver()));
    }

    private static c a(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.c.a.c.a(context).h().a(), dVar, com.c.a.c.a(context).b(), context.getContentResolver()));
    }

    c(Uri uri, e eVar) {
        this.f5642a = uri;
        this.f5643b = eVar;
    }

    public void a(g gVar, b.a<? super InputStream> aVar) {
        try {
            this.f5644c = e();
            aVar.a(this.f5644c);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    private InputStream e() throws FileNotFoundException {
        InputStream b2 = this.f5643b.b(this.f5642a);
        int a2 = b2 != null ? this.f5643b.a(this.f5642a) : -1;
        return a2 != -1 ? new e(b2, a2) : b2;
    }

    public void a() {
        InputStream inputStream = this.f5644c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public Class<InputStream> d() {
        return InputStream.class;
    }

    public com.c.a.c.a c() {
        return com.c.a.c.a.LOCAL;
    }

    static class b implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f5647b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f5648a;

        b(ContentResolver contentResolver) {
            this.f5648a = contentResolver;
        }

        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f5648a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f5647b, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }

    static class a implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f5645b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f5646a;

        a(ContentResolver contentResolver) {
            this.f5646a = contentResolver;
        }

        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f5646a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f5645b, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }
}
