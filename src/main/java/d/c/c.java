package d.c;

import d.d.b.j;
import java.io.File;

public final class c {
    /* access modifiers changed from: private */
    public static final String b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String sb2 = sb.toString();
        j.a((Object) sb2, "sb.toString()");
        return sb2;
    }
}
