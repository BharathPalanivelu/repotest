package com.shopee.app.tracking.b;

import com.shopee.a.b.a;
import com.shopee.app.react.protocol.PushData;
import com.shopee.app.web.WebRegister;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final String f19151a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19152b;

    public boolean c() {
        return false;
    }

    public b(String str, String str2) {
        this.f19151a = str;
        this.f19152b = str2;
    }

    public String a() {
        return this.f19151a;
    }

    public String b() {
        try {
            PushData pushData = (PushData) WebRegister.GSON.a(this.f19152b, PushData.class);
            if (pushData != null) {
                return pushData.getPropsString();
            }
            return "";
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return "";
        }
    }
}
