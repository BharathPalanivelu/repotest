package com.shopee.live.livestreaming.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;

public class TXVideoLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static WeakReference<TXCloudVideoView> f29173a;

    /* renamed from: b  reason: collision with root package name */
    private TXCloudVideoView f29174b;

    public TXVideoLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TXVideoLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TXVideoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void a() {
        this.f29174b = get();
        TXCloudVideoView tXCloudVideoView = this.f29174b;
        if (tXCloudVideoView != null && tXCloudVideoView != getChildAt(0)) {
            ViewGroup viewGroup = (ViewGroup) this.f29174b.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f29174b);
            }
            addView(this.f29174b, -1, -1);
        }
    }

    public TXCloudVideoView get() {
        return getVideoInstance();
    }

    private TXCloudVideoView getVideoInstance() {
        synchronized (TXVideoLayout.class) {
            if (f29173a == null) {
                synchronized (TXVideoLayout.class) {
                    f29173a = new WeakReference<>(new TXCloudVideoView(getContext()));
                }
            }
        }
        return (TXCloudVideoView) f29173a.get();
    }
}
