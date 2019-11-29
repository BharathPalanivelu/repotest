package com.airpay.paysdk.base.different.netserver;

import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import com.airpay.paysdk.a;
import com.google.a.f;
import com.shopee.arcatch.data.common_bean.Country;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b {
    private static ArrayList<EnvironmentBean> a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = Country.COUNTRY_TH;
        }
        String str2 = "environments_" + str.toLowerCase() + ".json";
        try {
            return (ArrayList) new f().a((Reader) new InputStreamReader(a.a().b().getAssets().open(str2)), new com.google.a.c.a<List<EnvironmentBean>>() {
            }.getType());
        } catch (IOException e2) {
            e2.printStackTrace();
            throw new RuntimeException("Cannot load environments config file: " + str2, e2);
        }
    }

    public static TcpServerBean a(a aVar) {
        String b2 = aVar.b();
        int c2 = aVar.c();
        ArrayList<EnvironmentBean> a2 = a(b2);
        Iterator<EnvironmentBean> it = a2.iterator();
        TcpServerBean tcpServerBean = null;
        while (it.hasNext()) {
            EnvironmentBean next = it.next();
            if (next.getType() == c2) {
                tcpServerBean = next.getTcpServerList().getMainServer();
            }
        }
        if (tcpServerBean != null) {
            return tcpServerBean;
        }
        Iterator<EnvironmentBean> it2 = a2.iterator();
        while (it2.hasNext()) {
            EnvironmentBean next2 = it2.next();
            if (next2.getType() == 4) {
                tcpServerBean = next2.getTcpServerList().getMainServer();
            }
        }
        if (tcpServerBean != null) {
            return tcpServerBean;
        }
        throw new AndroidRuntimeException("not matched environment config");
    }
}
