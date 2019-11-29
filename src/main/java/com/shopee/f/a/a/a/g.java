package com.shopee.f.a.a.a;

import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Pattern;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private String f27212a;

    /* renamed from: b  reason: collision with root package name */
    private String f27213b;

    /* renamed from: c  reason: collision with root package name */
    private long f27214c;

    /* renamed from: d  reason: collision with root package name */
    private String f27215d;

    /* renamed from: e  reason: collision with root package name */
    private String f27216e;

    /* renamed from: f  reason: collision with root package name */
    private String f27217f = null;

    /* renamed from: g  reason: collision with root package name */
    private long f27218g = 0;
    private long h = 0;
    private String i;

    public g(String str, String str2, String str3, String str4, String str5) {
        this.f27212a = str;
        this.f27213b = str2;
        this.f27215d = str3;
        this.f27216e = str4;
        this.f27217f = str5;
    }

    public String a() {
        return this.f27212a;
    }

    public String b() {
        return this.f27213b;
    }

    public String c() {
        return this.f27215d;
    }

    public String d() {
        return this.f27216e;
    }

    public boolean e() {
        return !TextUtils.isEmpty(this.f27215d) && !TextUtils.isEmpty(this.f27216e);
    }

    public String f() {
        if (this.f27217f == null) {
            int lastIndexOf = this.f27213b.lastIndexOf(47);
            this.f27217f = this.f27213b.substring(-1 == lastIndexOf ? 0 : lastIndexOf + 1);
        }
        return this.f27217f;
    }

    public String g() {
        if (this.i == null) {
            int lastIndexOf = this.f27216e.lastIndexOf(47);
            this.i = this.f27216e.substring(-1 == lastIndexOf ? 0 : lastIndexOf + 1);
        }
        return this.i;
    }

    public long h() {
        if (0 == this.f27218g) {
            Log.i("getFileSize", "getFileSize: " + this.f27213b);
            File file = new File(this.f27213b);
            try {
                if (file.exists()) {
                    this.f27218g = (long) new FileInputStream(file).available();
                }
            } catch (Exception e2) {
                Log.e("getFileSize", "getFileSize: " + e2);
            }
        }
        return this.f27218g;
    }

    public long i() {
        if (0 == this.h) {
            Log.i("getCoverFileSize", "getCoverFileSize: " + this.f27216e);
            File file = new File(this.f27216e);
            try {
                if (file.exists()) {
                    this.h = (long) new FileInputStream(file).available();
                }
            } catch (Exception e2) {
                Log.e("getCoverFileSize", "getCoverFileSize: " + e2);
            }
        }
        return this.h;
    }

    public long j() {
        if (0 == this.f27214c) {
            this.f27214c = new File(this.f27213b).lastModified();
        }
        return this.f27214c;
    }

    public boolean a(String str) {
        return Pattern.compile("[/:*?\"<>]").matcher(str).find();
    }
}
