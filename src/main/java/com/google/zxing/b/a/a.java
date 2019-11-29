package com.google.zxing.b.a;

import android.hardware.Camera;
import android.util.Log;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f14457a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static final String f14458b = "com.google.zxing.b.a.a";

    private a() {
    }

    public static Camera a(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(f14458b, "No cameras!");
            return null;
        }
        boolean z = i >= 0;
        if (!z) {
            i = 0;
            while (i < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i++;
            }
        }
        if (i < numberOfCameras) {
            String str = f14458b;
            Log.i(str, "Opening camera #" + i);
            Camera open = Camera.open(i);
            f14457a = i;
            return open;
        } else if (z) {
            String str2 = f14458b;
            Log.w(str2, "Requested camera does not exist: " + i);
            return null;
        } else {
            Log.i(f14458b, "No camera facing back; returning camera #0");
            Camera open2 = Camera.open(0);
            f14457a = 0;
            return open2;
        }
    }
}
