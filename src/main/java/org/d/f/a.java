package org.d.f;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.c.d;
import org.d.c.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f33974a = Charset.forName("UTF-8");

    public static String a(String str, Map<String, String> map, String str2) throws b {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(f33974a), "HmacSHA256");
        ArrayList arrayList = new ArrayList(map.size());
        for (String next : c.a(map)) {
            arrayList.add(String.format("%s=%s", new Object[]{next, map.get(next)}));
        }
        String format = String.format("%s|%s", new Object[]{str, d.a((Iterable<?>) arrayList, '|')});
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(secretKeySpec);
            return org.apache.commons.a.a.a.b(instance.doFinal(format.getBytes(f33974a)));
        } catch (NoSuchAlgorithmException e2) {
            throw new b("Invalid algorithm name!", (Exception) e2);
        } catch (InvalidKeyException e3) {
            throw new b("Invalid key: " + str2, (Exception) e3);
        }
    }
}
