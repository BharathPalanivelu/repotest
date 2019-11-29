package cn.tongdun.android.core.ooxoxoooxooo0xx00;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class o00o0o0oo0oo0o000x00 {
    public static synchronized Map o00xxox0x0xoox(Context context) {
        Hashtable hashtable;
        String str;
        ApplicationInfo applicationInfo;
        boolean z;
        String str2;
        boolean z2;
        synchronized (o00o0o0oo0oo0o000x00.class) {
            PackageManager packageManager = context.getPackageManager();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            List installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages == null || installedPackages.size() == 0) {
                Intent intent = new Intent(o00xxox0x0xoox("53566b4076467b0c3c0b261a2d00774f7558685e691e0a120215", 7));
                intent.addCategory(o00xxox0x0xoox("53366b2076267b6c3c6b267a2d60772d7538643a6c276770057d11661c6d117a", 103));
                installedPackages = packageManager.queryIntentActivities(intent, 0);
            }
            Iterator it = installedPackages.iterator();
            String[] strArr = {o00xxox0x0xoox("517261312e3e2428392e3464", 32), o00xxox0x0xoox("51166155285d2855235c68", 68), o00xxox0x0xoox("512461673e632a6e2562276264", 118), o00xxox0x0xoox("551067186c11275e28543e49384472", 70), o00xxox0x0xoox("51006143275e3348214466", 82), o00xxox0x0xoox("5169612a222e3e3279", 59), o00xxox0x0xoox("5157611437053f0b3d0f7a", 5), o00xxox0x0xoox("51106153394c265567", 66), o00xxox0x0xoox("513461772068207761", 102), o00xxox0x0xoox("511361503c42305c36473f0e", 65), o00xxox0x0xoox("513461773c613a2c75237f3562336f79", 102), o00xxox0x0xoox("510a614923402841315870", 88), o00xxox0x0xoox("51746137363b2f382e3167", 38), o00xxox0x0xoox("514d610e28002e0125016e", 31), o00xxox0x0xoox("51016142234b32496a", 83), o00xxox0x0xoox("514161022e0f2b1f270467", 19), o00xxox0x0xoox("51416102360e2d0f3152", 19), o00xxox0x0xoox("510061433c5f3d48", 82), o00xxox0x0xoox("515e611d2701304c", 12), o00xxox0x0xoox("516c612f3521246a", 62), o00xxox0x0xoox("51166155225d2e402f1b", 68), o00xxox0x0xoox("516661252229312d22242266", 52), o00xxox0x0xoox("5138617b2370213b", 106), o00xxox0x0xoox("512061632b682b71", 114), o00xxox0x0xoox("5124616720662b73376a3137", 118), o00xxox0x0xoox("511f615c22542e47211c", 77), o00xxox0x0xoox("5138617b277a3d6c3671203a", 106), o00xxox0x0xoox("517a61393e213c3f67", 40), o00xxox0x0xoox("517b613838263f2f2c3e2a356c", 41), o00xxox0x0xoox("512e616d226f39742469276468", 124), o00xxox0x0xoox("51582318380f33077c", 11), o00xxox0x0xoox("512361603b7734", 113), o00xxox0x0xoox("512061633f6124723b39", 114), o00xxox0x0xoox("5139617a3c643077366a2c7823", 107), o00xxox0x0xoox("51116152355d291a", 67), o00xxox0x0xoox("5162612128343f3434352926262f2464", 48), o00xxox0x0xoox("515f611c2a0f3904201629166b", 13), o00xxox0x0xoox("516b61283e303c2e67", 57), o00xxox0x0xoox("5155611629023e02360a7d", 7), o00xxox0x0xoox("513161722e60286675", 99), o00xxox0x0xoox("517061333d2439213f2c297b", 34), o00xxox0x0xoox("510561462c4d25422c4d2b4c2205", 87), o00xxox0x0xoox("516461272c2b2c303d3e78", 54), o00xxox0x0xoox("513361702e7c2a722233", 97), o00xxox0x0xoox("51506113221b23162b033a0d7f", 2)};
            String[] strArr2 = {o00xxox0x0xoox("1c3e203020", 45)};
            String[] strArr3 = {o00xxox0x0xoox("71004e0c4b307e3b7728622025", 117)};
            Hashtable hashtable2 = new Hashtable();
            String str3 = null;
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (next instanceof ResolveInfo) {
                    applicationInfo = ((ResolveInfo) next).activityInfo.applicationInfo;
                    str = ((ResolveInfo) next).activityInfo.packageName;
                } else {
                    str = str3;
                    applicationInfo = null;
                }
                if (next instanceof PackageInfo) {
                    applicationInfo = ((PackageInfo) next).applicationInfo;
                    str = applicationInfo.packageName;
                }
                if ((applicationInfo.flags & 1) > 0) {
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z2 = false;
                            break;
                        }
                        String str4 = strArr[i2];
                        if (str.startsWith(str4)) {
                            String str5 = (String) hashtable2.get(str4);
                            if (str5 == null) {
                                hashtable2.put(str4, o00xxox0x0xoox("03", 27));
                            } else {
                                hashtable2.put(str4, Integer.toString(Integer.parseInt(str5) + 1));
                            }
                            z2 = true;
                        } else {
                            i2++;
                        }
                    }
                    int length2 = strArr2.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length2) {
                            break;
                        } else if (str.endsWith(strArr2[i3])) {
                            z2 = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (z2 || o00xxox0x0xoox("531e6b08760e7b", 79).equals(str)) {
                        str3 = str;
                    }
                }
                if ((applicationInfo.flags & 1) <= 0) {
                    int length3 = strArr3.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length3) {
                            z = false;
                            break;
                        } else if (str.startsWith(strArr3[i4])) {
                            z = true;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (!z) {
                        if (i < 20) {
                            str2 = packageManager.getApplicationLabel(applicationInfo).toString();
                        } else {
                            str2 = o00xxox0x0xoox("1f", 122);
                        }
                        i++;
                        if (i > 100) {
                            break;
                        }
                        if (sb.length() > 0) {
                            sb.append(o00xxox0x0xoox("1e", 43));
                        }
                        sb.append(str + o00xxox0x0xoox("08", 4) + str2);
                        if (sb2.length() > 0) {
                            sb2.append(o00xxox0x0xoox("1e", 53));
                        }
                        sb2.append(str);
                        sb2.append(o00xxox0x0xoox("08", 105));
                        sb2.append(str2);
                    }
                }
                str3 = str;
            }
            for (String str6 : hashtable2.keySet()) {
                if (Integer.parseInt((String) hashtable2.get(str6)) > 5) {
                    if (sb.length() > 0) {
                        sb.append(o00xxox0x0xoox("1e", 16));
                    }
                    sb.append(str6 + o00xxox0x0xoox("18", 119) + ((String) hashtable2.get(str6)));
                }
            }
            hashtable = new Hashtable();
            hashtable.put(o00xxox0x0xoox("517961647d6d6c7c", 43), sb.toString());
            hashtable.put(o00xxox0x0xoox("56316c33772e712f", 110), sb2.toString());
        }
        return hashtable;
    }

    public static String o00xxox0x0xoox(Context context, ActivityManager activityManager) {
        if (!xoo0xoo0oxo00x0o0.o00xxox0x0xoox(context, "android.permission.GET_TASKS")) {
            return o00xxox0x0xoox("5f7e777e5b51464f", 36);
        }
        StringBuilder sb = new StringBuilder();
        for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(Integer.MAX_VALUE)) {
            String packageName = runningTaskInfo.baseActivity.getPackageName();
            if (sb.length() > 0) {
                sb.append(o00xxox0x0xoox("1e", 40));
            }
            sb.append(packageName);
        }
        return sb.toString();
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
            byte b2 = (byte) (i ^ 94);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 50);
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
