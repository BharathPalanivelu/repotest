package com.airbnb.lottie.e;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.c.a;
import com.airbnb.lottie.c.b.l;
import com.airbnb.lottie.f.e;
import com.appsflyer.share.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ad implements aj<l> {

    /* renamed from: a  reason: collision with root package name */
    public static final ad f3675a = new ad();

    private ad() {
    }

    /* renamed from: a */
    public l b(JsonReader jsonReader, float f2) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 99) {
                if (hashCode != 105) {
                    if (hashCode != 111) {
                        if (hashCode == 118 && nextName.equals("v")) {
                            c2 = 1;
                        }
                    } else if (nextName.equals("o")) {
                        c2 = 3;
                    }
                } else if (nextName.equals("i")) {
                    c2 = 2;
                }
            } else if (nextName.equals(Constants.URL_CAMPAIGN)) {
                c2 = 0;
            }
            if (c2 == 0) {
                z = jsonReader.nextBoolean();
            } else if (c2 == 1) {
                list = p.a(jsonReader, f2);
            } else if (c2 == 2) {
                list2 = p.a(jsonReader, f2);
            } else if (c2 == 3) {
                list3 = p.a(jsonReader, f2);
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == JsonToken.END_ARRAY) {
            jsonReader.endArray();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        } else if (list.isEmpty()) {
            return new l(new PointF(), false, Collections.emptyList());
        } else {
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i = 1; i < size; i++) {
                PointF pointF2 = list.get(i);
                int i2 = i - 1;
                arrayList.add(new a(e.a(list.get(i2), list3.get(i2)), e.a(pointF2, list2.get(i)), pointF2));
            }
            if (z) {
                PointF pointF3 = list.get(0);
                int i3 = size - 1;
                arrayList.add(new a(e.a(list.get(i3), list3.get(i3)), e.a(pointF3, list2.get(0)), pointF3));
            }
            return new l(pointF, z, arrayList);
        }
    }
}
