package cn.tongdun.android.core.oo0ooo0o00o0xo;

import android.app.ActivityManager;
import android.content.Context;
import cn.tongdun.android.core.oo0ooo0o00o0xo.o00xxox0x0xoox.o00xxox0x0xoox;

final class oox00xoxxoooxoxox0o0o implements o00xxox0x0xoox {
    private final Context o00xxox0x0xoox;
    private final ActivityManager oo0ooo0o00o0xo;

    private oox00xoxxoooxoxox0o0o(Context context, ActivityManager activityManager) {
        this.o00xxox0x0xoox = context;
        this.oo0ooo0o00o0xo = activityManager;
    }

    static oox00xoxxoooxoxox0o0o o00xxox0x0xoox(Context context, ActivityManager activityManager) {
        return new oox00xoxxoooxoxox0o0o(context, activityManager);
    }

    public Object o00xxox0x0xoox() {
        return xoxx0xx.o00xxox0x0xoox(this.o00xxox0x0xoox, this.oo0ooo0o00o0xo);
    }
}
