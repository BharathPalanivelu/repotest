package com.airpay.paysdk.pay.c.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.airpay.paysdk.base.bean.BPTopupChannelWithEvents;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f4163a = false;

    public abstract View a(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public abstract BPTopupChannelWithEvents a();

    public abstract void a(View view);

    public abstract int b();

    public boolean c() {
        return true;
    }
}
