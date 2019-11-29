package com.airbnb.lottie.e;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.a.b.h;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f.f;
import java.io.IOException;

class w {
    static h a(JsonReader jsonReader, d dVar) throws IOException {
        return new h(dVar, q.a(jsonReader, dVar, f.a(), x.f3684a, jsonReader.peek() == JsonToken.BEGIN_OBJECT));
    }
}
