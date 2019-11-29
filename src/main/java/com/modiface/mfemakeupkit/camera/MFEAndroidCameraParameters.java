package com.modiface.mfemakeupkit.camera;

public class MFEAndroidCameraParameters {
    public static final int HINT_SIZE_MAX = -1;
    public static final int HINT_SIZE_SCREEN = 0;
    public CameraRotation cameraRotation = CameraRotation.ROTATE_0;
    int hintHeight = 0;
    int hintWidth = 0;
    public boolean isContinuousAutoFocusOn = true;
    public boolean isFrontCamera = true;

    public enum CameraRotation {
        ROTATE_0,
        ROTATE_90,
        ROTATE_180,
        ROTATE_270
    }

    public void setHintSize(int i, int i2) {
        if ((i > 0 || i == 0 || i == -1) && (i2 > 0 || i2 == 0 || i2 == -1)) {
            this.hintWidth = i;
            this.hintHeight = i2;
            return;
        }
        throw new IllegalArgumentException("invalid value(s) for setting hint size in MFEAndroidCameraParameters");
    }
}
