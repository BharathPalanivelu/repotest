package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.SpannedString;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.a.a.f;
import com.garena.android.appkit.b.b;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.a;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.data.viewmodel.chat.ChatOfferMessage;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.chat.b;
import com.shopee.app.util.ak;
import com.shopee.app.util.bk;
import com.shopee.app.util.i;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class g extends FrameLayout implements n<ChatMessage> {

    /* renamed from: a  reason: collision with root package name */
    int f20090a;

    /* renamed from: b  reason: collision with root package name */
    int f20091b;

    /* renamed from: c  reason: collision with root package name */
    TextView f20092c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f20093d;

    /* renamed from: e  reason: collision with root package name */
    ak f20094e;

    /* renamed from: f  reason: collision with root package name */
    aa f20095f;

    /* renamed from: g  reason: collision with root package name */
    private int f20096g;
    private String h;

    public g(Context context) {
        super(context);
        a(context);
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
        a(context, attributeSet);
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
        a(context, attributeSet);
    }

    private void a(Context context) {
        ((b) ((x) context).b()).a(this);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.ChatHelpView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 0) {
                this.f20096g = obtainStyledAttributes.getResourceId(index, 0);
            } else if (index == 1) {
                this.h = obtainStyledAttributes.getString(index);
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f20092c.setText(this.h);
        this.f20093d.setImageResource(this.f20096g);
    }

    public void a(final ChatMessage chatMessage) {
        setVisibility(0);
        if (chatMessage.getData() instanceof ChatOfferMessage) {
            a((ChatOfferMessage) chatMessage.getData());
        } else if (!(chatMessage.getData() instanceof String)) {
            this.f20092c.setText(chatMessage.getText());
            this.f20093d.setImageResource(R.drawable.com_garena_shopee_ic_sys_msg_info);
        } else if ("SCAM".equals(chatMessage.getData())) {
            f a2 = f.a(getContext());
            a2.a((int) R.string.sp_chat_scam_hint_text).b().b().a(SQLBuilder.BLANK).b();
            a2.a((int) R.string.sp_label_learn_more).a().b(com.garena.android.appkit.tools.b.a(R.color.black54)).c().a((View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    boolean equals = g.this.f20095f.b().equals("en");
                    ak akVar = g.this.f20094e;
                    akVar.n(i.f7041d + "events3/code/3586486288/");
                }
            }).b().b().a(" | ").b();
            a2.a((int) R.string.sp_report_user2).a().b(com.garena.android.appkit.tools.b.a(R.color.primary)).c().a((View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.f20094e.k(chatMessage.getShopId());
                }
            }).b();
            a2.a(this.f20092c);
            this.f20093d.setImageResource(R.drawable.ic_pop_warning);
        } else if ("BLACK_LIST".equals(chatMessage.getData())) {
            f a3 = f.a(getContext());
            a3.a((int) R.string.sp_label_message_content_violates_t_and_c).b().b().a(SQLBuilder.BLANK).b();
            a3.a((int) R.string.sp_label_learn_more).a().b(com.garena.android.appkit.tools.b.a(R.color.black54)).c().a((View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.f20094e.z();
                }
            }).b();
            a3.a(this.f20092c);
            this.f20093d.setImageResource(R.drawable.ic_pop_warning);
        }
    }

    private void a(ChatOfferMessage chatOfferMessage) {
        if (chatOfferMessage.isMyShop()) {
            c(chatOfferMessage);
        } else {
            b(chatOfferMessage);
        }
    }

    private void b(ChatOfferMessage chatOfferMessage) {
        int offerStatus = chatOfferMessage.getOfferStatus();
        if (offerStatus == 1) {
            this.f20092c.setText(com.garena.android.appkit.tools.b.e(R.string.sp_chat_sys_msg_buyer_new_offer));
            this.f20093d.setImageResource(R.drawable.com_garena_shopee_ic_sys_msg_info);
        } else if (offerStatus == 2) {
            f a2 = f.a(getContext(), (int) R.string.sp_buyer_accepted_offer);
            a2.a().a((Object) com.garena.android.appkit.tools.b.e(R.string.sp_lower_case_shopping_cart)).a().b(com.garena.android.appkit.tools.b.a(R.color.primary)).c().a((com.a.a.a) new com.a.a.a() {
                public SpannedString format(Object obj) {
                    SpannableString spannableString = new SpannableString((CharSequence) obj);
                    spannableString.setSpan(new bk() {
                        public void onClick(View view) {
                            com.garena.android.appkit.b.b.a("CHAT_GOTO_CART", new com.garena.android.appkit.b.a(), b.a.UI_BUS);
                        }
                    }, 0, spannableString.length(), 33);
                    return new SpannedString(spannableString);
                }
            }).b();
            a2.a(this.f20092c);
            this.f20093d.setImageResource(R.drawable.com_garena_shopee_ic_sys_msg_cart);
        } else if (offerStatus == 3) {
            setVisibility(8);
        } else if (offerStatus != 4) {
            setVisibility(8);
        } else {
            setVisibility(8);
        }
    }

    private void c(ChatOfferMessage chatOfferMessage) {
        int offerStatus = chatOfferMessage.getOfferStatus();
        if (offerStatus == 1) {
            this.f20092c.setText(com.garena.android.appkit.tools.b.e(R.string.sp_chat_sys_msg_seller_offer_new));
            this.f20093d.setImageResource(R.drawable.com_garena_shopee_ic_sys_msg_smiley);
        } else if (offerStatus == 2) {
            this.f20092c.setText(com.garena.android.appkit.tools.b.e(R.string.sp_chat_sys_msg_seller_offer_accept));
            this.f20093d.setImageResource(R.drawable.com_garena_shopee_ic_sys_msg_smiley);
        } else if (offerStatus == 3) {
            setVisibility(8);
        } else if (offerStatus != 4) {
            setVisibility(8);
        } else {
            setVisibility(8);
        }
    }
}
