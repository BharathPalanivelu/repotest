package com.shopee.live.livestreaming.ui.anchor.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.ui.view.DotsLoadingView;
import com.shopee.live.livestreaming.util.d;
import com.shopee.live.livestreaming.util.j;

public class WrapLoadingView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    DotsLoadingView f28924a;

    /* renamed from: b  reason: collision with root package name */
    private a f28925b;

    public interface a {
        void a();

        void b();
    }

    public WrapLoadingView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WrapLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WrapLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d();
    }

    private void d() {
        this.f28924a = (DotsLoadingView) LayoutInflater.from(getContext()).inflate(c.f.live_streaming_layout_wrap_loading, this, true).findViewById(c.e.loading_view);
    }

    public void setLoadingText(String str) {
        if (!d.a(str)) {
            this.f28924a.setLabel(str);
        }
    }

    public void a() {
        DotsLoadingView dotsLoadingView = this.f28924a;
        if (dotsLoadingView != null) {
            dotsLoadingView.a();
            a aVar = this.f28925b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void b() {
        DotsLoadingView dotsLoadingView = this.f28924a;
        if (dotsLoadingView != null) {
            dotsLoadingView.b();
            a aVar = this.f28925b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public void setLoadingListener(a aVar) {
        this.f28925b = aVar;
    }

    public void c() {
        if (this.f28925b != null) {
            this.f28925b = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f28924a.getLayoutParams();
        if (configuration.orientation == 1) {
            layoutParams.topMargin = j.a(getContext(), 240.0f);
            this.f28924a.setPadding(0, 0, 0, 0);
            layoutParams.addRule(15, 0);
            return;
        }
        layoutParams.topMargin = 0;
        this.f28924a.setPadding(0, 0, 0, j.a(getContext(), 40.0f));
        layoutParams.addRule(15);
    }
}
