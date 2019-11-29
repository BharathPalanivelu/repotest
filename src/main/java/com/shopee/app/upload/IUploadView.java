package com.shopee.app.upload;

public interface IUploadView {
    void hide();

    boolean isShown();

    void setImage(String str);

    void setLabel(String str);

    void setProgress(int i);

    void setStateFailed(String str);

    void setStateInProgress();

    void setVideo(boolean z);

    void show();
}
