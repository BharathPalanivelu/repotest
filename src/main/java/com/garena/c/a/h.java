package com.garena.c.a;

import com.garena.android.appkit.c.b;
import com.garena.android.appkit.d.a;
import com.garena.c.a.d;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class h {
    public static List<d.a> a(a aVar) {
        String str;
        String format = String.format("http://maps.googleapis.com/maps/api/geocode/json?latlng=%s&sensor=true", new Object[]{aVar.a()});
        try {
            a.e("location %s", format);
            str = b.a(format);
        } catch (URISyntaxException e2) {
            a.a(e2);
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            str = null;
        }
        if (str == null) {
            return null;
        }
        d dVar = new d(str);
        if (!dVar.b()) {
            return null;
        }
        return dVar.a();
    }
}
