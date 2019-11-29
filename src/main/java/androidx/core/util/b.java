package androidx.core.util;

import android.util.Log;
import java.io.Writer;

public class b extends Writer {

    /* renamed from: a  reason: collision with root package name */
    private final String f1880a;

    /* renamed from: b  reason: collision with root package name */
    private StringBuilder f1881b = new StringBuilder(128);

    public b(String str) {
        this.f1880a = str;
    }

    public void close() {
        a();
    }

    public void flush() {
        a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c2 = cArr[i + i3];
            if (c2 == 10) {
                a();
            } else {
                this.f1881b.append(c2);
            }
        }
    }

    private void a() {
        if (this.f1881b.length() > 0) {
            Log.d(this.f1880a, this.f1881b.toString());
            StringBuilder sb = this.f1881b;
            sb.delete(0, sb.length());
        }
    }
}
