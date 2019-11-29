package com.shopee.app.ui.image.editor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.facebook.common.util.UriUtil;
import com.garena.imageeditor.ImageEditView;
import com.garena.imageeditor.a.c.n;
import com.garena.imageeditor.a.d;
import com.garena.imageeditor.a.g;
import com.garena.imageeditor.a.h;
import com.garena.imageeditor.b.b;
import com.shopee.app.h.f;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.image.editor.AdjustView;
import com.shopee.app.ui.image.editor.b;
import com.shopee.app.ui.image.editor.d.c;
import com.shopee.app.ui.image.editor.h;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.io.File;

public class e extends FrameLayout implements ImageEditView.a, com.garena.imageeditor.a, b.a, com.garena.imageeditor.c.a, b.a<com.shopee.app.ui.image.editor.c.a.b> {

    /* renamed from: a  reason: collision with root package name */
    ImageEditView f22917a;

    /* renamed from: b  reason: collision with root package name */
    b f22918b;

    /* renamed from: c  reason: collision with root package name */
    AdjustView f22919c;

    /* renamed from: d  reason: collision with root package name */
    h f22920d;

    /* renamed from: e  reason: collision with root package name */
    View f22921e;

    /* renamed from: f  reason: collision with root package name */
    ImageButton f22922f;

    /* renamed from: g  reason: collision with root package name */
    ImageButton f22923g;
    ImageButton h;
    ImageButton i;
    TextView j;
    Activity k;
    r l;
    /* access modifiers changed from: private */
    public com.garena.imageeditor.b m;
    /* access modifiers changed from: private */
    public com.shopee.app.ui.image.editor.b.a n;
    /* access modifiers changed from: private */
    public Uri o;
    private int p = 0;

    static /* synthetic */ int c(e eVar) {
        int i2 = eVar.p;
        eVar.p = i2 + 1;
        return i2;
    }

    public e(Context context, String str) {
        super(context);
        this.o = Uri.parse(str);
        ((d) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.h.setEnabled(false);
        String a2 = a(getContext(), this.o);
        if (a2 == null || !new File(a2).exists()) {
            new a().execute(new String[]{this.o.toString()});
            return;
        }
        e();
    }

    public void e() {
        this.h.setEnabled(true);
        this.m = this.f22917a.getEditor();
        this.m.a((b.a) this);
        a(false);
        b(false);
        int min = Math.min(com.garena.android.appkit.tools.b.b(), 1024);
        this.f22917a.a(this.o, (com.garena.imageeditor.c.b) new com.shopee.app.ui.image.editor.d.b(getContext(), min, min));
        this.f22917a.setThumbnailLoader(new c(getContext()));
        this.f22917a.setImageLoadListener(this);
        this.f22917a.setImageEditListener(this);
        this.f22918b.setAdapter(new com.shopee.app.ui.image.editor.a.a());
        this.f22918b.setItemClickListener(this);
        this.n = new com.shopee.app.ui.image.editor.b.a(this.m);
        this.f22917a.setPresetUpdateListener(this);
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

    /* access modifiers changed from: package-private */
    public void f() {
        this.k.onBackPressed();
    }

    /* access modifiers changed from: package-private */
    public void g() {
        final File file = new File(f.a().b("imageEdit.jpg"));
        this.l.a();
        this.f22917a.a(file, new com.shopee.app.ui.image.editor.d.b(getContext(), 1024, 1024), new com.garena.imageeditor.c.a() {
            public void a(Bitmap bitmap) {
                e.this.l.b();
                Intent intent = new Intent();
                intent.putExtra("image", Uri.fromFile(file).toString());
                e.this.k.setResult(-1, intent);
                e.this.k.finish();
            }

            public void c() {
                e.this.l.b();
                com.shopee.app.h.r.a().b((int) R.string.sp_unable_to_load_image);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void h() {
        this.f22917a.getEditor().c();
        this.n = null;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        this.f22917a.getEditor().d();
    }

    public void a(int i2, View view, com.shopee.app.ui.image.editor.c.a.b bVar, ViewGroup viewGroup) {
        a(bVar.f());
        if (bVar.d()) {
            j();
            return;
        }
        com.garena.imageeditor.a.b a2 = this.m.a(bVar.b());
        if (bVar.c()) {
            a(a2);
        } else {
            b(a2);
        }
    }

    private void j() {
        this.f22919c.setVisibility(0);
        this.f22919c.c();
        i subMenu = this.f22919c.getSubMenu();
        subMenu.setAdapter(new com.shopee.app.ui.image.editor.a.b());
        if (this.n == null) {
            this.n = new com.shopee.app.ui.image.editor.b.a(this.m);
        }
        subMenu.setItemClickListener(this.n);
        this.f22919c.setOnOkClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e.this.n.a();
                e.this.k();
            }
        });
        this.f22919c.setOnCancelClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e.this.n.b();
                e.this.k();
            }
        });
    }

