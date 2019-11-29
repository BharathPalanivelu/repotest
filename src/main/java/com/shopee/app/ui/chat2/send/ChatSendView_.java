package com.shopee.app.ui.chat2.send;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.shopee.app.ui.common.TagEditText;
import com.shopee.app.ui.common.m;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class ChatSendView_ extends e implements a, b {
    private boolean l = false;
    private final c m = new c();

    public ChatSendView_(Context context) {
        super(context);
        k();
    }

    public ChatSendView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k();
    }

    public ChatSendView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k();
    }

    public ChatSendView_(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        k();
    }

    public void onFinishInflate() {
        if (!this.l) {
            this.l = true;
            inflate(getContext(), R.layout.chat_send_view, this);
            this.m.a((a) this);
        }
        super.onFinishInflate();
    }

    private void k() {
        c a2 = c.a(this.m);
        c.a((b) this);
        this.f20933e = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_from_up);
        this.f20934f = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_from_bottom);
        this.f20935g = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_from_bottom);
        this.h = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_from_top);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20929a = (TagEditText) aVar.internalFindViewById(R.id.chat_edit);
        this.f20930b = (ImageButton) aVar.internalFindViewById(R.id.send_btn);
        this.f20931c = (m) aVar.internalFindViewById(R.id.more_btn);
        this.f20932d = (ImageView) aVar.internalFindViewById(R.id.sticker_btn);
        if (this.f20930b != null) {
            this.f20930b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ChatSendView_.this.b();
                }
            });
        }
        if (this.f20931c != null) {
            this.f20931c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ChatSendView_.this.c();
                }
            });
        }
        if (this.f20932d != null) {
            this.f20932d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ChatSendView_.this.d();
                }
            });
        }
        a();
    }
}
