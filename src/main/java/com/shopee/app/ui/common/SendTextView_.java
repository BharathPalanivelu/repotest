package com.shopee.app.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class SendTextView_ extends ag implements a, b {
    private boolean m = false;
    private final c n = new c();

    public SendTextView_(Context context) {
        super(context);
        i();
    }

    public SendTextView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i();
    }

    public SendTextView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        i();
    }

    public void onFinishInflate() {
        if (!this.m) {
            this.m = true;
            inflate(getContext(), R.layout.chat_text_bar_layout, this);
            this.n.a((a) this);
        }
        super.onFinishInflate();
    }

    private void i() {
        c a2 = c.a(this.n);
        c.a((b) this);
        this.f21138e = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_from_up);
        this.f21139f = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_from_bottom);
        this.f21140g = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_from_bottom);
        this.h = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_from_top);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21134a = (TagEditText) aVar.internalFindViewById(R.id.chat_edit);
        this.f21135b = (ImageButton) aVar.internalFindViewById(R.id.send_btn);
        this.f21136c = (ImageButton) aVar.internalFindViewById(R.id.phone_btn);
        this.f21137d = (ImageButton) aVar.internalFindViewById(R.id.photo_add);
        if (this.f21135b != null) {
            this.f21135b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    SendTextView_.this.c();
                }
            });
        }
        if (this.f21136c != null) {
            this.f21136c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    SendTextView_.this.d();
                }
            });
        }
        if (this.f21137d != null) {
            this.f21137d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    SendTextView_.this.e();
                }
            });
        }
        if (this.f21134a != null) {
            this.f21134a.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return SendTextView_.this.a(motionEvent);
                }
            });
        }
        a();
    }
}
