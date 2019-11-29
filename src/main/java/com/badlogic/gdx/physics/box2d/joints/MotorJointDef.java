package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.utils.Vector2;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class MotorJointDef extends JointDef {
    public float angularOffset = BitmapDescriptorFactory.HUE_RED;
    public float correctionFactor = 0.3f;
    public final Vector2 linearOffset = new Vector2();
    public float maxForce = 1.0f;
    public float maxTorque = 1.0f;

    public MotorJointDef() {
        this.type = JointDef.JointType.MotorJoint;
    }

    public void initialize(Body body, Body body2) {
        this.bodyA = body;
        this.bodyB = body2;
        this.linearOffset.set(this.bodyA.getLocalPoint(this.bodyB.getPosition()));
        this.angularOffset = this.bodyB.getAngle() - this.bodyA.getAngle();
    }
}
