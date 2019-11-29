package com.badlogic.gdx.physics.box2d;

import com.badlogic.gdx.physics.box2d.utils.Vector2;

public class Transform {
    public static final int COS = 2;
    public static final int POS_X = 0;
    public static final int POS_Y = 1;
    public static final int SIN = 3;
    private Vector2 orientation = new Vector2();
    private Vector2 position = new Vector2();
    public float[] vals = new float[4];

    public Transform() {
    }

    public Transform(Vector2 vector2, float f2) {
        setPosition(vector2);
        setRotation(f2);
    }

    public Transform(Vector2 vector2, Vector2 vector22) {
        setPosition(vector2);
        setOrientation(vector22);
    }

    public Vector2 mul(Vector2 vector2) {
        float[] fArr = this.vals;
        float f2 = fArr[0] + (fArr[2] * vector2.x) + ((-this.vals[3]) * vector2.y);
        float[] fArr2 = this.vals;
        vector2.x = f2;
        vector2.y = fArr2[1] + (fArr2[3] * vector2.x) + (this.vals[2] * vector2.y);
        return vector2;
    }

    public Vector2 getPosition() {
        Vector2 vector2 = this.position;
        float[] fArr = this.vals;
        return vector2.set(fArr[0], fArr[1]);
    }

    public void setRotation(float f2) {
        double d2 = (double) f2;
        float[] fArr = this.vals;
        fArr[2] = (float) Math.cos(d2);
        fArr[3] = (float) Math.sin(d2);
    }

    public float getRotation() {
        float[] fArr = this.vals;
        return (float) Math.atan2((double) fArr[3], (double) fArr[2]);
    }

    public Vector2 getOrientation() {
        Vector2 vector2 = this.orientation;
        float[] fArr = this.vals;
        return vector2.set(fArr[2], fArr[3]);
    }

    public void setOrientation(Vector2 vector2) {
        this.vals[2] = vector2.x;
        this.vals[3] = vector2.y;
    }

    public void setPosition(Vector2 vector2) {
        this.vals[0] = vector2.x;
        this.vals[1] = vector2.y;
    }
}
