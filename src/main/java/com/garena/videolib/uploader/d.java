package com.garena.videolib.uploader;

public interface d {
    void onError(Exception exc);

    void onFinish(String str);

    void onProgress(int i);

    void onSessionSuccess(String str);
}
