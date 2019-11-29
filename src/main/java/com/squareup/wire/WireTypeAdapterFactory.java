package com.squareup.wire;

import com.google.a.c.a;
import com.google.a.f;
import com.google.a.w;
import com.google.a.x;

public final class WireTypeAdapterFactory implements x {
    private final Wire wire;

    public WireTypeAdapterFactory(Wire wire2) {
        this.wire = wire2;
    }

    public <T> w<T> create(f fVar, a<T> aVar) {
        if (aVar.getRawType().equals(e.f.class)) {
            return new ByteStringTypeAdapter();
        }
        if (Message.class.isAssignableFrom(aVar.getRawType())) {
            return new MessageTypeAdapter(this.wire, fVar, aVar);
        }
        return null;
    }
}
