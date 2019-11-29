package com.tencent.liteav.basic.util;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class TXHttpRequest {
    private static final int CON_TIMEOUT = 5000;
    private static final int READ_TIMEOUT = 5000;
    private static final String TAG = "TXHttpRequest";
    /* access modifiers changed from: private */
    public long mNativeHttps = 0;

    /* access modifiers changed from: private */
    public native void nativeOnRecvMessage(long j, int i, byte[] bArr);

    public TXHttpRequest(long j) {
        this.mNativeHttps = j;
    }

    public static byte[] getHttpPostRsp(String str, byte[] bArr) throws Exception {
        TXCLog.i(TAG, "getHttpPostRsp->request: " + str);
        TXCLog.i(TAG, "getHttpPostRsp->data size: " + bArr.length);
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str.replace(SQLBuilder.BLANK, "%20")).openConnection()));
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setRequestMethod("POST");
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.flush();
        dataOutputStream.close();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr, 0, bArr.length);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    TXCLog.i(TAG, "getHttpsPostRsp->rsp size: " + byteArrayOutputStream.size());
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } else {
            TXCLog.i(TAG, "getHttpPostRsp->response code: " + responseCode);
            throw new Exception("response: " + responseCode);
        }
    }

    public int sendHttpsRequest(String str, byte[] bArr) {
        TXCLog.i(TAG, "sendHttpsRequest->enter action: " + str + ", data size: " + bArr.length);
        asyncPostRequest(str.getBytes(), bArr);
        return 0;
    }

    public static byte[] getHttpsPostRsp(String str, byte[] bArr) throws Exception {
        TXCLog.i(TAG, "getHttpsPostRsp->request: " + str);
        TXCLog.i(TAG, "getHttpsPostRsp->data: " + bArr.length);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str.replace(SQLBuilder.BLANK, "%20")).openConnection()));
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setConnectTimeout(5000);
        httpsURLConnection.setReadTimeout(5000);
        httpsURLConnection.setRequestMethod("POST");
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.flush();
        dataOutputStream.close();
        int responseCode = httpsURLConnection.getResponseCode();
        if (responseCode == 200) {
            InputStream inputStream = httpsURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr, 0, bArr.length);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    inputStream.close();
                    httpsURLConnection.disconnect();
                    TXCLog.i(TAG, "getHttpsPostRsp->rsp size: " + byteArrayOutputStream.size());
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } else {
            TXCLog.i(TAG, "getHttpsPostRsp->response code: " + responseCode);
            throw new Exception("response: " + responseCode);
        }
    }

    public void asyncPostRequest(byte[] bArr, byte[] bArr2) {
        new a(this).execute(new byte[][]{bArr, bArr2});
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f31416a = -1;

        /* renamed from: b  reason: collision with root package name */
        public String f31417b = "";

        /* renamed from: c  reason: collision with root package name */
        public byte[] f31418c = "".getBytes();

        b() {
        }
    }

    static class a extends AsyncTask<byte[], Void, b> {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<TXHttpRequest> f31411a;

        /* renamed from: b  reason: collision with root package name */
        private Handler f31412b = null;

        public a(TXHttpRequest tXHttpRequest) {
            this.f31411a = new WeakReference<>(tXHttpRequest);
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                this.f31412b = new Handler(myLooper);
            } else {
                this.f31412b = null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public b doInBackground(byte[]... bArr) {
            b bVar = new b();
            try {
                if (new String(bArr[0]).startsWith("https")) {
                    bVar.f31418c = TXHttpRequest.getHttpsPostRsp(new String(bArr[0]), bArr[1]);
                } else {
                    bVar.f31418c = TXHttpRequest.getHttpPostRsp(new String(bArr[0]), bArr[1]);
                }
                bVar.f31416a = 0;
            } catch (Exception e2) {
                bVar.f31417b = e2.toString();
            }
            TXCLog.i(TXHttpRequest.TAG, "TXPostRequest->result: " + bVar.f31416a + "|" + bVar.f31417b);
            return bVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(final b bVar) {
            super.onPostExecute(bVar);
            final TXHttpRequest tXHttpRequest = (TXHttpRequest) this.f31411a.get();
            if (tXHttpRequest != null && tXHttpRequest.mNativeHttps != 0) {
                Handler handler = this.f31412b;
                if (handler != null) {
                    handler.post(new Runnable() {
                        public void run() {
                            TXHttpRequest tXHttpRequest = tXHttpRequest;
                            tXHttpRequest.nativeOnRecvMessage(tXHttpRequest.mNativeHttps, bVar.f31416a, bVar.f31418c);
                        }
                    });
                } else {
                    tXHttpRequest.nativeOnRecvMessage(tXHttpRequest.mNativeHttps, bVar.f31416a, bVar.f31418c);
                }
            }
        }
    }
}
