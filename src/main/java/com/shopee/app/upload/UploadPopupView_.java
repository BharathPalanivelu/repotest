package com.shopee.app.upload;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.app.ui.common.aa;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class UploadPopupView_ extends UploadPopupView implements a, b {
    private boolean alreadyInflated_ = false;
    private final c onViewChangedNotifier_ = new c();

    public UploadPopupView_(Context context) {
        super(context);
        init_();
    }

    public UploadPopupView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init_();
    }

    public UploadPopupView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init_();
    }

    public static UploadPopupView build(Context context) {
        UploadPopupView_ uploadPopupView_ = new UploadPopupView_(context);
        uploadPopupView_.onFinishInflate();
        return uploadPopupView_;
    }

    public void onFinishInflate() {
        if (!this.alreadyInflated_) {
            this.alreadyInflated_ = true;
            inflate(getContext(), R.layout.upload_popup_layout, this);
            this.onViewChangedNotifier_.a((a) this);
        }
        super.onFinishInflate();
    }

    private void init_() {
        c a2 = c.a(this.onViewChangedNotifier_);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public static UploadPopupView build(Context context, AttributeSet attributeSet) {
        UploadPopupView_ uploadPopupView_ = new UploadPopupView_(context, attributeSet);
        uploadPopupView_.onFinishInflate();
        return uploadPopupView_;
    }

    public static UploadPopupView build(Context context, AttributeSet attributeSet, int i) {
        UploadPopupView_ uploadPopupView_ = new UploadPopupView_(context, attributeSet, i);
        uploadPopupView_.onFinishInflate();
        return uploadPopupView_;
    }

    public void onViewChanged(a aVar) {
        this.mProgressView = (aa) aVar.internalFindViewById(R.id.progress_view);
        onViewInit();
    }
}
