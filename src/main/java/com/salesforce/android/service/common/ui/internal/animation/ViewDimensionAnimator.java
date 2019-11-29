package com.salesforce.android.service.common.ui.internal.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import d.d.b.j;

public final class ViewDimensionAnimator extends Animation {
    private final int fromDimension;
    private final int toDimension;
    private final Type type;
    private final View view;

    public enum Type {
        WIDTH,
        HEIGHT
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Type.values().length];

        static {
            $EnumSwitchMapping$0[Type.WIDTH.ordinal()] = 1;
            $EnumSwitchMapping$0[Type.HEIGHT.ordinal()] = 2;
        }
    }

    public ViewDimensionAnimator(int i, View view2, Type type2, long j) {
        j.b(view2, "view");
        j.b(type2, "type");
        this.toDimension = i;
        this.view = view2;
        this.type = type2;
        this.fromDimension = this.type == Type.WIDTH ? this.view.getLayoutParams().width : this.view.getLayoutParams().height;
        setDuration(j);
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f2, Transformation transformation) {
        j.b(transformation, "t");
        int i = this.fromDimension;
        int i2 = i + ((int) (((float) (this.toDimension - i)) * f2));
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (i3 == 1) {
            this.view.getLayoutParams().width = i2;
        } else if (i3 == 2) {
            this.view.getLayoutParams().height = i2;
        }
        this.view.requestLayout();
    }
}
