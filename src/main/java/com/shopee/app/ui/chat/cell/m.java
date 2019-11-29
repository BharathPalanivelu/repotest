package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.f;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.data.viewmodel.chat.ChatOfferMessage;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.chat2.a.a;
import com.shopee.app.ui.chat2.a.d;
import com.shopee.app.ui.chat2.a.e;
import com.shopee.app.util.ak;
import com.shopee.app.util.av;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class m extends FrameLayout implements n<ChatMessage> {

    /* renamed from: a  reason: collision with root package name */
    TextView f20118a;

    /* renamed from: b  reason: collision with root package name */
    TextView f20119b;

    /* renamed from: c  reason: collision with root package name */
    ImageView f20120c;

    /* renamed from: d  reason: collision with root package name */
    TextView f20121d;

    /* renamed from: e  reason: collision with root package name */
    TextView f20122e;

    /* renamed from: f  reason: collision with root package name */
    TextView f20123f;

    /* renamed from: g  reason: collision with root package name */
    TextView f20124g;
    int h;
    int i;
    ao j;
    ak k;
    b l;
    int m;
    private final boolean n;
    private final an o;

    public m(Context context, an anVar, boolean z) {
        super(context);
        this.n = z;
        this.o = anVar;
        ((com.shopee.app.ui.chat.b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.n) {
            av.a((View) this, (int) R.drawable.com_garena_shopee_bg_msg_sent);
            this.f20119b.setTextColor(this.h);
            this.f20121d.setTextColor(this.h);
            this.f20118a.setTextColor(this.h);
            this.f20122e.setTextColor(this.h);
            return;
        }
        av.a((View) this, (int) R.drawable.com_garena_shopee_bg_msg_received);
        this.f20119b.setTextColor(this.i);
        this.f20121d.setTextColor(this.i);
        this.f20118a.setTextColor(this.i);
        this.f20122e.setTextColor(this.i);
    }

    public void a(ChatMessage chatMessage) {
        final ChatOfferMessage chatOfferMessage = (ChatOfferMessage) chatMessage;
        if (TextUtils.isEmpty(chatOfferMessage.getImageUrl())) {
            this.f20120c.setImageResource(R.drawable.com_garena_shopee_ic_product_default);
        } else {
            z.b(getContext()).a(chatOfferMessage.getImageUrl()).a(this.f20120c);
        }
        int offerStatus = chatOfferMessage.getOfferStatus();
        if (offerStatus != 1) {
            if (offerStatus != 2) {
                if (offerStatus == 3) {
                    a(chatOfferMessage, R.string.sp_offer_rejected);
                } else if (offerStatus != 4) {
                    this.f20118a.setText("DEBUG: unknown offer");
                } else {
                    a(chatOfferMessage, R.string.sp_offer_cancelled);
                }
            } else if (chatOfferMessage.getOfferId() < 0) {
                a(chatOfferMessage, R.string.sp_offer_accepted);
            } else {
                c(chatOfferMessage);
            }
        } else if (chatOfferMessage.getOfferId() < 0) {
            b(chatOfferMessage);
        } else if (chatOfferMessage.getOffer() == null || chatOfferMessage.getOffer().getOfferStatus() == 1 || chatOfferMessage.getOffer().getOfferStatus() == 2) {
            a(chatOfferMessage);
        } else {
            b(chatOfferMessage);
        }
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final a aVar = new a(chatOfferMessage);
                d a2 = e.a(m.this.getContext(), aVar);
                final f b2 = new f.a(m.this.getContext()).a((View) a2, false).b();
                AnonymousClass1 r2 = new d.b() {
                    public void a() {
                        b2.dismiss();
                        m.this.k.b(aVar.h(), aVar.g());
                        m.this.l.a("pop_up_item", b.a(aVar.g(), (long) aVar.h()));
                    }
                };
                a2.setDialog(b2);
                a2.setOnProductClickedListener(r2);
                b2.show();
            }
        });
        TextView textView = this.f20124g;
        int i2 = this.m;
        textView.setPadding(i2, i2 / 2, i2, i2 / 2);
    }

    private void a(ChatOfferMessage chatOfferMessage) {
        this.f20118a.setText(com.garena.android.appkit.tools.b.e(R.string.sp_made_an_offer));
        this.f20118a.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
        this.f20118a.setTextSize(14.0f);
        if (TextUtils.isEmpty(chatOfferMessage.getItemName())) {
            this.f20123f.setVisibility(8);
        } else {
            this.f20123f.setVisibility(0);
            this.f20123f.setText(chatOfferMessage.getItemName());
        }
        this.f20123f.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
        this.f20119b.setText(chatOfferMessage.getPriceString());
        this.f20119b.setTextSize(14.0f);
        this.f20119b.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
        com.devspark.robototextview.b.a(this.f20119b, com.devspark.robototextview.b.a(getContext(), 0, 2, 0));
        TextView textView = this.f20121d;
        textView.setText("x " + chatOfferMessage.getQuantity());
        this.f20121d.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
        if (chatOfferMessage.getModelId() > 0) {
            this.f20122e.setText(chatOfferMessage.getModelName());
            this.f20122e.setVisibility(0);
        } else {
            this.f20122e.setVisibility(8);
        }
        this.f20122e.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
        an anVar = this.o;
        if (anVar != null) {
            anVar.setContentBackground(R.color.white);
        }
        this.f20124g.setBackgroundResource(R.drawable.chat_offer_bottom_bg_primary);
        this.f20124g.setTextColor(com.garena.android.appkit.tools.b.a(R.color.white));
    }

    private void b(ChatOfferMessage chatOfferMessage) {
        this.f20118a.setText(com.garena.android.appkit.tools.b.e(R.string.sp_made_an_offer));
        this.f20118a.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
        this.f20118a.setTextSize(14.0f);
        if (TextUtils.isEmpty(chatOfferMessage.getItemName())) {
            this.f20123f.setVisibility(8);
        } else {
            this.f20123f.setVisibility(0);
            this.f20123f.setText(chatOfferMessage.getItemName());
        }
        this.f20123f.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black54));
        this.f20119b.setText(chatOfferMessage.getPriceString());
        this.f20119b.setTextSize(14.0f);
        this.f20119b.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black54));
        com.devspark.robototextview.b.a(this.f20119b, com.devspark.robototextview.b.a(getContext(), 0, 2, 0));
        TextView textView = this.f20121d;
        textView.setText("x " + chatOfferMessage.getQuantity());
        this.f20121d.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black54));
        if (chatOfferMessage.getModelId() > 0) {
            this.f20122e.setText(chatOfferMessage.getModelName());
            this.f20122e.setVisibility(0);
        } else {
            this.f20122e.setVisibility(8);
        }
        this.f20122e.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black54));
        an anVar = this.o;
        if (anVar != null) {
            anVar.setContentBackground(R.color.white);
        }
        this.f20124g.setBackgroundResource(R.drawable.chat_offer_bottom_bg_grey);
        this.f20124g.setTextColor(com.garena.android.appkit.tools.b.a(R.color.white));
    }

    private void c(ChatOfferMessage chatOfferMessage) {
        this.f20118a.setText(com.garena.android.appkit.tools.b.e(R.string.sp_offer_accepted));
        this.f20118a.setTextColor(com.garena.android.appkit.tools.b.a(R.color.primary));
        this.f20118a.setTextSize(14.0f);
        if (TextUtils.isEmpty(chatOfferMessage.getItemName())) {
            this.f20123f.setVisibility(8);
        } else {
            this.f20123f.setVisibility(0);
            this.f20123f.setText(chatOfferMessage.getItemName());
        }
        this.f20123f.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
        this.f20119b.setText(chatOfferMessage.getPriceString());
        this.f20119b.setTextSize(14.0f);
        this.f20119b.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
        com.devspark.robototextview.b.a(this.f20119b, com.devspark.robototextview.b.a(getContext(), 0, 2, 0));
        TextView textView = this.f20121d;
        textView.setText("x " + chatOfferMessage.getQuantity());
        this.f20121d.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
        if (chatOfferMessage.getModelId() > 0) {
            this.f20122e.setText(chatOfferMessage.getModelName());
            this.f20122e.setVisibility(0);
        } else {
            this.f20122e.setVisibility(8);
        }
        this.f20122e.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
        an anVar = this.o;
        if (anVar != null) {
            anVar.setContentBackground(R.color.white);
        }
        this.f20124g.setBackgroundResource(R.drawable.chat_offer_bottom_bg_primary);
        this.f20124g.setTextColor(com.garena.android.appkit.tools.b.a(R.color.white));
    }

    private void a(ChatOfferMessage chatOfferMessage, int i2) {
        this.f20118a.setText(com.garena.android.appkit.tools.b.e(i2));
        this.f20118a.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
        this.f20118a.setTextSize(14.0f);
        if (TextUtils.isEmpty(chatOfferMessage.getItemName())) {
            this.f20123f.setVisibility(8);
        } else {
            this.f20123f.setVisibility(0);
            this.f20123f.setText(chatOfferMessage.getItemName());
        }
        this.f20123f.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black54));
        this.f20119b.setText(chatOfferMessage.getPriceString());
        this.f20119b.setTextSize(14.0f);
        this.f20119b.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black54));
        com.devspark.robototextview.b.a(this.f20119b, com.devspark.robototextview.b.a(getContext(), 0, 2, 0));
        TextView textView = this.f20121d;
        textView.setText("x " + chatOfferMessage.getQuantity());
        this.f20121d.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black54));
        if (chatOfferMessage.getModelId() > 0) {
            this.f20122e.setText(chatOfferMessage.getModelName());
            this.f20122e.setVisibility(0);
        } else {
            this.f20122e.setVisibility(8);
        }
        this.f20122e.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black54));
        an anVar = this.o;
        if (anVar != null) {
            anVar.setContentBackground(R.color.white);
        }
        this.f20124g.setBackgroundResource(R.drawable.chat_offer_bottom_bg_grey);
        this.f20124g.setTextColor(com.garena.android.appkit.tools.b.a(R.color.white));
    }
}
