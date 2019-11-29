package androidx.m.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.core.graphics.c;
import cn.tongdun.android.shell.settings.Constants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import org.xmlpull.v1.XmlPullParser;

public class g implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private float[] f2617a;

    /* renamed from: b  reason: collision with root package name */
    private float[] f2618b;

    public g(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray a2 = androidx.core.content.a.g.a(resources, theme, attributeSet, a.l);
        a(a2, xmlPullParser);
        a2.recycle();
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (androidx.core.content.a.g.a(xmlPullParser, "pathData")) {
            String a2 = androidx.core.content.a.g.a(typedArray, xmlPullParser, "pathData", 4);
            Path a3 = c.a(a2);
            if (a3 != null) {
                a(a3);
                return;
            }
            throw new InflateException("The path is null, which is created from " + a2);
        } else if (!androidx.core.content.a.g.a(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else if (androidx.core.content.a.g.a(xmlPullParser, "controlY1")) {
            float a4 = androidx.core.content.a.g.a(typedArray, xmlPullParser, "controlX1", 0, (float) BitmapDescriptorFactory.HUE_RED);
            float a5 = androidx.core.content.a.g.a(typedArray, xmlPullParser, "controlY1", 1, (float) BitmapDescriptorFactory.HUE_RED);
            boolean a6 = androidx.core.content.a.g.a(xmlPullParser, "controlX2");
            if (a6 != androidx.core.content.a.g.a(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            } else if (!a6) {
                a(a4, a5);
            } else {
                a(a4, a5, androidx.core.content.a.g.a(typedArray, xmlPullParser, "controlX2", 2, (float) BitmapDescriptorFactory.HUE_RED), androidx.core.content.a.g.a(typedArray, xmlPullParser, "controlY2", 3, (float) BitmapDescriptorFactory.HUE_RED));
            }
        } else {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
    }

    private void a(float f2, float f3) {
        Path path = new Path();
        path.moveTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        path.quadTo(f2, f3, 1.0f, 1.0f);
        a(path);
    }

    private void a(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        path.cubicTo(f2, f3, f4, f5, 1.0f, 1.0f);
        a(path);
    }

    private void a(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(Constants.DEFAULT_WAIT_TIME, ((int) (length / 0.002f)) + 1);
        if (min > 0) {
            this.f2617a = new float[min];
            this.f2618b = new float[min];
            float[] fArr = new float[2];
            for (int i2 = 0; i2 < min; i2++) {
                pathMeasure.getPosTan((((float) i2) * length) / ((float) (min - 1)), fArr, (float[]) null);
                this.f2617a[i2] = fArr[0];
                this.f2618b[i2] = fArr[1];
            }
            if (((double) Math.abs(this.f2617a[0])) <= 1.0E-5d && ((double) Math.abs(this.f2618b[0])) <= 1.0E-5d) {
                int i3 = min - 1;
                if (((double) Math.abs(this.f2617a[i3] - 1.0f)) <= 1.0E-5d && ((double) Math.abs(this.f2618b[i3] - 1.0f)) <= 1.0E-5d) {
                    int i4 = 0;
                    float f2 = BitmapDescriptorFactory.HUE_RED;
                    while (i < min) {
                        float[] fArr2 = this.f2617a;
                        int i5 = i4 + 1;
                        float f3 = fArr2[i4];
                        if (f3 >= f2) {
                            fArr2[i] = f3;
                            i++;
                            f2 = f3;
                            i4 = i5;
                        } else {
                            throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f3);
                        }
                    }
                    if (pathMeasure.nextContour()) {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The Path must start at (0,0) and end at (1,1) start: ");
            sb.append(this.f2617a[0]);
            sb.append(",");
            sb.append(this.f2618b[0]);
            sb.append(" end:");
            int i6 = min - 1;
            sb.append(this.f2617a[i6]);
            sb.append(",");
            sb.append(this.f2618b[i6]);
            throw new IllegalArgumentException(sb.toString());
        }
        throw new IllegalArgumentException("The Path has a invalid length " + length);
    }

    public float getInterpolation(float f2) {
        if (f2 <= BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f2617a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f2 < this.f2617a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.f2617a;
        float f3 = fArr[length] - fArr[i];
        if (f3 == BitmapDescriptorFactory.HUE_RED) {
            return this.f2618b[i];
        }
        float[] fArr2 = this.f2618b;
        float f4 = fArr2[i];
        return f4 + (((f2 - fArr[i]) / f3) * (fArr2[length] - f4));
    }
}
