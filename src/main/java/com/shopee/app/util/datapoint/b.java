package com.shopee.app.util.datapoint;

import android.content.Intent;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.google.android.exoplayer2.s.v;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.aa;
import d.d.b.j;
import d.d.b.k;
import d.m;
import d.p;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26325a = new a((g) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static C0401b f26326c = new C0401b((String) null, (String) null, (String) null, (String) null, 15, (g) null);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final Object f26327d = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final aa f26328b;

    static final class d extends k implements d.d.a.c<C0401b, C0401b, p> {
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar) {
            super(2);
            this.this$0 = bVar;
        }

        public /* bridge */ /* synthetic */ Object a(Object obj, Object obj2) {
            a((C0401b) obj, (C0401b) obj2);
            return p.f32714a;
        }

        public final void a(C0401b bVar, C0401b bVar2) {
            j.b(bVar, "resultData");
            j.b(bVar2, "original");
            synchronized (b.f26325a.b()) {
                if (j.a((Object) bVar2, (Object) b.f26325a.a())) {
                    b.f26325a.a(bVar);
                    aa a2 = this.this$0.f26328b;
                    j.a((Object) a2, "deviceStore");
                    a2.d(bVar.a());
                    aa a3 = this.this$0.f26328b;
                    j.a((Object) a3, "deviceStore");
                    a3.c(bVar.c());
                    aa a4 = this.this$0.f26328b;
                    j.a((Object) a4, "deviceStore");
                    a4.f(bVar.b());
                    aa a5 = this.this$0.f26328b;
                    j.a((Object) a5, "deviceStore");
                    a5.e(bVar.d());
                }
                p pVar = p.f32714a;
            }
        }
    }

    public b() {
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        this.f26328b = f2.e().deviceStore();
        a();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final C0401b a() {
            return b.f26326c;
        }

        public final void a(C0401b bVar) {
            j.b(bVar, "<set-?>");
            b.f26326c = bVar;
        }

        public final Object b() {
            return b.f26327d;
        }
    }

    public final void a() {
        aa aaVar = this.f26328b;
        j.a((Object) aaVar, "deviceStore");
        String q = aaVar.q();
        j.a((Object) q, "deviceStore.freefireFingerprintEncrypted");
        aa aaVar2 = this.f26328b;
        j.a((Object) aaVar2, "deviceStore");
        String s = aaVar2.s();
        j.a((Object) s, "deviceStore.freefireFingerprintRaw");
        aa aaVar3 = this.f26328b;
        j.a((Object) aaVar3, "deviceStore");
        String p = aaVar3.p();
        j.a((Object) p, "deviceStore.freefireOpenIdEncrypted");
        aa aaVar4 = this.f26328b;
        j.a((Object) aaVar4, "deviceStore");
        String r = aaVar4.r();
        j.a((Object) r, "deviceStore.freefireOpenIdRaw");
        f26326c = new C0401b(q, s, p, r);
    }

    public final void a(Intent intent) {
        String str;
        j.b(intent, "intent");
        String stringExtra = intent.getStringExtra("device_fingerprint");
        String str2 = stringExtra != null ? stringExtra : "";
        String stringExtra2 = intent.getStringExtra("gop_id");
        if (stringExtra2 != null) {
            str = stringExtra2;
        } else {
            str = "";
        }
        C0401b bVar = new C0401b(str2, (String) null, str, (String) null, 10, (g) null);
        if (!j.a((Object) bVar, (Object) f26326c)) {
            f26326c = bVar;
            a(bVar, (d.d.a.c<? super C0401b, ? super C0401b, p>) new d(this));
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f26338a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C0401b f26339b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d.d.a.c f26340c;

        c(b bVar, C0401b bVar2, d.d.a.c cVar) {
            this.f26338a = bVar;
            this.f26339b = bVar2;
            this.f26340c = cVar;
        }

        public final void run() {
            this.f26340c.a(new C0401b(this.f26339b.a(), this.f26338a.a(this.f26339b.a(), "FreeFireDeviceIdentifier"), this.f26339b.c(), this.f26338a.a(this.f26339b.c(), "GarenaOpenID")), this.f26339b);
        }
    }

    private final void a(C0401b bVar, d.d.a.c<? super C0401b, ? super C0401b, p> cVar) {
        org.a.a.a.a((Runnable) new c(this, bVar, cVar));
    }

    /* access modifiers changed from: private */
    public final String a(String str, String str2) {
        try {
            SecretKeyFactory instance = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            char[] charArray = "FreeFire_Shopee_20190813".toCharArray();
            j.a((Object) charArray, "(this as java.lang.String).toCharArray()");
            Charset charset = d.h.d.f32688a;
            if (str2 != null) {
                byte[] bytes = str2.getBytes(charset);
                j.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                SecretKey generateSecret = instance.generateSecret(new PBEKeySpec(charArray, bytes, 1000, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT));
                byte[] bArr = new byte[32];
                byte[] bArr2 = new byte[16];
                j.a((Object) generateSecret, "secretKey");
                System.arraycopy(generateSecret.getEncoded(), 0, bArr, 0, 32);
                System.arraycopy(generateSecret.getEncoded(), 32, bArr2, 0, 16);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
                Cipher instance2 = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                instance2.init(2, secretKeySpec, ivParameterSpec);
                byte[] doFinal = instance2.doFinal(v.h(str));
                j.a((Object) doFinal, "decryptResult");
                return new String(doFinal, d.h.d.f32688a);
            }
            throw new m("null cannot be cast to non-null type java.lang.String");
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public final String b() {
        return f26326c.b();
    }

    public final String c() {
        return f26326c.d();
    }

    /* renamed from: com.shopee.app.util.datapoint.b$b  reason: collision with other inner class name */
    public static final class C0401b {

        /* renamed from: a  reason: collision with root package name */
        private final String f26334a;

        /* renamed from: b  reason: collision with root package name */
        private final String f26335b;

        /* renamed from: c  reason: collision with root package name */
        private final String f26336c;

        /* renamed from: d  reason: collision with root package name */
        private final String f26337d;

        public C0401b() {
            this((String) null, (String) null, (String) null, (String) null, 15, (g) null);
        }

        public C0401b(String str, String str2, String str3, String str4) {
            j.b(str, "fingerprint");
            j.b(str2, "fingerprintRaw");
            j.b(str3, "openId");
            j.b(str4, "openIdRaw");
            this.f26334a = str;
            this.f26335b = str2;
            this.f26336c = str3;
            this.f26337d = str4;
        }

        public final String a() {
            return this.f26334a;
        }

        public final String b() {
            return this.f26335b;
        }

        public final String c() {
            return this.f26336c;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C0401b(String str, String str2, String str3, String str4, int i, g gVar) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
        }

        public final String d() {
            return this.f26337d;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0401b) {
                C0401b bVar = (C0401b) obj;
                return j.a((Object) bVar.f26334a, (Object) this.f26334a) && j.a((Object) bVar.f26336c, (Object) this.f26336c);
            }
        }

        public int hashCode() {
            return (this.f26334a + this.f26335b + this.f26336c + this.f26337d).hashCode();
        }
    }
}
