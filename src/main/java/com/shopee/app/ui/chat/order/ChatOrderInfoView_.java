package com.shopee.app.ui.chat.order;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class ChatOrderInfoView_ extends b implements a, b {
    private boolean r = false;
    private final c s = new c();

    public ChatOrderInfoView_(Context context) {
        super(context);
        f();
    }

    public ChatOrderInfoView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f();
    }

    public ChatOrderInfoView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        f();
    }

    public void onFinishInflate() {
        if (!this.r) {
            this.r = true;
            inflate(getContext(), R.layout.chat_order_info_layout, this);
            this.s.a((a) this);
        }
        super.onFinishInflate();
    }

    private void f() {
        c a2 = c.a(this.s);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.f20184f = resources.getString(R.string.sp_selling);
        this.f20185g = resources.getString(R.string.sp_buying);
        this.h = resources.getString(R.string.sp_order_number);
        this.i = resources.getString(R.string.sp_order_time);
        this.l = resources.getDimensionPixelSize(R.dimen.dp72);
        this.m = resources.getDimensionPixelSize(R.dimen.dp220);
        this.j = androidx.core.content.b.c(getContext(), R.color.complement87);
        this.k = androidx.core.content.b.c(getContext(), R.color.primary87);
        a();
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20179a = (ImageView) aVar.internalFindViewById(R.id.order_icon);
        this.f20180b = (TextView) aVar.internalFindViewById(R.id.order_title);
        this.f20181c = (TextView) aVar.internalFindViewById(R.id.order_number);
        this.f20182d = (TextView) aVar.internalFindViewById(R.id.order_time);
        this.f20183e = (ImageButton) aVar.internalFindViewById(R.id.expand_button);
        View internalFindViewById = aVar.internalFindViewById(R.id.order_container);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ChatOrderInfoView_.this.c();
                }
            });
        }
        if (this.f20183e != null) {
            this.f20183e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ChatOrderInfoView_.this.d();
                }
            });
        }
        b();
    }
}
