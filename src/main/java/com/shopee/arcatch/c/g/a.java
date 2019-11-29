package com.shopee.arcatch.c.g;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.utils.Vector2;
import com.google.a.f;
import java.util.ArrayList;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f26856a;

    /* renamed from: b  reason: collision with root package name */
    private final Vector2 f26857b = new Vector2();

    /* renamed from: c  reason: collision with root package name */
    private final List<Vector2> f26858c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final PolygonShape f26859d = new PolygonShape();

    /* renamed from: e  reason: collision with root package name */
    private final CircleShape f26860e = new CircleShape();

    /* renamed from: com.shopee.arcatch.c.g.a$a  reason: collision with other inner class name */
    public static class C0418a {
        @com.google.a.a.c(a = "cx")

        /* renamed from: a  reason: collision with root package name */
        public float f26861a;
        @com.google.a.a.c(a = "cy")

        /* renamed from: b  reason: collision with root package name */
        public float f26862b;
        @com.google.a.a.c(a = "r")

        /* renamed from: c  reason: collision with root package name */
        public float f26863c;
    }

    public static class c {
        @com.google.a.a.c(a = "x")

        /* renamed from: a  reason: collision with root package name */
        public float f26865a;
        @com.google.a.a.c(a = "y")

        /* renamed from: b  reason: collision with root package name */
        public float f26866b;
    }

    public static class d {
        @com.google.a.a.c(a = "name")

        /* renamed from: a  reason: collision with root package name */
        public String f26867a;
        @com.google.a.a.c(a = "origin")

        /* renamed from: b  reason: collision with root package name */
        public c f26868b;
        @com.google.a.a.c(a = "polygons")

        /* renamed from: c  reason: collision with root package name */
        public List<List<c>> f26869c;
        @com.google.a.a.c(a = "circles")

        /* renamed from: d  reason: collision with root package name */
        public List<C0418a> f26870d;
    }

    public a(String str) {
        if (str != null) {
            this.f26856a = a(str);
            return;
        }
        throw new NullPointerException("str is null");
    }

    private b a(String str) {
        return (b) new f().a(str, b.class);
    }

    public void a(Body body, String str, FixtureDef fixtureDef, float f2) {
        b bVar = this.f26856a;
        if (bVar != null) {
            d a2 = bVar.a(str);
            if (a2 != null) {
                Vector2 scl = this.f26857b.set(a2.f26868b.f26865a, a2.f26868b.f26866b).scl(f2);
                if (a2.f26869c != null) {
                    int size = a2.f26869c.size();
                    for (int i = 0; i < size; i++) {
                        List list = a2.f26869c.get(i);
                        Vector2[] vector2Arr = new Vector2[list.size()];
                        int size2 = list.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            vector2Arr[i2] = a().set(((c) list.get(i2)).f26865a, ((c) list.get(i2)).f26866b).scl(f2);
                            vector2Arr[i2].arcatchSub(scl);
                        }
                        this.f26859d.set(vector2Arr);
                        fixtureDef.shape = this.f26859d;
                        body.createFixture(fixtureDef);
                        for (Vector2 a3 : vector2Arr) {
                            a(a3);
                        }
                    }
                }
                if (a2.f26870d != null) {
                    int size3 = a2.f26870d.size();
                    for (int i3 = 0; i3 < size3; i3++) {
                        C0418a aVar = a2.f26870d.get(i3);
                        Vector2 scl2 = a().set(aVar.f26861a, aVar.f26862b).scl(f2);
                        this.f26860e.setPosition(scl2);
                        this.f26860e.setRadius(aVar.f26863c * f2);
                        fixtureDef.shape = this.f26860e;
                        body.createFixture(fixtureDef);
                        a(scl2);
                    }
                    return;
                }
                return;
            }
            throw new RuntimeException("Name '" + str + "' was not found.");
        }
        throw new RuntimeException("Name '" + str + "' was not found.");
    }

    public static class b {
        @com.google.a.a.c(a = "rigidBodies")

        /* renamed from: a  reason: collision with root package name */
        public List<d> f26864a;

        public d a(String str) {
            if (this.f26864a == null) {
                return null;
            }
            for (int i = 0; i < this.f26864a.size(); i++) {
                if (this.f26864a.get(i).f26867a.equals(str)) {
                    return this.f26864a.get(i);
                }
            }
            return null;
        }
    }

    private Vector2 a() {
        return this.f26858c.isEmpty() ? new Vector2() : this.f26858c.remove(0);
    }

    private void a(Vector2 vector2) {
        this.f26858c.add(vector2);
    }
}
