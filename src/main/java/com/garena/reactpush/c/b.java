package com.garena.reactpush.c;

import com.appsflyer.share.Constants;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class b implements Callback {

    /* renamed from: a  reason: collision with root package name */
    private final OkHttpClient f8348a;

    /* renamed from: b  reason: collision with root package name */
    private final a f8349b;

    /* renamed from: c  reason: collision with root package name */
    private String f8350c;

    /* renamed from: d  reason: collision with root package name */
    private String f8351d;

    public interface a {
        void a(File file);

        void a(Call call, Exception exc);
    }

    public b(OkHttpClient okHttpClient, String str, String str2, a aVar) {
        this.f8348a = okHttpClient;
        this.f8349b = aVar;
        this.f8350c = str;
        this.f8351d = str2.replace("https://", "http://");
    }

    public void a() {
        try {
            FirebasePerfOkHttpClient.enqueue(this.f8348a.newCall(new Request.Builder().url(this.f8351d).build()), this);
        } catch (Exception unused) {
        }
    }

    public void onFailure(Call call, IOException iOException) {
        a(call, iOException);
    }

    public void onResponse(Call call, Response response) throws IOException {
        try {
            if (response.isSuccessful()) {
                InputStream byteStream = response.body().byteStream();
                File file = new File(this.f8350c + DefaultDiskStorage.FileType.TEMP);
                file.getParentFile().mkdirs();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(byteStream);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                bufferedInputStream.close();
                new File(this.f8350c).delete();
                if (file.renameTo(new File(this.f8350c))) {
                    this.f8349b.a(new File(this.f8350c));
                } else {
                    a(call, new Exception(response.message()));
                }
            } else {
                a(call, new Exception(response.message()));
            }
        } catch (Exception e2) {
            a(call, e2);
        }
    }

    private void a(Call call, Exception exc) {
        d dVar = com.garena.reactpush.b.f6701d;
        dVar.b("File Failed: " + exc.getMessage() + Constants.URL_PATH_DELIMITER + call.request().url());
        this.f8349b.a(call, exc);
    }
}
