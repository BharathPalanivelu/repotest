package com.airbnb.lottie.e;

import android.util.JsonReader;
import com.airbnb.lottie.c.a.h;
import com.airbnb.lottie.c.b.o;
import com.airbnb.lottie.d;
import java.io.IOException;

class ag {
    static o a(JsonReader jsonReader, d dVar) throws IOException {
        String str = null;
        h hVar = null;
        int i = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3432) {
                if (hashCode != 3519) {
                    if (hashCode == 104415 && nextName.equals("ind")) {
                        c2 = 1;
                    }
                } else if (nextName.equals("nm")) {
                    c2 = 0;
                }
            } else if (nextName.equals("ks")) {
                c2 = 2;
            }
            if (c2 == 0) {
                str = jsonReader.nextString();
            } else if (c2 == 1) {
                i = jsonReader.nextInt();
            } else if (c2 != 2) {
                jsonReader.skipValue();
            } else {
                hVar = d.e(jsonReader, dVar);
            }
        }
        return new o(str, i, hVar);
    }
}
