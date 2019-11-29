package com.garena.reactpush.e.c;

import com.facebook.common.internal.Files;
import com.garena.reactpush.c.e;
import com.garena.reactpush.d.a;
import com.garena.reactpush.data.BundleState;
import com.garena.reactpush.data.Manifest;
import com.garena.reactpush.data.ReactBundle;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static long f8416a = 259200000;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8417b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8418c = false;

    /* renamed from: d  reason: collision with root package name */
    private String f8419d;

    public b(String str, boolean z) {
        this.f8419d = str;
        this.f8417b = z;
    }

    public boolean a() {
        return this.f8418c;
    }

    public boolean a(Manifest manifest, BundleState bundleState) {
        boolean z;
        boolean z2;
        if (manifest.isEmpty()) {
            this.f8418c = false;
            return false;
        }
        boolean a2 = a(bundleState.getLastCheckedTime());
        Iterator<ReactBundle> it = manifest.getBundles().iterator();
        do {
            z = true;
            if (it.hasNext()) {
                ReactBundle next = it.next();
                File file = new File(this.f8419d.concat(next.getName()).concat(".bundle"));
                if (!a(file)) {
                    this.f8418c = false;
                    return false;
                }
                if (a(file, bundleState.getBundleModifiedTime(next.getName())) || a2) {
                    try {
                        z2 = next.getMd5().equals(e.a(Files.toByteArray(file)));
                    } catch (IOException unused) {
                        z2 = false;
                    }
                    if (z2) {
                        bundleState.setBundleModifiedTime(next.getName(), file.lastModified());
                        bundleState.setLastCheckedTime(System.currentTimeMillis());
                    } else {
                        this.f8418c = false;
                        return false;
                    }
                }
                if (this.f8417b && next.getPriority() < 0) {
                    z = false;
                    continue;
                }
            } else {
                this.f8418c = true;
                return true;
            }
        } while (z);
        return false;
    }

    public String toString() {
        return "ReactBundleVerifier {\n\tverified=" + this.f8418c + "\n" + '}';
    }

    private boolean a(File file) {
        return file != null && file.exists() && file.isFile();
    }

    private boolean a(File file, long j) {
        return (file == null || file.lastModified() == j) ? false : true;
    }

    private boolean a(long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        return currentTimeMillis > 0 && currentTimeMillis > f8416a;
    }
}
