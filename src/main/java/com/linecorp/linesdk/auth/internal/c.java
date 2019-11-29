package com.linecorp.linesdk.auth.internal;

import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.linecorp.linesdk.LineAccessToken;
import com.linecorp.linesdk.LineApiError;
import com.linecorp.linesdk.LineCredential;
import com.linecorp.linesdk.LineProfile;
import com.linecorp.linesdk.a.a.d;
import com.linecorp.linesdk.a.e;
import com.linecorp.linesdk.a.f;
import com.linecorp.linesdk.auth.LineAuthenticationConfig;
import com.linecorp.linesdk.auth.LineLoginResult;
import com.linecorp.linesdk.auth.internal.d;
import java.util.Collections;
import java.util.HashMap;

final class c {

    /* renamed from: a  reason: collision with root package name */
    final LineAuthenticationActivity f15076a;

    /* renamed from: b  reason: collision with root package name */
    final LineAuthenticationConfig f15077b;

    /* renamed from: c  reason: collision with root package name */
    final com.linecorp.linesdk.a.a.b f15078c;

    /* renamed from: d  reason: collision with root package name */
    final d f15079d;

    /* renamed from: e  reason: collision with root package name */
    final a f15080e;

    /* renamed from: f  reason: collision with root package name */
    final com.linecorp.linesdk.a.a f15081f;

    /* renamed from: g  reason: collision with root package name */
    final String[] f15082g;
    final d h;

    c(LineAuthenticationActivity lineAuthenticationActivity, LineAuthenticationConfig lineAuthenticationConfig, d dVar, String[] strArr) {
        this(lineAuthenticationActivity, lineAuthenticationConfig, new com.linecorp.linesdk.a.a.b(lineAuthenticationActivity.getApplicationContext(), lineAuthenticationConfig.b()), new d(lineAuthenticationActivity.getApplicationContext(), lineAuthenticationConfig.b()), new a(dVar), new com.linecorp.linesdk.a.a(lineAuthenticationActivity.getApplicationContext(), lineAuthenticationConfig.a()), dVar, strArr);
    }

    private c(LineAuthenticationActivity lineAuthenticationActivity, LineAuthenticationConfig lineAuthenticationConfig, com.linecorp.linesdk.a.a.b bVar, d dVar, a aVar, com.linecorp.linesdk.a.a aVar2, d dVar2, String[] strArr) {
        this.f15076a = lineAuthenticationActivity;
        this.f15077b = lineAuthenticationConfig;
        this.f15078c = bVar;
        this.f15079d = dVar;
        this.f15080e = aVar;
        this.f15081f = aVar2;
        this.h = dVar2;
        this.f15082g = strArr;
    }

    /* renamed from: com.linecorp.linesdk.auth.internal.c$c  reason: collision with other inner class name */
    private class C0247c extends AsyncTask<Void, Void, com.linecorp.linesdk.a<f>> {
        private C0247c() {
        }

