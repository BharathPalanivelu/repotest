package com.shopee.app.react.util.image;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.react.protocol.ImageData;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.a.j;
import com.shopee.app.ui.a.k;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.photo.PhotoProxyActivity_;
import com.shopee.app.util.af;
import com.shopee.app.util.x;
import java.util.ArrayList;
import java.util.List;

public class a extends b implements x<k> {

    /* renamed from: a  reason: collision with root package name */
    int f19017a = 800;

    /* renamed from: b  reason: collision with root package name */
    int f19018b = 800;

    /* renamed from: c  reason: collision with root package name */
    int f19019c = 80;

    /* renamed from: d  reason: collision with root package name */
    r f19020d;

    /* renamed from: e  reason: collision with root package name */
    private k f19021e;

    /* access modifiers changed from: protected */
    public void s() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v().setVisibility(8);
        if (bundle == null) {
            Intent intent = new Intent(this, PhotoProxyActivity_.class);
            intent.putExtras(getIntent());
            startActivityForResult(intent, 77);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) new RelativeLayout(this));
    }

    /* access modifiers changed from: package-private */
    public void a(int i, Intent intent) {
        if (i == -1) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("add_product_image_uri_list");
            new C0288a().execute(stringArrayListExtra.toArray(new String[stringArrayListExtra.size()]));
            return;
        }
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f19021e = j.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f19021e.a(this);
    }

    /* renamed from: a */
    public k b() {
        return this.f19021e;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    /* renamed from: com.shopee.app.react.util.image.a$a  reason: collision with other inner class name */
    private class C0288a extends AsyncTask<String, Void, List<ImageData>> {
        private C0288a() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            a.this.f19020d.a();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x009e A[SYNTHETIC, Splitter:B:23:0x009e] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00a9 A[SYNTHETIC, Splitter:B:28:0x00a9] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00b2 A[SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.List<com.shopee.app.react.protocol.ImageData> doInBackground(java.lang.String... r11) {
            /*
                r10 = this;
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                int r1 = r11.length
                r2 = 0
                r3 = 0
            L_0x0008:
                if (r3 >= r1) goto L_0x00b6
                r4 = r11[r3]
                android.net.Uri r4 = android.net.Uri.parse(r4)
                com.shopee.app.h.f r5 = com.shopee.app.h.f.a()
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = r4.getPath()
                r7.append(r8)
                long r8 = com.garena.android.appkit.tools.a.a.b()
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                java.lang.String r7 = com.shopee.app.util.bd.a((java.lang.String) r7)
                r6.append(r7)
                java.lang.String r7 = ".jpg"
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                java.lang.String r5 = r5.b(r6)
                com.shopee.app.h.l r6 = com.shopee.app.h.l.a()
                android.graphics.Rect r6 = r6.a((android.net.Uri) r4)
                if (r6 != 0) goto L_0x0053
                android.graphics.Rect r6 = new android.graphics.Rect
                r6.<init>(r2, r2, r2, r2)
            L_0x0053:
                com.shopee.app.h.l r7 = com.shopee.app.h.l.a()
                com.shopee.app.react.util.image.a r8 = com.shopee.app.react.util.image.a.this
                int r8 = r8.f19017a
                com.shopee.app.react.util.image.a r9 = com.shopee.app.react.util.image.a.this
                int r9 = r9.f19018b
                android.graphics.Bitmap r4 = r7.a((android.net.Uri) r4, (int) r8, (int) r9)
                if (r4 == 0) goto L_0x00b2
                r7 = 0
                java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0098 }
                java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x0098 }
                r9.<init>(r5)     // Catch:{ Exception -> 0x0098 }
                r8.<init>(r9)     // Catch:{ Exception -> 0x0098 }
                android.graphics.Bitmap$CompressFormat r7 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
                com.shopee.app.react.util.image.a r9 = com.shopee.app.react.util.image.a.this     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
                int r9 = r9.f19019c     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
                r4.compress(r7, r9, r8)     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
                com.shopee.app.react.protocol.ImageData r7 = new com.shopee.app.react.protocol.ImageData     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
                int r9 = r6.width()     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
                int r6 = r6.height()     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
                r7.<init>(r5, r9, r6)     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
                r0.add(r7)     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
                r4.recycle()     // Catch:{ Exception -> 0x0092, all -> 0x0090 }
                r8.close()     // Catch:{ IOException -> 0x00a2 }
                goto L_0x00b2
            L_0x0090:
                r11 = move-exception
                goto L_0x00a7
            L_0x0092:
                r4 = move-exception
                r7 = r8
                goto L_0x0099
            L_0x0095:
                r11 = move-exception
                r8 = r7
                goto L_0x00a7
            L_0x0098:
                r4 = move-exception
            L_0x0099:
                r4.printStackTrace()     // Catch:{ all -> 0x0095 }
                if (r7 == 0) goto L_0x00b2
                r7.close()     // Catch:{ IOException -> 0x00a2 }
                goto L_0x00b2
            L_0x00a2:
                r4 = move-exception
                r4.printStackTrace()
                goto L_0x00b2
            L_0x00a7:
                if (r8 == 0) goto L_0x00b1
                r8.close()     // Catch:{ IOException -> 0x00ad }
                goto L_0x00b1
            L_0x00ad:
                r0 = move-exception
                r0.printStackTrace()
            L_0x00b1:
                throw r11
            L_0x00b2:
                int r3 = r3 + 1
                goto L_0x0008
            L_0x00b6:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.react.util.image.a.C0288a.doInBackground(java.lang.String[]):java.util.List");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(List<ImageData> list) {
            a.this.f19020d.b();
            Intent intent = new Intent();
            intent.putStringArrayListExtra("add_product_image_uri_list", new ArrayList(af.a(list, new af.b<String, ImageData>() {
                /* renamed from: a */
                public String map(ImageData imageData) {
                    return imageData.uri;
                }
            })));
            intent.putParcelableArrayListExtra("IMAGE_DIMENSION_DATA", new ArrayList(list));
            a.this.setResult(-1, intent);
            a.this.finish();
        }
    }
}
