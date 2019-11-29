package com.shopee.arcatch.c.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.appevents.AppEventsConstants;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import com.shopee.arcatch.c.f.b;
import com.squareup.a.w;
import io.b.d.g;
import io.b.j;
import io.b.k;
import io.b.l;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f26693a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public float f26694b;

    /* renamed from: com.shopee.arcatch.c.a.a$a  reason: collision with other inner class name */
    private static class C0416a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f26709a = new a();
    }

    public static a a() {
        return C0416a.f26709a;
    }

    private a() {
        File cacheDir = b.b().a().getCacheDir();
        this.f26693a = cacheDir.getPath() + File.separator + "arcatch" + File.separator + "audio";
        b();
        c();
    }

    private boolean b() {
        File file = new File(this.f26693a);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }

    private void c() {
        int b2 = com.shopee.arcatch.b.c.b.b(b.b().a());
        if (b2 != 0) {
            this.f26694b = ((float) b2) / 974.99994f;
        } else {
            this.f26694b = com.shopee.arcatch.b.c.b.a(b.b().a()) / 2.0f;
        }
    }

    public j<Boolean> a(List<String> list) {
        com.shopee.e.a.a.a((Object) "saveImage urlList " + list);
        ArrayList arrayList = new ArrayList();
        for (String a2 : list) {
            arrayList.add(a(a2));
        }
        return j.a(arrayList, new g<Object[], Boolean>() {
            /* renamed from: a */
            public Boolean apply(Object[] objArr) {
                boolean z = true;
                for (Boolean bool : objArr) {
                    com.shopee.e.a.a.a((Object) "saveImage " + bool);
                    z &= bool.booleanValue();
                }
                return Boolean.valueOf(z);
            }
        }).b(io.b.h.a.b());
    }

    public j<Boolean> a(final String str) {
        com.shopee.e.a.a.a((Object) "saveImage url " + str);
        final Context a2 = b.b().a();
        if (TextUtils.isEmpty(str)) {
            return j.b(false);
        }
        return j.a(new l<Boolean>() {
            public void a(k<Boolean> kVar) {
                w a2 = w.a(a2);
                a2.a(true);
                boolean z = false;
                try {
                    if (a2.a(str).h() != null) {
                        z = true;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                com.shopee.e.a.a.a((Object) "onBitmapLoaded " + str + " success " + z);
                kVar.a(Boolean.valueOf(z));
            }
        });
    }

    public j<Map<String, Bitmap>> b(List<Pair<String, String>> list) {
        com.shopee.e.a.a.a((Object) "saveImage urlList " + list);
        ArrayList arrayList = new ArrayList();
        for (Pair next : list) {
            arrayList.add(a((String) next.first, (String) next.second));
        }
        return j.a(arrayList, new g<Object[], Map<String, Bitmap>>() {
            /* renamed from: a */
            public Map<String, Bitmap> apply(Object[] objArr) {
                HashMap hashMap = new HashMap();
                for (Pair pair : objArr) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("saveImage ");
                    sb.append(pair.second != null);
                    com.shopee.e.a.a.a((Object) sb.toString());
                    hashMap.put(pair.first, pair.second);
                }
                return hashMap;
            }
        }).b(io.b.h.a.b());
    }

    public j<Pair<String, Bitmap>> a(final String str, final String str2) {
        com.shopee.e.a.a.a((Object) "saveImage url " + str2);
        final Context a2 = b.b().a();
        if (TextUtils.isEmpty(str2)) {
            return j.b(new Pair(str, (Object) null));
        }
        return j.a(new l<Pair<String, Bitmap>>() {
            public void a(k<Pair<String, Bitmap>> kVar) {
                Bitmap bitmap;
                w a2 = w.a(a2);
                boolean z = true;
                a2.a(true);
                try {
                    bitmap = a2.a(str2).h();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    com.shopee.e.a.a.a(e2, "picasso get " + str2 + " error", new Object[0]);
                    bitmap = null;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("onBitmapLoaded ");
                sb.append(str2);
                sb.append(" success ");
                sb.append(bitmap != null);
                com.shopee.e.a.a.a((Object) sb.toString());
                if (bitmap == null) {
                    kVar.a(new Pair(str, (Object) null));
                    return;
                }
                Bitmap a3 = com.shopee.arcatch.b.c.b.a(bitmap, a.this.f26694b);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("resizedBitmap");
                sb2.append(str2);
                sb2.append(" scaleBitmap is null? ");
                if (a3 != null) {
                    z = false;
                }
                sb2.append(z);
                com.shopee.e.a.a.b(sb2.toString(), new Object[0]);
                kVar.a(new Pair(str, a3));
            }
        });
    }

    public j<Map<String, String>> c(List<Pair<String, String>> list) {
        com.shopee.e.a.a.a((Object) "saveAudioFile urlList " + list);
        ArrayList arrayList = new ArrayList();
        for (Pair next : list) {
            arrayList.add(b((String) next.first, (String) next.second));
        }
        return j.a(arrayList, new g<Object[], Map<String, String>>() {
            /* renamed from: a */
            public Map<String, String> apply(Object[] objArr) {
                HashMap hashMap = new HashMap();
                for (Pair pair : objArr) {
                    hashMap.put(pair.first, pair.second);
                }
                return hashMap;
            }
        });
    }

    public j<Pair<String, String>> b(final String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return j.b(new Pair(str, ""));
        }
        final String b2 = b(c(str2));
        final File file = new File(b2);
        if (file.exists()) {
            return j.b(new Pair(str, b2));
        }
        return com.shopee.arcatch.a.a.a().a(str2).b(new g<InputStream, Pair<String, String>>() {
            /* renamed from: a */
            public Pair<String, String> apply(InputStream inputStream) {
                if (inputStream == null) {
                    return new Pair<>(str, "");
                }
                return a.b(inputStream, file) ? new Pair<>(str, b2) : new Pair<>(str, "");
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0030 A[SYNTHETIC, Splitter:B:24:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x003e A[SYNTHETIC, Splitter:B:31:0x003e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.io.InputStream r3, java.io.File r4) {
        /*
            r0 = 0
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002a }
            r2.<init>(r4)     // Catch:{ IOException -> 0x002a }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
        L_0x000b:
            int r1 = r3.read(r4)     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
            if (r1 <= 0) goto L_0x0015
            r2.write(r4, r0, r1)     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
            goto L_0x000b
        L_0x0015:
            r4 = 1
            r2.close()     // Catch:{ IOException -> 0x001d }
            r3.close()     // Catch:{ IOException -> 0x001d }
            goto L_0x0021
        L_0x001d:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0021:
            return r4
        L_0x0022:
            r4 = move-exception
            r1 = r2
            goto L_0x003c
        L_0x0025:
            r4 = move-exception
            r1 = r2
            goto L_0x002b
        L_0x0028:
            r4 = move-exception
            goto L_0x003c
        L_0x002a:
            r4 = move-exception
        L_0x002b:
            r4.printStackTrace()     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0033
            r1.close()     // Catch:{ IOException -> 0x0037 }
        L_0x0033:
            r3.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r3 = move-exception
            r3.printStackTrace()
        L_0x003b:
            return r0
        L_0x003c:
            if (r1 == 0) goto L_0x0041
            r1.close()     // Catch:{ IOException -> 0x0045 }
        L_0x0041:
            r3.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x0049
        L_0x0045:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0049:
            goto L_0x004b
        L_0x004a:
            throw r4
        L_0x004b:
            goto L_0x004a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.arcatch.c.a.a.b(java.io.InputStream, java.io.File):boolean");
    }

    private String b(String str) {
        return this.f26693a + File.separator + str;
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(Hash.ALGORITHM_MD5);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        if (messageDigest == null) {
            return str;
        }
        byte[] digest = messageDigest.digest(str.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b2 : digest) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                sb.append(hexString);
            } else {
                sb.append(hexString);
            }
        }
        return sb.toString();
    }
}
