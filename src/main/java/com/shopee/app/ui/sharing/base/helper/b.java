package com.shopee.app.ui.sharing.base.helper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.app.ui.sharing.base.data.ShareImage;
import com.squareup.a.af;
import com.squareup.a.w;
import d.d.b.j;
import d.h.m;
import java.lang.ref.WeakReference;

public final class b extends AsyncTask<ShareImage, Void, ProcessedData> {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Activity> f25353a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<a> f25354b;

    /* renamed from: c  reason: collision with root package name */
    private af f25355c;

    public b(Activity activity, a aVar) {
        j.b(activity, "activity");
        j.b(aVar, "imageProcessListener");
        this.f25353a = new WeakReference<>(activity);
        this.f25354b = new WeakReference<>(aVar);
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        a aVar = (a) this.f25354b.get();
        if (aVar != null) {
            aVar.d();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
        if (r7 != null) goto L_0x005a;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.shopee.app.ui.sharing.base.helper.ProcessedData doInBackground(com.shopee.app.ui.sharing.base.data.ShareImage... r7) {
        /*
            r6 = this;
            java.lang.String r0 = "params"
            d.d.b.j.b(r7, r0)
            r0 = 0
            r7 = r7[r0]
            java.lang.String r1 = ""
            if (r7 == 0) goto L_0x0065
            java.lang.String r2 = r7.getImageUrl()
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4 = 1
            if (r3 == 0) goto L_0x001f
            boolean r5 = d.h.m.a(r3)
            if (r5 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r5 = 0
            goto L_0x0020
        L_0x001f:
            r5 = 1
        L_0x0020:
            if (r5 != 0) goto L_0x003a
            java.util.regex.Pattern r7 = android.util.Patterns.WEB_URL
            java.util.regex.Matcher r7 = r7.matcher(r3)
            boolean r7 = r7.matches()
            if (r7 == 0) goto L_0x0034
            com.shopee.app.ui.sharing.base.helper.ProcessedData r7 = new com.shopee.app.ui.sharing.base.helper.ProcessedData
            r7.<init>(r1, r2)
            return r7
        L_0x0034:
            com.shopee.app.ui.sharing.base.helper.ProcessedData r7 = new com.shopee.app.ui.sharing.base.helper.ProcessedData
            r7.<init>(r2, r1)
            return r7
        L_0x003a:
            java.lang.String r7 = r7.getImageBase64()
            r2 = r7
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0049
            boolean r2 = d.h.m.a(r2)
            if (r2 == 0) goto L_0x004a
        L_0x0049:
            r0 = 1
        L_0x004a:
            if (r0 != 0) goto L_0x0065
            android.net.Uri r7 = com.shopee.app.ui.sharing.base.helper.c.a(r7)
            if (r7 == 0) goto L_0x0059
            java.lang.String r7 = r7.toString()
            if (r7 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r7 = r1
        L_0x005a:
            java.lang.String r0 = "imageUri?.toString() ?: \"\""
            d.d.b.j.a((java.lang.Object) r7, (java.lang.String) r0)
            com.shopee.app.ui.sharing.base.helper.ProcessedData r0 = new com.shopee.app.ui.sharing.base.helper.ProcessedData
            r0.<init>(r7, r1)
            return r0
        L_0x0065:
            com.shopee.app.ui.sharing.base.helper.ProcessedData r7 = new com.shopee.app.ui.sharing.base.helper.ProcessedData
            r7.<init>(r1, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.sharing.base.helper.b.doInBackground(com.shopee.app.ui.sharing.base.data.ShareImage[]):com.shopee.app.ui.sharing.base.helper.ProcessedData");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(ProcessedData processedData) {
        j.b(processedData, AbTestingModule.KEY_RESULT);
        super.onPostExecute(processedData);
        if (m.a(processedData.getFilePath()) && m.a(processedData.getFileUrl())) {
            a aVar = (a) this.f25354b.get();
            if (aVar != null) {
                aVar.e();
            }
        }
        if (!m.a(processedData.getFileUrl())) {
            a(processedData.getFileUrl());
        } else if (!m.a(processedData.getFilePath())) {
            a aVar2 = (a) this.f25354b.get();
            if (aVar2 != null) {
                aVar2.b(processedData.getFilePath());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        super.onCancelled();
        a();
    }

    private final void a() {
        Activity activity = (Activity) this.f25353a.get();
        if (activity != null) {
            af afVar = this.f25355c;
            if (afVar != null) {
                w.a((Context) activity).a(afVar);
            }
        }
    }

    public static final class a implements af {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f25356a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f25357b;

        public void a(Drawable drawable) {
        }

        a(b bVar, String str) {
            this.f25356a = bVar;
            this.f25357b = str;
        }

        public void b(Drawable drawable) {
            a aVar = (a) this.f25356a.f25354b.get();
            if (aVar != null) {
                aVar.e();
            }
        }

        public void a(Bitmap bitmap, w.d dVar) {
            if (bitmap != null) {
                Uri a2 = c.a(this.f25357b, bitmap);
                if (m.a(String.valueOf(c.a(this.f25357b, bitmap)))) {
                    a aVar = (a) this.f25356a.f25354b.get();
                    if (aVar != null) {
                        aVar.e();
                        return;
                    }
                    return;
                }
                a aVar2 = (a) this.f25356a.f25354b.get();
                if (aVar2 != null) {
                    aVar2.b(String.valueOf(a2));
                    return;
                }
                return;
            }
            a aVar3 = (a) this.f25356a.f25354b.get();
            if (aVar3 != null) {
                aVar3.e();
            }
        }
    }

    private final void a(String str) {
        a();
        a aVar = new a(this, str);
        Activity activity = (Activity) this.f25353a.get();
        if (activity != null) {
            w.a((Context) activity).a(str).a((af) aVar);
        }
        this.f25355c = aVar;
    }
}
