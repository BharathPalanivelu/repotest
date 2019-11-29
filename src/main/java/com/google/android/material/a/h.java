package com.google.android.material.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import androidx.b.g;
import java.util.ArrayList;
import java.util.List;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final g<String, i> f13111a = new g<>();

    public boolean a(String str) {
        return this.f13111a.get(str) != null;
    }

    public i b(String str) {
        if (a(str)) {
            return this.f13111a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public void a(String str, i iVar) {
        this.f13111a.put(str, iVar);
    }

    public long a() {
        int size = this.f13111a.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            i c2 = this.f13111a.c(i);
            j = Math.max(j, c2.a() + c2.b());
        }
        return j;
    }

    public static h a(Context context, TypedArray typedArray, int i) {
        if (!typedArray.hasValue(i)) {
            return null;
        }
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId != 0) {
            return a(context, resourceId);
        }
        return null;
    }

    public static h a(Context context, int i) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (loadAnimator instanceof AnimatorSet) {
                return a((List<Animator>) ((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return a((List<Animator>) arrayList);
        } catch (Exception e2) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i), e2);
            return null;
        }
    }

    private static h a(List<Animator> list) {
        h hVar = new h();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(hVar, list.get(i));
        }
        return hVar;
    }

    private static void a(h hVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            hVar.a(objectAnimator.getPropertyName(), i.a((ValueAnimator) objectAnimator));
            return;
        }
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f13111a.equals(((h) obj).f13111a);
    }

    public int hashCode() {
        return this.f13111a.hashCode();
    }

    public String toString() {
        return 10 + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f13111a + "}\n";
    }
}
