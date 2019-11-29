package com.beetalk.sdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.Toast;
import com.beetalk.sdk.b;
import com.beetalk.sdk.e.g;
import com.facebook.share.internal.MessengerShareContentUtility;

public class i extends c {
    /* access modifiers changed from: private */
    public b.a pendingRequest;

    protected i(b bVar) {
        super(bVar);
    }

    public static boolean a(Context context, String str, int i) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            if (packageManager.getPackageInfo(str, 0).versionCode >= i || l.f5464b) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    protected static boolean a(Context context, String str) {
        String str2 = Build.BRAND;
        int i = context.getApplicationInfo().flags;
        if (str2.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) && (i & 2) != 0) {
            return true;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            for (Signature signature : packageManager.getPackageInfo(str, 64).signatures) {
                if (signature.toCharsString().equals("3082030b308201f3a00302010202047a0636e6300d06092a864886f70d01010b05003036311e301c060355040b1315476172656e61204f6e6c696e6520507464204c7464311430120603550403130b476172656e6120506c7573301e170d3134303831393130323431345a170d3135303831393130323431345a3036311e301c060355040b1315476172656e61204f6e6c696e6520507464204c7464311430120603550403130b476172656e6120506c757330820122300d06092a864886f70d01010105000382010f003082010a028201010084f9e11b108453d15322f95c388cb9f10deded1953a1b2343835345e2bdd2509f390014167000b4e73f1cf302b4d4d173f37eefa986fe7c235741adac823ec50d98f980d5f80c8f2d9e54e0d9113afbd6530b1272299f8b32966405af143041050bc8ce9010ca59ddab081bdc080f95818f7511a2e0f9d754bcfd9b4b9cd54cb08c41a9e42e27ee73689c35262267765379651e0837bec77fdeb8f69fc4ff71ac140d41f620fe0943e5cb1466fd764d3d6822ef8663ed9521b279ba55ed897c9b067dcd15799fd1e1e6783aeeafe3de47e6e004cebcc41cc7472e2d78d52095bea62f5db81e0653db2c08227248d0abfe2c243d49521b645549e1d9b40d2830d0203010001a321301f301d0603551d0e0416041431118e3818aaad6f0025d4724af957f6d9a82e11300d06092a864886f70d01010b050003820101007689d7b46da6e227ffc6fc29f2d8f78d1b79b8fc265745efb461c985eb160a248ddb54601b203b70817838743061f4d20dc0ec68fdd2e7d2e2f268a4626f643cd91126e6c5956bddaefdf6186c9e89a3d300ea9d55065161969acd92e061c2993d8cac35e6517c49942944d54083ddd4f4503018f88d1f5028725a10f1f188a020ee62d72a523c29dae1f93eb657bfe04855d29f83c8964942958b4fea9a5c82a9a4fe5820df5a606e5b950ee809178d167f3e651c474bc5507efa6d935f02dc37dee116f5ed2657b1b53d3087c0f291e333c6726557e9977d64626b7e49f1de3b8fcf8df1d81c09768658300d5b8f06a81ed56a819fe7a34beafcac50f39f5a")) {
                    return true;
                }
                if (signature.toCharsString().equals("308203b53082029da00302010202041c5ce5b9300d06092a864886f70d01010b050030818a310b3009060355040613023635311230100603550408130953696e6761706f7265311230100603550407130953696e6761706f7265311e301c060355040a1315476172656e61204f6e6c696e6520507465204c7464311d301b060355040b1314536f66747761726520456e67696e656572696e67311430120603550403130b476172656e6120506c7573301e170d3134303831393130333330345a170d3339303831333130333330345a30818a310b3009060355040613023635311230100603550408130953696e6761706f7265311230100603550407130953696e6761706f7265311e301c060355040a1315476172656e61204f6e6c696e6520507465204c7464311d301b060355040b1314536f66747761726520456e67696e656572696e67311430120603550403130b476172656e6120506c757330820122300d06092a864886f70d01010105000382010f003082010a02820101008f7cec7d1529db09e6d8bb56b00ca4d2a9ca0ba1d3d17fe249ebcc39472cf1a5733cd9972f48bfc6e56c47d123d5d451ae15bff099d96ca22d9a3d9775e0d59b74a1b23cc7cc745fd29d5060a74d3a48246a82ddaac587a6cfffe0f264e16241b7a91bebd8db4589776e61b9916e20e0c749e205715930e9c54b5a5b5d7d14f3b27693eba1a3264eb0c0818ae11809b85bbe9e6099e641fb24940b534336fcc519e284e4d944a385732ae1a792025eadd49486a10a01b6d09c52bac1798d0d74c9e1ea07ae3b7ac20e0aee6ba9e23c402ae0cc047a8e11b96a47d4ebd4674d1e3c565bb5ca3ef8af9037df8f9d2e3b34b389cfe1fd4854b331f2735b6a8c01250203010001a321301f301d0603551d0e0416041466f6c0a324150c5c5b770186ba3e0d8efbec0e5f300d06092a864886f70d01010b0500038201010083e3ae177a46cf6a51b8f747f546d91a287db288c57553d36cbef7b7271e024cfba3f5b65b9b2fff74c25304da082bee95740ce61acf9bbbcc3004f976ca801244a1a62bcac998107b80f37c3b5b8361305817fa7ef2ba1c52d443228696bbd5d1220da5d5729dd034a01c2e702226d292e1eb00d3e554217934cb392623c06a15c9f0579f8e234f4ddf66077ee787953dc4a206dcef4799d9017b20df91b3098fa6ed640c51f2c215663f27a8dce98b6cf12d014522ad9be495a645cfffc66dac9bf984342161a4a60e06601622020ed9e49a3d886a408b89ae69e85bb903f0a38eb169ed7177a0848401862e96e6a8b6561d567311af414dc203686ea41ecf") && l.f5464b) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(b.a aVar) {
        ResolveInfo resolveInfo;
        this.pendingRequest = aVar;
        if (aVar == null) {
            return false;
        }
        Activity a2 = this.client.a().a();
        g.a(a2, "Auth Activity");
        String str = "com.garena.gas";
        Intent className = new Intent().setClassName(str, "com.garena.gameauth.GPProxyAuthActivity");
        className.putExtra("gg_request_code", aVar.c());
        className.putExtra("gg_application_id", aVar.e());
        className.putExtra("gg_application_key", aVar.f());
        className.putExtra("gg_app_redirect_url", l.i + this.pendingRequest.e() + "://auth/");
        className.putExtra("gg_auth_id", aVar.b());
        className.putExtra("gg_key_hash", com.beetalk.sdk.e.b.b(a2));
        className.putExtra("gg_sdk_env", l.a().toString());
        PackageManager packageManager = this.client.a().a().getPackageManager();
        ResolveInfo resolveInfo2 = null;
        if (packageManager == null) {
            resolveInfo = null;
        } else {
            resolveInfo = packageManager.resolveActivity(className, 0);
        }
        if (resolveInfo == null) {
            str = "com.garena.gaslite";
            className.setClassName(str, "com.garena.gameauth.GPProxyAuthActivity");
            if (packageManager != null) {
                resolveInfo2 = packageManager.resolveActivity(className, 0);
            }
            if (resolveInfo2 == null) {
                Intent intent = new Intent();
                intent.setClass(this.client.a().a(), h.class);
                intent.putExtra("garena_request_info", aVar);
                this.client.a().a(intent, aVar.c());
                return true;
            }
        }
        if (!a((Context) a2, str)) {
            Toast.makeText(a2, "No valid Gas Signature Found", 0).show();
            return false;
        } else if (!a((Context) a2, str, l.h)) {
            Toast.makeText(a2, "Please upgrade the Gas app", 0).show();
            return false;
        } else {
            try {
                a2.startActivityForResult(className, aVar.c());
                return true;
            } catch (ActivityNotFoundException unused) {
                return false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i, int i2, Intent intent, b.a aVar) {
        b.c cVar;
        if (!this.pendingRequest.b().equals(aVar.b())) {
            a(b.c.a(this.pendingRequest, com.garena.pay.android.a.REQUEST_ID_MISMATCH.getCode().intValue()));
            return true;
        }
        if (i2 != 0) {
            switch (i2) {
                case 178:
                    cVar = b.c.a(this.pendingRequest, com.garena.pay.android.a.NETWORK_EXCEPTION.getCode().intValue());
                    break;
                case 179:
                    cVar = b.c.a(this.pendingRequest, com.garena.pay.android.a.ERROR.getCode().intValue());
                    break;
                case 180:
                    cVar = b.c.a(this.pendingRequest, com.garena.pay.android.a.UNKNOWN_ERROR.getCode().intValue());
                    break;
                default:
                    switch (i2) {
                        case 182:
                            cVar = b.c.a(this.pendingRequest, com.garena.pay.android.a.ACCESS_TOKEN_EXCHANGE_FAILED.getCode().intValue());
                            break;
                        case 183:
                            cVar = b.c.a(this.pendingRequest, com.garena.pay.android.a.REFRESH_TOKEN_FAILED.getCode().intValue());
                            break;
                        case 184:
                            break;
                        case 185:
                            cVar = b.c.a(this.pendingRequest, com.garena.pay.android.a.ERROR_IN_PARAMS.getCode().intValue());
                            break;
                        case 186:
                            cVar = b.c.a(this.pendingRequest, com.garena.pay.android.a.REFRESH_TOKEN_FAILED.getCode().intValue());
                            break;
                        case 187:
                            cVar = b.c.a(this.pendingRequest, com.garena.pay.android.a.UNSUPPORTED_API.getCode().intValue());
                            break;
                        default:
                            cVar = b.c.a(this.pendingRequest, com.garena.pay.android.a.UNKNOWN_ERROR.getCode().intValue());
                            break;
                    }
            }
        }
        cVar = b.c.a(this.pendingRequest, com.garena.pay.android.a.USER_CANCELLED.getCode().intValue());
        if (i2 == -1) {
            if (intent.hasExtra("garena_auth_result")) {
                cVar = (b.c) intent.getSerializableExtra("garena_auth_result");
            } else {
                try {
                    String string = intent.getExtras().getString("gg_token_value");
                    new a().execute(new String[]{string});
                    return true;
                } catch (NullPointerException e2) {
                    com.beetalk.sdk.e.a.a((Exception) e2);
                }
            }
        }
        a(cVar);
        return true;
    }

    /* access modifiers changed from: private */
    public void a(b.c cVar) {
        if (cVar != null) {
            this.client.a(cVar);
        } else {
            this.client.b();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.beetalk.sdk.b.c a(java.lang.String r8, com.beetalk.sdk.b.a r9) {
        /*
            r7 = this;
            java.lang.String r0 = "error"
            java.lang.String r1 = "open_id"
            java.util.HashMap r2 = new java.util.HashMap
            r3 = 3
            r2.<init>(r3)
            java.lang.String r3 = "grant_type"
            java.lang.String r4 = "authorization_code"
            r2.put(r3, r4)
            java.lang.String r3 = "code"
            r2.put(r3, r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r3 = com.beetalk.sdk.l.i
            r8.append(r3)
            java.lang.String r3 = r9.e()
            r8.append(r3)
            java.lang.String r3 = "://auth/"
            r8.append(r3)
            java.lang.String r8 = r8.toString()
            java.lang.String r3 = "redirect_uri"
            r2.put(r3, r8)
            java.lang.Integer r8 = com.beetalk.sdk.g.b()
            java.lang.String r8 = r8.toString()
            java.lang.String r3 = "source"
            r2.put(r3, r8)
            java.lang.String r8 = r9.e()
            java.lang.String r3 = "client_id"
            r2.put(r3, r8)
            java.lang.String r8 = r9.f()
            java.lang.String r3 = "client_secret"
            r2.put(r3, r8)
            com.beetalk.sdk.f.c r8 = com.beetalk.sdk.f.c.a()
            java.lang.String r3 = com.beetalk.sdk.l.d()
            org.json.JSONObject r8 = r8.a(r3, r2)
            com.garena.pay.android.a r2 = com.garena.pay.android.a.UNKNOWN_ERROR
            java.lang.Integer r2 = r2.getCode()
            int r2 = r2.intValue()
            r3 = 0
            if (r8 != 0) goto L_0x007b
            com.garena.pay.android.a r8 = com.garena.pay.android.a.NETWORK_EXCEPTION     // Catch:{ JSONException -> 0x0079 }
            java.lang.Integer r8 = r8.getCode()     // Catch:{ JSONException -> 0x0079 }
            int r8 = r8.intValue()     // Catch:{ JSONException -> 0x0079 }
        L_0x0077:
            r2 = r8
            goto L_0x00d5
        L_0x0079:
            r8 = move-exception
            goto L_0x00d2
        L_0x007b:
            boolean r4 = r8.has(r1)     // Catch:{ JSONException -> 0x0079 }
            if (r4 == 0) goto L_0x00aa
            java.lang.String r0 = r8.getString(r1)     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r1 = "access_token"
            java.lang.String r1 = r8.getString(r1)     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r4 = "refresh_token"
            java.lang.String r4 = r8.getString(r4)     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r5 = "expiry_time"
            int r8 = r8.getInt(r5)     // Catch:{ JSONException -> 0x0079 }
            com.beetalk.sdk.data.a r5 = new com.beetalk.sdk.data.a     // Catch:{ JSONException -> 0x0079 }
            com.beetalk.sdk.data.d r6 = com.beetalk.sdk.data.d.GARENA_NATIVE_ANDROID     // Catch:{ JSONException -> 0x0079 }
            r5.<init>(r1, r6)     // Catch:{ JSONException -> 0x0079 }
            r5.b(r4)     // Catch:{ JSONException -> 0x0079 }
            r5.a((int) r8)     // Catch:{ JSONException -> 0x0079 }
            com.beetalk.sdk.b$c r8 = com.beetalk.sdk.b.c.a(r9, r5, r0)     // Catch:{ JSONException -> 0x0079 }
            r3 = r8
            goto L_0x00d5
        L_0x00aa:
            boolean r1 = r8.has(r0)     // Catch:{ JSONException -> 0x0079 }
            if (r1 == 0) goto L_0x00c7
            java.lang.String r8 = r8.getString(r0)     // Catch:{ JSONException -> 0x0079 }
            java.lang.String r0 = "invalid_grant"
            boolean r8 = r8.equals(r0)     // Catch:{ JSONException -> 0x0079 }
            if (r8 == 0) goto L_0x00c7
            com.garena.pay.android.a r8 = com.garena.pay.android.a.ACCESS_TOKEN_INVALID_GRANT     // Catch:{ JSONException -> 0x0079 }
            java.lang.Integer r8 = r8.getCode()     // Catch:{ JSONException -> 0x0079 }
            int r8 = r8.intValue()     // Catch:{ JSONException -> 0x0079 }
            goto L_0x0077
        L_0x00c7:
            com.garena.pay.android.a r8 = com.garena.pay.android.a.ACCESS_TOKEN_EXCHANGE_FAILED     // Catch:{ JSONException -> 0x0079 }
            java.lang.Integer r8 = r8.getCode()     // Catch:{ JSONException -> 0x0079 }
            int r8 = r8.intValue()     // Catch:{ JSONException -> 0x0079 }
            goto L_0x0077
        L_0x00d2:
            com.beetalk.sdk.e.a.a((java.lang.Exception) r8)
        L_0x00d5:
            if (r3 != 0) goto L_0x00db
            com.beetalk.sdk.b$c r3 = com.beetalk.sdk.b.c.a(r9, r2)
        L_0x00db:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beetalk.sdk.i.a(java.lang.String, com.beetalk.sdk.b$a):com.beetalk.sdk.b$c");
    }

    private class a extends AsyncTask<String, Void, b.c> {
        private a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public b.c doInBackground(String... strArr) {
            String str = strArr[0];
            i iVar = i.this;
            return iVar.a(str, iVar.pendingRequest);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(b.c cVar) {
            i.this.a(cVar);
        }
    }
}
