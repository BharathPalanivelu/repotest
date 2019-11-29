package com.airbnb.lottie.e;

import android.util.JsonReader;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.l;
import com.airbnb.lottie.c.b.k;
import com.airbnb.lottie.d;
import com.appsflyer.share.Constants;
import java.io.IOException;

class ab {
    static k a(JsonReader jsonReader, d dVar) throws IOException {
        String str = null;
        b bVar = null;
        b bVar2 = null;
        l lVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 99) {
                if (hashCode != 111) {
                    if (hashCode != 3519) {
                        if (hashCode == 3710 && nextName.equals("tr")) {
                            c2 = 3;
                        }
                    } else if (nextName.equals("nm")) {
                        c2 = 0;
                    }
                } else if (nextName.equals("o")) {
                    c2 = 2;
                }
            } else if (nextName.equals(Constants.URL_CAMPAIGN)) {
                c2 = 1;
            }
            if (c2 == 0) {
                str = jsonReader.nextString();
            } else if (c2 == 1) {
                bVar = d.a(jsonReader, dVar, false);
            } else if (c2 == 2) {
                bVar2 = d.a(jsonReader, dVar, false);
            } else if (c2 != 3) {
                jsonReader.skipValue();
            } else {
                lVar = c.a(jsonReader, dVar);
            }
        }
        return new k(str, bVar, bVar2, lVar);
    }
}
