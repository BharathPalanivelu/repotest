package com.shopee.app.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.garena.android.appkit.f.e;
import com.garena.android.appkit.f.f;
import com.garena.android.appkit.tools.a.b;
import com.shopee.id.R;
import com.squareup.a.af;
import com.squareup.a.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ai {

    /* renamed from: a  reason: collision with root package name */
    private final Context f26141a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f26142b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f26143c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<ImageView> f26144d;

    /* renamed from: e  reason: collision with root package name */
    private List<String> f26145e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public List<Bitmap> f26146f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public List<a> f26147g = new ArrayList();

    static /* synthetic */ int b(ai aiVar) {
        int i = aiVar.f26143c;
        aiVar.f26143c = i + 1;
        return i;
    }

    public static ai a(Context context) {
        return new ai(context);
    }

    private ai(Context context) {
        this.f26141a = context;
    }

    /* access modifiers changed from: private */
    public String a() {
        StringBuilder sb = new StringBuilder();
        for (String append : this.f26145e) {
            sb.append(append);
        }
        return sb.toString();
    }

    public void a(List<String> list, ImageView imageView) {
        if (list == null || list.isEmpty()) {
            imageView.setTag("");
            return;
        }
        if (list.size() > 4) {
            list = list.subList(0, 4);
        }
        this.f26145e = list;
        this.f26142b = this.f26145e.size();
        this.f26143c = 0;
        this.f26146f = new ArrayList();
        imageView.setTag(a());
        this.f26144d = new WeakReference<>(imageView);
        b();
        imageView.setTag(R.id.image, this.f26147g);
    }

    private void b() {
        w a2 = w.a(this.f26141a);
        if (this.f26142b != 1) {
            for (String split : this.f26145e) {
                a aVar = new a();
                this.f26147g.add(aVar);
                a2.a("http://cf.shopee.co.id/file/" + split.split(",")[0]).b(b.a.t, b.a.t).d().a((af) aVar);
            }
            return;
        }
        ImageView imageView = (ImageView) this.f26144d.get();
        if (imageView != null) {
            z.b(this.f26141a).a(this.f26145e.get(0)).a(imageView);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x00db A[LOOP:0: B:13:0x00d9->B:14:0x00db, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap a(android.graphics.Bitmap r13) {
        /*
            r12 = this;
            int r0 = r13.getWidth()
            int r13 = r13.getHeight()
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r0, r13, r1)
            android.graphics.Canvas r2 = new android.graphics.Canvas
            r2.<init>(r1)
            int r3 = r0 / 2
            int r4 = r13 / 2
            int r5 = r0 / 4
            android.graphics.Paint r6 = new android.graphics.Paint
            r6.<init>()
            android.graphics.Rect r7 = new android.graphics.Rect
            r8 = 0
            r7.<init>(r8, r8, r3, r4)
            r7 = 1
            r6.setAntiAlias(r7)
            java.lang.String r9 = "#F3F3F3"
            int r9 = android.graphics.Color.parseColor(r9)
            r2.drawColor(r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.List<android.graphics.Bitmap> r10 = r12.f26146f
            int r10 = r10.size()
            r11 = 0
            if (r10 == r7) goto L_0x00ab
            r13 = 2
            if (r10 == r13) goto L_0x00b5
            r0 = 3
            if (r10 == r0) goto L_0x007d
            r0 = 4
            if (r10 == r0) goto L_0x004a
            goto L_0x00d3
        L_0x004a:
            android.graphics.RectF r0 = new android.graphics.RectF
            int r5 = r3 + -1
            float r5 = (float) r5
            int r7 = r4 + -1
            float r7 = (float) r7
            r0.<init>(r11, r11, r5, r7)
            r9.add(r0)
            android.graphics.RectF r0 = new android.graphics.RectF
            int r10 = r3 + 1
            float r10 = (float) r10
            int r3 = r3 * 2
            float r3 = (float) r3
            r0.<init>(r10, r11, r3, r7)
            r9.add(r0)
            android.graphics.RectF r0 = new android.graphics.RectF
            int r7 = r4 + 1
            float r7 = (float) r7
            int r4 = r4 * 2
            float r13 = (float) r4
            r0.<init>(r11, r7, r5, r13)
            r9.add(r0)
            android.graphics.RectF r0 = new android.graphics.RectF
            r0.<init>(r10, r7, r3, r13)
            r9.add(r0)
            goto L_0x00d3
        L_0x007d:
            android.graphics.RectF r0 = new android.graphics.RectF
            float r7 = (float) r5
            int r5 = r5 + r3
            float r5 = (float) r5
            int r10 = r4 + -1
            float r10 = (float) r10
            r0.<init>(r7, r11, r5, r10)
            r9.add(r0)
            android.graphics.RectF r0 = new android.graphics.RectF
            int r5 = r4 + 1
            float r5 = (float) r5
            int r7 = r3 + -1
            float r7 = (float) r7
            int r4 = r4 * 2
            float r4 = (float) r4
            r0.<init>(r11, r5, r7, r4)
            r9.add(r0)
            android.graphics.RectF r0 = new android.graphics.RectF
            int r7 = r3 + 1
            float r7 = (float) r7
            int r3 = r3 * 2
            float r13 = (float) r3
            r0.<init>(r7, r5, r13, r4)
            r9.add(r0)
            goto L_0x00d3
        L_0x00ab:
            android.graphics.RectF r7 = new android.graphics.RectF
            float r0 = (float) r0
            float r13 = (float) r13
            r7.<init>(r11, r11, r0, r13)
            r9.add(r7)
        L_0x00b5:
            android.graphics.RectF r13 = new android.graphics.RectF
            float r0 = (float) r5
            int r7 = r3 + -1
            float r7 = (float) r7
            int r4 = r4 + r5
            float r4 = (float) r4
            r13.<init>(r11, r0, r7, r4)
            r9.add(r13)
            android.graphics.RectF r13 = new android.graphics.RectF
            int r4 = r3 + 1
            float r4 = (float) r4
            int r7 = r3 * 2
            float r7 = (float) r7
            int r5 = r5 + r3
            float r3 = (float) r5
            r13.<init>(r4, r0, r7, r3)
            r9.add(r13)
        L_0x00d3:
            java.util.List<android.graphics.Bitmap> r13 = r12.f26146f
            int r13 = r13.size()
        L_0x00d9:
            if (r8 >= r13) goto L_0x00f0
            java.util.List<android.graphics.Bitmap> r0 = r12.f26146f
            java.lang.Object r0 = r0.get(r8)
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            r3 = 0
            java.lang.Object r4 = r9.get(r8)
            android.graphics.RectF r4 = (android.graphics.RectF) r4
            r2.drawBitmap(r0, r3, r4, r6)
            int r8 = r8 + 1
            goto L_0x00d9
        L_0x00f0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.util.ai.a(android.graphics.Bitmap):android.graphics.Bitmap");
    }

    private class a implements af {
        public void a(Drawable drawable) {
        }

        public void b(Drawable drawable) {
        }

        private a() {
        }

        public void a(final Bitmap bitmap, w.d dVar) {
            if (((ImageView) ai.this.f26144d.get()) != null) {
                ai.b(ai.this);
                ai.this.f26146f.add(bitmap);
                if (ai.this.f26143c == ai.this.f26142b) {
                    e.a().a(new Runnable() {
                        public void run() {
                            final Bitmap a2 = ai.this.a(bitmap);
                            f.a().a(new Runnable() {
                                public void run() {
                                    ImageView imageView = (ImageView) ai.this.f26144d.get();
                                    if (imageView != null && ((String) imageView.getTag()).equals(ai.this.a())) {
                                        imageView.setImageBitmap(a2);
                                    }
                                }
                            });
                            ai.this.f26146f.clear();
                            ai.this.f26147g.clear();
                        }
                    });
                }
            }
        }
    }
}
