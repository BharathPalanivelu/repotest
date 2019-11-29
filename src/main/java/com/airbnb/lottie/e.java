package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.JsonReader;
import android.util.Log;
import com.airbnb.lottie.c.g;
import com.airbnb.lottie.d.c;
import com.airbnb.lottie.e.t;
import com.airbnb.lottie.f.f;
import com.appsflyer.share.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, l<d>> f3664a = new HashMap();

    public static l<d> a(Context context, String str) {
        return c.a(context, str);
    }

    public static l<d> b(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        return a(str, (Callable<k<d>>) new Callable<k<d>>() {
            /* renamed from: a */
            public k<d> call() {
                return e.c(applicationContext, str);
            }
        });
    }

    public static k<d> c(Context context, String str) {
        try {
            String str2 = "asset_" + str;
            if (str.endsWith(".zip")) {
                return a(new ZipInputStream(context.getAssets().open(str)), str2);
            }
            return a(context.getAssets().open(str), str2);
        } catch (IOException e2) {
            return new k<>((Throwable) e2);
        }
    }

    public static l<d> a(Context context, final int i) {
        final Context applicationContext = context.getApplicationContext();
        return a(a(i), (Callable<k<d>>) new Callable<k<d>>() {
            /* renamed from: a */
            public k<d> call() {
                return e.b(applicationContext, i);
            }
        });
    }

    public static k<d> b(Context context, int i) {
        try {
            return a(context.getResources().openRawResource(i), a(i));
        } catch (Resources.NotFoundException e2) {
            return new k<>((Throwable) e2);
        }
    }

    private static String a(int i) {
        return "rawRes_" + i;
    }

    public static k<d> a(InputStream inputStream, String str) {
        return a(inputStream, str, true);
    }

    private static k<d> a(InputStream inputStream, String str, boolean z) {
        try {
            return b(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                f.a((Closeable) inputStream);
            }
        }
    }

    public static l<d> a(final JsonReader jsonReader, final String str) {
        return a(str, (Callable<k<d>>) new Callable<k<d>>() {
            /* renamed from: a */
            public k<d> call() {
                return e.b(jsonReader, str);
            }
        });
    }

    public static k<d> b(JsonReader jsonReader, String str) {
        try {
            d a2 = t.a(jsonReader);
            g.a().a(str, a2);
            return new k<>(a2);
        } catch (Exception e2) {
            return new k<>((Throwable) e2);
        }
    }

    public static k<d> a(ZipInputStream zipInputStream, String str) {
        try {
            return b(zipInputStream, str);
        } finally {
            f.a((Closeable) zipInputStream);
        }
    }

    private static k<d> b(ZipInputStream zipInputStream, String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            d dVar = null;
            while (nextEntry != null) {
                if (nextEntry.getName().contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    dVar = a(zipInputStream, str, false).a();
                } else if (nextEntry.getName().contains(".png")) {
                    String[] split = nextEntry.getName().split(Constants.URL_PATH_DELIMITER);
                    hashMap.put(split[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (dVar == null) {
                return new k<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                g a2 = a(dVar, (String) entry.getKey());
                if (a2 != null) {
                    a2.a((Bitmap) entry.getValue());
                }
            }
            for (Map.Entry next : dVar.j().entrySet()) {
                if (((g) next.getValue()).c() == null) {
                    return new k<>((Throwable) new IllegalStateException("There is no image for " + ((g) next.getValue()).b()));
                }
            }
            g.a().a(str, dVar);
            return new k<>(dVar);
        } catch (IOException e2) {
            return new k<>((Throwable) e2);
        }
    }

    private static g a(d dVar, String str) {
        for (g next : dVar.j().values()) {
            if (next.b().equals(str)) {
                return next;
            }
        }
        return null;
    }

    private static l<d> a(final String str, Callable<k<d>> callable) {
        final d a2 = g.a().a(str);
        if (a2 != null) {
            return new l<>(new Callable<k<d>>() {
                /* renamed from: a */
                public k<d> call() {
                    Log.d("Gabe", "call\treturning from cache");
                    return new k<>(a2);
                }
            });
        }
        if (f3664a.containsKey(str)) {
            return f3664a.get(str);
        }
        l<d> lVar = new l<>(callable);
        lVar.a((h<d>) new h<d>() {
            public void a(d dVar) {
                if (str != null) {
                    g.a().a(str, dVar);
                }
                e.f3664a.remove(str);
            }
        });
        lVar.c((h<Throwable>) new h<Throwable>() {
            public void a(Throwable th) {
                e.f3664a.remove(str);
            }
        });
        f3664a.put(str, lVar);
        return lVar;
    }
}
