package cn.tongdun.android.core;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.util.Base64;
import cn.tongdun.android.core.oo0ooo0o00o0xo.o0o0xxox;
import cn.tongdun.android.core.oo0ooo0o00o0xo.xo0xo0x0oox000oxox0;
import cn.tongdun.android.core.oo0ooo0o00o0xo.xoxx0xx;
import cn.tongdun.android.core.xo00x00xo00.oo0ooo0o00o0xo;
import cn.tongdun.android.shell.FMAgent;
import cn.tongdun.android.shell.common.CollectorError;
import cn.tongdun.android.shell.common.HelperJNI;
import cn.tongdun.android.shell.utils.BoxUtil;
import cn.tongdun.android.shell.utils.LogUtil;
import org.json.JSONObject;

public class o00xxox0x0xoox {
    public static long o00xxox0x0xoox = 0;
    private static Context o0oo0xx00ooo0oox0xx0 = null;
    public static String oo0ooo0o00o0xo = "";
    private String o00o0o0oo0oo0o000x00 = "";
    private long o00xx0xx0ooooo0xx00 = 0;
    private boolean ooxoxoooxooo0xx00 = false;
    private long x0000xo0x0oooooo0 = 0;
    private xoxx0xx x0ox00x0oooo0xxx;
    private boolean xo00x00xo00 = false;
    private String xoo0xoo0oxo00x0o0;

    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02dc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02de, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
        r1.ooxoxoooxooo0xx00 = true;
        cn.tongdun.android.shell.FMAgent.mStatus = cn.tongdun.android.shell.FMAgent.STATUS_FAILED;
        cn.tongdun.android.shell.common.CollectorError.addError(cn.tongdun.android.shell.common.CollectorError.TYPE.ERROR_PROFILE_FAILED, cn.tongdun.android.shell.common.CollectorError.catchErr(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02ef, code lost:
        r1.x0000xo0x0oooooo0 = java.lang.System.currentTimeMillis() - r1.o00xx0xx0ooooo0xx00;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02f8, code lost:
        if (r26 != null) goto L_0x02fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02fa, code lost:
        r26.countDown();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02fd, code lost:
        if (r6 != null) goto L_0x02ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02ff, code lost:
        r6.unregisterListener(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0304, code lost:
        if (cn.tongdun.android.shell.FMAgent.mfmCallBack == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0334, code lost:
        r1.x0000xo0x0oooooo0 = java.lang.System.currentTimeMillis() - r1.o00xx0xx0ooooo0xx00;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x033d, code lost:
        if (r26 != null) goto L_0x033f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x033f, code lost:
        r26.countDown();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0342, code lost:
        if (r6 != null) goto L_0x0344;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0344, code lost:
        r6.unregisterListener(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0349, code lost:
        if (cn.tongdun.android.shell.FMAgent.mfmCallBack != null) goto L_0x034b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x034b, code lost:
        cn.tongdun.android.shell.FMAgent.mfmCallBack.onEvent(o00xxox0x0xoox(r17));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0354, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0211, code lost:
        r0 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0228, code lost:
        r0 = r3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x02de A[ExcHandler: Throwable (r0v4 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:10:0x0075] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:62:0x01a7=Splitter:B:62:0x01a7, B:79:0x022b=Splitter:B:79:0x022b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o00xxox0x0xoox(android.content.Context r17, java.lang.String r18, java.lang.String r19, boolean r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, boolean r24, boolean r25, java.util.concurrent.CountDownLatch r26, java.lang.String r27, int r28, java.lang.String r29, java.lang.String r30, boolean r31) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            java.lang.String r0 = ""
            long r3 = java.lang.System.currentTimeMillis()
            r5 = 0
            r1.xo00x00xo00 = r5
            cn.tongdun.android.core.oo0ooo0o00o0xo.xoxx0xx r6 = cn.tongdun.android.core.oo0ooo0o00o0xo.xoxx0xx.o00xxox0x0xoox((android.content.Context) r17)
            r1.x0ox00x0oooo0xxx = r6
            o0oo0xx00ooo0oox0xx0 = r2
            java.lang.String r6 = cn.tongdun.android.shell.FMAgent.STATUS_COLLECTING
            cn.tongdun.android.shell.FMAgent.mStatus = r6
            cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.oo0ooo0o00o0xo = r18
            cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.ooxoxoooxooo0xx00 = r20
            cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.x0ox00x0oooo0xxx = r21
            cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.o00xx0xx0ooooo0xx00 = r22
            cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.x0000xo0x0oooooo0 = r23
            cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.xo00x00xo00 = r19
            cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.o00o0o0oo0oo0o000x00 = r24
            cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.xoo0xoo0oxo00x0o0 = r25
            cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.o0oo0xx00ooo0oox0xx0 = r28
            cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.ooxo0o0xxxooxo00 = r27
            cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.ox000o0o = r30
            cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.ox0xxoox0 = r31
            android.content.Context r6 = o0oo0xx00ooo0oox0xx0
            if (r6 == 0) goto L_0x0049
            cn.tongdun.android.shell.common.HelperJNI.setContext(r6)     // Catch:{ Throwable -> 0x0039 }
            goto L_0x0049
        L_0x0039:
            java.lang.String r6 = "316a756376726d"
            r7 = 92
            java.lang.String r6 = o00xxox0x0xoox((java.lang.String) r6, (int) r7)     // Catch:{ Throwable -> 0x0049 }
            java.lang.System.loadLibrary(r6)     // Catch:{ Throwable -> 0x0049 }
            android.content.Context r6 = o0oo0xx00ooo0oox0xx0     // Catch:{ Throwable -> 0x0049 }
            cn.tongdun.android.shell.common.HelperJNI.setContext(r6)     // Catch:{ Throwable -> 0x0049 }
        L_0x0049:
            r6 = 3
            r7 = 4
            cn.tongdun.android.shell.common.HelperJNI.exprot(r6, r7)
            cn.tongdun.android.shell.common.HelperJNI.exprot(r7, r5)
            cn.tongdun.android.core.oo0ooo0o00o0xo.o0o0xxox.xo00x00xo00()
            java.lang.String r6 = "sensor"
            java.lang.Object r6 = r2.getSystemService(r6)
            android.hardware.SensorManager r6 = (android.hardware.SensorManager) r6
            cn.tongdun.android.core.oo0ooo0o00o0xo.o0o0xxox r7 = new cn.tongdun.android.core.oo0ooo0o00o0xo.o0o0xxox
            r7.<init>()
            r1.o00xxox0x0xoox((android.hardware.SensorManager) r6, (cn.tongdun.android.core.oo0ooo0o00o0xo.o0o0xxox) r7)
            cn.tongdun.android.shell.common.CollectorError$TYPE r8 = cn.tongdun.android.shell.common.CollectorError.TYPE.ERROR_SHORT_INTERVAL
            cn.tongdun.android.shell.common.CollectorError.remove(r8)
            r8 = 46
            java.lang.String r9 = "1138553156204d6e1e7911325d3153341767117111770777"
            java.lang.String r8 = o00xxox0x0xoox((java.lang.String) r9, (int) r8)
            cn.tongdun.android.shell.utils.LogUtil.info((java.lang.String) r8)
            r8 = 1
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            o00xxox0x0xoox = r9     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            cn.tongdun.android.core.oo0ooo0o00o0xo.xoxx0xx r9 = r1.x0ox00x0oooo0xxx     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            int r9 = r9.o00xxox0x0xoox()     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            r10 = 233(0xe9, float:3.27E-43)
            if (r9 == r10) goto L_0x00a6
            long r3 = java.lang.System.currentTimeMillis()
            long r8 = r1.o00xx0xx0ooooo0xx00
            long r3 = r3 - r8
            r1.x0000xo0x0oooooo0 = r3
            if (r26 == 0) goto L_0x0093
            r26.countDown()
        L_0x0093:
            if (r6 == 0) goto L_0x0098
            r6.unregisterListener(r7)
        L_0x0098:
            cn.tongdun.android.shell.inter.FMCallback r0 = cn.tongdun.android.shell.FMAgent.mfmCallBack
            if (r0 == 0) goto L_0x00a5
            cn.tongdun.android.shell.inter.FMCallback r0 = cn.tongdun.android.shell.FMAgent.mfmCallBack
            java.lang.String r2 = r16.o00xxox0x0xoox(r17)
            r0.onEvent(r2)
        L_0x00a5:
            return
        L_0x00a6:
            boolean r9 = android.text.TextUtils.isEmpty(r29)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            if (r9 != 0) goto L_0x00b3
            cn.tongdun.android.core.oo0ooo0o00o0xo.xoxx0xx r9 = r1.x0ox00x0oooo0xxx     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            r10 = r29
            r9.o00xxox0x0xoox((java.lang.String) r10)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
        L_0x00b3:
            cn.tongdun.android.core.oo0ooo0o00o0xo.xoxx0xx r9 = r1.x0ox00x0oooo0xxx     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            byte[] r9 = r9.oo0ooo0o00o0xo()     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            if (r9 != 0) goto L_0x00dc
            long r3 = java.lang.System.currentTimeMillis()
            long r8 = r1.o00xx0xx0ooooo0xx00
            long r3 = r3 - r8
            r1.x0000xo0x0oooooo0 = r3
            if (r26 == 0) goto L_0x00c9
            r26.countDown()
        L_0x00c9:
            if (r6 == 0) goto L_0x00ce
            r6.unregisterListener(r7)
        L_0x00ce:
            cn.tongdun.android.shell.inter.FMCallback r0 = cn.tongdun.android.shell.FMAgent.mfmCallBack
            if (r0 == 0) goto L_0x00db
            cn.tongdun.android.shell.inter.FMCallback r0 = cn.tongdun.android.shell.FMAgent.mfmCallBack
            java.lang.String r2 = r16.o00xxox0x0xoox(r17)
            r0.onEvent(r2)
        L_0x00db:
            return
        L_0x00dc:
            java.lang.String r10 = cn.tongdun.android.shell.FMAgent.STATUS_PROFILING     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            cn.tongdun.android.shell.FMAgent.mStatus = r10     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            cn.tongdun.android.shell.common.CollectorError$TYPE r10 = cn.tongdun.android.shell.common.CollectorError.TYPE.ERROR_PROFILE_DELAY     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            java.lang.String r11 = "15564d5f425a4b1f0f1e06131e"
            r12 = 89
            java.lang.String r11 = o00xxox0x0xoox((java.lang.String) r11, (int) r12)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            cn.tongdun.android.shell.common.CollectorError.addError((cn.tongdun.android.shell.common.CollectorError.TYPE) r10, (java.lang.String) r11)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            r10.<init>()     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            java.lang.String r11 = "3548634e79456e"
            r12 = 116(0x74, float:1.63E-43)
            java.lang.String r11 = o00xxox0x0xoox((java.lang.String) r11, (int) r12)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            java.lang.String r12 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.xo00x00xo00     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            r10.put(r11, r12)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            java.lang.String r11 = "337161707b767a"
            r12 = 79
            java.lang.String r11 = o00xxox0x0xoox((java.lang.String) r11, (int) r12)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            java.lang.String r12 = cn.tongdun.android.core.xo00x00xo00.oo0ooo0o00o0xo.o00xxox0x0xoox     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            r10.put(r11, r12)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            r1.o00xx0xx0ooooo0xx00 = r11     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            boolean r11 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.xoo0xoo0oxo00x0o0     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            if (r11 == 0) goto L_0x0125
            cn.tongdun.android.shell.common.CollectorError$TYPE r3 = cn.tongdun.android.shell.common.CollectorError.TYPE.ERROR_ALWAYS_DEMOTION     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            java.lang.String r4 = "04155a034209114d1045125e0f580e"
            r5 = 21
            java.lang.String r4 = o00xxox0x0xoox((java.lang.String) r4, (int) r5)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            cn.tongdun.android.shell.common.CollectorError.addError((cn.tongdun.android.shell.common.CollectorError.TYPE) r3, (java.lang.String) r4)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            goto L_0x02c4
        L_0x0125:
            java.lang.String r11 = cn.tongdun.android.core.xo00x00xo00.oo0ooo0o00o0xo.x0000xo0x0oooooo0     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            java.lang.String r12 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.ooxo0o0xxxooxo00     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            if (r12 == 0) goto L_0x0151
            java.lang.String r12 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.oo0ooo0o00o0xo     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            if (r12 == 0) goto L_0x0140
            java.lang.String r12 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.oo0ooo0o00o0xo     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            java.lang.String r13 = cn.tongdun.android.shell.FMAgent.ENV_SANDBOX     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            boolean r12 = r12.equals(r13)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            if (r12 == 0) goto L_0x0140
            java.lang.String r11 = cn.tongdun.android.core.xo00x00xo00.oo0ooo0o00o0xo.xo00x00xo00     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            goto L_0x0164
        L_0x0140:
            java.lang.String r12 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.oo0ooo0o00o0xo     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            if (r12 == 0) goto L_0x0164
            java.lang.String r12 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.oo0ooo0o00o0xo     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            java.lang.String r13 = cn.tongdun.android.shell.FMAgent.ENV_PRODUCTION     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            boolean r12 = r12.equals(r13)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            if (r12 == 0) goto L_0x0164
            java.lang.String r11 = cn.tongdun.android.core.xo00x00xo00.oo0ooo0o00o0xo.x0000xo0x0oooooo0     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            goto L_0x0164
        L_0x0151:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            r11.<init>()     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            java.lang.String r12 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.ooxo0o0xxxooxo00     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            r11.append(r12)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            java.lang.String r12 = cn.tongdun.android.core.xo00x00xo00.oo0ooo0o00o0xo.x0ox00x0oooo0xxx     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            r11.append(r12)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            java.lang.String r11 = r11.toString()     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
        L_0x0164:
            java.util.Random r12 = new java.util.Random     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            r12.<init>()     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            r13 = 999999(0xf423f, float:1.401297E-39)
            int r12 = r12.nextInt(r13)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            r13 = 100000(0x186a0, float:1.4013E-40)
            if (r12 >= r13) goto L_0x0176
            int r12 = r12 + r13
        L_0x0176:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            r13.<init>()     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            r13.append(r0)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            r13.append(r14)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            r13.append(r12)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            java.lang.String r12 = r13.toString()     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            oo0ooo0o00o0xo = r12     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            java.lang.String r12 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.x0ox00x0oooo0xxx     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            r13 = 22
            r14 = 39
            if (r12 == 0) goto L_0x0214
            boolean r11 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.ox0xxoox0     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            if (r11 == 0) goto L_0x01a1
            java.lang.String r11 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.x0ox00x0oooo0xxx     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            java.lang.String r9 = cn.tongdun.android.core.x0ox00x0oooo0xxx.o00xxox0x0xoox.o00xxox0x0xoox((java.lang.String) r11, (java.util.Map) r10, (byte[]) r9, (int) r8)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            goto L_0x01a7
        L_0x01a1:
            java.lang.String r11 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.x0ox00x0oooo0xxx     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            java.lang.String r9 = cn.tongdun.android.core.x0ox00x0oooo0xxx.o00xxox0x0xoox.o00xxox0x0xoox((java.lang.String) r11, (java.util.Map) r10, (byte[]) r9, (int) r5)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
        L_0x01a7:
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            android.content.Context r15 = o0oo0xx00ooo0oox0xx0     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            boolean r15 = cn.tongdun.android.core.ooxoxoooxooo0xx00.x0000xo0x0oooooo0.o00xxox0x0xoox((android.content.Context) r15)     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            if (r15 == 0) goto L_0x020f
            java.lang.String r15 = "112f"
            r8 = 18
            java.lang.String r8 = o00xxox0x0xoox((java.lang.String) r15, (int) r8)     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            r15.<init>()     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            java.lang.String r5 = "111659732c743205"
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r5, (int) r14)     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            r15.append(r5)     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            java.lang.String r5 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.x0ox00x0oooo0xxx     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            java.lang.String r5 = cn.tongdun.android.core.x0ox00x0oooo0xxx.o00xxox0x0xoox.o00xxox0x0xoox((java.lang.String) r5, (java.util.Map) r10)     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            r15.append(r5)     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            java.lang.String r5 = "65f473c4df"
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r5, (int) r13)     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            r15.append(r5)     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            java.lang.String r5 = "0d14481038633f762c70580445004d78"
            r10 = 37
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r5, (int) r10)     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            r15.append(r5)     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            long r13 = r1.o00xx0xx0ooooo0xx00     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            r15.append(r13)     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            java.lang.String r5 = "697730773407510c5b682f752b7d53"
            r10 = 62
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r5, (int) r10)     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            r15.append(r5)     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            r15.append(r11)     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            java.lang.String r5 = "693230323442574e4b493f3d22392a41"
            r10 = 123(0x7b, float:1.72E-43)
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r5, (int) r10)     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            r15.append(r5)     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            long r11 = r11 - r3
            r15.append(r11)     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            java.lang.String r3 = r15.toString()     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
            android.util.Log.i(r8, r3)     // Catch:{ JSONException -> 0x0211, Throwable -> 0x02de }
        L_0x020f:
            r3 = r9
            goto L_0x024a
        L_0x0211:
            r0 = r9
            goto L_0x0307
        L_0x0214:
            java.lang.String r3 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.x0000xo0x0oooooo0     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            r4 = 2
            if (r3 == 0) goto L_0x022b
            java.lang.String r3 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.o00xx0xx0ooooo0xx00     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            if (r3 == 0) goto L_0x022b
            java.lang.String r3 = cn.tongdun.android.core.x0ox00x0oooo0xxx.o00xxox0x0xoox.o00xxox0x0xoox((java.lang.String) r11, (java.util.Map) r10, (byte[]) r9, (int) r4)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            java.lang.String r4 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.o00xx0xx0ooooo0xx00     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            r5 = 0
            cn.tongdun.android.core.x0ox00x0oooo0xxx.o00xxox0x0xoox.o00xxox0x0xoox((java.lang.String) r4, (java.util.Map) r10, (byte[]) r9, (int) r5)     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            goto L_0x024a
        L_0x0228:
            r0 = r3
            goto L_0x0307
        L_0x022b:
            java.lang.String r3 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.x0000xo0x0oooooo0     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            if (r3 == 0) goto L_0x0237
            java.lang.String r3 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.x0000xo0x0oooooo0     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            r4 = 0
            java.lang.String r3 = cn.tongdun.android.core.x0ox00x0oooo0xxx.o00xxox0x0xoox.o00xxox0x0xoox((java.lang.String) r3, (java.util.Map) r10, (byte[]) r9, (int) r4)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            goto L_0x024a
        L_0x0237:
            java.lang.String r3 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.o00xx0xx0ooooo0xx00     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            if (r3 == 0) goto L_0x0246
            java.lang.String r3 = cn.tongdun.android.core.x0ox00x0oooo0xxx.o00xxox0x0xoox.o00xxox0x0xoox((java.lang.String) r11, (java.util.Map) r10, (byte[]) r9, (int) r4)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
            java.lang.String r4 = cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.o00xx0xx0ooooo0xx00     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            r5 = 0
            cn.tongdun.android.core.x0ox00x0oooo0xxx.o00xxox0x0xoox.o00xxox0x0xoox((java.lang.String) r4, (java.util.Map) r10, (byte[]) r9, (int) r5)     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            goto L_0x024a
        L_0x0246:
            java.lang.String r3 = cn.tongdun.android.core.x0ox00x0oooo0xxx.o00xxox0x0xoox.o00xxox0x0xoox((java.lang.String) r11, (java.util.Map) r10, (byte[]) r9, (int) r4)     // Catch:{ JSONException -> 0x0307, Throwable -> 0x02de }
        L_0x024a:
            if (r3 == 0) goto L_0x024f
            r0.equals(r3)     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
        L_0x024f:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            r0.<init>(r3)     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            java.lang.String r4 = "753630"
            r5 = 27
            java.lang.String r4 = o00xxox0x0xoox((java.lang.String) r4, (int) r5)     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            java.lang.String r5 = "26066807"
            r8 = 39
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r5, (int) r8)     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            java.lang.String r5 = r0.optString(r5)     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            boolean r4 = r4.equals(r5)     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            if (r4 == 0) goto L_0x028f
            r4 = 1
            r1.xo00x00xo00 = r4     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            r1.ooxoxoooxooo0xx00 = r4     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            java.lang.String r4 = cn.tongdun.android.shell.FMAgent.STATUS_SUCCESSFUL     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            cn.tongdun.android.shell.FMAgent.mStatus = r4     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            java.lang.String r4 = "213a722a"
            r5 = 22
            java.lang.String r4 = o00xxox0x0xoox((java.lang.String) r4, (int) r5)     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            java.lang.String r0 = r0.getString(r4)     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            r1.xoo0xoo0oxo00x0o0 = r0     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            cn.tongdun.android.core.oo0ooo0o00o0xo.oxxx0x0ooooxxooooo000 r0 = cn.tongdun.android.core.oo0ooo0o00o0xo.oxxx0x0ooooxxooooo000.o00xxox0x0xoox()     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            android.content.Context r4 = o0oo0xx00ooo0oox0xx0     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            r0.oo0ooo0o00o0xo((android.content.Context) r4)     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            goto L_0x02bf
        L_0x028f:
            java.lang.String r4 = "746a35"
            r5 = 70
            java.lang.String r4 = o00xxox0x0xoox((java.lang.String) r4, (int) r5)     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            java.lang.String r5 = "266c686d"
            r8 = 77
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r5, (int) r8)     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            java.lang.String r0 = r0.optString(r5)     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            boolean r0 = r4.equals(r0)     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            if (r0 == 0) goto L_0x02b3
            java.lang.String r0 = cn.tongdun.android.shell.FMAgent.STATUS_FAILED     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            cn.tongdun.android.shell.FMAgent.mStatus = r0     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            r0 = 0
            r1.ooxoxoooxooo0xx00 = r0     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            r1.o00o0o0oo0oo0o000x00 = r3     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            goto L_0x02bf
        L_0x02b3:
            r4 = 1
            r1.ooxoxoooxooo0xx00 = r4     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            java.lang.String r0 = cn.tongdun.android.shell.FMAgent.STATUS_FAILED     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            cn.tongdun.android.shell.FMAgent.mStatus = r0     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            cn.tongdun.android.shell.common.CollectorError$TYPE r0 = cn.tongdun.android.shell.common.CollectorError.TYPE.ERROR_PROFILE_FAILED     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            cn.tongdun.android.shell.common.CollectorError.addError((cn.tongdun.android.shell.common.CollectorError.TYPE) r0, (java.lang.String) r3)     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
        L_0x02bf:
            cn.tongdun.android.shell.common.CollectorError$TYPE r0 = cn.tongdun.android.shell.common.CollectorError.TYPE.ERROR_PROFILE_DELAY     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
            cn.tongdun.android.shell.common.CollectorError.remove(r0)     // Catch:{ JSONException -> 0x0228, Throwable -> 0x02de }
        L_0x02c4:
            long r3 = java.lang.System.currentTimeMillis()
            long r8 = r1.o00xx0xx0ooooo0xx00
            long r3 = r3 - r8
            r1.x0000xo0x0oooooo0 = r3
            if (r26 == 0) goto L_0x02d2
            r26.countDown()
        L_0x02d2:
            if (r6 == 0) goto L_0x02d7
            r6.unregisterListener(r7)
        L_0x02d7:
            cn.tongdun.android.shell.inter.FMCallback r0 = cn.tongdun.android.shell.FMAgent.mfmCallBack
            if (r0 == 0) goto L_0x0333
            goto L_0x032a
        L_0x02dc:
            r0 = move-exception
            goto L_0x0334
        L_0x02de:
            r0 = move-exception
            r3 = 1
            r1.ooxoxoooxooo0xx00 = r3     // Catch:{ all -> 0x02dc }
            java.lang.String r3 = cn.tongdun.android.shell.FMAgent.STATUS_FAILED     // Catch:{ all -> 0x02dc }
            cn.tongdun.android.shell.FMAgent.mStatus = r3     // Catch:{ all -> 0x02dc }
            org.json.JSONObject r0 = cn.tongdun.android.shell.common.CollectorError.catchErr(r0)     // Catch:{ all -> 0x02dc }
            cn.tongdun.android.shell.common.CollectorError$TYPE r3 = cn.tongdun.android.shell.common.CollectorError.TYPE.ERROR_PROFILE_FAILED     // Catch:{ all -> 0x02dc }
            cn.tongdun.android.shell.common.CollectorError.addError((cn.tongdun.android.shell.common.CollectorError.TYPE) r3, (org.json.JSONObject) r0)     // Catch:{ all -> 0x02dc }
            long r3 = java.lang.System.currentTimeMillis()
            long r8 = r1.o00xx0xx0ooooo0xx00
            long r3 = r3 - r8
            r1.x0000xo0x0oooooo0 = r3
            if (r26 == 0) goto L_0x02fd
            r26.countDown()
        L_0x02fd:
            if (r6 == 0) goto L_0x0302
            r6.unregisterListener(r7)
        L_0x0302:
            cn.tongdun.android.shell.inter.FMCallback r0 = cn.tongdun.android.shell.FMAgent.mfmCallBack
            if (r0 == 0) goto L_0x0333
            goto L_0x032a
        L_0x0307:
            r3 = 1
            r1.ooxoxoooxooo0xx00 = r3     // Catch:{ all -> 0x02dc }
            java.lang.String r3 = cn.tongdun.android.shell.FMAgent.STATUS_FAILED     // Catch:{ all -> 0x02dc }
            cn.tongdun.android.shell.FMAgent.mStatus = r3     // Catch:{ all -> 0x02dc }
            cn.tongdun.android.shell.common.CollectorError$TYPE r3 = cn.tongdun.android.shell.common.CollectorError.TYPE.ERROR_JSONERROR     // Catch:{ all -> 0x02dc }
            cn.tongdun.android.shell.common.CollectorError.addError((cn.tongdun.android.shell.common.CollectorError.TYPE) r3, (java.lang.String) r0)     // Catch:{ all -> 0x02dc }
            long r3 = java.lang.System.currentTimeMillis()
            long r8 = r1.o00xx0xx0ooooo0xx00
            long r3 = r3 - r8
            r1.x0000xo0x0oooooo0 = r3
            if (r26 == 0) goto L_0x0321
            r26.countDown()
        L_0x0321:
            if (r6 == 0) goto L_0x0326
            r6.unregisterListener(r7)
        L_0x0326:
            cn.tongdun.android.shell.inter.FMCallback r0 = cn.tongdun.android.shell.FMAgent.mfmCallBack
            if (r0 == 0) goto L_0x0333
        L_0x032a:
            cn.tongdun.android.shell.inter.FMCallback r0 = cn.tongdun.android.shell.FMAgent.mfmCallBack
            java.lang.String r2 = r16.o00xxox0x0xoox(r17)
            r0.onEvent(r2)
        L_0x0333:
            return
        L_0x0334:
            long r3 = java.lang.System.currentTimeMillis()
            long r8 = r1.o00xx0xx0ooooo0xx00
            long r3 = r3 - r8
            r1.x0000xo0x0oooooo0 = r3
            if (r26 == 0) goto L_0x0342
            r26.countDown()
        L_0x0342:
            if (r6 == 0) goto L_0x0347
            r6.unregisterListener(r7)
        L_0x0347:
            cn.tongdun.android.shell.inter.FMCallback r3 = cn.tongdun.android.shell.FMAgent.mfmCallBack
            if (r3 == 0) goto L_0x0354
            cn.tongdun.android.shell.inter.FMCallback r3 = cn.tongdun.android.shell.FMAgent.mfmCallBack
            java.lang.String r2 = r16.o00xxox0x0xoox(r17)
            r3.onEvent(r2)
        L_0x0354:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.tongdun.android.core.o00xxox0x0xoox.o00xxox0x0xoox(android.content.Context, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, java.util.concurrent.CountDownLatch, java.lang.String, int, java.lang.String, java.lang.String, boolean):void");
    }

    private void o00xxox0x0xoox(SensorManager sensorManager, o0o0xxox o0o0xxox) {
        try {
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            sensorManager.registerListener(o0o0xxox, defaultSensor, 0);
            if (defaultSensor != null) {
                defaultSensor = sensorManager.getDefaultSensor(9);
                sensorManager.registerListener(o0o0xxox, defaultSensor, 0);
            }
            if (defaultSensor != null) {
                defaultSensor = sensorManager.getDefaultSensor(5);
                sensorManager.registerListener(o0o0xxox, defaultSensor, 0);
            }
            if (defaultSensor != null) {
                defaultSensor = sensorManager.getDefaultSensor(2);
                sensorManager.registerListener(o0o0xxox, defaultSensor, 0);
            }
            if (defaultSensor != null) {
                defaultSensor = sensorManager.getDefaultSensor(4);
                sensorManager.registerListener(o0o0xxox, defaultSensor, 0);
            }
            if (defaultSensor != null) {
                sensorManager.registerListener(o0o0xxox, sensorManager.getDefaultSensor(9), 0);
            }
        } catch (Exception unused) {
        }
    }

    public String o00xxox0x0xoox(Context context) {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis() - FMAgent.mStartInitTime;
            int i = (int) (currentTimeMillis / 86400000);
            if (i > 15 && context != null) {
                FMAgent.initWithOptions(context, FMAgent.ENV_PRODUCTION, FMAgent.mOptions);
                Thread.sleep(2500);
            }
            jSONObject.put(o00xxox0x0xoox("2a69", 88), oo0ooo0o00o0xo.oo0ooo0o00o0xo);
            jSONObject.put(o00xxox0x0xoox("334961487b4e7a", 119), oo0ooo0o00o0xo.o00xxox0x0xoox);
            jSONObject.put(o00xxox0x0xoox("357a727278747a62", 70), xo0xo0x0oox000oxox0.xo00x00xo00(context));
            jSONObject.put(o00xxox0x0xoox("35316d38623d6b07401a4412", 30), this.x0000xo0x0oooooo0);
            jSONObject.put(o00xxox0x0xoox("2c1373026406730b40205d2455", 57), currentTimeMillis);
            if (!this.ooxoxoooxooo0xx00 && !TextUtils.isEmpty(this.o00o0o0oo0oo0o000x00)) {
                return this.o00o0o0oo0oo0o000x00;
            }
            if (!this.xo00x00xo00) {
                String o00xxox0x0xoox2 = this.x0ox00x0oooo0xxx.o00xxox0x0xoox(cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.o0oo0xx00ooo0oox0xx0);
                JSONObject jSONObject2 = new JSONObject();
                String errorCode = CollectorError.getErrorCode();
                str2 = HelperJNI.err0r(errorCode, CollectorError.getErrorMsg());
                jSONObject2.put(o00xxox0x0xoox("2056654b7866446a4f6b", 108), errorCode);
                jSONObject2.put(o00xxox0x0xoox("207d6560784d4a535e", 71), str2);
                jSONObject.put(o00xxox0x0xoox("204f6552787f4e784965", 117), jSONObject2);
                jSONObject.put(o00xxox0x0xoox("21367123", 30), o00xxox0x0xoox2);
                str = BoxUtil.limitBox(jSONObject, cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.o0oo0xx00ooo0oox0xx0);
            } else {
                jSONObject.put(o00xxox0x0xoox("311770197b284d25", 33), this.xoo0xoo0oxo00x0o0);
                str = jSONObject.toString();
            }
            String encodeToString = Base64.encodeToString(str.getBytes(o00xxox0x0xoox("3021676a72", 13)), 2);
            if (i >= 1 && i < 15 && context != null) {
                FMAgent.initWithOptions(context, FMAgent.ENV_PRODUCTION, FMAgent.mOptions);
            }
            LogUtil.info(o00xxox0x0xoox("02475613141d191f112b2c263b7e68787e78786e78", 72));
            return encodeToString;
        } catch (Throwable th) {
            return CollectorError.catchErr(th).toString();
        }
    }

    public static String o00xxox0x0xoox(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b2 = (byte) (i ^ 45);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 69);
            byte b3 = bArr[0];
            int i4 = 1;
            while (i4 < length2) {
                byte b4 = bArr[i4];
                bArr[i4] = (byte) ((b3 ^ bArr[i4]) ^ b2);
                i4++;
                b3 = b4;
            }
            return new String(bArr, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
