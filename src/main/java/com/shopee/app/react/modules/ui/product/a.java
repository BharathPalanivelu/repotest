package com.shopee.app.react.modules.ui.product;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.facebook.react.bridge.Promise;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.garena.android.appkit.b.i;
import com.garena.android.appkit.tools.a.b;
import com.google.a.o;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.g.l;
import com.shopee.app.h.m;
import com.shopee.app.h.q;
import com.shopee.app.h.r;
import com.shopee.app.network.d.g;
import com.shopee.app.react.modules.base.b;
import com.shopee.app.tracking.f;
import com.shopee.app.ui.common.a.c;
import com.shopee.app.util.CartAnimation;
import com.shopee.app.util.ak;
import com.shopee.app.util.au;
import com.shopee.app.util.u;
import com.shopee.app.util.z;
import com.shopee.app.web.protocol.AddCartMessage;
import com.shopee.app.web.protocol.ShareMessage;
import com.shopee.app.web.protocol.notification.ShareDataField;
import com.shopee.id.R;
import com.squareup.a.ah;
import java.util.ArrayList;
import java.util.List;

public class a extends b implements e {

    /* renamed from: a  reason: collision with root package name */
    UserInfo f18937a;

    /* renamed from: b  reason: collision with root package name */
    f f18938b;

    /* renamed from: c  reason: collision with root package name */
    ak f18939c;

    /* renamed from: d  reason: collision with root package name */
    private Activity f18940d;

    /* renamed from: e  reason: collision with root package name */
    private i f18941e;

    /* renamed from: f  reason: collision with root package name */
    private e f18942f;

    /* renamed from: g  reason: collision with root package name */
    private long f18943g = 0;
    private List<Dialog> h = new ArrayList();
    private c.b i;
    private ImageView j;
    private int[] k = {-1, -1};
    private Promise l;

    a(com.shopee.app.react.c cVar) {
        this.f18940d = cVar.a();
        cVar.c().a(this);
        this.f18941e = com.garena.a.a.a.b.a(this);
        this.f18942f = this;
    }

    public a(UserInfo userInfo, f fVar, Activity activity, ak akVar) {
        this.f18937a = userInfo;
        this.f18938b = fVar;
        this.f18940d = activity;
        this.f18939c = akVar;
    }

    public void a(AddCartMessage addCartMessage) {
        a(addCartMessage, -1, -1, (Promise) null);
    }

