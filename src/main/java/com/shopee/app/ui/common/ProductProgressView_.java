package com.shopee.app.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class ProductProgressView_ extends aa implements a, b {
    private boolean k = false;
    private final c l = new c();

    public ProductProgressView_(Context context) {
        super(context);
        h();
    }

    public ProductProgressView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h();
    }

    public ProductProgressView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        h();
    }

    public void onFinishInflate() {
        if (!this.k) {
            this.k = true;
            inflate(getContext(), R.layout.product_progress_view, this);
            this.l.a((a) this);
        }
        super.onFinishInflate();
    }

    private void h() {
        c a2 = c.a(this.l);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21108a = (TextView) aVar.internalFindViewById(R.id.label);
        this.f21109b = (SmoothProgressBar) aVar.internalFindViewById(R.id.progress);
        this.f21110c = (m) aVar.internalFindViewById(R.id.cancel_btn);
        this.f21111d = aVar.internalFindViewById(R.id.button_container);
        this.f21112e = (TextView) aVar.internalFindViewById(R.id.status);
        this.f21113f = (ImageView) aVar.internalFindViewById(R.id.image);
        this.f21114g = (ImageView) aVar.internalFindViewById(R.id.buttonRight);
        View internalFindViewById = aVar.internalFindViewById(R.id.buttonLeft);
        if (this.f21110c != null) {
            this.f21110c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ProductProgressView_.this.b();
                }
            });
        }
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ProductProgressView_.this.c();
                }
            });
        }
        if (this.f21114g != null) {
            this.f21114g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ProductProgressView_.this.d();
                }
            });
        }
        a();
    }
}
