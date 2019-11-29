package com.tencent.imsdk;

import com.tencent.imcore.EnvRequestClosure;
import com.tencent.imcore.HttpMethod;
import com.tencent.imsdk.log.QLog;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;

final class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ HttpMethod f30677a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ HttpURLConnection f30678b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ byte[] f30679c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ EnvRequestClosure f30680d;

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ IMCoreAndroidEnv f30681e;

    ab(IMCoreAndroidEnv iMCoreAndroidEnv, HttpMethod httpMethod, HttpURLConnection httpURLConnection, byte[] bArr, EnvRequestClosure envRequestClosure) {
        this.f30681e = iMCoreAndroidEnv;
        this.f30677a = httpMethod;
        this.f30678b = httpURLConnection;
        this.f30679c = bArr;
        this.f30680d = envRequestClosure;
    }

    public final void run() {
        try {
            if (this.f30677a == HttpMethod.kPost) {
                this.f30678b.setRequestMethod("POST");
                this.f30678b.setDoOutput(true);
                this.f30678b.setRequestProperty(HttpConstants.Header.CONTENT_LENGTH, String.valueOf(this.f30679c.length));
                this.f30678b.getOutputStream().write(this.f30679c);
            }
            this.f30678b.setRequestProperty("connection", "close");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.f30678b.getInputStream());
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
            String access$000 = IMCoreAndroidEnv.logTag;
            QLog.d(access$000, 1, "httpRequest->success: " + new String(byteArray));
            if (this.f30680d != null) {
                this.f30680d.done(byteArray);
            }
        } catch (Throwable th) {
            QLog.e(IMCoreAndroidEnv.logTag, 1, IMFunc.getExceptionInfo(th));
        }
        this.f30678b.disconnect();
    }
}
