package com.shopee.app.ui.image.crop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.FrameLayout;
import com.facebook.common.util.UriUtil;
import com.garena.android.appkit.tools.b;
import com.garena.cropimage.library.CropImageView;
import com.garena.cropimage.library.c;
import com.shopee.app.h.f;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.common.r;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.squareup.a.w;
import java.io.File;

public class d extends FrameLayout implements CropImageView.c {

    /* renamed from: a  reason: collision with root package name */
    CropImageView f22799a;

    /* renamed from: b  reason: collision with root package name */
    bc f22800b;

    /* renamed from: c  reason: collision with root package name */
    c f22801c;

    /* renamed from: d  reason: collision with root package name */
    ak f22802d;

    /* renamed from: e  reason: collision with root package name */
    com.shopee.app.ui.actionbar.a f22803e;

    /* renamed from: f  reason: collision with root package name */
    Activity f22804f;

    /* renamed from: g  reason: collision with root package name */
    r f22805g;
    private final int h;
    private final int i;
    /* access modifiers changed from: private */
    public final String j;
    private String k;
    private final boolean l;
    /* access modifiers changed from: private */
    public a.b m = new a.b("ACTION_BAR_DONE", R.drawable.com_garena_shopee_ic_done) {
        public void a() {
            d.this.f22805g.a();
            d.this.f22799a.a();
        }
    };

    public d(Context context, String str, int i2, int i3, boolean z) {
        super(context);
        setId(R.id.view);
        this.j = str;
        this.h = i2;
        this.i = i3;
        this.l = z;
        ((b) ((x) context).b()).a(this);
        setBackgroundColor(Color.parseColor("#161719"));
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f22800b.a(this.f22801c);
        this.f22801c.a(this);
        this.k = f.a().b("croppedImage.jpg");
        String a2 = a(getContext(), Uri.parse(this.j));
        if (a2 == null || !new File(a2).exists()) {
            new a().execute(new String[]{this.j});
            return;
        }
        setupCrop(a2);
    }

    /* access modifiers changed from: private */
    public void setupCrop(String str) {
        this.f22799a.setImageLoadCallback(new CropImageView.f() {
            public void a(Bitmap bitmap) {
                d.this.f22803e.a(d.this.m);
            }

            public void a() {
                com.shopee.app.h.r.a().b((int) R.string.sp_unable_to_load_image);
            }
        });
        com.garena.cropimage.library.a params = this.f22799a.getParams();
        if (this.l) {
            params.a(str).b(this.k).a(1024, 1024).a(-16777216).c().b(-1).b(this.h, this.i);
        } else {
            params.a(str).b(this.k).a(1024, 1024).b(this.h, this.i);
        }
        this.f22799a.setParams(params);
        this.f22799a.setCropImageCallback(this);
        this.f22799a.setBitmapLoader(new c(w.a(getContext()).a(new File(str)), b.b(), b.b()));
    }

    public void a(CropImageView.g gVar) {
        this.f22805g.b();
        if (gVar == CropImageView.g.SUCCESS) {
            a(Uri.fromFile(new File(this.k)).toString());
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        Intent intent = new Intent();
        intent.putExtra("image", str);
        this.f22804f.setResult(-1, intent);
        this.f22804f.finish();
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

    private class a extends AsyncTask<String, Void, String> {
        private a() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            d.this.f22805g.a();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x006a A[SYNTHETIC, Splitter:B:23:0x006a] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0077 A[SYNTHETIC, Splitter:B:31:0x0077] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r7) {
            /*
                r6 = this;
                r0 = 0
                r7 = r7[r0]
                com.shopee.app.h.f r1 = com.shopee.app.h.f.a()
                java.lang.String r2 = com.shopee.app.g.c.a((java.lang.String) r7)
                java.lang.String r1 = r1.b(r2)
                java.io.File r2 = new java.io.File
                r2.<init>(r1)
                boolean r2 = r2.exists()
                if (r2 == 0) goto L_0x001c
                goto L_0x0085
            L_0x001c:
                r2 = 0
                com.shopee.app.ui.image.crop.d r3 = com.shopee.app.ui.image.crop.d.this     // Catch:{ IOException -> 0x0080 }
                android.content.Context r3 = r3.getContext()     // Catch:{ IOException -> 0x0080 }
                com.squareup.a.w r3 = com.squareup.a.w.a((android.content.Context) r3)     // Catch:{ IOException -> 0x0080 }
                com.squareup.a.aa r7 = r3.a((java.lang.String) r7)     // Catch:{ IOException -> 0x0080 }
                com.squareup.a.r r3 = com.squareup.a.r.NO_CACHE     // Catch:{ IOException -> 0x0080 }
                r4 = 1
                com.squareup.a.r[] r4 = new com.squareup.a.r[r4]     // Catch:{ IOException -> 0x0080 }
                com.squareup.a.r r5 = com.squareup.a.r.NO_STORE     // Catch:{ IOException -> 0x0080 }
                r4[r0] = r5     // Catch:{ IOException -> 0x0080 }
                com.squareup.a.aa r7 = r7.a((com.squareup.a.r) r3, (com.squareup.a.r[]) r4)     // Catch:{ IOException -> 0x0080 }
                android.graphics.Bitmap r7 = r7.h()     // Catch:{ IOException -> 0x0080 }
                com.shopee.app.h.l r0 = com.shopee.app.h.l.a()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                r3 = 100
                byte[] r7 = r0.a((android.graphics.Bitmap) r7, (int) r3)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                r3.<init>(r1)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                r0.<init>(r3)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
                r0.write(r7)     // Catch:{ Exception -> 0x005e }
                r0.close()     // Catch:{ IOException -> 0x0057 }
                goto L_0x0085
            L_0x0057:
                r7 = move-exception
                com.garena.android.appkit.d.a.a(r7)     // Catch:{ IOException -> 0x005c }
                goto L_0x0085
            L_0x005c:
                r7 = move-exception
                goto L_0x0082
            L_0x005e:
                r7 = move-exception
                goto L_0x0065
            L_0x0060:
                r7 = move-exception
                r0 = r2
                goto L_0x0075
            L_0x0063:
                r7 = move-exception
                r0 = r2
            L_0x0065:
                com.garena.android.appkit.d.a.a(r7)     // Catch:{ all -> 0x0074 }
                if (r0 == 0) goto L_0x0072
                r0.close()     // Catch:{ IOException -> 0x006e }
                goto L_0x0072
            L_0x006e:
                r7 = move-exception
                com.garena.android.appkit.d.a.a(r7)     // Catch:{ IOException -> 0x0080 }
            L_0x0072:
                r1 = r2
                goto L_0x0085
            L_0x0074:
                r7 = move-exception
            L_0x0075:
                if (r0 == 0) goto L_0x007f
                r0.close()     // Catch:{ IOException -> 0x007b }
                goto L_0x007f
            L_0x007b:
                r0 = move-exception
                com.garena.android.appkit.d.a.a(r0)     // Catch:{ IOException -> 0x0080 }
            L_0x007f:
                throw r7     // Catch:{ IOException -> 0x0080 }
            L_0x0080:
                r7 = move-exception
                r1 = r2
            L_0x0082:
                com.garena.android.appkit.d.a.a(r7)
            L_0x0085:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.image.crop.d.a.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(String str) {
            d.this.f22805g.b();
            if (str == null) {
                d dVar = d.this;
                dVar.a(dVar.j);
                return;
            }
            d.this.setupCrop(str);
        }
    }
}
