package com.shopee.scanner.camera;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.shopee.scanner.c;

class h extends e {

    /* renamed from: a  reason: collision with root package name */
    private final TextureView f30316a;

    /* renamed from: b  reason: collision with root package name */
    private int f30317b;

    h(Context context, ViewGroup viewGroup) {
        this.f30316a = (TextureView) View.inflate(context, c.C0466c.texture_view, viewGroup).findViewById(c.b.texture_view);
        this.f30316a.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                h.this.a(i, i2);
                h.this.g();
                h.this.c();
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                h.this.a(i, i2);
                h.this.g();
                h.this.c();
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                h.this.a(0, 0);
                return true;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public SurfaceTexture d() {
        return this.f30316a.getSurfaceTexture();
    }

    /* access modifiers changed from: package-private */
    public View a() {
        return this.f30316a;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f30316a.getSurfaceTexture() != null;
    }

    /* access modifiers changed from: private */
    public void g() {
        Matrix matrix = new Matrix();
        int i = this.f30317b;
        if (i % 180 == 90) {
            float e2 = (float) e();
            float f2 = (float) f();
            matrix.setPolyToPoly(new float[]{0.0f, 0.0f, e2, 0.0f, 0.0f, f2, e2, f2}, 0, this.f30317b == 90 ? new float[]{0.0f, f2, 0.0f, 0.0f, e2, f2, e2, 0.0f} : new float[]{e2, 0.0f, e2, f2, 0.0f, 0.0f, 0.0f, f2}, 0, 4);
        } else if (i == 180) {
            matrix.postRotate(180.0f, (float) (e() / 2), (float) (f() / 2));
        }
        this.f30316a.setTransform(matrix);
    }
}
