package com.badlogic.gdx.physics.box2d;

public final class Box2D {
    private static final String SO_NAME = "gdx-box2d";
    private static boolean isInit = false;

    private Box2D() {
    }

    public static void init() {
        if (!isInit) {
            System.loadLibrary(SO_NAME);
            isInit = true;
        }
    }
}