        /* synthetic */ C0247c(c cVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x010c, code lost:
            if (r10.f15073a >= r2.f15073a) goto L_0x010e;
         */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0127 A[Catch:{ ActivityNotFoundException -> 0x01ef }] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x012c A[Catch:{ ActivityNotFoundException -> 0x01ef }] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x013f A[Catch:{ ActivityNotFoundException -> 0x01ef }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onPostExecute(java.lang.Object r14) {
            /*
                r13 = this;
                com.linecorp.linesdk.a r14 = (com.linecorp.linesdk.a) r14
                boolean r0 = r14.a()
                if (r0 != 0) goto L_0x001c
                com.linecorp.linesdk.auth.internal.c r0 = com.linecorp.linesdk.auth.internal.c.this
                com.linecorp.linesdk.auth.internal.d r0 = r0.h
                int r1 = com.linecorp.linesdk.auth.internal.d.a.f15093d
                r0.f15089d = r1
                com.linecorp.linesdk.auth.internal.c r0 = com.linecorp.linesdk.auth.internal.c.this
                com.linecorp.linesdk.auth.internal.LineAuthenticationActivity r0 = r0.f15076a
                com.linecorp.linesdk.auth.LineLoginResult r14 = com.linecorp.linesdk.auth.internal.c.a(r14)
                r0.a((com.linecorp.linesdk.auth.LineLoginResult) r14)
                return
            L_0x001c:
                java.lang.Object r14 = r14.c()
                com.linecorp.linesdk.a.f r14 = (com.linecorp.linesdk.a.f) r14
                com.linecorp.linesdk.auth.internal.c r0 = com.linecorp.linesdk.auth.internal.c.this
                com.linecorp.linesdk.auth.internal.d r0 = r0.h
                r0.f15086a = r14
                com.linecorp.linesdk.auth.internal.c r0 = com.linecorp.linesdk.auth.internal.c.this     // Catch:{ ActivityNotFoundException -> 0x01ef }
                com.linecorp.linesdk.auth.internal.a r0 = r0.f15080e     // Catch:{ ActivityNotFoundException -> 0x01ef }
                com.linecorp.linesdk.auth.internal.c r1 = com.linecorp.linesdk.auth.internal.c.this     // Catch:{ ActivityNotFoundException -> 0x01ef }
                com.linecorp.linesdk.auth.internal.LineAuthenticationActivity r1 = r1.f15076a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                com.linecorp.linesdk.auth.internal.c r2 = com.linecorp.linesdk.auth.internal.c.this     // Catch:{ ActivityNotFoundException -> 0x01ef }
                com.linecorp.linesdk.auth.LineAuthenticationConfig r2 = r2.f15077b     // Catch:{ ActivityNotFoundException -> 0x01ef }
                com.linecorp.linesdk.auth.internal.c r3 = com.linecorp.linesdk.auth.internal.c.this     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.String[] r3 = r3.f15082g     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r4 = 8
                byte[] r5 = new byte[r4]     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.security.SecureRandom r6 = new java.security.SecureRandom     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r6.<init>()     // Catch:{ ActivityNotFoundException -> 0x01ef }
                long r6 = r6.nextLong()     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r8 = 0
                r9 = r6
                r6 = 0
            L_0x0048:
                if (r6 >= r4) goto L_0x0052
                int r7 = (int) r9     // Catch:{ ActivityNotFoundException -> 0x01ef }
                byte r7 = (byte) r7     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r5[r6] = r7     // Catch:{ ActivityNotFoundException -> 0x01ef }
                long r9 = r9 >> r4
                int r6 = r6 + 1
                goto L_0x0048
            L_0x0052:
                r4 = 11
                java.lang.String r4 = android.util.Base64.encodeToString(r5, r4)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                com.linecorp.linesdk.auth.internal.d r0 = r0.f15061b     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r0.f15088c = r4     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.String r5 = "intent://result#Intent;package="
                r0.<init>(r5)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.String r5 = r1.getPackageName()     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r0.append(r5)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.String r5 = ";scheme=lineauth;end"
                r0.append(r5)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.String r0 = r0.toString()     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.net.Uri r5 = r2.c()     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.net.Uri$Builder r5 = r5.buildUpon()     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.String r6 = "response_type"
                java.lang.String r7 = "code"
                android.net.Uri$Builder r5 = r5.appendQueryParameter(r6, r7)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.String r6 = "client_id"
                java.lang.String r7 = r2.a()     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.net.Uri$Builder r5 = r5.appendQueryParameter(r6, r7)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.String r6 = "state"
                android.net.Uri$Builder r4 = r5.appendQueryParameter(r6, r4)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.String r5 = "otpId"
                java.lang.String r14 = r14.f15035a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.net.Uri$Builder r14 = r4.appendQueryParameter(r5, r14)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.String r4 = "redirect_uri"
                android.net.Uri$Builder r14 = r14.appendQueryParameter(r4, r0)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                if (r3 == 0) goto L_0x00b1
                int r4 = r3.length     // Catch:{ ActivityNotFoundException -> 0x01ef }
                if (r4 <= 0) goto L_0x00b1
                java.lang.String r4 = "scope"
                java.lang.String r5 = " "
                java.lang.String r3 = android.text.TextUtils.join(r5, r3)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r14.appendQueryParameter(r4, r3)     // Catch:{ ActivityNotFoundException -> 0x01ef }
            L_0x00b1:
                android.net.Uri r14 = r14.build()     // Catch:{ ActivityNotFoundException -> 0x01ef }
                boolean r2 = r2.d()     // Catch:{ ActivityNotFoundException -> 0x01ef }
                int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r4 = 16
                r5 = 1
                if (r3 < r4) goto L_0x00c2
                r3 = 1
                goto L_0x00c3
            L_0x00c2:
                r3 = 0
            L_0x00c3:
                r6 = 0
                java.lang.String r7 = "android.intent.action.VIEW"
                if (r3 == 0) goto L_0x00e5
                androidx.browser.a.a$a r3 = new androidx.browser.a.a$a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r3.<init>()     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r9 = 17170443(0x106000b, float:2.4611944E-38)
                int r9 = androidx.core.content.b.c(r1, r9)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                androidx.browser.a.a$a r3 = r3.a(r9)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                androidx.browser.a.a r3 = r3.a()     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.content.Intent r9 = r3.f1316a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.content.Intent r9 = r9.setData(r14)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.os.Bundle r3 = r3.f1317b     // Catch:{ ActivityNotFoundException -> 0x01ef }
                goto L_0x00ef
            L_0x00e5:
                android.content.Intent r3 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r3.<init>(r7)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.content.Intent r9 = r3.setData(r14)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r3 = r6
            L_0x00ef:
                com.linecorp.linesdk.auth.internal.b r10 = com.linecorp.linesdk.auth.internal.b.a(r1)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                if (r10 != 0) goto L_0x00fc
                com.linecorp.linesdk.auth.internal.a$a r14 = new com.linecorp.linesdk.auth.internal.a$a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r14.<init>(r9, r3, r8)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                goto L_0x018f
            L_0x00fc:
                if (r2 != 0) goto L_0x0129
                com.linecorp.linesdk.auth.internal.b r2 = com.linecorp.linesdk.auth.internal.a.f15060a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                if (r2 == 0) goto L_0x0124
                int r11 = r10.f15073a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                int r12 = r2.f15073a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                if (r11 == r12) goto L_0x0110
                int r10 = r10.f15073a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                int r2 = r2.f15073a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                if (r10 < r2) goto L_0x0124
            L_0x010e:
                r2 = 1
                goto L_0x0125
            L_0x0110:
                int r11 = r10.f15074b     // Catch:{ ActivityNotFoundException -> 0x01ef }
                int r12 = r2.f15074b     // Catch:{ ActivityNotFoundException -> 0x01ef }
                if (r11 == r12) goto L_0x011d
                int r10 = r10.f15074b     // Catch:{ ActivityNotFoundException -> 0x01ef }
                int r2 = r2.f15074b     // Catch:{ ActivityNotFoundException -> 0x01ef }
                if (r10 < r2) goto L_0x0124
                goto L_0x010e
            L_0x011d:
                int r10 = r10.f15075c     // Catch:{ ActivityNotFoundException -> 0x01ef }
                int r2 = r2.f15075c     // Catch:{ ActivityNotFoundException -> 0x01ef }
                if (r10 < r2) goto L_0x0124
                goto L_0x010e
            L_0x0124:
                r2 = 0
            L_0x0125:
                if (r2 == 0) goto L_0x0129
                r2 = 1
                goto L_0x012a
            L_0x0129:
                r2 = 0
            L_0x012a:
                if (r2 == 0) goto L_0x013f
                android.content.Intent r1 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r1.<init>(r7)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r1.setData(r14)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.String r14 = "jp.naver.line.android"
                r1.setPackage(r14)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                com.linecorp.linesdk.auth.internal.a$a r14 = new com.linecorp.linesdk.auth.internal.a$a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r14.<init>(r1, r3, r5)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                goto L_0x018f
            L_0x013f:
                android.content.Intent r2 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.String r10 = "http://"
                android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r2.<init>(r7, r10)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.util.List r1 = r1.queryIntentActivities(r2, r8)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.os.Bundle r2 = r9.getExtras()     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.util.List r1 = com.linecorp.linesdk.auth.internal.a.a(r14, r1, r2)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                int r2 = r1.size()     // Catch:{ ActivityNotFoundException -> 0x01ef }
                if (r2 == 0) goto L_0x01db
                if (r2 != r5) goto L_0x016e
                com.linecorp.linesdk.auth.internal.a$a r14 = new com.linecorp.linesdk.auth.internal.a$a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.Object r1 = r1.get(r8)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.content.Intent r1 = (android.content.Intent) r1     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r14.<init>(r1, r3, r8)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                goto L_0x018f
            L_0x016e:
                java.lang.Object r14 = r1.remove(r8)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.content.Intent r14 = (android.content.Intent) r14     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.content.Intent r14 = android.content.Intent.createChooser(r14, r6)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.String r2 = "android.intent.extra.INITIAL_INTENTS"
                int r5 = r1.size()     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.os.Parcelable[] r5 = new android.os.Parcelable[r5]     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.Object[] r1 = r1.toArray(r5)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.os.Parcelable[] r1 = (android.os.Parcelable[]) r1     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r14.putExtra(r2, r1)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                com.linecorp.linesdk.auth.internal.a$a r1 = new com.linecorp.linesdk.auth.internal.a$a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r1.<init>(r14, r3, r8)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r14 = r1
            L_0x018f:
                com.linecorp.linesdk.auth.internal.a$b r1 = new com.linecorp.linesdk.auth.internal.a$b     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.content.Intent r2 = r14.f15062a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.os.Bundle r3 = r14.f15063b     // Catch:{ ActivityNotFoundException -> 0x01ef }
                boolean r14 = r14.f15064c     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r1.<init>(r2, r3, r0, r14)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                boolean r14 = r1.f15068d     // Catch:{ ActivityNotFoundException -> 0x01ef }
                if (r14 == 0) goto L_0x01b8
                int r14 = android.os.Build.VERSION.SDK_INT     // Catch:{ ActivityNotFoundException -> 0x01ef }
                if (r14 < r4) goto L_0x01ae
                com.linecorp.linesdk.auth.internal.c r14 = com.linecorp.linesdk.auth.internal.c.this     // Catch:{ ActivityNotFoundException -> 0x01ef }
                com.linecorp.linesdk.auth.internal.LineAuthenticationActivity r14 = r14.f15076a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.content.Intent r0 = r1.f15065a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.os.Bundle r2 = r1.f15066b     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r14.startActivity(r0, r2)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                goto L_0x01d2
            L_0x01ae:
                com.linecorp.linesdk.auth.internal.c r14 = com.linecorp.linesdk.auth.internal.c.this     // Catch:{ ActivityNotFoundException -> 0x01ef }
                com.linecorp.linesdk.auth.internal.LineAuthenticationActivity r14 = r14.f15076a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.content.Intent r0 = r1.f15065a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r14.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                goto L_0x01d2
            L_0x01b8:
                int r14 = android.os.Build.VERSION.SDK_INT     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r0 = 3
                if (r14 < r4) goto L_0x01c9
                com.linecorp.linesdk.auth.internal.c r14 = com.linecorp.linesdk.auth.internal.c.this     // Catch:{ ActivityNotFoundException -> 0x01ef }
                com.linecorp.linesdk.auth.internal.LineAuthenticationActivity r14 = r14.f15076a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.content.Intent r2 = r1.f15065a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.os.Bundle r3 = r1.f15066b     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r14.startActivityForResult(r2, r0, r3)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                goto L_0x01d2
            L_0x01c9:
                com.linecorp.linesdk.auth.internal.c r14 = com.linecorp.linesdk.auth.internal.c.this     // Catch:{ ActivityNotFoundException -> 0x01ef }
                com.linecorp.linesdk.auth.internal.LineAuthenticationActivity r14 = r14.f15076a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                android.content.Intent r2 = r1.f15065a     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r14.startActivityForResult(r2, r0)     // Catch:{ ActivityNotFoundException -> 0x01ef }
            L_0x01d2:
                com.linecorp.linesdk.auth.internal.c r14 = com.linecorp.linesdk.auth.internal.c.this     // Catch:{ ActivityNotFoundException -> 0x01ef }
                com.linecorp.linesdk.auth.internal.d r14 = r14.h     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.String r0 = r1.f15067c     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r14.f15087b = r0     // Catch:{ ActivityNotFoundException -> 0x01ef }
                return
            L_0x01db:
                android.content.ActivityNotFoundException r0 = new android.content.ActivityNotFoundException     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.String r2 = "Activity for LINE log-in is not found. uri="
                r1.<init>(r2)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r1.append(r14)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                java.lang.String r14 = r1.toString()     // Catch:{ ActivityNotFoundException -> 0x01ef }
                r0.<init>(r14)     // Catch:{ ActivityNotFoundException -> 0x01ef }
                throw r0     // Catch:{ ActivityNotFoundException -> 0x01ef }
            L_0x01ef:
                r14 = move-exception
                com.linecorp.linesdk.auth.internal.c r0 = com.linecorp.linesdk.auth.internal.c.this
                com.linecorp.linesdk.auth.internal.d r0 = r0.h
                int r1 = com.linecorp.linesdk.auth.internal.d.a.f15093d
                r0.f15089d = r1
                com.linecorp.linesdk.auth.internal.c r0 = com.linecorp.linesdk.auth.internal.c.this
                com.linecorp.linesdk.auth.internal.LineAuthenticationActivity r0 = r0.f15076a
                com.linecorp.linesdk.auth.LineLoginResult r1 = new com.linecorp.linesdk.auth.LineLoginResult
                com.linecorp.linesdk.b r2 = com.linecorp.linesdk.b.INTERNAL_ERROR
                com.linecorp.linesdk.LineApiError r3 = new com.linecorp.linesdk.LineApiError
                r3.<init>((java.lang.Exception) r14)
                r1.<init>((com.linecorp.linesdk.b) r2, (com.linecorp.linesdk.LineApiError) r3)
                r0.a((com.linecorp.linesdk.auth.LineLoginResult) r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.linecorp.linesdk.auth.internal.c.C0247c.onPostExecute(java.lang.Object):void");
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            com.linecorp.linesdk.a.a.b bVar = c.this.f15078c;
            String a2 = c.this.f15077b.a();
            Uri build = bVar.f15017f.buildUpon().appendPath("oauth").appendPath("otp").build();
            HashMap hashMap = new HashMap(1);
            hashMap.put("client_id", a2);
            return bVar.f15018g.a(build, Collections.emptyMap(), hashMap, com.linecorp.linesdk.a.a.b.f15012a);
        }
    }

    private class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(c cVar, byte b2) {
            this();
        }

        public final void run() {
            if (c.this.h.f15089d != d.a.f15092c && !c.this.f15076a.isFinishing()) {
                c.this.f15076a.a(LineLoginResult.f15052a);
            }
        }
    }

    private class a extends AsyncTask<String, Void, LineLoginResult> {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            String[] strArr = (String[]) objArr;
            String str = (strArr == null || strArr.length != 1) ? null : strArr[0];
            f fVar = c.this.h.f15086a;
            String str2 = c.this.h.f15087b;
            if (TextUtils.isEmpty(str) || fVar == null || TextUtils.isEmpty(str2)) {
                return new LineLoginResult(com.linecorp.linesdk.b.INTERNAL_ERROR, new LineApiError("Requested data is missing."));
            }
            com.linecorp.linesdk.a.a.b bVar = c.this.f15078c;
            String a2 = c.this.f15077b.a();
            Uri build = bVar.f15017f.buildUpon().appendPath("oauth").appendPath("accessToken").build();
            HashMap hashMap = new HashMap(5);
            hashMap.put("grant_type", "authorization_code");
            hashMap.put("code", str);
            hashMap.put(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, str2);
            hashMap.put("client_id", a2);
            hashMap.put("otp", fVar.f15036b);
            com.linecorp.linesdk.a<e> a3 = bVar.f15018g.a(build, Collections.emptyMap(), hashMap, com.linecorp.linesdk.a.a.b.f15013b);
            if (!a3.a()) {
                return c.a(a3);
            }
            e c2 = a3.c();
            com.linecorp.linesdk.a.d dVar = c2.f15033a;
            com.linecorp.linesdk.a<LineProfile> a4 = c.this.f15079d.a(dVar);
            if (!a4.a()) {
                return c.a(a4);
            }
            c.this.f15081f.a(dVar);
            return new LineLoginResult(a4.c(), new LineCredential(new LineAccessToken(dVar.f15029a, dVar.f15030b, dVar.f15031c), c2.f15034b));
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            c.this.h.f15089d = d.a.f15093d;
            c.this.f15076a.a((LineLoginResult) obj);
        }
    }

    static /* synthetic */ LineLoginResult a(com.linecorp.linesdk.a aVar) {
        return new LineLoginResult(aVar.b(), aVar.d());
    }
}
