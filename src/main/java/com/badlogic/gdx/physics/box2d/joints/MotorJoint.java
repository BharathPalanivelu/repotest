package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.utils.Vector2;

public class MotorJoint extends Joint {
    private final Vector2 linearOffset = new Vector2();
    private final float[] tmp = new float[2];

    private native float jniGetAngularOffset(long j);

    private native float jniGetCorrectionFactor(long j);

    private native void jniGetLinearOffset(long j, float[] fArr);

    private native float jniGetMaxForce(long j);

    private native float jniGetMaxTorque(long j);

    private native void jniSetAngularOffset(long j, float f2);

    private native void jniSetCorrectionFactor(long j, float f2);

    private native void jniSetLinearOffset(long j, float f2, float f3);

    private native void jniSetMaxForce(long j, float f2);

    private native void jniSetMaxTorque(long j, float f2);

    public MotorJoint(World world, long j) {
        super(world, j);
    }

    public Vector2 getLinearOffset() {
        jniGetLinearOffset(this.addr, this.tmp);
        Vector2 vector2 = this.linearOffset;
        float[] fArr = this.tmp;
        vector2.set(fArr[0], fArr[1]);
        return this.linearOffset;
    }

    public void setLinearOffset(Vector2 vector2) {
        jniSetLinearOffset(this.addr, vector2.x, vector2.y);
    }

    public float getAngularOffset() {
        return jniGetAngularOffset(this.addr);
    }

    public void setAngularOffset(float f2) {
        jniSetAngularOffset(this.addr, f2);
    }

    public float getMaxForce() {
        return jniGetMaxForce(this.addr);
    }

    public void setMaxForce(float f2) {
        jniSetMaxForce(this.addr, f2);
    }

    public float getMaxTorque() {
        return jniGetMaxTorque(this.addr);
    }

    public void setMaxTorque(float f2) {
        jniSetMaxTorque(this.addr, f2);
    }

    public float getCorrectionFactor() {
        return jniGetCorrectionFactor(this.addr);
    }

    public void setCorrectionFactor(float f2) {
        jniSetCorrectionFactor(this.addr, f2);
    }
}
