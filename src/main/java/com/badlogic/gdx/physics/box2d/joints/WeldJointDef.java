package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.utils.Vector2;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class WeldJointDef extends JointDef {
    public float dampingRatio = BitmapDescriptorFactory.HUE_RED;
    public float frequencyHz = BitmapDescriptorFactory.HUE_RED;
    public final Vector2 localAnchorA = new Vector2();
    public final Vector2 localAnchorB = new Vector2();
    public float referenceAngle = BitmapDescriptorFactory.HUE_RED;

    public WeldJointDef() {
        this.type = JointDef.JointType.WeldJoint;
    }

    public void initialize(Body body, Body body2, Vector2 vector2) {
        this.bodyA = body;
        this.bodyB = body2;
        this.localAnchorA.set(body.getLocalPoint(vector2));
        this.localAnchorB.set(body2.getLocalPoint(vector2));
        this.referenceAngle = body2.getAngle() - body.getAngle();
    }
}
