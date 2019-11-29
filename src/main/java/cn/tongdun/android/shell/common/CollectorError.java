package cn.tongdun.android.shell.common;

import cn.tongdun.android.shell.utils.LogUtil;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class CollectorError {
    public static final String KEY_REASON = linkxxxxx("361376016a00", 74);
    public static final String KEY_STACK = linkxxxxx("377466766e", 61);
    public static final String KEY_TYPE = linkxxxxx("30497d5c", 10);
    private static Map errorMap = new Hashtable();

    public enum TYPE {
        ERROR_INIT("000"),
        ERROR_SO_LOAD("001"),
        ERROR_PROFILE_FAILED("011"),
        ERROR_PROFILE_DELAY("012"),
        ERROR_SHORT_INTERVAL("013"),
        ERROR_ALWAYS_DEMOTION("014"),
        ERROR_SO_LOAD_FAIL("015"),
        ERROR_TRANSFORM("016"),
        ERROR_NATIVE_METHOD("017"),
        ERROR_SDCARD_FILE("018"),
        ERROR_GETSERVICE_NULL("019"),
        ERROR_JSONERROR("020"),
        ERROR_SIZE_LIMIT("101");
        
        /* access modifiers changed from: private */
        public String code;

        private TYPE(String str) {
            this.code = str;
        }

        public String code() {
            return this.code;
        }
    }

    static {
        addError(TYPE.ERROR_INIT, linkxxxxx("004d490907081c5c555b4d42494c0c050b0216", 46));
    }

    public static void addError(TYPE type, JSONObject jSONObject) {
        if (errorMap == null) {
            errorMap = new Hashtable();
        }
        if (errorMap.containsKey(type.code())) {
            if (jSONObject != null) {
                String jSONObject2 = jSONObject.toString();
                if (jSONObject2 == null) {
                    jSONObject2 = "";
                }
                String str = (String) errorMap.get(type.code);
                if (str == null) {
                    errorMap.put(type.code(), jSONObject2);
                } else if (!str.contains(jSONObject2)) {
                    errorMap.put(type.code(), str + linkxxxxx("6863", 33) + jSONObject2);
                }
            }
        } else if (jSONObject != null) {
            String jSONObject3 = jSONObject.toString();
            if (jSONObject3 == null) {
                jSONObject3 = "";
            }
            errorMap.put(type.code(), jSONObject3);
        } else {
            errorMap.put(type.code(), linkxxxxx("3f1e", 86));
        }
    }

    public static void addError(TYPE type, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_REASON, str);
        } catch (JSONException e2) {
            LogUtil.err(e2.toString());
        }
        addError(type, jSONObject);
    }

    public static void clearError() {
        Map map = errorMap;
        if (map != null) {
            map.clear();
        }
    }

    public static void remove(TYPE type) {
        Map map = errorMap;
        if (map != null && map.containsKey(type.code)) {
            errorMap.remove(type.code());
        }
    }

    public static String getErrorCode() {
        Map map = errorMap;
        return map != null ? map.keySet().toString() : "";
    }

    public static String getErrorMsg() {
        Map map = errorMap;
        if (map == null) {
            return linkxxxxx("1f2c", 100);
        }
        if (map.size() <= 0) {
            return linkxxxxx("1f41", 9);
        }
        Collection values = errorMap.values();
        if (values.size() <= 0) {
            return linkxxxxx("1f49", 1);
        }
        return values.toString();
    }

    public static JSONObject catchErr(Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY_REASON, th.getLocalizedMessage());
            jSONObject.put(KEY_TYPE, th.getClass().getName());
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i = 0;
            while (true) {
                if (i >= stackTrace.length) {
                    break;
                } else if (stackTrace[i].getClassName().contains(linkxxxxx("276a233038313132202960666f6c79717f7c", 41))) {
                    jSONObject.put(KEY_STACK, stackTrace[i].toString());
                    break;
                } else {
                    i++;
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return new JSONObject();
        }
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
            byte b2 = (byte) (i ^ 78);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 68);
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
