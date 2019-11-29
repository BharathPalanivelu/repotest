package cn.tongdun.android.core.x0000xo0x0oooooo0;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class ox000o0o extends o00xxox0x0xoox {
    private List o00xxox0x0xoox = new ArrayList();

    public boolean o00xxox0x0xoox(String str, String str2, int i) {
        return this.o00xxox0x0xoox.add(new ox0xxoox0(this, str, str2, i));
    }

    public String o00xxox0x0xoox() {
        JSONArray jSONArray = new JSONArray();
        for (ox0xxoox0 o00xxox0x0xoox2 : this.o00xxox0x0xoox) {
            jSONArray.put(o00xxox0x0xoox2.o00xxox0x0xoox());
        }
        return jSONArray.toString();
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
            byte b2 = (byte) (i ^ 14);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 93);
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
