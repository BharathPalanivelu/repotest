package com.shopee.arcatch.c.e.b;

import android.opengl.GLES20;
import android.util.Log;

public abstract class c {
    public abstract void a(boolean z);

    public void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("ArCatchRender", str + ": glError " + glGetError);
            throw new RuntimeException(str + ": glError " + glGetError);
        }
    }
}
