package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import androidx.core.util.Pools;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.SoftAssertions;

public class TouchEvent extends Event<TouchEvent> {
    private static final Pools.b<TouchEvent> EVENTS_POOL = new Pools.b<>(3);
    private static final int TOUCH_EVENTS_POOL_SIZE = 3;
    public static final long UNSET = Long.MIN_VALUE;
    private short mCoalescingKey;
    private MotionEvent mMotionEvent;
    private TouchEventType mTouchEventType;
    private float mViewX;
    private float mViewY;

    public static TouchEvent obtain(int i, TouchEventType touchEventType, MotionEvent motionEvent, long j, float f2, float f3, TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper) {
        TouchEvent acquire = EVENTS_POOL.acquire();
        if (acquire == null) {
            acquire = new TouchEvent();
        }
        acquire.init(i, touchEventType, motionEvent, j, f2, f3, touchEventCoalescingKeyHelper);
        return acquire;
    }

    private TouchEvent() {
    }

    private void init(int i, TouchEventType touchEventType, MotionEvent motionEvent, long j, float f2, float f3, TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper) {
        super.init(i);
        short s = 0;
        SoftAssertions.assertCondition(j != Long.MIN_VALUE, "Gesture start time must be initialized");
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            touchEventCoalescingKeyHelper.addCoalescingKey(j);
        } else if (action == 1) {
            touchEventCoalescingKeyHelper.removeCoalescingKey(j);
        } else if (action == 2) {
            s = touchEventCoalescingKeyHelper.getCoalescingKey(j);
        } else if (action == 3) {
            touchEventCoalescingKeyHelper.removeCoalescingKey(j);
        } else if (action == 5 || action == 6) {
            touchEventCoalescingKeyHelper.incrementCoalescingKey(j);
        } else {
            throw new RuntimeException("Unhandled MotionEvent action: " + action);
        }
        this.mTouchEventType = touchEventType;
        this.mMotionEvent = MotionEvent.obtain(motionEvent);
        this.mCoalescingKey = s;
        this.mViewX = f2;
        this.mViewY = f3;
    }

    public void onDispose() {
        ((MotionEvent) Assertions.assertNotNull(this.mMotionEvent)).recycle();
        this.mMotionEvent = null;
        EVENTS_POOL.release(this);
    }

    public String getEventName() {
        return TouchEventType.getJSEventName((TouchEventType) Assertions.assertNotNull(this.mTouchEventType));
    }

    /* renamed from: com.facebook.react.uimanager.events.TouchEvent$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$uimanager$events$TouchEventType = new int[TouchEventType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.facebook.react.uimanager.events.TouchEventType[] r0 = com.facebook.react.uimanager.events.TouchEventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$uimanager$events$TouchEventType = r0
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$events$TouchEventType     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.facebook.react.uimanager.events.TouchEventType r1 = com.facebook.react.uimanager.events.TouchEventType.START     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$events$TouchEventType     // Catch:{ NoSuchFieldError -> 0x001f }
                com.facebook.react.uimanager.events.TouchEventType r1 = com.facebook.react.uimanager.events.TouchEventType.END     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$events$TouchEventType     // Catch:{ NoSuchFieldError -> 0x002a }
                com.facebook.react.uimanager.events.TouchEventType r1 = com.facebook.react.uimanager.events.TouchEventType.CANCEL     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$events$TouchEventType     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.facebook.react.uimanager.events.TouchEventType r1 = com.facebook.react.uimanager.events.TouchEventType.MOVE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.events.TouchEvent.AnonymousClass1.<clinit>():void");
        }
    }

    public boolean canCoalesce() {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$events$TouchEventType[((TouchEventType) Assertions.assertNotNull(this.mTouchEventType)).ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return false;
        }
        if (i == 4) {
            return true;
        }
        throw new RuntimeException("Unknown touch event type: " + this.mTouchEventType);
    }

    public short getCoalescingKey() {
        return this.mCoalescingKey;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        TouchesHelper.sendTouchEvent(rCTEventEmitter, (TouchEventType) Assertions.assertNotNull(this.mTouchEventType), getViewTag(), this);
    }

    public MotionEvent getMotionEvent() {
        Assertions.assertNotNull(this.mMotionEvent);
        return this.mMotionEvent;
    }

    public float getViewX() {
        return this.mViewX;
    }

    public float getViewY() {
        return this.mViewY;
    }
}
