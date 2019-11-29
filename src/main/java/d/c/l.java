package d.c;

import d.d.b.j;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public final class l {
    public static final String a(Reader reader) {
        j.b(reader, "$this$readText");
        StringWriter stringWriter = new StringWriter();
        a(reader, stringWriter, 0, 2, (Object) null);
        String stringWriter2 = stringWriter.toString();
        j.a((Object) stringWriter2, "buffer.toString()");
        return stringWriter2;
    }

    public static /* synthetic */ long a(Reader reader, Writer writer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return a(reader, writer, i);
    }

    public static final long a(Reader reader, Writer writer, int i) {
        j.b(reader, "$this$copyTo");
        j.b(writer, "out");
        char[] cArr = new char[i];
        int read = reader.read(cArr);
        long j = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j += (long) read;
            read = reader.read(cArr);
        }
        return j;
    }
}
