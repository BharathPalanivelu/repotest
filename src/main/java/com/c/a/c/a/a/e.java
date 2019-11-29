package com.c.a.c.a.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.c.a.c.b.a.b;
import com.c.a.c.f;
import com.c.a.c.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

class e {

    /* renamed from: a  reason: collision with root package name */
    private static final a f5649a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final a f5650b;

    /* renamed from: c  reason: collision with root package name */
    private final d f5651c;

    /* renamed from: d  reason: collision with root package name */
    private final b f5652d;

    /* renamed from: e  reason: collision with root package name */
    private final ContentResolver f5653e;

    /* renamed from: f  reason: collision with root package name */
    private final List<f> f5654f;

    public e(List<f> list, d dVar, b bVar, ContentResolver contentResolver) {
        this(list, f5649a, dVar, bVar, contentResolver);
    }

    public e(List<f> list, a aVar, d dVar, b bVar, ContentResolver contentResolver) {
        this.f5650b = aVar;
        this.f5651c = dVar;
        this.f5652d = bVar;
        this.f5653e = contentResolver;
        this.f5654f = list;
    }

    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            InputStream openInputStream = this.f5653e.openInputStream(uri);
            int b2 = g.b(this.f5654f, openInputStream, this.f5652d);
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (IOException unused) {
                }
            }
            return b2;
        } catch (IOException | NullPointerException e2) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e2);
            }
            if (inputStream == null) {
                return -1;
            }
            try {
                inputStream.close();
                return -1;
            } catch (IOException unused2) {
                return -1;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    public InputStream b(Uri uri) throws FileNotFoundException {
        Cursor a2 = this.f5651c.a(uri);
        if (a2 != null) {
            try {
                if (a2.moveToFirst()) {
                    String string = a2.getString(0);
                    if (TextUtils.isEmpty(string)) {
                        return null;
                    }
                    File a3 = this.f5650b.a(string);
                    Uri fromFile = (!this.f5650b.a(a3) || this.f5650b.b(a3) <= 0) ? null : Uri.fromFile(a3);
                    if (a2 != null) {
                        a2.close();
                    }
                    if (fromFile == null) {
                        return null;
                    }
                    try {
                        return this.f5653e.openInputStream(fromFile);
                    } catch (NullPointerException e2) {
                        throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + fromFile).initCause(e2));
                    }
                }
            } finally {
                if (a2 != null) {
                    a2.close();
                }
            }
        }
        if (a2 != null) {
            a2.close();
        }
        return null;
    }
}
