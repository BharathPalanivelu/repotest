package com.airbnb.lottie.a.a;

import android.graphics.Path;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.c.b.o;
import com.airbnb.lottie.c.b.q;
import com.airbnb.lottie.f;
import java.util.List;

public class p implements l, a.C0069a {

    /* renamed from: a  reason: collision with root package name */
    private final Path f3447a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f3448b;

    /* renamed from: c  reason: collision with root package name */
    private final f f3449c;

    /* renamed from: d  reason: collision with root package name */
    private final a<?, Path> f3450d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3451e;

    /* renamed from: f  reason: collision with root package name */
    private r f3452f;

    public p(f fVar, com.airbnb.lottie.c.c.a aVar, o oVar) {
        this.f3448b = oVar.a();
        this.f3449c = fVar;
        this.f3450d = oVar.b().a();
        aVar.a((a<?, ?>) this.f3450d);
        this.f3450d.a((a.C0069a) this);
    }

    public void a() {
        c();
    }

    private void c() {
        this.f3451e = false;
        this.f3449c.invalidateSelf();
    }

    public void a(List<b> list, List<b> list2) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.c() == q.a.Simultaneously) {
                    this.f3452f = rVar;
                    this.f3452f.a(this);
                }
            }
        }
    }

    public Path e() {
        if (this.f3451e) {
            return this.f3447a;
        }
        this.f3447a.reset();
        this.f3447a.set(this.f3450d.e());
        this.f3447a.setFillType(Path.FillType.EVEN_ODD);
        com.airbnb.lottie.f.f.a(this.f3447a, this.f3452f);
        this.f3451e = true;
        return this.f3447a;
    }

    public String b() {
        return this.f3448b;
    }
}
