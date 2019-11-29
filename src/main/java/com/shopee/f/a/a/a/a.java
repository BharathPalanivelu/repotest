package com.shopee.f.a.a.a;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;

public class a implements Dns {
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        List<String> c2 = j.a().c(str);
        if (c2 == null || c2.size() == 0) {
            return Dns.SYSTEM.lookup(str);
        }
        ArrayList arrayList = new ArrayList();
        for (String allByName : c2) {
            arrayList.addAll(Arrays.asList(InetAddress.getAllByName(allByName)));
        }
        return arrayList;
    }
}
