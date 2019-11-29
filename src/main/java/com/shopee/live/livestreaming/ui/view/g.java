package com.shopee.live.livestreaming.ui.view;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.VoucherEntity;
import com.shopee.live.livestreaming.data.entity.VoucherListEntity;
import com.shopee.live.livestreaming.data.entity.VoucherListItem;
import com.shopee.live.livestreaming.network.service.InjectorUtils;
import com.shopee.live.livestreaming.network.task.GetVoucherListTask;
import com.shopee.live.livestreaming.ui.anchor.b;
import com.shopee.live.livestreaming.ui.view.a.c;
import com.shopee.live.livestreaming.util.ad;
import com.shopee.live.livestreaming.util.d;
import com.shopee.live.livestreaming.util.f;
import com.shopee.live.livestreaming.util.z;
import java.util.ArrayList;
import java.util.List;

public class g extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    Context f29349a;

    /* renamed from: b  reason: collision with root package name */
    RecyclerView f29350b;

    /* renamed from: c  reason: collision with root package name */
    TextView f29351c;

    /* renamed from: d  reason: collision with root package name */
    ProgressBar f29352d;

    /* renamed from: e  reason: collision with root package name */
    GetVoucherListTask f29353e;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<VoucherListItem> f29354f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    a f29355g;
    private String h;
    private int i;
    /* access modifiers changed from: private */
    public c j;
    /* access modifiers changed from: private */
    public ArrayList<VoucherListItem> k = new ArrayList<>();
    private ad l;
    /* access modifiers changed from: private */
    public List<Long> m;

    public interface a {
        void a();

        void a(VoucherEntity voucherEntity, String str);

        void a(ArrayList<VoucherListItem> arrayList, int i, int i2);

        void b(VoucherEntity voucherEntity, String str);
    }

    public static g a(String str, ArrayList<VoucherListItem> arrayList, int i2) {
        g gVar = new g();
        Bundle bundle = new Bundle();
        bundle.putString("pos", str);
        bundle.putSerializable("list", arrayList);
        bundle.putInt("index", i2);
        gVar.setArguments(bundle);
        return gVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.h = arguments.getString("pos");
        this.f29354f = (ArrayList) arguments.getSerializable("list");
        this.i = arguments.getInt("index");
        this.f29353e = InjectorUtils.provideGetVoucherListTask();
        setStyle(c.h.bottom_sheet_dialog, 0);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(c.b.transparent)));
            window.requestFeature(1);
        }
        View inflate = layoutInflater.inflate(c.f.live_streaming_fragment_voucher_list, viewGroup, false);
        this.f29350b = (RecyclerView) inflate.findViewById(c.e.rv_shopee_voucher);
        this.f29351c = (TextView) inflate.findViewById(c.e.tv_no_product);
        this.f29352d = (ProgressBar) inflate.findViewById(c.e.loading_progress);
        a();
        return inflate;
    }

    private void a() {
        this.j = new com.shopee.live.livestreaming.ui.view.a.c(this.f29349a);
        this.j.a(this.h);
        this.j.a((c.C0444c) new c.C0444c() {
            public void a(int i, VoucherEntity voucherEntity) {
            }

            public void b(int i, VoucherEntity voucherEntity) {
                if (g.this.f29355g != null && voucherEntity != null) {
                    g.this.f29355g.a(voucherEntity, g.this.j.b());
                } else if (voucherEntity != null) {
                    b.b(voucherEntity.getPromotion_id(), voucherEntity.getVoucher_code(), voucherEntity.getShop_id() == 0 ? 0 : 1, false);
                }
                g.this.dismiss();
            }

            public void c(int i, VoucherEntity voucherEntity) {
                if (g.this.f29355g != null && voucherEntity != null) {
                    g.this.f29355g.b(voucherEntity, "-1");
                }
            }
        });
        this.f29350b.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f29350b.setAdapter(this.j);
        this.f29350b.a((RecyclerView.n) new RecyclerView.n() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && g.this.f29355g != null) {
                    g.this.f29355g.a(g.this.k, g.this.f29350b.g(g.this.f29350b.getChildAt(0)), 0);
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
            }
        });
        this.l = new ad(getActivity(), this.f29350b);
        this.m = new ArrayList();
        this.l.a((ad.a) new ad.a() {
            public void a(int i) {
                VoucherListItem voucherListItem = (VoucherListItem) g.this.j.a(i);
                if (voucherListItem != null && voucherListItem.getType() != 3) {
                    VoucherEntity voucherEntity = voucherListItem.getVoucherEntity();
                    if (voucherEntity != null) {
                        long promotion_id = voucherEntity.getPromotion_id();
                        if (!g.this.m.contains(Long.valueOf(promotion_id))) {
                            g.this.m.add(Long.valueOf(promotion_id));
                            boolean z = false;
                            int i2 = voucherEntity.getShop_id() == 0 ? 0 : 1;
                            if (g.this.j.a() != i) {
                                z = true;
                            }
                            b.a(promotion_id, voucherEntity.getVoucher_code(), i2, z);
                        }
                    }
                }
            }
        });
        g();
        b();
        c();
    }

    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.dimAmount = BitmapDescriptorFactory.HUE_RED;
            attributes.width = (int) (((float) getResources().getDisplayMetrics().widthPixels) * 0.95f);
            attributes.height = (getResources().getDisplayMetrics().heightPixels * 3) / 5;
            attributes.windowAnimations = c.h.bottom_sheet_dialog_animation;
            window.setAttributes(attributes);
        }
    }

    public void onResume() {
        super.onResume();
        f();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f29349a = activity;
    }

    public void onDestroy() {
        super.onDestroy();
        e();
        this.f29353e.shutTask();
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    private void b() {
        ArrayList<VoucherListItem> arrayList = this.f29354f;
        if (arrayList != null && arrayList.size() > 0) {
            this.k.clear();
            this.k.addAll(this.f29354f);
            h();
            this.j.a(this.k);
            int i2 = this.i;
        }
        d();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        a aVar = this.f29355g;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void c() {
        this.f29353e.execute(new GetVoucherListTask.Data(), new GetVoucherListTask.Callback() {
            public void returnVoucherList(VoucherListEntity voucherListEntity) {
                if (g.this.f29350b != null) {
                    if (g.this.a(voucherListEntity)) {
                        g.this.h();
                        g.this.j.a(g.this.k);
                        if (g.this.f29355g != null) {
                            g.this.f29355g.a(g.this.k, g.this.f29350b.g(g.this.f29350b.getChildAt(0)), 0);
                            return;
                        }
                        return;
                    }
                    g.this.i();
                }
            }

            public void onError(int i, String str) {
                if (g.this.f29350b != null) {
                    if (!d.a(str)) {
                        z.a(g.this.f29349a, str);
                    }
                    if (g.this.k == null || g.this.k.size() <= 0) {
                        g.this.i();
                    }
                }
            }
        });
    }

    private void d() {
        this.l.a();
    }

    private void e() {
        this.l.c();
    }

    private void f() {
        this.l.b();
    }

    public void a(a aVar) {
        this.f29355g = aVar;
    }

    /* access modifiers changed from: private */
    public boolean a(VoucherListEntity voucherListEntity) {
        f.a().e(voucherListEntity.getShow_voucher_duration());
        ArrayList<VoucherEntity> shopee_vouchers = voucherListEntity.getShopee_vouchers();
        ArrayList<VoucherEntity> shop_vouchers = voucherListEntity.getShop_vouchers();
        if (shopee_vouchers.size() <= 0 && shop_vouchers.size() <= 0) {
            return false;
        }
        this.k.clear();
        if (shopee_vouchers.size() > 0) {
            VoucherListItem voucherListItem = new VoucherListItem();
            voucherListItem.setType(1);
            voucherListItem.setTitle(com.garena.android.appkit.tools.b.e(c.g.live_streaming_shopee_voucher) + SQLBuilder.PARENTHESES_LEFT + String.valueOf(shopee_vouchers.size()) + SQLBuilder.PARENTHESES_RIGHT);
            this.k.add(voucherListItem);
            for (int i2 = 0; i2 < shopee_vouchers.size(); i2++) {
                VoucherListItem voucherListItem2 = new VoucherListItem();
                voucherListItem2.setType(2);
                voucherListItem2.setVoucherEntity(shopee_vouchers.get(i2));
                this.k.add(voucherListItem2);
            }
        }
        if (shopee_vouchers.size() > 0 && shop_vouchers.size() > 0) {
            VoucherListItem voucherListItem3 = new VoucherListItem();
            voucherListItem3.setType(3);
            this.k.add(voucherListItem3);
        }
        if (shop_vouchers.size() > 0) {
            VoucherListItem voucherListItem4 = new VoucherListItem();
            voucherListItem4.setType(1);
            voucherListItem4.setTitle(com.garena.android.appkit.tools.b.e(c.g.live_streaming_shop_voucher) + SQLBuilder.PARENTHESES_LEFT + String.valueOf(shop_vouchers.size()) + SQLBuilder.PARENTHESES_RIGHT);
            this.k.add(voucherListItem4);
            for (int i3 = 0; i3 < shop_vouchers.size(); i3++) {
                VoucherListItem voucherListItem5 = new VoucherListItem();
                voucherListItem5.setType(2);
                voucherListItem5.setVoucherEntity(shop_vouchers.get(i3));
                this.k.add(voucherListItem5);
            }
        }
        return true;
    }

    private void g() {
        this.f29350b.setVisibility(8);
        this.f29351c.setVisibility(8);
        this.f29352d.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void h() {
        this.f29350b.setVisibility(0);
        this.f29351c.setVisibility(8);
        this.f29352d.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void i() {
        this.f29350b.setVisibility(8);
        this.f29351c.setVisibility(0);
        this.f29352d.setVisibility(8);
        this.f29351c.setText("No Voucher");
    }
}
