package cn.tongdun.android.core.x0000xo0x0oooooo0;

import org.json.JSONException;
import org.json.JSONObject;

public class ooxo0o0xxxooxo00 extends o00xxox0x0xoox {
    private static final String o00xxox0x0xoox = o00xxox0x0xoox("595d744a6b5766", 117);
    private static final String oo0ooo0o00o0xo = o00xxox0x0xoox("59606c7d706d7c7269", 67);
    private JSONObject o00xx0xx0ooooo0xx00;
    private JSONObject x0000xo0x0oooooo0;

    public void o00xxox0x0xoox(float f2, float f3, float f4) {
        try {
            this.x0000xo0x0oooooo0.put(o00xxox0x0xoox("46", 85), (double) f2);
            this.x0000xo0x0oooooo0.put(o00xxox0x0xoox("47", 26), (double) f3);
            this.x0000xo0x0oooooo0.put(o00xxox0x0xoox("44", 22), (double) f4);
        } catch (JSONException unused) {
        }
    }

    public String o00xxox0x0xoox() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(o00xxox0x0xoox, this.o00xx0xx0ooooo0xx00);
            jSONObject.put(oo0ooo0o00o0xo, this.x0000xo0x0oooooo0);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
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
            byte b2 = (byte) (i ^ 61);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 62);
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
