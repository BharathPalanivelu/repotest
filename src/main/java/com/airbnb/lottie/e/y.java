package com.airbnb.lottie.e;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

public class y implements aj<PointF> {

    /* renamed from: a  reason: collision with root package name */
    public static final y f3685a = new y();

    private y() {
    }

    /* renamed from: a */
    public PointF b(JsonReader jsonReader, float f2) throws IOException {
        JsonToken peek = jsonReader.peek();
        if (peek == JsonToken.BEGIN_ARRAY) {
            return p.b(jsonReader, f2);
        }
        if (peek == JsonToken.BEGIN_OBJECT) {
            return p.b(jsonReader, f2);
        }
        if (peek == JsonToken.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f2, ((float) jsonReader.nextDouble()) * f2);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + peek);
    }
}
