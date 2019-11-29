package com.tencent.qalsdk.core;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.sdk.MsfSdkUtils;
import com.tencent.qalsdk.util.QLog;
import java.io.File;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static String f32192a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f32193b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f32194c = "";

    /* renamed from: d  reason: collision with root package name */
    private static String f32195d = "";

    /* renamed from: e  reason: collision with root package name */
    private static String f32196e = "qalimid";

    /* renamed from: f  reason: collision with root package name */
    private static String f32197f = "qalimid9";

    public static FromServiceMsg a(ToServiceMsg toServiceMsg) {
        FromServiceMsg fromServiceMsg = new FromServiceMsg(toServiceMsg.getUin(), toServiceMsg.getServiceCmd());
        fromServiceMsg.setAppId(toServiceMsg.getAppId());
        fromServiceMsg.setAppSeq(toServiceMsg.getAppSeq());
        fromServiceMsg.setRequestSsoSeq(toServiceMsg.getRequestSsoSeq());
        fromServiceMsg.setMsfCommand(toServiceMsg.getMsfCommand());
        fromServiceMsg.addAttribute("to_SenderProcessName", toServiceMsg.getAttribute("to_SenderProcessName"));
        fromServiceMsg.addAttribute("__timestamp_net2msf", Long.valueOf(System.currentTimeMillis()));
        return fromServiceMsg;
    }

    public static void a(Context context) {
        String str;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
                    f32193b = null;
                    str = f32192a;
                    if (str != null || str.length() == 0) {
                        f32192a = e();
                        QLog.i("MSF.C.Util", 2, "load imei:" + f32192a);
                    }
                    return;
                }
            }
            f32193b = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception e2) {
            QLog.d("MSF.C.Util", 1, "read sys imei error " + e2, e2);
        }
        str = f32192a;
        if (str != null) {
        }
        f32192a = e();
        QLog.i("MSF.C.Util", 2, "load imei:" + f32192a);
    }

    public static String a() {
        return f32192a;
    }

    public static String b() {
        return f32193b;
    }

    public static String c() {
        return f32194c;
    }

    public static String d() {
        return f32195d;
    }

    private static String e() {
        String str;
        File file = new File(j.a().n);
        try {
            if (file.exists()) {
                String property = MsfSdkUtils.loadConfig(j.a().n).getProperty(f32196e);
                String str2 = f32197f;
                byte[] decode = Base64.decode(property, 0);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes("ASCII"));
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "DES");
                Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
                instance.init(2, secretKeySpec, ivParameterSpec);
                str = new String(instance.doFinal(decode));
                QLog.i("MSF.C.Util", "file exit,get imei: " + str + ":" + property);
            } else {
                str = null;
            }
            if (str != null && str.length() > 0) {
                return str;
            }
        } catch (Exception e2) {
            QLog.d("MSF.C.Util", 1, "load sys imei error", e2);
        }
        String uuid = UUID.randomUUID().toString();
        if (uuid == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 15; i++) {
                stringBuffer.append(new Random().nextInt(10));
            }
            uuid = stringBuffer.toString();
        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                Properties loadConfig = MsfSdkUtils.loadConfig(j.a().n);
                String str3 = f32197f;
                IvParameterSpec ivParameterSpec2 = new IvParameterSpec(str3.getBytes("ASCII"));
                SecretKeySpec secretKeySpec2 = new SecretKeySpec(str3.getBytes(), "DES");
                Cipher instance2 = Cipher.getInstance("DES/CBC/PKCS5Padding");
                instance2.init(1, secretKeySpec2, ivParameterSpec2);
                String encodeToString = Base64.encodeToString(instance2.doFinal(uuid.getBytes()), 0);
                loadConfig.put(f32196e, encodeToString);
                MsfSdkUtils.saveConfig(j.a().n, loadConfig);
                QLog.d("MSF.C.Util", "save random imei " + f32196e + ":" + uuid + ":" + encodeToString);
            } else if (QLog.isColorLevel()) {
                QLog.d("MSF.C.Util", 2, "can not create imei file");
            }
        } catch (Exception e3) {
            QLog.d("MSF.C.Util", 1, "load imei error", e3);
        }
        return uuid;
    }
}
