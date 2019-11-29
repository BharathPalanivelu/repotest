package com.google.a;

import com.google.a.b.a.e;
import com.google.a.b.a.f;
import com.google.a.d.a;
import com.google.a.d.b;
import com.google.a.d.c;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public abstract class w<T> {
    public abstract T read(a aVar) throws IOException;

    public abstract void write(c cVar, T t) throws IOException;

    public final void toJson(Writer writer, T t) throws IOException {
        write(new c(writer), t);
    }

    public final w<T> nullSafe() {
        return new w<T>() {
            public void write(c cVar, T t) throws IOException {
                if (t == null) {
                    cVar.f();
                } else {
                    w.this.write(cVar, t);
                }
            }

            public T read(a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return w.this.read(aVar);
                }
                aVar.j();
                return null;
            }
        };
    }

    public final String toJson(T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final l toJsonTree(T t) {
        try {
            f fVar = new f();
            write(fVar, t);
            return fVar.a();
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        }
    }

    public final T fromJson(Reader reader) throws IOException {
        return read(new a(reader));
    }

    public final T fromJson(String str) throws IOException {
        return fromJson((Reader) new StringReader(str));
    }

    public final T fromJsonTree(l lVar) {
        try {
            return read(new e(lVar));
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        }
    }
}
