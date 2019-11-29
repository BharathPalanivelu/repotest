package com.tencent.rtmp.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.appsflyer.share.Constants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapFactory.Options f32345a;

    /* renamed from: b  reason: collision with root package name */
    private HandlerThread f32346b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f32347c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public List<c> f32348d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Map<String, BitmapRegionDecoder> f32349e;

    public b() {
        this.f32345a = new BitmapFactory.Options();
        this.f32348d = new ArrayList();
        this.f32348d = Collections.synchronizedList(this.f32348d);
        this.f32349e = new HashMap();
        this.f32349e = Collections.synchronizedMap(this.f32349e);
    }

    public void setVTTUrlAndImageUrls(String str, List<String> list) {
        if (TextUtils.isEmpty(str)) {
            TXCLog.e("TXImageSprite", "setVTTUrlAndImageUrls: vttUrl can't be null!");
            return;
        }
        b();
        a();
        this.f32347c.post(new a(this, str));
        if (list != null && list.size() != 0) {
            for (String bVar : list) {
                this.f32347c.post(new C0494b(this, str, bVar));
            }
        }
    }

    public Bitmap getThumbnail(float f2) {
        if (this.f32348d.size() == 0) {
            return null;
        }
        c a2 = a(0, this.f32348d.size() - 1, f2);
        if (a2 == null) {
            return null;
        }
        BitmapRegionDecoder bitmapRegionDecoder = this.f32349e.get(a2.f32359d);
        if (bitmapRegionDecoder == null) {
            return null;
        }
        Rect rect = new Rect();
        rect.left = a2.f32360e;
        rect.top = a2.f32361f;
        rect.right = a2.f32360e + a2.f32362g;
        rect.bottom = a2.f32361f + a2.h;
        return bitmapRegionDecoder.decodeRegion(rect, this.f32345a);
    }

    public void release() {
        b();
        if (this.f32346b != null && this.f32347c != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.f32346b.quitSafely();
            } else {
                this.f32346b.quit();
            }
            this.f32347c = null;
            this.f32346b = null;
        }
    }

    private c a(int i, int i2, float f2) {
        int i3 = ((i2 - i) / 2) + i;
        if (this.f32348d.get(i3).f32356a <= f2 && this.f32348d.get(i3).f32357b > f2) {
            return this.f32348d.get(i3);
        }
        if (i >= i2) {
            return this.f32348d.get(i);
        }
        if (f2 >= this.f32348d.get(i3).f32357b) {
            return a(i3 + 1, i2, f2);
        }
        if (f2 < this.f32348d.get(i3).f32356a) {
            return a(i, i3 - 1, f2);
        }
        return null;
    }

    private void a() {
        if (this.f32346b == null) {
            this.f32346b = new HandlerThread("SuperVodThumbnailsWorkThread");
            this.f32346b.start();
            this.f32347c = new Handler(this.f32346b.getLooper());
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        if (this.f32347c != null) {
            TXCLog.i("TXImageSprite", " remove all tasks!");
            this.f32347c.removeCallbacksAndMessages((Object) null);
            this.f32347c.post(new Runnable() {
                public void run() {
                    if (b.this.f32348d != null) {
                        b.this.f32348d.clear();
                    }
                    if (b.this.f32349e != null) {
                        for (BitmapRegionDecoder bitmapRegionDecoder : b.this.f32349e.values()) {
                            if (bitmapRegionDecoder != null) {
                                bitmapRegionDecoder.recycle();
                            }
                        }
                        b.this.f32349e.clear();
                    }
                }
            });
        }
    }

    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<b> f32351a;

        /* renamed from: b  reason: collision with root package name */
        private String f32352b;

        public a(b bVar, String str) {
            this.f32351a = new WeakReference<>(bVar);
            this.f32352b = str;
        }

        private float a(String str) {
            String str2;
            String str3;
            String[] split = str.split(":");
            String str4 = null;
            if (split.length == 3) {
                str4 = split[0];
                str3 = split[1];
                str2 = split[2];
            } else if (split.length == 2) {
                str3 = split[0];
                str2 = split[1];
            } else if (split.length == 1) {
                str2 = split[0];
                str3 = null;
            } else {
                str2 = null;
                str3 = null;
            }
            float f2 = BitmapDescriptorFactory.HUE_RED;
            if (str4 != null) {
                f2 = BitmapDescriptorFactory.HUE_RED + (Float.valueOf(BitmapDescriptorFactory.HUE_RED).floatValue() * 3600.0f);
            }
            if (str3 != null) {
                f2 += Float.valueOf(str3).floatValue() * 60.0f;
            }
            return str2 != null ? f2 + Float.valueOf(str2).floatValue() : f2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:56:0x0103 A[SYNTHETIC, Splitter:B:56:0x0103] */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x010e A[SYNTHETIC, Splitter:B:61:0x010e] */
        /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r10 = this;
                java.lang.ref.WeakReference<com.tencent.rtmp.a.b> r0 = r10.f32351a
                java.lang.Object r0 = r0.get()
                com.tencent.rtmp.a.b r0 = (com.tencent.rtmp.a.b) r0
                r1 = 0
                java.lang.String r2 = r10.f32352b     // Catch:{ IOException -> 0x00fd }
                java.io.InputStream r2 = r0.a((java.lang.String) r2)     // Catch:{ IOException -> 0x00fd }
                if (r2 != 0) goto L_0x0012
                return
            L_0x0012:
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00fd }
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00fd }
                r4.<init>(r2)     // Catch:{ IOException -> 0x00fd }
                r3.<init>(r4)     // Catch:{ IOException -> 0x00fd }
                java.lang.String r1 = r3.readLine()     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                if (r1 == 0) goto L_0x00e0
                int r2 = r1.length()     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                if (r2 == 0) goto L_0x00e0
                java.lang.String r2 = "WEBVTT"
                boolean r1 = r1.contains(r2)     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                if (r1 != 0) goto L_0x0032
                goto L_0x00e0
            L_0x0032:
                java.lang.String r1 = r3.readLine()     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                if (r1 == 0) goto L_0x00da
                java.lang.String r2 = "-->"
                boolean r2 = r1.contains(r2)     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                if (r2 == 0) goto L_0x00da
                java.lang.String r2 = " --> "
                java.lang.String[] r2 = r1.split(r2)     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                int r4 = r2.length     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                r5 = 2
                if (r4 == r5) goto L_0x004c
                goto L_0x00da
            L_0x004c:
                java.lang.String r4 = r3.readLine()     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                com.tencent.rtmp.a.c r6 = new com.tencent.rtmp.a.c     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                r6.<init>()     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                r7 = 0
                r8 = r2[r7]     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                float r8 = r10.a(r8)     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                r6.f32356a = r8     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                r8 = 1
                r2 = r2[r8]     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                float r2 = r10.a(r2)     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                r6.f32357b = r2     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                r6.f32358c = r4     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                java.lang.String r2 = "#"
                int r2 = r4.indexOf(r2)     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                r9 = -1
                if (r2 == r9) goto L_0x0078
                java.lang.String r2 = r4.substring(r7, r2)     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                r6.f32359d = r2     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
            L_0x0078:
                java.lang.String r2 = "="
                int r2 = r4.indexOf(r2)     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                if (r2 == r9) goto L_0x00cb
                int r2 = r2 + 1
                int r9 = r4.length()     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                if (r2 >= r9) goto L_0x00cb
                int r9 = r4.length()     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                java.lang.String r2 = r4.substring(r2, r9)     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                java.lang.String r4 = ","
                java.lang.String[] r2 = r2.split(r4)     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                int r4 = r2.length     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                r9 = 4
                if (r4 != r9) goto L_0x00cb
                r4 = r2[r7]     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                int r4 = r4.intValue()     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                r6.f32360e = r4     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                r4 = r2[r8]     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                int r4 = r4.intValue()     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                r6.f32361f = r4     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                r4 = r2[r5]     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                int r4 = r4.intValue()     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                r6.f32362g = r4     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                r4 = 3
                r2 = r2[r4]     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                int r2 = r2.intValue()     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                r6.h = r2     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
            L_0x00cb:
                if (r0 == 0) goto L_0x00da
                java.util.List r2 = r0.f32348d     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                if (r2 == 0) goto L_0x00da
                java.util.List r2 = r0.f32348d     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                r2.add(r6)     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
            L_0x00da:
                if (r1 != 0) goto L_0x0032
                r3.close()     // Catch:{ IOException -> 0x0107 }
                goto L_0x010b
            L_0x00e0:
                java.lang.String r1 = "TXImageSprite"
                java.lang.String r2 = "DownloadAndParseVTTFileTask : getVTT File Error!"
                com.tencent.liteav.basic.log.TXCLog.e(r1, r2)     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
                if (r0 == 0) goto L_0x00ec
                r0.b()     // Catch:{ IOException -> 0x00f7, all -> 0x00f5 }
            L_0x00ec:
                r3.close()     // Catch:{ IOException -> 0x00f0 }
                goto L_0x00f4
            L_0x00f0:
                r0 = move-exception
                r0.printStackTrace()
            L_0x00f4:
                return
            L_0x00f5:
                r0 = move-exception
                goto L_0x010c
            L_0x00f7:
                r0 = move-exception
                r1 = r3
                goto L_0x00fe
            L_0x00fa:
                r0 = move-exception
                r3 = r1
                goto L_0x010c
            L_0x00fd:
                r0 = move-exception
            L_0x00fe:
                r0.printStackTrace()     // Catch:{ all -> 0x00fa }
                if (r1 == 0) goto L_0x010b
                r1.close()     // Catch:{ IOException -> 0x0107 }
                goto L_0x010b
            L_0x0107:
                r0 = move-exception
                r0.printStackTrace()
            L_0x010b:
                return
            L_0x010c:
                if (r3 == 0) goto L_0x0116
                r3.close()     // Catch:{ IOException -> 0x0112 }
                goto L_0x0116
            L_0x0112:
                r1 = move-exception
                r1.printStackTrace()
            L_0x0116:
                goto L_0x0118
            L_0x0117:
                throw r0
            L_0x0118:
                goto L_0x0117
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.a.b.a.run():void");
        }
    }

    /* access modifiers changed from: private */
    public InputStream a(String str) throws IOException {
        URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection());
        uRLConnection.connect();
        uRLConnection.getInputStream();
        uRLConnection.setConnectTimeout(15000);
        uRLConnection.setReadTimeout(15000);
        return uRLConnection.getInputStream();
    }

    /* renamed from: com.tencent.rtmp.a.b$b  reason: collision with other inner class name */
    private static class C0494b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<b> f32353a;

        /* renamed from: b  reason: collision with root package name */
        private String f32354b;

        /* renamed from: c  reason: collision with root package name */
        private String f32355c;

        public C0494b(b bVar, String str, String str2) {
            this.f32353a = new WeakReference<>(bVar);
            this.f32354b = str;
            this.f32355c = str2;
        }

        public void run() {
            b bVar = (b) this.f32353a.get();
            if (this.f32353a != null && bVar != null) {
                InputStream inputStream = null;
                try {
                    InputStream a2 = bVar.a(this.f32355c);
                    int lastIndexOf = this.f32355c.lastIndexOf(Constants.URL_PATH_DELIMITER);
                    if (lastIndexOf != -1) {
                        int i = lastIndexOf + 1;
                        if (i < this.f32355c.length()) {
                            String substring = this.f32355c.substring(i, this.f32355c.length());
                            if (bVar.f32349e != null) {
                                bVar.f32349e.put(substring, BitmapRegionDecoder.newInstance(a2, true));
                            }
                        }
                    }
                    if (a2 != null) {
                        try {
                            a2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        }
    }
}
