package com.tencent.imsdk;

import com.tencent.imsdk.IMFunc;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.util.Map;

final class au implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ HttpURLConnection f30728a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ byte[] f30729b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ Map f30730c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ IMFunc.RequestListener f30731d;

    au(HttpURLConnection httpURLConnection, byte[] bArr, Map map, IMFunc.RequestListener requestListener) {
        this.f30728a = httpURLConnection;
        this.f30729b = bArr;
        this.f30730c = map;
        this.f30731d = requestListener;
    }

    public final void run() {
        try {
            this.f30728a.setRequestMethod("POST");
            this.f30728a.setDoOutput(true);
            this.f30728a.setRequestProperty(HttpConstants.Header.CONTENT_LENGTH, String.valueOf(this.f30729b.length));
            this.f30728a.setRequestProperty("connection", "close");
            for (Map.Entry entry : this.f30730c.entrySet()) {
                this.f30728a.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            this.f30728a.getOutputStream().write(this.f30729b);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.f30728a.getInputStream());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(10240);
            byte[] bArr = new byte[10240];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (this.f30731d != null) {
                this.f30731d.onSuccess(byteArray);
            }
        } catch (Throwable th) {
            this.f30728a.disconnect();
            throw th;
        }
        this.f30728a.disconnect();
    }
}
