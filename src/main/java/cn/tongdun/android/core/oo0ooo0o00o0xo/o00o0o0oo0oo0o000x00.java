package cn.tongdun.android.core.oo0ooo0o00o0xo;

import android.content.Context;
import android.net.ConnectivityManager;
import cn.tongdun.android.core.oo0ooo0o00o0xo.o00xxox0x0xoox.o00xxox0x0xoox;

final class o00o0o0oo0oo0o000x00 implements o00xxox0x0xoox {
    private final Context o00xxox0x0xoox;
    private final ConnectivityManager oo0ooo0o00o0xo;

    private o00o0o0oo0oo0o000x00(Context context, ConnectivityManager connectivityManager) {
        this.o00xxox0x0xoox = context;
        this.oo0ooo0o00o0xo = connectivityManager;
    }

    static o00o0o0oo0oo0o000x00 o00xxox0x0xoox(Context context, ConnectivityManager connectivityManager) {
        return new o00o0o0oo0oo0o000x00(context, connectivityManager);
    }

    public Object o00xxox0x0xoox() {
        return xoxx0xx.o00xxox0x0xoox(this.o00xxox0x0xoox, this.oo0ooo0o00o0xo);
    }
}
