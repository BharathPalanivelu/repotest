package androidx.core.g;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final a f1775a;

    interface a {
        boolean a(MotionEvent motionEvent);
    }

    static class b implements a {
        private static final int j = ViewConfiguration.getLongPressTimeout();
        private static final int k = ViewConfiguration.getTapTimeout();
        private static final int l = ViewConfiguration.getDoubleTapTimeout();

        /* renamed from: a  reason: collision with root package name */
        final GestureDetector.OnGestureListener f1776a;

        /* renamed from: b  reason: collision with root package name */
        GestureDetector.OnDoubleTapListener f1777b;

        /* renamed from: c  reason: collision with root package name */
        boolean f1778c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1779d;

        /* renamed from: e  reason: collision with root package name */
        MotionEvent f1780e;

        /* renamed from: f  reason: collision with root package name */
        private int f1781f;

        /* renamed from: g  reason: collision with root package name */
        private int f1782g;
        private int h;
        private int i;
        private final Handler m;
        private boolean n;
        private boolean o;
        private boolean p;
        private MotionEvent q;
        private boolean r;
        private float s;
        private float t;
        private float u;
        private float v;
        private boolean w;
        private VelocityTracker x;

        private class a extends Handler {
            a() {
            }

            a(Handler handler) {
                super(handler.getLooper());
            }

            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    b.this.f1776a.onShowPress(b.this.f1780e);
                } else if (i == 2) {
                    b.this.a();
                } else if (i != 3) {
                    throw new RuntimeException("Unknown message " + message);
                } else if (b.this.f1777b == null) {
                } else {
                    if (!b.this.f1778c) {
                        b.this.f1777b.onSingleTapConfirmed(b.this.f1780e);
                    } else {
                        b.this.f1779d = true;
                    }
                }
            }
        }

        b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.m = new a(handler);
            } else {
                this.m = new a();
            }
            this.f1776a = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                a((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            a(context);
        }

        private void a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.f1776a != null) {
                this.w = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.h = viewConfiguration.getScaledMinimumFlingVelocity();
                this.i = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f1781f = scaledTouchSlop * scaledTouchSlop;
                this.f1782g = scaledDoubleTapSlop * scaledDoubleTapSlop;
            } else {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
        }

        public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f1777b = onDoubleTapListener;
        }

        /* JADX WARNING: Removed duplicated region for block: B:100:0x0208  */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x021f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(android.view.MotionEvent r13) {
            /*
                r12 = this;
                int r0 = r13.getAction()
                android.view.VelocityTracker r1 = r12.x
                if (r1 != 0) goto L_0x000e
                android.view.VelocityTracker r1 = android.view.VelocityTracker.obtain()
                r12.x = r1
            L_0x000e:
                android.view.VelocityTracker r1 = r12.x
                r1.addMovement(r13)
                r0 = r0 & 255(0xff, float:3.57E-43)
                r1 = 6
                r2 = 1
                r3 = 0
                if (r0 != r1) goto L_0x001c
                r4 = 1
                goto L_0x001d
            L_0x001c:
                r4 = 0
            L_0x001d:
                if (r4 == 0) goto L_0x0024
                int r5 = r13.getActionIndex()
                goto L_0x0025
            L_0x0024:
                r5 = -1
            L_0x0025:
                int r6 = r13.getPointerCount()
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
            L_0x002d:
                if (r8 >= r6) goto L_0x003f
                if (r5 != r8) goto L_0x0032
                goto L_0x003c
            L_0x0032:
                float r11 = r13.getX(r8)
                float r9 = r9 + r11
                float r11 = r13.getY(r8)
                float r10 = r10 + r11
            L_0x003c:
                int r8 = r8 + 1
                goto L_0x002d
            L_0x003f:
                if (r4 == 0) goto L_0x0044
                int r4 = r6 + -1
                goto L_0x0045
            L_0x0044:
                r4 = r6
            L_0x0045:
                float r4 = (float) r4
                float r9 = r9 / r4
                float r10 = r10 / r4
                r4 = 2
                r5 = 3
                if (r0 == 0) goto L_0x01bf
                r8 = 1000(0x3e8, float:1.401E-42)
                if (r0 == r2) goto L_0x0131
                if (r0 == r4) goto L_0x00ba
                if (r0 == r5) goto L_0x00b5
                r2 = 5
                if (r0 == r2) goto L_0x00a8
                if (r0 == r1) goto L_0x005b
                goto L_0x024e
            L_0x005b:
                r12.s = r9
                r12.u = r9
                r12.t = r10
                r12.v = r10
                android.view.VelocityTracker r0 = r12.x
                int r1 = r12.i
                float r1 = (float) r1
                r0.computeCurrentVelocity(r8, r1)
                int r0 = r13.getActionIndex()
                int r1 = r13.getPointerId(r0)
                android.view.VelocityTracker r2 = r12.x
                float r2 = r2.getXVelocity(r1)
                android.view.VelocityTracker r4 = r12.x
                float r1 = r4.getYVelocity(r1)
                r4 = 0
            L_0x0080:
                if (r4 >= r6) goto L_0x024e
                if (r4 != r0) goto L_0x0085
                goto L_0x00a5
            L_0x0085:
                int r5 = r13.getPointerId(r4)
                android.view.VelocityTracker r8 = r12.x
                float r8 = r8.getXVelocity(r5)
                float r8 = r8 * r2
                android.view.VelocityTracker r9 = r12.x
                float r5 = r9.getYVelocity(r5)
                float r5 = r5 * r1
                float r8 = r8 + r5
                int r5 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
                if (r5 >= 0) goto L_0x00a5
                android.view.VelocityTracker r13 = r12.x
                r13.clear()
                goto L_0x024e
            L_0x00a5:
                int r4 = r4 + 1
                goto L_0x0080
            L_0x00a8:
                r12.s = r9
                r12.u = r9
                r12.t = r10
                r12.v = r10
                r12.c()
                goto L_0x024e
            L_0x00b5:
                r12.b()
                goto L_0x024e
            L_0x00ba:
                boolean r0 = r12.n
                if (r0 == 0) goto L_0x00c0
                goto L_0x024e
            L_0x00c0:
                float r0 = r12.s
                float r0 = r0 - r9
                float r1 = r12.t
                float r1 = r1 - r10
                boolean r6 = r12.r
                if (r6 == 0) goto L_0x00d3
                android.view.GestureDetector$OnDoubleTapListener r0 = r12.f1777b
                boolean r13 = r0.onDoubleTapEvent(r13)
                r3 = r3 | r13
                goto L_0x024e
            L_0x00d3:
                boolean r6 = r12.o
                if (r6 == 0) goto L_0x0111
                float r6 = r12.u
                float r6 = r9 - r6
                int r6 = (int) r6
                float r7 = r12.v
                float r7 = r10 - r7
                int r7 = (int) r7
                int r6 = r6 * r6
                int r7 = r7 * r7
                int r6 = r6 + r7
                int r7 = r12.f1781f
                if (r6 <= r7) goto L_0x0108
                android.view.GestureDetector$OnGestureListener r7 = r12.f1776a
                android.view.MotionEvent r8 = r12.f1780e
                boolean r13 = r7.onScroll(r8, r13, r0, r1)
                r12.s = r9
                r12.t = r10
                r12.o = r3
                android.os.Handler r0 = r12.m
                r0.removeMessages(r5)
                android.os.Handler r0 = r12.m
                r0.removeMessages(r2)
                android.os.Handler r0 = r12.m
                r0.removeMessages(r4)
                goto L_0x0109
            L_0x0108:
                r13 = 0
            L_0x0109:
                int r0 = r12.f1781f
                if (r6 <= r0) goto L_0x01bc
                r12.p = r3
                goto L_0x01bc
            L_0x0111:
                float r2 = java.lang.Math.abs(r0)
                r4 = 1065353216(0x3f800000, float:1.0)
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 >= 0) goto L_0x0123
                float r2 = java.lang.Math.abs(r1)
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 < 0) goto L_0x024e
            L_0x0123:
                android.view.GestureDetector$OnGestureListener r2 = r12.f1776a
                android.view.MotionEvent r3 = r12.f1780e
                boolean r3 = r2.onScroll(r3, r13, r0, r1)
                r12.s = r9
                r12.t = r10
                goto L_0x024e
            L_0x0131:
                r12.f1778c = r3
                android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r13)
                boolean r1 = r12.r
                if (r1 == 0) goto L_0x0143
                android.view.GestureDetector$OnDoubleTapListener r1 = r12.f1777b
                boolean r13 = r1.onDoubleTapEvent(r13)
                r13 = r13 | r3
                goto L_0x019b
            L_0x0143:
                boolean r1 = r12.n
                if (r1 == 0) goto L_0x014f
                android.os.Handler r13 = r12.m
                r13.removeMessages(r5)
                r12.n = r3
                goto L_0x0191
            L_0x014f:
                boolean r1 = r12.o
                if (r1 == 0) goto L_0x0166
                android.view.GestureDetector$OnGestureListener r1 = r12.f1776a
                boolean r1 = r1.onSingleTapUp(r13)
                boolean r5 = r12.f1779d
                if (r5 == 0) goto L_0x0164
                android.view.GestureDetector$OnDoubleTapListener r5 = r12.f1777b
                if (r5 == 0) goto L_0x0164
                r5.onSingleTapConfirmed(r13)
            L_0x0164:
                r13 = r1
                goto L_0x019b
            L_0x0166:
                android.view.VelocityTracker r1 = r12.x
                int r5 = r13.getPointerId(r3)
                int r6 = r12.i
                float r6 = (float) r6
                r1.computeCurrentVelocity(r8, r6)
                float r6 = r1.getYVelocity(r5)
                float r1 = r1.getXVelocity(r5)
                float r5 = java.lang.Math.abs(r6)
                int r7 = r12.h
                float r7 = (float) r7
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 > 0) goto L_0x0193
                float r5 = java.lang.Math.abs(r1)
                int r7 = r12.h
                float r7 = (float) r7
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 <= 0) goto L_0x0191
                goto L_0x0193
            L_0x0191:
                r13 = 0
                goto L_0x019b
            L_0x0193:
                android.view.GestureDetector$OnGestureListener r5 = r12.f1776a
                android.view.MotionEvent r7 = r12.f1780e
                boolean r13 = r5.onFling(r7, r13, r1, r6)
            L_0x019b:
                android.view.MotionEvent r1 = r12.q
                if (r1 == 0) goto L_0x01a2
                r1.recycle()
            L_0x01a2:
                r12.q = r0
                android.view.VelocityTracker r0 = r12.x
                if (r0 == 0) goto L_0x01ae
                r0.recycle()
                r0 = 0
                r12.x = r0
            L_0x01ae:
                r12.r = r3
                r12.f1779d = r3
                android.os.Handler r0 = r12.m
                r0.removeMessages(r2)
                android.os.Handler r0 = r12.m
                r0.removeMessages(r4)
            L_0x01bc:
                r3 = r13
                goto L_0x024e
            L_0x01bf:
                android.view.GestureDetector$OnDoubleTapListener r0 = r12.f1777b
                if (r0 == 0) goto L_0x01fb
                android.os.Handler r0 = r12.m
                boolean r0 = r0.hasMessages(r5)
                if (r0 == 0) goto L_0x01d0
                android.os.Handler r1 = r12.m
                r1.removeMessages(r5)
            L_0x01d0:
                android.view.MotionEvent r1 = r12.f1780e
                if (r1 == 0) goto L_0x01f3
                android.view.MotionEvent r6 = r12.q
                if (r6 == 0) goto L_0x01f3
                if (r0 == 0) goto L_0x01f3
                boolean r0 = r12.a(r1, r6, r13)
                if (r0 == 0) goto L_0x01f3
                r12.r = r2
                android.view.GestureDetector$OnDoubleTapListener r0 = r12.f1777b
                android.view.MotionEvent r1 = r12.f1780e
                boolean r0 = r0.onDoubleTap(r1)
                r0 = r0 | r3
                android.view.GestureDetector$OnDoubleTapListener r1 = r12.f1777b
                boolean r1 = r1.onDoubleTapEvent(r13)
                r0 = r0 | r1
                goto L_0x01fc
            L_0x01f3:
                android.os.Handler r0 = r12.m
                int r1 = l
                long r6 = (long) r1
                r0.sendEmptyMessageDelayed(r5, r6)
            L_0x01fb:
                r0 = 0
            L_0x01fc:
                r12.s = r9
                r12.u = r9
                r12.t = r10
                r12.v = r10
                android.view.MotionEvent r1 = r12.f1780e
                if (r1 == 0) goto L_0x020b
                r1.recycle()
            L_0x020b:
                android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r13)
                r12.f1780e = r1
                r12.o = r2
                r12.p = r2
                r12.f1778c = r2
                r12.n = r3
                r12.f1779d = r3
                boolean r1 = r12.w
                if (r1 == 0) goto L_0x0237
                android.os.Handler r1 = r12.m
                r1.removeMessages(r4)
                android.os.Handler r1 = r12.m
                android.view.MotionEvent r3 = r12.f1780e
                long r5 = r3.getDownTime()
                int r3 = k
                long r7 = (long) r3
                long r5 = r5 + r7
                int r3 = j
                long r7 = (long) r3
                long r5 = r5 + r7
                r1.sendEmptyMessageAtTime(r4, r5)
            L_0x0237:
                android.os.Handler r1 = r12.m
                android.view.MotionEvent r3 = r12.f1780e
                long r3 = r3.getDownTime()
                int r5 = k
                long r5 = (long) r5
                long r3 = r3 + r5
                r1.sendEmptyMessageAtTime(r2, r3)
                android.view.GestureDetector$OnGestureListener r1 = r12.f1776a
                boolean r13 = r1.onDown(r13)
                r3 = r0 | r13
            L_0x024e:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.g.c.b.a(android.view.MotionEvent):boolean");
        }

        private void b() {
            this.m.removeMessages(1);
            this.m.removeMessages(2);
            this.m.removeMessages(3);
            this.x.recycle();
            this.x = null;
            this.r = false;
            this.f1778c = false;
            this.o = false;
            this.p = false;
            this.f1779d = false;
            if (this.n) {
                this.n = false;
            }
        }

        private void c() {
            this.m.removeMessages(1);
            this.m.removeMessages(2);
            this.m.removeMessages(3);
            this.r = false;
            this.o = false;
            this.p = false;
            this.f1779d = false;
            if (this.n) {
                this.n = false;
            }
        }

        private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.p || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) l)) {
                return false;
            }
            int x2 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            if ((x2 * x2) + (y * y) < this.f1782g) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.m.removeMessages(3);
            this.f1779d = false;
            this.n = true;
            this.f1776a.onLongPress(this.f1780e);
        }
    }

    /* renamed from: androidx.core.g.c$c  reason: collision with other inner class name */
    static class C0037c implements a {

        /* renamed from: a  reason: collision with root package name */
        private final GestureDetector f1784a;

        C0037c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f1784a = new GestureDetector(context, onGestureListener, handler);
        }

        public boolean a(MotionEvent motionEvent) {
            return this.f1784a.onTouchEvent(motionEvent);
        }
    }

    public c(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, (Handler) null);
    }

    public c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.f1775a = new C0037c(context, onGestureListener, handler);
        } else {
            this.f1775a = new b(context, onGestureListener, handler);
        }
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f1775a.a(motionEvent);
    }
}
