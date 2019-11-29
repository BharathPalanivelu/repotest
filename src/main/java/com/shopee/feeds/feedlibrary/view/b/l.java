package com.shopee.feeds.feedlibrary.view.b;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import androidx.core.g.i;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class l implements View.OnLayoutChangeListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private static float f28527a = 3.0f;

    /* renamed from: b  reason: collision with root package name */
    private static float f28528b = 1.75f;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static float f28529c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private static int f28530d = 200;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static int f28531e = 1;
    /* access modifiers changed from: private */
    public g A;
    /* access modifiers changed from: private */
    public h B;
    /* access modifiers changed from: private */
    public i C;
    /* access modifiers changed from: private */
    public b D;
    /* access modifiers changed from: private */
    public int E = 2;
    private float F;
    private boolean G = true;
    private ImageView.ScaleType H = ImageView.ScaleType.FIT_CENTER;
    /* access modifiers changed from: private */
    public c I = new c() {
        public void a(float f2, float f3) {
            if (!l.this.o.a()) {
                if (l.this.C != null) {
                    l.this.C.a(f2, f3);
                }
                l.this.r.postTranslate(f2, f3);
                l.this.m();
                ViewParent parent = l.this.m.getParent();
                if (!l.this.k || l.this.o.a() || l.this.l) {
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                } else if ((l.this.E == 2 || ((l.this.E == 0 && f2 >= 1.0f) || (l.this.E == 1 && f2 <= -1.0f))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        }

        public void a(float f2, float f3, float f4, float f5) {
            l lVar = l.this;
            b unused = lVar.D = new b(lVar.m.getContext());
            b i = l.this.D;
            l lVar2 = l.this;
            int a2 = lVar2.a(lVar2.m);
            l lVar3 = l.this;
            i.a(a2, lVar3.b(lVar3.m), (int) f4, (int) f5);
            l.this.m.post(l.this.D);
        }

        public void a(float f2, float f3, float f4) {
            if (l.this.e() >= l.this.j && f2 >= 1.0f) {
                return;
            }
            if (l.this.e() > l.this.h || f2 > 1.0f) {
                if (l.this.A != null) {
                    l.this.A.a(f2, f3, f4);
                }
                l.this.r.postScale(f2, f2, f3, f4);
                l.this.m();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Interpolator f28532f = new AccelerateDecelerateInterpolator();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f28533g = f28530d;
    /* access modifiers changed from: private */
    public float h = f28529c;
    private float i = f28528b;
    /* access modifiers changed from: private */
    public float j = f28527a;
    /* access modifiers changed from: private */
    public boolean k = true;
    /* access modifiers changed from: private */
    public boolean l = false;
    /* access modifiers changed from: private */
    public ImageView m;
    private GestureDetector n;
    /* access modifiers changed from: private */
    public b o;
    private final Matrix p = new Matrix();
    private final Matrix q = new Matrix();
    /* access modifiers changed from: private */
    public final Matrix r = new Matrix();
    private final RectF s = new RectF();
    private final float[] t = new float[9];
    private d u;
    /* access modifiers changed from: private */
    public f v;
    /* access modifiers changed from: private */
    public e w;
    /* access modifiers changed from: private */
    public j x;
    /* access modifiers changed from: private */
    public View.OnClickListener y;
    /* access modifiers changed from: private */
    public View.OnLongClickListener z;

    public l(ImageView imageView) {
        this.m = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (!imageView.isInEditMode()) {
            this.F = BitmapDescriptorFactory.HUE_RED;
            this.o = new b(imageView.getContext(), this.I);
            this.n = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() {
                public void onLongPress(MotionEvent motionEvent) {
                    if (l.this.z != null) {
                        l.this.z.onLongClick(l.this.m);
                    }
                }

                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    if (l.this.B == null || l.this.e() > l.f28529c || i.c(motionEvent) > l.f28531e || i.c(motionEvent2) > l.f28531e) {
                        return false;
                    }
                    return l.this.B.a(motionEvent, motionEvent2, f2, f3);
                }
            });
            this.n.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
                public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                    return false;
                }

                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    if (l.this.y != null) {
                        l.this.y.onClick(l.this.m);
                    }
                    RectF a2 = l.this.a();
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (l.this.x != null) {
                        l.this.x.a(l.this.m, x, y);
                    }
                    if (a2 == null) {
                        return false;
                    }
                    if (a2.contains(x, y)) {
                        float width = (x - a2.left) / a2.width();
                        float height = (y - a2.top) / a2.height();
                        if (l.this.v == null) {
                            return true;
                        }
                        l.this.v.a(l.this.m, width, height);
                        return true;
                    } else if (l.this.w == null) {
                        return false;
                    } else {
                        l.this.w.a(l.this.m);
                        return false;
                    }
                }

                public boolean onDoubleTap(MotionEvent motionEvent) {
                    try {
                        float e2 = l.this.e();
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        if (e2 < l.this.c()) {
                            l.this.a(l.this.c(), x, y, true);
                        } else if (e2 < l.this.c() || e2 >= l.this.d()) {
                            l.this.a(l.this.b(), x, y, true);
                        } else {
                            l.this.a(l.this.d(), x, y, true);
                        }
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                    return true;
                }
            });
        }
    }

    public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.n.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void a(g gVar) {
        this.A = gVar;
    }

    public void a(h hVar) {
        this.B = hVar;
    }

    public RectF a() {
        n();
        return b(k());
    }

    public void a(float f2) {
        this.r.setRotate(f2 % 360.0f);
        m();
    }

    public void b(float f2) {
        this.r.postRotate(f2 % 360.0f);
        m();
    }

    public float b() {
        return this.h;
    }

    public float c() {
        return this.i;
    }

    public float d() {
        return this.j;
    }

    public float e() {
        return (float) Math.sqrt((double) (((float) Math.pow((double) a(this.r, 0), 2.0d)) + ((float) Math.pow((double) a(this.r, 3), 2.0d))));
    }

    public ImageView.ScaleType f() {
        return this.H;
    }

    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i2 != i6 || i3 != i7 || i4 != i8 || i5 != i9) {
            a(this.m.getDrawable());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.G
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00be
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = com.shopee.feeds.feedlibrary.view.b.m.a((android.widget.ImageView) r0)
            if (r0 == 0) goto L_0x00be
            int r0 = r12.getAction()
            if (r0 == 0) goto L_0x006e
            if (r0 == r2) goto L_0x001b
            r3 = 3
            if (r0 == r3) goto L_0x001b
            goto L_0x007a
        L_0x001b:
            float r0 = r10.e()
            float r3 = r10.h
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0044
            android.graphics.RectF r0 = r10.a()
            if (r0 == 0) goto L_0x007a
            com.shopee.feeds.feedlibrary.view.b.l$a r9 = new com.shopee.feeds.feedlibrary.view.b.l$a
            float r5 = r10.e()
            float r6 = r10.h
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            goto L_0x006c
        L_0x0044:
            float r0 = r10.e()
            float r3 = r10.j
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x007a
            android.graphics.RectF r0 = r10.a()
            if (r0 == 0) goto L_0x007a
            com.shopee.feeds.feedlibrary.view.b.l$a r9 = new com.shopee.feeds.feedlibrary.view.b.l$a
            float r5 = r10.e()
            float r6 = r10.j
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
        L_0x006c:
            r11 = 1
            goto L_0x007b
        L_0x006e:
            android.view.ViewParent r11 = r11.getParent()
            if (r11 == 0) goto L_0x0077
            r11.requestDisallowInterceptTouchEvent(r2)
        L_0x0077:
            r10.o()
        L_0x007a:
            r11 = 0
        L_0x007b:
            com.shopee.feeds.feedlibrary.view.b.b r0 = r10.o
            if (r0 == 0) goto L_0x00b2
            boolean r11 = r0.a()
            com.shopee.feeds.feedlibrary.view.b.b r0 = r10.o
            boolean r0 = r0.b()
            com.shopee.feeds.feedlibrary.view.b.b r3 = r10.o
            boolean r3 = r3.a((android.view.MotionEvent) r12)
            if (r11 != 0) goto L_0x009b
            com.shopee.feeds.feedlibrary.view.b.b r11 = r10.o
            boolean r11 = r11.a()
            if (r11 != 0) goto L_0x009b
            r11 = 1
            goto L_0x009c
        L_0x009b:
            r11 = 0
        L_0x009c:
            if (r0 != 0) goto L_0x00a8
            com.shopee.feeds.feedlibrary.view.b.b r0 = r10.o
            boolean r0 = r0.b()
            if (r0 != 0) goto L_0x00a8
            r0 = 1
            goto L_0x00a9
        L_0x00a8:
            r0 = 0
        L_0x00a9:
            if (r11 == 0) goto L_0x00ae
            if (r0 == 0) goto L_0x00ae
            r1 = 1
        L_0x00ae:
            r10.l = r1
            r1 = r3
            goto L_0x00b3
        L_0x00b2:
            r1 = r11
        L_0x00b3:
            android.view.GestureDetector r11 = r10.n
            if (r11 == 0) goto L_0x00be
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto L_0x00be
            r1 = 1
        L_0x00be:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.view.b.l.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void a(boolean z2) {
        this.k = z2;
    }

    public void c(float f2) {
        m.a(f2, this.i, this.j);
        this.h = f2;
    }

    public void d(float f2) {
        m.a(this.h, f2, this.j);
        this.i = f2;
    }

    public void e(float f2) {
        m.a(this.h, this.i, f2);
        this.j = f2;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.z = onLongClickListener;
    }

    public void a(View.OnClickListener onClickListener) {
        this.y = onClickListener;
    }

    public void a(d dVar) {
        this.u = dVar;
    }

    public void a(f fVar) {
        this.v = fVar;
    }

    public void a(e eVar) {
        this.w = eVar;
    }

    public void a(j jVar) {
        this.x = jVar;
    }

    public void a(i iVar) {
        this.C = iVar;
    }

    public void f(float f2) {
        a(f2, false);
    }

    public void a(float f2, boolean z2) {
        a(f2, (float) (this.m.getRight() / 2), (float) (this.m.getBottom() / 2), z2);
    }

    public void a(float f2, float f3, float f4, boolean z2) {
        if (f2 < this.h || f2 > this.j) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        } else if (z2) {
            this.m.post(new a(e(), f2, f3, f4));
        } else {
            this.r.setScale(f2, f2, f3, f4);
            m();
        }
    }

    public void a(ImageView.ScaleType scaleType) {
        if (m.a(scaleType) && scaleType != this.H) {
            this.H = scaleType;
            g();
        }
    }

    public void b(boolean z2) {
        this.G = z2;
        g();
    }

    public void g() {
        if (this.G) {
            a(this.m.getDrawable());
        } else {
            l();
        }
    }

    private Matrix k() {
        this.q.set(this.p);
        this.q.postConcat(this.r);
        return this.q;
    }

    public Matrix h() {
        return this.q;
    }

    public void a(int i2) {
        this.f28533g = i2;
    }

    private float a(Matrix matrix, int i2) {
        matrix.getValues(this.t);
        return this.t[i2];
    }

    private void l() {
        this.r.reset();
        b(this.F);
        a(k());
        n();
    }

    private void a(Matrix matrix) {
        this.m.setImageMatrix(matrix);
        if (this.u != null) {
            RectF b2 = b(matrix);
            if (b2 != null) {
                this.u.a(b2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        if (n()) {
            a(k());
        }
    }

    private RectF b(Matrix matrix) {
        Drawable drawable = this.m.getDrawable();
        if (drawable == null) {
            return null;
        }
        this.s.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        matrix.mapRect(this.s);
        return this.s;
    }

    private void a(Drawable drawable) {
        if (drawable != null) {
            float a2 = (float) a(this.m);
            float b2 = (float) b(this.m);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.p.reset();
            float f2 = (float) intrinsicWidth;
            float f3 = a2 / f2;
            float f4 = (float) intrinsicHeight;
            float f5 = b2 / f4;
            if (this.H == ImageView.ScaleType.CENTER) {
                this.p.postTranslate((a2 - f2) / 2.0f, (b2 - f4) / 2.0f);
            } else if (this.H == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f3, f5);
                this.p.postScale(max, max);
                this.p.postTranslate((a2 - (f2 * max)) / 2.0f, (b2 - (f4 * max)) / 2.0f);
            } else if (this.H == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f3, f5));
                this.p.postScale(min, min);
                this.p.postTranslate((a2 - (f2 * min)) / 2.0f, (b2 - (f4 * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f2, f4);
                RectF rectF2 = new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, a2, b2);
                if (((int) this.F) % 180 != 0) {
                    rectF = new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f4, f2);
                }
                int i2 = AnonymousClass4.f28537a[this.H.ordinal()];
                if (i2 == 1) {
                    this.p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                } else if (i2 == 2) {
                    this.p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else if (i2 == 3) {
                    this.p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                } else if (i2 == 4) {
                    this.p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            }
            l();
        }
    }

    /* renamed from: com.shopee.feeds.feedlibrary.view.b.l$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28537a = new int[ImageView.ScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28537a = r0
                int[] r0 = f28537a     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f28537a     // Catch:{ NoSuchFieldError -> 0x001f }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f28537a     // Catch:{ NoSuchFieldError -> 0x002a }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f28537a     // Catch:{ NoSuchFieldError -> 0x0035 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.view.b.l.AnonymousClass4.<clinit>():void");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean n() {
        /*
            r11 = this;
            android.graphics.Matrix r0 = r11.k()
            android.graphics.RectF r0 = r11.b((android.graphics.Matrix) r0)
            r1 = 0
            if (r0 != 0) goto L_0x000c
            return r1
        L_0x000c:
            float r2 = r0.height()
            float r3 = r0.width()
            android.widget.ImageView r4 = r11.m
            int r4 = r11.b((android.widget.ImageView) r4)
            float r4 = (float) r4
            r5 = 1073741824(0x40000000, float:2.0)
            r6 = 3
            r7 = 2
            r8 = 0
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 > 0) goto L_0x0040
            int[] r9 = com.shopee.feeds.feedlibrary.view.b.l.AnonymousClass4.f28537a
            android.widget.ImageView$ScaleType r10 = r11.H
            int r10 = r10.ordinal()
            r9 = r9[r10]
            if (r9 == r7) goto L_0x003d
            if (r9 == r6) goto L_0x0039
            float r4 = r4 - r2
            float r4 = r4 / r5
            float r2 = r0.top
        L_0x0036:
            float r2 = r4 - r2
            goto L_0x0054
        L_0x0039:
            float r4 = r4 - r2
            float r2 = r0.top
            goto L_0x0036
        L_0x003d:
            float r2 = r0.top
            goto L_0x0048
        L_0x0040:
            float r2 = r0.top
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 <= 0) goto L_0x004a
            float r2 = r0.top
        L_0x0048:
            float r2 = -r2
            goto L_0x0054
        L_0x004a:
            float r2 = r0.bottom
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0053
            float r2 = r0.bottom
            goto L_0x0036
        L_0x0053:
            r2 = 0
        L_0x0054:
            android.widget.ImageView r4 = r11.m
            int r4 = r11.a((android.widget.ImageView) r4)
            float r4 = (float) r4
            r9 = 1
            int r10 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r10 > 0) goto L_0x0080
            int[] r1 = com.shopee.feeds.feedlibrary.view.b.l.AnonymousClass4.f28537a
            android.widget.ImageView$ScaleType r8 = r11.H
            int r8 = r8.ordinal()
            r1 = r1[r8]
            if (r1 == r7) goto L_0x0079
            if (r1 == r6) goto L_0x0075
            float r4 = r4 - r3
            float r4 = r4 / r5
            float r0 = r0.left
        L_0x0072:
            float r4 = r4 - r0
            r8 = r4
            goto L_0x007d
        L_0x0075:
            float r4 = r4 - r3
            float r0 = r0.left
            goto L_0x0072
        L_0x0079:
            float r0 = r0.left
            float r0 = -r0
            r8 = r0
        L_0x007d:
            r11.E = r7
            goto L_0x009c
        L_0x0080:
            float r3 = r0.left
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x008c
            r11.E = r1
            float r0 = r0.left
            float r8 = -r0
            goto L_0x009c
        L_0x008c:
            float r1 = r0.right
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x0099
            float r0 = r0.right
            float r8 = r4 - r0
            r11.E = r9
            goto L_0x009c
        L_0x0099:
            r0 = -1
            r11.E = r0
        L_0x009c:
            android.graphics.Matrix r0 = r11.r
            r0.postTranslate(r8, r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.view.b.l.n():boolean");
    }

    /* access modifiers changed from: private */
    public int a(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    /* access modifiers changed from: private */
    public int b(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    private void o() {
        b bVar = this.D;
        if (bVar != null) {
            bVar.a();
            this.D = null;
        }
    }

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final float f28539b;

        /* renamed from: c  reason: collision with root package name */
        private final float f28540c;

        /* renamed from: d  reason: collision with root package name */
        private final long f28541d = System.currentTimeMillis();

        /* renamed from: e  reason: collision with root package name */
        private final float f28542e;

        /* renamed from: f  reason: collision with root package name */
        private final float f28543f;

        public a(float f2, float f3, float f4, float f5) {
            this.f28539b = f4;
            this.f28540c = f5;
            this.f28542e = f2;
            this.f28543f = f3;
        }

        public void run() {
            float a2 = a();
            float f2 = this.f28542e;
            l.this.I.a((f2 + ((this.f28543f - f2) * a2)) / l.this.e(), this.f28539b, this.f28540c);
            if (a2 < 1.0f) {
                a.a(l.this.m, this);
            }
        }

        private float a() {
            return l.this.f28532f.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f28541d)) * 1.0f) / ((float) l.this.f28533g)));
        }
    }

    private class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final OverScroller f28545b;

        /* renamed from: c  reason: collision with root package name */
        private int f28546c;

        /* renamed from: d  reason: collision with root package name */
        private int f28547d;

        public b(Context context) {
            this.f28545b = new OverScroller(context);
        }

        public void a() {
            this.f28545b.forceFinished(true);
        }

        public void a(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            RectF a2 = l.this.a();
            if (a2 != null) {
                int round = Math.round(-a2.left);
                float f2 = (float) i;
                if (f2 < a2.width()) {
                    i5 = Math.round(a2.width() - f2);
                    i6 = 0;
                } else {
                    i6 = round;
                    i5 = i6;
                }
                int round2 = Math.round(-a2.top);
                float f3 = (float) i2;
                if (f3 < a2.height()) {
                    i7 = Math.round(a2.height() - f3);
                    i8 = 0;
                } else {
                    i8 = round2;
                    i7 = i8;
                }
                this.f28546c = round;
                this.f28547d = round2;
                if (round != i5 || round2 != i7) {
                    this.f28545b.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        public void run() {
            if (!this.f28545b.isFinished() && this.f28545b.computeScrollOffset()) {
                int currX = this.f28545b.getCurrX();
                int currY = this.f28545b.getCurrY();
                l.this.r.postTranslate((float) (this.f28546c - currX), (float) (this.f28547d - currY));
                l.this.m();
                this.f28546c = currX;
                this.f28547d = currY;
                a.a(l.this.m, this);
            }
        }
    }
}
