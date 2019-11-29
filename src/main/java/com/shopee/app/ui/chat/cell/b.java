package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.ui.a.n;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;

public class b extends FrameLayout implements n<ChatMessage> {

    /* renamed from: a  reason: collision with root package name */
    int f20075a;

    /* renamed from: b  reason: collision with root package name */
    int f20076b;

    /* renamed from: c  reason: collision with root package name */
    ImageView f20077c;

    /* renamed from: d  reason: collision with root package name */
    Button f20078d;

    /* renamed from: e  reason: collision with root package name */
    bi f20079e;

    /* renamed from: f  reason: collision with root package name */
    RegionConfig f20080f;

    public interface a {
        void a(b bVar);
    }

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public b(Context context) {
        super(context);
        ((a) ((x) context).b()).a(this);
    }

    public void a(ChatMessage chatMessage) {
        int i = this.f20080f.isFullBuild() ? 0 : 8;
        this.f20077c.setVisibility(i);
        this.f20078d.setVisibility(i);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f20079e.a("CHAT_GOTO_CART", new com.garena.android.appkit.b.a());
    }
}
