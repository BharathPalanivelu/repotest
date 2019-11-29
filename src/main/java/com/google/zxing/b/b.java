package com.google.zxing.b;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

final class b {

    /* renamed from: d  reason: collision with root package name */
    private static double f14459d = 1.0E-7d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f14460a;

    /* renamed from: b  reason: collision with root package name */
    private Point f14461b;

    /* renamed from: c  reason: collision with root package name */
    private Point f14462c;

    b(Context context) {
        this.f14460a = context;
    }

    /* access modifiers changed from: package-private */
    public void a(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Display defaultDisplay = ((WindowManager) this.f14460a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 13) {
            defaultDisplay.getSize(point);
        } else {
            point.set(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        }
        this.f14461b = point;
        Log.i("CameraConfiguration", "Screen resolution: " + this.f14461b);
        if (this.f14460a.getResources().getDisplayMetrics().densityDpi == 120) {
            Point point2 = new Point();
            point2.x = this.f14461b.x;
            point2.y = this.f14461b.y;
            if (this.f14461b.x < this.f14461b.y) {
                point2.x = this.f14461b.y;
                point2.y = this.f14461b.x;
            }
            this.f14462c = a(parameters, point2);
        } else {
            this.f14462c = a(parameters, this.f14461b);
        }
        Log.i("CameraConfiguration", "Camera resolution: " + this.f14462c);
    }

    /* access modifiers changed from: package-private */
    public void a(Camera camera, boolean z) {
        String str;
        Camera.Parameters parameters = camera.getParameters();
        if (parameters == null) {
            Log.w("CameraConfiguration", "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        Log.i("CameraConfiguration", "Initial camera parameters: " + parameters.flatten());
        if (z) {
            Log.w("CameraConfiguration", "In camera config safe mode -- most settings will not be honored");
        }
        if (Build.VERSION.SDK_INT >= 14) {
            str = a((Collection<String>) parameters.getSupportedFocusModes(), "continuous-picture");
        } else {
            str = a((Collection<String>) parameters.getSupportedFocusModes(), "continuous-video");
        }
        if (str == null) {
            str = a((Collection<String>) parameters.getSupportedFocusModes(), "auto");
        }
        if (!z && str == null) {
            str = a((Collection<String>) parameters.getSupportedFocusModes(), "macro", "edof");
        }
        if (str != null) {
            parameters.setFocusMode(str);
        }
        parameters.setPreviewSize(this.f14462c.x, this.f14462c.y);
        camera.setParameters(parameters);
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        if (previewSize == null) {
            return;
        }
        if (this.f14462c.x != previewSize.width || this.f14462c.y != previewSize.height) {
            Log.w("CameraConfiguration", "Camera said it supported preview size " + this.f14462c.x + 'x' + this.f14462c.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height);
            this.f14462c.x = previewSize.width;
            this.f14462c.y = previewSize.height;
        }
    }

    public Point a() {
        return this.f14462c;
    }

    public Point b() {
        return this.f14461b;
    }

    /* access modifiers changed from: package-private */
    public boolean b(Camera camera) {
        if (camera == null || camera.getParameters() == null) {
            return false;
        }
        String flashMode = camera.getParameters().getFlashMode();
        if (flashMode == null) {
            return false;
        }
        if (ViewProps.ON.equals(flashMode) || "torch".equals(flashMode)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void b(Camera camera, boolean z) {
        Camera.Parameters parameters = camera.getParameters();
        a(parameters, z, false);
        camera.setParameters(parameters);
    }

    private void a(Camera.Parameters parameters, boolean z, boolean z2) {
        String str;
        if (z) {
            str = a((Collection<String>) parameters.getSupportedFlashModes(), "torch", ViewProps.ON);
        } else {
            str = a((Collection<String>) parameters.getSupportedFlashModes(), "off");
        }
        if (str != null) {
            parameters.setFlashMode(str);
        }
    }

    private Point a(Camera.Parameters parameters, Point point) {
        int i;
        double d2;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            Log.w("CameraConfiguration", "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            return new Point(previewSize.width, previewSize.height);
        }
        ArrayList<Camera.Size> arrayList = new ArrayList<>(supportedPreviewSizes);
        Collections.sort(arrayList, new Comparator<Camera.Size>() {
            /* renamed from: a */
            public int compare(Camera.Size size, Camera.Size size2) {
                int i = size.height * size.width;
                int i2 = size2.height * size2.width;
                if (i2 < i) {
                    return -1;
                }
                return i2 > i ? 1 : 0;
            }
        });
        if (Log.isLoggable("CameraConfiguration", 4)) {
            StringBuilder sb = new StringBuilder();
            for (Camera.Size size : arrayList) {
                sb.append(size.width);
                sb.append('x');
                sb.append(size.height);
                sb.append(' ');
            }
            Log.i("CameraConfiguration", "Supported preview sizes: " + sb);
        }
        if (point.y > point.x) {
            d2 = (double) point.y;
            i = point.x;
        } else {
            d2 = (double) point.x;
            i = point.y;
        }
        double d3 = (double) i;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = d2 / d3;
        Iterator it = arrayList.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Camera.Size size2 = (Camera.Size) it.next();
            int i2 = size2.width;
            int i3 = size2.height;
            if (i2 * i3 < 153600) {
                it.remove();
            } else {
                if (i2 < i3) {
                    z = true;
                }
                int i4 = z ? i3 : i2;
                if (z) {
                    i3 = i2;
                }
                double d5 = (double) i4;
                double d6 = (double) i3;
                Double.isNaN(d5);
                Double.isNaN(d6);
                if (Math.abs((d5 / d6) - d4) > 0.25d) {
                    it.remove();
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Camera.Size size3 = (Camera.Size) arrayList.get(0);
            Point point2 = new Point(size3.width, size3.height);
            Log.i("CameraConfiguration", "Using largest suitable preview size: " + point2);
            return point2;
        }
        Camera.Size previewSize2 = parameters.getPreviewSize();
        Point point3 = new Point(previewSize2.width, previewSize2.height);
        Log.i("CameraConfiguration", "No suitable preview sizes, using default: " + point3);
        return point3;
    }

    private static String a(Collection<String> collection, String... strArr) {
        String str;
        Log.i("CameraConfiguration", "Supported values: " + collection);
        if (collection != null) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                str = strArr[i];
                if (collection.contains(str)) {
                    break;
                }
                i++;
            }
        }
        str = null;
        Log.i("CameraConfiguration", "Settable value: " + str);
        return str;
    }
}
