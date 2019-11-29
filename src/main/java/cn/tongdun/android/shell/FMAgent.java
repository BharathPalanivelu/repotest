package cn.tongdun.android.shell;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import cn.tongdun.android.core.o00xxox0x0xoox;
import cn.tongdun.android.shell.common.CollectorError;
import cn.tongdun.android.shell.common.HelperJNI;
import cn.tongdun.android.shell.inter.FMCallback;
import cn.tongdun.android.shell.settings.Constants;
import cn.tongdun.android.shell.utils.BoxUtil;
import cn.tongdun.android.shell.utils.LogUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class FMAgent {
    public static String CURRENT_ENV = null;
    public static String CURRENT_PARTNERCODE = null;
    public static final String ENV_PRODUCTION = linkxxxxx("7f7d6d767c606b7d6d7c", 14);
    public static final String ENV_SANDBOX = linkxxxxx("7c197c137a1e6d", 122);
    public static final String OPTION_ALWAYS_DEMOTION = linkxxxxx("6e4c7a5a62504e6b4f634d78507e51", 48);
    public static final String OPTION_APP_NAME = linkxxxxx("4e04410b50045c0c", 100);
    public static final String OPTION_BLACKBOX_MAXSIZE = linkxxxxx("6d1a6f1867116a064d34412d4a375928", 101);
    public static final String OPTION_CHECK_LICENSE = linkxxxxx("6c346e32660655035f05540852", 78);
    public static final String OPTION_CUSTOM_URL = linkxxxxx("6c0165067e044c2e4b30", 102);
    public static final String OPTION_CUST_PROCESS = linkxxxxx("6c0565024e2d4c3040365636", 98);
    public static final String OPTION_DOMAIN = linkxxxxx("6b1866146e13", 98);
    public static final String OPTION_DOUBLE_URL = linkxxxxx("6b6b7e7c70754a5f4d41", 17);
    public static final String OPTION_GOOGLE_AID = linkxxxxx("4807470f4c0676387e35", 94);
    public static final String OPTION_INIT_TIMESPAN = linkxxxxx("66716e6c45475843505553445c", 7);
    public static final String OPTION_KILL_DEBUGGER = linkxxxxx("641f6e1f5d245c344e344c23", 108);
    public static final String OPTION_OVERRIDE_CERTI = linkxxxxx("60087c1f7c0471054b394d2e4b33", 96);
    public static final String OPTION_PARTNER_CODE = linkxxxxx("7f2a632c723b5f07530c52", 74);
    public static final String OPTION_PROXY_URL = linkxxxxx("7f3c6d2b6c0d460a58", 79);
    public static final String OPTION_SKIP_GPS = linkxxxxx("7c75716c5e544957", 28);
    public static final String OPTION_WAIT_TIME = linkxxxxx("787b7f66544d494941", 28);
    public static final String STATUS_COLLECTING = linkxxxxx("6c65606569637e7e7977", 24);
    public static final String STATUS_FAILED = linkxxxxx("69226e276726", 84);
    public static final String STATUS_LOADING = linkxxxxx("636362666f6166", 17);
    public static final String STATUS_PROFILING = linkxxxxx("7f216d28622d672a6e", 82);
    public static final String STATUS_SUCCESSFUL = linkxxxxx("7c00650063166303701a", 119);
    public static final String STATUS_UNINIT = linkxxxxx("7a6b726c7571", 1);
    public static final int Tag = 63109263;
    private static final int class_version = 312;
    /* access modifiers changed from: private */
    public static int mBlackboxMaxSize = Integer.MAX_VALUE;
    /* access modifiers changed from: private */
    public static CountDownLatch mDownLatch = null;
    /* access modifiers changed from: private */
    public static o00xxox0x0xoox mFmInter = null;
    private static boolean mInited = false;
    /* access modifiers changed from: private */
    public static long mLastInitTime = 0;
    public static Map mOptions = null;
    public static long mStartInitTime = 0;
    public static String mStatus = STATUS_UNINIT;
    private static int mWaitTime = Constants.DEFAULT_WAIT_TIME;
    public static FMCallback mfmCallBack = null;

    public static void openLog() {
        LogUtil.openLog();
        LogUtil.info(linkxxxxx("40685a6314370f360635172e597d4e72053e0636", 38));
    }

    public static String getInitStatus() {
        return mStatus;
    }

    public static void initWithCallback(Context context, String str, Map map, FMCallback fMCallback) {
        mfmCallBack = fMCallback;
        init(context, str, map);
        mOptions = map;
    }

    public static void initWithCallback(Context context, String str, FMCallback fMCallback) {
        initWithCallback(context, str, (Map) null, fMCallback);
    }

    private static void init1(Context context, String str) {
        if (mfmCallBack != null) {
            mfmCallBack = null;
        }
        if (TextUtils.isEmpty(str) || context == null) {
            LogUtil.err(linkxxxxx("e73df06cb54fd336e9d0c5d1dfc0c2cc50a24edc26d9f6dee8749643dc36ea76a178e53eea", 11));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(OPTION_CUSTOM_URL, str);
        init(context, ENV_PRODUCTION, hashMap);
    }

    public static void initWithDomain(Context context, String str) {
        if (mfmCallBack != null) {
            mfmCallBack = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(OPTION_DOMAIN, str);
        mOptions = hashMap;
        init(context, ENV_PRODUCTION, hashMap);
    }

    public static void init(Context context, String str) {
        if (mfmCallBack != null) {
            mfmCallBack = null;
        }
        init(context, str, (Map) null);
    }

    public static void initWithOptions(Context context, String str, Map map) {
        if (mfmCallBack != null) {
            mfmCallBack = null;
        }
        init(context, str, map);
        mOptions = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v35, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v37, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v39, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v41, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v43, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v45, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v47, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v49, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void init(android.content.Context r19, java.lang.String r20, java.util.Map r21) {
        /*
            r0 = r20
            r1 = r21
            long r2 = java.lang.System.currentTimeMillis()
            mStartInitTime = r2
            r2 = 1
            mInited = r2     // Catch:{ Throwable -> 0x022d }
            cn.tongdun.android.shell.common.CollectorError$TYPE r3 = cn.tongdun.android.shell.common.CollectorError.TYPE.ERROR_INIT     // Catch:{ Throwable -> 0x022d }
            cn.tongdun.android.shell.common.CollectorError.remove(r3)     // Catch:{ Throwable -> 0x022d }
            android.content.Context r3 = r19.getApplicationContext()     // Catch:{ Throwable -> 0x022d }
            r4 = 3000(0xbb8, float:4.204E-42)
            r5 = 600000(0x927c0, float:8.40779E-40)
            java.lang.String r6 = cn.tongdun.android.shell.settings.Constants.DEFAULT_PARTNER_CODE     // Catch:{ Throwable -> 0x022d }
            java.lang.String r7 = cn.tongdun.android.shell.settings.Constants.DEFAULT_DOMAIN     // Catch:{ Throwable -> 0x022d }
            java.lang.String r8 = cn.tongdun.android.shell.settings.Constants.DEFAULT_CUST_PROCESS     // Catch:{ Throwable -> 0x022d }
            java.lang.String r9 = cn.tongdun.android.shell.settings.Constants.DEFAULT_CUSTOM_URL     // Catch:{ Throwable -> 0x022d }
            java.lang.String r10 = cn.tongdun.android.shell.settings.Constants.DEFAULT_DOUBLE_URL     // Catch:{ Throwable -> 0x022d }
            java.lang.String r11 = cn.tongdun.android.shell.settings.Constants.DEFAULT_PROXY_URL     // Catch:{ Throwable -> 0x022d }
            java.lang.String r12 = cn.tongdun.android.shell.settings.Constants.DEFAULT_GOOGLE_AID     // Catch:{ Throwable -> 0x022d }
            java.lang.String r13 = cn.tongdun.android.shell.settings.Constants.DEFAULT_APPNAME     // Catch:{ Throwable -> 0x022d }
            if (r1 == 0) goto L_0x016f
            mOptions = r1     // Catch:{ Throwable -> 0x022d }
            java.lang.String r15 = OPTION_WAIT_TIME     // Catch:{ Throwable -> 0x022d }
            boolean r15 = r1.containsKey(r15)     // Catch:{ Throwable -> 0x022d }
            if (r15 == 0) goto L_0x0043
            java.lang.String r4 = OPTION_WAIT_TIME     // Catch:{ Throwable -> 0x022d }
            java.lang.Object r4 = r1.get(r4)     // Catch:{ Throwable -> 0x022d }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Throwable -> 0x022d }
            int r4 = r4.intValue()     // Catch:{ Throwable -> 0x022d }
        L_0x0043:
            java.lang.String r15 = OPTION_INIT_TIMESPAN     // Catch:{ Throwable -> 0x022d }
            boolean r15 = r1.containsKey(r15)     // Catch:{ Throwable -> 0x022d }
            if (r15 == 0) goto L_0x0057
            java.lang.String r5 = OPTION_INIT_TIMESPAN     // Catch:{ Throwable -> 0x022d }
            java.lang.Object r5 = r1.get(r5)     // Catch:{ Throwable -> 0x022d }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Throwable -> 0x022d }
            int r5 = r5.intValue()     // Catch:{ Throwable -> 0x022d }
        L_0x0057:
            java.lang.String r15 = OPTION_BLACKBOX_MAXSIZE     // Catch:{ Throwable -> 0x022d }
            boolean r15 = r1.containsKey(r15)     // Catch:{ Throwable -> 0x022d }
            if (r15 == 0) goto L_0x006c
            java.lang.String r15 = OPTION_BLACKBOX_MAXSIZE     // Catch:{ Throwable -> 0x022d }
            java.lang.Object r15 = r1.get(r15)     // Catch:{ Throwable -> 0x022d }
            java.lang.Integer r15 = (java.lang.Integer) r15     // Catch:{ Throwable -> 0x022d }
            int r15 = r15.intValue()     // Catch:{ Throwable -> 0x022d }
            goto L_0x006d
        L_0x006c:
            r15 = 0
        L_0x006d:
            java.lang.String r14 = OPTION_SKIP_GPS     // Catch:{ Throwable -> 0x022d }
            boolean r14 = r1.containsKey(r14)     // Catch:{ Throwable -> 0x022d }
            if (r14 == 0) goto L_0x0082
            java.lang.String r14 = OPTION_SKIP_GPS     // Catch:{ Throwable -> 0x022d }
            java.lang.Object r14 = r1.get(r14)     // Catch:{ Throwable -> 0x022d }
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ Throwable -> 0x022d }
            boolean r14 = r14.booleanValue()     // Catch:{ Throwable -> 0x022d }
            goto L_0x0083
        L_0x0082:
            r14 = 0
        L_0x0083:
            java.lang.String r2 = OPTION_KILL_DEBUGGER     // Catch:{ Throwable -> 0x022d }
            boolean r2 = r1.containsKey(r2)     // Catch:{ Throwable -> 0x022d }
            if (r2 == 0) goto L_0x009a
            java.lang.String r2 = OPTION_KILL_DEBUGGER     // Catch:{ Throwable -> 0x022d }
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Throwable -> 0x022d }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Throwable -> 0x022d }
            boolean r2 = r2.booleanValue()     // Catch:{ Throwable -> 0x022d }
            r16 = r2
            goto L_0x009c
        L_0x009a:
            r16 = 0
        L_0x009c:
            java.lang.String r2 = OPTION_ALWAYS_DEMOTION     // Catch:{ Throwable -> 0x022d }
            boolean r2 = r1.containsKey(r2)     // Catch:{ Throwable -> 0x022d }
            if (r2 == 0) goto L_0x00b3
            java.lang.String r2 = OPTION_ALWAYS_DEMOTION     // Catch:{ Throwable -> 0x022d }
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Throwable -> 0x022d }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Throwable -> 0x022d }
            boolean r2 = r2.booleanValue()     // Catch:{ Throwable -> 0x022d }
            r17 = r2
            goto L_0x00b5
        L_0x00b3:
            r17 = 0
        L_0x00b5:
            java.lang.String r2 = OPTION_PARTNER_CODE     // Catch:{ Throwable -> 0x022d }
            boolean r2 = r1.containsKey(r2)     // Catch:{ Throwable -> 0x022d }
            if (r2 == 0) goto L_0x00c6
            java.lang.String r2 = OPTION_PARTNER_CODE     // Catch:{ Throwable -> 0x022d }
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Throwable -> 0x022d }
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Throwable -> 0x022d }
        L_0x00c6:
            java.lang.String r2 = OPTION_DOMAIN     // Catch:{ Throwable -> 0x022d }
            boolean r2 = r1.containsKey(r2)     // Catch:{ Throwable -> 0x022d }
            if (r2 == 0) goto L_0x00d7
            java.lang.String r2 = OPTION_DOMAIN     // Catch:{ Throwable -> 0x022d }
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Throwable -> 0x022d }
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Throwable -> 0x022d }
        L_0x00d7:
            java.lang.String r2 = OPTION_CUST_PROCESS     // Catch:{ Throwable -> 0x022d }
            boolean r2 = r1.containsKey(r2)     // Catch:{ Throwable -> 0x022d }
            if (r2 == 0) goto L_0x00e8
            java.lang.String r2 = OPTION_CUST_PROCESS     // Catch:{ Throwable -> 0x022d }
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Throwable -> 0x022d }
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Throwable -> 0x022d }
        L_0x00e8:
            java.lang.String r2 = OPTION_CUSTOM_URL     // Catch:{ Throwable -> 0x022d }
            boolean r2 = r1.containsKey(r2)     // Catch:{ Throwable -> 0x022d }
            if (r2 == 0) goto L_0x00f9
            java.lang.String r2 = OPTION_CUSTOM_URL     // Catch:{ Throwable -> 0x022d }
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Throwable -> 0x022d }
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Throwable -> 0x022d }
        L_0x00f9:
            java.lang.String r2 = OPTION_DOUBLE_URL     // Catch:{ Throwable -> 0x022d }
            boolean r2 = r1.containsKey(r2)     // Catch:{ Throwable -> 0x022d }
            if (r2 == 0) goto L_0x010a
            java.lang.String r2 = OPTION_DOUBLE_URL     // Catch:{ Throwable -> 0x022d }
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Throwable -> 0x022d }
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Throwable -> 0x022d }
        L_0x010a:
            java.lang.String r2 = OPTION_PROXY_URL     // Catch:{ Throwable -> 0x022d }
            boolean r2 = r1.containsKey(r2)     // Catch:{ Throwable -> 0x022d }
            if (r2 == 0) goto L_0x011b
            java.lang.String r2 = OPTION_PROXY_URL     // Catch:{ Throwable -> 0x022d }
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Throwable -> 0x022d }
            r11 = r2
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Throwable -> 0x022d }
        L_0x011b:
            java.lang.String r2 = OPTION_GOOGLE_AID     // Catch:{ Throwable -> 0x022d }
            boolean r2 = r1.containsKey(r2)     // Catch:{ Throwable -> 0x022d }
            if (r2 == 0) goto L_0x012c
            java.lang.String r2 = OPTION_GOOGLE_AID     // Catch:{ Throwable -> 0x022d }
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Throwable -> 0x022d }
            r12 = r2
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Throwable -> 0x022d }
        L_0x012c:
            java.lang.String r2 = OPTION_APP_NAME     // Catch:{ Throwable -> 0x022d }
            boolean r2 = r1.containsKey(r2)     // Catch:{ Throwable -> 0x022d }
            if (r2 == 0) goto L_0x013d
            java.lang.String r2 = OPTION_APP_NAME     // Catch:{ Throwable -> 0x022d }
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Throwable -> 0x022d }
            r13 = r2
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ Throwable -> 0x022d }
        L_0x013d:
            java.lang.String r2 = OPTION_OVERRIDE_CERTI     // Catch:{ Throwable -> 0x022d }
            boolean r2 = r1.containsKey(r2)     // Catch:{ Throwable -> 0x022d }
            if (r2 == 0) goto L_0x0161
            java.lang.String r2 = OPTION_OVERRIDE_CERTI     // Catch:{ Throwable -> 0x022d }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Throwable -> 0x022d }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Throwable -> 0x022d }
            boolean r1 = r1.booleanValue()     // Catch:{ Throwable -> 0x022d }
            r18 = r17
            r17 = r1
            r1 = r8
            r8 = r11
            r11 = r7
            r7 = r9
            r9 = r16
            r16 = r12
            r12 = r10
            r10 = r18
            goto L_0x017c
        L_0x0161:
            r1 = r8
            r8 = r11
            r11 = r7
            r7 = r9
            r9 = r16
            r16 = r12
            r12 = r10
            r10 = r17
            r17 = 0
            goto L_0x017c
        L_0x016f:
            r1 = r8
            r8 = r11
            r16 = r12
            r14 = 0
            r15 = 0
            r17 = 0
            r11 = r7
            r7 = r9
            r12 = r10
            r9 = 0
            r10 = 0
        L_0x017c:
            r2 = 5120(0x1400, float:7.175E-42)
            if (r15 >= r2) goto L_0x0182
            r15 = 5120(0x1400, float:7.175E-42)
        L_0x0182:
            mBlackboxMaxSize = r15     // Catch:{ Throwable -> 0x022d }
            if (r6 != 0) goto L_0x018b
            java.lang.String r2 = cn.tongdun.android.shell.common.o00xxox0x0xoox.o00xxox0x0xoox(r3)     // Catch:{ Throwable -> 0x022d }
            r6 = r2
        L_0x018b:
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Throwable -> 0x022d }
            if (r2 == 0) goto L_0x01a3
            android.os.Handler r0 = new android.os.Handler     // Catch:{ Throwable -> 0x022d }
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ Throwable -> 0x022d }
            r0.<init>(r1)     // Catch:{ Throwable -> 0x022d }
            cn.tongdun.android.shell.o00xxox0x0xoox r1 = new cn.tongdun.android.shell.o00xxox0x0xoox     // Catch:{ Throwable -> 0x022d }
            r1.<init>(r3)     // Catch:{ Throwable -> 0x022d }
            r0.post(r1)     // Catch:{ Throwable -> 0x022d }
            return
        L_0x01a3:
            if (r13 != 0) goto L_0x01aa
            java.lang.String r2 = cn.tongdun.android.shell.common.o00xxox0x0xoox.oo0ooo0o00o0xo(r3)     // Catch:{ Throwable -> 0x022d }
            r13 = r2
        L_0x01aa:
            java.util.concurrent.CountDownLatch r2 = new java.util.concurrent.CountDownLatch     // Catch:{ Throwable -> 0x022d }
            r15 = 1
            r2.<init>(r15)     // Catch:{ Throwable -> 0x022d }
            mDownLatch = r2     // Catch:{ Throwable -> 0x022d }
            cn.tongdun.android.shell.common.o00xx0xx0ooooo0xx00 r2 = new cn.tongdun.android.shell.common.o00xx0xx0ooooo0xx00     // Catch:{ Throwable -> 0x022d }
            r2.<init>(r3)     // Catch:{ Throwable -> 0x022d }
            r2.o00xxox0x0xoox(r0, r8, r6, r1)     // Catch:{ Throwable -> 0x022d }
            if (r0 == 0) goto L_0x01d8
            java.lang.String r15 = ENV_SANDBOX     // Catch:{ Throwable -> 0x022d }
            boolean r15 = r0.equals(r15)     // Catch:{ Throwable -> 0x022d }
            if (r15 == 0) goto L_0x01d8
            android.os.Handler r15 = new android.os.Handler     // Catch:{ Throwable -> 0x022d }
            r19 = r13
            android.os.Looper r13 = android.os.Looper.getMainLooper()     // Catch:{ Throwable -> 0x022d }
            r15.<init>(r13)     // Catch:{ Throwable -> 0x022d }
            cn.tongdun.android.shell.oo0ooo0o00o0xo r13 = new cn.tongdun.android.shell.oo0ooo0o00o0xo     // Catch:{ Throwable -> 0x022d }
            r13.<init>(r3)     // Catch:{ Throwable -> 0x022d }
            r15.post(r13)     // Catch:{ Throwable -> 0x022d }
            goto L_0x01da
        L_0x01d8:
            r19 = r13
        L_0x01da:
            CURRENT_ENV = r0     // Catch:{ Throwable -> 0x022d }
            CURRENT_PARTNERCODE = r6     // Catch:{ Throwable -> 0x022d }
            boolean r1 = r2.o00xxox0x0xoox(r1)     // Catch:{ Throwable -> 0x022d }
            if (r1 != 0) goto L_0x01ea
            java.util.concurrent.CountDownLatch r0 = mDownLatch     // Catch:{ Throwable -> 0x022d }
            r0.countDown()     // Catch:{ Throwable -> 0x022d }
            return
        L_0x01ea:
            long r0 = mLastInitTime     // Catch:{ Throwable -> 0x022d }
            boolean r0 = r2.o00xxox0x0xoox((long) r0, (int) r5)     // Catch:{ Throwable -> 0x022d }
            if (r0 != 0) goto L_0x020b
            java.lang.String r0 = mStatus     // Catch:{ Throwable -> 0x022d }
            java.lang.String r1 = STATUS_SUCCESSFUL     // Catch:{ Throwable -> 0x022d }
            if (r0 != r1) goto L_0x020b
            java.util.concurrent.CountDownLatch r0 = mDownLatch     // Catch:{ Throwable -> 0x022d }
            r0.countDown()     // Catch:{ Throwable -> 0x022d }
            cn.tongdun.android.shell.inter.FMCallback r0 = mfmCallBack     // Catch:{ Throwable -> 0x022d }
            if (r0 == 0) goto L_0x020a
            cn.tongdun.android.shell.inter.FMCallback r0 = mfmCallBack     // Catch:{ Throwable -> 0x022d }
            java.lang.String r1 = onEvent(r3)     // Catch:{ Throwable -> 0x022d }
            r0.onEvent(r1)     // Catch:{ Throwable -> 0x022d }
        L_0x020a:
            return
        L_0x020b:
            java.lang.String r0 = STATUS_LOADING     // Catch:{ Throwable -> 0x022d }
            mStatus = r0     // Catch:{ Throwable -> 0x022d }
            mWaitTime = r4     // Catch:{ Throwable -> 0x022d }
            java.lang.Thread r0 = new java.lang.Thread     // Catch:{ Throwable -> 0x022d }
            cn.tongdun.android.shell.o00xx0xx0ooooo0xx00 r15 = new cn.tongdun.android.shell.o00xx0xx0ooooo0xx00     // Catch:{ Throwable -> 0x022d }
            r1 = r15
            r2 = r3
            r3 = r20
            r4 = r6
            r5 = r14
            r6 = r7
            r7 = r12
            r12 = r16
            r13 = r19
            r14 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Throwable -> 0x022d }
            r0.<init>(r15)     // Catch:{ Throwable -> 0x022d }
            r0.start()     // Catch:{ Throwable -> 0x022d }
            goto L_0x024c
        L_0x022d:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 101(0x65, float:1.42E-43)
            java.lang.String r3 = "4c364e36027f0578183602"
            java.lang.String r2 = linkxxxxx(r3, r2)
            r1.append(r2)
            org.json.JSONObject r0 = cn.tongdun.android.shell.common.CollectorError.catchErr(r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            cn.tongdun.android.shell.utils.LogUtil.err(r0)
        L_0x024c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.tongdun.android.shell.FMAgent.init(android.content.Context, java.lang.String, java.util.Map):void");
    }

    public static String onEvent(Context context) {
        JSONObject jSONObject;
        String errorCode;
        String str;
        if (!mInited) {
            CollectorError.addError(CollectorError.TYPE.ERROR_INIT, linkxxxxx("4b74493007311c6555624d7b49750c3c0b3b16", 40));
            LogUtil.err(linkxxxxx("42024b051f4c185401500f154f33443f623d69273360346729736935662e6729322932", 75));
        }
        CountDownLatch countDownLatch = mDownLatch;
        if (countDownLatch != null) {
            try {
                countDownLatch.await((long) mWaitTime, TimeUnit.MILLISECONDS);
            } catch (Exception unused) {
            }
        }
        o00xxox0x0xoox o00xxox0x0xoox = mFmInter;
        if (o00xxox0x0xoox != null) {
            return o00xxox0x0xoox.o00xxox0x0xoox(context);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject();
            errorCode = CollectorError.getErrorCode();
            str = HelperJNI.err0r(errorCode, CollectorError.getErrorMsg());
        } catch (Throwable th) {
            JSONObject catchErr = CollectorError.catchErr(th);
            LogUtil.err(linkxxxxx("60254416571d4d5357", 85) + catchErr);
            return catchErr.toString();
        }
        jSONObject.put(linkxxxxx("6a41655c7871447d4f7c", 39), errorCode);
        jSONObject.put(linkxxxxx("6a7a6567784a4a545e", 28), str);
        jSONObject.put(linkxxxxx("6b5c77437d45", 44), cn.tongdun.android.shell.common.o00xxox0x0xoox.x0ox00x0oooo0xxx(context));
        jSONObject2.put(linkxxxxx("6029", 68), Constants.OS);
        jSONObject2.put(linkxxxxx("792e612f7b297a", 76), Constants.VERSION);
        jSONObject2.put(linkxxxxx("7f7a727278747a62", 26), cn.tongdun.android.shell.common.o00xxox0x0xoox.o00xx0xx0ooooo0xx00(context));
        jSONObject2.put(linkxxxxx("6a76656b78464e41495c", 16), jSONObject);
        return Base64.encodeToString(BoxUtil.limitBox(jSONObject2, mBlackboxMaxSize).getBytes(linkxxxxx("7a54671f72", 36)), 2);
    }

    public static String linkxxxxx(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b2 = (byte) (i ^ 113);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 15);
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
