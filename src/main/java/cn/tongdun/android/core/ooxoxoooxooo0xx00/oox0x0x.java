package cn.tongdun.android.core.ooxoxoooxooo0xx00;

import android.content.pm.PackageManager;
import com.g.a.a.g;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class oox0x0x {
    private static final String o00o0o0oo0oo0o000x00 = o00xxox0x0xoox("687a61392b28312a357135", 1);
    private static final String o00xx0xx0ooooo0xx00 = o00xxox0x0xoox("685661152a0833042e182753785564", 45);
    private static final String o00xxox0x0xoox = o00xxox0x0xoox("681b61580c77097b0261234410681b69", 96);
    private static final String o0oo0xx00ooo0oox0xx0 = o00xxox0x0xoox("68026141275c3d4a3151", 121);
    private static final String oo0ooo0o00o0xo = o00xxox0x0xoox("66152642321a3605791479", 106);
    private static final String ooxo0o0xxxooxo00 = o00xxox0x0xoox("682261610c4e0942025835743e75", 89);
    private static final String ooxoxoooxooo0xx00 = o00xxox0x0xoox("68416102220e3a1e320f32", 58);
    private static final String ox000o0o = o00xxox0x0xoox("682761642a7933752e6927226a296b2e646120622c6a20", 92);
    private static final oox0x0x ox0xxoox0 = new oox0x0x();
    private static final String x0000xo0x0oooooo0 = o00xxox0x0xoox("680661453b583357305b2142264b355e3d196a136917", 125);
    private static final String x0ox00x0oooo0xxx = o00xxox0x0xoox("6347605770103d1c3f5f62417c446f53745c7b56794364456548694368", 57);
    private static final String xo00x00xo00 = o00xxox0x0xoox("720a72017e4c35512c5d3141380a6f1c6417681579157a", 107);
    private static final String xoo0xoo0oxo00x0o0 = o00xxox0x0xoox("68636120020c0d0505", 24);
    private List oox0x0x;

    public static oox0x0x o00xxox0x0xoox() {
        return ox0xxoox0;
    }

    private oox0x0x() {
        this.oox0x0x = null;
        this.oox0x0x = new ArrayList();
        this.oox0x0x.add(o00xxox0x0xoox);
        this.oox0x0x.add(oo0ooo0o00o0xo);
        this.oox0x0x.add(o00xx0xx0ooooo0xx00);
        this.oox0x0x.add(x0000xo0x0oooooo0);
        this.oox0x0x.add(x0ox00x0oooo0xxx);
        this.oox0x0x.add(xo00x00xo00);
        this.oox0x0x.add(ooxoxoooxooo0xx00);
        this.oox0x0x.add(o00o0o0oo0oo0o000x00);
        this.oox0x0x.add(xoo0xoo0oxo00x0o0);
        this.oox0x0x.add(o0oo0xx00ooo0oox0xx0);
        this.oox0x0x.add(ooxo0o0xxxooxo00);
        this.oox0x0x.add(ox000o0o);
    }

    public String o00xxox0x0xoox(PackageManager packageManager) {
        JSONArray jSONArray = new JSONArray();
        List list = this.oox0x0x;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (x0000xo0x0oooooo0.o00xxox0x0xoox(packageManager, (String) this.oox0x0x.get(i)) != null) {
                    jSONArray.put(i);
                }
            }
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
            byte b2 = (byte) (i ^ 119);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ g.STRUCT_END);
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
