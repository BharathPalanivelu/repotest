package cn.tongdun.android.core.oo0ooo0o00o0xo;

import android.app.ActivityManager;
import android.content.Context;
import cn.tongdun.android.core.oo0ooo0o00o0xo.o00xxox0x0xoox.o00xxox0x0xoox;

final class ox0xoo0xxoox000ooox0 implements o00xxox0x0xoox {
    private final Context o00xxox0x0xoox;
    private final ActivityManager oo0ooo0o00o0xo;

    private ox0xoo0xxoox000ooox0(Context context, ActivityManager activityManager) {
        this.o00xxox0x0xoox = context;
        this.oo0ooo0o00o0xo = activityManager;
    }

    static ox0xoo0xxoox000ooox0 o00xxox0x0xoox(Context context, ActivityManager activityManager) {
        return new ox0xoo0xxoox000ooox0(context, activityManager);
    }

    public Object o00xxox0x0xoox() {
        return xoxx0xx.oo0ooo0o00o0xo(this.o00xxox0x0xoox, this.oo0ooo0o00o0xo);
    }
}
