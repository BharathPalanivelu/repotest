package com.shopee.live.livestreaming.ui.anchor.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.g.w;
import androidx.l.p;
import com.devspark.robototextview.widget.RobotoTextView;
import com.facebook.appevents.AppEventsConstants;
import com.garena.android.appkit.tools.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.VoucherEntity;
import com.shopee.live.livestreaming.network.service.InjectorUtils;
import com.shopee.live.livestreaming.network.task.ShowVoucherTask;
import com.shopee.live.livestreaming.ui.anchor.view.ClaimStateView;
import com.shopee.live.livestreaming.ui.view.e;
import com.shopee.live.livestreaming.util.ab;
import com.shopee.live.livestreaming.util.d;
import com.shopee.live.livestreaming.util.f;
import com.shopee.live.livestreaming.util.x;
import com.shopee.sdk.modules.ui.a.a;

public class VoucherStickerItemView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    ShowVoucherTask f28903a;

    /* renamed from: b  reason: collision with root package name */
    a f28904b;

    /* renamed from: c  reason: collision with root package name */
    private RobotoTextView f28905c;

    /* renamed from: d  reason: collision with root package name */
    private ClaimStateView f28906d;

    /* renamed from: e  reason: collision with root package name */
    private RobotoTextView f28907e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ImageView f28908f;

    /* renamed from: g  reason: collision with root package name */
    private int f28909g;
    private long h;
    private boolean i;
    /* access modifiers changed from: private */
    public RelativeLayout j;
    private RelativeLayout k;
    /* access modifiers changed from: private */
    public ImageView l;
    /* access modifiers changed from: private */
    public RobotoTextView m;
    private LinearLayout n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    /* access modifiers changed from: private */
    public boolean s;
    /* access modifiers changed from: private */
    public int t;
    private ObjectAnimator u;
    /* access modifiers changed from: private */
    public VoucherEntity v;

    public interface a {
        void a();

        void b();
    }

    public void setPromotion_id(int i2) {
        this.h = (long) i2;
    }

    public void setmPageMode(int i2) {
        this.f28909g = i2;
    }

    public VoucherStickerItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public VoucherStickerItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VoucherStickerItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.i = true;
        View inflate = LayoutInflater.from(context).inflate(c.f.live_streaming_layout_photo_editor_sticker_voucher_item_view, this, true);
        this.f28905c = (RobotoTextView) inflate.findViewById(c.e.tv_voucher);
        this.f28906d = (ClaimStateView) inflate.findViewById(c.e.claim_state_view);
        this.f28907e = (RobotoTextView) inflate.findViewById(c.e.tv_describe);
        this.f28908f = (ImageView) inflate.findViewById(c.e.iv_close_voucher);
        this.j = (RelativeLayout) inflate.findViewById(c.e.rl_voucher_container);
        this.k = (RelativeLayout) inflate.findViewById(c.e.rl_status);
        this.n = (LinearLayout) inflate.findViewById(c.e.ll_voucher_info);
        this.l = (ImageView) inflate.findViewById(c.e.iv_voucher_edge);
        this.m = (RobotoTextView) inflate.findViewById(c.e.tv_voucher_dismiss_time);
        this.f28903a = InjectorUtils.provideShowVoucherTask();
        this.f28906d.setClaimCallback(new ClaimStateView.a() {
            public void a() {
                VoucherStickerItemView.this.b();
                if (VoucherStickerItemView.this.f28904b != null) {
                    VoucherStickerItemView.this.f28904b.a();
                }
            }

            public void b() {
                VoucherStickerItemView.this.b();
                if (VoucherStickerItemView.this.f28904b != null) {
                    VoucherStickerItemView.this.f28904b.b();
                }
            }

            public void c() {
                VoucherStickerItemView.this.b();
                if (VoucherStickerItemView.this.f28904b != null) {
                    VoucherStickerItemView.this.f28904b.b();
                }
            }

            public void a(int i, String str) {
                int unused = VoucherStickerItemView.this.t = i;
                VoucherStickerItemView.this.m.setText(str);
            }
        });
        this.f28908f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VoucherStickerItemView.this.i();
            }
        });
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VoucherStickerItemView.this.a(true, true);
            }
        });
        this.r = b.d(c.C0439c.live_streaming_voucher_right_width);
        this.l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (VoucherStickerItemView.this.d()) {
                    VoucherStickerItemView.this.a(true, false);
                } else {
                    VoucherStickerItemView.this.a(true, true);
                }
            }
        });
    }

    private void h() {
        com.shopee.sdk.b.a().c().a((Activity) getContext(), new a.C0472a().c(b.e(c.g.live_streaming_common_btn_ok)).d(b.e(c.g.live_streaming_btn_cancel)).b(b.e(c.g.live_streaming_msg_close_showing_voucher)).a(), new com.shopee.sdk.f.b<Integer>() {
            public void a(int i, String str) {
            }

            public void a(Integer num) {
                int intValue = num.intValue();
                int i = 0;
                int i2 = 1;
                if (intValue != 0) {
                    if (intValue == 1) {
                        VoucherStickerItemView.this.j();
                        if (VoucherStickerItemView.this.v != null) {
                            if (VoucherStickerItemView.this.v.getShop_id() != 0) {
                                i = 1;
                            }
                            com.shopee.live.livestreaming.ui.anchor.b.c(VoucherStickerItemView.this.v.getPromotion_id(), VoucherStickerItemView.this.v.getVoucher_code(), i, true);
                            return;
                        }
                        return;
                    } else if (intValue != 2) {
                        return;
                    }
                }
                if (VoucherStickerItemView.this.v != null) {
                    if (VoucherStickerItemView.this.v.getShop_id() == 0) {
                        i2 = 0;
                    }
                    com.shopee.live.livestreaming.ui.anchor.b.c(VoucherStickerItemView.this.v.getPromotion_id(), VoucherStickerItemView.this.v.getVoucher_code(), i2, false);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void i() {
        if (this.t > 0) {
            h();
            return;
        }
        j();
        VoucherEntity voucherEntity = this.v;
        if (voucherEntity != null) {
            com.shopee.live.livestreaming.ui.anchor.b.c(this.v.getPromotion_id(), this.v.getVoucher_code(), voucherEntity.getShop_id() == 0 ? 0 : 1, true);
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        this.f28903a.execute(new ShowVoucherTask.Data(f.a().f(), (VoucherEntity) null), new ShowVoucherTask.Callback() {
            public void onError(int i, String str) {
            }

            public void showSuccess() {
                VoucherStickerItemView.this.b();
                if (VoucherStickerItemView.this.f28904b != null) {
                    VoucherStickerItemView.this.f28904b.b();
                }
            }
        });
    }

    public void a(VoucherEntity voucherEntity) {
        if (c(voucherEntity)) {
            this.f28908f.setVisibility(0);
            setVoucherInfo(voucherEntity);
            this.f28906d.g();
            this.s = true;
            f();
        }
    }

    public void a(int i2, VoucherEntity voucherEntity, long j2, int i3) {
        if (c(voucherEntity) && this.h != voucherEntity.getPromotion_id()) {
            this.f28908f.setVisibility(8);
            setVoucherInfo(voucherEntity);
            this.h = voucherEntity.getPromotion_id();
            this.f28906d.setmVoucherEntity(voucherEntity);
            this.f28906d.setmCreateTime(j2);
            this.f28906d.h();
            this.f28906d.setAudienceUnClaimState(i2);
            a();
            f();
        }
    }

    public boolean b(VoucherEntity voucherEntity) {
        return this.f28906d.b(voucherEntity);
    }

    public void a() {
        this.f28906d.i();
    }

    public void b() {
        g();
        this.h = 0;
        this.f28906d.a();
    }

    public void setVoucherInfo(VoucherEntity voucherEntity) {
        String str;
        String str2;
        if (voucherEntity != null) {
            this.v = voucherEntity;
            this.f28906d.setmVoucherEntity(voucherEntity);
            int reward_type = voucherEntity.getReward_type();
            String a2 = a(voucherEntity.getMin_spend());
            int i2 = c.d.live_streaming_ic_discount_percent_voucher;
            String str3 = "";
            if (reward_type == 0) {
                if (d.a(voucherEntity.getDiscount_value()) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(voucherEntity.getDiscount_value())) {
                    if (voucherEntity.getDiscount_percentage() > 0) {
                        str2 = b.a(c.g.live_streaming_off, ab.a(voucherEntity.getDiscount_percentage()));
                    }
                    if (!d.a(voucherEntity.getDiscount_cap()) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(voucherEntity.getDiscount_cap())) {
                        str = b.a(c.g.live_streaming_discount_minspend_without_off, a2);
                    } else {
                        String a3 = a(voucherEntity.getDiscount_cap());
                        str = b.a(c.g.live_streaming_discount_minspend_and_cap_without_off, a2, a3);
                    }
                } else {
                    String a4 = a(voucherEntity.getDiscount_value());
                    if (x.d()) {
                        str2 = String.format(b.a(c.g.live_streaming_off_tw, a4), new Object[0]);
                    } else {
                        str2 = String.format(b.a(c.g.live_streaming_off, a4), new Object[0]);
                    }
                }
                str3 = str2;
                if (!d.a(voucherEntity.getDiscount_cap())) {
                }
                str = b.a(c.g.live_streaming_discount_minspend_without_off, a2);
            } else if (reward_type == 1) {
                int i3 = c.g.live_streaming_cashback;
                str3 = b.a(i3, String.valueOf(voucherEntity.getCoin_percentage_real()) + "%");
                if (d.a(voucherEntity.getCoin_cap()) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(voucherEntity.getCoin_cap())) {
                    str = b.a(c.g.live_streaming_discount_minspend_without_off, a2);
                } else {
                    String b2 = b(voucherEntity.getCoin_cap());
                    str = b.a(c.g.live_streaming_discount_minspend_and_cap_without_off_coins, a2, b2);
                }
            } else if (reward_type != 2) {
                str = str3;
            } else {
                str3 = b.e(c.g.live_streaming_voucher_freeshipping);
                str = b.a(c.g.live_streaming_discount_minspend_without_off, a2);
                i2 = c.d.live_streaming_ic_free_shipping_voucher;
            }
            this.l.setImageResource(i2);
            if (!d.a(str3)) {
                this.f28905c.setText(str3);
            }
            if (!d.a(str)) {
                this.f28907e.setText(str);
            }
        }
    }

    private String a(String str) {
        if (d.a(str)) {
            return "";
        }
        if (x.d()) {
            return ab.a() + ab.b(str);
        }
        return ab.a() + ab.a(str, 1);
    }

    private String b(String str) {
        if (!d.a(str)) {
            return x.d() ? ab.b(str) : str;
        }
        return "";
    }

    public void c() {
        this.f28906d.f();
    }

    public boolean d() {
        return this.i;
    }

    public void setExpand(boolean z) {
        this.i = z;
    }

    public boolean e() {
        return this.o;
    }

    public void setAnimating(boolean z) {
        this.o = z;
    }

    public void f() {
        if (getVisibility() == 8) {
            a((float) BitmapDescriptorFactory.HUE_RED, 1.0f, 200);
            VoucherEntity voucherEntity = this.v;
            if (voucherEntity != null) {
                com.shopee.live.livestreaming.ui.audience.c.a(this.v.getPromotion_id(), this.v.getVoucher_code(), voucherEntity.getShop_id() == 0 ? 0 : 1);
            }
        }
    }

    public void g() {
        if (getVisibility() == 0) {
            a(1.0f, (float) BitmapDescriptorFactory.HUE_RED, 200);
        }
    }

    public void a(boolean z, boolean z2) {
        if (z && d() != z2) {
            VoucherEntity voucherEntity = this.v;
            if (voucherEntity != null) {
                com.shopee.live.livestreaming.ui.audience.c.a(this.v.getPromotion_id(), this.v.getVoucher_code(), z2, voucherEntity.getShop_id() == 0 ? 0 : 1);
            }
        }
        a(z2);
    }

    public void a(boolean z) {
        a(z, 250);
    }

    /* access modifiers changed from: private */
    public void a(final boolean z, final long j2) {
        if (d() != z && !e() && getVisibility() != 8) {
            setExpand(z);
            setAnimating(true);
            com.garena.android.appkit.f.f.a().a(new Runnable() {
                public void run() {
                    VoucherStickerItemView.this.b(z, j2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b(final boolean z, long j2) {
        if (this.p == 0) {
            this.p = this.l.getMeasuredWidth() + b.d(c.C0439c.live_streaming_voucher_info_text_max_width) + (b.d(c.C0439c.live_streaming_voucher_left_container_padding) * 2);
        }
        if (this.l.getMeasuredWidth() != 0) {
            this.q = this.l.getMeasuredWidth() + (b.d(c.C0439c.live_streaming_voucher_left_container_padding) * 2);
        }
        if (this.k.getMeasuredWidth() != 0) {
            this.r = this.k.getMeasuredWidth();
        }
        Rect rect = new Rect(0, 0, 0, this.n.getMeasuredHeight());
        androidx.l.d dVar = new androidx.l.d();
        dVar.a(j2);
        p.a(this, dVar);
        LinearLayout linearLayout = this.n;
        if (z) {
            rect = null;
        }
        w.a((View) linearLayout, rect);
        final float f2 = (float) (-b.d(c.C0439c.live_streaming_voucher_edge_translation_y));
        this.m.setVisibility(0);
        e a2 = new e(this.j, z ? this.q : this.p, z ? this.p : this.q, this.j.getMeasuredHeight(), this.j.getMeasuredHeight()).a(j2).a((e.a) new e.a() {
            public void a(float f2) {
                if (f2 >= 1.0f) {
                    VoucherStickerItemView.this.setAnimating(false);
                }
                if (z && f2 <= BitmapDescriptorFactory.HUE_RED) {
                    VoucherStickerItemView.this.j.setBackground(b.f(c.d.live_streaming_bg_voucher_left));
                    int d2 = b.d(c.C0439c.live_streaming_voucher_left_container_padding);
                    VoucherStickerItemView.this.j.setPadding(d2, d2, d2, d2);
                } else if (!z && f2 == 1.0f) {
                    VoucherStickerItemView.this.j.setBackground(b.f(c.d.live_streaming_bg_voucher_scroll));
                    int d3 = b.d(c.C0439c.live_streaming_voucher_left_container_padding);
                    VoucherStickerItemView.this.j.setPadding(d3, d3, d3, d3);
                }
                if (z) {
                    ImageView f3 = VoucherStickerItemView.this.l;
                    float f4 = f2;
                    f3.setTranslationY(f4 + ((BitmapDescriptorFactory.HUE_RED - f4) * f2));
                    VoucherStickerItemView voucherStickerItemView = VoucherStickerItemView.this;
                    voucherStickerItemView.a((View) voucherStickerItemView.m, 1.0f - f2);
                    if (VoucherStickerItemView.this.s) {
                        VoucherStickerItemView voucherStickerItemView2 = VoucherStickerItemView.this;
                        voucherStickerItemView2.a((View) voucherStickerItemView2.f28908f, f2);
                        return;
                    }
                    return;
                }
                VoucherStickerItemView.this.l.setTranslationY((f2 * f2) + BitmapDescriptorFactory.HUE_RED);
                VoucherStickerItemView voucherStickerItemView3 = VoucherStickerItemView.this;
                voucherStickerItemView3.a((View) voucherStickerItemView3.m, f2);
                if (VoucherStickerItemView.this.s) {
                    VoucherStickerItemView voucherStickerItemView4 = VoucherStickerItemView.this;
                    voucherStickerItemView4.a((View) voucherStickerItemView4.f28908f, 1.0f - f2);
                }
            }
        });
        int max = Math.max(this.r, this.k.getMeasuredHeight());
        e a3 = new e(this.k, z ? 0 : max, z ? max : 0, -1, -1).a(j2);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(a3);
        animationSet.addAnimation(a2);
        animationSet.setDuration(j2);
        startAnimation(animationSet);
    }

    private void a(float f2, final float f3, int i2) {
        if (!e()) {
            setAnimating(true);
            ObjectAnimator objectAnimator = this.u;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.u.cancel();
            }
            this.u = ObjectAnimator.ofFloat(this, "alpha", new float[]{f2, f3});
            setVisibility(0);
            setAlpha(f2);
            this.u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    VoucherStickerItemView.this.setAnimating(false);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float f2 = f3;
                    if (f2 == BitmapDescriptorFactory.HUE_RED && floatValue <= f2) {
                        VoucherStickerItemView.this.setVisibility(4);
                        VoucherStickerItemView.this.a(true, 0);
                        VoucherStickerItemView.this.setVisibility(8);
                    }
                }
            });
            this.u.setDuration((long) i2);
            this.u.start();
        }
    }

    /* access modifiers changed from: private */
    public void a(View view, float f2) {
        if (f2 >= BitmapDescriptorFactory.HUE_RED && f2 <= 1.0f) {
            if (f2 <= 0.3f) {
                view.setAlpha(f2);
                view.setVisibility(8);
                return;
            }
            view.setVisibility(0);
            view.setAlpha(f2);
        }
    }

    private boolean c(VoucherEntity voucherEntity) {
        if (voucherEntity != null && voucherEntity.getPromotion_id() != 0 && !TextUtils.isEmpty(voucherEntity.getVoucher_code()) && voucherEntity.getReward_type() >= 0 && voucherEntity.getReward_type() <= 2) {
            return true;
        }
        return false;
    }

    public void setVoucherCallback(a aVar) {
        this.f28904b = aVar;
    }
}
