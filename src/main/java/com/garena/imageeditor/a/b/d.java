package com.garena.imageeditor.a.b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import com.appsflyer.share.Constants;
import com.facebook.common.util.UriUtil;
import com.garena.cropimage.library.CropImageView;
import com.garena.imageeditor.ImageEditView;
import com.garena.imageeditor.a.f;
import com.garena.imageeditor.a.g;
import com.garena.imageeditor.b;
import java.io.File;

public class d extends f {

    /* renamed from: g  reason: collision with root package name */
    int f8074g = 0;

    public d(ImageEditView imageEditView, b bVar, com.garena.imageeditor.b.b bVar2) {
        super(imageEditView, bVar, bVar2);
    }

    public void a(g gVar) {
        this.f8066c = gVar;
        this.f8095f.setCurrentUri(Uri.fromFile(new File(this.f8066c.c("cropFile"))));
        this.f8095f.g();
    }

    /* access modifiers changed from: protected */
    public void b(g gVar) {
        this.f8067d = gVar;
        this.f8095f.f();
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.f8066c = this.f8067d;
        this.f8095f.b();
        CropImageView cropView = this.f8095f.getCropView();
        cropView.getParams().a(a(this.f8095f.getContext(), this.f8095f.getRotateUri()));
        cropView.getParams().b(this.f8066c.c("cropFile"));
        cropView.setCropImageCallback(new CropImageView.c() {
            public void a(CropImageView.g gVar) {
                if (gVar == CropImageView.g.SUCCESS) {
                    d.this.f8095f.setCurrentUri(Uri.fromFile(new File(d.this.f8066c.c("cropFile"))));
                    d.this.f8095f.g();
                    return;
                }
                d.this.f8095f.c();
                d.this.f8095f.g();
            }
        });
        cropView.a();
        this.f8074g++;
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f8095f.g();
    }

    public void d() {
        this.f8095f.setCurrentUri(this.f8095f.getRotateUri());
        this.f8095f.g();
        super.d();
    }

    public com.garena.imageeditor.a.d g() {
        return com.garena.imageeditor.a.d.CROP;
    }

    public g h() {
        g gVar = new g();
        gVar.a("cropFile", a("crop1.jpg"));
        return gVar;
    }

    private String a(String str) {
        return Environment.getExternalStorageDirectory() + Constants.URL_PATH_DELIMITER + str;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [java.lang.String, android.database.Cursor] */
    private String a(Context context, Uri uri) {
        Cursor cursor = 0;
        if (uri.getScheme().compareTo(UriUtil.LOCAL_CONTENT_SCHEME) != 0) {
            return uri.getScheme().compareTo(UriUtil.LOCAL_FILE_SCHEME) == 0 ? new File(uri.getPath()).getAbsolutePath() : cursor;
        }
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null);
            int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
            cursor.moveToFirst();
            return cursor.getString(columnIndexOrThrow);
        } finally {
            if (cursor != 0) {
                cursor.close();
            }
        }
    }
}
