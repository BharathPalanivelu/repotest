package com.airbnb.lottie.e;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.c.b.c;
import com.airbnb.lottie.f.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class l implements aj<c> {

    /* renamed from: a  reason: collision with root package name */
    private int f3679a;

    public l(int i) {
        this.f3679a = i;
    }

    /* renamed from: a */
    public c b(JsonReader jsonReader, float f2) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (z) {
            jsonReader.endArray();
        }
        if (this.f3679a == -1) {
            this.f3679a = arrayList.size() / 4;
        }
        int i = this.f3679a;
        float[] fArr = new float[i];
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f3679a * 4; i4++) {
            int i5 = i4 / 4;
            double floatValue = (double) ((Float) arrayList.get(i4)).floatValue();
            int i6 = i4 % 4;
            if (i6 == 0) {
                fArr[i5] = (float) floatValue;
            } else if (i6 == 1) {
                Double.isNaN(floatValue);
                i2 = (int) (floatValue * 255.0d);
            } else if (i6 == 2) {
                Double.isNaN(floatValue);
                i3 = (int) (floatValue * 255.0d);
            } else if (i6 == 3) {
                Double.isNaN(floatValue);
                iArr[i5] = Color.argb(255, i2, i3, (int) (floatValue * 255.0d));
            }
        }
        c cVar = new c(fArr, iArr);
        a(cVar, (List<Float>) arrayList);
        return cVar;
    }

    private void a(c cVar, List<Float> list) {
        int i = this.f3679a * 4;
        if (list.size() > i) {
            int size = (list.size() - i) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i2 = 0;
            while (i < list.size()) {
                if (i % 2 == 0) {
                    dArr[i2] = (double) list.get(i).floatValue();
                } else {
                    dArr2[i2] = (double) list.get(i).floatValue();
                    i2++;
                }
                i++;
            }
            for (int i3 = 0; i3 < cVar.c(); i3++) {
                int i4 = cVar.b()[i3];
                cVar.b()[i3] = Color.argb(a((double) cVar.a()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
            }
        }
    }

    private int a(double d2, double[] dArr, double[] dArr2) {
        double d3;
        double[] dArr3 = dArr;
        double[] dArr4 = dArr2;
        int i = 1;
        while (true) {
            if (i >= dArr3.length) {
                d3 = dArr4[dArr4.length - 1];
                break;
            }
            int i2 = i - 1;
            double d4 = dArr3[i2];
            double d5 = dArr3[i];
            if (dArr3[i] >= d2) {
                d3 = e.a(dArr4[i2], dArr4[i], (d2 - d4) / (d5 - d4));
                break;
            }
            i++;
        }
        return (int) (d3 * 255.0d);
    }
}
