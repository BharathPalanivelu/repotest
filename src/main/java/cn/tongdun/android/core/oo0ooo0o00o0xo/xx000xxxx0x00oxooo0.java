package cn.tongdun.android.core.oo0ooo0o00o0xo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import cn.tongdun.android.core.oo0ooo0o00o0xo.o00xxox0x0xoox.o00xxox0x0xoox;

final class xx000xxxx0x00oxooo0 implements o00xxox0x0xoox {
    private ConnectivityManager o00xx0xx0ooooo0xx00;
    private Context o00xxox0x0xoox;
    private WifiManager oo0ooo0o00o0xo;

    private xx000xxxx0x00oxooo0(Context context, ConnectivityManager connectivityManager, WifiManager wifiManager) {
        this.o00xxox0x0xoox = context;
        this.o00xx0xx0ooooo0xx00 = connectivityManager;
        this.oo0ooo0o00o0xo = wifiManager;
    }

    static xx000xxxx0x00oxooo0 o00xxox0x0xoox(Context context, ConnectivityManager connectivityManager, WifiManager wifiManager) {
        return new xx000xxxx0x00oxooo0(context, connectivityManager, wifiManager);
    }

    public Object o00xxox0x0xoox() {
        return xoxx0xx.o00xxox0x0xoox(this.o00xxox0x0xoox, this.o00xx0xx0ooooo0xx00, this.oo0ooo0o00o0xo);
    }
}
