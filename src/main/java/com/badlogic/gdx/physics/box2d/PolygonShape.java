package com.badlogic.gdx.physics.box2d;

import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.utils.Vector2;

public class PolygonShape extends Shape {
    private static float[] verts = new float[2];

    private native void jniGetVertex(long j, int i, float[] fArr);

    private native int jniGetVertexCount(long j);

    private native void jniSet(long j, float[] fArr, int i, int i2);

    private native void jniSetAsBox(long j, float f2, float f3);

    private native void jniSetAsBox(long j, float f2, float f3, float f4, float f5, float f6);

    private native long newPolygonShape();

    public PolygonShape() {
        this.addr = newPolygonShape();
    }

    protected PolygonShape(long j) {
        this.addr = j;
    }

    public Shape.Type getType() {
        return Shape.Type.Polygon;
    }

    public void set(Vector2[] vector2Arr) {
        float[] fArr = new float[(vector2Arr.length * 2)];
        int i = 0;
        int i2 = 0;
        while (i < vector2Arr.length * 2) {
            fArr[i] = vector2Arr[i2].x;
            fArr[i + 1] = vector2Arr[i2].y;
            i += 2;
            i2++;
        }
        jniSet(this.addr, fArr, 0, fArr.length);
    }

    public void set(float[] fArr) {
        jniSet(this.addr, fArr, 0, fArr.length);
    }

    public void set(float[] fArr, int i, int i2) {
        jniSet(this.addr, fArr, i, i2);
    }

    public void setAsBox(float f2, float f3) {
        jniSetAsBox(this.addr, f2, f3);
    }

    public void setAsBox(float f2, float f3, Vector2 vector2, float f4) {
        jniSetAsBox(this.addr, f2, f3, vector2.x, vector2.y, f4);
    }

    public int getVertexCount() {
        return jniGetVertexCount(this.addr);
    }

    public void getVertex(int i, Vector2 vector2) {
        jniGetVertex(this.addr, i, verts);
        float[] fArr = verts;
        vector2.x = fArr[0];
        vector2.y = fArr[1];
    }
}
