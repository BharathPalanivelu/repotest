package com.shopee.app.ui.myproduct.a;

import android.text.TextUtils;
import android.util.Pair;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.au;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.network.d.ae;
import com.shopee.app.network.d.o;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.p;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.n;
import com.shopee.id.R;
import java.util.List;

public class f extends q<h> implements p.a {

    /* renamed from: a  reason: collision with root package name */
    private final n f23396a;

    /* renamed from: c  reason: collision with root package name */
    private final au f23397c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23398d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f23399e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f23400f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f23401g = 0;
    /* access modifiers changed from: private */
    public int h;
    private final i i;
    private e j = new g() {
        public void onEvent(a aVar) {
            Pair pair = (Pair) aVar.data;
            if (((Integer) pair.first).equals(Integer.valueOf(f.this.f23400f))) {
                ((h) f.this.f19220b).a((List<ItemDetail>) (List) pair.second);
                if (((List) pair.second).size() + 1 == f.this.h) {
                    ((h) f.this.f19220b).f();
                } else {
                    ((h) f.this.f19220b).g();
                }
                ((h) f.this.f19220b).d();
            }
        }
    };
    private e k = new g() {
        public void onEvent(a aVar) {
            f.this.a(true);
            f fVar = f.this;
            fVar.b(0, fVar.f23401g + 20, false);
        }
    };
    private e l = new g() {
        public void onEvent(a aVar) {
            f.this.a(true);
            f.this.b(0, 20, false);
            ((h) f.this.f19220b).h();
        }
    };
    private e m = new g() {
        public void onEvent(a aVar) {
            ((h) f.this.f19220b).d();
            if (aVar.data != null && (aVar.data instanceof Integer) && aVar.data.equals(Integer.valueOf(f.this.f23400f))) {
                f.this.a(false);
            }
        }
    };

    public f(n nVar, UserInfo userInfo, au auVar) {
        this.f23396a = nVar;
        this.f23398d = userInfo.getShopId();
        this.f23399e = userInfo.isHolidayMode();
        this.f23397c = auVar;
        this.i = b.a(this);
    }

    public boolean e() {
        return this.f23399e;
    }

    public void a(int i2, int i3, boolean z) {
        this.f23400f = i2;
        a(true);
        b(i3, 20, z);
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        this.f23397c.a(this.f23400f, z);
    }

    /* access modifiers changed from: private */
    public void b(int i2, int i3, boolean z) {
        new ae().a(this.f23400f, this.f23398d, i2, i3, z, false);
    }

    public void a() {
        this.i.a();
        this.f23396a.a("ITEM_BY_TYPE_LIST_LOCAL_LOAD", this.j);
        this.f23396a.a("ITEM_BY_TYPE_LIST_SAVED", this.m);
        this.f23396a.a("CMD_GET_ITEM_SCORES_SUCCESS", this.m);
        this.f23396a.a("ADD_ITEM_RESULT_SUCCESS", this.l);
        this.f23396a.a("ITEM_DELETE", this.m);
        this.f23396a.a("ITEM_BAN", this.k);
        this.f23396a.a("INVALID_ITEM", this.k);
        this.f23396a.a("EDIT_ITEM_SUCCESS", this.k);
    }

    public void b() {
        this.i.b();
        this.f23396a.b("ITEM_BY_TYPE_LIST_LOCAL_LOAD", this.j);
        this.f23396a.b("ITEM_BY_TYPE_LIST_SAVED", this.m);
        this.f23396a.b("CMD_GET_ITEM_SCORES_SUCCESS", this.m);
        this.f23396a.b("ADD_ITEM_RESULT_SUCCESS", this.l);
        this.f23396a.b("ITEM_BAN", this.k);
        this.f23396a.b("INVALID_ITEM", this.k);
        this.f23396a.b("EDIT_ITEM_SUCCESS", this.k);
        this.f23396a.b("ITEM_DELETE", this.m);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        ((h) this.f19220b).d();
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            str = a(aVar.f17892a);
        }
        ((h) this.f19220b).a(str);
    }

    /* access modifiers changed from: package-private */
    public void b(com.shopee.app.network.c.d.a aVar) {
        String str;
        ((h) this.f19220b).d();
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            str = a(aVar.f17892a);
        }
        ((h) this.f19220b).a(str);
    }

    private String a(int i2) {
        if (i2 == -100) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
        }
        if (i2 == 17) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_server_price_limit_error);
        }
        if (i2 == 1) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_server_parameter_error);
        }
        if (i2 == 2) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_server_permission_error);
        }
        if (i2 == 3) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_max_product_limit_reached);
        }
        switch (i2) {
            case 30:
            case 31:
            case 32:
                return com.garena.android.appkit.tools.b.e(R.string.sp_add_product_category_error);
            default:
                return com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
        }
    }

    public void a(final long j2) {
        com.shopee.app.ui.dialog.a.a(((h) this.f19220b).getContext(), (int) R.string.sp_product_delete_prompt, (int) R.string.sp_label_cancel, (int) R.string.sp_label_confirm, (a.C0318a) new a.C0318a() {
            public void onNegative() {
            }

            public void onPositive() {
                ((h) f.this.f19220b).x_();
                new com.shopee.app.network.d.n(j2).g();
            }
        });
    }

    public void a(ItemDetail itemDetail) {
        if (itemDetail.isDeList()) {
            b(itemDetail);
        } else {
            c(itemDetail);
        }
    }

    private void b(final ItemDetail itemDetail) {
        com.shopee.app.ui.dialog.a.a(((h) this.f19220b).getContext(), (int) R.string.sp_product_publish_prompt, (int) R.string.sp_label_cancel, (int) R.string.sp_label_confirm, (a.C0318a) new a.C0318a() {
            public void onNegative() {
            }

            public void onPositive() {
                ((h) f.this.f19220b).x_();
                o.a(itemDetail).g();
            }
        });
    }

    private void c(final ItemDetail itemDetail) {
        com.shopee.app.ui.dialog.a.a(((h) this.f19220b).getContext(), (int) R.string.sp_product_delist_prompt, (int) R.string.sp_label_cancel, (int) R.string.sp_label_confirm, (a.C0318a) new a.C0318a() {
            public void onNegative() {
            }

            public void onPositive() {
                ((h) f.this.f19220b).x_();
                o.b(itemDetail).g();
            }
        });
    }

    public void c(int i2) {
        this.h = i2;
        this.f23401g += 20;
        b(this.f23401g, 20, false);
    }
}
