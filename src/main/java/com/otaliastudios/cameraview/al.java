package com.otaliastudios.cameraview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.otaliastudios.cameraview.ab;
import com.otaliastudios.cameraview.i;

class al extends i<TextureView, SurfaceTexture> {
    al(Context context, ViewGroup viewGroup, i.a aVar) {
        super(context, viewGroup, aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public TextureView a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(ab.b.cameraview_texture_view, viewGroup, false);
        viewGroup.addView(inflate, 0);
        TextureView textureView = (TextureView) inflate.findViewById(ab.a.texture_view);
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                al.this.b(i, i2);
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                al.this.c(i, i2);
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                al.this.e();
                return true;
            }
        });
        return textureView;
    }

    /* access modifiers changed from: package-private */
    public Class<SurfaceTexture> b() {
        return SurfaceTexture.class;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public SurfaceTexture c() {
        return ((TextureView) a()).getSurfaceTexture();
    }

    /* access modifiers changed from: package-private */
    @TargetApi(15)
    public void a(int i, int i2) {
        super.a(i, i2);
        if (((TextureView) a()).getSurfaceTexture() != null) {
            ((TextureView) a()).getSurfaceTexture().setDefaultBufferSize(i, i2);
        }
    }
}
