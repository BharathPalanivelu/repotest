package com.shopee.arcatch.c.g;

import android.content.Context;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.utils.Vector2;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.arcatch.page.view.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static final String f26871b = "b";

    /* renamed from: a  reason: collision with root package name */
    public World f26872a;

    /* renamed from: c  reason: collision with root package name */
    private e f26873c;

    /* renamed from: d  reason: collision with root package name */
    private d f26874d;

    /* renamed from: e  reason: collision with root package name */
    private float f26875e = 0.0125f;

    /* renamed from: f  reason: collision with root package name */
    private final int f26876f = 5;

    /* renamed from: g  reason: collision with root package name */
    private final int f26877g = 20;
    private int h;
    private int i;
    private float j = 1.0f;
    private float k = 100.0f;
    private final float l = BitmapDescriptorFactory.HUE_RED;
    private final float m = 25.0f;
    private final float n = 5.0f;
    private final float o = 0.1f;
    private final float p = 20.0f;
    private final float q = BitmapDescriptorFactory.HUE_RED;
    private final String r = "arcatch-hat.json";
    private final String s = "hat";
    private final String t = "hatcover";

    public float c(float f2) {
        return (f2 / 3.14f) * 180.0f;
    }

    public b(float f2) {
        this.j = f2;
    }

    public void a(int i2, int i3) {
        this.h = i2;
        this.i = i3;
    }

    public float a() {
        return this.f26872a != null ? a((float) this.i) : BitmapDescriptorFactory.HUE_RED;
    }

    public void a(List<f> list, com.shopee.arcatch.page.view.b bVar) {
        if (this.f26872a == null) {
            this.f26872a = new World(new Vector2(BitmapDescriptorFactory.HUE_RED, 25.0f), true);
            this.f26873c = new e(list, bVar);
            this.f26874d = new d(list, bVar);
            this.f26872a.setContactListener(this.f26873c);
            this.f26872a.setContactFilter(this.f26874d);
            this.f26872a.setContinuousPhysics(true);
        }
    }

    public void a(a aVar) {
        e eVar = this.f26873c;
        if (eVar != null) {
            eVar.a(aVar);
        }
    }

    private a a(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return new a(sb.toString());
                }
                sb.append(readLine);
            }
        } catch (IOException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public void a(f fVar, f fVar2, Context context) {
        a a2 = a(context, "arcatch-hat.json");
        if (a2 != null) {
            BodyDef bodyDef = new BodyDef();
            bodyDef.type = BodyDef.BodyType.KinematicBody;
            bodyDef.position.set(a(fVar.h() + (((float) fVar.j()) / 2.0f)), a(fVar.i() + (((float) fVar.k()) / 2.0f)));
            Body createBody = this.f26872a.createBody(bodyDef);
            FixtureDef fixtureDef = new FixtureDef();
            fixtureDef.density = this.j;
            fixtureDef.friction = 5.0f;
            fixtureDef.restitution = 0.1f;
            a2.a(createBody, "hat", fixtureDef, ((float) fVar.j()) / this.k);
            fVar.a(createBody);
            createBody.setUserData(fVar);
            BodyDef bodyDef2 = new BodyDef();
            bodyDef2.type = BodyDef.BodyType.KinematicBody;
            bodyDef2.position.set(a(fVar2.h() + (((float) fVar2.j()) / 2.0f)), a(fVar2.i() + (((float) fVar2.k()) / 2.0f)));
            Body createBody2 = this.f26872a.createBody(bodyDef2);
            FixtureDef fixtureDef2 = new FixtureDef();
            fixtureDef2.density = this.j;
            fixtureDef2.friction = 5.0f;
            fixtureDef2.restitution = 0.1f;
            a2.a(createBody2, "hatcover", fixtureDef2, ((float) fVar2.j()) / this.k);
            fVar2.a(createBody2);
            createBody2.setUserData(fVar2);
        }
    }

    public float a(float f2) {
        return f2 / this.k;
    }

    public float b(float f2) {
        return f2 * this.k;
    }

    public void a(f fVar) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.allowSleep = true;
        bodyDef.position.set(a(fVar.h() + (((float) fVar.j()) / 2.0f)), a(fVar.i() + (((float) fVar.k()) / 2.0f)));
        Shape d2 = d(a(((float) fVar.j()) / 5.0f));
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = d2;
        fixtureDef.density = this.j * 5.0f;
        fixtureDef.friction = 20.0f;
        fixtureDef.restitution = BitmapDescriptorFactory.HUE_RED;
        Body createBody = this.f26872a.createBody(bodyDef);
        createBody.createFixture(fixtureDef);
        fVar.a(createBody);
        createBody.setUserData(fVar);
    }

    private Shape d(float f2) {
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(f2);
        return circleShape;
    }

    public void b() {
        World world = this.f26872a;
        if (world != null) {
            world.step(this.f26875e, 5, 20);
        }
    }

    public void a(Body body) {
        if (body != null) {
            this.f26872a.destroyBody(body);
        }
    }

    public void c() {
        World world = this.f26872a;
        if (world != null) {
            world.dispose();
        }
    }
}
