package com.squareup.a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.squareup.a.ab;
import com.squareup.a.w;
import java.io.IOException;
import java.io.InputStream;

class q extends g {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f30577b = {"orientation"};

    q(Context context) {
        super(context);
    }

    public boolean a(z zVar) {
        Uri uri = zVar.f30601d;
        return UriUtil.LOCAL_CONTENT_SCHEME.equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public ab.a a(z zVar, int i) throws IOException {
        Bitmap bitmap;
        z zVar2 = zVar;
        ContentResolver contentResolver = this.f30549a.getContentResolver();
        int a2 = a(contentResolver, zVar2.f30601d);
        String type = contentResolver.getType(zVar2.f30601d);
        boolean z = type != null && type.startsWith("video/");
        if (zVar.d()) {
            a a3 = a(zVar2.h, zVar2.i);
            if (!z && a3 == a.FULL) {
                return new ab.a((Bitmap) null, b(zVar), w.d.DISK, a2);
            }
            long parseId = ContentUris.parseId(zVar2.f30601d);
            BitmapFactory.Options c2 = c(zVar);
            c2.inJustDecodeBounds = true;
            BitmapFactory.Options options = c2;
            a(zVar2.h, zVar2.i, a3.width, a3.height, c2, zVar);
            if (z) {
                bitmap = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, parseId, a3 == a.FULL ? 1 : a3.androidKind, options);
            } else {
                bitmap = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, parseId, a3.androidKind, options);
            }
            if (bitmap != null) {
                return new ab.a(bitmap, (InputStream) null, w.d.DISK, a2);
            }
        }
        return new ab.a((Bitmap) null, b(zVar), w.d.DISK, a2);
    }

    static a a(int i, int i2) {
        if (i <= a.MICRO.width && i2 <= a.MICRO.height) {
            return a.MICRO;
        }
        if (i > a.MINI.width || i2 > a.MINI.height) {
            return a.FULL;
        }
        return a.MINI;
    }

    static int a(ContentResolver contentResolver, Uri uri) {
        Cursor cursor = null;
        try {
            Cursor query = contentResolver.query(uri, f30577b, (String) null, (String[]) null, (String) null);
            if (query != null) {
                if (query.moveToFirst()) {
                    int i = query.getInt(0);
                    if (query != null) {
                        query.close();
                    }
                    return i;
                }
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (RuntimeException unused) {
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    enum a {
        MICRO(3, 96, 96),
        MINI(1, 512, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT),
        FULL(2, -1, -1);
        
        final int androidKind;
        final int height;
        final int width;

        private a(int i, int i2, int i3) {
            this.androidKind = i;
            this.width = i2;
            this.height = i3;
        }
    }
}