    public void a(AddCartMessage addCartMessage, int i2, int i3, Promise promise) {
        AddCartMessage addCartMessage2 = addCartMessage;
        final Promise promise2 = promise;
        int[] iArr = this.k;
        iArr[0] = i2;
        int i4 = 1;
        iArr[1] = i3;
        this.l = promise2;
        if (!addCartMessage.hasStock()) {
            this.f18942f.a(com.garena.android.appkit.tools.b.e(R.string.sp_item_out_of_stock_buy_tip));
            return;
        }
        if (!(!addCartMessage.hasVariations() || (addCartMessage.hasVariations() && addCartMessage2.variations.size() == 1 && addCartMessage.skipPanel())) || addCartMessage.isCanUseWholesale() || addCartMessage.canPickQuantity()) {
            long b2 = com.garena.android.appkit.tools.a.a.b();
            if (!addCartMessage2.viewOnly) {
                i4 = 7;
            }
            if (!this.f18942f.c() && b2 - this.f18943g > 200) {
                this.f18943g = b2;
                Dialog a2 = l.a(this.f18942f.getContext(), addCartMessage2, i4);
                a2.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        a.this.a(promise2, 0, 0, 0);
                    }
                });
                this.f18942f.a(a2);
                return;
            }
            return;
        }
        long j2 = 0;
        if (!this.f18937a.isLoggedIn()) {
            if (!addCartMessage.skipServerRequest()) {
                c.a aVar = new c.a();
                aVar.f21081a = addCartMessage2.itemID;
                aVar.f21082b = "IDR";
                aVar.f21083c = au.a(addCartMessage2.price);
                aVar.f21084d = 1;
                aVar.f21085e = addCartMessage2.shopID;
                if (addCartMessage.hasVariations()) {
                    j2 = addCartMessage2.variations.get(0).modelID;
                }
                aVar.f21086f = j2;
                aVar.f21087g = addCartMessage2;
                com.shopee.app.ui.home.i.f22227a = aVar;
            }
            this.f18942f.d();
        } else if (!addCartMessage.skipServerRequest()) {
            this.f18938b.a(addCartMessage2.itemID, "IDR", au.a(addCartMessage2.price), 1, addCartMessage2.shopID, addCartMessage.getCategoryIDs());
            new g().a(addCartMessage2.itemID, 1, addCartMessage2.shopID, addCartMessage.hasVariations() ? addCartMessage2.variations.get(0).modelID : 0, addCartMessage);
        } else {
            if (addCartMessage.hasVariations()) {
                j2 = addCartMessage2.variations.get(0).modelID;
            }
            a(promise, 1, j2, 1);
        }
        if (addCartMessage.isAddOnly()) {
            this.f18942f.d(addCartMessage2);
        }
    }

    /* access modifiers changed from: private */
    public void a(Promise promise, int i2, long j2, int i3) {
        if (promise != null) {
            o oVar = new o();
            oVar.a("status", (Number) Integer.valueOf(i2));
            oVar.a("selectedModelId", (Number) Long.valueOf(j2));
            oVar.a("quantity", (Number) Integer.valueOf(i3));
            promise.resolve(oVar.toString());
        }
    }

    public void b(AddCartMessage addCartMessage) {
        if (addCartMessage != null) {
            Promise promise = this.l;
            if (promise != null) {
                a(promise, 1, addCartMessage.getSelectedModelId(), addCartMessage.getQuantity());
            }
        }
    }

    public void c(AddCartMessage addCartMessage) {
        if (addCartMessage != null) {
            if (!addCartMessage.skipServerRequest()) {
                if (!addCartMessage.isAddOnly()) {
                    this.f18942f.b(addCartMessage.getPassBackString());
                    this.f18942f.e();
                } else {
                    this.f18942f.f();
                }
            }
            if (this.l != null) {
                o oVar = new o();
                oVar.a("selectedModelId", (Number) Long.valueOf(addCartMessage.getSelectedModelId()));
                oVar.a("quantity", (Number) Integer.valueOf(addCartMessage.getQuantity()));
                this.l.resolve(oVar.toString());
            }
        }
    }

    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            int i2 = aVar.f17892a;
            if (i2 == -100) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
            } else if (i2 == 9 || i2 == 4) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_err_ban_delete);
            } else if (i2 == 5) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_error_exist_offer_in_chart);
            } else if (i2 != 6) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
            } else {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_item_in_cart);
            }
        }
        this.f18942f.c(str);
    }

    public void a() {
        this.f18941e.a();
        this.f18941e.c();
    }

    public void b() {
        this.f18941e.b();
        this.f18941e.d();
    }

    public void a(String str) {
        Activity activity = this.f18940d;
        if (activity != null) {
            q.a(activity.getWindow().getDecorView().getRootView(), str);
        }
    }

    public void a(c.b bVar) {
        this.i = bVar;
    }

    /* access modifiers changed from: package-private */
    public void b(c.b bVar) {
        this.f18942f.a(new c.b(bVar.f21088a, this.k, bVar.f21090c, bVar.f21091d));
    }

    /* access modifiers changed from: package-private */
    public void a(ShareMessage shareMessage) {
        if (this.f18940d != null) {
            boolean a2 = m.a(shareMessage.getShopID());
            int i2 = shareMessage.getmTime();
            String value = ShareDataField.Companion.getValue(shareMessage.getUrl(), shareMessage.getSharingUrls(), "facebook");
            if (a2) {
                if (i2 == 0) {
                    value = value + "?is_owner=1";
                } else {
                    value = value + "?is_owner=1&v=" + i2;
                }
            } else if (i2 != 0) {
                value = value + "?v=" + i2;
            }
            ShareDialog shareDialog = new ShareDialog(this.f18940d);
            if (!ShareDialog.canShow(ShareLinkContent.class)) {
                return;
            }
            if (TextUtils.isEmpty(value)) {
                r.a().b((int) R.string.sp_server_error);
            } else {
                shareDialog.show(((ShareLinkContent.Builder) new ShareLinkContent.Builder().setContentUrl(Uri.parse(value))).build());
            }
        }
    }

    public void d(AddCartMessage addCartMessage) {
        this.i = new c.b(new int[]{(int) (((float) com.garena.android.appkit.tools.b.b()) * addCartMessage.getAddCartStartPercent()), com.garena.android.appkit.tools.b.d() - b.a.t}, this.k, addCartMessage.itemImage, false);
    }

    public void a(Dialog dialog) {
        this.h.add(dialog);
    }

    public boolean c() {
        Activity activity = this.f18940d;
        return activity != null && activity.isFinishing();
    }

    public Context getContext() {
        return this.f18940d;
    }

    public void d() {
        this.f18939c.f();
    }

    public void b(String str) {
        this.f18939c.e(str);
    }

    public void e() {
        for (Dialog dismiss : this.h) {
            dismiss.dismiss();
        }
    }

    public void f() {
        Activity activity = this.f18940d;
        if (activity != null) {
            c.b bVar = this.i;
            if (bVar != null && bVar.f21089b[0] != -1) {
                if (this.j == null) {
                    this.j = new ImageView(getContext());
                }
                this.j.setImageResource(R.drawable.com_garena_shopee_ic_product_default);
                z.b(getContext()).a(this.i.f21090c).a(b.a.t * 2).a((ah) new u()).a(this.j);
                new CartAnimation().activity(activity).cartLocation(this.i.f21089b).startLocation(this.i.f21088a).imageView(this.j).animationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        a.this.e();
                        r.a().a(com.garena.android.appkit.tools.b.e(R.string.sp_add_cart_success));
                    }
                }).build().start();
            }
        }
    }

    public void c(String str) {
        r.a().a(str);
    }

    public void a(e eVar) {
        this.f18942f = eVar;
    }
}
