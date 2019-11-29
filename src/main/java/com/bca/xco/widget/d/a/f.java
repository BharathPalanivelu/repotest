package com.bca.xco.widget.d.a;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f5043a = new f() {
        public List<InetAddress> a(String str) {
            if (str != null) {
                return Arrays.asList(InetAddress.getAllByName(str));
            }
            throw new UnknownHostException("hostname == null");
        }
    };

    List<InetAddress> a(String str);
}
