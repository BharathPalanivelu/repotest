package com.badlogic.gdx.physics.box2d.utils;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;

public class Vector2 {
    public static final Vector2 X = new Vector2(1.0f, BitmapDescriptorFactory.HUE_RED);
    public static final Vector2 Y = new Vector2(BitmapDescriptorFactory.HUE_RED, 1.0f);
    public static final Vector2 Zero = new Vector2(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
    public float x;
    public float y;

    public static float dot(float f2, float f3, float f4, float f5) {
        return (f2 * f4) + (f3 * f5);
    }

    public static float dst2(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        return (f6 * f6) + (f7 * f7);
    }

    public static float len2(float f2, float f3) {
        return (f2 * f2) + (f3 * f3);
    }

    public Vector2() {
    }

    public Vector2(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }

    public Vector2(Vector2 vector2) {
        set(vector2);
    }

    public Vector2 cpy() {
        return new Vector2(this);
    }

    public static float len(float f2, float f3) {
        return (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
    }

    public float len() {
        float f2 = this.x;
        float f3 = this.y;
        return (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
    }

    public float len2() {
        float f2 = this.x;
        float f3 = this.y;
        return (f2 * f2) + (f3 * f3);
    }

    public Vector2 set(Vector2 vector2) {
        this.x = vector2.x;
        this.y = vector2.y;
        return this;
    }

    public Vector2 set(float f2, float f3) {
        this.x = f2;
        this.y = f3;
        return this;
    }

    public Vector2 sub(Vector2 vector2) {
        this.x -= vector2.x;
        this.y -= vector2.y;
        return this;
    }

    public Vector2 arcatchSub(Vector2 vector2) {
        this.x -= vector2.x;
        this.y = vector2.y - this.y;
        return this;
    }

    public Vector2 sub(float f2, float f3) {
        this.x -= f2;
        this.y -= f3;
        return this;
    }

    public Vector2 nor() {
        float len = len();
        if (len != BitmapDescriptorFactory.HUE_RED) {
            this.x /= len;
            this.y /= len;
        }
        return this;
    }

    public Vector2 add(Vector2 vector2) {
        this.x += vector2.x;
        this.y += vector2.y;
        return this;
    }

    public Vector2 add(float f2, float f3) {
        this.x += f2;
        this.y += f3;
        return this;
    }

    public float dot(Vector2 vector2) {
        return (this.x * vector2.x) + (this.y * vector2.y);
    }

    public float dot(float f2, float f3) {
        return (this.x * f2) + (this.y * f3);
    }

    public Vector2 scl(float f2) {
        this.x *= f2;
        this.y *= f2;
        return this;
    }

    public Vector2 scl(float f2, float f3) {
        this.x *= f2;
        this.y *= f3;
        return this;
    }

    public Vector2 scl(Vector2 vector2) {
        this.x *= vector2.x;
        this.y *= vector2.y;
        return this;
    }

    public Vector2 mulAdd(Vector2 vector2, float f2) {
        this.x += vector2.x * f2;
        this.y += vector2.y * f2;
        return this;
    }

    public Vector2 mulAdd(Vector2 vector2, Vector2 vector22) {
        this.x += vector2.x * vector22.x;
        this.y += vector2.y * vector22.y;
        return this;
    }

    public static float dst(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        return (float) Math.sqrt((double) ((f6 * f6) + (f7 * f7)));
    }

    public float dst(Vector2 vector2) {
        float f2 = vector2.x - this.x;
        float f3 = vector2.y - this.y;
        return (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
    }

    public float dst(float f2, float f3) {
        float f4 = f2 - this.x;
        float f5 = f3 - this.y;
        return (float) Math.sqrt((double) ((f4 * f4) + (f5 * f5)));
    }

    public float dst2(Vector2 vector2) {
        float f2 = vector2.x - this.x;
        float f3 = vector2.y - this.y;
        return (f2 * f2) + (f3 * f3);
    }

    public float dst2(float f2, float f3) {
        float f4 = f2 - this.x;
        float f5 = f3 - this.y;
        return (f4 * f4) + (f5 * f5);
    }

    public Vector2 limit(float f2) {
        return limit2(f2 * f2);
    }

    public Vector2 limit2(float f2) {
        float len2 = len2();
        return len2 > f2 ? scl((float) Math.sqrt((double) (f2 / len2))) : this;
    }

    public Vector2 clamp(float f2, float f3) {
        float len2 = len2();
        if (len2 == BitmapDescriptorFactory.HUE_RED) {
            return this;
        }
        float f4 = f3 * f3;
        if (len2 > f4) {
            return scl((float) Math.sqrt((double) (f4 / len2)));
        }
        float f5 = f2 * f2;
        return len2 < f5 ? scl((float) Math.sqrt((double) (f5 / len2))) : this;
    }

    public Vector2 setLength(float f2) {
        return setLength2(f2 * f2);
    }

    public Vector2 setLength2(float f2) {
        float len2 = len2();
        return (len2 == BitmapDescriptorFactory.HUE_RED || len2 == f2) ? this : scl((float) Math.sqrt((double) (f2 / len2)));
    }

    public String toString() {
        return SQLBuilder.PARENTHESES_LEFT + this.x + "," + this.y + SQLBuilder.PARENTHESES_RIGHT;
    }

    public Vector2 fromString(String str) {
        int indexOf = str.indexOf(44, 1);
        if (indexOf != -1 && str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
            try {
                return set(Float.parseFloat(str.substring(1, indexOf)), Float.parseFloat(str.substring(indexOf + 1, str.length() - 1)));
            } catch (NumberFormatException unused) {
            }
        }
        throw new Box2dRuntimeException("Malformed Vector2: " + str);
    }
}
