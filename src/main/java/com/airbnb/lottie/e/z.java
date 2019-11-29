package com.airbnb.lottie.e;

import android.graphics.PointF;
import android.util.JsonReader;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.m;
import com.airbnb.lottie.c.b.i;
import com.airbnb.lottie.d;
import java.io.IOException;

class z {
    static i a(JsonReader jsonReader, d dVar) throws IOException {
        String str = null;
        i.a aVar = null;
        b bVar = null;
        m<PointF, PointF> mVar = null;
        b bVar2 = null;
        b bVar3 = null;
        b bVar4 = null;
        b bVar5 = null;
        b bVar6 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 112) {
                if (hashCode != 114) {
                    if (hashCode != 3519) {
                        if (hashCode != 3588) {
                            if (hashCode != 3686) {
                                if (hashCode != 3369) {
                                    if (hashCode != 3370) {
                                        if (hashCode != 3555) {
                                            if (hashCode == 3556 && nextName.equals("os")) {
                                                c2 = 6;
                                            }
                                        } else if (nextName.equals("or")) {
                                            c2 = 5;
                                        }
                                    } else if (nextName.equals("is")) {
                                        c2 = 8;
                                    }
                                } else if (nextName.equals("ir")) {
                                    c2 = 7;
                                }
                            } else if (nextName.equals("sy")) {
                                c2 = 1;
                            }
                        } else if (nextName.equals("pt")) {
                            c2 = 2;
                        }
                    } else if (nextName.equals("nm")) {
                        c2 = 0;
                    }
                } else if (nextName.equals("r")) {
                    c2 = 4;
                }
            } else if (nextName.equals("p")) {
                c2 = 3;
            }
            switch (c2) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    aVar = i.a.forValue(jsonReader.nextInt());
                    break;
                case 2:
                    bVar = d.a(jsonReader, dVar, false);
                    break;
                case 3:
                    mVar = a.b(jsonReader, dVar);
                    break;
                case 4:
                    bVar2 = d.a(jsonReader, dVar, false);
                    break;
                case 5:
                    bVar4 = d.a(jsonReader, dVar);
                    break;
                case 6:
                    bVar6 = d.a(jsonReader, dVar, false);
                    break;
                case 7:
                    bVar3 = d.a(jsonReader, dVar);
                    break;
                case 8:
                    bVar5 = d.a(jsonReader, dVar, false);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new i(str, aVar, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6);
    }
}
