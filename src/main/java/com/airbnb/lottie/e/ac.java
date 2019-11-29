package com.airbnb.lottie.e;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.g.d;
import java.io.IOException;

public class ac implements aj<d> {

    /* renamed from: a  reason: collision with root package name */
    public static final ac f3674a = new ac();

    private ac() {
    }

    /* renamed from: a */
    public d b(JsonReader jsonReader, float f2) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new d((nextDouble / 100.0f) * f2, (nextDouble2 / 100.0f) * f2);
    }
}
