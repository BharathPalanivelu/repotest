package com.garena.videolib.uploader;

public interface b {
    void onError(Exception exc);

    void onFinish(String str);

    void onProgress(int i);
}
