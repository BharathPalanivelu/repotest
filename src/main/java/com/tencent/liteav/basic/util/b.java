package com.tencent.liteav.basic.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.media.MediaFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ugc.TXRecordCommon;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.UUID;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static long f31419a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static float f31420b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    private static float f31421c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    private static float f31422d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    private static float f31423e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private static float f31424f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private static float f31425g = 0.0f;
    private static boolean h = true;
    private static int[] i = new int[2];
    private static long j = 0;
    private static String k = "";
    private static int l = 0;
    private static long m = 0;
    private static final Object n = new Object();
    private static boolean o = false;
    private static int[] p = {96000, 88200, 64000, 48000, TXRecordCommon.AUDIO_SAMPLERATE_44100, TXRecordCommon.AUDIO_SAMPLERATE_32000, 24000, 22050, TXRecordCommon.AUDIO_SAMPLERATE_16000, 12000, 11025, TXRecordCommon.AUDIO_SAMPLERATE_8000, 7350};

    private static long h() {
        try {
            int myPid = Process.myPid();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + myPid + "/stat")), 1000);
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            String[] split = readLine.split(SQLBuilder.BLANK);
            if (split == null || TextUtils.isEmpty(split[13])) {
                return 0;
            }
            return Long.parseLong(split[13]) + Long.parseLong(split[14]) + Long.parseLong(split[15]) + Long.parseLong(split[16]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void i() {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r3 = 26
            if (r0 >= r3) goto L_0x007e
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0078 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0078 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0078 }
            java.lang.String r5 = "/proc/stat"
            r4.<init>(r5)     // Catch:{ Exception -> 0x0078 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0078 }
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.<init>(r3, r4)     // Catch:{ Exception -> 0x0078 }
            java.lang.String r3 = r0.readLine()     // Catch:{ Exception -> 0x0078 }
            r0.close()     // Catch:{ Exception -> 0x0078 }
            java.lang.String r0 = " "
            java.lang.String[] r0 = r3.split(r0)     // Catch:{ Exception -> 0x0078 }
            if (r0 == 0) goto L_0x007e
            int r3 = r0.length     // Catch:{ Exception -> 0x0078 }
            r4 = 9
            if (r3 < r4) goto L_0x007e
            r3 = 2
            r3 = r0[r3]     // Catch:{ Exception -> 0x0078 }
            long r3 = java.lang.Long.parseLong(r3)     // Catch:{ Exception -> 0x0078 }
            r5 = 3
            r5 = r0[r5]     // Catch:{ Exception -> 0x0078 }
            long r5 = java.lang.Long.parseLong(r5)     // Catch:{ Exception -> 0x0078 }
            long r3 = r3 + r5
            r5 = 4
            r5 = r0[r5]     // Catch:{ Exception -> 0x0078 }
            long r5 = java.lang.Long.parseLong(r5)     // Catch:{ Exception -> 0x0078 }
            long r3 = r3 + r5
            r5 = 6
            r6 = r0[r5]     // Catch:{ Exception -> 0x0078 }
            long r6 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x0078 }
            long r3 = r3 + r6
            r6 = 5
            r7 = r0[r6]     // Catch:{ Exception -> 0x0078 }
            long r7 = java.lang.Long.parseLong(r7)     // Catch:{ Exception -> 0x0078 }
            long r3 = r3 + r7
            r7 = 7
            r7 = r0[r7]     // Catch:{ Exception -> 0x0078 }
            long r7 = java.lang.Long.parseLong(r7)     // Catch:{ Exception -> 0x0078 }
            long r3 = r3 + r7
            r7 = 8
            r7 = r0[r7]     // Catch:{ Exception -> 0x0078 }
            long r7 = java.lang.Long.parseLong(r7)     // Catch:{ Exception -> 0x0078 }
            long r3 = r3 + r7
            r6 = r0[r6]     // Catch:{ Exception -> 0x0076 }
            long r6 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x0076 }
            r0 = r0[r5]     // Catch:{ Exception -> 0x0076 }
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x0076 }
            long r6 = r6 + r0
            r1 = r6
            goto L_0x007f
        L_0x0076:
            r0 = move-exception
            goto L_0x007a
        L_0x0078:
            r0 = move-exception
            r3 = r1
        L_0x007a:
            r0.printStackTrace()
            goto L_0x007f
        L_0x007e:
            r3 = r1
        L_0x007f:
            boolean r0 = h
            if (r0 == 0) goto L_0x008a
            float r0 = (float) r3
            f31420b = r0
            float r0 = (float) r1
            f31424f = r0
            goto L_0x0090
        L_0x008a:
            float r0 = (float) r3
            f31421c = r0
            float r0 = (float) r1
            f31425g = r0
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.basic.util.b.i():void");
    }

    public static int[] a() {
        float f2;
        if (j != 0 && TXCTimeUtil.getTimeTick() - j < 2000) {
            return i;
        }
        int[] iArr = new int[2];
        if (h) {
            f31422d = (float) h();
            i();
            h = false;
            iArr[0] = 0;
            iArr[1] = 0;
            return iArr;
        }
        f31423e = (float) h();
        i();
        float f3 = f31421c;
        float f4 = f31420b;
        float f5 = BitmapDescriptorFactory.HUE_RED;
        if (f3 != f4) {
            f5 = ((f31423e - f31422d) * 100.0f) / (f3 - f4);
            f2 = (((f3 - f4) - (f31425g - f31424f)) * 100.0f) / (f3 - f4);
        } else {
            f2 = BitmapDescriptorFactory.HUE_RED;
        }
        f31420b = f31421c;
        f31422d = f31423e;
        f31424f = f31425g;
        iArr[0] = (int) (f5 * 10.0f);
        iArr[1] = (int) (f2 * 10.0f);
        int[] iArr2 = i;
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        j = TXCTimeUtil.getTimeTick();
        return iArr;
    }

    public static int b() {
        try {
            if (m != 0 && TXCTimeUtil.getTimeTick() - m < 10000) {
                return l;
            }
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            int totalPss = memoryInfo.getTotalPss();
            m = TXCTimeUtil.getTimeTick();
            l = totalPss / 1024;
            return l;
        } catch (Exception unused) {
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager.getRunningTasks(1) == null) {
                TXCLog.e("TXCSystemUtil", "running task is null, ams is abnormal!!!");
                return false;
            }
            ActivityManager.RunningTaskInfo runningTaskInfo = activityManager.getRunningTasks(1).get(0);
            if (runningTaskInfo != null) {
                if (runningTaskInfo.topActivity != null) {
                    return !runningTaskInfo.topActivity.getPackageName().equals(context.getPackageName());
                }
            }
            TXCLog.e("TXCSystemUtil", "failed to get RunningTaskInfo");
            return false;
        } catch (Exception unused) {
        }
    }

    public static String b(Context context) {
        return TXCDRApi.getSimulateIDFA(context);
    }

    public static String c(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public static int d(Context context) {
        if (context == null) {
            return 0;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return 0;
        }
        if (activeNetworkInfo.getType() == 9) {
            return 5;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 1;
        }
        if (activeNetworkInfo.getType() != 0) {
            return 0;
        }
        switch (telephonyManager.getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 4;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            default:
                return 2;
        }
    }

    public static String c() {
        return Build.MODEL;
    }

    public static String d() {
        return Build.VERSION.RELEASE;
    }

    public static String e() {
        return UUID.randomUUID().toString();
    }

    public static String e(Context context) {
        return TXCDRApi.getDevUUID(context, TXCDRApi.getSimulateIDFA(context));
    }

    public static void a(WeakReference<a> weakReference, String str, int i2, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("EVT_USERID", str);
        bundle.putInt("EVT_ID", i2);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (str2 != null) {
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str2);
        }
        a(weakReference, i2, bundle);
    }

    public static void a(WeakReference<a> weakReference, int i2, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("EVT_ID", i2);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (str != null) {
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        }
        a(weakReference, i2, bundle);
    }

    public static void a(WeakReference<a> weakReference, int i2, Bundle bundle) {
        if (weakReference != null) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.onNotifyEvent(i2, bundle);
            }
        }
    }

    public static void a(WeakReference<a> weakReference, String str, int i2, Bundle bundle) {
        if (weakReference != null) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                bundle.putString("EVT_USERID", str);
                aVar.onNotifyEvent(i2, bundle);
            }
        }
    }

    public static com.tencent.liteav.basic.d.a a(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i2 * i5;
        int i9 = i3 * i4;
        if (i8 >= i9) {
            i7 = i9 / i5;
            i6 = i3;
        } else {
            i6 = i8 / i4;
            i7 = i2;
        }
        int i10 = 0;
        int i11 = i2 > i7 ? (i2 - i7) >> 1 : 0;
        if (i3 > i6) {
            i10 = (i3 - i6) >> 1;
        }
        return new com.tencent.liteav.basic.d.a(i11, i10, i7, i6);
    }

    public static boolean f() {
        boolean z;
        synchronized (n) {
            if (!o) {
                a("stlport_shared");
                a("saturn");
                a("txffmpeg");
                o = a("liteavsdk");
                Log.w("NativeLoad", "load library success " + o);
            }
            z = o;
        }
        return z;
    }

    public static boolean a(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (Error e2) {
            Log.d("NativeLoad", "load library : " + e2.toString());
            return b(k, str);
        } catch (Exception e3) {
            Log.d("NativeLoad", "load library : " + e3.toString());
            return b(k, str);
        }
    }

    private static boolean b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            System.load(str + "/lib" + str2 + ".so");
            return true;
        } catch (Error e2) {
            Log.d("NativeLoad", "load library : " + e2.toString());
            return false;
        } catch (Exception e3) {
            Log.d("NativeLoad", "load library : " + e3.toString());
            return false;
        }
    }

    public static void b(String str) {
        k = str;
    }

    public static String g() {
        return k;
    }

    public static int a(int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = p;
            if (i3 < iArr.length && iArr[i3] != i2) {
                i3++;
            }
        }
        if (i3 >= p.length) {
            return -1;
        }
        return i3;
    }

    @TargetApi(16)
    public static MediaFormat a(int i2, int i3, int i4) {
        int a2 = a(i2);
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.put(0, (byte) ((i4 << 3) | (a2 >> 1)));
        allocate.put(1, (byte) (((a2 & 1) << 7) | (i3 << 3)));
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i2, i3);
        createAudioFormat.setInteger("channel-count", i3);
        createAudioFormat.setInteger("sample-rate", i2);
        createAudioFormat.setByteBuffer("csd-0", allocate);
        return createAudioFormat;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x005c A[SYNTHETIC, Splitter:B:34:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x006d A[SYNTHETIC, Splitter:B:43:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x007b
            if (r5 != 0) goto L_0x0007
            goto L_0x007b
        L_0x0007:
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            boolean r2 = r2.exists()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            if (r2 != 0) goto L_0x0014
            return r0
        L_0x0014:
            android.media.MediaMetadataRetriever r2 = new android.media.MediaMetadataRetriever     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r2.<init>()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r2.setDataSource(r4)     // Catch:{ Exception -> 0x0050 }
            android.graphics.Bitmap r4 = r2.getFrameAtTime()     // Catch:{ Exception -> 0x0050 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0050 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x0050 }
            boolean r5 = r3.exists()     // Catch:{ Exception -> 0x0050 }
            if (r5 == 0) goto L_0x002e
            r3.delete()     // Catch:{ Exception -> 0x0050 }
        L_0x002e:
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0050 }
            r5.<init>(r3)     // Catch:{ Exception -> 0x0050 }
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            r3 = 100
            r4.compress(r1, r3, r5)     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            r5.flush()     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            r5.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0045:
            r2.release()
            r4 = 1
            return r4
        L_0x004a:
            r4 = move-exception
            r1 = r5
            goto L_0x006b
        L_0x004d:
            r4 = move-exception
            r1 = r5
            goto L_0x0057
        L_0x0050:
            r4 = move-exception
            goto L_0x0057
        L_0x0052:
            r4 = move-exception
            r2 = r1
            goto L_0x006b
        L_0x0055:
            r4 = move-exception
            r2 = r1
        L_0x0057:
            r4.printStackTrace()     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0064
            r1.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0064:
            if (r2 == 0) goto L_0x0069
            r2.release()
        L_0x0069:
            return r0
        L_0x006a:
            r4 = move-exception
        L_0x006b:
            if (r1 == 0) goto L_0x0075
            r1.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0075:
            if (r2 == 0) goto L_0x007a
            r2.release()
        L_0x007a:
            throw r4
        L_0x007b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.basic.util.b.a(java.lang.String, java.lang.String):boolean");
    }

    private static void a(String str, MediaFormat mediaFormat, byte[] bArr, int i2, int i3) {
        int i4 = i3 - i2;
        ByteBuffer allocate = ByteBuffer.allocate(i4);
        allocate.put(bArr, i2, i4);
        allocate.position(0);
        mediaFormat.setByteBuffer(str, allocate);
    }

    @TargetApi(16)
    public static MediaFormat a(byte[] bArr, int i2, int i3) {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i2, i3);
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        boolean z2 = false;
        int i6 = 0;
        while (true) {
            int i7 = i4 + 3;
            if (i7 < bArr.length) {
                int i8 = (bArr[i4] == 0 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 1) ? 3 : 0;
                if (bArr[i4] == 0 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 0 && bArr[i7] == 1) {
                    i8 = 4;
                }
                if (i8 > 0) {
                    if (i5 == 0) {
                        i4 += i8;
                        i5 = i8;
                    } else {
                        byte b2 = bArr[i5] & 31;
                        if (b2 == 7) {
                            a("csd-0", createVideoFormat, bArr, i5, i4);
                            z = true;
                        } else if (b2 == 8) {
                            a("csd-1", createVideoFormat, bArr, i5, i4);
                            z2 = true;
                        }
                        i5 = i4 + i8;
                        if (z && z2) {
                            return createVideoFormat;
                        }
                        i6 = i4;
                        i4 = i5;
                    }
                }
                i4++;
            } else {
                byte b3 = bArr[i5] & 31;
                if (z && b3 == 8) {
                    a("csd-1", createVideoFormat, bArr, i5, i6);
                    return createVideoFormat;
                } else if (!z2 || b3 != 7) {
                    return null;
                } else {
                    a("csd-0", createVideoFormat, bArr, i5, i6);
                    return createVideoFormat;
                }
            }
        }
    }
}
