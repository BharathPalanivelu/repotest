package com.shopee.feeds.feedlibrary.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.a.a;
import butterknife.a.b;
import com.shopee.feeds.feedlibrary.c;

public class SelectVoucherActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private SelectVoucherActivity f27444b;

    /* renamed from: c  reason: collision with root package name */
    private View f27445c;

    /* renamed from: d  reason: collision with root package name */
    private View f27446d;

    public SelectVoucherActivity_ViewBinding(final SelectVoucherActivity selectVoucherActivity, View view) {
        this.f27444b = selectVoucherActivity;
        View a2 = b.a(view, c.e.iv_left, "field 'ivLeft' and method 'onClick'");
        selectVoucherActivity.ivLeft = (ImageView) b.b(a2, c.e.iv_left, "field 'ivLeft'", ImageView.class);
        this.f27445c = a2;
        a2.setOnClickListener(new a() {
            public void a(View view) {
                selectVoucherActivity.onClick(view);
            }
        });
        selectVoucherActivity.tvSelectVoucher = (TextView) b.a(view, c.e.tv_select_voucher, "field 'tvSelectVoucher'", TextView.class);
        View a3 = b.a(view, c.e.iv_info, "field 'ivInfo' and method 'onClick'");
        selectVoucherActivity.ivInfo = (ImageView) b.b(a3, c.e.iv_info, "field 'ivInfo'", ImageView.class);
        this.f27446d = a3;
        a3.setOnClickListener(new a() {
            public void a(View view) {
                selectVoucherActivity.onClick(view);
            }
        });
        selectVoucherActivity.tvNoVoucher = (TextView) b.a(view, c.e.tv_no_voucher_hint, "field 'tvNoVoucher'", TextView.class);
        selectVoucherActivity.voucherRecyclerView = (RecyclerView) b.a(view, c.e.select_voucher_list, "field 'voucherRecyclerView'", RecyclerView.class);
    }
}
