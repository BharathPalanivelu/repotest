package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.ui.a.n;

public class af extends LinearLayout implements n<ChatMessage> {

    /* renamed from: a  reason: collision with root package name */
    FrameLayout f20047a;

    /* renamed from: b  reason: collision with root package name */
    private final View f20048b;

    public af(Context context, View view) {
        super(context);
        this.f20048b = view;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        View view = this.f20048b;
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            this.f20047a.addView(this.f20048b, layoutParams);
        }
    }

    public void a(ChatMessage chatMessage) {
        View view = this.f20048b;
        if (view instanceof n) {
            ((n) view).a(chatMessage);
        }
    }
}
