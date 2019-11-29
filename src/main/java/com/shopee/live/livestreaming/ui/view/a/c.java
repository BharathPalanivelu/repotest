package com.shopee.live.livestreaming.ui.view.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.devspark.robototextview.widget.RobotoTextView;
import com.facebook.appevents.AppEventsConstants;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.VoucherEntity;
import com.shopee.live.livestreaming.data.entity.VoucherListItem;
import com.shopee.live.livestreaming.network.service.InjectorUtils;
import com.shopee.live.livestreaming.network.task.ShowVoucherTask;
import com.shopee.live.livestreaming.util.ab;
import com.shopee.live.livestreaming.util.f;
import com.shopee.live.livestreaming.util.x;
import com.shopee.live.livestreaming.util.z;

public class c extends com.shopee.live.livestreaming.a.d<VoucherListItem> {

    /* renamed from: e  reason: collision with root package name */
    ShowVoucherTask f29211e = InjectorUtils.provideShowVoucherTask();

    /* renamed from: f  reason: collision with root package name */
    C0444c f29212f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f29213g = -1;
    /* access modifiers changed from: private */
    public int h = -1;
    /* access modifiers changed from: private */
    public String i = "";

    /* renamed from: com.shopee.live.livestreaming.ui.view.a.c$c  reason: collision with other inner class name */
    public interface C0444c {
        void a(int i, VoucherEntity voucherEntity);

        void b(int i, VoucherEntity voucherEntity);

        void c(int i, VoucherEntity voucherEntity);
    }

