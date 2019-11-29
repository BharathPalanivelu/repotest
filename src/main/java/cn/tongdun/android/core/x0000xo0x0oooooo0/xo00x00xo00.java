package cn.tongdun.android.core.x0000xo0x0oooooo0;

import org.json.JSONException;
import org.json.JSONObject;

class xo00x00xo00 extends x0000xo0x0oooooo0 {
    private int o00o0o0oo0oo0o000x00;
    private int o00xx0xx0ooooo0xx00;
    final /* synthetic */ oo0ooo0o00o0xo o00xxox0x0xoox;
    private int ooxoxoooxooo0xx00;
    private int x0000xo0x0oooooo0;
    private int x0ox00x0oooo0xxx;
    private int xo00x00xo00;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public xo00x00xo00(oo0ooo0o00o0xo oo0ooo0o00o0xo, int i, int i2, int i3, int i4, int i5, int i6) {
        super(oo0ooo0o00o0xo);
        this.o00xxox0x0xoox = oo0ooo0o00o0xo;
        this.ooxoxoooxooo0xx00 = i;
        this.o00xx0xx0ooooo0xx00 = i2;
        this.x0000xo0x0oooooo0 = i3;
        this.x0ox00x0oooo0xxx = i4;
        this.xo00x00xo00 = i5;
        this.o00o0o0oo0oo0o000x00 = i6;
    }

    /* access modifiers changed from: package-private */
    public JSONObject o00xxox0x0xoox() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.ooxoxoooxooo0xx00 != -1) {
                jSONObject.put(oo0ooo0o00o0xo.o00xxox0x0xoox("265860", 7), this.ooxoxoooxooo0xx00);
            }
            jSONObject.put(oo0ooo0o00o0xo.o00xxox0x0xoox("3f6f76", 38), this.o00xx0xx0ooooo0xx00);
            jSONObject.put(oo0ooo0o00o0xo.o00xxox0x0xoox("2856", 0), this.x0000xo0x0oooooo0);
            if (this.x0ox00x0oooo0xxx != 0) {
                jSONObject.put(oo0ooo0o00o0xo.o00xxox0x0xoox("2e277633733e", 127), this.x0ox00x0oooo0xxx);
            }
            if (this.xo00x00xo00 != 0) {
                jSONObject.put(oo0ooo0o00o0xo.o00xxox0x0xoox("3b617a", 46), this.xo00x00xo00);
            }
            if (this.o00o0o0oo0oo0o000x00 != Integer.MIN_VALUE) {
                jSONObject.put(oo0ooo0o00o0xo.o00xxox0x0xoox("2f516b", 11), this.o00o0o0oo0oo0o000x00);
            }
            jSONObject.put(oo0ooo0o00o0xo.o00xxox0x0xoox("3f287d3d", 121), oo0ooo0o00o0xo.o00xxox0x0xoox("27117d", 85));
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
