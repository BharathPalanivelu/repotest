package com.google.android.libraries.places.internal;

import java.io.IOException;

public class ld extends IOException {
    public static final long serialVersionUID = -1616151763072450476L;

    public ld(String str) {
        super(str);
    }

    static ld a() {
        return new ld("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static ld b() {
        return new ld("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static le c() {
        return new le("Protocol message tag had invalid wire type.");
    }
}
