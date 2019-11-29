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

public class d extends c {
    /* access modifiers changed from: private */
    public b.a pendingRequest;

    protected d(b bVar) {
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
                if (signature.toCharsString().equals("3082030d308201f5a003020102020426d581f2300d06092a864886f70d01010b05003037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f6964204465627567301e170d3134303432313133323335325a170d3434303431333133323335325a3037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f696420446562756730820122300d06092a864886f70d01010105000382010f003082010a0282010100965c13493cbc06285e3ae36536bf414f04bb5984797fe45492f3d86b1d6b4b670ad09da48283804deb29d2a95713c2caf3074e5b33f0cd8da8654ba44ea1c05b40cf3b1653dd781c6fac476c370427d2ad435b357f0d4bd77c22d278e07f58e7097d73e62783c1bb552ae47b112b1c3a94992c78340222021fc96f1652fb0ab5b6893a8c418bec7a38a0bbe59aa9c62580f87cf3f44dc3fc6fad2258e9a01380ab0b1b06e3c063e1104540eecde13b9201ae703fb779159ef91990e73b6602cd3927122c05ab4d98ef5c5efc99907a21f4a78dbd4f5c2487afe1a0f1cad3174a49866aa04430d743de19307e8732ef1eca1d4759d09ded5f22bf9ce99f48ed3f0203010001a321301f301d0603551d0e0416041451862913c557a4a248fd5f04ea04949f895c93fb300d06092a864886f70d01010b050003820101002a3324b1bae8b4f3a548a554bcc514995bd20ee105246ad93807e6208cc11759f335ad072dc4d5b0c188de1359251ecf21f8f846c13e3db6ab0e39d0d93f76cf7bbe6e7fe7a1e3c98ff84072b6306f30a1ea81a51d7b3af7470a210b06fa2e6c67a3447547193ba2bec8ba08e90a2aa804678d8e59517f9416e2bf886389f343b323a37045f654557bcc65db461177f9fc0194eb57750e212b13771a98cf21d0a02dd0f5246dd30cc6b5870e9c2dabf3357fd46a8abfdbb7de229b057bea8f2999af76f83957110c2407bb93de1298ce9d9b496a8eb3bdf8add2d836f8f161d63508c49fba86bd97a5f3156aafc605f25ae03681dce6bb9076c9f380b2581bf8")) {
                    return true;
                }
                if (signature.toCharsString().equals("308203733082025ba0030201020204376594c4300d06092a864886f70d01010b0500306a310b3009060355040613025347311230100603550408130953696e6761706f7265311230100603550407130953696e6761706f7265310f300d060355040a1306476172656e613110300e060355040b130742656574616c6b3110300e0603550403130742656574616c6b301e170d3133303431323039313535335a170d3338303430363039313535335a306a310b3009060355040613025347311230100603550408130953696e6761706f7265311230100603550407130953696e6761706f7265310f300d060355040a1306476172656e613110300e060355040b130742656574616c6b3110300e0603550403130742656574616c6b30820122300d06092a864886f70d01010105000382010f003082010a02820101008206045cd5c92e04da6afc6bd63a6ca10e13b460556858fbea86d080b282315546d680587f180a65f72490a8e5ececaf5ff5f52fe29bfca3fee2048d459febd6cf07600dc6ff46314891da13052d44a7106967dcbbc09166233e21f10d0a6d0f0bdd211830149dcdf4a91e71be2b4445deeff68972d3d41df408eac7e812fb5d3011efebab4eae43982ecd78f066cffff8c573d3911b2333d870532290b5d550f3a17e2cbeda2bf75fc4354f2e7af46af856e73ec71ac2349a0d8c4346e56c2e80e33a8189e3919041cc7196ee3f7b612e2200541a05838d986a08105395a9e034110024d08f19b05b0fdfa440d7937a4ec509684dbfa0f1127c06a6ade700490203010001a321301f301d0603551d0e04160414d9b54be49dde5854c4f463eb93d15b5fb6e5bc3c300d06092a864886f70d01010b0500038201010006f4d3b5ca0596e620c410722e29590f252bbe0736b51d2ea8619832b0fbde0900f5bc6c5e5cb0e44588ce5682b97ee2d88670566724cadb8987237af1638f8c4d8704f305af69d34c80a3187b0ca4e0d48dca072039658d257f7c6773f1ecf8bed9a76a213cbd78345181278fe231150fd57b772e5907e1a07e1ed530561abec9cdf37332a5af99cd1cbe78f43740a666fd25abfed14a8a98dc557a1f69d5dd847555c5bdd5df09330d9b07ee23f221a7a5ab6d4885fcd14b8434210f73f2b1e56467fa650ca22dfc6ea1f3329d837be31f0961bec0ef33cd6a0a1aeffb16c1357b75a094a8f7f749a4dbd39252a6fb9de6174ae1ee0bab2bce034ee1c4dc50") && l.f5464b) {
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
        Intent className = new Intent().setClassName(l.f5463a, "com.beetalk.ui.view.proxyauth.BTProxyAuthActivity");
        className.putExtra("gg_request_code", aVar.c());
        className.putExtra("gg_application_id", aVar.e());
        className.putExtra("gg_application_key", aVar.f());
        className.putExtra("gg_app_redirect_url", l.i + this.pendingRequest.e() + "://auth/");
        className.putExtra("gg_auth_id", aVar.b());
        className.putExtra("gg_key_hash", com.beetalk.sdk.e.b.b(a2));
        className.putExtra("gg_sdk_env", l.a().toString());
        PackageManager packageManager = this.client.a().a().getPackageManager();
        if (packageManager == null) {
            resolveInfo = null;
        } else {
            resolveInfo = packageManager.resolveActivity(className, 0);
        }
        if (resolveInfo == null) {
            Toast.makeText(a2, "Install BeeTalk Application first", 0).show();
            return false;
        } else if (!a((Context) a2, l.f5463a)) {
            Toast.makeText(a2, "No valid Beetalk Signature Found", 0).show();
            return false;
        } else if (!a((Context) a2, l.f5463a, l.f5469g)) {
            Toast.makeText(a2, "Please upgrade the beetalk app", 0).show();
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
            case 182:
                cVar = b.c.a(this.pendingRequest, com.garena.pay.android.a.ACCESS_TOKEN_EXCHANGE_FAILED.getCode().intValue());
                break;
            case 183:
                cVar = b.c.a(this.pendingRequest, com.garena.pay.android.a.REFRESH_TOKEN_FAILED.getCode().intValue());
                break;
            case 184:
                cVar = b.c.a(this.pendingRequest, com.garena.pay.android.a.USER_CANCELLED.getCode().intValue());
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
        if (i2 == -1) {
            try {
                String string = intent.getExtras().getString("gg_token_value");
                new a().execute(new String[]{string});
                return true;
            } catch (NullPointerException e2) {
                com.beetalk.sdk.e.a.a((Exception) e2);
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
            com.beetalk.sdk.data.d r6 = com.beetalk.sdk.data.d.BEETALK_NATIVE_ANDROID     // Catch:{ JSONException -> 0x0079 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.beetalk.sdk.d.a(java.lang.String, com.beetalk.sdk.b$a):com.beetalk.sdk.b$c");
    }

    private class a extends AsyncTask<String, Void, b.c> {
        private a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public b.c doInBackground(String... strArr) {
            String str = strArr[0];
            d dVar = d.this;
            return dVar.a(str, dVar.pendingRequest);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(b.c cVar) {
            d.this.a(cVar);
        }
    }
}
