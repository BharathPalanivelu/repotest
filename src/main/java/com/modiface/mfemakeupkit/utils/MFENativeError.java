package com.modiface.mfemakeupkit.utils;

import android.text.TextUtils;

public class MFENativeError {
    private long mNativeState;

    static {
        q.a("MFEMakeupKit");
        registerNatives();
    }

    public MFENativeError() {
        this.mNativeState = 0;
        this.mNativeState = jniInit();
    }

    private native int getCode();

    private native int getLine();

    private native String getMessage();

    private native boolean isError();

    private native boolean isGLError();

    private native void jniDestroy();

    private native long jniInit();

    private static native void registerNatives();

    public void close() {
        if (this.mNativeState != 0) {
            jniDestroy();
            this.mNativeState = 0;
        }
    }

    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public Throwable getNativeError() {
        String str;
        if (!isError()) {
            return null;
        }
        int line = getLine();
        String message = getMessage();
        if (TextUtils.isEmpty(message)) {
            message = "(no message)";
        }
        if (isGLError()) {
            return MFEGLUtil.getErrorForGLCode(getCode(), line, message);
        }
        if (line >= 0) {
            str = " at line " + line;
        } else {
            str = "";
        }
        return new Throwable("MFE native error" + str + " with code " + getCode() + " (0x" + Integer.toHexString(getCode()) + ") with message: " + message);
    }

    public long getNativeState() {
        return this.mNativeState;
    }
}
