package com.garena.imageeditor;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.garena.cropimage.library.CropImageView;
import com.garena.cropimage.library.CropTouchImageView;
import com.garena.imageeditor.a.c.n;
import com.garena.imageeditor.a.e;
import com.garena.imageeditor.c;
import com.garena.imageeditor.c.c;
import com.garena.imageeditor.c.d;
import com.garena.imageeditor.view.ImageGLSurfaceView;
import com.garena.imageeditor.view.ImageMaskView;
import com.squareup.a.aa;
import com.squareup.a.ah;
import com.squareup.a.w;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jp.co.cyberagent.android.gpuimage.b;
import jp.co.cyberagent.android.gpuimage.p;

public class ImageEditView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    p f8034a = p.NORMAL;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f8035b;

    /* renamed from: c  reason: collision with root package name */
    private ImageGLSurfaceView f8036c;

    /* renamed from: d  reason: collision with root package name */
    private b f8037d;

    /* renamed from: e  reason: collision with root package name */
    private ImageMaskView f8038e;

    /* renamed from: f  reason: collision with root package name */
    private CropImageView f8039f;

    /* renamed from: g  reason: collision with root package name */
    private com.garena.imageeditor.c.b f8040g;
    private c h;
    private a i;
    private Uri j;
    private Uri k;
    private Uri l;
    private com.garena.imageeditor.c.b m;
    /* access modifiers changed from: private */
    public com.garena.imageeditor.c.a n;
    private a o;
    private float p = 1.0f;
    private com.garena.imageeditor.c.a q = new com.garena.imageeditor.c.a() {
        public void a(Bitmap bitmap) {
            ImageEditView.this.setBitmap(bitmap);
            if (ImageEditView.this.n != null) {
                ImageEditView.this.n.a(bitmap);
            }
        }

        public void c() {
            if (ImageEditView.this.n != null) {
                ImageEditView.this.n.c();
            }
        }
    };
    private com.garena.imageeditor.c.a r = new com.garena.imageeditor.c.a() {
        public void a(Bitmap bitmap) {
            ImageEditView.this.setBitmap(bitmap);
            ImageEditView.this.h();
        }

        public void c() {
            ImageEditView.this.c();
        }
    };
    private com.garena.imageeditor.c.a s;
    private com.garena.imageeditor.c.a t;

    public interface a {
        void a(n nVar);
    }

    public ImageEditView(Context context) {
        super(context);
        a(context);
    }

    public ImageEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ImageEditView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    @TargetApi(21)
    public ImageEditView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context);
    }

    private void a(Context context) {
        inflate(context, c.C0134c.image_edit_layout, this);
        this.f8035b = new b(context);
        this.f8036c = (ImageGLSurfaceView) findViewById(c.b.surfaceView);
        this.f8038e = (ImageMaskView) findViewById(c.b.maskView);
        this.f8039f = (CropImageView) findViewById(c.b.cropView);
        this.f8035b.a((jp.co.cyberagent.android.gpuimage.a) this.f8036c);
        this.f8035b.a(b.C0528b.CENTER_INSIDE);
        this.f8037d = new b(this, this.f8035b);
    }

    public void setBitmap(final Bitmap bitmap) {
        this.f8036c.setRatio(((float) bitmap.getWidth()) / (((float) bitmap.getHeight()) * 1.0f));
        this.f8036c.requestLayout();
        this.f8038e.setRatio(((float) bitmap.getWidth()) / (((float) bitmap.getHeight()) * 1.0f));
        this.p = ((float) bitmap.getWidth()) / (((float) bitmap.getHeight()) * 1.0f);
        this.f8038e.requestLayout();
        this.f8036c.post(new Runnable() {
            public void run() {
                ImageEditView.this.f8035b.e();
                ImageEditView.this.f8035b.a(bitmap);
            }
        });
    }

    public void a() {
        this.f8035b.e();
        this.f8035b.a((Bitmap) null);
    }

    public void b() {
        a aVar = this.i;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        a aVar = this.i;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void c() {
        a aVar = this.i;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void d() {
        this.f8038e.setVisibility(0);
    }

    public void e() {
        this.f8038e.setVisibility(4);
    }

    public void f() {
        a();
        this.f8039f.setVisibility(0);
        this.f8039f.getParams().d(this.f8034a.asInt());
        this.f8039f.getParams().a(this.f8035b.c(), this.f8035b.d());
        this.f8039f.setBitmapLoader(new d(this.l, new com.garena.imageeditor.c.b(1024, 1024) {
            public Bitmap a(Uri uri) {
                try {
                    aa a2 = w.a(ImageEditView.this.getContext()).a(uri).b(b(), c()).e().a((float) ImageEditView.this.f8034a.asInt());
                    int i = AnonymousClass7.f8052a[ImageEditView.this.f8034a.ordinal()];
                    if (i == 1 || i == 2) {
                        if (ImageEditView.this.f8035b.d() || ImageEditView.this.f8035b.c()) {
                            a2.a((ah) new e(ImageEditView.this.f8035b.d(), ImageEditView.this.f8035b.c()));
                        }
                    } else if (ImageEditView.this.f8035b.d() || ImageEditView.this.f8035b.c()) {
                        a2.a((ah) new e(ImageEditView.this.f8035b.c(), ImageEditView.this.f8035b.d()));
                    }
                    return a2.h();
                } catch (IOException unused) {
                    return null;
                }
            }
        }));
    }

    /* renamed from: com.garena.imageeditor.ImageEditView$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8052a = new int[p.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                jp.co.cyberagent.android.gpuimage.p[] r0 = jp.co.cyberagent.android.gpuimage.p.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8052a = r0
                int[] r0 = f8052a     // Catch:{ NoSuchFieldError -> 0x0014 }
                jp.co.cyberagent.android.gpuimage.p r1 = jp.co.cyberagent.android.gpuimage.p.ROTATION_90     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f8052a     // Catch:{ NoSuchFieldError -> 0x001f }
                jp.co.cyberagent.android.gpuimage.p r1 = jp.co.cyberagent.android.gpuimage.p.ROTATION_270     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.garena.imageeditor.ImageEditView.AnonymousClass7.<clinit>():void");
        }
    }

    public void g() {
        this.f8039f.setVisibility(8);
        ((CropTouchImageView) this.f8039f.findViewById(c.b.origin_image)).setImageBitmap((Bitmap) null);
        new com.garena.imageeditor.c.c(this.f8040g, this.r).execute(new Uri[]{this.k});
    }

    public void setCurrentUri(Uri uri) {
        this.k = uri;
    }

    public b getEditor() {
        return this.f8037d;
    }

    public void a(Uri uri, com.garena.imageeditor.c.b bVar) {
        this.j = uri;
        this.k = uri;
        this.l = uri;
        this.f8040g = bVar;
        this.f8039f.getParams().a(a(uri));
        b();
        com.garena.imageeditor.c.c cVar = this.h;
        if (cVar != null) {
            cVar.cancel(false);
        }
        this.h = new com.garena.imageeditor.c.c(this.f8040g, this.q);
        this.h.execute(new Uri[]{uri});
    }

    public void setImageEditListener(a aVar) {
        this.i = aVar;
    }

    public CropImageView getCropView() {
        return this.f8039f;
    }

    public Uri getUri() {
        return this.j;
    }

    private String a(Uri uri) {
        Cursor query = getContext().getContentResolver().query(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return null;
        }
        int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
        query.moveToFirst();
        String string = query.getString(columnIndexOrThrow);
        query.close();
        return string;
    }

    public ImageMaskView getMask() {
        return this.f8038e;
    }

    public void a(p pVar) {
        this.f8034a = pVar;
        int i2 = AnonymousClass7.f8052a[pVar.ordinal()];
        if (i2 == 1 || i2 == 2) {
            this.f8036c.setRatio(1.0f / this.p);
            this.f8036c.requestLayout();
            return;
        }
        this.f8036c.setRatio(this.p);
        this.f8036c.requestLayout();
    }

    public Uri getRotateUri() {
        return this.l;
    }

    public void setThumbnailLoader(com.garena.imageeditor.c.b bVar) {
        this.m = bVar;
    }

    public void a(final ArrayList<jp.co.cyberagent.android.gpuimage.e> arrayList, final b.a<Bitmap> aVar) {
        this.s = new com.garena.imageeditor.c.a() {
            public void c() {
            }

            public void a(Bitmap bitmap) {
                b.a(bitmap, (List<jp.co.cyberagent.android.gpuimage.e>) arrayList, (b.a<Bitmap>) aVar);
                arrayList.clear();
            }
        };
        new com.garena.imageeditor.c.c(this.m, this.s).execute(new Uri[]{this.j});
    }

    public void a(n nVar) {
        a aVar = this.o;
        if (aVar != null) {
            aVar.a(nVar);
        }
    }

    public void setPresetUpdateListener(a aVar) {
        this.o = aVar;
    }

    public void setImageLoadListener(com.garena.imageeditor.c.a aVar) {
        this.n = aVar;
    }

    public void a(final File file, com.garena.imageeditor.c.b bVar, final com.garena.imageeditor.c.a aVar) {
        this.t = new com.garena.imageeditor.c.a() {
            public void a(Bitmap bitmap) {
                new com.garena.imageeditor.c.e(ImageEditView.this.f8035b, file, aVar).execute(new Bitmap[]{bitmap});
            }

            public void c() {
                com.garena.imageeditor.c.a aVar = aVar;
                if (aVar != null) {
                    aVar.c();
                }
            }
        };
        new com.garena.imageeditor.c.c(bVar, this.t).execute(new Uri[]{this.k});
    }
}
