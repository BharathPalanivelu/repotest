package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.garena.android.appkit.tools.a.b;
import com.garena.sticker.d.a;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.data.viewmodel.chat.ChatStickerMessage;
import com.shopee.app.ui.a.n;
import com.shopee.id.R;
import com.squareup.a.e;
import com.squareup.a.w;

public class ad extends FrameLayout implements n<ChatMessage>, am, e {

    /* renamed from: f  reason: collision with root package name */
    private static int f20039f = (b.a.j * 2);

    /* renamed from: a  reason: collision with root package name */
    ProgressWheel f20040a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f20041b;

    /* renamed from: c  reason: collision with root package name */
    private final an f20042c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f20043d;

    /* renamed from: e  reason: collision with root package name */
    private ChatStickerMessage f20044e;

    public void d() {
    }

    public ad(Context context, an anVar, boolean z) {
        super(context);
        this.f20042c = anVar;
        this.f20043d = z;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int i = b.a.i * 10;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, i);
        setMinimumHeight(i);
        setLayoutParams(layoutParams);
        int i2 = f20039f;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i2);
        layoutParams2.gravity = this.f20043d ? 8388613 : 8388611;
        this.f20040a.setLayoutParams(layoutParams2);
    }

    public void a(ChatMessage chatMessage) {
        this.f20044e = (ChatStickerMessage) chatMessage;
        this.f20042c.setContentBackground(R.color.transparent);
        this.f20040a.setVisibility(0);
        w.a(getContext()).a(a.a(this.f20044e.getPackId(), this.f20044e.getStickerId(), a.a(getContext().getResources().getDisplayMetrics().density), this.f20044e.getFormat())).a(this.f20041b, (e) this);
    }

    public void b() {
        if (this.f20044e.getSendStatus() == 2) {
            a.a((View) this, (ChatMessage) this.f20044e);
        }
    }

    public void c() {
        this.f20040a.setVisibility(8);
    }
}
