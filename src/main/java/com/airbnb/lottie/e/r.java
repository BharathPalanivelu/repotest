package com.airbnb.lottie.e;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.d;
import com.airbnb.lottie.g.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class r {
    static <T> List<a<T>> a(JsonReader jsonReader, d dVar, float f2, aj<T> ajVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            dVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            if (nextName.hashCode() == 107 && nextName.equals("k")) {
                c2 = 0;
            }
            if (c2 != 0) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonToken.NUMBER) {
                    arrayList.add(q.a(jsonReader, dVar, f2, ajVar, false));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(q.a(jsonReader, dVar, f2, ajVar, true));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(q.a(jsonReader, dVar, f2, ajVar, false));
            }
        }
        jsonReader.endObject();
        a(arrayList);
        return arrayList;
    }

    public static void a(List<? extends a<?>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            i2++;
            ((a) list.get(i2)).f3738e = Float.valueOf(((a) list.get(i2)).f3737d);
        }
        a aVar = (a) list.get(i);
        if (aVar.f3734a == null) {
            list.remove(aVar);
        }
    }
}
