package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class c extends b {
    /* access modifiers changed from: private */
    public static final String i = "c";
    /* access modifiers changed from: private */
    public Context j = null;
    /* access modifiers changed from: private */
    public boolean k = false;
    private boolean l = false;
    /* access modifiers changed from: private */
    public m m = null;
    /* access modifiers changed from: private */
    public l n = null;
    private CountDownLatch o = null;
    private int p = 0;

    c() {
    }

    static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        c f32564b = null;

        /* renamed from: c  reason: collision with root package name */
        CountDownLatch f32565c = null;

        public a(c cVar, CountDownLatch countDownLatch) {
            this.f32564b = cVar;
            this.f32565c = countDownLatch;
        }

        public void run() {
            throw new NoSuchMethodError();
        }
    }

    public String d() {
        if (this.f32557c == null) {
            l lVar = this.n;
            if (lVar == null || this.l) {
                this.f32559e = l.c();
            } else {
                this.f32559e = lVar.a(this.j);
            }
        }
        return this.f32559e;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.n != null && !this.l;
    }

    private static HashMap<String, String> a(ArrayList<HashMap<String, String>> arrayList, String str) {
        Iterator<HashMap<String, String>> it = arrayList.iterator();
        while (it.hasNext()) {
            HashMap<String, String> next = it.next();
            String str2 = next.get("name");
            if (str2 != null && str2.toLowerCase(Locale.US).contains(str.toLowerCase(Locale.US))) {
                return next;
            }
        }
        return null;
    }

    private static String a(String str, String str2, ArrayList<HashMap<String, String>> arrayList) {
        String str3;
        HashMap<String, String> a2 = a(arrayList, str);
        if (a2 != null) {
            str3 = a2.get("name").replace("[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXY -]", "");
            if (!str3.isEmpty()) {
                str3 = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            }
        } else {
            str3 = "false";
        }
        return str2 + "^" + str3 + "!";
    }

    /* access modifiers changed from: package-private */
    public boolean a(Context context, boolean z, int i2) {
        this.j = context;
        this.k = z;
        this.p = i2;
        if (!this.k) {
            return false;
        }
        String str = i;
        StringBuilder sb = new StringBuilder();
        sb.append("initJSExecutor: jsProblem = ");
        sb.append(this.l);
        sb.append(", jsExec = ");
        sb.append(this.n);
        sb.append(", hasBadOptions = ");
        l lVar = this.n;
        sb.append(lVar != null ? Boolean.valueOf(lVar.a(z)) : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        Log.d(str, sb.toString());
        if (this.l || this.n != null) {
            l lVar2 = this.n;
            if (lVar2 == null || !lVar2.a(this.k)) {
                Log.d(i, "reused JS Interface");
                return true;
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Handler handler = new Handler(Looper.getMainLooper());
        this.m = new m(l.b() || l.a() ? countDownLatch : null);
        String str2 = i;
        Log.d(str2, "Firing off initJSExecutor on UI thread using latch: " + countDownLatch.hashCode() + " with count: " + countDownLatch.getCount());
        handler.post(new a(this, countDownLatch) {
            public void run() {
                Log.d(c.i, "Calling initJSExecutor() - on UI thread");
                l unused = this.f32564b.n = new l(c.this.j, c.this.m, c.this.k);
                try {
                    this.f32564b.n.d();
                } catch (InterruptedException unused2) {
                    Log.e(c.i, "Interrupted initing js engine");
                }
                Log.d(c.i, "js exec init complete");
                if (this.f32565c != null) {
                    String k = c.i;
                    Log.d(k, "js exec init countdown using latch: " + this.f32565c.hashCode() + " with count: " + this.f32565c.getCount());
                    this.f32565c.countDown();
                }
            }
        });
        try {
            if (!countDownLatch.await(10, TimeUnit.SECONDS)) {
                this.l = true;
                String str3 = i;
                Log.e(str3, "initJSExecutor no response from UI thread before timeout using init latch: " + countDownLatch.hashCode() + " with count: " + countDownLatch.getCount());
                return false;
            }
            return true;
        } catch (InterruptedException unused) {
            Log.e(i, "Interrupted initing js engine");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (this.o != null) {
            try {
                String str = i;
                Log.d(str, "waiting for getBrowserInfo to finished, latch: " + this.o.getCount() + " - " + this.o.hashCode());
                if (!this.o.await(10, TimeUnit.SECONDS)) {
                    String str2 = i;
                    Log.e(str2, "getBrowserInfo no response from UI thread before timeout using latch: " + this.o.hashCode() + " with count: " + this.o.getCount());
                    this.l = true;
                } else if (l.b() || l.a()) {
                    m();
                }
            } catch (InterruptedException e2) {
                Log.e(i, "getBrowserInfo interrupted", e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return g() && this.k;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        int i2 = 1;
        boolean z = l.b() || l.a();
        if (z) {
            if ((this.p & 32) != 0) {
                i2 = 2;
            }
            if ((this.p & 4) != 0) {
                i2 += 2;
            }
        }
        this.o = new CountDownLatch(i2);
        Handler handler = new Handler(Looper.getMainLooper());
        String str = i;
        Log.d(str, "Firing off getBrowserInfo on UI thread using latch: " + this.o.hashCode() + " with count: " + i2);
        this.m.a(z ? this.o : null);
        handler.post(new a(this, this.o) {
            public void run() {
                try {
                    Log.d(c.i, "Calling getBrowserInfo() - on UI thread");
                    this.f32564b.l();
                } catch (InterruptedException e2) {
                    Log.d(c.i, "getBrowserInfo interrupted", e2);
                }
                if (this.f32565c != null) {
                    String k = c.i;
                    Log.d(k, "getBrowserInfo countdown using latch: " + this.f32565c.hashCode() + " with count: " + this.f32565c.getCount());
                    this.f32565c.countDown();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void l() throws InterruptedException {
        if (!Thread.currentThread().isInterrupted()) {
            if ((this.p & 32) != 0) {
                String a2 = this.n.a("(function () { var plugins_string='', i=0; for (p=navigator.plugins[0]; i< navigator.plugins.length;p=navigator.plugins[i++]) {  plugins_string += p.name + '<FIELD_SEP>' + p.description + '<FIELD_SEP>' + p.filename + '<FIELD_SEP>' + p.length.toString() + '<REC_SEP>'; } return plugins_string;})();");
                if (a2 != null) {
                    a(a2);
                }
            }
            if (!Thread.currentThread().isInterrupted() && (this.p & 4) != 0) {
                String a3 = this.n.a("navigator.mimeTypes.length");
                if (a3 != null) {
                    try {
                        this.f32560f = Integer.parseInt(a3);
                    } catch (NumberFormatException e2) {
                        Log.e(i, "failed to convert", e2);
                    }
                }
                this.f32561g = this.n.a("(function () { var mime_string='', i=0; for (var m=navigator.mimeTypes[0]; i< navigator.mimeTypes.length;m=navigator.mimeTypes[i++]) {  mime_string += m.type; } return mime_string;})();");
                if (this.f32561g != null) {
                    this.h = v.b(this.f32561g);
                    String str = i;
                    Log.d(str, "Got:" + this.f32561g);
                    return;
                }
                this.h = "";
            }
        }
    }

    private void a(String str) {
        String str2 = "";
        this.f32557c = str.replaceAll("(<FIELD_SEP>|<REC_SEP>)", str2);
        this.f32558d = v.b(this.f32557c);
        ArrayList arrayList = new ArrayList();
        String[] split = str.split("<REC_SEP>");
        int length = split.length;
        int i2 = 0;
        while (i2 < length) {
            String str3 = split[i2];
            if (!Thread.currentThread().isInterrupted()) {
                HashMap hashMap = new HashMap();
                String[] split2 = str3.split("<FIELD_SEP>");
                if (split2.length == 4) {
                    hashMap.put("name", split2[0]);
                    hashMap.put("description", split2[1]);
                    hashMap.put("filename", split2[2]);
                    hashMap.put("length", split2[3]);
                    arrayList.add(hashMap);
                }
                i2++;
            } else {
                return;
            }
        }
        this.f32556b = Integer.toString(arrayList.size());
        this.f32555a = a("QuickTime Plug-in", "plugin_quicktime", (ArrayList<HashMap<String, String>>) arrayList) + a("Adobe Acrobat", "plugin_adobe_acrobat", (ArrayList<HashMap<String, String>>) arrayList) + a("Java", "plugin_java", (ArrayList<HashMap<String, String>>) arrayList) + a("SVG Viewer", "plugin_svg_viewer", (ArrayList<HashMap<String, String>>) arrayList) + a("Flash", "plugin_flash", (ArrayList<HashMap<String, String>>) arrayList) + a("Windows Media Player", "plugin_windows_media_player", (ArrayList<HashMap<String, String>>) arrayList) + a("Silverlight", "plugin_silverlight", (ArrayList<HashMap<String, String>>) arrayList) + a("Real Player", "plugin_realplayer", (ArrayList<HashMap<String, String>>) arrayList) + a("ShockWave Director", "plugin_shockwave", (ArrayList<HashMap<String, String>>) arrayList) + a("VLC", "plugin_vlc_player", (ArrayList<HashMap<String, String>>) arrayList) + a("DevalVR", "plugin_devalvr", (ArrayList<HashMap<String, String>>) arrayList);
        String str4 = i;
        StringBuilder sb = new StringBuilder();
        sb.append("Got");
        sb.append(this.f32556b);
        sb.append(":");
        if (this.f32555a != null) {
            str2 = this.f32555a;
        }
        sb.append(str2);
        Log.d(str4, sb.toString());
    }

    private void m() {
        int i2;
        String str = "";
        if ((this.p & 32) == 0 || this.m.f32597c.size() <= 0) {
            i2 = 0;
        } else {
            String str2 = this.m.f32597c.get(0);
            if (str2 == null || str2.isEmpty()) {
                this.f32558d = str;
            } else {
                a(str2);
            }
            i2 = 1;
        }
        if (!Thread.currentThread().isInterrupted() && (this.p & 4) != 0 && this.m.f32597c.size() > i2) {
            String str3 = this.m.f32597c.get(i2);
            int i3 = i2 + 1;
            if (str3 == null || str3.isEmpty()) {
                this.f32560f = 0;
            } else {
                try {
                    this.f32560f = Integer.parseInt(str3);
                } catch (NumberFormatException e2) {
                    Log.e(i, "failed to convert", e2);
                    this.f32560f = 0;
                }
            }
            if (this.f32560f > 0 && this.m.f32597c.size() > i3) {
                this.f32561g = this.m.f32597c.get(i3);
            }
            if (this.f32561g != null) {
                this.h = v.b(this.f32561g);
                String str4 = i;
                Log.d(str4, "Got:" + this.f32561g);
            } else {
                this.h = str;
            }
            String str5 = i;
            StringBuilder sb = new StringBuilder();
            sb.append("Got mime ");
            sb.append(this.f32560f);
            sb.append(":");
            if (this.f32561g != null) {
                str = this.f32561g;
            }
            sb.append(str);
            Log.d(str5, sb.toString());
        }
    }
}
