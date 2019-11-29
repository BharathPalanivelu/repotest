package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.utils.Vector2;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class RopeJointDef extends JointDef {
    public final Vector2 localAnchorA = new Vector2(-1.0f, BitmapDescriptorFactory.HUE_RED);
    public final Vector2 localAnchorB = new Vector2(1.0f, BitmapDescriptorFactory.HUE_RED);
    public float maxLength = BitmapDescriptorFactory.HUE_RED;

    public RopeJointDef() {
        this.type = JointDef.JointType.RopeJoint;
    }
}
