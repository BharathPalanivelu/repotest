package com.airbnb.lottie.e;

import android.graphics.PointF;
import android.util.JsonReader;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.f;
import com.airbnb.lottie.c.a.m;
import com.airbnb.lottie.c.b.j;
import com.airbnb.lottie.d;
import java.io.IOException;

class aa {
    static j a(JsonReader jsonReader, d dVar) throws IOException {
        String str = null;
        m<PointF, PointF> mVar = null;
        f fVar = null;
        b bVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 112) {
                if (hashCode != 3519) {
                    if (hashCode != 114) {
                        if (hashCode == 115 && nextName.equals("s")) {
                            c2 = 2;
                        }
                    } else if (nextName.equals("r")) {
                        c2 = 3;
                    }
                } else if (nextName.equals("nm")) {
                    c2 = 0;
                }
            } else if (nextName.equals("p")) {
                c2 = 1;
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
                bVar = d.a(jsonReader, dVar);
            }
        }
        return new j(str, mVar, fVar, bVar);
    }
}
