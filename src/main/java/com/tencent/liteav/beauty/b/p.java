package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.a;
import com.tencent.liteav.basic.d.g;

public class p extends g {
    private a r;

    public int b(int i) {
        if (this.r == null) {
            this.r = new a();
            a aVar = this.r;
            aVar.f31254a = 0;
            aVar.f31255b = 0;
            aVar.f31256c = this.f31317e;
            this.r.f31257d = this.f31318f;
        }
        GLES20.glViewport(this.r.f31254a, this.r.f31255b, this.r.f31256c, this.r.f31257d);
        return super.b(i);
    }
}
