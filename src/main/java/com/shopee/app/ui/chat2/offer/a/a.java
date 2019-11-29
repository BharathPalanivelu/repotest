package com.shopee.app.ui.chat2.offer.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.f;
import com.garena.android.appkit.tools.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.ModelDetail;
import com.shopee.app.data.viewmodel.chatP2P.VMOfferHistory;
import com.shopee.app.h.r;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.chat2.a.d;
import com.shopee.app.ui.chat2.a.e;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.at;
import com.shopee.app.util.au;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class a extends FrameLayout implements n<VMOfferHistory> {
    /* access modifiers changed from: private */
    public static CharSequence[] l = new CharSequence[2];
    /* access modifiers changed from: private */
    public static CharSequence[] m = new CharSequence[3];

    /* renamed from: a  reason: collision with root package name */
    TextView f20559a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f20560b;

    /* renamed from: c  reason: collision with root package name */
    TextView f20561c;

    /* renamed from: d  reason: collision with root package name */
    TextView f20562d;

    /* renamed from: e  reason: collision with root package name */
    CheckBox f20563e;

    /* renamed from: f  reason: collision with root package name */
    TextView f20564f;

    /* renamed from: g  reason: collision with root package name */
    TextView f20565g;
    Activity h;
    ak i;
    bi j;
    UserInfo k;
    private ItemDetail n;
    private VMOfferHistory o;
    private View.OnClickListener p = new View.OnClickListener() {
        public void onClick(View view) {
            com.shopee.app.ui.dialog.a.a(a.this.getContext(), a.l, (a.c) new a.c() {
                public void a(f fVar, View view, int i, CharSequence charSequence) {
                    if (i == 0) {
                        a.this.e();
                    } else if (i == 1) {
                        a.this.f();
                    }
                }
            });
        }
    };
    private View.OnClickListener q = new View.OnClickListener() {
        public void onClick(View view) {
            com.shopee.app.ui.dialog.a.a(a.this.getContext(), a.m, (a.c) new a.c() {
                public void a(f fVar, View view, int i, CharSequence charSequence) {
                    if (i == 0) {
                        a.this.e();
                    } else if (i == 1) {
                        a.this.f();
                    } else if (i == 2) {
                        a.this.g();
                    }
                }
            });
        }
    };

    /* renamed from: com.shopee.app.ui.chat2.offer.a.a$a  reason: collision with other inner class name */
    public interface C0306a {
        void a(a aVar);
    }

    /* access modifiers changed from: package-private */
    public void a() {
    }

    static {
        l[0] = b.e(R.string.sp_send_link2);
        l[1] = b.e(R.string.sp_view_offer);
        m[0] = b.e(R.string.sp_send_link2);
        m[1] = b.e(R.string.sp_view_offer);
        m[2] = b.e(R.string.sp_label_resend_offer);
    }

    public a(Context context) {
        super(context);
        b();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        ((C0306a) ((x) getContext()).b()).a(this);
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.n != null) {
            Intent intent = new Intent();
            com.shopee.app.ui.chat.a.f20001a = this.n;
            intent.putExtra("type", 1);
            this.h.setResult(-1, intent);
            this.h.finish();
            return;
        }
        r.a().b((int) R.string.sp_item_detail_not_ready);
    }

    /* access modifiers changed from: private */
    public void f() {
        final com.shopee.app.ui.chat2.a.a aVar = new com.shopee.app.ui.chat2.a.a(this.o);
        d a2 = e.a(getContext(), aVar);
        final f b2 = new f.a(getContext()).a((View) a2, false).b();
        AnonymousClass1 r3 = new d.b() {
            public void a() {
                b2.dismiss();
                a.this.i.b(aVar.h(), aVar.g());
            }
        };
        a2.setDialog(b2);
        a2.setOnProductClickedListener(r3);
        b2.show();
    }

    /* access modifiers changed from: private */
    public void g() {
        this.j.a("ACTION_MENU_REMIND_OFFER", new com.garena.android.appkit.b.a(this.o));
    }

    public void a(VMOfferHistory vMOfferHistory) {
        this.n = null;
        this.o = vMOfferHistory;
        if (vMOfferHistory.getSnapshot() == null && vMOfferHistory.getItemDetail() != null) {
            this.n = vMOfferHistory.getItemDetail();
            this.f20561c.setText(vMOfferHistory.getItemDetail().getItemName());
            at.a(getContext(), vMOfferHistory.getItemDetail().getVariationNoOOSPriceString(), vMOfferHistory.getOffer().getOfferPrice()).a(this.f20562d);
            z.b(getContext()).a(vMOfferHistory.getItemDetail().getImages()).a(this.f20560b);
            ModelDetail variation = vMOfferHistory.getItemDetail().getVariation(vMOfferHistory.getOffer().getModelid());
            if (variation == null) {
                this.f20565g.setVisibility(8);
            } else {
                this.f20565g.setVisibility(0);
                this.f20565g.setText(variation.getName());
                at.a(getContext(), au.b(variation.getPrice()), vMOfferHistory.getOffer().getOfferPrice()).a(this.f20562d);
            }
            int offerStatus = vMOfferHistory.getOffer().getOfferStatus();
            if (offerStatus == 1) {
                this.f20564f.setText(R.string.sp_offer_pending);
                this.f20564f.setBackgroundResource(R.drawable.offer_item_new);
                setOnClickListener(this.p);
            } else if (offerStatus == 2) {
                this.f20564f.setText(R.string.sp_offer_accepted);
                this.f20564f.setBackgroundResource(R.drawable.offer_item_new);
                setOnClickListener(this.p);
            } else if (offerStatus == 3) {
                this.f20564f.setText(R.string.sp_offer_rejected);
                this.f20564f.setBackgroundResource(R.drawable.sold_out_label);
                setOnClickListener(this.p);
            } else if (offerStatus == 4) {
                this.f20564f.setText(R.string.sp_offer_cancelled);
                this.f20564f.setBackgroundResource(R.drawable.sold_out_label);
                setOnClickListener(this.p);
            }
        } else if (vMOfferHistory.getSnapshot() != null) {
            this.n = vMOfferHistory.getItemDetail();
            this.f20561c.setText(vMOfferHistory.getSnapshot().getItemName());
            at.a(getContext(), vMOfferHistory.getSnapshot().getPriceString(), vMOfferHistory.getOffer().getOfferPrice()).a(this.f20562d);
            z.b(getContext()).a(vMOfferHistory.getSnapshot().getImages()).a(this.f20560b);
            ModelDetail variation2 = vMOfferHistory.getSnapshot().getVariation(vMOfferHistory.getOffer().getModelid());
            if (variation2 == null) {
                this.f20565g.setVisibility(8);
            } else {
                this.f20565g.setVisibility(0);
                this.f20565g.setText(variation2.getName());
                at.a(getContext(), au.b(variation2.getPrice()), vMOfferHistory.getOffer().getOfferPrice()).a(this.f20562d);
            }
            int offerStatus2 = vMOfferHistory.getOffer().getOfferStatus();
            if (offerStatus2 == 1) {
                this.f20564f.setText(R.string.sp_offer_pending);
                this.f20564f.setBackgroundResource(R.drawable.offer_item_new);
                if (this.k.isMyShop(vMOfferHistory.getSnapshot().getShopId())) {
                    setOnClickListener(this.p);
                } else {
                    setOnClickListener(this.q);
                }
            } else if (offerStatus2 == 2) {
                this.f20564f.setText(R.string.sp_offer_accepted);
                this.f20564f.setBackgroundResource(R.drawable.offer_item_new);
                setOnClickListener(this.p);
            } else if (offerStatus2 == 3) {
                this.f20564f.setText(R.string.sp_offer_rejected);
                this.f20564f.setBackgroundResource(R.drawable.sold_out_label);
                setOnClickListener(this.p);
            } else if (offerStatus2 == 4) {
                this.f20564f.setText(R.string.sp_offer_cancelled);
                this.f20564f.setBackgroundResource(R.drawable.sold_out_label);
                setOnClickListener(this.p);
            }
        }
        this.f20559a.setText("x " + vMOfferHistory.getOffer().getBuyCount());
    }
}
