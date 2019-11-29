package com.salesforce.android.service.common.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import com.salesforce.android.service.common.ui.R;
import d.d.b.j;

public final class SalesforceConnectionBanner extends TextView {
    public static final double BANNER_HEIGHT_PERCENTAGE = 0.8d;
    public static final Companion Companion = new Companion((g) null);
    private long animationDuration;
    private Handler animationHandler;
    private long connectedAnimationDelay;
    private boolean connectedState;
    private long disconnectedAnimationDelay;

    public final boolean getConnectedState() {
        return this.connectedState;
    }

    public final void setConnectedState(boolean z) {
        this.connectedState = z;
    }

    public final long getConnectedAnimationDelay() {
        return this.connectedAnimationDelay;
    }

    public final void setConnectedAnimationDelay(long j) {
        this.connectedAnimationDelay = j;
    }

    public final long getDisconnectedAnimationDelay() {
        return this.disconnectedAnimationDelay;
    }

    public final void setDisconnectedAnimationDelay(long j) {
        this.disconnectedAnimationDelay = j;
    }

    public final long getAnimationDuration() {
        return this.animationDuration;
    }

    public final void setAnimationDuration(long j) {
        this.animationDuration = j;
    }

    public final Handler getAnimationHandler() {
        return this.animationHandler;
    }

    public final void setAnimationHandler(Handler handler) {
        j.b(handler, "<set-?>");
        this.animationHandler = handler;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SalesforceConnectionBanner(Context context) {
        this(context, (AttributeSet) null);
        j.b(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SalesforceConnectionBanner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        j.b(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SalesforceConnectionBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
        j.b(context, "context");
        this.connectedState = true;
        this.connectedAnimationDelay = 3000;
        this.animationDuration = 250;
        this.animationHandler = new Handler();
    }

    public final void toggleDisplay(boolean z) {
        int i;
        int i2;
        this.connectedState = z;
        if (z) {
            i = R.string.chat_connection_banner_connected_text;
        } else {
            i = R.string.chat_connection_banner_disconnected_text;
        }
        if (z) {
            i2 = getResources().getColor(R.color.salesforce_brand_secondary);
        } else {
            i2 = getResources().getColor(R.color.salesforce_contrast_secondary);
        }
        long j = z ? this.connectedAnimationDelay : this.disconnectedAnimationDelay;
        setText(getResources().getString(i));
        setBackgroundColor(i2);
        this.animationHandler.postDelayed(new SalesforceConnectionBanner$toggleDisplay$1(this, z), j);
    }

    /* access modifiers changed from: private */
    public final int getBannerHeight() {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new TypedValue().data, new int[]{16843499});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        obtainStyledAttributes.recycle();
        double d2 = (double) dimensionPixelSize;
        Double.isNaN(d2);
        return (int) (d2 * 0.8d);
    }
}
