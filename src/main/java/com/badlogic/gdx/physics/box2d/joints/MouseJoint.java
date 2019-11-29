package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.utils.Vector2;

public class MouseJoint extends Joint {
    private final Vector2 target = new Vector2();
    final float[] tmp = new float[2];

    private native float jniGetDampingRatio(long j);

    private native float jniGetFrequency(long j);

    private native float jniGetMaxForce(long j);

    private native void jniGetTarget(long j, float[] fArr);

    private native void jniSetDampingRatio(long j, float f2);

    private native void jniSetFrequency(long j, float f2);

    private native void jniSetMaxForce(long j, float f2);

    private native void jniSetTarget(long j, float f2, float f3);

    public MouseJoint(World world, long j) {
        super(world, j);
    }

    public void setTarget(Vector2 vector2) {
        jniSetTarget(this.addr, vector2.x, vector2.y);
    }

    public Vector2 getTarget() {
        jniGetTarget(this.addr, this.tmp);
        Vector2 vector2 = this.target;
        float[] fArr = this.tmp;
        vector2.x = fArr[0];
        vector2.y = fArr[1];
        return vector2;
    }

    public void setMaxForce(float f2) {
        jniSetMaxForce(this.addr, f2);
    }

    public float getMaxForce() {
        return jniGetMaxForce(this.addr);
    }

    public void setFrequency(float f2) {
        jniSetFrequency(this.addr, f2);
    }

    public float getFrequency() {
        return jniGetFrequency(this.addr);
    }

    public void setDampingRatio(float f2) {
        jniSetDampingRatio(this.addr, f2);
    }

    public float getDampingRatio() {
        return jniGetDampingRatio(this.addr);
    }
}
