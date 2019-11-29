package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.utils.Vector2;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class PulleyJointDef extends JointDef {
    private static final float minPulleyLength = 2.0f;
    public final Vector2 groundAnchorA = new Vector2(-1.0f, 1.0f);
    public final Vector2 groundAnchorB = new Vector2(1.0f, 1.0f);
    public float lengthA = BitmapDescriptorFactory.HUE_RED;
    public float lengthB = BitmapDescriptorFactory.HUE_RED;
    public final Vector2 localAnchorA = new Vector2(-1.0f, BitmapDescriptorFactory.HUE_RED);
    public final Vector2 localAnchorB = new Vector2(1.0f, BitmapDescriptorFactory.HUE_RED);
    public float ratio = 1.0f;

    public PulleyJointDef() {
        this.type = JointDef.JointType.PulleyJoint;
        this.collideConnected = true;
    }

    public void initialize(Body body, Body body2, Vector2 vector2, Vector2 vector22, Vector2 vector23, Vector2 vector24, float f2) {
        this.bodyA = body;
        this.bodyB = body2;
        this.groundAnchorA.set(vector2);
        this.groundAnchorB.set(vector22);
        this.localAnchorA.set(body.getLocalPoint(vector23));
        this.localAnchorB.set(body2.getLocalPoint(vector24));
        this.lengthA = vector23.dst(vector2);
        this.lengthB = vector24.dst(vector22);
        this.ratio = f2;
        float f3 = this.lengthA;
        float f4 = this.lengthB;
    }
}
