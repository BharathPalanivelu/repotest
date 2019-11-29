package tencent.tls.request;

import java.net.InetSocketAddress;

public class DNS_resolver implements Runnable {
    private String domain;
    private InetSocketAddress inetSkAddr;
    private int port;

    public DNS_resolver(String str, int i) {
        this.domain = str;
        this.port = i;
    }

    public void run() {
        try {
            set(new InetSocketAddress(this.domain, this.port));
        } catch (Exception unused) {
        }
    }

    public synchronized void set(InetSocketAddress inetSocketAddress) {
        this.inetSkAddr = inetSocketAddress;
    }

    public synchronized InetSocketAddress get() {
        return this.inetSkAddr;
    }

    public static InetSocketAddress get_DNS_resolver(String str, int i, long j) {
        try {
            DNS_resolver dNS_resolver = new DNS_resolver(str, i);
            Thread thread = new Thread(dNS_resolver);
            thread.start();
            thread.join(j);
            return dNS_resolver.get();
        } catch (Exception unused) {
            return null;
        }
    }
}
