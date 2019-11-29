package com.badlogic.gdx.physics.box2d;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class FixtureDef {
    public float density = BitmapDescriptorFactory.HUE_RED;
    public final Filter filter = new Filter();
    public float friction = 0.2f;
    public boolean isSensor = false;
    public float restitution = BitmapDescriptorFactory.HUE_RED;
    public Shape shape;
}