    public c(Context context) {
        super(context);
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return new b(this.f28753c.inflate(c.f.live_streaming_layout_voucher_title, viewGroup, false));
        }
        if (i2 == 2) {
            return new d(this.f28753c.inflate(c.f.live_streaming_layout_voucher_list_item, viewGroup, false));
        }
        if (i2 != 3) {
            return null;
        }
        return new a(this.f28753c.inflate(c.f.live_streaming_layout_voucher_line, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.w wVar, int i2) {
        VoucherListItem voucherListItem = (VoucherListItem) this.f28752b.get(i2);
        int type = voucherListItem.getType();
        if (type == 1) {
            a((b) wVar, voucherListItem.getTitle());
        } else if (type == 2) {
            a(voucherListItem.getVoucherEntity(), (d) wVar, i2);
        }
    }

    private void a(b bVar, String str) {
        if (!com.shopee.live.livestreaming.util.d.a(str)) {
            bVar.f29219b.setText(str);
        }
    }

    private void a(final VoucherEntity voucherEntity, final d dVar, final int i2) {
        String str;
        boolean z;
        String str2;
        String str3;
        if (voucherEntity != null) {
            int reward_type = voucherEntity.getReward_type();
            String c2 = c(voucherEntity.getMin_spend());
            if (reward_type == 0) {
                dVar.f29220b.setImageResource(c.d.live_streaming_ic_discount_percent_voucher);
                if (com.shopee.live.livestreaming.util.d.a(voucherEntity.getDiscount_value()) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(voucherEntity.getDiscount_value())) {
                    str = voucherEntity.getDiscount_percentage() > 0 ? ab.a(voucherEntity.getDiscount_percentage()) : "";
                    z = false;
                } else {
                    str = c(voucherEntity.getDiscount_value());
                    z = true;
                }
                if (!com.shopee.live.livestreaming.util.d.a(voucherEntity.getDiscount_cap()) && !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(voucherEntity.getDiscount_cap())) {
                    String c3 = c(voucherEntity.getDiscount_cap());
                    if (!x.d() || !z) {
                        str2 = com.garena.android.appkit.tools.b.a(c.g.live_streaming_discount_with_minspend_and_cap, str, c2, c3);
                    } else {
                        str2 = com.garena.android.appkit.tools.b.a(c.g.live_streaming_discount_with_minspend_and_cap_tw, str, c2, c3);
                    }
                } else if (!x.d() || !z) {
                    str2 = com.garena.android.appkit.tools.b.a(c.g.live_streaming_discount_with_minspend, str, c2);
                } else {
                    str2 = com.garena.android.appkit.tools.b.a(c.g.live_streaming_discount_with_minspend_tw, str, c2);
                }
                if (voucherEntity.getUse_type() == 1) {
                    str2 = b(str2);
                }
                dVar.f29221c.setText(str2);
            } else if (reward_type == 1) {
                dVar.f29220b.setImageResource(c.d.live_streaming_ic_discount_percent_voucher);
                String str4 = String.valueOf(voucherEntity.getCoin_percentage_real()) + "%";
                if (com.shopee.live.livestreaming.util.d.a(voucherEntity.getCoin_cap()) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(voucherEntity.getCoin_cap())) {
                    str3 = com.garena.android.appkit.tools.b.a(c.g.live_streaming_cashback_with_minspend, str4, c2);
                } else {
                    str3 = com.garena.android.appkit.tools.b.a(c.g.live_streaming_cashback_with_minspend_and_cap, str4, c2, c(voucherEntity.getCoin_cap()));
                }
                if (voucherEntity.getUse_type() == 1) {
                    str3 = b(str3);
                }
                dVar.f29221c.setText(str3);
            } else if (reward_type != 2) {
                dVar.f29220b.setImageResource(c.d.live_streaming_ic_discount_percent_voucher);
            } else {
                dVar.f29221c.setText(com.garena.android.appkit.tools.b.a(c.g.live_streaming_host_voucher_freeshipping, c2));
                dVar.f29220b.setImageResource(c.d.live_streaming_ic_free_shipping_voucher);
            }
            dVar.f29222d.setText(com.garena.android.appkit.tools.b.a(c.g.live_streaming_vall_till, ab.d(String.valueOf(voucherEntity.getEnd_time()))));
            if (!this.i.equals(String.valueOf(voucherEntity.getPromotion_id()))) {
                a(dVar);
                dVar.f29223e.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        int i = 1;
                        if (f.a().n()) {
                            z.a(c.this.f28751a, com.garena.android.appkit.tools.b.e(c.g.live_streaming_msg_showing_voucher_conflict));
                            VoucherEntity voucherEntity = voucherEntity;
                            if (voucherEntity != null) {
                                if (voucherEntity.getShop_id() == 0) {
                                    i = 0;
                                }
                                com.shopee.live.livestreaming.ui.anchor.b.b(voucherEntity.getPromotion_id(), voucherEntity.getVoucher_code(), i, false);
                            }
                        } else if (i2 != c.this.f29213g) {
                            c.this.b(dVar);
                            if (c.this.f29212f != null) {
                                c.this.f29212f.a(i2, voucherEntity);
                            }
                            c.this.f29211e.execute(new ShowVoucherTask.Data(f.a().f(), voucherEntity), new ShowVoucherTask.Callback() {
                                public void showSuccess() {
                                    String unused = c.this.i = String.valueOf(voucherEntity.getPromotion_id());
                                    int unused2 = c.this.h = c.this.f29213g;
                                    int unused3 = c.this.f29213g = i2;
                                    c.this.notifyItemChanged(c.this.h);
                                    c.this.notifyItemChanged(c.this.f29213g);
                                    if (c.this.f29212f != null) {
                                        c.this.f29212f.b(i2, voucherEntity);
                                    }
                                }

                                public void onError(int i, String str) {
                                    if (!com.shopee.live.livestreaming.util.d.a(str)) {
                                        z.a(c.this.f28751a, str);
                                    }
                                    if (c.this.f29212f != null) {
                                        c.this.f29212f.c(i2, voucherEntity);
                                    }
                                    c.this.a(dVar);
                                    if (voucherEntity != null) {
                                        com.shopee.live.livestreaming.ui.anchor.b.b(voucherEntity.getPromotion_id(), voucherEntity.getVoucher_code(), voucherEntity.getShop_id() == 0 ? 0 : 1, false);
                                    }
                                }
                            });
                        } else {
                            VoucherEntity voucherEntity2 = voucherEntity;
                            if (voucherEntity2 != null) {
                                if (voucherEntity2.getShop_id() == 0) {
                                    i = 0;
                                }
                                com.shopee.live.livestreaming.ui.anchor.b.b(voucherEntity.getPromotion_id(), voucherEntity.getVoucher_code(), i, false);
                            }
                        }
                    }
                });
                return;
            }
            this.f29213g = i2;
            c(dVar);
        }
    }

    private String b(String str) {
        return SQLBuilder.PARENTHESES_LEFT + com.garena.android.appkit.tools.b.e(c.g.live_streaming_host_voucher_limited) + ") " + str;
    }

    public int getItemViewType(int i2) {
        VoucherListItem voucherListItem = (VoucherListItem) this.f28752b.get(i2);
        if (voucherListItem.isVoucher()) {
            return 2;
        }
        if (voucherListItem.isTitle()) {
            return 1;
        }
        return voucherListItem.isLine() ? 3 : 0;
    }

    /* access modifiers changed from: private */
    public void a(d dVar) {
        dVar.f29224f.setVisibility(8);
        dVar.f29223e.setVisibility(0);
        dVar.f29225g.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void b(d dVar) {
        dVar.f29224f.setVisibility(8);
        dVar.f29223e.setVisibility(8);
        dVar.f29225g.setVisibility(0);
    }

    private void c(d dVar) {
        dVar.f29224f.setVisibility(0);
        dVar.f29223e.setVisibility(8);
        dVar.f29225g.setVisibility(8);
    }

    private String c(String str) {
        if (com.shopee.live.livestreaming.util.d.a(str)) {
            return "";
        }
        if (x.d()) {
            return ab.a() + ab.b(str);
        }
        return ab.a() + ab.a(str, 1);
    }

    static class d extends com.shopee.live.livestreaming.a.f {

        /* renamed from: b  reason: collision with root package name */
        ImageView f29220b = ((ImageView) a(c.e.iv_voucher_edge));

        /* renamed from: c  reason: collision with root package name */
        RobotoTextView f29221c = ((RobotoTextView) a(c.e.tv_voucher_value));

        /* renamed from: d  reason: collision with root package name */
        RobotoTextView f29222d = ((RobotoTextView) a(c.e.tv_valid_till));

        /* renamed from: e  reason: collision with root package name */
        RobotoTextView f29223e = ((RobotoTextView) a(c.e.tv_show));

        /* renamed from: f  reason: collision with root package name */
        RobotoTextView f29224f = ((RobotoTextView) a(c.e.tv_showing));

        /* renamed from: g  reason: collision with root package name */
        ProgressBar f29225g = ((ProgressBar) a(c.e.loading_progress));
        RelativeLayout h = ((RelativeLayout) a(c.e.rl_show));

        public d(View view) {
            super(view);
            this.f29223e.setText(com.garena.android.appkit.tools.b.e(c.g.live_streaming_host_related_products_btn_show));
            this.f29224f.setText(com.garena.android.appkit.tools.b.e(c.g.live_streaming_host_related_products_btn_showing));
        }
    }

    static class b extends com.shopee.live.livestreaming.a.f {

        /* renamed from: b  reason: collision with root package name */
        RobotoTextView f29219b = ((RobotoTextView) a(c.e.tv_shopee_voucher_title));

        public b(View view) {
            super(view);
        }
    }

    static class a extends RecyclerView.w {
        public a(View view) {
            super(view);
        }
    }

    public int a() {
        return this.f29213g;
    }

    public String b() {
        String str = this.i;
        return str == null ? "" : str;
    }

    public void a(String str) {
        this.i = str;
    }

    public void a(C0444c cVar) {
        this.f29212f = cVar;
    }
}
