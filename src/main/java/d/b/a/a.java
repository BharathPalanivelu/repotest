package d.b.a;

import com.tencent.qcloud.core.http.HttpMetric;
import d.d.b.j;

public class a extends d.b.a {
    public void a(Throwable th, Throwable th2) {
        j.b(th, "cause");
        j.b(th2, HttpMetric.ATTR_EXCEPTION);
    }
}
