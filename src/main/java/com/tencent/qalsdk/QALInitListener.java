package com.tencent.qalsdk;

public interface QALInitListener {
    void onInitError(int i, String str);

    void onInitSuccess();
}
