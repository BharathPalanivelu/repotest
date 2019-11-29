package com.shopee.live.livestreaming.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.util.p;
import com.squareup.a.w;

public class AdView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private b f29095a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f29096b;

    public interface a {
        void a();
    }

    public interface b {
        void a(int i);
    }

    public AdView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    private void b() {
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (AdView.this.f29096b != null) {
                    AdView.this.f29096b.a();
                }
            }
        });
    }

    public boolean a(String str, boolean z) {
        if (!z) {
            setVisibility(8);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        w.a(getContext()).a(p.b(str)).a(c.d.live_streaming_ic_show_product_default).b(c.d.live_streaming_ic_show_product_default).a((ImageView) this);
        setVisibility(0);
        return true;
    }

    public void setAdViewClickListener(a aVar) {
        this.f29096b = aVar;
    }

    public void a() {
        if (this.f29096b != null) {
            this.f29096b = null;
        }
    }

    public void setVisibility(int i) {
        int visibility = getVisibility();
        super.setVisibility(i);
        if (visibility != i) {
            b bVar = this.f29095a;
            if (bVar != null) {
                bVar.a(i);
            }
        }
    }

    public void setVisibilityListener(b bVar) {
        this.f29095a = bVar;
    }
}
