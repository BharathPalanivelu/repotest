package com.shopee.app.ui.product.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class CommentSwitchView_ extends f implements a, b {
    private boolean i = false;
    private final c j = new c();

    public CommentSwitchView_(Context context) {
        super(context);
        b();
    }

    public CommentSwitchView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public CommentSwitchView_(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }

    public void onFinishInflate() {
        if (!this.i) {
            this.i = true;
            inflate(getContext(), R.layout.comment_buyer_review_switch, this);
            this.j.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.j);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f24487a = (Button) aVar.internalFindViewById(R.id.all_star);
        this.f24488b = (Button) aVar.internalFindViewById(R.id.five_star);
        this.f24489c = (Button) aVar.internalFindViewById(R.id.four_star);
        this.f24490d = (Button) aVar.internalFindViewById(R.id.three_star);
        this.f24491e = (Button) aVar.internalFindViewById(R.id.two_star);
        this.f24492f = (Button) aVar.internalFindViewById(R.id.one_star);
        this.f24493g = aVar.internalFindViewById(R.id.star_section_1);
        this.h = aVar.internalFindViewById(R.id.star_section_2);
        a();
    }
}
