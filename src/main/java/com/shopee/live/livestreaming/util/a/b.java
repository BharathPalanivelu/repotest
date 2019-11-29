package com.shopee.live.livestreaming.util.a;

import android.content.Context;
import java.io.File;

public class b {

    /* renamed from: a  reason: collision with root package name */
    d f29371a;

    /* renamed from: b  reason: collision with root package name */
    d f29372b;

    /* renamed from: c  reason: collision with root package name */
    private Context f29373c;

    public b(Context context) {
        this.f29373c = context;
        this.f29371a = new d(context, "audience_bitrate");
        this.f29372b = new d(context, "audience_txlog");
    }

    public void a(int i) {
        this.f29371a.a(i);
        this.f29372b.a(i);
    }

    public void a(File file) {
        try {
            this.f29371a.a(file);
            this.f29372b.a(file);
        } catch (Exception unused) {
        }
    }

    public void a(String str) {
        try {
            if (this.f29371a != null) {
                this.f29371a.a(str);
            }
        } catch (Exception unused) {
        }
    }

    public void b(String str) {
        try {
            if (this.f29372b != null) {
                this.f29372b.a(str);
            }
        } catch (Exception unused) {
        }
    }

    public void a() {
        this.f29371a.a();
        this.f29372b.a();
    }
}
