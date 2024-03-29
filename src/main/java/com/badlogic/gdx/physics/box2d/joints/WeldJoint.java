package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.utils.Vector2;

public class WeldJoint extends Joint {
    private final Vector2 localAnchorA = new Vector2();
    private final Vector2 localAnchorB = new Vector2();
    private final float[] tmp = new float[2];

    private native float jniGetDampingRatio(long j);

    private native float jniGetFrequency(long j);

    private native void jniGetLocalAnchorA(long j, float[] fArr);

    private native void jniGetLocalAnchorB(long j, float[] fArr);

    private native float jniGetReferenceAngle(long j);

    private native void jniSetDampingRatio(long j, float f2);

    private native void jniSetFrequency(long j, float f2);

    public WeldJoint(World world, long j) {
        super(world, j);
    }

    public Vector2 getLocalAnchorA() {
        jniGetLocalAnchorA(this.addr, this.tmp);
        Vector2 vector2 = this.localAnchorA;
        float[] fArr = this.tmp;
        vector2.set(fArr[0], fArr[1]);
        return this.localAnchorA;
    }

    public Vector2 getLocalAnchorB() {
        jniGetLocalAnchorB(this.addr, this.tmp);
        Vector2 vector2 = this.localAnchorB;
        float[] fArr = this.tmp;
        vector2.set(fArr[0], fArr[1]);
        return this.localAnchorB;
    }

    public float getReferenceAngle() {
        return jniGetReferenceAngle(this.addr);
    }

    public float getFrequency() {
        return jniGetFrequency(this.addr);
    }

    public void setFrequency(float f2) {
        jniSetFrequency(this.addr, f2);
    }

    public float getDampingRatio() {
        return jniGetDampingRatio(this.addr);
    }

    public void setDampingRatio(float f2) {
        jniSetDampingRatio(this.addr, f2);
    }
}
