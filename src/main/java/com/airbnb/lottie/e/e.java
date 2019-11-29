package com.airbnb.lottie.e;

import android.graphics.PointF;
import android.util.JsonReader;
import com.airbnb.lottie.c.a.f;
import com.airbnb.lottie.c.a.m;
import com.airbnb.lottie.c.b.a;
import com.airbnb.lottie.d;
import java.io.IOException;

class e {
    static a a(JsonReader jsonReader, d dVar, int i) throws IOException {
        String str = null;
        boolean z = i == 3;
        m<PointF, PointF> mVar = null;
        f fVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 100) {
                if (hashCode != 112) {
                    if (hashCode != 115) {
                        if (hashCode == 3519 && nextName.equals("nm")) {
                            c2 = 0;
                        }
                    } else if (nextName.equals("s")) {
                        c2 = 2;
                    }
                } else if (nextName.equals("p")) {
                    c2 = 1;
                }
            } else if (nextName.equals("d")) {
                c2 = 3;
            }
            if (c2 == 0) {
                str = jsonReader.nextString();
            } else if (c2 == 1) {
                mVar = a.b(jsonReader, dVar);
            } else if (c2 == 2) {
                fVar = d.c(jsonReader, dVar);
            } else if (c2 != 3) {
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextInt() == 3;
            }
        }
        return new a(str, mVar, fVar, z);
    }
}
