package io.a.a.a.a.f;

import android.content.Context;
import io.a.a.a.c;
import io.a.a.a.i;
import java.io.File;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f33195a;

    /* renamed from: b  reason: collision with root package name */
    private final String f33196b;

    /* renamed from: c  reason: collision with root package name */
    private final String f33197c;

    public b(i iVar) {
        if (iVar.r() != null) {
            this.f33195a = iVar.r();
            this.f33196b = iVar.t();
            this.f33197c = "Android/" + this.f33195a.getPackageName();
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    public File a() {
        return a(this.f33195a.getFilesDir());
    }

    /* access modifiers changed from: package-private */
    public File a(File file) {
        if (file == null) {
            c.h().a("Fabric", "Null File");
            return null;
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            c.h().d("Fabric", "Couldn't create file");
            return null;
        }
    }
}
