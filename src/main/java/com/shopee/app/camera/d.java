package com.shopee.app.camera;

import android.app.Activity;
import android.hardware.Camera;
import java.util.List;

public class d {
    public static void a(Activity activity, int i, Camera camera) {
        int i2;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int i3 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i3 = 90;
            } else if (rotation == 2) {
                i3 = 180;
            } else if (rotation == 3) {
                i3 = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            i2 = (360 - ((cameraInfo.orientation + i3) % 360)) % 360;
        } else {
            i2 = ((cameraInfo.orientation - i3) + 360) % 360;
        }
        camera.setDisplayOrientation(i2);
    }

    public static Camera.Size a(List<Camera.Size> list, double d2, int i) {
        int i2;
        double d3;
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        int i3 = Integer.MAX_VALUE;
        for (Camera.Size next : list) {
            if (next.width < next.height) {
                d3 = (double) next.width;
                i2 = next.height;
            } else {
                d3 = (double) next.height;
                i2 = next.width;
            }
            double d4 = (double) i2;
            Double.isNaN(d3);
            Double.isNaN(d4);
            double d5 = d3 / d4;
            if (next.width * next.height >= i && Math.abs(d5 - d2) <= 0.1d) {
                if (size == null) {
                    size = next;
                } else {
                    int min = Math.min(next.height, next.width);
                    if (i3 > min) {
                        size = next;
                        i3 = min;
                    }
                }
            }
        }
        if (size == null) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                Camera.Size size2 = list.get(i4);
                if (size2.width * size2.height >= i) {
                    if (size == null) {
                        size = size2;
                    } else {
                        int min2 = Math.min(size2.height, size2.width);
                        if (i3 > min2) {
                            size = size2;
                            i3 = min2;
                        }
                    }
                }
            }
        }
        return size;
    }
}
