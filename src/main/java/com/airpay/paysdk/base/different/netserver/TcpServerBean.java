package com.airpay.paysdk.base.different.netserver;

import androidx.annotation.Keep;
import com.google.a.a.c;

@Keep
public class TcpServerBean {
    @c(a = "address")
    private String address;
    @c(a = "port")
    private int port;
    @c(a = "tls")
    private boolean tls;

    public String getAddress() {
        return this.address;
    }

    public int getPort() {
        return this.port;
    }

    public boolean isTls() {
        return this.tls;
    }

    public String toString() {
        return "TcpServerBean{address='" + this.address + '\'' + ", port=" + this.port + ", tls=" + this.tls + '}';
    }
}
