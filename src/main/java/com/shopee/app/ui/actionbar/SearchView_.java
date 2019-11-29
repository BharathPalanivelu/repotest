package com.shopee.app.ui.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class SearchView_ extends k implements a, b {
    private boolean k = false;
    private final c l = new c();

    public SearchView_(Context context) {
        super(context);
        g();
    }

    public SearchView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public SearchView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }

    public void onFinishInflate() {
        if (!this.k) {
            this.k = true;
            inflate(getContext(), R.layout.action_bar_search_layout, this);
            this.l.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        c a2 = c.a(this.l);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f19316a = (ImageButton) aVar.internalFindViewById(R.id.cross_btn);
        this.f19317b = (ImageButton) aVar.internalFindViewById(R.id.imageSearch);
        this.f19318c = (EditText) aVar.internalFindViewById(R.id.search_edit);
        this.f19319d = (ProgressBar) aVar.internalFindViewById(R.id.progress);
        if (this.f19316a != null) {
            this.f19316a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    SearchView_.this.c();
                }
            });
        }
        if (this.f19317b != null) {
            this.f19317b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    SearchView_.this.d();
                }
            });
        }
        a();
    }
}
