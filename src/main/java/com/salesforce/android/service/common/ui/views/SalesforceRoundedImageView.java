package com.salesforce.android.service.common.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.salesforce.android.service.common.ui.R;
import java.util.HashMap;
import java.util.Map;

public class SalesforceRoundedImageView extends AppCompatImageView {
    private int mBackgroundColor;
    private Path mClipPath;
    private float mCornerRadius;
    private CornerType mCornerType;
    private boolean mIsClipPathSet;
    private RectF mRectF;

    public SalesforceRoundedImageView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public SalesforceRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SalesforceRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRectF = new RectF();
        this.mClipPath = new Path();
        this.mIsClipPathSet = false;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SalesforceRoundedImageView, R.attr.salesforce_corner_radius, 0);
        this.mCornerRadius = obtainStyledAttributes.getDimension(R.styleable.SalesforceRoundedImageView_salesforce_corner_radius, BitmapDescriptorFactory.HUE_RED);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SalesforceRoundedImageView, 0, 0);
        if (obtainStyledAttributes2.hasValue(R.styleable.SalesforceRoundedImageView_salesforce_round_top_bottom)) {
            this.mCornerType = CornerType.valueOf(obtainStyledAttributes2.getInt(R.styleable.SalesforceRoundedImageView_salesforce_round_top_bottom, 0));
        } else {
            this.mCornerType = CornerType.TOP_ONLY;
        }
        obtainStyledAttributes2.recycle();
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int height = getHeight();
        int i = AnonymousClass1.$SwitchMap$com$salesforce$android$service$common$ui$views$SalesforceRoundedImageView$CornerType[this.mCornerType.ordinal()];
        int i2 = 0;
        if (i == 1) {
            height = (int) (((float) height) + this.mCornerRadius);
        } else if (i == 2) {
            float f2 = this.mCornerRadius;
            height = (int) (((float) height) + f2);
            i2 = (int) (((float) 0) - f2);
        }
        RectF rectF = this.mRectF;
        rectF.left = BitmapDescriptorFactory.HUE_RED;
        rectF.top = (float) i2;
        rectF.right = (float) getWidth();
        RectF rectF2 = this.mRectF;
        rectF2.bottom = (float) height;
        if (!this.mIsClipPathSet) {
            this.mIsClipPathSet = true;
            Path path = this.mClipPath;
            float f3 = this.mCornerRadius;
            path.addRoundRect(rectF2, f3, f3, Path.Direction.CW);
        }
        canvas.clipPath(this.mClipPath);
        canvas.drawColor(this.mBackgroundColor);
        super.onDraw(canvas);
    }

    /* renamed from: com.salesforce.android.service.common.ui.views.SalesforceRoundedImageView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$salesforce$android$service$common$ui$views$SalesforceRoundedImageView$CornerType = new int[CornerType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.salesforce.android.service.common.ui.views.SalesforceRoundedImageView$CornerType[] r0 = com.salesforce.android.service.common.ui.views.SalesforceRoundedImageView.CornerType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$salesforce$android$service$common$ui$views$SalesforceRoundedImageView$CornerType = r0
                int[] r0 = $SwitchMap$com$salesforce$android$service$common$ui$views$SalesforceRoundedImageView$CornerType     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.salesforce.android.service.common.ui.views.SalesforceRoundedImageView$CornerType r1 = com.salesforce.android.service.common.ui.views.SalesforceRoundedImageView.CornerType.TOP_ONLY     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$salesforce$android$service$common$ui$views$SalesforceRoundedImageView$CornerType     // Catch:{ NoSuchFieldError -> 0x001f }
                com.salesforce.android.service.common.ui.views.SalesforceRoundedImageView$CornerType r1 = com.salesforce.android.service.common.ui.views.SalesforceRoundedImageView.CornerType.BOTTOM_ONLY     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.android.service.common.ui.views.SalesforceRoundedImageView.AnonymousClass1.<clinit>():void");
        }
    }

    public enum CornerType {
        TOP_ONLY(0),
        BOTTOM_ONLY(1),
        TOP_AND_BOTTOM(2);
        
        private static Map<Integer, CornerType> map;
        private int value;

        static {
            int i;
            map = new HashMap();
            for (CornerType cornerType : values()) {
                map.put(Integer.valueOf(cornerType.value), cornerType);
            }
        }

        private CornerType(int i) {
            this.value = i;
        }

        public static CornerType valueOf(int i) {
            return map.get(Integer.valueOf(i));
        }

        public int getValue() {
            return this.value;
        }
    }
}
