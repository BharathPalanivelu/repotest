package com.shopee.app.h;

import com.garena.android.appkit.d.a;
import com.shopee.app.application.ar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    public static JSONObject a(int i) {
        InputStream openRawResource;
        try {
            openRawResource = ar.a().getResources().openRawResource(i);
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource, "UTF-8"));
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read == -1) {
                    break;
                }
                stringWriter.write(cArr, 0, read);
            }
            if (openRawResource != null) {
                openRawResource.close();
            }
            return new JSONObject(stringWriter.toString());
        } catch (JSONException e2) {
            a.a(e2);
            return null;
        } catch (IOException e3) {
            a.a(e3);
            return null;
        } catch (Throwable th) {
            if (openRawResource != null) {
                openRawResource.close();
            }
            throw th;
        }
    }
}
