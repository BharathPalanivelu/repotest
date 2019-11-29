package com.shopee.app.ui.webview.simpleweb;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;

public final class c extends b implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f26094g = false;
    private final org.a.a.b.c h = new org.a.a.b.c();

    public c(Context context) {
        super(context);
        g();
    }

    public static b a(Context context) {
        c cVar = new c(context);
        cVar.onFinishInflate();
        return cVar;
    }

    public void onFinishInflate() {
        if (!this.f26094g) {
            this.f26094g = true;
            inflate(getContext(), R.layout.simple_web_page_layout, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        org.a.a.b.c a2 = org.a.a.b.c.a(this.h);
        org.a.a.b.c.a((b) this);
        org.a.a.b.c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f26079a = (ImageButton) aVar.internalFindViewById(R.id.forward_button);
        this.f26080b = (ImageButton) aVar.internalFindViewById(R.id.back_button);
        this.f26081c = (WebView) aVar.internalFindViewById(R.id.webView);
        this.f26082d = (TextView) aVar.internalFindViewById(R.id.error);
        this.f26083e = (ProgressBar) aVar.internalFindViewById(R.id.progress);
        View internalFindViewById = aVar.internalFindViewById(R.id.refresh_button);
        if (this.f26080b != null) {
            this.f26080b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.a();
                }
            });
        }
        if (this.f26079a != null) {
            this.f26079a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.b();
                }
            });
        }
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.c();
                }
            });
        }
        d();
    }
}
