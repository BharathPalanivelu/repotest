package cn.tongdun.android.shell.common;

import android.content.Context;
import cn.tongdun.android.shell.FMAgent;
import cn.tongdun.android.shell.exception.FMException;

public class o00xx0xx0ooooo0xx00 {
    private String o00xxox0x0xoox;
    private Context oo0ooo0o00o0xo;

    public o00xx0xx0ooooo0xx00(Context context) {
        this.oo0ooo0o00o0xo = context;
        this.o00xxox0x0xoox = o00xxox0x0xoox.x0000xo0x0oooooo0(context);
    }

    public void o00xxox0x0xoox(String str, String str2, String str3, String str4) throws FMException {
        if (this.oo0ooo0o00o0xo == null) {
            throw new FMException(o00xxox0x0xoox("701157104d01500d1e590540057178014408401a565f1f58015d00094305421f53025f5619590258050c040c04", 124));
        } else if (str2 != null || (str != null && (str.equals(FMAgent.ENV_PRODUCTION) || str.equals(FMAgent.ENV_SANDBOX)))) {
            this.o00xxox0x0xoox = o00xxox0x0xoox.x0000xo0x0oooooo0(this.oo0ooo0o00o0xo);
            if (str4 != null && !str4.equals(this.o00xxox0x0xoox)) {
                throw new FMException(o00xxox0x0xoox("70024d054d1246086d276f3a633c753c3c", 111) + this.o00xxox0x0xoox + o00xxox0x0xoox("762534022a072b537c56615768103812251e2308235b6d54615c3e", 13) + str4 + o00xxox0x0xoox("0a2021", 117));
            }
        } else {
            throw new FMException(o00xxox0x0xoox("7024503c1c", 79) + str + o00xxox0x0xoox("76372d0b240f3619734a655b311e3a06717d7a715c7357690d02061a7e647c797768617f7c797d17320a606c6b604d6246781c13170b6f767d79777f7a6802690269", 31));
        }
    }

    public boolean o00xxox0x0xoox(String str) {
        return str != null || this.o00xxox0x0xoox.equals(this.oo0ooo0o00o0xo.getPackageName()) || this.o00xxox0x0xoox.equals(this.oo0ooo0o00o0xo.getApplicationInfo().processName);
    }

    public boolean o00xxox0x0xoox(long j, int i) {
        return j == 0 || System.currentTimeMillis() - j >= ((long) i);
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
            byte b2 = (byte) (i ^ 85);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 43);
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
