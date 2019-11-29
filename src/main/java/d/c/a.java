package d.c;

import d.d.b.j;
import java.io.InputStream;
import java.io.OutputStream;

public final class a {
    public static final long a(InputStream inputStream, OutputStream outputStream, int i) {
        j.b(inputStream, "$this$copyTo");
        j.b(outputStream, "out");
        byte[] bArr = new byte[i];
        int read = inputStream.read(bArr);
        long j = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j += (long) read;
            read = inputStream.read(bArr);
        }
        return j;
    }
}
