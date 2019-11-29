package org.d.f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class c {
    static List<String> a(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        return arrayList;
    }
}
