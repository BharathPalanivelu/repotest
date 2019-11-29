package com.otaliastudios.cameraview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.otaliastudios.cameraview.ab;
import com.otaliastudios.cameraview.i;

class ai extends i<View, SurfaceHolder> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final g f15541b = g.a(ai.class.getSimpleName());

    /* renamed from: c  reason: collision with root package name */
    private SurfaceView f15542c;

    /* access modifiers changed from: protected */
    public void a(float f2, float f3) {
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return false;
    }

    ai(Context context, ViewGroup viewGroup, i.a aVar) {
        super(context, viewGroup, aVar);
    }

    /* access modifiers changed from: protected */
    public View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(ab.b.cameraview_surface_view, viewGroup, false);
        viewGroup.addView(inflate, 0);
        this.f15542c = (SurfaceView) inflate.findViewById(ab.a.surface_view);
        SurfaceHolder holder = this.f15542c.getHolder();
        holder.setType(3);
        holder.addCallback(new SurfaceHolder.Callback() {

            /* renamed from: b  reason: collision with root package name */
            private boolean f15544b = true;

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                ai.f15541b.b("callback:", "surfaceCreated");
            }

            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                ai.f15541b.b("callback:", "surfaceChanged", "w:", Integer.valueOf(i2), "h:", Integer.valueOf(i3), "firstTime:", Boolean.valueOf(this.f15544b));
                if (this.f15544b) {
                    ai.this.b(i2, i3);
                    this.f15544b = false;
                    return;
                }
                ai.this.c(i2, i3);
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                ai.f15541b.b("callback:", "surfaceDestroyed");
                ai.this.e();
                this.f15544b = true;
            }
        });
        return inflate.findViewById(ab.a.surface_view_root);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public SurfaceHolder c() {
        return this.f15542c.getHolder();
    }

    /* access modifiers changed from: package-private */
    public Class<SurfaceHolder> b() {
        return SurfaceHolder.class;
    }
}
