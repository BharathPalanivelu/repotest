package com.garena.pay.android.c;

import android.os.AsyncTask;
import com.beetalk.sdk.f.c;
import com.beetalk.sdk.l;
import com.google.firebase.perf.network.FirebasePerfHttpClient;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    static C0138a f8166a;

    /* renamed from: b  reason: collision with root package name */
    static Runnable f8167b = new Runnable() {
        public void run() {
            if (a.f8166a != null) {
                a.f8166a.cancel(true);
                if (a.f8166a.f8170a != null) {
                    a.f8166a.f8170a.a();
                }
                a.f8166a = null;
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static Random f8168c = new Random();

    public static void a(C0138a.C0139a aVar, Map<String, String> map) {
        if (f8166a == null) {
            f8166a = new b(aVar, map);
            f8166a.a(C0138a.b.POST);
            e.a().a(f8167b, 10000);
            f8166a.execute(new String[]{l.k()});
        }
    }

    public static void b(C0138a.C0139a aVar, Map<String, String> map) {
        if (f8166a == null) {
            f8166a = new b(aVar, map);
            f8166a.a(C0138a.b.POST);
            e.a().a(f8167b, 10000);
            f8166a.execute(new String[]{l.l()});
        }
    }

    public static void c(C0138a.C0139a aVar, Map<String, String> map) {
        if (f8166a == null) {
            f8166a = new b(aVar, map);
            f8166a.a(C0138a.b.GET);
            e.a().a(f8167b, 10000);
            f8166a.execute(new String[]{l.j()});
        }
    }

    public static class b extends C0138a {
        public b(C0138a.C0139a aVar, Map<String, String> map) {
            super(aVar, map);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            JSONObject jSONObject;
            int i = AnonymousClass2.f8169a[a().ordinal()];
            if (i == 1) {
                jSONObject = c.a().b(strArr[0], b());
            } else if (i != 2) {
                jSONObject = null;
            } else {
                jSONObject = c.a().a(strArr[0], b());
            }
            return jSONObject != null ? jSONObject.toString() : "";
        }
    }

    /* renamed from: com.garena.pay.android.c.a$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8169a = new int[C0138a.b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.garena.pay.android.c.a$a$b[] r0 = com.garena.pay.android.c.a.C0138a.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8169a = r0
                int[] r0 = f8169a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.garena.pay.android.c.a$a$b r1 = com.garena.pay.android.c.a.C0138a.b.GET     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f8169a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.garena.pay.android.c.a$a$b r1 = com.garena.pay.android.c.a.C0138a.b.POST     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.garena.pay.android.c.a.AnonymousClass2.<clinit>():void");
        }
    }

    /* renamed from: com.garena.pay.android.c.a$a  reason: collision with other inner class name */
    public static class C0138a extends AsyncTask<String, String, String> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public C0139a f8170a;

        /* renamed from: b  reason: collision with root package name */
        private b f8171b;

        /* renamed from: c  reason: collision with root package name */
        private Map<String, String> f8172c;

        /* renamed from: com.garena.pay.android.c.a$a$a  reason: collision with other inner class name */
        public interface C0139a {
            void a();

            void a(String str);
        }

        /* renamed from: com.garena.pay.android.c.a$a$b */
        public enum b {
            GET,
            POST
        }

        public C0138a(C0139a aVar, Map<String, String> map) {
            this.f8172c = map;
            this.f8170a = aVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            try {
                HttpResponse execute = FirebasePerfHttpClient.execute(new DefaultHttpClient(), new HttpGet(strArr[0]));
                StatusLine statusLine = execute.getStatusLine();
                if (statusLine.getStatusCode() == 200) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    execute.getEntity().writeTo(byteArrayOutputStream);
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toString();
                }
                execute.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            } catch (IOException e2) {
                com.beetalk.sdk.e.a.a((Exception) e2);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            e.a().a(a.f8167b);
            a.f8166a = null;
            C0139a aVar = this.f8170a;
            if (aVar != null) {
                aVar.a(str);
            }
        }

        public b a() {
            return this.f8171b;
        }

        public void a(b bVar) {
            this.f8171b = bVar;
        }

        public Map<String, String> b() {
            return this.f8172c;
        }
    }
}
