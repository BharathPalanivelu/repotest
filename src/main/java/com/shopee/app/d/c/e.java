package com.shopee.app.d.c;

import com.garena.android.appkit.tools.a.a;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.be;
import com.shopee.app.h.f;
import com.shopee.app.util.n;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class e extends a {

    /* renamed from: c  reason: collision with root package name */
    private static final long f16883c = TimeUnit.DAYS.toMillis(7);

    /* renamed from: d  reason: collision with root package name */
    private static final Set<String> f16884d = new HashSet(Arrays.asList(new String[]{".nomedia", "journal", "dfdata"}));

    /* renamed from: e  reason: collision with root package name */
    private static final Set<String> f16885e = new HashSet(Arrays.asList(new String[]{"react", ar.a().getDir("react", 0).getName()}));

    /* renamed from: f  reason: collision with root package name */
    private final be f16886f;

    /* renamed from: g  reason: collision with root package name */
    private File f16887g = new File(f.a().f());
    private long h;
    private boolean i = false;

    /* access modifiers changed from: protected */
    public String b() {
        return "cleaner";
    }

    /* access modifiers changed from: protected */
    public String d() {
        return "CleanTemporaryFilesInteractor";
    }

    public e(n nVar, be beVar) {
        super(nVar);
        this.f16886f = beVar;
    }

    private void a(long j, boolean z) {
        this.h = j;
        this.i = z;
        a();
    }

    public void e() {
        a(0, true);
    }

    public void f() {
        a(f16883c, false);
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (this.i) {
            g();
        } else if (this.f16886f.t()) {
            g();
            this.f16886f.r();
        }
    }

    private boolean a(File file, long j) {
        return file.lastModified() < j && file.delete();
    }

    private boolean a(File file) {
        return !f16884d.contains(file.getName());
    }

    private int g() {
        long b2 = a.b() - this.h;
        Stack stack = new Stack();
        stack.push(this.f16887g);
        int i2 = 0;
        while (!stack.isEmpty()) {
            File file = (File) stack.pop();
            if (file.exists() && file.isDirectory() && !f16885e.contains(file.getName().toLowerCase())) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    int i3 = i2;
                    for (File file2 : listFiles) {
                        if (file2.isFile()) {
                            if (a(file2) && a(file2, b2)) {
                                i3++;
                            }
                        } else if (file2.isDirectory()) {
                            stack.push(file2);
                        }
                    }
                    i2 = i3;
                }
            }
        }
        com.garena.android.appkit.d.a.e("CleanTemporaryFilesInteractor: Deleted " + i2 + " files", new Object[0]);
        return i2;
    }
}
