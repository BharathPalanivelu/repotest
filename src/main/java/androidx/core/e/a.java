package androidx.core.e;

import android.util.Base64;
import androidx.core.util.e;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f1659a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1660b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1661c;

    /* renamed from: d  reason: collision with root package name */
    private final List<List<byte[]>> f1662d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1663e = 0;

    /* renamed from: f  reason: collision with root package name */
    private final String f1664f = (this.f1659a + "-" + this.f1660b + "-" + this.f1661c);

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f1659a = (String) e.a(str);
        this.f1660b = (String) e.a(str2);
        this.f1661c = (String) e.a(str3);
        this.f1662d = (List) e.a(list);
    }

    public String a() {
        return this.f1659a;
    }

    public String b() {
        return this.f1660b;
    }

    public String c() {
        return this.f1661c;
    }

    public List<List<byte[]>> d() {
        return this.f1662d;
    }

    public int e() {
        return this.f1663e;
    }

    public String f() {
        return this.f1664f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f1659a + ", mProviderPackage: " + this.f1660b + ", mQuery: " + this.f1661c + ", mCertificates:");
        for (int i = 0; i < this.f1662d.size(); i++) {
            sb.append(" [");
            List list = this.f1662d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f1663e);
        return sb.toString();
    }
}
