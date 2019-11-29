package com.shopee.sdk.d;

import android.app.Activity;
import com.google.a.o;
import java.util.ArrayList;
import java.util.Iterator;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f30347a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<b> f30348b = new ArrayList<>();

    public c(String str) {
        this.f30347a = str;
    }

    public c a(b bVar) {
        this.f30348b.add(bVar);
        return this;
    }

    public boolean a(Activity activity, String str, o oVar) {
        Iterator<b> it = this.f30348b.iterator();
        while (it.hasNext()) {
            b next = it.next();
            a a2 = next.a();
            if (!a2.c()) {
                if (str.equals(a2.a()) && next.a(activity, oVar)) {
                    return true;
                }
            } else if (a2.b().matcher(str).matches() && next.a(activity, oVar)) {
                return true;
            }
        }
        return false;
    }
}
