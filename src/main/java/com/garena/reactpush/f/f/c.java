package com.garena.reactpush.f.f;

import com.garena.reactpush.b.b;
import com.garena.reactpush.data.BundleDiff;
import com.garena.reactpush.data.Manifest;
import com.garena.reactpush.data.ReactBundle;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f8533a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8534b;

    /* renamed from: c  reason: collision with root package name */
    private Manifest f8535c;

    /* renamed from: d  reason: collision with root package name */
    private b f8536d;

    public c(Manifest manifest, String str, String str2, b bVar) {
        this.f8535c = manifest;
        this.f8533a = str;
        this.f8534b = str2;
        this.f8536d = bVar;
    }

    public boolean a(List<BundleDiff> list) {
        if (list == null) {
            return true;
        }
        try {
            if (list.isEmpty()) {
                return true;
            }
            File file = new File(this.f8534b.concat(com.garena.reactpush.c.c.f8355d));
            file.mkdirs();
            file.delete();
            for (BundleDiff a2 : list) {
                if (!a(a2)) {
                    return false;
                }
            }
            file.createNewFile();
            this.f8536d.a(this.f8535c);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private boolean a(BundleDiff bundleDiff) {
        String str;
        ReactBundle reactBundle = (ReactBundle) bundleDiff.getBundle().f1882a;
        ReactBundle reactBundle2 = (ReactBundle) bundleDiff.getBundle().f1883b;
        if (reactBundle2 != null) {
            str = reactBundle2.getName().concat(".bundle");
        } else {
            str = reactBundle.getName().concat(".bundle");
        }
        File file = new File(this.f8534b.concat(str));
        File file2 = new File(this.f8533a.concat(str));
        file.delete();
        if (!(bundleDiff.isBundleDeleted() || (file2.exists() && file2.renameTo(file)))) {
            return false;
        }
        if (bundleDiff.isBundleNew()) {
            this.f8535c.getBundles().add(reactBundle2);
        } else if (bundleDiff.isBundleDeleted()) {
            this.f8535c.getBundles().remove(reactBundle);
        } else {
            reactBundle.update(reactBundle2);
        }
        return true;
    }
}
