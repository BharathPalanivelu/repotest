package com.beetalklib.network.b;

import java.net.UnknownHostException;

public class d extends a {
    public d(Exception exc) {
        super(exc, "Unable to connect to the server.");
        boolean z = exc instanceof UnknownHostException;
    }

    public int a() {
        return getCause() instanceof UnknownHostException ? 1 : 2;
    }
}
