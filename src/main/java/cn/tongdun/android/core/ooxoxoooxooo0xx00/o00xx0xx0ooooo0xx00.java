package cn.tongdun.android.core.ooxoxoooxooo0xx00;

import android.text.TextUtils;
import cn.tongdun.android.core.O0o0o0o0o;
import cn.tongdun.android.core.o00xx0xx0ooooo0xx00.oo0ooo0o00o0xo;
import cn.tongdun.android.core.o00xxox0x0xoox.o00xxox0x0xoox;
import cn.tongdun.android.core.x0000xo0x0oooooo0.o00o0o0oo0oo0o000x00;
import cn.tongdun.android.core.x0000xo0x0oooooo0.o0oo0xx00ooo0oox0xx0;
import cn.tongdun.android.core.x0000xo0x0oooooo0.xoo0xoo0oxo00x0o0;
import cn.tongdun.android.shell.common.CollectorError;
import cn.tongdun.android.shell.common.HelperJNI;
import cn.tongdun.android.shell.utils.BoxUtil;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class o00xx0xx0ooooo0xx00 {
    private static final String[] o00xx0xx0ooooo0xx00 = {o00xxox0x0xoox("501659", 3), o00xxox0x0xoox("507c51", 110), o00xxox0x0xoox("505c5c", 69), o00xxox0x0xoox("502251", 54), o00xxox0x0xoox("50215e", 51), o00xxox0x0xoox("504e5c4e", 94), o00xxox0x0xoox("500f50", 28), o00xxox0x0xoox("50165f", 14)};
    public static final String o00xxox0x0xoox = o00xxox0x0xoox("6752614f7d466c57", 43);
    public static final String oo0ooo0o00o0xo = o00xxox0x0xoox("60546c56774b714a", 32);
    private static final String[] x0000xo0x0oooooo0 = {o00xxox0x0xoox("507755", 103), o00xxox0x0xoox("502d54", 61), o00xxox0x0xoox("503157", 33), o00xxox0x0xoox("502256", 50), o00xxox0x0xoox("501d55", 10), o00xxox0x0xoox("507951", 106), o00xxox0x0xoox("50695b", 126), o00xxox0x0xoox("50355a", 35), o00xxox0x0xoox("50185d", 0), o00xxox0x0xoox("507e5a", 103), o00xxox0x0xoox("50005c", 24), o00xxox0x0xoox("503b553a", 43), o00xxox0x0xoox("503b5539", 43), o00xxox0x0xoox("50125511", 2)};

    public static byte[] o00xxox0x0xoox(o00o0o0oo0oo0o000x00 o00o0o0oo0oo0o000x00, String str, int i) throws IllegalAccessException, JSONException, UnsupportedEncodingException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (Field field : o00o0o0oo0oo0o000x00.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(o00xxox0x0xoox.class)) {
                field.setAccessible(true);
                o00xxox0x0xoox o00xxox0x0xoox2 = (o00xxox0x0xoox) field.getAnnotation(o00xxox0x0xoox.class);
                xoo0xoo0oxo00x0o0 xoo0xoo0oxo00x0o0 = (xoo0xoo0oxo00x0o0) field.get(o00o0o0oo0oo0o000x00);
                if (xoo0xoo0oxo00x0o0 == null) {
                    jSONObject.put(o00xxox0x0xoox2.o00xxox0x0xoox(), "");
                } else if (xoo0xoo0oxo00x0o0.o00xx0xx0ooooo0xx00) {
                    if (xoo0xoo0oxo00x0o0.o00xxox0x0xoox instanceof cn.tongdun.android.core.x0000xo0x0oooooo0.o00xxox0x0xoox) {
                        String o00xxox0x0xoox3 = ((cn.tongdun.android.core.x0000xo0x0oooooo0.o00xxox0x0xoox) xoo0xoo0oxo00x0o0.o00xxox0x0xoox).o00xxox0x0xoox();
                        if (o00xxox0x0xoox3 != null) {
                            jSONObject.put(o00xxox0x0xoox2.o00xxox0x0xoox(), o00xxox0x0xoox3);
                        }
                    } else if (xoo0xoo0oxo00x0o0.o00xxox0x0xoox instanceof String) {
                        jSONObject.put(o00xxox0x0xoox2.o00xxox0x0xoox(), xoo0xoo0oxo00x0o0.o00xxox0x0xoox);
                    } else if (xoo0xoo0oxo00x0o0.o00xxox0x0xoox instanceof Map) {
                        String str2 = (String) ((Map) xoo0xoo0oxo00x0o0.o00xxox0x0xoox).get(oo0ooo0o00o0xo);
                        String str3 = (String) ((Map) xoo0xoo0oxo00x0o0.o00xxox0x0xoox).get(o00xxox0x0xoox);
                        String o00xxox0x0xoox4 = o00xxox0x0xoox2.o00xxox0x0xoox();
                        if (!str.equals(oo0ooo0o00o0xo)) {
                            str2 = str3;
                        }
                        jSONObject.put(o00xxox0x0xoox4, str2);
                    } else if (xoo0xoo0oxo00x0o0.o00xxox0x0xoox != null) {
                        jSONObject.put(o00xxox0x0xoox2.o00xxox0x0xoox(), xoo0xoo0oxo00x0o0.o00xxox0x0xoox);
                    }
                } else if (!ox000o0o.o00xxox0x0xoox(xoo0xoo0oxo00x0o0.oo0ooo0o00o0xo)) {
                    jSONObject2.put(o00xxox0x0xoox2.o00xxox0x0xoox(), xoo0xoo0oxo00x0o0.oo0ooo0o00o0xo);
                }
            }
        }
        long optInt = (long) jSONObject.optInt(o00xxox0x0xoox("506b50", 127));
        long optLong = jSONObject.optLong(o00xxox0x0xoox("507b52", 110));
        if (optLong != 0) {
            jSONObject.put(o00xxox0x0xoox("501250", 6), optInt ^ optLong);
        }
        jSONObject.put(o00xxox0x0xoox("507355", 106), o0oo0xx00ooo0oox0xx0.x0ox00x0oooo0xxx);
        o0oo0xx00ooo0oox0xx0.x0ox00x0oooo0xxx = "";
        jSONObject2.put(o00xxox0x0xoox("6b2b732664", 69), CollectorError.getErrorMsg());
        jSONObject.put(o00xxox0x0xoox("50715c71", 97), jSONObject2.toString());
        String jSONObject3 = jSONObject.toString();
        if (str.equals(oo0ooo0o00o0xo)) {
            jSONObject.put(o00xxox0x0xoox("745e635879536e", 58), cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox.xo00x00xo00);
            return o00xxox0x0xoox(jSONObject, i).getBytes(o00xxox0x0xoox("717b673072", 15));
        }
        O0o0o0o0o.o0ooo0oo0oo0o = oo0ooo0o00o0xo.o00xxox0x0xoox(36);
        HelperJNI.exprot(2, 0);
        BoxUtil.stamp = System.currentTimeMillis();
        String str4 = BoxUtil.stamp + O0o0o0o0o.o0o0oo;
        return (jSONObject3 + (str4 + o00xxox0x0xoox("29", 7) + (str4.length() + 1))).getBytes(o00xxox0x0xoox("7142670972", 54));
    }

    private static String o00xxox0x0xoox(JSONObject jSONObject, int i) throws JSONException {
        double d2 = (double) ((((((i * 3) / 4) - 1024) * 3) / 4) - 16);
        Double.isNaN(d2);
        int i2 = (int) (d2 / 0.7d);
        if (i2 < 1024) {
            i2 = 1024;
        }
        if (jSONObject.toString().length() < i2) {
            return jSONObject.toString();
        }
        Iterator<String> keys = jSONObject.keys();
        ArrayList arrayList = new ArrayList();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        int i3 = 0;
        while (true) {
            String[] strArr = x0000xo0x0oooooo0;
            if (i3 < strArr.length) {
                if (arrayList.contains(strArr[i3])) {
                    jSONObject.remove(x0000xo0x0oooooo0[i3]);
                }
                if (jSONObject.toString().length() < i2) {
                    return jSONObject.toString();
                }
                i3++;
            } else {
                int i4 = 0;
                while (true) {
                    String[] strArr2 = o00xx0xx0ooooo0xx00;
                    if (i4 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i4];
                    if (jSONObject.toString().length() < i2) {
                        break;
                    }
                    if (arrayList.contains(str)) {
                        if (o00xxox0x0xoox("504551", 87).equals(str)) {
                            jSONObject.put(str, o00xxox0x0xoox(new JSONArray(jSONObject.getString(str)), 3).toString());
                        } else if (o00xxox0x0xoox("503350", 32).equals(str)) {
                            String string = jSONObject.getString(str);
                            if (string.contains(o00xxox0x0xoox("59192a", 29))) {
                                String[] split = string.trim().split(o00xxox0x0xoox("58482d382a", 60));
                                JSONArray o00xxox0x0xoox2 = o00xxox0x0xoox(new JSONArray(split[0] + o00xxox0x0xoox("59", 46)), 1);
                                JSONArray o00xxox0x0xoox3 = o00xxox0x0xoox(new JSONArray(o00xxox0x0xoox("5f", 123) + split[1]), 1);
                                jSONObject.put(str, o00xxox0x0xoox2.toString() + o00xxox0x0xoox("28", 127) + o00xxox0x0xoox3.toString());
                            } else {
                                jSONObject.put(str, o00xxox0x0xoox(new JSONArray(jSONObject.getString(str)), 1).toString());
                            }
                        } else if (o00xxox0x0xoox("502b5f", 51).equals(str)) {
                            o00xxox0x0xoox(jSONObject, str);
                        } else {
                            jSONObject.put(str, "");
                        }
                    }
                    i4++;
                }
                return jSONObject.toString();
            }
        }
    }

    private static void o00xxox0x0xoox(JSONObject jSONObject, String str) throws JSONException {
        String string = jSONObject.getString(str);
        if (TextUtils.isEmpty(string)) {
            jSONObject.remove(str);
            return;
        }
        String[] split = string.split(o00xxox0x0xoox("584c", 25));
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < split.length; i3++) {
            if (!"".equals(split[i3])) {
                i++;
                i2 = (split[i3].length() * i) + i3;
                if (i == 3) {
                    break;
                }
            }
        }
        if (i == 0) {
            jSONObject.remove(str);
        } else {
            jSONObject.put(str, string.substring(0, i2));
        }
    }

    private static JSONArray o00xxox0x0xoox(JSONArray jSONArray, int i) throws JSONException {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        int i2 = 0;
        while (i2 < length && i2 < i) {
            jSONArray2.put(jSONArray.get(i2));
            i2++;
        }
        return jSONArray2;
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
            byte b2 = (byte) (i ^ 117);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 4);
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
