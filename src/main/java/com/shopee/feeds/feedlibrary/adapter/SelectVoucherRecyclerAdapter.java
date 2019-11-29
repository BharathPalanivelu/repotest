package com.shopee.feeds.feedlibrary.adapter;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.a.b;
import com.devspark.robototextview.widget.RobotoTextView;
import com.facebook.appevents.AppEventsConstants;
import com.shopee.arcatch.data.common_bean.Country;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.VoucherEntity;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.v;

public class SelectVoucherRecyclerAdapter extends a<VoucherEntity> {

    public class Holder_ViewBinding implements Unbinder {

        /* renamed from: b  reason: collision with root package name */
        private Holder f27536b;

        public Holder_ViewBinding(Holder holder, View view) {
            this.f27536b = holder;
            holder.tvVoucherOff = (RobotoTextView) b.a(view, c.e.tv_voucher_off, "field 'tvVoucherOff'", RobotoTextView.class);
            holder.tvCoinsCashback = (TextView) b.a(view, c.e.tv_coins_cash_back, "field 'tvCoinsCashback'", TextView.class);
            holder.tvTitle = (TextView) b.a(view, c.e.tv_title, "field 'tvTitle'", TextView.class);
            holder.tvValidTill = (TextView) b.a(view, c.e.tv_valid_till, "field 'tvValidTill'", TextView.class);
            holder.ivVoucherEdge = (ImageView) b.a(view, c.e.iv_voucher_edge, "field 'ivVoucherEdge'", ImageView.class);
            holder.rlOffInfo = (RelativeLayout) b.a(view, c.e.rl_off_info, "field 'rlOffInfo'", RelativeLayout.class);
        }
    }

    public SelectVoucherRecyclerAdapter(Context context) {
        super(context);
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new Holder(this.f27559c.inflate(c.f.feeds_layout_select_voucher_list_item, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.w wVar, final int i) {
        final Holder holder = (Holder) wVar;
        final VoucherEntity voucherEntity = (VoucherEntity) this.f27558b.get(i);
        int reward_type = voucherEntity.getReward_type();
        if (reward_type == 0) {
            String b2 = v.b();
            if (!d.a(voucherEntity.getDiscount_value()) && !voucherEntity.getDiscount_value().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                if (Country.COUNTRY_VN.equals(b2) || "ID".equals(b2)) {
                    holder.tvVoucherOff.setText(v.b(voucherEntity.getDiscount_value(), 1));
                } else {
                    RobotoTextView robotoTextView = holder.tvVoucherOff;
                    robotoTextView.setText(v.a() + v.b(voucherEntity.getDiscount_value(), 1));
                }
                TextView textView = holder.tvTitle;
                int i2 = c.g.feeds_voucher_sticker_min_spend;
                textView.setText(com.garena.android.appkit.tools.b.a(i2, v.a() + v.b(voucherEntity.getMin_spend(), 1)));
            } else if (voucherEntity.getDiscount_percent() > 0) {
                if (Country.COUNTRY_TW.equals(b2)) {
                    holder.tvVoucherOff.setText(com.garena.android.appkit.tools.b.a(c.g.feeds_voucher_sticker_view_off_label, v.a(voucherEntity.getDiscount_percent())));
                } else {
                    RobotoTextView robotoTextView2 = holder.tvVoucherOff;
                    robotoTextView2.setText(voucherEntity.getDiscount_percent() + "%");
                }
            }
            holder.tvCoinsCashback.setVisibility(8);
            a(holder.tvTitle, voucherEntity.getMin_spend(), voucherEntity.getDiscount_cap(), false);
            holder.ivVoucherEdge.setImageDrawable(com.garena.android.appkit.tools.b.f(c.d.feeds_bg_select_voucher_edge));
            holder.rlOffInfo.setBackgroundResource(c.b.main_color);
        } else if (reward_type == 1) {
            RobotoTextView robotoTextView3 = holder.tvVoucherOff;
            robotoTextView3.setText(String.valueOf(voucherEntity.getCoin_percentage_real()) + "%");
            holder.tvCoinsCashback.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_voucher_coins_cashback));
            holder.tvCoinsCashback.setVisibility(0);
            a(holder.tvTitle, voucherEntity.getMin_spend(), voucherEntity.getCoin_cap(), true);
            holder.ivVoucherEdge.setImageDrawable(com.garena.android.appkit.tools.b.f(c.d.feeds_bg_select_voucher_edge));
        }
        holder.tvVoucherOff.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                holder.tvVoucherOff.getViewTreeObserver().removeOnPreDrawListener(this);
                if (holder.tvVoucherOff.getLineCount() <= 1) {
                    return false;
                }
                SelectVoucherRecyclerAdapter.this.a(holder.tvVoucherOff);
                return false;
            }
        });
        holder.tvValidTill.setText(com.garena.android.appkit.tools.b.a(c.g.feeds_voucher_end_time, v.f(voucherEntity.getEnd_time())));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (SelectVoucherRecyclerAdapter.this.f27560d != null) {
                    e.d(voucherEntity.getPromotion_id());
                    SelectVoucherRecyclerAdapter.this.f27560d.a(i, SelectVoucherRecyclerAdapter.this.f27558b.get(i), (View) null);
                }
            }
        });
    }

    private void a(TextView textView, String str, String str2, boolean z) {
        if (d.a(str)) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        if (d.a(str2) || str2.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            int i = c.g.feeds_voucher_sticker_min_spend;
            textView.setText(com.garena.android.appkit.tools.b.a(i, v.a() + v.b(str, 1)));
            return;
        }
        String a2 = !z ? v.a() : "";
        if (z) {
            int i2 = c.g.feeds_voucher_sticker_min_spend_with_capped_for_coin_cashback;
            textView.setText(com.garena.android.appkit.tools.b.a(i2, v.a() + v.b(str, 1), a2 + v.d(str2)));
            return;
        }
        int i3 = c.g.feeds_voucher_sticker_min_spend_with_capped;
        textView.setText(com.garena.android.appkit.tools.b.a(i3, v.a() + v.b(str, 1), a2 + v.b(str2, 1)));
    }

    public static class Holder extends RecyclerView.w {
        @BindView
        ImageView ivVoucherEdge;
        @BindView
        RelativeLayout rlOffInfo;
        @BindView
        TextView tvCoinsCashback;
        @BindView
        TextView tvTitle;
        @BindView
        TextView tvValidTill;
        @BindView
        RobotoTextView tvVoucherOff;

        public Holder(View view) {
            super(view);
            ButterKnife.a(this, view);
        }
    }

    /* access modifiers changed from: private */
    public void a(RobotoTextView robotoTextView) {
        int width = (robotoTextView.getWidth() - robotoTextView.getPaddingLeft()) - robotoTextView.getPaddingRight();
        if (width > 0) {
            TextPaint textPaint = new TextPaint(robotoTextView.getPaint());
            float textSize = textPaint.getTextSize();
            float f2 = 2.0f;
            while (textSize - f2 > 0.5f) {
                float f3 = (textSize + f2) / 2.0f;
                textPaint.setTextSize(f3);
                float f4 = (float) width;
                if (textPaint.measureText(robotoTextView.getText().toString()) >= f4) {
                    textSize = f3;
                } else if (textPaint.measureText(robotoTextView.getText().toString()) < f4) {
                    f2 = f3;
                }
            }
            robotoTextView.setTextSize(0, f2);
        }
    }
}
