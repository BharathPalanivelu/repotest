package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.utils.Vector2;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class MouseJointDef extends JointDef {
    public float dampingRatio = 0.7f;
    public float frequencyHz = 5.0f;
    public float maxForce = BitmapDescriptorFactory.HUE_RED;
    public final Vector2 target = new Vector2();

    public MouseJointDef() {
        this.type = JointDef.JointType.MouseJoint;
    }
}
