package com.airbnb.lottie.e;

import android.util.JsonReader;
import com.airbnb.lottie.c.b.h;
import java.io.IOException;

class v {
    static h a(JsonReader jsonReader) throws IOException {
        String str = null;
        h.a aVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3488) {
                if (hashCode == 3519 && nextName.equals("nm")) {
                    c2 = 0;
                }
            } else if (nextName.equals("mm")) {
                c2 = 1;
            }
            if (c2 == 0) {
                str = jsonReader.nextString();
            } else if (c2 != 1) {
                jsonReader.skipValue();
            } else {
                aVar = h.a.forId(jsonReader.nextInt());
            }
        }
        return new h(str, aVar);
    }
}
