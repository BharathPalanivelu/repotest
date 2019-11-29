package com.garena.h.a;

import java.net.UnknownHostException;

public class e extends a {
    public e(Exception exc) {
        super(exc, "Unable to connect to the server.");
        boolean z = exc instanceof UnknownHostException;
    }

    public d a() {
        if (getCause() instanceof UnknownHostException) {
            return d.UNKNOWN_HOST;
        }
        return d.SOCKET_ERROR;
    }
}
