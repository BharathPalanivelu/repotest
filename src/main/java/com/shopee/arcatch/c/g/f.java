package com.shopee.arcatch.c.g;

import android.graphics.Bitmap;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.utils.Vector2;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private float f26884a;

    /* renamed from: b  reason: collision with root package name */
    private float f26885b;

    /* renamed from: c  reason: collision with root package name */
    private float f26886c;

    /* renamed from: d  reason: collision with root package name */
    private int f26887d;

    /* renamed from: e  reason: collision with root package name */
    private float f26888e;

    /* renamed from: f  reason: collision with root package name */
    private int f26889f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f26890g;
    private Body h;
    private boolean i;
    private int j;
    private String k;

    public f(Bitmap bitmap, float f2, float f3) {
        this.f26890g = bitmap;
        if (bitmap != null) {
            this.f26887d = bitmap.getWidth();
            this.f26889f = bitmap.getHeight();
        }
        this.f26884a = f2;
        this.f26885b = f3;
    }

    public f() {
    }

    public String a() {
        return this.k;
    }

    public void a(String str) {
        this.k = str;
    }

    public int b() {
        return this.j;
    }

    public void a(int i2) {
        this.j = i2;
    }

    public boolean c() {
        return this.j == 4;
    }

    public void a(boolean z) {
        this.j = z ? 4 : 0;
    }

    public float d() {
        return this.f26888e;
    }

    public void a(float f2) {
        this.f26888e = f2;
    }

    public boolean e() {
        return this.i;
    }

    public void b(boolean z) {
        this.i = z;
    }

    public float f() {
        return this.f26886c;
    }

    public Body g() {
        return this.h;
    }

    public void a(Body body) {
        this.h = body;
    }

    public float h() {
        return this.f26884a;
    }

    public void b(float f2) {
        this.f26884a = f2;
    }

    public float i() {
        return this.f26885b;
    }

    public void c(float f2) {
        this.f26885b = f2;
    }

    public int j() {
        return this.f26887d;
    }

    public int k() {
        return this.f26889f;
    }

    public Bitmap l() {
        return this.f26890g;
    }

    public void a(Bitmap bitmap) {
        this.f26890g = bitmap;
        if (bitmap != null) {
            this.f26887d = bitmap.getWidth();
            this.f26889f = bitmap.getHeight();
        }
    }

    public boolean m() {
        int i2 = this.j;
        return i2 == 0 || i2 == 4;
    }

    public boolean n() {
        return this.j == 0;
    }

    public boolean o() {
        int i2 = this.j;
        return i2 == 8 || i2 == 12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        if (r1 != false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.shopee.arcatch.c.g.b r5, com.shopee.arcatch.page.view.b r6) {
        /*
            r4 = this;
            com.badlogic.gdx.physics.box2d.Body r0 = r4.h
            if (r0 == 0) goto L_0x006a
            boolean r0 = r0.isAwake()
            if (r0 == 0) goto L_0x006a
            boolean r0 = r4.i
            if (r0 != 0) goto L_0x006a
            com.badlogic.gdx.physics.box2d.Body r0 = r4.h
            float r0 = r0.getAngle()
            float r0 = r5.c(r0)
            r4.f26886c = r0
            com.badlogic.gdx.physics.box2d.Body r0 = r4.h
            com.badlogic.gdx.physics.box2d.utils.Vector2 r0 = r0.getPosition()
            r1 = 0
            boolean r2 = r4.m()
            if (r2 == 0) goto L_0x004e
            float r2 = r0.y
            float r3 = r5.a()
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x0037
            boolean r2 = r6.d(r4)
            if (r2 == 0) goto L_0x003d
        L_0x0037:
            boolean r1 = r6.b((com.shopee.arcatch.c.g.f) r4)
            if (r1 == 0) goto L_0x004e
        L_0x003d:
            if (r1 != 0) goto L_0x0042
            r6.a((com.shopee.arcatch.c.g.f) r4)
        L_0x0042:
            r6 = 1
            r4.i = r6
            com.badlogic.gdx.physics.box2d.Body r6 = r4.h
            r5.a((com.badlogic.gdx.physics.box2d.Body) r6)
            r5 = 0
            r4.h = r5
            goto L_0x006a
        L_0x004e:
            float r6 = r0.x
            float r6 = r5.b(r6)
            int r1 = r4.f26887d
            float r1 = (float) r1
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            float r6 = r6 - r1
            r4.f26884a = r6
            float r6 = r0.y
            float r5 = r5.b(r6)
            int r6 = r4.f26889f
            float r6 = (float) r6
            float r6 = r6 / r2
            float r5 = r5 - r6
            r4.f26885b = r5
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.arcatch.c.g.f.a(com.shopee.arcatch.c.g.b, com.shopee.arcatch.page.view.b):void");
    }

    public void a(Vector2 vector2, float f2) {
        Body body = this.h;
        if (body != null) {
            this.h.setLinearVelocity(vector2.sub(body.getPosition()).scl(f2));
        }
    }

    public void p() {
        Body body = this.h;
        if (body != null) {
            body.setLinearVelocity(Vector2.Zero);
        }
    }
}
