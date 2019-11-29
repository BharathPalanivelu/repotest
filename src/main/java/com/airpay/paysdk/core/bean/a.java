package com.airpay.paysdk.core.bean;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f4123a;

    /* renamed from: b  reason: collision with root package name */
    public int f4124b;

    public a(int i, int i2) {
        this.f4123a = i;
        this.f4124b = i2;
    }

    public boolean a(long j) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("Asia/Bangkok"));
        gregorianCalendar.setTimeInMillis(j);
        int i = (gregorianCalendar.get(11) * 100) + gregorianCalendar.get(12);
        if (i >= this.f4123a && i <= this.f4124b) {
            return true;
        }
        int i2 = this.f4124b;
        int i3 = this.f4123a;
        if (i2 >= i3) {
            return false;
        }
        if (i <= i3 && i >= i2) {
            return false;
        }
        return true;
    }

    public String a() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("Asia/Bangkok"));
        gregorianCalendar.setTimeInMillis(System.currentTimeMillis());
        gregorianCalendar.set(11, this.f4124b / 100);
        gregorianCalendar.set(12, this.f4124b % 100);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat.format(gregorianCalendar.getTime());
    }
}
