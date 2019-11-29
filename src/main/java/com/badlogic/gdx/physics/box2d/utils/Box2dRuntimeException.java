package com.badlogic.gdx.physics.box2d.utils;

public class Box2dRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public Box2dRuntimeException(String str) {
        super(str);
    }

    public Box2dRuntimeException(Throwable th) {
        super(th);
    }

    public Box2dRuntimeException(String str, Throwable th) {
        super(str, th);
    }
}
