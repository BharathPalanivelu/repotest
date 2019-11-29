package com.badlogic.gdx.physics.box2d;

import com.badlogic.gdx.physics.box2d.utils.Vector2;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class BodyDef {
    public boolean active = true;
    public boolean allowSleep = true;
    public float angle = BitmapDescriptorFactory.HUE_RED;
    public float angularDamping = BitmapDescriptorFactory.HUE_RED;
    public float angularVelocity = BitmapDescriptorFactory.HUE_RED;
    public boolean awake = true;
    public boolean bullet = false;
    public boolean fixedRotation = false;
    public float gravityScale = 1.0f;
    public float linearDamping = BitmapDescriptorFactory.HUE_RED;
    public final Vector2 linearVelocity = new Vector2();
    public final Vector2 position = new Vector2();
    public BodyType type = BodyType.StaticBody;

    public enum BodyType {
        StaticBody(0),
        KinematicBody(1),
        DynamicBody(2);
        
        private int value;

        private BodyType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
