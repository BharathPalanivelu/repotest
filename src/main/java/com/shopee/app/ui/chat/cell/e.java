package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.ui.a.n;

public class e extends FrameLayout implements n<ChatMessage> {

    /* renamed from: a  reason: collision with root package name */
    int f20083a;

    /* renamed from: b  reason: collision with root package name */
    int f20084b;

    /* renamed from: c  reason: collision with root package name */
    TextView f20085c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f20086d;

    /* renamed from: e  reason: collision with root package name */
    View f20087e;

    public e(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f20087e.setLayoutParams(new LinearLayout.LayoutParams(-1, (b.d() - (b.a.r * 5)) - (b.a.o * 5)));
    }

    public void a(ChatMessage chatMessage) {
        if (chatMessage.isTW()) {
            this.f20085c.setVisibility(4);
            this.f20086d.setVisibility(4);
        } else {
            this.f20085c.setVisibility(0);
            this.f20086d.setVisibility(0);
        }
        this.f20085c.setText(chatMessage.getText());
    }
}
