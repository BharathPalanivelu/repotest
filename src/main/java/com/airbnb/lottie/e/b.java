package com.airbnb.lottie.e;

import android.util.JsonReader;
import com.airbnb.lottie.c.a.a;
import com.airbnb.lottie.c.a.k;
import com.airbnb.lottie.d;
import java.io.IOException;

public class b {
    public static k a(JsonReader jsonReader, d dVar) throws IOException {
        jsonReader.beginObject();
        k kVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            if (nextName.hashCode() == 97 && nextName.equals("a")) {
                c2 = 0;
            }
            if (c2 != 0) {
                jsonReader.skipValue();
            } else {
                kVar = b(jsonReader, dVar);
            }
        }
        jsonReader.endObject();
        return kVar == null ? new k((a) null, (a) null, (com.airbnb.lottie.c.a.b) null, (com.airbnb.lottie.c.a.b) null) : kVar;
    }

    private static k b(JsonReader jsonReader, d dVar) throws IOException {
        jsonReader.beginObject();
        a aVar = null;
        a aVar2 = null;
        com.airbnb.lottie.c.a.b bVar = null;
        com.airbnb.lottie.c.a.b bVar2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 116) {
                if (hashCode != 3261) {
                    if (hashCode != 3664) {
                        if (hashCode == 3684 && nextName.equals("sw")) {
                            c2 = 2;
                        }
                    } else if (nextName.equals("sc")) {
                        c2 = 1;
                    }
                } else if (nextName.equals("fc")) {
                    c2 = 0;
                }
            } else if (nextName.equals("t")) {
                c2 = 3;
            }
            if (c2 == 0) {
                aVar = d.g(jsonReader, dVar);
            } else if (c2 == 1) {
                aVar2 = d.g(jsonReader, dVar);
            } else if (c2 == 2) {
                bVar = d.a(jsonReader, dVar);
            } else if (c2 != 3) {
                jsonReader.skipValue();
            } else {
                bVar2 = d.a(jsonReader, dVar);
            }
        }
        jsonReader.endObject();
        return new k(aVar, aVar2, bVar, bVar2);
    }
}
