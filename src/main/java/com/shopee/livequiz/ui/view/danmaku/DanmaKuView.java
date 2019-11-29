package com.shopee.livequiz.ui.view.danmaku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class DanmaKuView extends RecyclerView {
    /* access modifiers changed from: private */
    public Paint M;
    /* access modifiers changed from: private */
    public int N;
    private RecyclerView.h O;
    private boolean P;

    public DanmaKuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DanmaKuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DanmaKuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.M = new Paint();
        final PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        final LinearGradient linearGradient = new LinearGradient(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 160.0f, new int[]{0, -16777216}, (float[]) null, Shader.TileMode.CLAMP);
        this.O = new RecyclerView.h() {
            public void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.t tVar) {
                super.b(canvas, recyclerView, tVar);
                int unused = DanmaKuView.this.N = canvas.saveLayer(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) recyclerView.getWidth(), (float) recyclerView.getHeight(), DanmaKuView.this.M, 31);
            }

            public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.t tVar) {
                super.a(canvas, recyclerView, tVar);
                DanmaKuView.this.M.setXfermode(porterDuffXfermode);
                DanmaKuView.this.M.setShader(linearGradient);
                canvas.drawRect(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) recyclerView.getRight(), 160.0f, DanmaKuView.this.M);
                DanmaKuView.this.M.setXfermode((Xfermode) null);
                canvas.restoreToCount(DanmaKuView.this.N);
            }

            public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t tVar) {
                super.a(rect, view, recyclerView, tVar);
            }
        };
    }

    public void y() {
        if (!this.P) {
            this.P = true;
            a(this.O);
        }
    }
}
