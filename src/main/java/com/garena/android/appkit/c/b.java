package com.garena.android.appkit.c;

import com.google.firebase.perf.network.FirebasePerfHttpClient;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class b {
    public static String a(String str) throws URISyntaxException, IOException {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet();
        httpGet.setURI(new URI(str));
        HttpEntity entity = FirebasePerfHttpClient.execute(defaultHttpClient, httpGet).getEntity();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (entity != null) {
            InputStream content = entity.getContent();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        }
        return a.a(byteArrayOutputStream.toByteArray());
    }
}
