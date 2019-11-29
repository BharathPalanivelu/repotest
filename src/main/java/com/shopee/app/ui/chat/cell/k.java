package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.a.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.common.m;
import com.shopee.app.util.av;
import com.shopee.id.R;

public class k extends LinearLayout implements n<ChatMessage>, an {

    /* renamed from: a  reason: collision with root package name */
    FrameLayout f20110a;

    /* renamed from: b  reason: collision with root package name */
    TextView f20111b;

    /* renamed from: c  reason: collision with root package name */
    m f20112c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f20113d;

    /* renamed from: e  reason: collision with root package name */
    private View f20114e = null;

    public k(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        setContent(this.f20114e);
    }

    public void setContent(View view) {
        this.f20114e = view;
        View view2 = this.f20114e;
        if (view2 != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            this.f20110a.addView(this.f20114e, layoutParams);
            av.a(this.f20114e, (int) R.drawable.com_garena_shopee_bg_msg_sent_new);
        }
    }

    public void a(ChatMessage chatMessage) {
        b(chatMessage);
        View view = this.f20114e;
        if (view instanceof n) {
            ((n) view).a(chatMessage);
        }
    }

    private void b(ChatMessage chatMessage) {
        int sendStatus = chatMessage.getSendStatus();
        if (sendStatus == 0) {
            this.f20113d.setVisibility(0);
            int i = R.drawable.ic_msg_sent;
            if (chatMessage.isBlacklistCensored()) {
                i = R.drawable.q_ic_issue;
            }
            this.f20113d.setImageDrawable(b.f(i));
            this.f20111b.setText(a.d(chatMessage.getTime(), "ID"));
        } else if (sendStatus == 1) {
            this.f20111b.setText(R.string.sp_send_pending);
            this.f20113d.setVisibility(4);
        } else if (sendStatus == 2 || sendStatus == 4) {
            this.f20113d.setVisibility(0);
            this.f20113d.setImageDrawable(b.f(R.drawable.q_ic_issue));
            this.f20111b.setText(a.d(chatMessage.getTime(), "ID"));
        }
    }

    public void setContentBackground(int i) {
        Drawable g2 = androidx.core.graphics.drawable.a.g(b.f(R.drawable.com_garena_shopee_bg_msg_sent_new).mutate());
        androidx.core.graphics.drawable.a.a(g2, b.a(i));
        av.a(this.f20114e, g2);
        this.f20112c.setColor(b.a(i));
    }

    /* access modifiers changed from: package-private */
    public void b() {
        View view = this.f20114e;
        if (view instanceof am) {
            ((am) view).b();
        }
    }
}
