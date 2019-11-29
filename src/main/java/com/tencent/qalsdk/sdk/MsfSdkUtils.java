package com.tencent.qalsdk.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.g.a.a.g;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.util.QLog;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MsfSdkUtils {
    private static final String[] PRIVILEGE_CMDS = {"openim.pbvideoinfo", "openim.pbvideoapp", "openim.pbtinyidtouserid", "openim.pbuseridtotinyid"};
    private static final AtomicInteger seqFactory = new AtomicInteger(new Random().nextInt(100000));
    private static final String tag = "MsfSdkUtils";
    public static final SimpleDateFormat timeFormatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss:SSS");

    public static boolean isTopActivity(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean isScreenOn(Context context) {
        if (context == null) {
            return false;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return ((Boolean) powerManager.getClass().getMethod("isScreenOn", new Class[0]).invoke(powerManager, (Object[]) null)).booleanValue();
        } catch (Exception e2) {
            QLog.d(tag, 1, "e = " + e2.toString());
            return true;
        }
    }

    public static String getProcessName(Context context) {
        if (context == null) {
            return "unknown";
        }
        try {
            for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (next != null && next.pid == Process.myPid()) {
                    return next.processName;
                }
            }
        } catch (Exception unused) {
            QLog.d(tag, 1, "getProcessName error " + null);
        }
        return "unknown";
    }

    public static boolean isMainProcess(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String packageName = context.getPackageName();
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            QLog.i(tag, "isMainProcess get getRunningAppProcesses null");
            List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
            if (runningServices == null) {
                QLog.i(tag, "isMainProcess get getRunningServices null");
                return false;
            }
            for (ActivityManager.RunningServiceInfo next : runningServices) {
                if (next.pid == myPid && packageName.equals(next.service.getPackageName())) {
                    return true;
                }
            }
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next2 : runningAppProcesses) {
            if (next2.pid == myPid && packageName.equals(next2.processName)) {
                return true;
            }
        }
        return false;
    }

    public static synchronized int getNextAppSeq() {
        int incrementAndGet;
        synchronized (MsfSdkUtils.class) {
            incrementAndGet = seqFactory.incrementAndGet();
            if (incrementAndGet > 1000000) {
                seqFactory.set(new Random().nextInt(100000));
            }
            if (incrementAndGet == 50000) {
                incrementAndGet += 10000;
            }
        }
        return incrementAndGet;
    }

    public static boolean killProcess(Context context, String str) {
        if (!(context == null || str == null)) {
            for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (next.processName.equals(str)) {
                    Process.killProcess(next.pid);
                    return true;
                }
            }
        }
        return false;
    }

    public static FromServiceMsg constructResponse(String str, String str2, int i, int i2, String str3, Object obj, int i3) {
        FromServiceMsg fromServiceMsg = new FromServiceMsg(str, str2);
        fromServiceMsg.setAppId(i);
        if (i2 != 1000) {
            fromServiceMsg.setBusinessFail(i2, str3);
        } else {
            fromServiceMsg.setMsgSuccess();
        }
        if (obj != null) {
            fromServiceMsg.addAttribute(str2, obj);
        }
        fromServiceMsg.setRequestSsoSeq(i3);
        return fromServiceMsg;
    }

    public static void addFromMsgProcessName(String str, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg != null) {
            fromServiceMsg.getAttributes().put("to_SenderProcessName", str);
        }
    }

    public static void addToMsgProcessName(String str, ToServiceMsg toServiceMsg) {
        if (toServiceMsg != null) {
            toServiceMsg.getAttributes().put("to_SenderProcessName", str);
        }
    }

    public static byte[] convertInt2Bytes(int i) {
        return new byte[]{(byte) (i >>> 24), (byte) (i >>> 16), (byte) (i >>> 8), (byte) i};
    }

    public static int convertBytes2Int(byte[] bArr) {
        return (bArr[3] & 255) | ((bArr[0] << 24) & g.BYTE) | ((bArr[1] << 16) & g.BYTE) | ((bArr[2] << 8) & g.BYTE);
    }

    public static int convertBytes2Int(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i + 0] << 24) & g.BYTE) | ((bArr[i + 1] << 16) & g.BYTE) | ((bArr[i + 2] << 8) & g.BYTE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void saveConfig(java.lang.String r3, java.util.Properties r4) throws java.lang.Exception {
        /*
            if (r3 == 0) goto L_0x001f
            if (r4 != 0) goto L_0x0005
            goto L_0x001f
        L_0x0005:
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0018 }
            r2 = 0
            r1.<init>(r3, r2)     // Catch:{ all -> 0x0018 }
            java.lang.String r3 = ""
            r4.store(r1, r3)     // Catch:{ all -> 0x0015 }
            r1.close()
            return
        L_0x0015:
            r3 = move-exception
            r0 = r1
            goto L_0x0019
        L_0x0018:
            r3 = move-exception
        L_0x0019:
            if (r0 == 0) goto L_0x001e
            r0.close()
        L_0x001e:
            throw r3
        L_0x001f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.sdk.MsfSdkUtils.saveConfig(java.lang.String, java.util.Properties):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Properties loadConfig(java.lang.String r3) throws java.lang.Exception {
        /*
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            if (r3 != 0) goto L_0x0008
            return r0
        L_0x0008:
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0018 }
            r2.<init>(r3)     // Catch:{ all -> 0x0018 }
            r0.load(r2)     // Catch:{ all -> 0x0015 }
            r2.close()
            return r0
        L_0x0015:
            r3 = move-exception
            r1 = r2
            goto L_0x0019
        L_0x0018:
            r3 = move-exception
        L_0x0019:
            if (r1 == 0) goto L_0x001e
            r1.close()
        L_0x001e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.sdk.MsfSdkUtils.loadConfig(java.lang.String):java.util.Properties");
    }

    public static FromServiceMsg constructResponse(ToServiceMsg toServiceMsg, int i, String str, Object obj) {
        if (toServiceMsg == null) {
            return new FromServiceMsg();
        }
        FromServiceMsg constructResponse = constructResponse(toServiceMsg.getUin(), toServiceMsg.getServiceCmd(), toServiceMsg.getAppId(), i, str, obj, toServiceMsg.getRequestSsoSeq());
        constructResponse.setAppSeq(toServiceMsg.getAppSeq());
        return constructResponse;
    }

    public static String getShortUin(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 4) {
            return str;
        }
        return "*" + str.substring(str.length() - 4, str.length());
    }

    public static String insertMtype(String str, String str2) {
        if (str2.contains("mType=") || str == null) {
            return str2;
        }
        int indexOf = str2.indexOf("?");
        if (indexOf > 0) {
            int i = indexOf + 1;
            if (str2.length() == i) {
                return str2.substring(0, i) + "mType=" + str;
            }
            int indexOf2 = str2.indexOf("#", indexOf);
            if (indexOf2 >= 0) {
                return str2.substring(0, indexOf2) + "&mType=" + str + str2.substring(indexOf2);
            }
            return str2 + "&mType=" + str;
        } else if (str2.length() <= 0) {
            return str2;
        } else {
            return str2 + "?mType=" + str;
        }
    }

    public static boolean isPrivilegeCMD(String str) {
        if (str == null) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = PRIVILEGE_CMDS;
            if (i >= strArr.length) {
                return false;
            }
            if (str.equals(strArr[i])) {
                return true;
            }
            i++;
        }
    }
}
