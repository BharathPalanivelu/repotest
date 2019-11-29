package com.google.c;

import java.io.IOException;

public class v extends IOException {
    private static final long serialVersionUID = -1616151763072450476L;
    private ad unfinishedMessage = null;

    public v(String str) {
        super(str);
    }

    public v(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public v a(ad adVar) {
        this.unfinishedMessage = adVar;
        return this;
    }

    public ad a() {
        return this.unfinishedMessage;
    }

    public IOException b() {
        return getCause() instanceof IOException ? (IOException) getCause() : this;
    }

    static v c() {
        return new v("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static v d() {
        return new v("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static v e() {
        return new v("CodedInputStream encountered a malformed varint.");
    }

    static v f() {
        return new v("Protocol message contained an invalid tag (zero).");
    }

    static v g() {
        return new v("Protocol message end-group tag did not match expected tag.");
    }

    static v h() {
        return new v("Protocol message tag had invalid wire type.");
    }

    static v i() {
        return new v("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static v j() {
        return new v("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static v k() {
        return new v("Protocol message had invalid UTF-8.");
    }
}
