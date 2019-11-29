package com.c.a.c.b.b;

import androidx.core.util.Pools;
import com.c.a.c.h;
import com.c.a.i.a.a;
import com.c.a.i.a.b;
import com.c.a.i.e;
import com.c.a.i.i;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private final e<h, String> f5753a = new e<>(1000);

    /* renamed from: b  reason: collision with root package name */
    private final Pools.a<a> f5754b = com.c.a.i.a.a.b(10, new a.C0112a<a>() {
        /* renamed from: a */
        public a b() {
            try {
                return new a(MessageDigest.getInstance(Hash.ALGORITHM_SHA256));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    });

    public String a(h hVar) {
        String b2;
        synchronized (this.f5753a) {
            b2 = this.f5753a.b(hVar);
        }
        if (b2 == null) {
            b2 = b(hVar);
        }
        synchronized (this.f5753a) {
            this.f5753a.b(hVar, b2);
        }
        return b2;
    }

    private String b(h hVar) {
        a acquire = this.f5754b.acquire();
        try {
            hVar.a(acquire.f5756a);
            return i.a(acquire.f5756a.digest());
        } finally {
            this.f5754b.release(acquire);
        }
    }

    private static final class a implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final MessageDigest f5756a;

        /* renamed from: b  reason: collision with root package name */
        private final b f5757b = b.a();

        a(MessageDigest messageDigest) {
            this.f5756a = messageDigest;
        }

        public b f_() {
            return this.f5757b;
        }
    }
}
