package com.shopee.app.react.view.effectimage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.react.views.image.GlobalImageLoadListener;
import com.facebook.react.views.image.ReactImageView;
import java.util.ArrayList;
import java.util.List;

public class a extends ReactImageView {

    /* renamed from: a  reason: collision with root package name */
    private List<BasePostprocessor> f19031a = new ArrayList();

    public a(Context context, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, Object obj) {
        super(context, abstractDraweeControllerBuilder, (GlobalImageLoadListener) null, obj);
    }

    public void a(int i, float f2) {
        try {
            int red = Color.red(i);
            float f3 = (float) red;
            float green = (float) Color.green(i);
            float blue = (float) Color.blue(i);
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.postConcat(RNEffectImageViewManager.GRAYSCALE_MATRIX);
            colorMatrix.postConcat(new ColorMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, f3 * (f3 / 255.0f) * f2, 0.0f, 1.0f, 0.0f, 0.0f, green * (green / 255.0f) * f2, 0.0f, 0.0f, 1.0f, 0.0f, blue * (blue / 255.0f) * f2, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
            setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}
