package com.shopee.feeds.feedlibrary.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.garena.android.appkit.tools.b;
import com.shopee.feeds.feedlibrary.adapter.SelectVoucherRecyclerAdapter;
import com.shopee.feeds.feedlibrary.adapter.a;
import com.shopee.feeds.feedlibrary.b.c;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.PosVoucherEntity;
import com.shopee.feeds.feedlibrary.data.entity.VoucherEntity;
import com.shopee.feeds.feedlibrary.editor.sticker.a.f;
import com.shopee.feeds.feedlibrary.util.b.d;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.view.a.g;
import com.shopee.sdk.ui.a;
import java.util.ArrayList;

public class SelectVoucherActivity extends a implements g {

    /* renamed from: c  reason: collision with root package name */
    private SelectVoucherRecyclerAdapter f27437c;

    /* renamed from: d  reason: collision with root package name */
    private c f27438d;

    /* renamed from: e  reason: collision with root package name */
    private com.shopee.feeds.feedlibrary.view.c.c f27439e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<VoucherEntity> f27440f = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f27441g;
    /* access modifiers changed from: private */
    public f h;
    private d i;
    @BindView
    ImageView ivInfo;
    @BindView
    ImageView ivLeft;
    private a j;
    /* access modifiers changed from: private */
    public boolean k;
    @BindView
    TextView tvNoVoucher;
    @BindView
    TextView tvSelectVoucher;
    @BindView
    RecyclerView voucherRecyclerView;

    public boolean e() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(c.f.feeds_activity_select_voucher);
        ButterKnife.a((Activity) this);
        h();
        this.k = false;
    }

    /* access modifiers changed from: protected */
    @OnClick
    public void onClick(View view) {
        int id = view.getId();
        if (id == c.e.iv_left) {
            finish();
        } else if (id == c.e.iv_info) {
            this.f27439e.a();
        }
    }

    private void h() {
        this.f27441g = com.shopee.feeds.feedlibrary.util.d.b((Activity) this, "type");
        this.i = new d(this, this.voucherRecyclerView, 2, false);
        this.i.a((d.a) new d.a() {
            public void a(int i) {
                SelectVoucherActivity.this.a(i);
            }
        });
        this.f27438d = new com.shopee.feeds.feedlibrary.b.c(this.f7086a, (g) this);
        this.f27439e = new com.shopee.feeds.feedlibrary.view.c.c(this);
        this.f27437c = new SelectVoucherRecyclerAdapter(this);
        this.f27437c.a((a.C0422a) new a.C0422a() {
            public void a(int i, Object obj, View view) {
                if (!SelectVoucherActivity.this.k) {
                    boolean unused = SelectVoucherActivity.this.k = true;
                    PosVoucherEntity posVoucherEntity = new PosVoucherEntity();
                    posVoucherEntity.setType(SelectVoucherActivity.this.f27441g);
                    posVoucherEntity.setVoucherEntity((VoucherEntity) obj);
                    if (SelectVoucherActivity.this.h != null) {
                        posVoucherEntity.setOldInfo(SelectVoucherActivity.this.h);
                    }
                    org.greenrobot.eventbus.c.a().c(posVoucherEntity);
                    SelectVoucherActivity.this.finish();
                }
            }
        });
        this.voucherRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.voucherRecyclerView.setAdapter(this.f27437c);
        this.voucherRecyclerView.a((RecyclerView.h) new com.shopee.feeds.feedlibrary.view.c(this, 1, c.d.feeds_divider_select_voucher_list));
        this.f27438d.b();
        try {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.h = (f) extras.getSerializable("extra_info");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.tvSelectVoucher.setText(b.e(c.g.feeds_nav_bar_title_select_voucher));
        this.j = new com.shopee.sdk.ui.a(this);
        this.j.a(false);
        this.j.a();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.i.c();
        this.j.b();
    }

    public void a(ArrayList<VoucherEntity> arrayList) {
        if (arrayList.size() > 0) {
            this.voucherRecyclerView.setVisibility(0);
            this.tvNoVoucher.setVisibility(8);
            e.a(false, true);
        } else {
            e.a(true, true);
            this.voucherRecyclerView.setVisibility(8);
            this.tvNoVoucher.setVisibility(0);
            this.tvNoVoucher.setText(b.e(c.g.feeds_voucher_list_no_data));
        }
        this.f27437c.a(arrayList);
        this.f27440f.clear();
        this.f27440f.addAll(arrayList);
        this.i.a();
        this.j.b();
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        ArrayList<VoucherEntity> arrayList = this.f27440f;
        if (arrayList != null && arrayList.size() > 0) {
            VoucherEntity voucherEntity = this.f27440f.get(i2);
            if (voucherEntity != null) {
                e.c(voucherEntity.getPromotion_id());
            }
        }
    }
}
