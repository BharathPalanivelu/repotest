package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.data.viewmodel.chat.ChatMessageTranslationInfo;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.chat.b;
import com.shopee.app.util.bi;
import com.shopee.app.util.bm;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.regex.Pattern;

public class ah extends FrameLayout implements n<ChatMessage>, am {
    private static Pattern i = Pattern.compile("^(http|https)://");

    /* renamed from: a  reason: collision with root package name */
    TextView f20051a;

    /* renamed from: b  reason: collision with root package name */
    TextView f20052b;

    /* renamed from: c  reason: collision with root package name */
    View f20053c;

    /* renamed from: d  reason: collision with root package name */
    View f20054d;

    /* renamed from: e  reason: collision with root package name */
    TextView f20055e;

    /* renamed from: f  reason: collision with root package name */
    int f20056f;

    /* renamed from: g  reason: collision with root package name */
    int f20057g;
    bi h;
    private final boolean j;
    private ChatMessage k;

    public ah(Context context, boolean z) {
        super(context);
        this.j = z;
        ((b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.j) {
            this.f20051a.setTextColor(this.f20056f);
        } else {
            this.f20051a.setTextColor(this.f20057g);
        }
    }

    public void a(ChatMessage chatMessage) {
        this.k = chatMessage;
        if (this.j || !this.k.isTranslationAvailable()) {
            h();
            this.f20051a.setText(this.k.getText());
            this.k.setLinkUrl(bm.a(this.f20051a, Color.parseColor("#3366BB"), Boolean.valueOf(chatMessage.isWhitelistCensored())));
            return;
        }
        g();
    }

    public void b() {
        if (this.k.getSendStatus() == 2) {
            a.a((View) this.f20051a, this.k);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f20051a.getSelectionStart() != -1 || this.f20051a.getSelectionEnd() != -1) {
            return;
        }
        if (this.k.getLinkUrl() != null) {
            a.c(this.f20051a, this.k);
        } else {
            a.b(this.f20051a, this.k);
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (this.f20055e.getSelectionStart() != -1 || this.f20055e.getSelectionEnd() != -1) {
            return;
        }
        if (this.k.getLinkUrl() != null) {
            a.c(this.f20055e, this.k);
        } else {
            a.b(this.f20055e, this.k);
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (this.k.getSendStatus() == 2) {
            a.a((View) this.f20051a, this.k);
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.h.a().D.a(Long.valueOf(this.k.getMessageId())).a();
        this.k.setTranslationViewExpanded(true);
        a(true);
    }

    private void g() {
        this.f20052b.setVisibility(0);
        this.f20053c.setVisibility(0);
        this.f20054d.setVisibility(0);
        this.f20055e.setVisibility(0);
        a(this.k.isTranslationViewExpanded());
        ChatMessageTranslationInfo translationInfo = this.k.getTranslationInfo();
        this.f20051a.setText(translationInfo.getTranslatedText());
        this.k.setLinkUrl(bm.a(this.f20051a, Color.parseColor("#3366BB"), Boolean.valueOf(this.k.isWhitelistCensored())));
        this.f20055e.setText(this.k.getText());
        this.k.setLinkUrl(bm.a(this.f20055e, Color.parseColor("#3366BB"), Boolean.valueOf(this.k.isWhitelistCensored())));
        if (!TextUtils.isEmpty(translationInfo.getTranslatedSource())) {
            this.f20052b.setText(com.garena.android.appkit.tools.b.a(R.string.sp_chat_translation_source, translationInfo.getTranslatedSource()));
        }
    }

    private void h() {
        this.f20052b.setVisibility(8);
        this.f20053c.setVisibility(8);
        this.f20054d.setVisibility(8);
        this.f20055e.setVisibility(8);
    }

    private void a(boolean z) {
        if (z) {
            this.f20054d.setVisibility(8);
            this.f20055e.setVisibility(0);
            return;
        }
        this.f20054d.setVisibility(0);
        this.f20055e.setVisibility(8);
    }
}
