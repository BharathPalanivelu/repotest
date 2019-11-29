package com.airbnb.lottie.c.b;

import com.airbnb.lottie.a.a.b;
import com.airbnb.lottie.a.a.k;
import com.airbnb.lottie.c;
import com.airbnb.lottie.f;

public class h implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f3557a;

    /* renamed from: b  reason: collision with root package name */
    private final a f3558b;

    public enum a {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        public static a forId(int i) {
            if (i == 1) {
                return Merge;
            }
            if (i == 2) {
                return Add;
            }
            if (i == 3) {
                return Subtract;
            }
            if (i == 4) {
                return Intersect;
            }
            if (i != 5) {
                return Merge;
            }
            return ExcludeIntersections;
        }
    }

    public h(String str, a aVar) {
        this.f3557a = str;
        this.f3558b = aVar;
    }

    public String a() {
        return this.f3557a;
    }

    public a b() {
        return this.f3558b;
    }

    public b a(f fVar, com.airbnb.lottie.c.c.a aVar) {
        if (fVar.a()) {
            return new k(this);
        }
        c.b("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f3558b + '}';
    }
}
