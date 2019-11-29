package com.shopee.app.h;

import android.os.Environment;
import com.facebook.internal.AnalyticsEvents;
import com.garena.android.appkit.d.a;
import com.shopee.app.application.ar;
import java.io.File;
import java.io.IOException;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f6966a = new f();

    /* renamed from: b  reason: collision with root package name */
    private boolean f6967b = false;

    /* renamed from: c  reason: collision with root package name */
    private String f6968c;

    /* renamed from: d  reason: collision with root package name */
    private String f6969d;

    /* renamed from: e  reason: collision with root package name */
    private String f6970e;

    /* renamed from: f  reason: collision with root package name */
    private String f6971f;

    /* renamed from: g  reason: collision with root package name */
    private String f6972g;
    private String h;

    public static f a() {
        return f6966a;
    }

    private f() {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.f6968c = absolutePath + File.separator + "shopeeID";
        a.e("SD Root Folder:%s", this.f6968c);
        g(this.f6968c);
    }

    public void a(boolean z) {
        this.f6967b = z;
    }

    private void g(String str) {
        File file = new File(str);
        if (file.isDirectory() && file.exists()) {
            return;
        }
        if (!file.mkdirs()) {
            a.a("create folder:%s error", str);
            return;
        }
        try {
            File file2 = new File(file.getPath() + File.separator + ".nomedia");
            if (!file2.exists()) {
                file2.createNewFile();
            }
        } catch (IOException e2) {
            a.a(e2.getMessage(), new Object[0]);
        }
    }

    public String a(String str) {
        return j() + File.separator + str + "_tn";
    }

    private String i() {
        if (this.f6967b) {
            return ar.a().getDir(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB, 0).getPath();
        }
        if (this.f6971f == null) {
            this.f6971f = this.f6968c + File.separator + AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB;
            g(this.f6971f);
        }
        return this.f6971f;
    }

    public String b() {
        return i() + File.separator;
    }

    private String j() {
        if (this.f6967b) {
            return ar.a().getDir("images", 0).getPath();
        }
        if (this.f6969d == null) {
            this.f6969d = this.f6968c + File.separator + "images";
            g(this.f6969d);
        }
        return this.f6969d;
    }

    private String k() {
        boolean z = this.f6967b;
        return ar.a().getDir("react", 0).getPath();
    }

    public String c() {
        if (this.f6967b) {
            String str = ar.a().getFilesDir().getPath() + File.separator + "sharing";
            g(str);
            return str;
        }
        if (this.f6972g == null) {
            this.f6972g = this.f6968c + File.separator + "sharing";
        }
        g(this.f6972g);
        return this.f6972g;
    }

    public String b(String str) {
        return j() + File.separator + str;
    }

    public String c(String str) {
        return c() + File.separator + str;
    }

    public String d(String str) {
        return c() + File.separator + "no_mark" + str;
    }

    public String d() {
        return j() + File.separator;
    }

    public String e() {
        return k() + File.separator;
    }

    public boolean e(String str) {
        File file = new File(str);
        return file.isFile() && file.exists();
    }

    public String f() {
        if (this.f6967b) {
            return ar.a().getFilesDir().getPath();
        }
        return this.f6968c;
    }

    public String g() {
        if (this.f6967b) {
            return ar.a().getDir("webcache", 0).getPath();
        }
        if (this.h == null) {
            this.h = this.f6968c + File.separator + "webcache";
            g(this.h);
        }
        return this.h;
    }

    public String f(String str) {
        return g() + File.separator + str;
    }

    public String h() {
        String str = ar.a().getFilesDir().getPath() + File.separator + "signature";
        g(str);
        return str;
    }
}
