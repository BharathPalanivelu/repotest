package com.tencent.imsdk;

import android.os.Build;
import android.util.Base64;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import com.tencent.imcore.QrEventType;
import com.tencent.imsdk.utils.QualityReportHelper;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class IMFunc {
    private static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public interface RequestListener {
        void onFail(String str);

        void onSuccess(byte[] bArr);
    }

    public static String appSignature(int i, String str, String str2, long j, String str3, String str4) throws Exception {
        if (str == null || str2 == null || str3 == null || str4 == null) {
            return "-1";
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String str5 = "a=" + i + "&k=" + str + "&e=" + (j + currentTimeMillis) + "&t=" + currentTimeMillis + "&r=" + Math.abs(new Random().nextInt()) + "&f=" + str3 + "&b=" + str4;
        byte[] hmacSHA1 = getHmacSHA1(str5.getBytes(), str2);
        byte[] bArr = new byte[(hmacSHA1.length + str5.getBytes().length)];
        System.arraycopy(hmacSHA1, 0, bArr, 0, hmacSHA1.length);
        System.arraycopy(str5.getBytes(), 0, bArr, hmacSHA1.length, str5.getBytes().length);
        return base64Encode(bArr);
    }

    public static String base64Encode(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    public static String byte2hex(byte[] bArr) {
        TIMSdkConfig sdkConfig = TIMManager.getInstance().getSdkConfig();
        return (sdkConfig == null || sdkConfig.getLogLevel() != TIMLogLevel.DEBUG) ? "loglevel too high" : byte2hexInternal(bArr);
    }

    public static String byte2hexInternal(byte[] bArr) {
        try {
            StringBuilder sb = new StringBuilder();
            if (bArr == null || bArr.length == 0) {
                return "b2h failed";
            }
            for (byte b2 : bArr) {
                char c2 = digits[b2 & 15];
                sb.append(digits[((byte) (b2 >>> 4)) & 15]);
                sb.append(c2);
            }
            return sb.toString();
        } catch (OutOfMemoryError unused) {
            System.gc();
            return "b2h failed";
        }
    }

    public static String calcSHA(byte[] bArr) throws Exception {
        MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_SHA1);
        instance.update(bArr);
        return byte2hexInternal(instance.digest()).replace(SQLBuilder.BLANK, "");
    }

    public static int getClientInstType() {
        String str = Build.MANUFACTURER;
        if (isBrandXiaoMi()) {
            return 2000;
        }
        if (isBrandHuawei()) {
            return 2001;
        }
        return isBrandMeizu() ? 2003 : 2002;
    }

    public static String getExceptionInfo(Throwable th) {
        if (th == null) {
            return "";
        }
        String th2 = th.toString();
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                th2 = th2 + "\n\tat " + stackTraceElement.toString();
            }
        }
        return th2;
    }

    public static byte[] getHmacSHA1(byte[] bArr, String str) throws Exception {
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec(str.getBytes(), "HmacSHA1"));
        try {
            return instance.doFinal(bArr);
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public static byte[] getParamBytes(String str, String str2, String str3, String str4) {
        return ("--" + str + "\r\nContent-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + str3 + "\"\r\n\r\n" + str4 + IOUtils.LINE_SEPARATOR_WINDOWS).getBytes();
    }

    public static byte[] getParamBytes(String str, String str2, String str3, byte[] bArr) {
        byte[] bytes = ("--" + str + "\r\nContent-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + str3 + "\"\r\n\r\n").getBytes();
        byte[] bArr2 = new byte[(bytes.length + bArr.length + 2)];
        System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
        System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
        System.arraycopy(IOUtils.LINE_SEPARATOR_WINDOWS.getBytes(), 0, bArr2, bytes.length + bArr.length, 2);
        return bArr2;
    }

    public static byte[] gzCompress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean httpPostReq(String str, byte[] bArr, Map<String, String> map, RequestListener requestListener) {
        try {
            new Thread(new au((HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection())), bArr, map, requestListener)).start();
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            if (requestListener == null) {
                return false;
            }
            requestListener.onFail(getExceptionInfo(th));
            return false;
        }
    }

    public static boolean isBrandHuawei() {
        return "huawei".equalsIgnoreCase(Build.BRAND) || "huawei".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isBrandMeizu() {
        return "meizu".equalsIgnoreCase(Build.BRAND) || "meizu".equalsIgnoreCase(Build.MANUFACTURER) || "22c4185e".equalsIgnoreCase(Build.BRAND);
    }

    public static boolean isBrandXiaoMi() {
        return "xiaomi".equalsIgnoreCase(Build.BRAND) || "xiaomi".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static int preCheck(boolean z, Object obj, QualityReportHelper qualityReportHelper) {
        IMErrInfo iMErrInfo = z ? new IMErrInfo(BaseConstants.ERR_INVALID_PARAMETERS, "invalid param.") : !IMCoreWrapper.get().isIMCoreInited() ? new IMErrInfo(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not initialized") : !IMCoreWrapper.get().isIMCoreUserInited() ? new IMErrInfo(BaseConstants.ERR_SDK_NOT_LOGGED_IN, "user not logged in.") : null;
        if (iMErrInfo == null) {
            return 0;
        }
        if (obj != null) {
            if (obj instanceof TIMValueCallBack) {
                ((TIMValueCallBack) obj).onError(iMErrInfo.getCode(), iMErrInfo.getMsg());
            } else if (obj instanceof TIMCallBack) {
                ((TIMCallBack) obj).onError(iMErrInfo.getCode(), iMErrInfo.getMsg());
            }
        }
        if (!(qualityReportHelper == null || qualityReportHelper.getEventId() == QrEventType.kEventMax.swigValue())) {
            qualityReportHelper.init(iMErrInfo.getCode(), iMErrInfo.getMsg());
            qualityReportHelper.report();
        }
        return iMErrInfo.getCode();
    }
}
