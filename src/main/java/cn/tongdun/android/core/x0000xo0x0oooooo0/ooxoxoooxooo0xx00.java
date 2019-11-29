package cn.tongdun.android.core.x0000xo0x0oooooo0;

import org.json.JSONException;
import org.json.JSONObject;

class ooxoxoooxooo0xx00 extends x0000xo0x0oooooo0 {
    private int o00o0o0oo0oo0o000x00;
    private int o00xx0xx0ooooo0xx00;
    final /* synthetic */ oo0ooo0o00o0xo o00xxox0x0xoox;
    private int ooxoxoooxooo0xx00;
    private int x0000xo0x0oooooo0;
    private int x0ox00x0oooo0xxx;
    private int xo00x00xo00;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ooxoxoooxooo0xx00(oo0ooo0o00o0xo oo0ooo0o00o0xo, int i, int i2, int i3, int i4, int i5, int i6) {
        super(oo0ooo0o00o0xo);
        this.o00xxox0x0xoox = oo0ooo0o00o0xo;
        this.x0000xo0x0oooooo0 = i;
        this.o00xx0xx0ooooo0xx00 = i2;
        this.x0ox00x0oooo0xxx = i3;
        this.ooxoxoooxooo0xx00 = i4;
        this.xo00x00xo00 = i5;
        this.o00o0o0oo0oo0o000x00 = i6;
    }

    /* access modifiers changed from: package-private */
    public JSONObject o00xxox0x0xoox() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.x0000xo0x0oooooo0 != -1) {
                jSONObject.put(oo0ooo0o00o0xo.o00xxox0x0xoox("260060", 95), this.x0000xo0x0oooooo0);
            }
            if (this.o00xx0xx0ooooo0xx00 != Integer.MAX_VALUE) {
                jSONObject.put(oo0ooo0o00o0xo.o00xxox0x0xoox("271f6e", 78), this.o00xx0xx0ooooo0xx00);
            }
            if (this.x0ox00x0oooo0xxx != Integer.MAX_VALUE) {
                jSONObject.put(oo0ooo0o00o0xo.o00xxox0x0xoox("282f6e", 121), this.x0ox00x0oooo0xxx);
            }
            if (this.ooxoxoooxooo0xx00 != 0) {
                jSONObject.put(oo0ooo0o00o0xo.o00xxox0x0xoox("3e346620632d", 124), this.ooxoxoooxooo0xx00);
            }
            if (this.o00o0o0oo0oo0o000x00 != Integer.MIN_VALUE) {
                jSONObject.put(oo0ooo0o00o0xo.o00xxox0x0xoox("2f1d6b", 71), this.o00o0o0oo0oo0o000x00);
            }
            jSONObject.put(oo0ooo0o00o0xo.o00xxox0x0xoox("3f577d42", 6), oo0ooo0o00o0xo.o00xxox0x0xoox("3c6b70627c", 35));
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
