package org.d.d;

import com.facebook.internal.NativeProtocol;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.d.f.e;

public final class d {
    public static String a(InputStream inputStream) {
        int read;
        e.a((Object) inputStream, "Cannot get String from a null object");
        try {
            char[] cArr = new char[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST];
            StringBuilder sb = new StringBuilder();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            do {
                read = inputStreamReader.read(cArr, 0, cArr.length);
                if (read > 0) {
                    sb.append(cArr, 0, read);
                    continue;
                }
            } while (read >= 0);
            inputStreamReader.close();
            return sb.toString();
        } catch (IOException e2) {
            throw new IllegalStateException("Error while reading response body", e2);
        }
    }
}
