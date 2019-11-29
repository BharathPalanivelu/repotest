package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.a.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.common.m;
import com.shopee.app.util.av;
import com.shopee.id.R;

public class ab extends LinearLayout implements n<ChatMessage>, an {

    /* renamed from: a  reason: collision with root package name */
    FrameLayout f20032a;

    /* renamed from: b  reason: collision with root package name */
    TextView f20033b;

    /* renamed from: c  reason: collision with root package name */
    AvatarView f20034c;

    /* renamed from: d  reason: collision with root package name */
    m f20035d;

    /* renamed from: e  reason: collision with root package name */
    private View f20036e = null;

    public ab(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        View view = this.f20036e;
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            this.f20032a.addView(this.f20036e, layoutParams);
            av.a(this.f20036e, (int) R.drawable.com_garena_shopee_bg_msg_received_new);
        }
    }

    public void setContent(View view) {
        this.f20036e = view;
        View view2 = this.f20036e;
        if (view2 != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            this.f20032a.addView(this.f20036e, layoutParams);
            av.a(this.f20036e, (int) R.drawable.com_garena_shopee_bg_msg_received_new);
        }
    }

    public void a(ChatMessage chatMessage) {
        this.f20033b.setText(a.d(chatMessage.getTime(), "ID"));
        this.f20034c.a(chatMessage.getFromUserId(), chatMessage.getFromUserAvatar());
        View view = this.f20036e;
        if (view instanceof n) {
            ((n) view).a(chatMessage);
        }
    }

    public void setContentBackground(int i) {
        Drawable g2 = androidx.core.graphics.drawable.a.g(b.f(R.drawable.com_garena_shopee_bg_msg_sent_new).mutate());
        androidx.core.graphics.drawable.a.a(g2, b.a(i));
        av.a(this.f20036e, g2);
        this.f20035d.setColor(b.a(i));
    }
}
