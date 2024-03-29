package com.badlogic.gdx.physics.box2d;

import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.joints.DistanceJoint;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.badlogic.gdx.physics.box2d.joints.FrictionJoint;
import com.badlogic.gdx.physics.box2d.joints.FrictionJointDef;
import com.badlogic.gdx.physics.box2d.joints.GearJoint;
import com.badlogic.gdx.physics.box2d.joints.GearJointDef;
import com.badlogic.gdx.physics.box2d.joints.MotorJoint;
import com.badlogic.gdx.physics.box2d.joints.MotorJointDef;
import com.badlogic.gdx.physics.box2d.joints.MouseJoint;
import com.badlogic.gdx.physics.box2d.joints.MouseJointDef;
import com.badlogic.gdx.physics.box2d.joints.PrismaticJoint;
import com.badlogic.gdx.physics.box2d.joints.PrismaticJointDef;
import com.badlogic.gdx.physics.box2d.joints.PulleyJoint;
import com.badlogic.gdx.physics.box2d.joints.PulleyJointDef;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;
import com.badlogic.gdx.physics.box2d.joints.RopeJoint;
import com.badlogic.gdx.physics.box2d.joints.RopeJointDef;
import com.badlogic.gdx.physics.box2d.joints.WeldJoint;
import com.badlogic.gdx.physics.box2d.joints.WeldJointDef;
import com.badlogic.gdx.physics.box2d.joints.WheelJoint;
import com.badlogic.gdx.physics.box2d.joints.WheelJointDef;
import com.badlogic.gdx.physics.box2d.utils.Box2dArray;
import com.badlogic.gdx.physics.box2d.utils.Box2dLongMap;
import com.badlogic.gdx.physics.box2d.utils.Box2dPool;
import com.badlogic.gdx.physics.box2d.utils.Disposable;
import com.badlogic.gdx.physics.box2d.utils.Vector2;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class World implements Disposable {
    protected final long addr;
    protected final Box2dLongMap<Body> bodies = new Box2dLongMap<>(100);
    private final Contact contact = new Contact(this, 0);
    private long[] contactAddrs = new long[200];
    protected ContactFilter contactFilter = null;
    protected ContactListener contactListener = null;
    private final Box2dArray<Contact> contacts = new Box2dArray<>();
    protected final Box2dLongMap<Fixture> fixtures = new Box2dLongMap<>(100);
    protected final Box2dPool<Body> freeBodies = new Box2dPool<Body>(100, 200) {
        /* access modifiers changed from: protected */
        public Body newObject() {
            return new Body(World.this, 0);
        }
    };
    private final Box2dArray<Contact> freeContacts = new Box2dArray<>();
    protected final Box2dPool<Fixture> freeFixtures = new Box2dPool<Fixture>(100, 200) {
        /* access modifiers changed from: protected */
        public Fixture newObject() {
            return new Fixture((Body) null, 0);
        }
    };
    final Vector2 gravity = new Vector2();
    private final ContactImpulse impulse = new ContactImpulse(this, 0);
    protected final Box2dLongMap<Joint> joints = new Box2dLongMap<>(100);
    private final Manifold manifold = new Manifold(0);
    private QueryCallback queryCallback = null;
    private RayCastCallback rayCastCallback = null;
    private Vector2 rayNormal = new Vector2();
    private Vector2 rayPoint = new Vector2();
    final float[] tmpGravity = new float[2];

    public static native float getVelocityThreshold();

    private native void jniClearForces(long j);

    private native long jniCreateBody(long j, int i, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, float f10);

    private native long jniCreateDistanceJoint(long j, long j2, long j3, boolean z, float f2, float f3, float f4, float f5, float f6, float f7, float f8);

    private native long jniCreateFrictionJoint(long j, long j2, long j3, boolean z, float f2, float f3, float f4, float f5, float f6, float f7);

    private native long jniCreateGearJoint(long j, long j2, long j3, boolean z, long j4, long j5, float f2);

    private native long jniCreateMotorJoint(long j, long j2, long j3, boolean z, float f2, float f3, float f4, float f5, float f6, float f7);

    private native long jniCreateMouseJoint(long j, long j2, long j3, boolean z, float f2, float f3, float f4, float f5, float f6);

    private native long jniCreatePrismaticJoint(long j, long j2, long j3, boolean z, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z2, float f9, float f10, boolean z3, float f11, float f12);

    private native long jniCreatePulleyJoint(long j, long j2, long j3, boolean z, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12);

    private native long jniCreateRevoluteJoint(long j, long j2, long j3, boolean z, float f2, float f3, float f4, float f5, float f6, boolean z2, float f7, float f8, boolean z3, float f9, float f10);

    private native long jniCreateRopeJoint(long j, long j2, long j3, boolean z, float f2, float f3, float f4, float f5, float f6);

    private native long jniCreateWeldJoint(long j, long j2, long j3, boolean z, float f2, float f3, float f4, float f5, float f6, float f7, float f8);

    private native long jniCreateWheelJoint(long j, long j2, long j3, boolean z, float f2, float f3, float f4, float f5, float f6, float f7, boolean z2, float f8, float f9, float f10, float f11);

    private native void jniDeactivateBody(long j, long j2);

    private native void jniDestroyBody(long j, long j2);

    private native void jniDestroyFixture(long j, long j2, long j3);

    private native void jniDestroyJoint(long j, long j2);

    private native void jniDispose(long j);

    private native boolean jniGetAutoClearForces(long j);

    private native int jniGetBodyCount(long j);

    private native int jniGetContactCount(long j);

    private native void jniGetContactList(long j, long[] jArr);

    private native void jniGetGravity(long j, float[] fArr);

    private native int jniGetJointcount(long j);

    private native int jniGetProxyCount(long j);

    private native boolean jniIsLocked(long j);

    private native void jniQueryAABB(long j, float f2, float f3, float f4, float f5);

    private native void jniRayCast(long j, float f2, float f3, float f4, float f5);

    private native void jniSetAutoClearForces(long j, boolean z);

    private native void jniSetContiousPhysics(long j, boolean z);

    private native void jniSetGravity(long j, float f2, float f3);

    private native void jniSetWarmStarting(long j, boolean z);

    private native void jniStep(long j, float f2, int i, int i2);

    private native long newWorld(float f2, float f3, boolean z);

    private native void setUseDefaultContactFilter(boolean z);

    public static native void setVelocityThreshold(float f2);

    public void setDestructionListener(DestructionListener destructionListener) {
    }

    static {
        Box2D.init();
    }

    public World(Vector2 vector2, boolean z) {
        this.addr = newWorld(vector2.x, vector2.y, z);
        this.contacts.ensureCapacity(this.contactAddrs.length);
        this.freeContacts.ensureCapacity(this.contactAddrs.length);
        for (int i = 0; i < this.contactAddrs.length; i++) {
            this.freeContacts.add(new Contact(this, 0));
        }
    }

    public void setContactFilter(ContactFilter contactFilter2) {
        this.contactFilter = contactFilter2;
        setUseDefaultContactFilter(contactFilter2 == null);
    }

    public void setContactListener(ContactListener contactListener2) {
        this.contactListener = contactListener2;
    }

    public Body createBody(BodyDef bodyDef) {
        BodyDef bodyDef2 = bodyDef;
        long j = this.addr;
        BodyDef bodyDef3 = bodyDef2;
        long j2 = j;
        long jniCreateBody = jniCreateBody(j2, bodyDef2.type.getValue(), bodyDef2.position.x, bodyDef2.position.y, bodyDef2.angle, bodyDef2.linearVelocity.x, bodyDef2.linearVelocity.y, bodyDef2.angularVelocity, bodyDef2.linearDamping, bodyDef2.angularDamping, bodyDef2.allowSleep, bodyDef2.awake, bodyDef2.fixedRotation, bodyDef3.bullet, bodyDef3.active, bodyDef3.gravityScale);
        Body obtain = this.freeBodies.obtain();
        obtain.reset(jniCreateBody);
        this.bodies.put(obtain.addr, obtain);
        return obtain;
    }

    public void destroyBody(Body body) {
        Box2dArray<JointEdge> jointList = body.getJointList();
        while (jointList.size > 0) {
            destroyJoint(body.getJointList().get(0).joint);
        }
        jniDestroyBody(this.addr, body.addr);
        body.setUserData((Object) null);
        this.bodies.remove(body.addr);
        Box2dArray<Fixture> fixtureList = body.getFixtureList();
        while (fixtureList.size > 0) {
            Fixture removeIndex = fixtureList.removeIndex(0);
            this.fixtures.remove(removeIndex.addr).setUserData((Object) null);
            this.freeFixtures.free(removeIndex);
        }
        this.freeBodies.free(body);
    }

    /* access modifiers changed from: package-private */
    public void destroyFixture(Body body, Fixture fixture) {
        jniDestroyFixture(this.addr, body.addr, fixture.addr);
    }

    /* access modifiers changed from: package-private */
    public void deactivateBody(Body body) {
        jniDeactivateBody(this.addr, body.addr);
    }

    public Joint createJoint(JointDef jointDef) {
        long createProperJoint = createProperJoint(jointDef);
        Joint distanceJoint = jointDef.type == JointDef.JointType.DistanceJoint ? new DistanceJoint(this, createProperJoint) : null;
        if (jointDef.type == JointDef.JointType.FrictionJoint) {
            distanceJoint = new FrictionJoint(this, createProperJoint);
        }
        if (jointDef.type == JointDef.JointType.GearJoint) {
            GearJointDef gearJointDef = (GearJointDef) jointDef;
            distanceJoint = new GearJoint(this, createProperJoint, gearJointDef.joint1, gearJointDef.joint2);
        }
        if (jointDef.type == JointDef.JointType.MotorJoint) {
            distanceJoint = new MotorJoint(this, createProperJoint);
        }
        if (jointDef.type == JointDef.JointType.MouseJoint) {
            distanceJoint = new MouseJoint(this, createProperJoint);
        }
        if (jointDef.type == JointDef.JointType.PrismaticJoint) {
            distanceJoint = new PrismaticJoint(this, createProperJoint);
        }
        if (jointDef.type == JointDef.JointType.PulleyJoint) {
            distanceJoint = new PulleyJoint(this, createProperJoint);
        }
        if (jointDef.type == JointDef.JointType.RevoluteJoint) {
            distanceJoint = new RevoluteJoint(this, createProperJoint);
        }
        if (jointDef.type == JointDef.JointType.RopeJoint) {
            distanceJoint = new RopeJoint(this, createProperJoint);
        }
        if (jointDef.type == JointDef.JointType.WeldJoint) {
            distanceJoint = new WeldJoint(this, createProperJoint);
        }
        if (jointDef.type == JointDef.JointType.WheelJoint) {
            distanceJoint = new WheelJoint(this, createProperJoint);
        }
        if (distanceJoint != null) {
            this.joints.put(distanceJoint.addr, distanceJoint);
        }
        JointEdge jointEdge = new JointEdge(jointDef.bodyB, distanceJoint);
        JointEdge jointEdge2 = new JointEdge(jointDef.bodyA, distanceJoint);
        distanceJoint.jointEdgeA = jointEdge;
        distanceJoint.jointEdgeB = jointEdge2;
        jointDef.bodyA.joints.add(jointEdge);
        jointDef.bodyB.joints.add(jointEdge2);
        return distanceJoint;
    }

    private long createProperJoint(JointDef jointDef) {
        JointDef jointDef2 = jointDef;
        if (jointDef2.type == JointDef.JointType.DistanceJoint) {
            DistanceJointDef distanceJointDef = (DistanceJointDef) jointDef2;
            return jniCreateDistanceJoint(this.addr, distanceJointDef.bodyA.addr, distanceJointDef.bodyB.addr, distanceJointDef.collideConnected, distanceJointDef.localAnchorA.x, distanceJointDef.localAnchorA.y, distanceJointDef.localAnchorB.x, distanceJointDef.localAnchorB.y, distanceJointDef.length, distanceJointDef.frequencyHz, distanceJointDef.dampingRatio);
        } else if (jointDef2.type == JointDef.JointType.FrictionJoint) {
            FrictionJointDef frictionJointDef = (FrictionJointDef) jointDef2;
            return jniCreateFrictionJoint(this.addr, frictionJointDef.bodyA.addr, frictionJointDef.bodyB.addr, frictionJointDef.collideConnected, frictionJointDef.localAnchorA.x, frictionJointDef.localAnchorA.y, frictionJointDef.localAnchorB.x, frictionJointDef.localAnchorB.y, frictionJointDef.maxForce, frictionJointDef.maxTorque);
        } else if (jointDef2.type == JointDef.JointType.GearJoint) {
            GearJointDef gearJointDef = (GearJointDef) jointDef2;
            return jniCreateGearJoint(this.addr, gearJointDef.bodyA.addr, gearJointDef.bodyB.addr, gearJointDef.collideConnected, gearJointDef.joint1.addr, gearJointDef.joint2.addr, gearJointDef.ratio);
        } else if (jointDef2.type == JointDef.JointType.MotorJoint) {
            MotorJointDef motorJointDef = (MotorJointDef) jointDef2;
            return jniCreateMotorJoint(this.addr, motorJointDef.bodyA.addr, motorJointDef.bodyB.addr, motorJointDef.collideConnected, motorJointDef.linearOffset.x, motorJointDef.linearOffset.y, motorJointDef.angularOffset, motorJointDef.maxForce, motorJointDef.maxTorque, motorJointDef.correctionFactor);
        } else if (jointDef2.type == JointDef.JointType.MouseJoint) {
            MouseJointDef mouseJointDef = (MouseJointDef) jointDef2;
            return jniCreateMouseJoint(this.addr, mouseJointDef.bodyA.addr, mouseJointDef.bodyB.addr, mouseJointDef.collideConnected, mouseJointDef.target.x, mouseJointDef.target.y, mouseJointDef.maxForce, mouseJointDef.frequencyHz, mouseJointDef.dampingRatio);
        } else if (jointDef2.type == JointDef.JointType.PrismaticJoint) {
            PrismaticJointDef prismaticJointDef = (PrismaticJointDef) jointDef2;
            long j = this.addr;
            return jniCreatePrismaticJoint(j, prismaticJointDef.bodyA.addr, prismaticJointDef.bodyB.addr, prismaticJointDef.collideConnected, prismaticJointDef.localAnchorA.x, prismaticJointDef.localAnchorA.y, prismaticJointDef.localAnchorB.x, prismaticJointDef.localAnchorB.y, prismaticJointDef.localAxisA.x, prismaticJointDef.localAxisA.y, prismaticJointDef.referenceAngle, prismaticJointDef.enableLimit, prismaticJointDef.lowerTranslation, prismaticJointDef.upperTranslation, prismaticJointDef.enableMotor, prismaticJointDef.maxMotorForce, prismaticJointDef.motorSpeed);
        } else if (jointDef2.type == JointDef.JointType.PulleyJoint) {
            PulleyJointDef pulleyJointDef = (PulleyJointDef) jointDef2;
            long j2 = this.addr;
            return jniCreatePulleyJoint(j2, pulleyJointDef.bodyA.addr, pulleyJointDef.bodyB.addr, pulleyJointDef.collideConnected, pulleyJointDef.groundAnchorA.x, pulleyJointDef.groundAnchorA.y, pulleyJointDef.groundAnchorB.x, pulleyJointDef.groundAnchorB.y, pulleyJointDef.localAnchorA.x, pulleyJointDef.localAnchorA.y, pulleyJointDef.localAnchorB.x, pulleyJointDef.localAnchorB.y, pulleyJointDef.lengthA, pulleyJointDef.lengthB, pulleyJointDef.ratio);
        } else if (jointDef2.type == JointDef.JointType.RevoluteJoint) {
            RevoluteJointDef revoluteJointDef = (RevoluteJointDef) jointDef2;
            long j3 = this.addr;
            return jniCreateRevoluteJoint(j3, revoluteJointDef.bodyA.addr, revoluteJointDef.bodyB.addr, revoluteJointDef.collideConnected, revoluteJointDef.localAnchorA.x, revoluteJointDef.localAnchorA.y, revoluteJointDef.localAnchorB.x, revoluteJointDef.localAnchorB.y, revoluteJointDef.referenceAngle, revoluteJointDef.enableLimit, revoluteJointDef.lowerAngle, revoluteJointDef.upperAngle, revoluteJointDef.enableMotor, revoluteJointDef.motorSpeed, revoluteJointDef.maxMotorTorque);
        } else if (jointDef2.type == JointDef.JointType.RopeJoint) {
            RopeJointDef ropeJointDef = (RopeJointDef) jointDef2;
            return jniCreateRopeJoint(this.addr, ropeJointDef.bodyA.addr, ropeJointDef.bodyB.addr, ropeJointDef.collideConnected, ropeJointDef.localAnchorA.x, ropeJointDef.localAnchorA.y, ropeJointDef.localAnchorB.x, ropeJointDef.localAnchorB.y, ropeJointDef.maxLength);
        } else {
            if (jointDef2.type == JointDef.JointType.WeldJoint) {
                WeldJointDef weldJointDef = (WeldJointDef) jointDef2;
                return jniCreateWeldJoint(this.addr, weldJointDef.bodyA.addr, weldJointDef.bodyB.addr, weldJointDef.collideConnected, weldJointDef.localAnchorA.x, weldJointDef.localAnchorA.y, weldJointDef.localAnchorB.x, weldJointDef.localAnchorB.y, weldJointDef.referenceAngle, weldJointDef.frequencyHz, weldJointDef.dampingRatio);
            } else if (jointDef2.type != JointDef.JointType.WheelJoint) {
                return 0;
            } else {
                WheelJointDef wheelJointDef = (WheelJointDef) jointDef2;
                long j4 = this.addr;
                return jniCreateWheelJoint(j4, wheelJointDef.bodyA.addr, wheelJointDef.bodyB.addr, wheelJointDef.collideConnected, wheelJointDef.localAnchorA.x, wheelJointDef.localAnchorA.y, wheelJointDef.localAnchorB.x, wheelJointDef.localAnchorB.y, wheelJointDef.localAxisA.x, wheelJointDef.localAxisA.y, wheelJointDef.enableMotor, wheelJointDef.maxMotorTorque, wheelJointDef.motorSpeed, wheelJointDef.frequencyHz, wheelJointDef.dampingRatio);
            }
        }
    }

    public void destroyJoint(Joint joint) {
        joint.setUserData((Object) null);
        this.joints.remove(joint.addr);
        joint.jointEdgeA.other.joints.removeValue(joint.jointEdgeB, true);
        joint.jointEdgeB.other.joints.removeValue(joint.jointEdgeA, true);
        jniDestroyJoint(this.addr, joint.addr);
    }

    public void step(float f2, int i, int i2) {
        jniStep(this.addr, f2, i, i2);
    }

    public void clearForces() {
        jniClearForces(this.addr);
    }

    public void setWarmStarting(boolean z) {
        jniSetWarmStarting(this.addr, z);
    }

    public void setContinuousPhysics(boolean z) {
        jniSetContiousPhysics(this.addr, z);
    }

    public int getProxyCount() {
        return jniGetProxyCount(this.addr);
    }

    public int getBodyCount() {
        return jniGetBodyCount(this.addr);
    }

    public int getFixtureCount() {
        return this.fixtures.size;
    }

    public int getJointCount() {
        return jniGetJointcount(this.addr);
    }

    public int getContactCount() {
        return jniGetContactCount(this.addr);
    }

    public void setGravity(Vector2 vector2) {
        jniSetGravity(this.addr, vector2.x, vector2.y);
    }

    public Vector2 getGravity() {
        jniGetGravity(this.addr, this.tmpGravity);
        Vector2 vector2 = this.gravity;
        float[] fArr = this.tmpGravity;
        vector2.x = fArr[0];
        vector2.y = fArr[1];
        return vector2;
    }

    public boolean isLocked() {
        return jniIsLocked(this.addr);
    }

    public void setAutoClearForces(boolean z) {
        jniSetAutoClearForces(this.addr, z);
    }

    public boolean getAutoClearForces() {
        return jniGetAutoClearForces(this.addr);
    }

    public void QueryAABB(QueryCallback queryCallback2, float f2, float f3, float f4, float f5) {
        this.queryCallback = queryCallback2;
        jniQueryAABB(this.addr, f2, f3, f4, f5);
    }

    public Box2dArray<Contact> getContactList() {
        int contactCount = getContactCount();
        if (contactCount > this.contactAddrs.length) {
            int i = contactCount * 2;
            this.contactAddrs = new long[i];
            this.contacts.ensureCapacity(i);
            this.freeContacts.ensureCapacity(i);
        }
        if (contactCount > this.freeContacts.size) {
            int i2 = this.freeContacts.size;
            for (int i3 = 0; i3 < contactCount - i2; i3++) {
                this.freeContacts.add(new Contact(this, 0));
            }
        }
        jniGetContactList(this.addr, this.contactAddrs);
        this.contacts.clear();
        for (int i4 = 0; i4 < contactCount; i4++) {
            Contact contact2 = this.freeContacts.get(i4);
            contact2.addr = this.contactAddrs[i4];
            this.contacts.add(contact2);
        }
        return this.contacts;
    }

    public void getBodies(Box2dArray<Body> box2dArray) {
        box2dArray.clear();
        box2dArray.ensureCapacity(this.bodies.size);
        Box2dLongMap.Values<Body> values = this.bodies.values();
        while (values.hasNext()) {
            box2dArray.add((Body) values.next());
        }
    }

    public void getFixtures(Box2dArray<Fixture> box2dArray) {
        box2dArray.clear();
        box2dArray.ensureCapacity(this.fixtures.size);
        Box2dLongMap.Values<Fixture> values = this.fixtures.values();
        while (values.hasNext()) {
            box2dArray.add((Fixture) values.next());
        }
    }

    public void getJoints(Box2dArray<Joint> box2dArray) {
        box2dArray.clear();
        box2dArray.ensureCapacity(this.joints.size);
        Box2dLongMap.Values<Joint> values = this.joints.values();
        while (values.hasNext()) {
            box2dArray.add((Joint) values.next());
        }
    }

    public void dispose() {
        jniDispose(this.addr);
    }

    private boolean contactFilter(long j, long j2) {
        ContactFilter contactFilter2 = this.contactFilter;
        if (contactFilter2 != null) {
            return contactFilter2.shouldCollide(this.fixtures.get(j), this.fixtures.get(j2));
        }
        Filter filterData = this.fixtures.get(j).getFilterData();
        Filter filterData2 = this.fixtures.get(j2).getFilterData();
        if (filterData.groupIndex == filterData2.groupIndex && filterData.groupIndex != 0) {
            return filterData.groupIndex > 0;
        }
        if ((filterData.maskBits & filterData2.categoryBits) == 0 || (filterData.categoryBits & filterData2.maskBits) == 0) {
            return false;
        }
        return true;
    }

    private void beginContact(long j) {
        Contact contact2 = this.contact;
        contact2.addr = j;
        ContactListener contactListener2 = this.contactListener;
        if (contactListener2 != null) {
            contactListener2.beginContact(contact2);
        }
    }

    private void endContact(long j) {
        Contact contact2 = this.contact;
        contact2.addr = j;
        ContactListener contactListener2 = this.contactListener;
        if (contactListener2 != null) {
            contactListener2.endContact(contact2);
        }
    }

    private void preSolve(long j, long j2) {
        Contact contact2 = this.contact;
        contact2.addr = j;
        Manifold manifold2 = this.manifold;
        manifold2.addr = j2;
        ContactListener contactListener2 = this.contactListener;
        if (contactListener2 != null) {
            contactListener2.preSolve(contact2, manifold2);
        }
    }

    private void postSolve(long j, long j2) {
        Contact contact2 = this.contact;
        contact2.addr = j;
        ContactImpulse contactImpulse = this.impulse;
        contactImpulse.addr = j2;
        ContactListener contactListener2 = this.contactListener;
        if (contactListener2 != null) {
            contactListener2.postSolve(contact2, contactImpulse);
        }
    }

    private boolean reportFixture(long j) {
        QueryCallback queryCallback2 = this.queryCallback;
        if (queryCallback2 != null) {
            return queryCallback2.reportFixture(this.fixtures.get(j));
        }
        return false;
    }

    public void rayCast(RayCastCallback rayCastCallback2, Vector2 vector2, Vector2 vector22) {
        rayCast(rayCastCallback2, vector2.x, vector2.y, vector22.x, vector22.y);
    }

    public void rayCast(RayCastCallback rayCastCallback2, float f2, float f3, float f4, float f5) {
        this.rayCastCallback = rayCastCallback2;
        jniRayCast(this.addr, f2, f3, f4, f5);
    }

    private float reportRayFixture(long j, float f2, float f3, float f4, float f5, float f6) {
        RayCastCallback rayCastCallback2 = this.rayCastCallback;
        if (rayCastCallback2 == null) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        Vector2 vector2 = this.rayPoint;
        vector2.x = f2;
        vector2.y = f3;
        Vector2 vector22 = this.rayNormal;
        vector22.x = f4;
        vector22.y = f5;
        return rayCastCallback2.reportRayFixture(this.fixtures.get(j), this.rayPoint, this.rayNormal, f6);
    }
}
