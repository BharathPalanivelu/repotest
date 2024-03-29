package com.badlogic.gdx.physics.box2d;

import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.utils.Vector2;

public abstract class Joint {
    protected long addr;
    private final Vector2 anchorA = new Vector2();
    private final Vector2 anchorB = new Vector2();
    protected JointEdge jointEdgeA;
    protected JointEdge jointEdgeB;
    private final Vector2 reactionForce = new Vector2();
    private final float[] tmp = new float[2];
    private Object userData;
    private final World world;

    private native void jniGetAnchorA(long j, float[] fArr);

    private native void jniGetAnchorB(long j, float[] fArr);

    private native long jniGetBodyA(long j);

    private native long jniGetBodyB(long j);

    private native boolean jniGetCollideConnected(long j);

    private native void jniGetReactionForce(long j, float f2, float[] fArr);

    private native float jniGetReactionTorque(long j, float f2);

    private native int jniGetType(long j);

    private native boolean jniIsActive(long j);

    protected Joint(World world2, long j) {
        this.world = world2;
        this.addr = j;
    }

    public JointDef.JointType getType() {
        int jniGetType = jniGetType(this.addr);
        if (jniGetType <= 0 || jniGetType >= JointDef.JointType.valueTypes.length) {
            return JointDef.JointType.Unknown;
        }
        return JointDef.JointType.valueTypes[jniGetType];
    }

    public Body getBodyA() {
        return this.world.bodies.get(jniGetBodyA(this.addr));
    }

    public Body getBodyB() {
        return this.world.bodies.get(jniGetBodyB(this.addr));
    }

    public Vector2 getAnchorA() {
        jniGetAnchorA(this.addr, this.tmp);
        Vector2 vector2 = this.anchorA;
        float[] fArr = this.tmp;
        vector2.x = fArr[0];
        vector2.y = fArr[1];
        return vector2;
    }

    public Vector2 getAnchorB() {
        jniGetAnchorB(this.addr, this.tmp);
        Vector2 vector2 = this.anchorB;
        float[] fArr = this.tmp;
        vector2.x = fArr[0];
        vector2.y = fArr[1];
        return vector2;
    }

    public boolean getCollideConnected() {
        return jniGetCollideConnected(this.addr);
    }

    public Vector2 getReactionForce(float f2) {
        jniGetReactionForce(this.addr, f2, this.tmp);
        Vector2 vector2 = this.reactionForce;
        float[] fArr = this.tmp;
        vector2.x = fArr[0];
        vector2.y = fArr[1];
        return vector2;
    }

    public float getReactionTorque(float f2) {
        return jniGetReactionTorque(this.addr, f2);
    }

    public Object getUserData() {
        return this.userData;
    }

    public void setUserData(Object obj) {
        this.userData = obj;
    }

    public boolean isActive() {
        return jniIsActive(this.addr);
    }
}
