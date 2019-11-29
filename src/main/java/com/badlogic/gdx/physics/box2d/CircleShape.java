package com.badlogic.gdx.physics.box2d;

import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.utils.Vector2;

public class CircleShape extends Shape {
    private final Vector2 position = new Vector2();
    private final float[] tmp = new float[2];

    private native void jniGetPosition(long j, float[] fArr);

    private native void jniSetPosition(long j, float f2, float f3);

    private native long newCircleShape();

    public CircleShape() {
        this.addr = newCircleShape();
    }

    protected CircleShape(long j) {
        this.addr = j;
    }

    public Shape.Type getType() {
        return Shape.Type.Circle;
    }

    public Vector2 getPosition() {
        jniGetPosition(this.addr, this.tmp);
        Vector2 vector2 = this.position;
        float[] fArr = this.tmp;
        vector2.x = fArr[0];
        vector2.y = fArr[1];
        return vector2;
    }

    public void setPosition(Vector2 vector2) {
        jniSetPosition(this.addr, vector2.x, vector2.y);
    }
}
