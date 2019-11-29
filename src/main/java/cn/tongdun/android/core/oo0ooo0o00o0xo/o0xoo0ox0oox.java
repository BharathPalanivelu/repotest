package cn.tongdun.android.core.oo0ooo0o00o0xo;

import android.content.Context;
import android.hardware.SensorManager;
import android.view.WindowManager;
import cn.tongdun.android.core.oo0ooo0o00o0xo.o00xxox0x0xoox.o00xxox0x0xoox;

final class o0xoo0ox0oox implements o00xxox0x0xoox {
    private final WindowManager o00xx0xx0ooooo0xx00;
    private final Context o00xxox0x0xoox;
    private final SensorManager oo0ooo0o00o0xo;

    private o0xoo0ox0oox(Context context, SensorManager sensorManager, WindowManager windowManager) {
        this.o00xxox0x0xoox = context;
        this.oo0ooo0o00o0xo = sensorManager;
        this.o00xx0xx0ooooo0xx00 = windowManager;
    }

    static o0xoo0ox0oox o00xxox0x0xoox(Context context, SensorManager sensorManager, WindowManager windowManager) {
        return new o0xoo0ox0oox(context, sensorManager, windowManager);
    }

    public Object o00xxox0x0xoox() {
        return xoxx0xx.o00xxox0x0xoox(this.o00xxox0x0xoox, this.oo0ooo0o00o0xo, this.o00xx0xx0ooooo0xx00);
    }
}
