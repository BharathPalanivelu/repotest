package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.utils.Vector2;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class WheelJointDef extends JointDef {
    public float dampingRatio = 0.7f;
    public boolean enableMotor = false;
    public float frequencyHz = 2.0f;
    public final Vector2 localAnchorA = new Vector2();
    public final Vector2 localAnchorB = new Vector2();
    public final Vector2 localAxisA = new Vector2(1.0f, BitmapDescriptorFactory.HUE_RED);
    public float maxMotorTorque = BitmapDescriptorFactory.HUE_RED;
    public float motorSpeed = BitmapDescriptorFactory.HUE_RED;

    public WheelJointDef() {
        this.type = JointDef.JointType.WheelJoint;
    }

    public void initialize(Body body, Body body2, Vector2 vector2, Vector2 vector22) {
        this.bodyA = body;
        this.bodyB = body2;
        this.localAnchorA.set(body.getLocalPoint(vector2));
        this.localAnchorB.set(body2.getLocalPoint(vector2));
        this.localAxisA.set(body.getLocalVector(vector22));
    }
}
