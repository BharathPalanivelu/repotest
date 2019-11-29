package com.shopee.arcatch.c.g;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.shopee.arcatch.page.view.a;
import com.shopee.arcatch.page.view.b;
import java.util.List;

public class e implements ContactListener {

    /* renamed from: a  reason: collision with root package name */
    private List<f> f26881a;

    /* renamed from: b  reason: collision with root package name */
    private a f26882b;

    /* renamed from: c  reason: collision with root package name */
    private b f26883c;

    public void beginContact(Contact contact) {
    }

    public void endContact(Contact contact) {
    }

    public void preSolve(Contact contact, Manifold manifold) {
    }

    public e(List<f> list, b bVar) {
        this.f26881a = list;
        this.f26883c = bVar;
    }

    public void a(a aVar) {
        this.f26882b = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003a, code lost:
        if (r5.f26881a.contains(r6) == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0057, code lost:
        if (r5.f26881a.contains(r6) == false) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void postSolve(com.badlogic.gdx.physics.box2d.Contact r6, com.badlogic.gdx.physics.box2d.ContactImpulse r7) {
        /*
            r5 = this;
            com.badlogic.gdx.physics.box2d.Fixture r7 = r6.getFixtureA()
            com.badlogic.gdx.physics.box2d.Body r7 = r7.getBody()
            com.badlogic.gdx.physics.box2d.Fixture r6 = r6.getFixtureB()
            com.badlogic.gdx.physics.box2d.Body r6 = r6.getBody()
            java.lang.Object r7 = r7.getUserData()
            com.shopee.arcatch.c.g.f r7 = (com.shopee.arcatch.c.g.f) r7
            java.lang.Object r6 = r6.getUserData()
            com.shopee.arcatch.c.g.f r6 = (com.shopee.arcatch.c.g.f) r6
            r0 = 0
            r1 = 1
            if (r7 == 0) goto L_0x0069
            if (r6 == 0) goto L_0x0069
            boolean r2 = r7.o()
            if (r2 == 0) goto L_0x003d
            boolean r2 = r6.m()
            if (r2 == 0) goto L_0x0069
            boolean r2 = r6.e()
            if (r2 != 0) goto L_0x0069
            java.util.List<com.shopee.arcatch.c.g.f> r2 = r5.f26881a
            boolean r2 = r2.contains(r6)
            if (r2 != 0) goto L_0x0069
            goto L_0x006a
        L_0x003d:
            boolean r2 = r7.e()
            if (r2 != 0) goto L_0x0069
            java.util.List<com.shopee.arcatch.c.g.f> r2 = r5.f26881a
            boolean r2 = r2.contains(r7)
            if (r2 == 0) goto L_0x005a
            boolean r2 = r6.m()
            if (r2 == 0) goto L_0x0069
            java.util.List<com.shopee.arcatch.c.g.f> r2 = r5.f26881a
            boolean r2 = r2.contains(r6)
            if (r2 != 0) goto L_0x0069
            goto L_0x006a
        L_0x005a:
            java.util.List<com.shopee.arcatch.c.g.f> r2 = r5.f26881a
            boolean r2 = r2.contains(r6)
            if (r2 != 0) goto L_0x0068
            boolean r2 = r6.o()
            if (r2 == 0) goto L_0x0069
        L_0x0068:
            r0 = 1
        L_0x0069:
            r1 = 0
        L_0x006a:
            if (r0 == 0) goto L_0x00aa
            com.shopee.arcatch.page.view.b r0 = r5.f26883c
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x00aa
            java.util.List<com.shopee.arcatch.c.g.f> r0 = r5.f26881a
            r0.add(r7)
            com.shopee.arcatch.page.view.b r0 = r5.f26883c
            r0.c(r7)
            boolean r0 = r7.c()
            if (r0 != 0) goto L_0x008c
            com.shopee.arcatch.c.d.b r7 = com.shopee.arcatch.c.d.b.a()
            r7.i()
            goto L_0x00aa
        L_0x008c:
            com.shopee.arcatch.c.d.b r0 = com.shopee.arcatch.c.d.b.a()
            r0.g()
            com.shopee.arcatch.page.view.a r0 = r5.f26882b
            if (r0 == 0) goto L_0x00aa
            float r2 = r7.h()
            float r3 = r7.i()
            float r4 = r7.d()
            java.lang.String r7 = r7.a()
            r0.a(r2, r3, r4, r7)
        L_0x00aa:
            if (r1 == 0) goto L_0x00ea
            com.shopee.arcatch.page.view.b r7 = r5.f26883c
            boolean r7 = r7.d()
            if (r7 == 0) goto L_0x00ea
            java.util.List<com.shopee.arcatch.c.g.f> r7 = r5.f26881a
            r7.add(r6)
            com.shopee.arcatch.page.view.b r7 = r5.f26883c
            r7.c(r6)
            boolean r7 = r6.c()
            if (r7 != 0) goto L_0x00cc
            com.shopee.arcatch.c.d.b r6 = com.shopee.arcatch.c.d.b.a()
            r6.i()
            goto L_0x00ea
        L_0x00cc:
            com.shopee.arcatch.c.d.b r7 = com.shopee.arcatch.c.d.b.a()
            r7.g()
            com.shopee.arcatch.page.view.a r7 = r5.f26882b
            if (r7 == 0) goto L_0x00ea
            float r0 = r6.h()
            float r1 = r6.i()
            float r2 = r6.d()
            java.lang.String r6 = r6.a()
            r7.a(r0, r1, r2, r6)
        L_0x00ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.arcatch.c.g.e.postSolve(com.badlogic.gdx.physics.box2d.Contact, com.badlogic.gdx.physics.box2d.ContactImpulse):void");
    }
}
