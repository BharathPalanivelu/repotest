package com.tencent.liteav.beauty.b.a;

import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.beauty.NativeLoad;

public class c extends g {
    public boolean a() {
        NativeLoad.getInstance();
        this.f31313a = NativeLoad.nativeLoadGLProgram(6);
        if (this.f31313a == 0 || !b()) {
            this.f31319g = false;
        } else {
            this.f31319g = true;
        }
        c();
        return this.f31319g;
    }
}
