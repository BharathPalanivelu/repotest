package qalsdk;

import com.tencent.qalsdk.core.c;
import com.tencent.qalsdk.core.j;
import com.tencent.qalsdk.util.MsfSocketInputBuffer;
import com.tencent.qalsdk.util.QLog;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.ProtocolException;
import org.apache.http.impl.io.ChunkedInputStream;
import org.apache.http.impl.io.ContentLengthInputStream;
import org.apache.http.impl.io.IdentityInputStream;

public final class e implements f {

    /* renamed from: a  reason: collision with root package name */
    private j f34133a;

    public e(j jVar) {
        this.f34133a = jVar;
    }

    public final void a(MsfSocketInputBuffer msfSocketInputBuffer) throws Exception {
        do {
            g a2 = new h(msfSocketInputBuffer).a();
            int statusCode = a2.a().getStatusCode();
            if ((statusCode < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) ? false : true) {
                if (a2.b() != -1) {
                    a2.a((InputStream) new ContentLengthInputStream(msfSocketInputBuffer, (long) a2.b()));
                } else if (a2.c().equalsIgnoreCase("chunked")) {
                    a2.a((InputStream) new ChunkedInputStream(msfSocketInputBuffer));
                } else {
                    a2.a((InputStream) new IdentityInputStream(msfSocketInputBuffer));
                }
            }
            int statusCode2 = a2.a().getStatusCode();
            if (statusCode2 >= 200) {
                byte[] bArr = new byte[20480];
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int read = a2.e().read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    i += read;
                    byte[] bArr2 = new byte[read];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
                    arrayList.add(bArr2);
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag", 2, " read " + bArr2.length);
                    }
                }
                if (arrayList.size() == 1) {
                    this.f34133a.f32187c.a((f) this, (byte[]) arrayList.get(0));
                } else {
                    byte[] bArr3 = new byte[i];
                    Iterator it = arrayList.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        byte[] bArr4 = (byte[]) it.next();
                        System.arraycopy(bArr4, 0, bArr3, i2, bArr4.length);
                        i2 += bArr4.length;
                    }
                    this.f34133a.f32187c.a((f) this, bArr3);
                }
            } else if (statusCode2 != 100) {
                throw new ProtocolException("Unexpected response: " + a2.a());
            }
        } while (msfSocketInputBuffer.hasBufferedData());
    }

    public final byte[] a(c cVar, String str, String str2, byte[] bArr) {
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.put(bArr2).flip();
        int i = allocate.getInt();
        if (bArr.length <= i) {
            return a(cVar, bArr);
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (bArr.length >= i) {
            byte[] bArr3 = new byte[i];
            System.arraycopy(bArr, i2, bArr3, 0, bArr3.length);
            byte[] a2 = a(cVar, bArr3);
            i3 += a2.length;
            arrayList.add(a2);
            i2 += bArr3.length;
            if (i2 >= bArr.length) {
                break;
            }
            System.arraycopy(bArr, i2, bArr2, 0, 4);
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.put(bArr2).flip();
            i = allocate2.getInt();
        }
        byte[] bArr4 = new byte[i3];
        Iterator it = arrayList.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            byte[] bArr5 = (byte[]) it.next();
            System.arraycopy(bArr5, 0, bArr4, i4, bArr5.length);
            i4 += bArr5.length;
        }
        return bArr4;
    }

    private static byte[] a(c cVar, byte[] bArr) {
        byte[] bytes = ("POST / HTTP/1.1\r\nConnection: Keep-Alive\r\nHost: " + cVar.c() + ":" + cVar.d() + "\r\nAccept: */*\r\n" + "User-Agent: javaMsfClient\r\nContent-Type: application/x-www-form-urlencoded\r\n" + "Content-Length: " + bArr.length + "\r\n\r\n").getBytes();
        byte[] bArr2 = new byte[(bytes.length + bArr.length)];
        System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
        System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
        return bArr2;
    }
}
