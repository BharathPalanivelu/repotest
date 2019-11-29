package com.shopee.app.upload;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.shopee.app.ui.common.aa;

public class UploadPopupView extends FrameLayout {
    aa mProgressView;

    public UploadPopupView(Context context) {
        super(context);
    }

    public UploadPopupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UploadPopupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: package-private */
    public void onViewInit() {
        this.mProgressView.e();
    }

    public void onDestroy() {
        this.mProgressView.g();
    }
}