    private void a(final com.garena.imageeditor.a.b bVar) {
        final h c2 = bVar.c();
        this.f22919c.setVisibility(0);
        this.f22919c.a();
        this.f22919c.setProgressChangeListener((AdjustView.a) null);
        this.f22919c.setSeekPosition(bVar.i());
        this.f22919c.setProgressChangeListener(new AdjustView.a() {
            public void a(SeekBar seekBar, int i, boolean z) {
                c2.a(bVar.a(i));
            }
        });
        this.f22919c.setOnOkClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                c2.a().a();
                e.this.k();
            }
        });
        this.f22919c.setOnCancelClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                c2.b();
                e.this.k();
            }
        });
    }

    private void b(com.garena.imageeditor.a.b bVar) {
        final h c2 = bVar.c();
        this.f22919c.setVisibility(0);
        this.f22920d.setVisibility(4);
        this.f22919c.b();
        this.f22919c.d();
        if (AnonymousClass2.f22927a[bVar.g().ordinal()] != 1) {
            c2.a(bVar.h());
        } else {
            g gVar = new g();
            f a2 = f.a();
            gVar.a("cropFile", a2.b("crop" + this.p));
            c2.a(gVar);
        }
        this.f22919c.setOnOkClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                c2.a().a();
                e.this.f22920d.setVisibility(0);
                e.this.k();
                e.c(e.this);
            }
        });
        this.f22919c.setOnCancelClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                c2.b();
                e.this.f22920d.setVisibility(0);
                e.this.k();
            }
        });
    }

    /* renamed from: com.shopee.app.ui.image.editor.e$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22927a = new int[d.values().length];

        static {
            try {
                f22927a[d.CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void a(boolean z) {
        Drawable drawable = getResources().getDrawable(R.drawable.ic_filter_back);
        if (drawable != null) {
            if (z) {
                drawable.setAlpha(255);
                this.f22922f.setImageDrawable(drawable);
                this.f22922f.setEnabled(true);
                return;
            }
            drawable.setAlpha(100);
            this.f22922f.setImageDrawable(drawable);
            this.f22922f.setEnabled(false);
        }
    }

    private void b(boolean z) {
        Drawable drawable = getResources().getDrawable(R.drawable.ic_filter_next);
        if (drawable != null) {
            if (z) {
                drawable.setAlpha(255);
                this.f22923g.setImageDrawable(drawable);
                this.f22923g.setEnabled(true);
                return;
            }
            drawable.setAlpha(100);
            this.f22923g.setImageDrawable(drawable);
            this.f22923g.setEnabled(false);
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        this.f22921e.setVisibility(0);
        this.h.setVisibility(0);
        this.i.setVisibility(0);
        this.j.setVisibility(4);
    }

    private void a(String str) {
        this.f22921e.setVisibility(8);
        this.h.setVisibility(8);
        this.i.setVisibility(8);
        this.j.setVisibility(0);
        this.j.setText(str);
    }

    public void a(int i2) {
        b(false);
        a(true);
    }

    public void b(int i2) {
        a(i2 != 0);
        b(true);
    }

    public void c(int i2) {
        b(i2 != 0);
        a(true);
    }

    public void a(Bitmap bitmap) {
        this.f22920d.a(this.f22917a);
        this.f22920d.setItemClickListener(new h.a() {
            public void a(View view, n nVar, ViewGroup viewGroup) {
                g gVar = new g();
                gVar.a("preset", nVar);
                com.garena.imageeditor.a.h c2 = ((com.garena.imageeditor.a.b.f) e.this.m.a(d.PRESET)).c();
                c2.a(gVar);
                c2.a().a();
            }
        });
    }

    public void a() {
        this.l.a();
    }

    public void b() {
        this.l.b();
    }

    public void c() {
        com.shopee.app.h.r.a().b((int) R.string.sp_unable_to_load_image);
    }

    public void a(n nVar) {
        this.f22920d.a(nVar);
    }

    private class a extends AsyncTask<String, Void, String> {
        private a() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            e.this.l.a();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0057, code lost:
            r7 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0059, code lost:
            r7 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            com.garena.android.appkit.d.a.a(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x007d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            com.garena.android.appkit.d.a.a(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0082, code lost:
            r7 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0083, code lost:
            r1 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0084, code lost:
            com.garena.android.appkit.d.a.a(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0088, code lost:
            r7 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0089, code lost:
            r1 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x008a, code lost:
            com.garena.android.appkit.d.a.a(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            return r1;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0057 A[ExcHandler: OutOfMemoryError (e java.lang.OutOfMemoryError), Splitter:B:9:0x0053] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x006c A[SYNTHETIC, Splitter:B:24:0x006c] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0079 A[SYNTHETIC, Splitter:B:32:0x0079] */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0082 A[ExcHandler: OutOfMemoryError (e java.lang.OutOfMemoryError), Splitter:B:3:0x001d] */
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
                goto L_0x008d
            L_0x001c:
                r2 = 0
                com.shopee.app.ui.image.editor.e r3 = com.shopee.app.ui.image.editor.e.this     // Catch:{ IOException -> 0x0088, OutOfMemoryError -> 0x0082 }
                android.content.Context r3 = r3.getContext()     // Catch:{ IOException -> 0x0088, OutOfMemoryError -> 0x0082 }
                com.squareup.a.w r3 = com.squareup.a.w.a((android.content.Context) r3)     // Catch:{ IOException -> 0x0088, OutOfMemoryError -> 0x0082 }
                com.squareup.a.aa r7 = r3.a((java.lang.String) r7)     // Catch:{ IOException -> 0x0088, OutOfMemoryError -> 0x0082 }
                com.squareup.a.r r3 = com.squareup.a.r.NO_CACHE     // Catch:{ IOException -> 0x0088, OutOfMemoryError -> 0x0082 }
                r4 = 1
                com.squareup.a.r[] r4 = new com.squareup.a.r[r4]     // Catch:{ IOException -> 0x0088, OutOfMemoryError -> 0x0082 }
                com.squareup.a.r r5 = com.squareup.a.r.NO_STORE     // Catch:{ IOException -> 0x0088, OutOfMemoryError -> 0x0082 }
                r4[r0] = r5     // Catch:{ IOException -> 0x0088, OutOfMemoryError -> 0x0082 }
                com.squareup.a.aa r7 = r7.a((com.squareup.a.r) r3, (com.squareup.a.r[]) r4)     // Catch:{ IOException -> 0x0088, OutOfMemoryError -> 0x0082 }
                android.graphics.Bitmap r7 = r7.h()     // Catch:{ IOException -> 0x0088, OutOfMemoryError -> 0x0082 }
                com.shopee.app.h.l r0 = com.shopee.app.h.l.a()     // Catch:{ Exception -> 0x0065, all -> 0x0062 }
                r3 = 100
                byte[] r7 = r0.a((android.graphics.Bitmap) r7, (int) r3)     // Catch:{ Exception -> 0x0065, all -> 0x0062 }
                java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0065, all -> 0x0062 }
                java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0065, all -> 0x0062 }
                r3.<init>(r1)     // Catch:{ Exception -> 0x0065, all -> 0x0062 }
                r0.<init>(r3)     // Catch:{ Exception -> 0x0065, all -> 0x0062 }
                r0.write(r7)     // Catch:{ Exception -> 0x0060 }
                r0.close()     // Catch:{ IOException -> 0x0059, OutOfMemoryError -> 0x0057 }
                goto L_0x008d
            L_0x0057:
                r7 = move-exception
                goto L_0x0084
            L_0x0059:
                r7 = move-exception
                com.garena.android.appkit.d.a.a(r7)     // Catch:{ IOException -> 0x005e, OutOfMemoryError -> 0x0057 }
                goto L_0x008d
            L_0x005e:
                r7 = move-exception
                goto L_0x008a
            L_0x0060:
                r7 = move-exception
                goto L_0x0067
            L_0x0062:
                r7 = move-exception
                r0 = r2
                goto L_0x0077
            L_0x0065:
                r7 = move-exception
                r0 = r2
            L_0x0067:
                com.garena.android.appkit.d.a.a(r7)     // Catch:{ all -> 0x0076 }
                if (r0 == 0) goto L_0x0074
                r0.close()     // Catch:{ IOException -> 0x0070, OutOfMemoryError -> 0x0082 }
                goto L_0x0074
            L_0x0070:
                r7 = move-exception
                com.garena.android.appkit.d.a.a(r7)     // Catch:{ IOException -> 0x0088, OutOfMemoryError -> 0x0082 }
            L_0x0074:
                r1 = r2
                goto L_0x008d
            L_0x0076:
                r7 = move-exception
            L_0x0077:
                if (r0 == 0) goto L_0x0081
                r0.close()     // Catch:{ IOException -> 0x007d, OutOfMemoryError -> 0x0082 }
                goto L_0x0081
            L_0x007d:
                r0 = move-exception
                com.garena.android.appkit.d.a.a(r0)     // Catch:{ IOException -> 0x0088, OutOfMemoryError -> 0x0082 }
            L_0x0081:
                throw r7     // Catch:{ IOException -> 0x0088, OutOfMemoryError -> 0x0082 }
            L_0x0082:
                r7 = move-exception
                r1 = r2
            L_0x0084:
                com.garena.android.appkit.d.a.a(r7)
                goto L_0x008d
            L_0x0088:
                r7 = move-exception
                r1 = r2
            L_0x008a:
                com.garena.android.appkit.d.a.a(r7)
            L_0x008d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.image.editor.e.a.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(String str) {
            e.this.l.b();
            if (str == null) {
                e.this.c();
                return;
            }
            Uri unused = e.this.o = Uri.fromFile(new File(str));
            e.this.e();
        }
    }
}
