package com.modiface.mfemakeupkit.utils;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;

public class MFEGLUtil {
    public static boolean DoCheckGLError = false;
    public static final int EmptyGLId = 0;
    public static final float[] untransformedTextureCoordinates = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f, 1.0f};
    public static final float[] untransformedVertices = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    private enum a {
        SUCCESS(12288),
        NOT_INITIALIZED(12289),
        BAD_ACCESS(12290),
        BAD_ALLOC(12291),
        BAD_ATTRIBUTE(12292),
        BAD_CONTEXT(12294),
        BAD_CONFIG(12293),
        BAD_CURRENT_SURFACE(12295),
        BAD_DISPLAY(12296),
        BAD_SURFACE(12301),
        BAD_MATCH(12297),
        BAD_PARAMETERS(12300),
        BAD_NATIVE_PIXMAP(12298),
        BAD_NATIVE_WINDOW(12299),
        CONTEXT_LOST(12302);
        
        public final int q;

        private a(int i) {
            this.q = i;
        }
    }

    private enum b {
        NO_ERROR(0),
        INVALID_ENUM(1280),
        INVALID_VALUE(1281),
        INVALID_OPERATION(1282),
        INVALID_FRAMEBUFFER_OPERATION(1286),
        OUT_OF_MEMORY(1285);
        
        public final int h;

        private b(int i) {
            this.h = i;
        }
    }

    public static void assertOnGLError() {
        if (DoCheckGLError) {
            int glGetError = GLES20.glGetError();
            b bVar = null;
            b[] values = b.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                b bVar2 = values[i];
                if (glGetError == bVar2.h) {
                    bVar = bVar2;
                    break;
                }
                i++;
            }
            if (bVar != b.NO_ERROR) {
                String name = bVar != null ? bVar.name() : "UNKNOWN";
                throw new RuntimeException("GL error with code: " + name + " (" + Integer.toHexString(glGetError) + SQLBuilder.PARENTHESES_RIGHT);
            }
        }
    }

    public static Throwable getEGLError() {
        a aVar;
        int eglGetError = EGL14.eglGetError();
        a[] values = a.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                aVar = null;
                break;
            }
            aVar = values[i];
            if (eglGetError == aVar.q) {
                break;
            }
            i++;
        }
        if (aVar == a.SUCCESS) {
            return null;
        }
        return new Throwable("EGL error with code: " + (aVar != null ? aVar.name() : "UNKNOWN") + " (" + Integer.toHexString(eglGetError) + SQLBuilder.PARENTHESES_RIGHT);
    }

    public static Throwable getErrorForGLCode(int i) {
        return getErrorForGLCode(i, -1, (String) null);
    }

    public static Throwable getGLError() {
        return getErrorForGLCode(GLES20.glGetError());
    }

    public static Throwable getErrorForGLCode(int i, int i2, String str) {
        b bVar;
        String str2;
        b[] values = b.values();
        int length = values.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                bVar = null;
                break;
            }
            bVar = values[i3];
            if (i == bVar.h) {
                break;
            }
            i3++;
        }
        if (bVar == b.NO_ERROR) {
            return null;
        }
        String name = bVar != null ? bVar.name() : "UNKNOWN";
        if (i2 >= 0) {
            str2 = " at line " + i2;
        } else {
            str2 = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = "(no message)";
        }
        return new Throwable("GL error with code " + name + " (0x" + Integer.toHexString(i) + SQLBuilder.PARENTHESES_RIGHT + str2 + " with message: " + str);
    }
}
