package com.badlogic.gdx.physics.box2d;

import com.badlogic.gdx.physics.box2d.utils.Vector2;

public interface RayCastCallback {
    float reportRayFixture(Fixture fixture, Vector2 vector2, Vector2 vector22, float f2);
}
