package com.shopee.feeds.feedlibrary.editor.tag;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.garena.android.appkit.tools.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.editor.b.c;
import com.shopee.feeds.feedlibrary.util.j;
import java.util.UUID;

public class d extends c implements View.OnClickListener {
    /* access modifiers changed from: private */
    public FrameLayout i;
    /* access modifiers changed from: private */
    public View j;
    /* access modifiers changed from: private */
    public FrameLayout k;
    /* access modifiers changed from: private */
    public FrameLayout l;
    private ImageView m;
    private ImageView n;
    /* access modifiers changed from: private */
    public boolean o;
    /* access modifiers changed from: private */
    public boolean p;
    /* access modifiers changed from: private */
    public float q;
    /* access modifiers changed from: private */
    public float r;
    /* access modifiers changed from: private */
    public float s;
    private float t;
    /* access modifiers changed from: private */
    public boolean u;
    private String v;

    public d(Context context, boolean z) {
        this(context);
        this.p = z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.u = false;
            j.a().a(getViewId(), false);
        }
        return super.onTouchEvent(motionEvent);
    }

    public d(Context context) {
        this(context, (AttributeSet) null);
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.p = true;
        this.u = false;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        if (layoutInflater != null) {
            View inflate = layoutInflater.inflate(c.f.feeds_layout_tag, this, true);
            this.v = UUID.randomUUID().toString();
            this.q = (float) (b.d(c.C0424c.feeds_tag_margin) + b.d(c.C0424c.feeds_tag_bg_padding));
            this.r = (float) b.d(c.C0424c.feeds_tag_triangle_width);
            this.s = (float) b.d(c.C0424c.feeds_tag_triangle_height);
            this.t = (float) b.d(c.C0424c.feeds_tag_delete_btn_padding);
            this.k = (FrameLayout) inflate.findViewById(c.e.fl_top);
            this.l = (FrameLayout) inflate.findViewById(c.e.fl_bottom);
            this.i = (FrameLayout) inflate.findViewById(c.e.container);
            this.m = (ImageView) inflate.findViewById(c.e.iv_delete_left);
            this.n = (ImageView) inflate.findViewById(c.e.iv_delete_right);
            if (this.p) {
                this.m.setOnClickListener(this);
                this.n.setOnClickListener(this);
            }
            int i3 = 8;
            this.k.setVisibility(this.o ? 8 : 0);
            this.l.setVisibility(this.o ? 0 : i3);
            this.f27921e = new androidx.core.g.c(context, new GestureDetector.SimpleOnGestureListener() {

                /* renamed from: b  reason: collision with root package name */
                private boolean f28026b;

                /* renamed from: c  reason: collision with root package name */
                private float f28027c;

                /* renamed from: d  reason: collision with root package name */
                private float f28028d;

                /* renamed from: e  reason: collision with root package name */
                private boolean f28029e;

                public boolean onDown(MotionEvent motionEvent) {
                    if (d.this.f27922f != null) {
                        d.this.f27922f.a();
                    }
                    if (j.a().g(d.this.getViewId())) {
                        return true;
                    }
                    j.a().a(d.this.getViewId(), true);
                    boolean unused = d.this.u = true;
                    float unused2 = d.this.f27917a = motionEvent.getX();
                    float unused3 = d.this.f27918b = motionEvent.getY();
                    float unused4 = d.this.f27919c = (motionEvent.getRawX() - motionEvent.getX()) - d.this.getX();
                    float unused5 = d.this.f27920d = (motionEvent.getRawY() - motionEvent.getY()) - d.this.getY();
                    this.f28027c = d.this.k.getTranslationX();
                    this.f28028d = motionEvent.getRawX();
                    this.f28026b = this.f28027c != BitmapDescriptorFactory.HUE_RED;
                    this.f28029e = d.this.o;
                    return true;
                }

                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    return super.onFling(motionEvent, motionEvent2, f2, f3);
                }

                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    if (d.this.f27922f != null) {
                        d.this.f27922f.c();
                        if ((d.this.j instanceof e) && d.this.p) {
                            d dVar = d.this;
                            dVar.b(!dVar.b());
                        }
                    }
                    d.this.a();
                    return true;
                }

                /* JADX WARNING: Removed duplicated region for block: B:52:0x024e  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public boolean onScroll(android.view.MotionEvent r7, android.view.MotionEvent r8, float r9, float r10) {
                    /*
                        r6 = this;
                        com.shopee.feeds.feedlibrary.editor.tag.d r7 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        boolean r7 = r7.u
                        r9 = 1
                        if (r7 != 0) goto L_0x001a
                        com.shopee.feeds.feedlibrary.util.j r7 = com.shopee.feeds.feedlibrary.util.j.a()
                        com.shopee.feeds.feedlibrary.editor.tag.d r10 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        java.lang.String r10 = r10.getViewId()
                        boolean r7 = r7.g((java.lang.String) r10)
                        if (r7 == 0) goto L_0x001a
                        return r9
                    L_0x001a:
                        boolean r7 = r6.f28026b
                        r10 = 0
                        r0 = 0
                        r1 = 1073741824(0x40000000, float:2.0)
                        if (r7 == 0) goto L_0x00c8
                        com.shopee.feeds.feedlibrary.editor.tag.d r7 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r2 = r8.getX()
                        float unused = r7.f27917a = r2
                        com.shopee.feeds.feedlibrary.editor.tag.d r7 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r2 = r8.getRawX()
                        float r3 = r8.getX()
                        float r2 = r2 - r3
                        com.shopee.feeds.feedlibrary.editor.tag.d r3 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r3 = r3.getX()
                        float r2 = r2 - r3
                        float unused = r7.f27919c = r2
                        float r7 = r6.f28027c
                        int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                        if (r2 >= 0) goto L_0x0086
                        float r7 = r8.getRawX()
                        float r2 = r6.f28028d
                        float r7 = r7 - r2
                        float r2 = r6.f28027c
                        float r7 = r7 + r2
                        float r2 = java.lang.Math.min(r7, r0)
                        com.shopee.feeds.feedlibrary.editor.tag.d r3 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        android.widget.FrameLayout r3 = r3.i
                        int r3 = r3.getMeasuredWidth()
                        float r3 = (float) r3
                        float r3 = -r3
                        float r3 = r3 / r1
                        com.shopee.feeds.feedlibrary.editor.tag.d r4 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r4 = r4.r
                        float r4 = r4 / r1
                        float r3 = r3 + r4
                        float r2 = java.lang.Math.max(r2, r3)
                        com.shopee.feeds.feedlibrary.editor.tag.d r3 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        android.widget.FrameLayout r3 = r3.k
                        r3.setTranslationX(r2)
                        com.shopee.feeds.feedlibrary.editor.tag.d r3 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        android.widget.FrameLayout r3 = r3.l
                        r3.setTranslationX(r2)
                        int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                        if (r7 < 0) goto L_0x00c8
                        r6.f28026b = r10
                        goto L_0x00c8
                    L_0x0086:
                        int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                        if (r7 <= 0) goto L_0x00c8
                        float r7 = r8.getRawX()
                        float r2 = r6.f28028d
                        float r7 = r7 - r2
                        float r2 = r6.f28027c
                        float r7 = r7 + r2
                        float r2 = java.lang.Math.max(r0, r7)
                        com.shopee.feeds.feedlibrary.editor.tag.d r3 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        android.widget.FrameLayout r3 = r3.i
                        int r3 = r3.getMeasuredWidth()
                        float r3 = (float) r3
                        float r3 = r3 / r1
                        com.shopee.feeds.feedlibrary.editor.tag.d r4 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r4 = r4.r
                        float r4 = r4 / r1
                        float r3 = r3 - r4
                        float r2 = java.lang.Math.min(r2, r3)
                        com.shopee.feeds.feedlibrary.editor.tag.d r3 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        android.widget.FrameLayout r3 = r3.k
                        r3.setTranslationX(r2)
                        com.shopee.feeds.feedlibrary.editor.tag.d r3 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        android.widget.FrameLayout r3 = r3.l
                        r3.setTranslationX(r2)
                        int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                        if (r7 > 0) goto L_0x00c8
                        r6.f28026b = r10
                    L_0x00c8:
                        float r7 = r8.getRawX()
                        com.shopee.feeds.feedlibrary.editor.tag.d r2 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r2 = r2.f27917a
                        float r7 = r7 - r2
                        com.shopee.feeds.feedlibrary.editor.tag.d r2 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r2 = r2.f27919c
                        float r7 = r7 - r2
                        float r8 = r8.getRawY()
                        com.shopee.feeds.feedlibrary.editor.tag.d r2 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r2 = r2.f27918b
                        float r8 = r8 - r2
                        com.shopee.feeds.feedlibrary.editor.tag.d r2 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r2 = r2.f27920d
                        float r8 = r8 - r2
                        com.shopee.feeds.feedlibrary.editor.tag.d r2 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r2 = r2.q
                        float r2 = -r2
                        com.shopee.feeds.feedlibrary.editor.tag.d r3 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        com.shopee.feeds.feedlibrary.editor.b.b r3 = r3.f27923g
                        float r3 = r3.e()
                        com.shopee.feeds.feedlibrary.editor.tag.d r4 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        int r4 = r4.getMeasuredWidth()
                        float r4 = (float) r4
                        float r3 = r3 - r4
                        com.shopee.feeds.feedlibrary.editor.tag.d r4 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r4 = r4.q
                        float r3 = r3 + r4
                        int r4 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                        if (r4 > 0) goto L_0x0142
                        float r7 = r7 - r2
                        com.shopee.feeds.feedlibrary.editor.tag.d r0 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        android.widget.FrameLayout r0 = r0.i
                        int r0 = r0.getMeasuredWidth()
                        float r0 = (float) r0
                        float r0 = r0 / r1
                        com.shopee.feeds.feedlibrary.editor.tag.d r3 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r3 = r3.r
                        float r3 = r3 / r1
                        float r0 = r0 - r3
                        float r0 = -r0
                        float r7 = java.lang.Math.max(r7, r0)
                        boolean r0 = r6.f28026b
                        if (r0 != 0) goto L_0x0140
                        com.shopee.feeds.feedlibrary.editor.tag.d r0 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        android.widget.FrameLayout r0 = r0.k
                        r0.setTranslationX(r7)
                        com.shopee.feeds.feedlibrary.editor.tag.d r0 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        android.widget.FrameLayout r0 = r0.l
                        r0.setTranslationX(r7)
                    L_0x0140:
                        r7 = r2
                        goto L_0x018d
                    L_0x0142:
                        int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
                        if (r2 < 0) goto L_0x0177
                        float r7 = r7 - r3
                        com.shopee.feeds.feedlibrary.editor.tag.d r0 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        android.widget.FrameLayout r0 = r0.i
                        int r0 = r0.getMeasuredWidth()
                        float r0 = (float) r0
                        float r0 = r0 / r1
                        com.shopee.feeds.feedlibrary.editor.tag.d r2 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r2 = r2.r
                        float r2 = r2 / r1
                        float r0 = r0 - r2
                        float r7 = java.lang.Math.min(r7, r0)
                        boolean r0 = r6.f28026b
                        if (r0 != 0) goto L_0x0175
                        com.shopee.feeds.feedlibrary.editor.tag.d r0 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        android.widget.FrameLayout r0 = r0.k
                        r0.setTranslationX(r7)
                        com.shopee.feeds.feedlibrary.editor.tag.d r0 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        android.widget.FrameLayout r0 = r0.l
                        r0.setTranslationX(r7)
                    L_0x0175:
                        r7 = r3
                        goto L_0x018d
                    L_0x0177:
                        boolean r2 = r6.f28026b
                        if (r2 != 0) goto L_0x018d
                        com.shopee.feeds.feedlibrary.editor.tag.d r2 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        android.widget.FrameLayout r2 = r2.k
                        r2.setTranslationX(r0)
                        com.shopee.feeds.feedlibrary.editor.tag.d r2 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        android.widget.FrameLayout r2 = r2.l
                        r2.setTranslationX(r0)
                    L_0x018d:
                        com.shopee.feeds.feedlibrary.editor.tag.d r0 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r0 = r0.q
                        float r0 = -r0
                        com.shopee.feeds.feedlibrary.editor.tag.d r2 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r2 = r2.s
                        float r0 = r0 + r2
                        com.shopee.feeds.feedlibrary.editor.tag.d r2 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        com.shopee.feeds.feedlibrary.editor.b.b r2 = r2.f27923g
                        float r2 = r2.f()
                        com.shopee.feeds.feedlibrary.editor.tag.d r3 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        int r3 = r3.getMeasuredHeight()
                        float r3 = (float) r3
                        float r2 = r2 - r3
                        com.shopee.feeds.feedlibrary.editor.tag.d r3 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r3 = r3.q
                        float r2 = r2 + r3
                        com.shopee.feeds.feedlibrary.editor.tag.d r3 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        com.shopee.feeds.feedlibrary.editor.b.b r3 = r3.f27923g
                        float r3 = r3.f()
                        com.shopee.feeds.feedlibrary.editor.tag.d r4 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        android.widget.FrameLayout r4 = r4.i
                        int r4 = r4.getMeasuredHeight()
                        float r4 = (float) r4
                        com.shopee.feeds.feedlibrary.editor.tag.d r5 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r5 = r5.s
                        float r4 = r4 + r5
                        float r4 = r4 * r1
                        float r3 = r3 - r4
                        com.shopee.feeds.feedlibrary.editor.tag.d r1 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r1 = r1.q
                        float r3 = r3 - r1
                        com.shopee.feeds.feedlibrary.editor.tag.d r1 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        android.widget.FrameLayout r1 = r1.l
                        int r1 = r1.getVisibility()
                        r4 = 8
                        if (r1 != r4) goto L_0x0210
                        int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                        if (r1 >= 0) goto L_0x01ee
                        r8 = r0
                        goto L_0x0233
                    L_0x01ee:
                        int r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                        if (r0 <= 0) goto L_0x020a
                        com.shopee.feeds.feedlibrary.editor.tag.d r10 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        r10.a((boolean) r9)
                        com.shopee.feeds.feedlibrary.editor.tag.d r10 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r10 = r10.s
                        float r10 = r2 - r10
                        int r10 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                        if (r10 <= 0) goto L_0x0233
                        com.shopee.feeds.feedlibrary.editor.tag.d r8 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r8 = r8.s
                        goto L_0x0231
                    L_0x020a:
                        com.shopee.feeds.feedlibrary.editor.tag.d r0 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        r0.a((boolean) r10)
                        goto L_0x0233
                    L_0x0210:
                        int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                        if (r0 >= 0) goto L_0x021a
                        com.shopee.feeds.feedlibrary.editor.tag.d r0 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        r0.a((boolean) r10)
                        goto L_0x0233
                    L_0x021a:
                        com.shopee.feeds.feedlibrary.editor.tag.d r10 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        r10.a((boolean) r9)
                        com.shopee.feeds.feedlibrary.editor.tag.d r10 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r10 = r10.s
                        float r10 = r2 - r10
                        int r10 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                        if (r10 <= 0) goto L_0x0233
                        com.shopee.feeds.feedlibrary.editor.tag.d r8 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        float r8 = r8.s
                    L_0x0231:
                        float r8 = r2 - r8
                    L_0x0233:
                        com.shopee.feeds.feedlibrary.editor.tag.d r10 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        r10.setX(r7)
                        com.shopee.feeds.feedlibrary.editor.tag.d r7 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        r7.setY(r8)
                        com.shopee.feeds.feedlibrary.editor.tag.d r7 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        boolean r8 = r7.b()
                        r7.b((boolean) r8)
                        com.shopee.feeds.feedlibrary.editor.tag.d r7 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        com.shopee.feeds.feedlibrary.editor.b.c$a r7 = r7.f27922f
                        if (r7 == 0) goto L_0x0257
                        com.shopee.feeds.feedlibrary.editor.tag.d r7 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        com.shopee.feeds.feedlibrary.editor.b.c$a r7 = r7.f27922f
                        r7.d()
                    L_0x0257:
                        com.shopee.feeds.feedlibrary.editor.tag.d r7 = com.shopee.feeds.feedlibrary.editor.tag.d.this
                        r7.a()
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.editor.tag.d.AnonymousClass1.onScroll(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
                }

                public void onLongPress(MotionEvent motionEvent) {
                    super.onLongPress(motionEvent);
                }
            });
            ViewGroup viewGroup = (ViewGroup) inflate;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            if (Build.VERSION.SDK_INT >= 21) {
                setTranslationZ(2.5f);
            }
        }
    }

    public void onClick(View view) {
        if ((this.j instanceof e) && this.f27922f != null) {
            this.f27922f.a(this.f27923g);
        }
    }

    public void a(boolean z) {
        this.o = z;
        int i2 = 8;
        this.k.setVisibility(z ? 8 : 0);
        FrameLayout frameLayout = this.l;
        if (z) {
            i2 = 0;
        }
        frameLayout.setVisibility(i2);
    }

    public void setTriangleTransition(float f2) {
        this.k.setTranslationX(f2);
        this.l.setTranslationX(f2);
    }

    public String getViewId() {
        return this.v;
    }

    public void setContainer(View view) {
        this.j = view;
        this.i.removeAllViews();
        this.i.addView(view);
        requestLayout();
        invalidate();
    }

    public View getContentView() {
        return this.j;
    }

    public float getTriangleWidth() {
        return this.r;
    }

    public float getTriangleHeight() {
        return this.s;
    }

    public float getTagMargin() {
        return this.q;
    }

    public float getContainerWidth() {
        return ((float) getMeasuredWidth()) - (getTagMargin() * 2.0f);
    }

    public float getContainerHeight() {
        return ((float) getMeasuredHeight()) - (getTagMargin() * 2.0f);
    }

    public void a() {
        float f2;
        float x = getX() + (((float) getMeasuredWidth()) / 2.0f) + (this.o ? this.l : this.k).getTranslationX();
        if (this.o) {
            f2 = getY() + this.q + ((float) this.i.getMeasuredHeight()) + this.s;
        } else {
            f2 = (((getY() + ((float) getMeasuredHeight())) - ((float) this.i.getMeasuredHeight())) - this.s) - this.q;
        }
        getGestureListener().a(getViewTag(), x, f2);
    }

    public void b(boolean z) {
        if (!z) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
        } else if (getX() + ((float) getMeasuredWidth()) > this.f27923g.e() + this.t) {
            this.n.setVisibility(8);
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
            this.n.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public boolean b() {
        return this.m.getVisibility() == 0 || this.n.getVisibility() == 0;
    }
}
