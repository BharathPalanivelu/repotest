package com.google.android.libraries.places.internal;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.util.Log;
import com.android.b.m;
import com.c.a.c.c.g;
import com.c.a.c.c.h;
import com.c.a.c.c.j;
import com.c.a.g.b;
import com.c.a.j;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class dq implements ny {

    /* renamed from: a  reason: collision with root package name */
    public final j f12470a;

    public static String a(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length == 0)) {
                if (packageInfo.signatures[0] != null) {
                    return a(packageInfo.signatures[0]);
                }
            }
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(str);
            Log.e("CredentialsHelper", valueOf.length() != 0 ? "Unable to get certificate fingerprint for package: ".concat(valueOf) : new String("Unable to get certificate fingerprint for package: "), e2);
            return null;
        }
    }

    private static String a(Signature signature) {
        try {
            byte[] digest = MessageDigest.getInstance(Hash.ALGORITHM_SHA1).digest(signature.toByteArray());
            return hw.f6736a.a(digest, 0, digest.length);
        } catch (NoSuchAlgorithmException e2) {
            Log.e("CredentialsHelper", "Unable to get certificate fingerprint.", e2);
            return null;
        }
    }

    public static gg a(m mVar, dr drVar) {
        return new gg(mVar, drVar);
    }

    public /* synthetic */ Object b() {
        throw new NoSuchMethodError();
    }

    public dq(j jVar) {
        this.f12470a = jVar;
    }

    public <HttpPhotoResponseT extends s<Object, ? extends az>> Task<HttpPhotoResponseT> a(r<Object, ?> rVar, dv dvVar) {
        return a(rVar.c(), rVar.b(), dvVar, rVar.a());
    }

    public <HttpPhotoResponseT extends s<Object, ? extends az>> Task<HttpPhotoResponseT> a(String str, Map<String, String> map, dv dvVar, CancellationToken cancellationToken) {
        TaskCompletionSource taskCompletionSource;
        if (cancellationToken != null) {
            taskCompletionSource = new TaskCompletionSource(cancellationToken);
        } else {
            taskCompletionSource = new TaskCompletionSource();
        }
        j.a aVar = new j.a();
        for (Map.Entry next : map.entrySet()) {
            aVar.a((String) next.getKey(), (String) next.getValue());
        }
        b<Bitmap> c2 = this.f12470a.f().a((Object) new g(str, (h) aVar.a())).a(new q(taskCompletionSource, dvVar)).c();
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new p(c2));
        }
        return taskCompletionSource.getTask();
    }
}
