package com.airpay.paysdk.base.different.netserver;

import androidx.annotation.Keep;
import com.google.a.a.c;

@Keep
public class TcpServerListBean {
    @c(a = "backup")
    private TcpServerBean backupServer;
    @c(a = "main")
    private TcpServerBean mainServer;

    public TcpServerBean getMainServer() {
        return this.mainServer;
    }

    public TcpServerBean getBackupServer() {
        return this.backupServer;
    }
}
