package com.shopee.app.ui.image;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.app.ui.image.bound.BoundPreview;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class q extends p implements a, b {
    private boolean l = false;
    private final c m = new c();

    public q(Context context, String str, boolean z, boolean z2, Rect rect, String str2, double d2, boolean z3, boolean z4) {
        super(context, str, z, z2, rect, str2, d2, z3, z4);
        i();
    }

    public static p a(Context context, String str, boolean z, boolean z2, Rect rect, String str2, double d2, boolean z3, boolean z4) {
        q qVar = new q(context, str, z, z2, rect, str2, d2, z3, z4);
        qVar.onFinishInflate();
        return qVar;
    }

    public void onFinishInflate() {
        if (!this.l) {
            this.l = true;
            inflate(getContext(), R.layout.search_preview_layout, this);
            this.m.a((a) this);
        }
        super.onFinishInflate();
    }

    private void i() {
        c a2 = c.a(this.m);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23052a = (ImageView) aVar.internalFindViewById(R.id.preview);
        this.f23053b = (TextView) aVar.internalFindViewById(R.id.progressTextView);
        this.f23054c = (BoundPreview) aVar.internalFindViewById(R.id.boundPreview);
        this.f23055d = (ImageView) aVar.internalFindViewById(R.id.cancel_button);
        this.f23056e = (ImageView) aVar.internalFindViewById(R.id.close_window);
        this.f23057f = (ImageView) aVar.internalFindViewById(R.id.done_button);
        this.f23058g = (TextView) aVar.internalFindViewById(R.id.boundBoxHint);
        if (this.f23057f != null) {
            this.f23057f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    q.this.f();
                }
            });
        }
        if (this.f23055d != null) {
            this.f23055d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    q.this.g();
                }
            });
        }
        if (this.f23056e != null) {
            this.f23056e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    q.this.g();
                }
            });
        }
        c();
    }
}
