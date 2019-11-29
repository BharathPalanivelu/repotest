package com.squareup.wire;

import com.google.a.d.a;
import com.google.a.d.b;
import com.google.a.d.c;
import com.google.a.w;
import e.f;
import java.io.IOException;

class ByteStringTypeAdapter extends w<f> {
    ByteStringTypeAdapter() {
    }

    public void write(c cVar, f fVar) throws IOException {
        if (fVar == null) {
            cVar.f();
        } else {
            cVar.b(fVar.b());
        }
    }

    public f read(a aVar) throws IOException {
        if (aVar.f() != b.NULL) {
            return f.b(aVar.h());
        }
        aVar.j();
        return null;
    }
}
