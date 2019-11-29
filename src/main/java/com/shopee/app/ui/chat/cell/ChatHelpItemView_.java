package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class ChatHelpItemView_ extends g implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f20022g = false;
    private final c h = new c();

    public ChatHelpItemView_(Context context) {
        super(context);
        b();
    }

    public ChatHelpItemView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public ChatHelpItemView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public static g a(Context context) {
        ChatHelpItemView_ chatHelpItemView_ = new ChatHelpItemView_(context);
        chatHelpItemView_.onFinishInflate();
        return chatHelpItemView_;
    }

    public void onFinishInflate() {
        if (!this.f20022g) {
            this.f20022g = true;
            inflate(getContext(), R.layout.chat_help_item_layout, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.h);
        c.a((b) this);
        this.f20090a = androidx.core.content.b.c(getContext(), R.color.white);
        this.f20091b = androidx.core.content.b.c(getContext(), R.color.black87);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20092c = (TextView) aVar.internalFindViewById(R.id.label);
        this.f20093d = (ImageView) aVar.internalFindViewById(R.id.icon);
        a();
    }
}
