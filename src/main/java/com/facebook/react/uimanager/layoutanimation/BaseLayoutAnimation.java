package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

abstract class BaseLayoutAnimation extends AbstractLayoutAnimation {
    /* access modifiers changed from: package-private */
    public abstract boolean isReverse();

    BaseLayoutAnimation() {
    }

    /* access modifiers changed from: package-private */
    public boolean isValid() {
        return this.mDurationMs > 0 && this.mAnimatedProperty != null;
    }

    /* renamed from: com.facebook.react.uimanager.layoutanimation.BaseLayoutAnimation$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType = new int[AnimatedPropertyType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType[] r0 = com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType = r0
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType r1 = com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType.OPACITY     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType     // Catch:{ NoSuchFieldError -> 0x001f }
                com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType r1 = com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType.SCALE_XY     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType     // Catch:{ NoSuchFieldError -> 0x002a }
                com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType r1 = com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType.SCALE_X     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType r1 = com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType.SCALE_Y     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.layoutanimation.BaseLayoutAnimation.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public Animation createAnimationImpl(View view, int i, int i2, int i3, int i4) {
        if (this.mAnimatedProperty != null) {
            int i5 = AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType[this.mAnimatedProperty.ordinal()];
            float f2 = BitmapDescriptorFactory.HUE_RED;
            if (i5 == 1) {
                float alpha = isReverse() ? view.getAlpha() : BitmapDescriptorFactory.HUE_RED;
                if (!isReverse()) {
                    f2 = view.getAlpha();
                }
                return new OpacityAnimation(view, alpha, f2);
            } else if (i5 == 2) {
                float f3 = isReverse() ? 1.0f : BitmapDescriptorFactory.HUE_RED;
                float f4 = isReverse() ? BitmapDescriptorFactory.HUE_RED : 1.0f;
                return new ScaleAnimation(f3, f4, f3, f4, 1, 0.5f, 1, 0.5f);
            } else if (i5 == 3) {
                return new ScaleAnimation(isReverse() ? 1.0f : BitmapDescriptorFactory.HUE_RED, isReverse() ? BitmapDescriptorFactory.HUE_RED : 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, BitmapDescriptorFactory.HUE_RED);
            } else if (i5 == 4) {
                return new ScaleAnimation(1.0f, 1.0f, isReverse() ? 1.0f : BitmapDescriptorFactory.HUE_RED, isReverse() ? BitmapDescriptorFactory.HUE_RED : 1.0f, 1, BitmapDescriptorFactory.HUE_RED, 1, 0.5f);
            } else {
                throw new IllegalViewOperationException("Missing animation for property : " + this.mAnimatedProperty);
            }
        } else {
            throw new IllegalViewOperationException("Missing animated property from animation config");
        }
    }
}
