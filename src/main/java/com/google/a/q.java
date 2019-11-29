package com.google.a;

import com.google.a.b.l;
import com.google.a.d.a;
import com.google.a.d.b;
import com.google.a.d.d;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class q {
    public l a(String str) throws u {
        return a((Reader) new StringReader(str));
    }

    public l a(Reader reader) throws m, u {
        try {
            a aVar = new a(reader);
            l a2 = a(aVar);
            if (!a2.l()) {
                if (aVar.f() != b.END_DOCUMENT) {
                    throw new u("Did not consume the entire document.");
                }
            }
            return a2;
        } catch (d e2) {
            throw new u((Throwable) e2);
        } catch (IOException e3) {
            throw new m((Throwable) e3);
        } catch (NumberFormatException e4) {
            throw new u((Throwable) e4);
        }
    }

    public l a(a aVar) throws m, u {
        boolean q = aVar.q();
        aVar.a(true);
        try {
            l a2 = l.a(aVar);
            aVar.a(q);
            return a2;
        } catch (StackOverflowError e2) {
            throw new p("Failed parsing JSON source: " + aVar + " to Json", e2);
        } catch (OutOfMemoryError e3) {
            throw new p("Failed parsing JSON source: " + aVar + " to Json", e3);
        } catch (Throwable th) {
            aVar.a(q);
            throw th;
        }
    }
}
