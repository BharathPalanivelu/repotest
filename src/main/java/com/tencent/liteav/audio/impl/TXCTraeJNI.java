package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.audio.impl.Play.TXCAudioBasePlayController;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
import java.lang.ref.WeakReference;

public class TXCTraeJNI {
    private static Context mContext;
    private static WeakReference<d> mTraeRecordListener;

    public static native void nativeAppendLibraryPath(String str);

    public static native void nativeCacheClassForNative();

    public static native void nativeSetAudioMode(int i);

    public static native void nativeSetEncBitRate(int i);

    public static native void nativeSetEncFrameLenMs(int i);

    public static native void nativeSetEncInfo(int i, int i2);

    public static native void nativeSetFecRatio(float f2);

    public static native void nativeSetTraeConfig(String str);

    public static native int nativeTraeGetVolumeLevel();

    public static native boolean nativeTraeIsPlaying();

    public static native boolean nativeTraeIsRecording();

    public static native void nativeTraeSetChangerType(int i, int i2);

    public static native void nativeTraeSetEnableVolumeLevel(boolean z);

    public static native void nativeTraeSetRecordMute(boolean z);

    public static native void nativeTraeSetRecordReverb(int i);

    public static native void nativeTraeSetVolume(float f2);

    private static native void nativeTraeStartPlay(Context context);

    public static native void nativeTraeStartRecord(Context context, int i, int i2, int i3, int i4, int i5);

    private static native void nativeTraeStopPlay();

    public static native void nativeTraeStopRecord(boolean z);

    static {
        b.f();
        nativeCacheClassForNative();
    }

    public static void setContext(Context context) {
        mContext = context;
    }

    public static void setTraeRecordListener(WeakReference<d> weakReference) {
        mTraeRecordListener = weakReference;
    }

    public static void onRecordRawPcmData(byte[] bArr, int i, int i2, int i3) {
        WeakReference<d> weakReference = mTraeRecordListener;
        if (weakReference != null && weakReference.get() != null) {
            ((d) mTraeRecordListener.get()).a(bArr, TXCTimeUtil.getTimeTick(), i, i2, i3, false);
        }
    }

    public static void onRecordPcmData(byte[] bArr, int i, int i2, int i3) {
        WeakReference<d> weakReference = mTraeRecordListener;
        if (weakReference != null && weakReference.get() != null) {
            ((d) mTraeRecordListener.get()).a(bArr, TXCTimeUtil.getTimeTick(), i, i2, i3);
        }
    }

    public static void onRecordEncData(byte[] bArr, long j, int i, int i2, int i3) {
        WeakReference<d> weakReference = mTraeRecordListener;
        if (weakReference != null && weakReference.get() != null) {
            ((d) mTraeRecordListener.get()).b(bArr, j, i, i2, i3);
        }
    }

    public static void onRecordError(int i, String str) {
        TXCLog.e("TXCAudioJNI", "trae audio record error: " + i + ", " + str);
        WeakReference<d> weakReference = mTraeRecordListener;
        if (weakReference != null && weakReference.get() != null) {
            ((d) mTraeRecordListener.get()).a(i, str);
        }
    }

    public static void SetAudioMode(int i) {
        a.a().b(i);
    }

