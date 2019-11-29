package qalsdk;

import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qalsdk.util.MsfSocketInputBuffer;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.StatusLine;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final MsfSocketInputBuffer f34134a;

    /* renamed from: b  reason: collision with root package name */
    private InputStream f34135b;

    /* renamed from: c  reason: collision with root package name */
    private StatusLine f34136c;

    /* renamed from: d  reason: collision with root package name */
    private int f34137d = -1;

    /* renamed from: e  reason: collision with root package name */
    private String f34138e;

    public g(MsfSocketInputBuffer msfSocketInputBuffer) {
        this.f34134a = msfSocketInputBuffer;
    }

    public final StatusLine a() {
        return this.f34136c;
    }

    public final String toString() {
        return this.f34136c + " contentLen:" + this.f34137d + " transfer:" + this.f34138e;
    }

    public final void a(Header[] headerArr) {
        for (int length = headerArr.length - 1; length >= 0; length--) {
            Header header = headerArr[length];
            if (header.getName().equalsIgnoreCase(HttpConstants.Header.TRANSFER_ENCODING)) {
                this.f34138e = header.getValue();
            } else if (header.getName().equalsIgnoreCase(HttpConstants.Header.CONTENT_LENGTH)) {
                this.f34137d = Integer.parseInt(header.getValue());
            } else if (header.getName().equalsIgnoreCase(HttpConstants.Header.CONNECTION)) {
                header.getValue();
            } else if (header.getName().equalsIgnoreCase(COSRequestHeaderKey.CONTENT_ENCODING)) {
                header.getValue();
            } else if (header.getName().equalsIgnoreCase(HttpConstants.Header.CONTENT_TYPE)) {
                header.getValue();
            }
        }
    }

    public final int b() {
        return this.f34137d;
    }

    public final String c() {
        return this.f34138e;
    }

    public final MsfSocketInputBuffer d() {
        return this.f34134a;
    }

    public final void a(StatusLine statusLine) {
        this.f34136c = statusLine;
    }

    public final InputStream e() {
        return this.f34135b;
    }

    public final void a(InputStream inputStream) {
        this.f34135b = inputStream;
    }
}
