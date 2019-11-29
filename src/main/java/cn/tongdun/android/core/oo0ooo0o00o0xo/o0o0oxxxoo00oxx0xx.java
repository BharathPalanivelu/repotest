package cn.tongdun.android.core.oo0ooo0o00o0xo;

import android.content.Context;
import android.location.LocationManager;
import cn.tongdun.android.core.oo0ooo0o00o0xo.o00xxox0x0xoox.o00xxox0x0xoox;

final class o0o0oxxxoo00oxx0xx implements o00xxox0x0xoox {
    private final LocationManager o00xxox0x0xoox;
    private final Context oo0ooo0o00o0xo;

    private o0o0oxxxoo00oxx0xx(Context context, LocationManager locationManager) {
        this.oo0ooo0o00o0xo = context;
        this.o00xxox0x0xoox = locationManager;
    }

    static o0o0oxxxoo00oxx0xx o00xxox0x0xoox(Context context, LocationManager locationManager) {
        return new o0o0oxxxoo00oxx0xx(context, locationManager);
    }

    public Object o00xxox0x0xoox() {
        return xoxx0xx.o00xxox0x0xoox(this.oo0ooo0o00o0xo, this.o00xxox0x0xoox);
    }
}
