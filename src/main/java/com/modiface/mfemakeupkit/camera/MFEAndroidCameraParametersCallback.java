package com.modiface.mfemakeupkit.camera;

import android.hardware.Camera;

public interface MFEAndroidCameraParametersCallback {
    void onCameraSetParameters(Camera.Parameters parameters, MFEAndroidCameraParameters mFEAndroidCameraParameters);
}
