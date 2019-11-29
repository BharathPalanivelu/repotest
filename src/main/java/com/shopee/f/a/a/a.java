package com.shopee.f.a.a;

import android.content.Context;
import android.os.Handler;
import com.shopee.f.a.a.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f27150a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Handler f27151b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public b.a f27152c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f27153d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public com.shopee.f.a.a.a.b f27154e = null;

    /* renamed from: f  reason: collision with root package name */
    private String f27155f = "";

    public a(Context context, String str) {
        this.f27155f = str;
        if (context != null) {
            this.f27150a = context;
            this.f27151b = new Handler(this.f27150a.getMainLooper());
        }
    }

    public void a(b.a aVar) {
        this.f27152c = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(com.shopee.f.a.a.b.C0421b r18) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            boolean r0 = r1.f27153d
            java.lang.String r3 = "TXVideoPublish"
            if (r0 == 0) goto L_0x0012
            java.lang.String r0 = "there is existing publish task"
            android.util.Log.e(r3, r0)
            r0 = 1009(0x3f1, float:1.414E-42)
            return r0
        L_0x0012:
            if (r2 != 0) goto L_0x001c
            java.lang.String r0 = "publishVideo invalid param"
            android.util.Log.e(r3, r0)
            r0 = 1010(0x3f2, float:1.415E-42)
            return r0
        L_0x001c:
            java.lang.String r0 = r2.f27267a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x002c
            java.lang.String r0 = "publishVideo invalid UGCSignature"
            android.util.Log.e(r3, r0)
            r0 = 1012(0x3f4, float:1.418E-42)
            return r0
        L_0x002c:
            java.lang.String r0 = r2.f27268b
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x003c
            java.lang.String r0 = "publishVideo invalid videoPath"
            android.util.Log.e(r3, r0)
            r0 = 1013(0x3f5, float:1.42E-42)
            return r0
        L_0x003c:
            r3 = 1
            r4 = 0
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0053 }
            java.lang.String r5 = r2.f27268b     // Catch:{ Exception -> 0x0053 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0053 }
            boolean r5 = r0.isFile()     // Catch:{ Exception -> 0x0053 }
            if (r5 == 0) goto L_0x0057
            boolean r0 = r0.exists()     // Catch:{ Exception -> 0x0053 }
            if (r0 == 0) goto L_0x0057
            r0 = 1
            goto L_0x0058
        L_0x0053:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0057:
            r0 = 0
        L_0x0058:
            if (r0 != 0) goto L_0x005d
            r0 = 1014(0x3f6, float:1.421E-42)
            return r0
        L_0x005d:
            java.lang.String r0 = r2.f27269c
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0075
            java.lang.String r0 = r2.f27269c
            java.io.File r5 = new java.io.File
            r5.<init>(r0)
            boolean r5 = r5.exists()
            if (r5 != 0) goto L_0x0077
            r0 = 1016(0x3f8, float:1.424E-42)
            return r0
        L_0x0075:
            java.lang.String r0 = ""
        L_0x0077:
            r9 = r0
            com.shopee.f.a.a.a.b r0 = r1.f27154e
            if (r0 != 0) goto L_0x0091
            com.shopee.f.a.a.a.b r0 = new com.shopee.f.a.a.a.b
            android.content.Context r11 = r1.f27150a
            java.lang.String r12 = r1.f27155f
            java.lang.String r13 = r2.f27267a
            boolean r14 = r2.f27270d
            boolean r15 = r2.f27271e
            r16 = 10
            r10 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16)
            r1.f27154e = r0
            goto L_0x0096
        L_0x0091:
            java.lang.String r5 = r2.f27267a
            r0.a((java.lang.String) r5)
        L_0x0096:
            com.shopee.f.a.a.a.g r0 = new com.shopee.f.a.a.a.g
            java.lang.String r5 = r2.f27268b
            java.lang.String r6 = r1.a((java.lang.String) r5)
            java.lang.String r7 = r2.f27268b
            java.lang.String r8 = r1.a((java.lang.String) r9)
            java.lang.String r10 = r2.f27272f
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            com.shopee.f.a.a.a.b r2 = r1.f27154e
            com.shopee.f.a.a.a$1 r5 = new com.shopee.f.a.a.a$1
            r5.<init>()
            int r0 = r2.a((com.shopee.f.a.a.a.g) r0, (com.shopee.f.a.a.a.h) r5)
            if (r0 != 0) goto L_0x00ba
            r1.f27153d = r3
            goto L_0x00bc
        L_0x00ba:
            r1.f27153d = r4
        L_0x00bc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.f.a.a.a.a(com.shopee.f.a.a.b$b):int");
    }

    private String a(String str) {
        if (!(str == null || str.length() == 0)) {
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf != -1) {
                return str.substring(lastIndexOf + 1);
            }
        }
        return "";
    }
}
