package qalsdk;

import com.tencent.qalsdk.util.MsfSocketInputBuffer;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpVersion;
import org.apache.http.NoHttpResponseException;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private LineParser f34139a;

    /* renamed from: b  reason: collision with root package name */
    private final int f34140b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34141c;

    /* renamed from: d  reason: collision with root package name */
    private final CharArrayBuffer f34142d;

    /* renamed from: e  reason: collision with root package name */
    private g f34143e;

    private h(MsfSocketInputBuffer msfSocketInputBuffer, int i, int i2) throws IOException {
        this.f34143e = new g(msfSocketInputBuffer);
        this.f34140b = -1;
        this.f34141c = -1;
        this.f34139a = BasicLineParser.DEFAULT;
        this.f34142d = new CharArrayBuffer(128);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public h(MsfSocketInputBuffer msfSocketInputBuffer) throws IOException {
        this(msfSocketInputBuffer, -1, -1);
        new BasicLineParser(HttpVersion.HTTP_1_1);
    }

    private Header[] a(int i, int i2, BasicLineParser basicLineParser) throws HttpException, IOException {
        int i3;
        if (basicLineParser == null) {
            basicLineParser = BasicLineParser.DEFAULT;
        }
        ArrayList arrayList = new ArrayList();
        CharArrayBuffer charArrayBuffer = null;
        CharArrayBuffer charArrayBuffer2 = null;
        while (true) {
            if (charArrayBuffer == null) {
                charArrayBuffer = new CharArrayBuffer(64);
            } else {
                charArrayBuffer.clear();
            }
            i3 = 0;
            if (this.f34143e.d().readLine(charArrayBuffer) == -1 || charArrayBuffer.length() <= 0) {
                Header[] headerArr = new Header[arrayList.size()];
            } else {
                if ((charArrayBuffer.charAt(0) == ' ' || charArrayBuffer.charAt(0) == 9) && charArrayBuffer2 != null) {
                    while (i3 < charArrayBuffer.length()) {
                        char charAt = charArrayBuffer.charAt(i3);
                        if (charAt != ' ' && charAt != 9) {
                            break;
                        }
                        i3++;
                    }
                    if (i2 <= 0 || ((charArrayBuffer2.length() + 1) + charArrayBuffer.length()) - i3 <= i2) {
                        charArrayBuffer2.append(' ');
                        charArrayBuffer2.append(charArrayBuffer, i3, charArrayBuffer.length() - i3);
                    } else {
                        throw new IOException("Maximum line length limit exceeded");
                    }
                } else {
                    arrayList.add(charArrayBuffer);
                    charArrayBuffer2 = charArrayBuffer;
                    charArrayBuffer = null;
                }
                if (i > 0 && arrayList.size() >= i) {
                    throw new IOException("Maximum header count exceeded");
                }
            }
        }
        Header[] headerArr2 = new Header[arrayList.size()];
        while (i3 < arrayList.size()) {
            try {
                headerArr2[i3] = basicLineParser.parseHeader((CharArrayBuffer) arrayList.get(i3));
                i3++;
            } catch (ParseException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }
        return headerArr2;
    }

    public final g a() throws IOException, HttpException {
        try {
            this.f34142d.clear();
            if (this.f34143e.d().readLine(this.f34142d) != -1) {
                this.f34143e.a(this.f34139a.parseStatusLine(this.f34142d, new ParserCursor(0, this.f34142d.length())));
                this.f34143e.a(a(this.f34140b, this.f34141c, this.f34139a));
                return this.f34143e;
            }
            throw new NoHttpResponseException("The target server failed to respond");
        } catch (ParseException e2) {
            throw new ProtocolException(e2.getMessage(), e2);
        }
    }
}
