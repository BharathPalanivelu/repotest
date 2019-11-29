package cn.tongdun.android.core.oo0ooo0o00o0xo;

import android.content.Context;
import android.telephony.TelephonyManager;
import cn.tongdun.android.core.oo0ooo0o00o0xo.o00xxox0x0xoox.o00xxox0x0xoox;

final class x0xoxo0o implements o00xxox0x0xoox {
    private final Context o00xxox0x0xoox;
    private final TelephonyManager oo0ooo0o00o0xo;

    private x0xoxo0o(Context context, TelephonyManager telephonyManager) {
        this.o00xxox0x0xoox = context;
        this.oo0ooo0o00o0xo = telephonyManager;
    }

    static x0xoxo0o o00xxox0x0xoox(Context context, TelephonyManager telephonyManager) {
        return new x0xoxo0o(context, telephonyManager);
    }

    public Object o00xxox0x0xoox() {
        return xoxx0xx.o00xxox0x0xoox(this.o00xxox0x0xoox, this.oo0ooo0o00o0xo);
    }
}
