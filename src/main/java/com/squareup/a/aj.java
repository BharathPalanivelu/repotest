package com.squareup.a;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.util.Log;
import com.facebook.common.util.ByteConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.imsdk.BaseConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadFactory;

final class aj {

    /* renamed from: a  reason: collision with root package name */
    static final StringBuilder f30530a = new StringBuilder();

    static int a(Bitmap bitmap) {
        int allocationByteCount = Build.VERSION.SDK_INT >= 19 ? bitmap.getAllocationByteCount() : bitmap.getByteCount();
        if (allocationByteCount >= 0) {
            return allocationByteCount;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static void a() {
        if (c()) {
            throw new IllegalStateException("Method call should not happen from the main thread.");
        }
    }

    static void b() {
        if (!c()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    static boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    static String a(c cVar) {
        return a(cVar, "");
    }

    static String a(c cVar, String str) {
        StringBuilder sb = new StringBuilder(str);
        a i = cVar.i();
        if (i != null) {
            sb.append(i.f30490b.a());
        }
        List<a> k = cVar.k();
        if (k != null) {
            int size = k.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0 || i != null) {
                    sb.append(", ");
                }
                sb.append(k.get(i2).f30490b.a());
            }
        }
        return sb.toString();
    }

    static void a(String str, String str2, String str3) {
        a(str, str2, str3, "");
    }

    static void a(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4}));
    }

    static String a(z zVar) {
        String a2 = a(zVar, f30530a);
        f30530a.setLength(0);
        return a2;
    }

    static String a(z zVar, StringBuilder sb) {
        if (zVar.f30603f != null) {
            sb.ensureCapacity(zVar.f30603f.length() + 50);
            sb.append(zVar.f30603f);
        } else if (zVar.f30601d != null) {
            String uri = zVar.f30601d.toString();
            sb.ensureCapacity(uri.length() + 50);
            sb.append(uri);
        } else {
            sb.ensureCapacity(50);
            sb.append(zVar.f30602e);
        }
        sb.append(10);
        if (zVar.n != BitmapDescriptorFactory.HUE_RED) {
            sb.append("rotation:");
            sb.append(zVar.n);
            if (zVar.q) {
                sb.append('@');
                sb.append(zVar.o);
                sb.append('x');
                sb.append(zVar.p);
            }
            sb.append(10);
        }
        if (zVar.d()) {
            sb.append("resize:");
            sb.append(zVar.h);
            sb.append('x');
            sb.append(zVar.i);
            sb.append(10);
        }
        if (zVar.j) {
            sb.append("centerCrop:");
            sb.append(zVar.k);
            sb.append(10);
        } else if (zVar.l) {
            sb.append("centerInside");
            sb.append(10);
        }
        if (zVar.f30604g != null) {
            int size = zVar.f30604g.size();
            for (int i = 0; i < size; i++) {
                sb.append(zVar.f30604g.get(i).a());
                sb.append(10);
            }
        }
        return sb.toString();
    }

    static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    static boolean a(String str) {
        if (str == null) {
            return false;
        }
        String[] split = str.split(SQLBuilder.BLANK, 2);
        if ("CACHE".equals(split[0])) {
            return true;
        }
        if (split.length == 1) {
            return false;
        }
        try {
            if (!"CONDITIONAL_CACHE".equals(split[0]) || Integer.parseInt(split[1]) != 304) {
                return false;
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    static j a(Context context) {
        try {
            Class.forName("okhttp3.OkHttpClient");
            return a.a(context);
        } catch (ClassNotFoundException unused) {
            try {
                Class.forName("com.squareup.okhttp.OkHttpClient");
                return b.a(context);
            } catch (ClassNotFoundException unused2) {
                return new ai(context);
            }
        }
    }

    static File b(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @TargetApi(18)
    static long a(File file) {
        long j;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = ((Build.VERSION.SDK_INT < 18 ? (long) statFs.getBlockCount() : statFs.getBlockCountLong()) * (Build.VERSION.SDK_INT < 18 ? (long) statFs.getBlockSize() : statFs.getBlockSizeLong())) / 50;
        } catch (IllegalArgumentException unused) {
            j = 5242880;
        }
        return Math.max(Math.min(j, 52428800), 5242880);
    }

    static int c(Context context) {
        ActivityManager activityManager = (ActivityManager) a(context, "activity");
        return (int) ((((long) ((context.getApplicationInfo().flags & ByteConstants.MB) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass())) * BaseConstants.MEGA) / 7);
    }

    static boolean d(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            if (Build.VERSION.SDK_INT < 17) {
                if (Settings.System.getInt(contentResolver, "airplane_mode_on", 0) != 0) {
                    return true;
                }
                return false;
            } else if (Settings.Global.getInt(contentResolver, "airplane_mode_on", 0) != 0) {
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException | SecurityException unused) {
            return false;
        }
    }

    static <T> T a(Context context, String str) {
        return context.getSystemService(str);
    }

    static boolean b(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    static boolean c(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[12];
        if (inputStream.read(bArr, 0, 12) != 12 || !"RIFF".equals(new String(bArr, 0, 4, "US-ASCII")) || !"WEBP".equals(new String(bArr, 8, 4, "US-ASCII"))) {
            return false;
        }
        return true;
    }

    static int a(Resources resources, z zVar) throws FileNotFoundException {
        if (zVar.f30602e != 0 || zVar.f30601d == null) {
            return zVar.f30602e;
        }
        String authority = zVar.f30601d.getAuthority();
        if (authority != null) {
            List<String> pathSegments = zVar.f30601d.getPathSegments();
            if (pathSegments == null || pathSegments.isEmpty()) {
                throw new FileNotFoundException("No path segments: " + zVar.f30601d);
            } else if (pathSegments.size() == 1) {
                try {
                    return Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Last path segment is not a resource ID: " + zVar.f30601d);
                }
            } else if (pathSegments.size() == 2) {
                return resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + zVar.f30601d);
            }
        } else {
            throw new FileNotFoundException("No package provided: " + zVar.f30601d);
        }
    }

    static Resources a(Context context, z zVar) throws FileNotFoundException {
        if (zVar.f30602e != 0 || zVar.f30601d == null) {
            return context.getResources();
        }
        String authority = zVar.f30601d.getAuthority();
        if (authority != null) {
            try {
                return context.getPackageManager().getResourcesForApplication(authority);
            } catch (PackageManager.NameNotFoundException unused) {
                throw new FileNotFoundException("Unable to obtain resources for package: " + zVar.f30601d);
            }
        } else {
            throw new FileNotFoundException("No package provided: " + zVar.f30601d);
        }
    }

    static void a(Looper looper) {
        AnonymousClass1 r0 = new Handler(looper) {
            public void handleMessage(Message message) {
                sendMessageDelayed(obtainMessage(), 1000);
            }
        };
        r0.sendMessageDelayed(r0.obtainMessage(), 1000);
    }

    static class d implements ThreadFactory {
        d() {
        }

        public Thread newThread(Runnable runnable) {
            return new c(runnable);
        }
    }

    private static class c extends Thread {
        public c(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    private static class b {
        static j a(Context context) {
            return new v(context);
        }
    }

    private static class a {
        static j a(Context context) {
            return new u(context);
        }
    }
}
