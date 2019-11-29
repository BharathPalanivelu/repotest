package com.airpay.paysdk.base.different.netserver;

import androidx.annotation.Keep;
import com.google.a.a.c;

@Keep
public class EnvironmentBean {
    @c(a = "http_server")
    private String httpServer;
    @c(a = "name")
    private String name;
    @c(a = "tcp_server")
    private TcpServerListBean tcpServerList;
    @c(a = "type")
    private int type;

    public int getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public TcpServerListBean getTcpServerList() {
        return this.tcpServerList;
    }

    public String getHttpServer() {
        return this.httpServer;
    }
}
