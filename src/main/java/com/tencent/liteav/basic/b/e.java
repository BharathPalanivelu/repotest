package com.tencent.liteav.basic.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e {

    /* renamed from: d  reason: collision with root package name */
    private static e f31237d;

    /* renamed from: a  reason: collision with root package name */
    private Context f31238a;

    /* renamed from: b  reason: collision with root package name */
    private String f31239b = "YTFaceSDK.licence";

    /* renamed from: c  reason: collision with root package name */
    private String f31240c = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq4teqkW/TUruU89ElNVd\nKrpSL+HCITruyb6BS9mW6M4mqmxDhazDmQgMKNfsA0d2kxFucCsXTyesFNajaisk\nrAzVJpNGO75bQFap4jYzJYskIuas6fgIS7zSmGXgRcp6i0ZBH3pkVCXcgfLfsVCO\n+sN01jFhFgOC0LY2f1pJ+3jqktAlMIxy8Q9t7XwwL5/n8/Sledp7TwuRdnl2OPl3\nycCTRkXtOIoRNB9vgd9XooTKiEdCXC7W9ryvtwCiAB82vEfHWXXgzhsPC13URuFy\n1JqbWJtTCCcfsCVxuBplhVJAQ7JsF5SMntdJDkp7rJLhprgsaim2CRjcVseNmw97\nbwIDAQAB";

    /* renamed from: e  reason: collision with root package name */
    private a f31241e = new a("TXUgcSDK.licence");

    /* renamed from: f  reason: collision with root package name */
    private a f31242f = new a("TXLiveSDK.licence");

    private class a {

        /* renamed from: a  reason: collision with root package name */
        String f31245a;

        /* renamed from: b  reason: collision with root package name */
        String f31246b;

        /* renamed from: c  reason: collision with root package name */
        String f31247c = "";

        /* renamed from: d  reason: collision with root package name */
        String f31248d = "";

        /* renamed from: e  reason: collision with root package name */
        String f31249e = "";

        /* renamed from: f  reason: collision with root package name */
        boolean f31250f = false;

        /* renamed from: g  reason: collision with root package name */
        boolean f31251g = false;
        int h = -1;
        String i = "";

        public a(String str) {
            this.f31245a = str;
            this.f31246b = str + DefaultDiskStorage.FileType.TEMP;
        }
    }

    public static e a() {
        if (f31237d == null) {
            f31237d = new e();
        }
        return f31237d;
    }

    private e() {
    }

    public void a(Context context, String str, String str2) {
        a(this.f31242f, context, str, str2);
    }

    private void a(a aVar, Context context, String str, String str2) {
        if (context != null) {
            this.f31238a = context.getApplicationContext();
        }
        aVar.f31248d = str2;
        aVar.f31249e = str;
        if (this.f31238a != null && b()) {
            File externalFilesDir = this.f31238a.getExternalFilesDir((String) null);
            if (externalFilesDir != null) {
                aVar.f31247c = externalFilesDir.getAbsolutePath();
            }
            if (!b(aVar.f31247c + File.separator + aVar.f31245a)) {
                TXCLog.d("LicenceCheck", "setLicense, sdcard file not exist, to download");
                a(aVar);
            }
        }
    }

    public void a(final a aVar) {
        if (TextUtils.isEmpty(aVar.f31249e)) {
            TXCLog.e("LicenceCheck", "downloadLicense, mUrl is empty, ignore!");
        } else if (aVar.f31250f) {
            TXCLog.i("LicenceCheck", "downloadLicense, in downloading, ignore");
        } else {
            AnonymousClass1 r7 = new b() {
                public void a(File file) {
                    TXCLog.i("LicenceCheck", "downloadLicense, onSaveSuccess");
                    String a2 = e.this.f(aVar);
                    if (TextUtils.isEmpty(a2)) {
                        TXCLog.e("LicenceCheck", "downloadLicense, readDownloadTempLicence is empty!");
                        aVar.f31250f = false;
                    } else if (e.this.c(aVar, a2) == 0) {
                        e.this.e(aVar);
                    }
                }

                public void a(File file, Exception exc) {
                    TXCLog.i("LicenceCheck", "downloadLicense, onSaveFailed");
                }

                public void a(int i) {
                    TXCLog.i("LicenceCheck", "downloadLicense, onProgressUpdate");
                }

                public void a() {
                    TXCLog.i("LicenceCheck", "downloadLicense, onProcessEnd");
                    aVar.f31250f = false;
                }
            };
            Context context = this.f31238a;
            if (context == null) {
                TXCLog.e("LicenceCheck", "context is NULL !!! Please set context in method:setLicense(Context context, String url, String key)");
                return;
            }
            File externalFilesDir = context.getExternalFilesDir((String) null);
            if (externalFilesDir == null) {
                TXCLog.e("LicenceCheck", "Please check permission WRITE_EXTERNAL_STORAGE permission has been set !!!");
                return;
            }
            aVar.f31247c = externalFilesDir.getAbsolutePath();
            new Thread(new c(this.f31238a, aVar.f31249e, aVar.f31247c, aVar.f31246b, r7, false)).start();
            aVar.f31250f = true;
        }
    }

    public int a(f fVar, Context context) {
        return a(this.f31242f, fVar, context);
    }

    private int a(a aVar, f fVar, Context context) {
        int a2 = a(aVar, context);
        if (a2 != 0) {
            a(aVar);
        }
        if (fVar != null) {
            fVar.f31252a = aVar.i;
        }
        return a2;
    }

    private int a(a aVar, Context context) {
        if (aVar.f31251g) {
            return 0;
        }
        if (this.f31238a == null) {
            this.f31238a = context;
        }
        if (c(aVar) == 0) {
            aVar.f31251g = true;
            return 0;
        }
        int b2 = b(aVar);
        if (b2 != 0) {
            return b2;
        }
        aVar.f31251g = true;
        return 0;
    }

    private int b(a aVar) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            TXCLog.e("LicenceCheck", "checkSdcardLicence, sdcard not mounted yet!");
            return -10;
        }
        File externalFilesDir = this.f31238a.getExternalFilesDir((String) null);
        if (externalFilesDir == null) {
            TXCLog.e("LicenceCheck", "checkSdcardLicence, mContext.getExternalFilesDir is null!");
            return -10;
        }
        String str = externalFilesDir.getAbsolutePath() + File.separator + aVar.f31245a;
        if (!b(str)) {
            return -7;
        }
        String b2 = com.tencent.liteav.basic.util.a.b(str);
        if (!TextUtils.isEmpty(b2)) {
            return a(aVar, b2);
        }
        TXCLog.e("LicenceCheck", "checkSdcardLicence, licenceSdcardStr is empty");
        return -8;
    }

    private int c(a aVar) {
        if (!d(aVar)) {
            return -6;
        }
        String b2 = com.tencent.liteav.basic.util.a.b(this.f31238a, aVar.f31245a);
        if (!TextUtils.isEmpty(b2)) {
            return a(aVar, b2);
        }
        TXCLog.e("LicenceCheck", "checkAssetLicence, licenceSdcardStr is empty");
        return -8;
    }

    public int a(a aVar, String str) {
        try {
            new JSONObject(str);
            return c(aVar, str);
        } catch (JSONException unused) {
            if (aVar == this.f31242f) {
                return -1;
            }
            return d(aVar, str);
        }
    }

    private boolean b() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            TXCLog.e("LicenceCheck", "checkSdcardLicence, sdcard not mounted yet!");
            return false;
        } else if (this.f31238a.getExternalFilesDir((String) null) != null) {
            return true;
        } else {
            TXCLog.e("LicenceCheck", "checkSdcardLicence, mContext.getExternalFilesDir is null!");
            return false;
        }
    }

    private boolean d(a aVar) {
        return com.tencent.liteav.basic.util.a.a(this.f31238a, aVar.f31245a);
    }

    private boolean b(String str) {
        return com.tencent.liteav.basic.util.a.a(str);
    }

    /* access modifiers changed from: private */
    public void e(a aVar) {
        File file = new File(this.f31238a.getExternalFilesDir((String) null).getAbsolutePath() + File.separator + aVar.f31245a);
        if (file.exists()) {
            boolean delete = file.delete();
            TXCLog.i("LicenceCheck", "delete dst file:" + delete);
        }
        File file2 = new File(aVar.f31247c + File.separator + aVar.f31246b);
        if (file2.exists()) {
            boolean renameTo = file2.renameTo(file);
            TXCLog.i("LicenceCheck", "rename file:" + renameTo);
        }
        aVar.f31251g = true;
    }

    private static long c(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public PublicKey a(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
    }

    private String b(a aVar, String str) {
        if (TextUtils.isEmpty(aVar.f31248d)) {
            TXCLog.e("LicenceCheck", "decodeLicence, mKey is empty!!!");
            return "";
        }
        byte[] bytes = aVar.f31248d.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        byte[] bArr = new byte[16];
        int i = 0;
        while (i < bytes.length && i < bArr.length) {
            bArr[i] = bytes[i];
            i++;
        }
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        byte[] decode = Base64.decode(str, 0);
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, ivParameterSpec);
            String str2 = new String(instance.doFinal(decode), "UTF-8");
            TXCLog.i("LicenceCheck", "decodeLicence : " + str2);
            return str2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public int c(a aVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("appId");
            String string = jSONObject.getString("encryptedLicense");
            String string2 = jSONObject.getString("signature");
            TXCLog.i("LicenceCheck", "appid:" + optInt);
            TXCLog.i("LicenceCheck", "encryptedLicense:" + string);
            TXCLog.i("LicenceCheck", "signature:" + string2);
            return a(aVar, string, string2);
        } catch (JSONException e2) {
            e2.printStackTrace();
            a(-1);
            return -1;
        }
    }

    private int a(a aVar, String str, String str2) {
        boolean z;
        try {
            z = a(Base64.decode(str, 0), Base64.decode(str2, 0), a(this.f31240c));
        } catch (Exception e2) {
            e2.printStackTrace();
            TXCLog.e("LicenceCheck", "verifyLicence, exception is : " + e2);
            z = false;
        }
        if (!z) {
            a(-2);
            TXCLog.e("LicenceCheck", "verifyLicence, signature not pass!");
            return -2;
        }
        String b2 = b(aVar, str);
        if (TextUtils.isEmpty(b2)) {
            a(-3);
            TXCLog.e("LicenceCheck", "verifyLicence, decodeValue is empty!");
            return -3;
        }
        aVar.i = b2;
        try {
            JSONObject jSONObject = new JSONObject(b2);
            String string = jSONObject.getString("pituLicense");
            JSONArray optJSONArray = jSONObject.optJSONArray("appData");
            if (optJSONArray == null) {
                TXCLog.e("LicenceCheck", "verifyLicence, appDataArray is null!");
                a(-1);
                return -1;
            }
            int i = 0;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            while (true) {
                if (i >= optJSONArray.length()) {
                    break;
                }
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                String optString = jSONObject2.optString("packageName");
                TXCLog.i("LicenceCheck", "verifyLicence, packageName:" + optString);
                if (optString.equals(this.f31238a.getPackageName())) {
                    if (!d(jSONObject2.optString("endDate"))) {
                        boolean a2 = a(aVar, jSONObject2, string);
                        if (a2) {
                            z2 = true;
                            z3 = true;
                            z4 = true;
                            break;
                        }
                        z4 = a2;
                        z2 = true;
                        z3 = true;
                    } else {
                        z2 = true;
                    }
                } else {
                    TXCLog.e("LicenceCheck", "verifyLicence, packageName not match!");
                }
                i++;
            }
            if (!z2) {
                a(-4);
                return -4;
            } else if (!z3) {
                a(-5);
                return -5;
            } else if (!z4) {
                a(-11);
                return -11;
            } else {
                if (!TextUtils.isEmpty(string)) {
                    try {
                        byte[] decode = Base64.decode(string, 0);
                        String absolutePath = this.f31238a.getExternalFilesDir((String) null).getAbsolutePath();
                        File file = new File(absolutePath + File.separator + this.f31239b);
                        com.tencent.liteav.basic.util.a.a(file.getAbsolutePath(), decode);
                        TXCCommonUtil.setPituLicencePath(file.getAbsolutePath());
                    } catch (Exception e3) {
                        TXCLog.e("LicenceCheck", "decode pitu license error:" + e3);
                    }
                }
                TXCDRApi.txReportDAU(this.f31238a, com.tencent.liteav.basic.datareport.a.aI);
                return 0;
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
            TXCLog.e("LicenceCheck", "verifyLicence, json format error ! exception = " + e4);
            a(-1);
            return -1;
        }
    }

    private boolean a(a aVar, JSONObject jSONObject, String str) {
        int optInt = jSONObject.optInt("feature");
        boolean z = false;
        if (aVar == this.f31242f) {
            int i = (optInt >> 4) & 15;
            if (i >= 1) {
                aVar.h = i;
                z = true;
            }
            TXCLog.i("LicenceCheck", "live parseVersionType, mLicenceVersionType = " + aVar.h);
        } else if (aVar == this.f31241e) {
            int i2 = optInt & 15;
            if (i2 <= 1) {
                if (i2 == 1 || optInt == 0) {
                    if (!TextUtils.isEmpty(str)) {
                        aVar.h = 5;
                    } else {
                        aVar.h = 3;
                    }
                }
                TXCLog.i("LicenceCheck", "ugc parseVersionType, mLicenceVersionType = " + aVar.h);
            } else {
                aVar.h = i2;
            }
            z = true;
            TXCLog.i("LicenceCheck", "ugc parseVersionType, mLicenceVersionType = " + aVar.h);
        }
        return z;
    }

    private void a(int i) {
        TXCDRApi.txReportDAU(this.f31238a, com.tencent.liteav.basic.datareport.a.aJ, i, "");
    }

    private boolean d(String str) {
        long c2 = c(str);
        if (c2 < 0) {
            TXCLog.e("LicenceCheck", "checkEndDate, end date millis < 0!");
            return true;
        } else if (c2 >= System.currentTimeMillis()) {
            return false;
        } else {
            TXCLog.e("LicenceCheck", "checkEndDate, end date expire!");
            return true;
        }
    }

    private int d(a aVar, String str) {
        String e2 = e(str);
        if (TextUtils.isEmpty(e2)) {
            TXCLog.e("LicenceCheck", "verifyOldLicence, decryptStr is empty");
            return -3;
        }
        aVar.i = e2;
        try {
            JSONObject jSONObject = new JSONObject(e2);
            if (!jSONObject.getString("packagename").equals(a(this.f31238a))) {
                TXCLog.e("LicenceCheck", "packagename not match!");
                a(-4);
                return -4;
            } else if (d(jSONObject.getString("enddate"))) {
                return -5;
            } else {
                aVar.h = 5;
                TXCDRApi.txReportDAU(this.f31238a, com.tencent.liteav.basic.datareport.a.aI);
                return 0;
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
            TXCLog.e("LicenceCheck", "verifyOldLicence, json format error !");
            a(-1);
            return -1;
        }
    }

    private static String a(Context context) {
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return "";
    }

    private String e(String str) {
        try {
            return new String(g.b(Base64.decode(str, 0), Base64.decode("MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKfMXaF6wx9lev2U\nIzkk6ydI2sdaSQAD2ZvDBLq+5Fm6nGwSSWawl03D4vHcWIUa3wnz6f19/y8wzrj4\nnTfcEnT94SPdB6GhGsqPwbwRp9MHAqd/2gWZxSb005il2yiOZafk6X4NGKCn2tGd\nyNaCF+m9rLykuLdZHB0Z53ivgseNAgMBAAECgYAvXI2pAH+Goxwd6uwuOu9svTGT\nRzaHnI6VWmxBUZQeh3+TOW4iYAG03291GN6bY0RFCOWouSGH7lzK9NFbbPCAQ/hx\ncO48PqioHoq7K8sqzd3XaYBv39HrRnM8JvZsqv0PLJwX/LGm2y/MRaKAC6bcHtse\npgh+NNmUxXNRcTMRAQJBANezmenBcR8HTcY5YaEk3SQRzOo+QhIXuuD4T/FESpVJ\nmVQGxJjLsEBua1j38WG2QuepE5JiVbkQ0jQSvhUiZK0CQQDHJa+vWu6l72lQAvIx\nwmRISorvLb/tnu5bH0Ele42oX+w4p/tm03awdVjhVANnpDjYS2H6EzrF/pfis7k9\nV2phAkB4E4gz47bYYhV+qsTZkw70HGCpab0YG1OyFylRkwW983nCl/3rXUChrZZe\nsbATCAZYtfuqOsmju2R5DpH4a+wFAkBmHlcWbmSNxlSUaM5U4b+WqlLQDv+qE6Na\nKo63b8HWI0n4S3tI4QqttZ7b/L66OKXFk/Ir0AyFVuX/o/VLFTZBAkAdSTEkGwE5\nGQmhxu95sKxmdlUY6Q0Gwwpi06C1BPBrj2VkGXpBP0twhPVAq/3xVjjb+2KXVTUW\nIpRLc06M4vhv", 0)));
        } catch (Exception e2) {
            e2.printStackTrace();
            TXCLog.e("LicenceCheck", "decryptLicenceStr, exception is : " + e2);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public String f(a aVar) {
        return com.tencent.liteav.basic.util.a.b(new File(aVar.f31247c + File.separator + aVar.f31246b).getAbsolutePath());
    }

    public static boolean a(byte[] bArr, byte[] bArr2, PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature instance = Signature.getInstance("SHA256WithRSA");
        instance.initVerify(publicKey);
        instance.update(bArr);
        return instance.verify(bArr2);
    }
}
