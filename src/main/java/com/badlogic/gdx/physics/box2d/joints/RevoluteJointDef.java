package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.utils.Vector2;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class RevoluteJointDef extends JointDef {
    public boolean enableLimit = false;
    public boolean enableMotor = false;
    public final Vector2 localAnchorA = new Vector2();
    public final Vector2 localAnchorB = new Vector2();
    public float lowerAngle = BitmapDescriptorFactory.HUE_RED;
    public float maxMotorTorque = BitmapDescriptorFactory.HUE_RED;
    public float motorSpeed = BitmapDescriptorFactory.HUE_RED;
    public float referenceAngle = BitmapDescriptorFactory.HUE_RED;
    public float upperAngle = BitmapDescriptorFactory.HUE_RED;

    public RevoluteJointDef() {
        this.type = JointDef.JointType.RevoluteJoint;
    }

    public void initialize(Body body, Body body2, Vector2 vector2) {
        this.bodyA = body;
        this.bodyB = body2;
        this.localAnchorA.set(body.getLocalPoint(vector2));
        this.localAnchorB.set(body2.getLocalPoint(vector2));
        this.referenceAngle = body2.getAngle() - body.getAngle();
    }
}
