package cn.tongdun.android.shell;

import android.content.Context;
import cn.tongdun.android.core.o00xxox0x0xoox;
import cn.tongdun.android.shell.common.CollectorError;
import cn.tongdun.android.shell.common.oo0ooo0o00o0xo;
import cn.tongdun.android.shell.utils.LogUtil;

final class o00xx0xx0ooooo0xx00 implements Runnable {
    final /* synthetic */ boolean o00o0o0oo0oo0o000x00;
    final /* synthetic */ String o00xx0xx0ooooo0xx00;
    final /* synthetic */ Context o00xxox0x0xoox;
    final /* synthetic */ String o0oo0xx00ooo0oox0xx0;
    final /* synthetic */ String oo0ooo0o00o0xo;
    final /* synthetic */ String ooxo0o0xxxooxo00;
    final /* synthetic */ String ooxoxoooxooo0xx00;
    final /* synthetic */ String ox000o0o;
    final /* synthetic */ boolean ox0xxoox0;
    final /* synthetic */ boolean x0000xo0x0oooooo0;
    final /* synthetic */ String x0ox00x0oooo0xxx;
    final /* synthetic */ String xo00x00xo00;
    final /* synthetic */ boolean xoo0xoo0oxo00x0o0;

    o00xx0xx0ooooo0xx00(Context context, String str, String str2, boolean z, String str3, String str4, String str5, boolean z2, boolean z3, String str6, String str7, String str8, boolean z4) {
        this.o00xxox0x0xoox = context;
        this.oo0ooo0o00o0xo = str;
        this.o00xx0xx0ooooo0xx00 = str2;
        this.x0000xo0x0oooooo0 = z;
        this.x0ox00x0oooo0xxx = str3;
        this.xo00x00xo00 = str4;
        this.ooxoxoooxooo0xx00 = str5;
        this.o00o0o0oo0oo0o000x00 = z2;
        this.xoo0xoo0oxo00x0o0 = z3;
        this.o0oo0xx00ooo0oox0xx0 = str6;
        this.ooxo0o0xxxooxo00 = str7;
        this.ox000o0o = str8;
        this.ox0xxoox0 = z4;
    }

    public void run() {
        CollectorError.clearError();
        CollectorError.addError(CollectorError.TYPE.ERROR_SHORT_INTERVAL, FMAgent.linkxxxxx("5b7c54330728003506614f6655774273557e193c1e2d1d3f1d34537d547a492e082102654d646657755c6f", 54));
        long unused = FMAgent.mLastInitTime = System.currentTimeMillis();
        synchronized (FMAgent.class) {
            if (FMAgent.mFmInter == null) {
                o00xxox0x0xoox unused2 = FMAgent.mFmInter = oo0ooo0o00o0xo.o00xxox0x0xoox(this.o00xxox0x0xoox);
            }
            if (FMAgent.mFmInter != null) {
                FMAgent.mFmInter.o00xxox0x0xoox(this.o00xxox0x0xoox, this.oo0ooo0o00o0xo, this.o00xx0xx0ooooo0xx00, this.x0000xo0x0oooooo0, this.x0ox00x0oooo0xxx, this.xo00x00xo00, this.ooxoxoooxooo0xx00, this.o00o0o0oo0oo0o000x00, this.xoo0xoo0oxo00x0o0, FMAgent.mDownLatch, this.o0oo0xx00ooo0oox0xx0, FMAgent.mBlackboxMaxSize, this.ooxo0o0xxxooxo00, this.ox000o0o, this.ox0xxoox0);
                LogUtil.info(FMAgent.linkxxxxx("5b03550a561b4d551e421109580e5f130b400d560d501b50", 73));
            }
        }
    }
}
