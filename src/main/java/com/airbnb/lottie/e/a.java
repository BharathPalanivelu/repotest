package com.airbnb.lottie.e;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.e;
import com.airbnb.lottie.c.a.i;
import com.airbnb.lottie.c.a.m;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f.f;
import java.io.IOException;
import java.util.ArrayList;

public class a {
    public static e a(JsonReader jsonReader, d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(w.a(jsonReader, dVar));
            }
            jsonReader.endArray();
            r.a(arrayList);
        } else {
            arrayList.add(new com.airbnb.lottie.g.a(p.b(jsonReader, f.a())));
        }
        return new e(arrayList);
    }

    static m<PointF, PointF> b(JsonReader jsonReader, d dVar) throws IOException {
        jsonReader.beginObject();
        e eVar = null;
        b bVar = null;
        b bVar2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 107) {
                if (hashCode != 120) {
                    if (hashCode == 121 && nextName.equals("y")) {
                        c2 = 2;
                    }
                } else if (nextName.equals("x")) {
                    c2 = 1;
                }
            } else if (nextName.equals("k")) {
                c2 = 0;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        jsonReader.skipValue();
                    } else if (jsonReader.peek() == JsonToken.STRING) {
                        jsonReader.skipValue();
                    } else {
                        bVar2 = d.a(jsonReader, dVar);
                    }
                } else if (jsonReader.peek() == JsonToken.STRING) {
                    jsonReader.skipValue();
                } else {
                    bVar = d.a(jsonReader, dVar);
                }
                z = true;
            } else {
                eVar = a(jsonReader, dVar);
            }
        }
        jsonReader.endObject();
        if (z) {
            dVar.a("Lottie doesn't support expressions.");
        }
        if (eVar != null) {
            return eVar;
        }
        return new i(bVar, bVar2);
    }
}
