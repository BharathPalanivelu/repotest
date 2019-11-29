package com.modiface.mfemakeupkit.camera;

import android.graphics.Matrix;
import android.hardware.Camera;
import com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters;
import java.util.Iterator;
import java.util.List;

public class l {
    public static Integer a(boolean z) {
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == z) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    public static j a(boolean z, int i, MFEAndroidCameraParameters.CameraRotation cameraRotation) {
        int i2;
        j jVar = z ? j.ROTATE270_FLIP : j.ROTATE0_NOFLIP;
        if (cameraRotation == null) {
            cameraRotation = MFEAndroidCameraParameters.CameraRotation.ROTATE_0;
        }
        try {
            Integer a2 = a(z);
            if (a2 == null) {
                return jVar;
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(a2.intValue(), cameraInfo);
            if (cameraInfo.facing == 1) {
                i2 = (cameraInfo.orientation + i) % 360;
            } else {
                i2 = ((360 - cameraInfo.orientation) + i) % 360;
            }
            int i3 = k.f15300a[cameraRotation.ordinal()];
            if (i3 == 1) {
                i2 = (i2 + 90) % 360;
            } else if (i3 == 2) {
                i2 = (i2 + 180) % 360;
            } else if (i3 == 3) {
                i2 = (i2 + 270) % 360;
            }
            if (cameraInfo.facing == 1) {
                if (i2 == 0) {
                    return j.ROTATE0_FLIP;
                }
                if (i2 == 90) {
                    return j.ROTATE90_FLIP;
                }
                if (i2 == 180) {
                    return j.ROTATE180_FLIP;
                }
                if (i2 != 270) {
                    return j.ROTATE270_FLIP;
                }
                return j.ROTATE270_FLIP;
            } else if (i2 == 0) {
                return j.ROTATE0_NOFLIP;
            } else {
                if (i2 == 90) {
                    return j.ROTATE90_NOFLIP;
                }
                if (i2 == 180) {
                    return j.ROTATE180_NOFLIP;
                }
                if (i2 != 270) {
                    return j.ROTATE0_NOFLIP;
                }
                return j.ROTATE270_NOFLIP;
            }
        } catch (Exception unused) {
            if (z) {
                return j.ROTATE270_FLIP;
            }
            return j.ROTATE0_NOFLIP;
        }
    }

    public static Camera.Size a(int i, int i2, Camera.Parameters parameters) {
        double d2;
        int i3 = i;
        int i4 = i2;
        boolean z = i3 <= 0 || i4 <= 0;
        double d3 = (double) i3;
        double max = (double) Math.max(1, i4);
        Double.isNaN(d3);
        Double.isNaN(max);
        double d4 = d3 / max;
        double d5 = Double.MAX_VALUE;
        Camera.Size size = null;
        if (parameters != null) {
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes != null) {
                Iterator<Camera.Size> it = supportedPreviewSizes.iterator();
                while (it.hasNext()) {
                    Camera.Size next = it.next();
                    if (next != null) {
                        int i5 = next.width;
                        if (i5 > 0) {
                            int i6 = next.height;
                            if (i6 > 0) {
                                double d6 = (double) i5;
                                Camera.Size size2 = size;
                                Iterator<Camera.Size> it2 = it;
                                double d7 = (double) i6;
                                Double.isNaN(d6);
                                Double.isNaN(d7);
                                double d8 = d6 / d7;
                                if (z) {
                                    double d9 = (double) (i5 * i6);
                                    Double.isNaN(d9);
                                    d2 = 1.0d / d9;
                                } else {
                                    double d10 = (double) (next.width - i3);
                                    Double.isNaN(d10);
                                    Double.isNaN(d3);
                                    double abs = (Math.abs(d8 - d4) / d4) + Math.abs(d10 / d3);
                                    double d11 = (double) (next.height - i4);
                                    double d12 = (double) i4;
                                    Double.isNaN(d11);
                                    Double.isNaN(d12);
                                    d2 = Math.abs(d11 / d12) + abs;
                                }
                                if (!(next.width % 4 == 0 && next.height % 4 == 0) || d2 >= d5) {
                                    size = size2;
                                } else {
                                    d5 = d2;
                                    size = next;
                                }
                                it = it2;
                            }
                        }
                    }
                    it = it;
                    size = size;
                }
            }
        }
        return size;
    }

    public static Matrix a(j jVar) {
        if (jVar == null) {
            jVar = j.ROTATE0_NOFLIP;
        }
        Matrix matrix = new Matrix();
        switch (k.f15301b[jVar.ordinal()]) {
            case 1:
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 2:
                matrix.postRotate(-90.0f);
                break;
            case 3:
                matrix.postScale(-1.0f, 1.0f);
                matrix.postRotate(-90.0f);
                break;
            case 4:
                matrix.postRotate(-180.0f);
                break;
            case 5:
                matrix.postScale(-1.0f, 1.0f);
                matrix.postRotate(-180.0f);
                break;
            case 6:
                matrix.postRotate(-270.0f);
                break;
            case 7:
                matrix.postScale(-1.0f, 1.0f);
                matrix.postRotate(-270.0f);
                break;
        }
        return matrix;
    }
}