    public static void InitTraeEngineLibrary(Context context) {
        if (context == null) {
            TXCLog.e("TXCAudioJNI", "nativeInitTraeEngine failed, context is null!");
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String str = applicationInfo.nativeLibraryDir;
            String str2 = applicationInfo.dataDir + "/lib";
            nativeAppendLibraryPath("add_libpath:" + str);
            nativeAppendLibraryPath("add_libpath:" + str2);
            nativeAppendLibraryPath("add_libpath:" + ("/data/data/" + applicationInfo.packageName + "/lib"));
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0125 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean nativeCheckTraeEngine(android.content.Context r10) {
        /*
            java.lang.String r0 = "TXCAudioJNI"
            r1 = 0
            if (r10 != 0) goto L_0x000b
            java.lang.String r10 = "nativeCheckTraeEngine failed, context is null!"
            com.tencent.liteav.basic.log.TXCLog.e(r0, r10)
            return r1
        L_0x000b:
            android.content.pm.ApplicationInfo r10 = r10.getApplicationInfo()
            java.lang.String r2 = r10.nativeLibraryDir
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r10.dataDir
            r3.append(r4)
            java.lang.String r4 = "/lib"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "/data/data/"
            r5.append(r6)
            java.lang.String r10 = r10.packageName
            r5.append(r10)
            r5.append(r4)
            java.lang.String r10 = r5.toString()
            java.lang.String r4 = com.tencent.liteav.basic.util.b.g()
            if (r4 != 0) goto L_0x0042
            java.lang.String r4 = ""
        L_0x0042:
            java.lang.String r5 = "/libTRAECodec.so"
            java.lang.String r6 = "/libtraeimp-rtmp.so"
            java.io.File r7 = new java.io.File
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r2)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            boolean r7 = r7.exists()
            r8 = 1
            if (r7 == 0) goto L_0x0063
        L_0x0061:
            r5 = 1
            goto L_0x00b5
        L_0x0063:
            java.io.File r7 = new java.io.File
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r3)
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            r7.<init>(r9)
            boolean r7 = r7.exists()
            if (r7 == 0) goto L_0x007e
            goto L_0x0061
        L_0x007e:
            java.io.File r7 = new java.io.File
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r10)
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            r7.<init>(r9)
            boolean r7 = r7.exists()
            if (r7 == 0) goto L_0x0099
            goto L_0x0061
        L_0x0099:
            java.io.File r7 = new java.io.File
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r4)
            r9.append(r5)
            java.lang.String r5 = r9.toString()
            r7.<init>(r5)
            boolean r5 = r7.exists()
            if (r5 == 0) goto L_0x00b4
            goto L_0x0061
        L_0x00b4:
            r5 = 0
        L_0x00b5:
            java.io.File r7 = new java.io.File
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r2)
            r9.append(r6)
            java.lang.String r2 = r9.toString()
            r7.<init>(r2)
            boolean r2 = r7.exists()
            if (r2 == 0) goto L_0x00d1
        L_0x00cf:
            r10 = 1
            goto L_0x0123
        L_0x00d1:
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r3)
            r7.append(r6)
            java.lang.String r3 = r7.toString()
            r2.<init>(r3)
            boolean r2 = r2.exists()
            if (r2 == 0) goto L_0x00ec
            goto L_0x00cf
        L_0x00ec:
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r10)
            r3.append(r6)
            java.lang.String r10 = r3.toString()
            r2.<init>(r10)
            boolean r10 = r2.exists()
            if (r10 == 0) goto L_0x0107
            goto L_0x00cf
        L_0x0107:
            java.io.File r10 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r10.<init>(r2)
            boolean r10 = r10.exists()
            if (r10 == 0) goto L_0x0122
            goto L_0x00cf
        L_0x0122:
            r10 = 0
        L_0x0123:
            if (r5 == 0) goto L_0x0128
            if (r10 == 0) goto L_0x0128
            return r8
        L_0x0128:
            java.lang.String r10 = "nativeCheckTraeEngine failed, can not find trae libs !"
            com.tencent.liteav.basic.log.TXCLog.e(r0, r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio.impl.TXCTraeJNI.nativeCheckTraeEngine(android.content.Context):boolean");
    }

    public static boolean traeStartPlay(Context context) {
        if (TXCAudioBasePlayController.nativeIsTracksEmpty() && !TXCLiveBGMPlayer.getInstance().isPlaying()) {
            return false;
        }
        InitTraeEngineLibrary(context);
        nativeTraeStartPlay(context);
        return true;
    }

    public static boolean traeStopPlay() {
        if (!TXCAudioBasePlayController.nativeIsTracksEmpty() || TXCLiveBGMPlayer.getInstance().isPlaying()) {
            return false;
        }
        nativeTraeStopPlay();
        return true;
    }
}
