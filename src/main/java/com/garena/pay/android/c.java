package com.garena.pay.android;

import android.app.Activity;
import com.garena.pay.android.a.b;
import com.garena.pay.android.a.d;
import com.garena.pay.android.a.e;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class c implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    transient Activity f8165a;
    private String chosenChannelId;
    private b.a chosenDenomination;
    private String clientId;
    private b clientPaymentRequest;
    private List<b.a> denominations;
    private boolean isUseDefaultItemList;
    private d mode;
    private Integer requestCode;
    private UUID requestId;
    private e virtualCurrency;

    public boolean a() {
        return this.isUseDefaultItemList;
    }

    public b b() {
        return this.clientPaymentRequest;
    }

    public Activity c() {
        return this.f8165a;
    }

    public void a(Activity activity) {
        this.f8165a = activity;
    }

    public UUID d() {
        return this.requestId;
    }

    public Integer e() {
        return this.requestCode;
    }

    public List<b.a> f() {
        return this.denominations;
    }

    public void a(List<b.a> list) {
        this.denominations = list;
    }

    public String g() {
        return this.chosenChannelId;
    }

    public e h() {
        return this.virtualCurrency;
    }

    public b.a i() {
        return this.chosenDenomination;
    }

    public void a(b.a aVar) {
        this.chosenDenomination = aVar;
    }

    public b.a a(String str) {
        for (b.a next : this.denominations) {
            if (next.b().equals(str)) {
                return next;
            }
        }
        return null;
    }
}
