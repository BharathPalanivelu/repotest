package com.tencent.qalsdk;

public interface QALValueWithSeqCallBack {
    void onError(int i, String str, int i2);

    void onSuccess(byte[] bArr, int i);
}
