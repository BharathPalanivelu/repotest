package qalsdk;

import android.text.TextUtils;
import com.shopee.arcatch.data.common_bean.ShopeeEnv;
import com.tencent.qalsdk.util.QLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import qalsdk.n;

public final class p extends n {

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<String> f34180b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private String f34181c;

    /* renamed from: d  reason: collision with root package name */
    private int f34182d;

    /* renamed from: e  reason: collision with root package name */
    private String f34183e;

    /* renamed from: f  reason: collision with root package name */
    private String f34184f;

    /* renamed from: g  reason: collision with root package name */
    private int f34185g = 10000;
    private Socket h;
    private String i;

    public p(int i2, String str, int i3, String str2, int i4, n.a aVar) {
        super(i2, aVar);
        this.f34181c = str;
        this.f34182d = i3;
        this.f34183e = this.f34181c + ":" + this.f34182d;
        this.f34184f = str2;
        this.f34185g = 10000;
        this.i = ShopeeEnv.ENV_TEST;
    }

    /* access modifiers changed from: protected */
    public final boolean a() {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("EchoTaskTcp", 2, "WIFI detect, EchoTaskTcp " + this.f34172a + " try connect " + this.f34183e);
            }
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f34181c, this.f34182d);
            this.h = new Socket();
            this.h.setSoTimeout(10000);
            this.h.setTcpNoDelay(true);
            this.h.setKeepAlive(true);
            this.h.connect(inetSocketAddress, this.f34185g);
            if (QLog.isColorLevel()) {
                QLog.d("EchoTaskTcp", 2, "WIFI detect, EchoTaskTcp " + this.f34172a + " connect " + this.f34183e + " succ.");
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d("EchoTaskTcp", 2, "WIFI detect, EchoTaskTcp " + this.f34172a + " connect " + this.f34183e + " failed.");
            }
            Socket socket = this.h;
            if (socket == null) {
                return false;
            }
            try {
                socket.close();
                return false;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void b() {
        if (QLog.isColorLevel()) {
            QLog.d("EchoTaskTcp", 2, "WIFI detect, EchoTaskTcp " + this.f34172a + " disconnect " + this.f34183e);
        }
        if (this.h != null) {
            try {
                f34180b.clear();
                this.h.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String c() {
        try {
            OutputStream outputStream = this.h.getOutputStream();
            f34180b.add(outputStream.toString());
            InputStream inputStream = this.h.getInputStream();
            f34180b.add(inputStream.toString());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            outputStream.write(this.i.getBytes());
            outputStream.flush();
            String str = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                str = str + readLine;
            }
            bufferedReader.close();
            if (QLog.isColorLevel()) {
                StringBuilder sb = new StringBuilder("WIFI detect, EchoTaskTcp ");
                sb.append(this.f34172a);
                sb.append(" echo content: ");
                sb.append(str.length() > 10 ? str.substring(0, 10) : str);
                QLog.d("EchoTaskTcp", 2, sb.toString());
            }
            return str;
        } catch (Throwable th) {
            f34180b.clear();
            th.printStackTrace();
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("EchoTaskTcp", 2, "WIFI detect, EchoTaskTcp " + this.f34172a + " echo failed");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final int a(String str) {
        if (TextUtils.isEmpty(str) || !str.equals(this.f34184f)) {
            if (!QLog.isColorLevel()) {
                return -3;
            }
            QLog.d("EchoTaskTcp", 2, "WIFI detect, EchoTaskTcp " + this.f34172a + " valid failed.");
            return -3;
        } else if (!QLog.isColorLevel()) {
            return 0;
        } else {
            QLog.d("EchoTaskTcp", 2, "WIFI detect, EchoTaskTcp " + this.f34172a + " valid succ");
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public final Object d() {
        return this.f34183e;
    }
}
