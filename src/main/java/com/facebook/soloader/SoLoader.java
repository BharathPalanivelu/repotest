package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.soloader.nativeloader.NativeLoader;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SoLoader {
    static final boolean DEBUG = false;
    public static final int SOLOADER_ALLOW_ASYNC_INIT = 2;
    public static final int SOLOADER_DISABLE_BACKUP_SOSOURCE = 8;
    public static final int SOLOADER_ENABLE_EXOPACKAGE = 1;
    public static final int SOLOADER_LOOK_IN_ZIP = 4;
    public static final int SOLOADER_SKIP_MERGED_JNI_ONLOAD = 16;
    private static final String SO_STORE_NAME_MAIN = "lib-main";
    private static final String SO_STORE_NAME_SPLIT = "lib-";
    static final boolean SYSTRACE_LIBRARY_LOADING;
    static final String TAG = "SoLoader";
    private static boolean isSystemApp;
    private static ApplicationSoSource sApplicationSoSource;
    private static UnpackingSoSource[] sBackupSoSources;
    private static int sFlags;
    private static final Set<String> sLoadedAndMergedLibraries = Collections.newSetFromMap(new ConcurrentHashMap());
    private static final HashSet<String> sLoadedLibraries = new HashSet<>();
    private static final Map<String, Object> sLoadingLibraries = new HashMap();
    static SoFileLoader sSoFileLoader;
    private static SoSource[] sSoSources = null;
    private static final ReentrantReadWriteLock sSoSourcesLock = new ReentrantReadWriteLock();
    private static int sSoSourcesVersion = 0;
    private static SystemLoadLibraryWrapper sSystemLoadLibraryWrapper = null;

    static {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                z = true;
            }
        } catch (NoClassDefFoundError | UnsatisfiedLinkError unused) {
        }
        SYSTRACE_LIBRARY_LOADING = z;
    }

    public static void init(Context context, int i) throws IOException {
        init(context, i, (SoFileLoader) null);
    }

    private static void init(Context context, int i, SoFileLoader soFileLoader) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            isSystemApp = checkIfSystemApp(context);
            initSoLoader(soFileLoader);
            initSoSources(context, i, soFileLoader);
            if (!NativeLoader.isInitialized()) {
                NativeLoader.init(new NativeLoaderToSoLoaderDelegate());
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    public static void init(Context context, boolean z) {
        try {
            init(context, z ? 1 : 0);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void initSoSources(Context context, int i, SoFileLoader soFileLoader) throws IOException {
        int i2;
        sSoSourcesLock.writeLock().lock();
        try {
            if (sSoSources == null) {
                Log.d(TAG, "init start");
                sFlags = i;
                ArrayList arrayList = new ArrayList();
                String str = System.getenv("LD_LIBRARY_PATH");
                if (str == null) {
                    str = "/vendor/lib:/system/lib";
                }
                String[] split = str.split(":");
                for (int i3 = 0; i3 < split.length; i3++) {
                    Log.d(TAG, "adding system library source: " + split[i3]);
                    arrayList.add(new DirectorySoSource(new File(split[i3]), 2));
                }
                if (context != null) {
                    if ((i & 1) != 0) {
                        sBackupSoSources = null;
                        Log.d(TAG, "adding exo package source: lib-main");
                        arrayList.add(0, new ExoSoSource(context, SO_STORE_NAME_MAIN));
                    } else {
                        if (isSystemApp) {
                            i2 = 0;
                        } else {
                            sApplicationSoSource = new ApplicationSoSource(context, Build.VERSION.SDK_INT <= 17 ? 1 : 0);
                            Log.d(TAG, "adding application source: " + sApplicationSoSource.toString());
                            arrayList.add(0, sApplicationSoSource);
                            i2 = 1;
                        }
                        if ((sFlags & 8) != 0) {
                            sBackupSoSources = null;
                        } else {
                            File file = new File(context.getApplicationInfo().sourceDir);
                            ArrayList arrayList2 = new ArrayList();
                            ApkSoSource apkSoSource = new ApkSoSource(context, file, SO_STORE_NAME_MAIN, i2);
                            arrayList2.add(apkSoSource);
                            Log.d(TAG, "adding backup source from : " + apkSoSource.toString());
                            if (Build.VERSION.SDK_INT >= 21 && context.getApplicationInfo().splitSourceDirs != null) {
                                Log.d(TAG, "adding backup sources from split apks");
                                String[] strArr = context.getApplicationInfo().splitSourceDirs;
                                int length = strArr.length;
                                int i4 = 0;
                                int i5 = 0;
                                while (i4 < length) {
                                    File file2 = new File(strArr[i4]);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(SO_STORE_NAME_SPLIT);
                                    sb.append(i5);
                                    ApkSoSource apkSoSource2 = new ApkSoSource(context, file2, sb.toString(), i2);
                                    Log.d(TAG, "adding backup source: " + apkSoSource2.toString());
                                    arrayList2.add(apkSoSource2);
                                    i4++;
                                    i5++;
                                }
                            }
                            sBackupSoSources = (UnpackingSoSource[]) arrayList2.toArray(new UnpackingSoSource[arrayList2.size()]);
                            arrayList.addAll(0, arrayList2);
                        }
                    }
                }
                SoSource[] soSourceArr = (SoSource[]) arrayList.toArray(new SoSource[arrayList.size()]);
                int makePrepareFlags = makePrepareFlags();
                int length2 = soSourceArr.length;
                while (true) {
                    int i6 = length2 - 1;
                    if (length2 <= 0) {
                        break;
                    }
                    Log.d(TAG, "Preparing SO source: " + soSourceArr[i6]);
                    soSourceArr[i6].prepare(makePrepareFlags);
                    length2 = i6;
                }
                sSoSources = soSourceArr;
                sSoSourcesVersion++;
                Log.d(TAG, "init finish: " + sSoSources.length + " SO sources prepared");
            }
        } finally {
            Log.d(TAG, "init exiting");
            sSoSourcesLock.writeLock().unlock();
        }
    }

    private static int makePrepareFlags() {
        sSoSourcesLock.writeLock().lock();
        try {
            return (sFlags & 2) != 0 ? 1 : 0;
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    private static synchronized void initSoLoader(SoFileLoader soFileLoader) {
        synchronized (SoLoader.class) {
            if (soFileLoader != null) {
                sSoFileLoader = soFileLoader;
                return;
            }
            final Runtime runtime = Runtime.getRuntime();
            final Method nativeLoadRuntimeMethod = getNativeLoadRuntimeMethod();
            final boolean z = nativeLoadRuntimeMethod != null;
            final String classLoaderLdLoadLibrary = z ? Api14Utils.getClassLoaderLdLoadLibrary() : null;
            final String makeNonZipPath = makeNonZipPath(classLoaderLdLoadLibrary);
            sSoFileLoader = new SoFileLoader() {
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
                    if (r1 == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
                    android.util.Log.e(com.facebook.soloader.SoLoader.TAG, "Error when loading lib: " + r1 + " lib hash: " + getLibHash(r9) + " search path is " + r10);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
                    return;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void load(java.lang.String r9, int r10) {
                    /*
                        r8 = this;
                        boolean r0 = r2
                        if (r0 == 0) goto L_0x00bb
                        r0 = 4
                        r10 = r10 & r0
                        r1 = 1
                        r2 = 0
                        if (r10 != r0) goto L_0x000c
                        r10 = 1
                        goto L_0x000d
                    L_0x000c:
                        r10 = 0
                    L_0x000d:
                        if (r10 == 0) goto L_0x0012
                        java.lang.String r10 = r3
                        goto L_0x0014
                    L_0x0012:
                        java.lang.String r10 = r4
                    L_0x0014:
                        r0 = 0
                        java.lang.Runtime r3 = r5     // Catch:{ IllegalAccessException -> 0x0076, IllegalArgumentException -> 0x0074, InvocationTargetException -> 0x0072 }
                        monitor-enter(r3)     // Catch:{ IllegalAccessException -> 0x0076, IllegalArgumentException -> 0x0074, InvocationTargetException -> 0x0072 }
                        java.lang.reflect.Method r4 = r6     // Catch:{ all -> 0x006d }
                        java.lang.Runtime r5 = r5     // Catch:{ all -> 0x006d }
                        r6 = 3
                        java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x006d }
                        r6[r2] = r9     // Catch:{ all -> 0x006d }
                        java.lang.Class<com.facebook.soloader.SoLoader> r2 = com.facebook.soloader.SoLoader.class
                        java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ all -> 0x006d }
                        r6[r1] = r2     // Catch:{ all -> 0x006d }
                        r1 = 2
                        r6[r1] = r10     // Catch:{ all -> 0x006d }
                        java.lang.Object r1 = r4.invoke(r5, r6)     // Catch:{ all -> 0x006d }
                        java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x006d }
                        if (r1 != 0) goto L_0x0067
                        monitor-exit(r3)     // Catch:{ all -> 0x0062 }
                        if (r1 == 0) goto L_0x00be
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        java.lang.String r2 = "Error when loading lib: "
                        r0.append(r2)
                        r0.append(r1)
                        java.lang.String r1 = " lib hash: "
                        r0.append(r1)
                        java.lang.String r9 = r8.getLibHash(r9)
                        r0.append(r9)
                        java.lang.String r9 = " search path is "
                        r0.append(r9)
                        r0.append(r10)
                        java.lang.String r9 = r0.toString()
                        java.lang.String r10 = "SoLoader"
                        android.util.Log.e(r10, r9)
                        goto L_0x00be
                    L_0x0062:
                        r0 = move-exception
                        r7 = r1
                        r1 = r0
                        r0 = r7
                        goto L_0x006e
                    L_0x0067:
                        java.lang.UnsatisfiedLinkError r0 = new java.lang.UnsatisfiedLinkError     // Catch:{ all -> 0x0062 }
                        r0.<init>(r1)     // Catch:{ all -> 0x0062 }
                        throw r0     // Catch:{ all -> 0x0062 }
                    L_0x006d:
                        r1 = move-exception
                    L_0x006e:
                        monitor-exit(r3)     // Catch:{ all -> 0x006d }
                        throw r1     // Catch:{ IllegalAccessException -> 0x0076, IllegalArgumentException -> 0x0074, InvocationTargetException -> 0x0072 }
                    L_0x0070:
                        r1 = move-exception
                        goto L_0x008e
                    L_0x0072:
                        r1 = move-exception
                        goto L_0x0077
                    L_0x0074:
                        r1 = move-exception
                        goto L_0x0077
                    L_0x0076:
                        r1 = move-exception
                    L_0x0077:
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0070 }
                        r2.<init>()     // Catch:{ all -> 0x0070 }
                        java.lang.String r3 = "Error: Cannot load "
                        r2.append(r3)     // Catch:{ all -> 0x0070 }
                        r2.append(r9)     // Catch:{ all -> 0x0070 }
                        java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0070 }
                        java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0070 }
                        r2.<init>(r0, r1)     // Catch:{ all -> 0x0070 }
                        throw r2     // Catch:{ all -> 0x0070 }
                    L_0x008e:
                        if (r0 == 0) goto L_0x00ba
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        java.lang.String r3 = "Error when loading lib: "
                        r2.append(r3)
                        r2.append(r0)
                        java.lang.String r0 = " lib hash: "
                        r2.append(r0)
                        java.lang.String r9 = r8.getLibHash(r9)
                        r2.append(r9)
                        java.lang.String r9 = " search path is "
                        r2.append(r9)
                        r2.append(r10)
                        java.lang.String r9 = r2.toString()
                        java.lang.String r10 = "SoLoader"
                        android.util.Log.e(r10, r9)
                    L_0x00ba:
                        throw r1
                    L_0x00bb:
                        java.lang.System.load(r9)
                    L_0x00be:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.AnonymousClass1.load(java.lang.String, int):void");
                }

                private String getLibHash(String str) {
                    FileInputStream fileInputStream;
                    Throwable th;
                    try {
                        File file = new File(str);
                        MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_MD5);
                        fileInputStream = new FileInputStream(file);
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read > 0) {
                                instance.update(bArr, 0, read);
                            } else {
                                String format = String.format("%32x", new Object[]{new BigInteger(1, instance.digest())});
                                fileInputStream.close();
                                return format;
                            }
                        }
                    } catch (IOException e2) {
                        return e2.toString();
                    } catch (SecurityException e3) {
                        return e3.toString();
                    } catch (NoSuchAlgorithmException e4) {
                        return e4.toString();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            };
        }
    }

    private static Method getNativeLoadRuntimeMethod() {
        if (Build.VERSION.SDK_INT >= 23 && Build.VERSION.SDK_INT <= 27) {
            try {
                Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", new Class[]{String.class, ClassLoader.class, String.class});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException | SecurityException e2) {
                Log.w(TAG, "Cannot get nativeLoad method", e2);
            }
        }
        return null;
    }

    private static boolean checkIfSystemApp(Context context) {
        return (context == null || (context.getApplicationInfo().flags & 129) == 0) ? false : true;
    }

    public static void setInTestMode() {
        setSoSources(new SoSource[]{new NoopSoSource()});
    }

    public static void deinitForTest() {
        setSoSources((SoSource[]) null);
    }

    static void setSoSources(SoSource[] soSourceArr) {
        sSoSourcesLock.writeLock().lock();
        try {
            sSoSources = soSourceArr;
            sSoSourcesVersion++;
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    static void setSoFileLoader(SoFileLoader soFileLoader) {
        sSoFileLoader = soFileLoader;
    }

    static void resetStatus() {
        synchronized (SoLoader.class) {
            sLoadedLibraries.clear();
            sLoadingLibraries.clear();
            sSoFileLoader = null;
        }
        setSoSources((SoSource[]) null);
    }

    public static void setSystemLoadLibraryWrapper(SystemLoadLibraryWrapper systemLoadLibraryWrapper) {
        sSystemLoadLibraryWrapper = systemLoadLibraryWrapper;
    }

    public static final class WrongAbiError extends UnsatisfiedLinkError {
        WrongAbiError(Throwable th) {
            super("APK was built for a different platform");
            initCause(th);
        }
    }

    public static String getLibraryPath(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            String str2 = null;
            if (sSoSources != null) {
                int i = 0;
                while (str2 == null && i < sSoSources.length) {
                    str2 = sSoSources[i].getLibraryPath(str);
                    i++;
                }
            }
            return str2;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static boolean loadLibrary(String str) {
        return loadLibrary(str, 0);
    }

    public static boolean loadLibrary(String str, int i) throws UnsatisfiedLinkError {
        boolean z;
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    assertInitialized();
                } else {
                    synchronized (SoLoader.class) {
                        z = !sLoadedLibraries.contains(str);
                        if (z) {
                            if (sSystemLoadLibraryWrapper != null) {
                                sSystemLoadLibraryWrapper.loadLibrary(str);
                            } else {
                                System.loadLibrary(str);
                            }
                        }
                    }
                    sSoSourcesLock.readLock().unlock();
                    return z;
                }
            }
            sSoSourcesLock.readLock().unlock();
            if (isSystemApp) {
                SystemLoadLibraryWrapper systemLoadLibraryWrapper = sSystemLoadLibraryWrapper;
                if (systemLoadLibraryWrapper != null) {
                    systemLoadLibraryWrapper.loadLibrary(str);
                    return true;
                }
            }
            String mapLibName = MergedSoMapping.mapLibName(str);
            return loadLibraryBySoName(System.mapLibraryName(mapLibName != null ? mapLibName : str), str, mapLibName, i | 2, (StrictMode.ThreadPolicy) null);
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    static void loadLibraryBySoName(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        loadLibraryBySoName(str, (String) null, (String) null, i, threadPolicy);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
        if (r2 != false) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
        r0 = com.facebook.soloader.SoLoader.class;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0049, code lost:
        if (sLoadedLibraries.contains(r7) == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004b, code lost:
        if (r9 != null) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004d, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0050, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0052, code lost:
        if (r2 != false) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        android.util.Log.d(TAG, "About to load: " + r7);
        doLoadLibraryBySoName(r7, r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x006d, code lost:
        r11 = com.facebook.soloader.SoLoader.class;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        monitor-enter(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        android.util.Log.d(TAG, "Loaded: " + r7);
        sLoadedLibraries.add(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008b, code lost:
        monitor-exit(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0090, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0091, code lost:
        r8 = r7.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0095, code lost:
        if (r8 == null) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a4, code lost:
        throw new com.facebook.soloader.SoLoader.WrongAbiError(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00a5, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00a6, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ac, code lost:
        throw new java.lang.RuntimeException(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00b0, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00b4, code lost:
        if ((r10 & 16) != 0) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00ba, code lost:
        if (android.text.TextUtils.isEmpty(r8) != false) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00c2, code lost:
        if (sLoadedAndMergedLibraries.contains(r8) == false) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00c4, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00c5, code lost:
        if (r9 == null) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00c7, code lost:
        if (r1 != false) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00cb, code lost:
        if (SYSTRACE_LIBRARY_LOADING == false) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00cd, code lost:
        com.facebook.soloader.Api18TraceUtils.beginTraceSection("MergedSoMapping.invokeJniOnload[", r8, "]");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        android.util.Log.d(TAG, "About to merge: " + r8 + " / " + r7);
        com.facebook.soloader.MergedSoMapping.invokeJniOnload(r8);
        sLoadedAndMergedLibraries.add(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x00fc, code lost:
        if (SYSTRACE_LIBRARY_LOADING == false) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x00fe, code lost:
        com.facebook.soloader.Api18TraceUtils.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0102, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0105, code lost:
        if (SYSTRACE_LIBRARY_LOADING != false) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0107, code lost:
        com.facebook.soloader.Api18TraceUtils.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x010a, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x010b, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x010e, code lost:
        return !r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0110, code lost:
        throw r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean loadLibraryBySoName(java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, android.os.StrictMode.ThreadPolicy r11) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            r1 = 0
            if (r0 != 0) goto L_0x0010
            java.util.Set<java.lang.String> r0 = sLoadedAndMergedLibraries
            boolean r0 = r0.contains(r8)
            if (r0 == 0) goto L_0x0010
            return r1
        L_0x0010:
            java.lang.Class<com.facebook.soloader.SoLoader> r0 = com.facebook.soloader.SoLoader.class
            monitor-enter(r0)
            java.util.HashSet<java.lang.String> r2 = sLoadedLibraries     // Catch:{ all -> 0x0111 }
            boolean r2 = r2.contains(r7)     // Catch:{ all -> 0x0111 }
            r3 = 1
            if (r2 == 0) goto L_0x0022
            if (r9 != 0) goto L_0x0020
            monitor-exit(r0)     // Catch:{ all -> 0x0111 }
            return r1
        L_0x0020:
            r2 = 1
            goto L_0x0023
        L_0x0022:
            r2 = 0
        L_0x0023:
            java.util.Map<java.lang.String, java.lang.Object> r4 = sLoadingLibraries     // Catch:{ all -> 0x0111 }
            boolean r4 = r4.containsKey(r7)     // Catch:{ all -> 0x0111 }
            if (r4 == 0) goto L_0x0032
            java.util.Map<java.lang.String, java.lang.Object> r4 = sLoadingLibraries     // Catch:{ all -> 0x0111 }
            java.lang.Object r4 = r4.get(r7)     // Catch:{ all -> 0x0111 }
            goto L_0x003c
        L_0x0032:
            java.lang.Object r4 = new java.lang.Object     // Catch:{ all -> 0x0111 }
            r4.<init>()     // Catch:{ all -> 0x0111 }
            java.util.Map<java.lang.String, java.lang.Object> r5 = sLoadingLibraries     // Catch:{ all -> 0x0111 }
            r5.put(r7, r4)     // Catch:{ all -> 0x0111 }
        L_0x003c:
            monitor-exit(r0)     // Catch:{ all -> 0x0111 }
            monitor-enter(r4)
            if (r2 != 0) goto L_0x00b2
            java.lang.Class<com.facebook.soloader.SoLoader> r0 = com.facebook.soloader.SoLoader.class
            monitor-enter(r0)     // Catch:{ all -> 0x00b0 }
            java.util.HashSet<java.lang.String> r5 = sLoadedLibraries     // Catch:{ all -> 0x00ad }
            boolean r5 = r5.contains(r7)     // Catch:{ all -> 0x00ad }
            if (r5 == 0) goto L_0x0051
            if (r9 != 0) goto L_0x0050
            monitor-exit(r0)     // Catch:{ all -> 0x00ad }
            monitor-exit(r4)     // Catch:{ all -> 0x00b0 }
            return r1
        L_0x0050:
            r2 = 1
        L_0x0051:
            monitor-exit(r0)     // Catch:{ all -> 0x00ad }
            if (r2 != 0) goto L_0x00b2
            java.lang.String r0 = "SoLoader"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a6, UnsatisfiedLinkError -> 0x0090 }
            r5.<init>()     // Catch:{ IOException -> 0x00a6, UnsatisfiedLinkError -> 0x0090 }
            java.lang.String r6 = "About to load: "
            r5.append(r6)     // Catch:{ IOException -> 0x00a6, UnsatisfiedLinkError -> 0x0090 }
            r5.append(r7)     // Catch:{ IOException -> 0x00a6, UnsatisfiedLinkError -> 0x0090 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x00a6, UnsatisfiedLinkError -> 0x0090 }
            android.util.Log.d(r0, r5)     // Catch:{ IOException -> 0x00a6, UnsatisfiedLinkError -> 0x0090 }
            doLoadLibraryBySoName(r7, r10, r11)     // Catch:{ IOException -> 0x00a6, UnsatisfiedLinkError -> 0x0090 }
            java.lang.Class<com.facebook.soloader.SoLoader> r11 = com.facebook.soloader.SoLoader.class
            monitor-enter(r11)     // Catch:{ all -> 0x00b0 }
            java.lang.String r0 = "SoLoader"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            r5.<init>()     // Catch:{ all -> 0x008d }
            java.lang.String r6 = "Loaded: "
            r5.append(r6)     // Catch:{ all -> 0x008d }
            r5.append(r7)     // Catch:{ all -> 0x008d }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x008d }
            android.util.Log.d(r0, r5)     // Catch:{ all -> 0x008d }
            java.util.HashSet<java.lang.String> r0 = sLoadedLibraries     // Catch:{ all -> 0x008d }
            r0.add(r7)     // Catch:{ all -> 0x008d }
            monitor-exit(r11)     // Catch:{ all -> 0x008d }
            goto L_0x00b2
        L_0x008d:
            r7 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x008d }
            throw r7     // Catch:{ all -> 0x00b0 }
        L_0x0090:
            r7 = move-exception
            java.lang.String r8 = r7.getMessage()     // Catch:{ all -> 0x00b0 }
            if (r8 == 0) goto L_0x00a5
            java.lang.String r9 = "unexpected e_machine:"
            boolean r8 = r8.contains(r9)     // Catch:{ all -> 0x00b0 }
            if (r8 == 0) goto L_0x00a5
            com.facebook.soloader.SoLoader$WrongAbiError r8 = new com.facebook.soloader.SoLoader$WrongAbiError     // Catch:{ all -> 0x00b0 }
            r8.<init>(r7)     // Catch:{ all -> 0x00b0 }
            throw r8     // Catch:{ all -> 0x00b0 }
        L_0x00a5:
            throw r7     // Catch:{ all -> 0x00b0 }
        L_0x00a6:
            r7 = move-exception
            java.lang.RuntimeException r8 = new java.lang.RuntimeException     // Catch:{ all -> 0x00b0 }
            r8.<init>(r7)     // Catch:{ all -> 0x00b0 }
            throw r8     // Catch:{ all -> 0x00b0 }
        L_0x00ad:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ad }
            throw r7     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            r7 = move-exception
            goto L_0x010f
        L_0x00b2:
            r10 = r10 & 16
            if (r10 != 0) goto L_0x010b
            boolean r10 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00b0 }
            if (r10 != 0) goto L_0x00c5
            java.util.Set<java.lang.String> r10 = sLoadedAndMergedLibraries     // Catch:{ all -> 0x00b0 }
            boolean r10 = r10.contains(r8)     // Catch:{ all -> 0x00b0 }
            if (r10 == 0) goto L_0x00c5
            r1 = 1
        L_0x00c5:
            if (r9 == 0) goto L_0x010b
            if (r1 != 0) goto L_0x010b
            boolean r9 = SYSTRACE_LIBRARY_LOADING     // Catch:{ all -> 0x00b0 }
            if (r9 == 0) goto L_0x00d4
            java.lang.String r9 = "MergedSoMapping.invokeJniOnload["
            java.lang.String r10 = "]"
            com.facebook.soloader.Api18TraceUtils.beginTraceSection(r9, r8, r10)     // Catch:{ all -> 0x00b0 }
        L_0x00d4:
            java.lang.String r9 = "SoLoader"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0102 }
            r10.<init>()     // Catch:{ all -> 0x0102 }
            java.lang.String r11 = "About to merge: "
            r10.append(r11)     // Catch:{ all -> 0x0102 }
            r10.append(r8)     // Catch:{ all -> 0x0102 }
            java.lang.String r11 = " / "
            r10.append(r11)     // Catch:{ all -> 0x0102 }
            r10.append(r7)     // Catch:{ all -> 0x0102 }
            java.lang.String r7 = r10.toString()     // Catch:{ all -> 0x0102 }
            android.util.Log.d(r9, r7)     // Catch:{ all -> 0x0102 }
            com.facebook.soloader.MergedSoMapping.invokeJniOnload(r8)     // Catch:{ all -> 0x0102 }
            java.util.Set<java.lang.String> r7 = sLoadedAndMergedLibraries     // Catch:{ all -> 0x0102 }
            r7.add(r8)     // Catch:{ all -> 0x0102 }
            boolean r7 = SYSTRACE_LIBRARY_LOADING     // Catch:{ all -> 0x00b0 }
            if (r7 == 0) goto L_0x010b
            com.facebook.soloader.Api18TraceUtils.endSection()     // Catch:{ all -> 0x00b0 }
            goto L_0x010b
        L_0x0102:
            r7 = move-exception
            boolean r8 = SYSTRACE_LIBRARY_LOADING     // Catch:{ all -> 0x00b0 }
            if (r8 == 0) goto L_0x010a
            com.facebook.soloader.Api18TraceUtils.endSection()     // Catch:{ all -> 0x00b0 }
        L_0x010a:
            throw r7     // Catch:{ all -> 0x00b0 }
        L_0x010b:
            monitor-exit(r4)     // Catch:{ all -> 0x00b0 }
            r7 = r2 ^ 1
            return r7
        L_0x010f:
            monitor-exit(r4)     // Catch:{ all -> 0x00b0 }
            throw r7
        L_0x0111:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0111 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.loadLibraryBySoName(java.lang.String, java.lang.String, java.lang.String, int, android.os.StrictMode$ThreadPolicy):boolean");
    }

    public static File unpackLibraryAndDependencies(String str) throws UnsatisfiedLinkError {
        assertInitialized();
        try {
            return unpackLibraryBySoName(System.mapLibraryName(str));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: finally extract failed */
    private static void doLoadLibraryBySoName(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        boolean z;
        boolean z2;
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources != null) {
                sSoSourcesLock.readLock().unlock();
                if (threadPolicy == null) {
                    threadPolicy = StrictMode.allowThreadDiskReads();
                    z = true;
                } else {
                    z = false;
                }
                if (SYSTRACE_LIBRARY_LOADING) {
                    Api18TraceUtils.beginTraceSection("SoLoader.loadLibrary[", str, "]");
                }
                int i2 = 0;
                do {
                    try {
                        sSoSourcesLock.readLock().lock();
                        int i3 = sSoSourcesVersion;
                        int i4 = 0;
                        while (true) {
                            if (i2 == 0) {
                                if (i4 >= sSoSources.length) {
                                    break;
                                }
                                i2 = sSoSources[i4].loadLibrary(str, i, threadPolicy);
                                if (i2 == 3 && sBackupSoSources != null) {
                                    Log.d(TAG, "Trying backup SoSource for " + str);
                                    UnpackingSoSource[] unpackingSoSourceArr = sBackupSoSources;
                                    int length = unpackingSoSourceArr.length;
                                    int i5 = 0;
                                    while (true) {
                                        if (i5 >= length) {
                                            break;
                                        }
                                        UnpackingSoSource unpackingSoSource = unpackingSoSourceArr[i5];
                                        unpackingSoSource.prepare(str);
                                        int loadLibrary = unpackingSoSource.loadLibrary(str, i, threadPolicy);
                                        if (loadLibrary == 1) {
                                            i2 = loadLibrary;
                                            break;
                                        }
                                        i5++;
                                    }
                                } else {
                                    i4++;
                                }
                            } else {
                                break;
                            }
                        }
                        sSoSourcesLock.readLock().unlock();
                        if ((i & 2) == 2 && i2 == 0) {
                            sSoSourcesLock.writeLock().lock();
                            if (sApplicationSoSource != null && sApplicationSoSource.checkAndMaybeUpdate()) {
                                sSoSourcesVersion++;
                            }
                            z2 = sSoSourcesVersion != i3;
                            sSoSourcesLock.writeLock().unlock();
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                    } catch (Throwable th) {
                        if (SYSTRACE_LIBRARY_LOADING) {
                            Api18TraceUtils.endSection();
                        }
                        if (z) {
                            StrictMode.setThreadPolicy(threadPolicy);
                        }
                        if (i2 == 0 || i2 == 3) {
                            String str2 = "couldn't find DSO to load: " + str;
                            Log.e(TAG, str2);
                            throw new UnsatisfiedLinkError(str2);
                        }
                        throw th;
                    }
                } while (z2);
                if (SYSTRACE_LIBRARY_LOADING) {
                    Api18TraceUtils.endSection();
                }
                if (z) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                if (i2 == 0 || i2 == 3) {
                    String str3 = "couldn't find DSO to load: " + str;
                    Log.e(TAG, str3);
                    throw new UnsatisfiedLinkError(str3);
                }
                return;
            }
            Log.e(TAG, "Could not load: " + str + " because no SO source exists");
            throw new UnsatisfiedLinkError("couldn't find DSO to load: " + str);
        } catch (Throwable th2) {
            sSoSourcesLock.readLock().unlock();
            throw th2;
        }
    }

    public static String makeNonZipPath(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            if (!str2.contains("!")) {
                arrayList.add(str2);
            }
        }
        return TextUtils.join(":", arrayList);
    }

    static File unpackLibraryBySoName(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        int i = 0;
        while (i < sSoSources.length) {
            try {
                File unpackLibrary = sSoSources[i].unpackLibrary(str);
                if (unpackLibrary != null) {
                    return unpackLibrary;
                }
                i++;
            } finally {
                sSoSourcesLock.readLock().unlock();
            }
        }
        sSoSourcesLock.readLock().unlock();
        throw new FileNotFoundException(str);
    }

    private static void assertInitialized() {
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources == null) {
                throw new RuntimeException("SoLoader.init() not yet called");
            }
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static void prependSoSource(SoSource soSource) throws IOException {
        sSoSourcesLock.writeLock().lock();
        try {
            Log.d(TAG, "Prepending to SO sources: " + soSource);
            assertInitialized();
            soSource.prepare(makePrepareFlags());
            SoSource[] soSourceArr = new SoSource[(sSoSources.length + 1)];
            soSourceArr[0] = soSource;
            System.arraycopy(sSoSources, 0, soSourceArr, 1, sSoSources.length);
            sSoSources = soSourceArr;
            sSoSourcesVersion++;
            Log.d(TAG, "Prepended to SO sources: " + soSource);
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    public static String makeLdLibraryPath() {
        sSoSourcesLock.readLock().lock();
        try {
            assertInitialized();
            Log.d(TAG, "makeLdLibraryPath");
            ArrayList arrayList = new ArrayList();
            SoSource[] soSourceArr = sSoSources;
            for (SoSource addToLdLibraryPath : soSourceArr) {
                addToLdLibraryPath.addToLdLibraryPath(arrayList);
            }
            String join = TextUtils.join(":", arrayList);
            Log.d(TAG, "makeLdLibraryPath final path: " + join);
            return join;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static boolean areSoSourcesAbisSupported() {
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources != null) {
                String[] supportedAbis = SysUtil.getSupportedAbis();
                for (SoSource soSourceAbis : sSoSources) {
                    String[] soSourceAbis2 = soSourceAbis.getSoSourceAbis();
                    int i = 0;
                    while (i < soSourceAbis2.length) {
                        boolean z = false;
                        for (int i2 = 0; i2 < supportedAbis.length && !z; i2++) {
                            z = soSourceAbis2[i].equals(supportedAbis[i2]);
                        }
                        if (!z) {
                            Log.e(TAG, "abi not supported: " + soSourceAbis2[i]);
                        } else {
                            i++;
                        }
                    }
                }
                sSoSourcesLock.readLock().unlock();
                return true;
            }
            return false;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    @DoNotOptimize
    @TargetApi(14)
    private static class Api14Utils {
        private Api14Utils() {
        }

        public static String getClassLoaderLdLoadLibrary() {
            ClassLoader classLoader = SoLoader.class.getClassLoader();
            if (classLoader instanceof BaseDexClassLoader) {
                try {
                    return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
                } catch (Exception e2) {
                    throw new RuntimeException("Cannot call getLdLibraryPath", e2);
                }
            } else {
                throw new IllegalStateException("ClassLoader " + classLoader.getClass().getName() + " should be of type BaseDexClassLoader");
            }
        }
    }
}
