package com.airbnb.lottie.e;

import android.graphics.Path;
import android.util.JsonReader;
import com.airbnb.lottie.c.a.a;
import com.airbnb.lottie.c.b.m;
import com.airbnb.lottie.d;
import com.appsflyer.share.Constants;
import java.io.IOException;

class ae {
    static m a(JsonReader jsonReader, d dVar) throws IOException {
        String str = null;
        a aVar = null;
        com.airbnb.lottie.c.a.d dVar2 = null;
        int i = 1;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -396065730) {
                if (hashCode != 99) {
                    if (hashCode != 111) {
                        if (hashCode != 114) {
                            if (hashCode == 3519 && nextName.equals("nm")) {
                                c2 = 0;
                            }
                        } else if (nextName.equals("r")) {
                            c2 = 4;
                        }
                    } else if (nextName.equals("o")) {
                        c2 = 2;
                    }
                } else if (nextName.equals(Constants.URL_CAMPAIGN)) {
                    c2 = 1;
                }
            } else if (nextName.equals("fillEnabled")) {
                c2 = 3;
            }
            if (c2 == 0) {
                str = jsonReader.nextString();
            } else if (c2 == 1) {
                aVar = d.g(jsonReader, dVar);
            } else if (c2 == 2) {
                dVar2 = d.b(jsonReader, dVar);
            } else if (c2 == 3) {
                z = jsonReader.nextBoolean();
            } else if (c2 != 4) {
                jsonReader.skipValue();
            } else {
                i = jsonReader.nextInt();
            }
        }
        return new m(str, z, i == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVar, dVar2);
    }
}
