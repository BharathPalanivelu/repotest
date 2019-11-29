package cn.tongdun.android.core.x0000xo0x0oooooo0;

import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import org.json.JSONArray;

public class oo0ooo0o00o0xo extends o00xxox0x0xoox {
    private int o00xxox0x0xoox;
    private JSONArray oo0ooo0o00o0xo = new JSONArray();

    public void o00xxox0x0xoox(int i, int... iArr) {
        if (iArr[0] != Integer.MAX_VALUE) {
            this.o00xxox0x0xoox = i;
            if (i == 0 && iArr.length == 6) {
                this.oo0ooo0o00o0xo.put(new x0ox00x0oooo0xxx(this, iArr[0], iArr[1], iArr[2], iArr[3], iArr[4], iArr[5]).o00xxox0x0xoox());
            } else if (i == 0 && iArr.length == 3) {
                this.oo0ooo0o00o0xo.put(new x0ox00x0oooo0xxx(this, -1, iArr[0], iArr[1], 0, 0, iArr[2]).o00xxox0x0xoox());
            } else if (i == 1 && iArr.length == 6) {
                this.oo0ooo0o00o0xo.put(new o00xx0xx0ooooo0xx00(this, iArr[0], iArr[1], iArr[2], iArr[3], iArr[4], iArr[5]).o00xxox0x0xoox());
            } else if (i == 2 && iArr.length == 6) {
                this.oo0ooo0o00o0xo.put(new xo00x00xo00(this, iArr[0], iArr[1], iArr[2], iArr[3], iArr[4], iArr[5]).o00xxox0x0xoox());
            } else if (i == 2 && iArr.length == 3) {
                this.oo0ooo0o00o0xo.put(new xo00x00xo00(this, -1, iArr[0], iArr[1], 0, 0, iArr[2]).o00xxox0x0xoox());
            } else if (i == 3 && iArr.length == 6) {
                this.oo0ooo0o00o0xo.put(new ooxoxoooxooo0xx00(this, iArr[0], iArr[1], iArr[2], iArr[3], iArr[4], iArr[5]).o00xxox0x0xoox());
            } else if (i == 3 && iArr.length == 3) {
                this.oo0ooo0o00o0xo.put(new ooxoxoooxooo0xx00(this, -1, iArr[0], iArr[1], 0, 0, iArr[2]).o00xxox0x0xoox());
            } else if (i == 0 && iArr.length == 5) {
                this.oo0ooo0o00o0xo.put(new x0ox00x0oooo0xxx(this, iArr[0], iArr[1], iArr[2], iArr[3], iArr[4], RNCartPanelDataEntity.NULL_VALUE).o00xxox0x0xoox());
            } else if (i == 0 && iArr.length == 2) {
                this.oo0ooo0o00o0xo.put(new x0ox00x0oooo0xxx(this, -1, iArr[0], iArr[1], 0, 0, RNCartPanelDataEntity.NULL_VALUE).o00xxox0x0xoox());
            } else if (i == 1 && iArr.length == 5) {
                this.oo0ooo0o00o0xo.put(new o00xx0xx0ooooo0xx00(this, iArr[0], iArr[1], iArr[2], iArr[3], iArr[4], RNCartPanelDataEntity.NULL_VALUE).o00xxox0x0xoox());
            } else if (i == 2 && iArr.length == 5) {
                this.oo0ooo0o00o0xo.put(new xo00x00xo00(this, iArr[0], iArr[1], iArr[2], iArr[3], iArr[4], RNCartPanelDataEntity.NULL_VALUE).o00xxox0x0xoox());
            } else if (i == 2 && iArr.length == 2) {
                this.oo0ooo0o00o0xo.put(new xo00x00xo00(this, -1, iArr[0], iArr[1], 0, 0, RNCartPanelDataEntity.NULL_VALUE).o00xxox0x0xoox());
            } else if (i == 3 && iArr.length == 5) {
                this.oo0ooo0o00o0xo.put(new ooxoxoooxooo0xx00(this, iArr[0], iArr[1], iArr[2], iArr[3], iArr[4], RNCartPanelDataEntity.NULL_VALUE).o00xxox0x0xoox());
            } else if (i == 3 && iArr.length == 2) {
                this.oo0ooo0o00o0xo.put(new ooxoxoooxooo0xx00(this, -1, iArr[0], iArr[1], 0, 0, RNCartPanelDataEntity.NULL_VALUE).o00xxox0x0xoox());
            }
        }
    }

    public String o00xxox0x0xoox() {
        return this.oo0ooo0o00o0xo.toString();
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
            byte b2 = (byte) (i ^ 92);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 75);
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
