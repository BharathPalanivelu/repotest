package qalsdk;

import com.tencent.qalsdk.core.c;
import com.tencent.qalsdk.core.j;
import com.tencent.qalsdk.util.MsfSocketInputBuffer;

public final class l implements f {

    /* renamed from: a  reason: collision with root package name */
    private j f34164a;

    public final byte[] a(c cVar, String str, String str2, byte[] bArr) {
        return bArr;
    }

    public l(j jVar) {
        this.f34164a = jVar;
    }

    public final void a(MsfSocketInputBuffer msfSocketInputBuffer) throws Exception {
        byte[] bArr = new byte[msfSocketInputBuffer.getBufferlen()];
        System.arraycopy(msfSocketInputBuffer.getBuffer(), 0, bArr, 0, bArr.length);
        this.f34164a.f32187c.a((f) this, bArr);
    }
}
