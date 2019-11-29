package com.shopee.app.ui.chat2;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import com.afollestad.materialdialogs.f;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.c.Cdo;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.chatP2P.VMOffer;
import com.shopee.app.g.l;
import com.shopee.app.h.r;
import com.shopee.app.network.d.g;
import com.shopee.app.ui.common.b.c;
import com.shopee.app.ui.home.HomeActivity_;
import com.shopee.app.util.af;
import com.shopee.app.util.ak;
import com.shopee.app.web.protocol.AddCartMessage;
import com.shopee.id.R;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public View f20200a;

    /* renamed from: b  reason: collision with root package name */
    private final ak f20201b;

    /* renamed from: c  reason: collision with root package name */
    private final SettingConfigStore f20202c;

    public a(View view, ak akVar, SettingConfigStore settingConfigStore) {
        this.f20200a = view;
        this.f20201b = akVar;
        this.f20202c = settingConfigStore;
    }

    public Dialog a(Cdo doVar, int i, RegionConfig regionConfig, ItemDetail itemDetail) {
        if (itemDetail.isDeList()) {
            r.a().a(b.e(R.string.sp_item_unlisted_error_msg));
            return null;
        } else if (af.a(itemDetail.getModelDetails())) {
            a(itemDetail, i);
            return null;
        } else if (itemDetail.isOutStock()) {
            r.a().a(b.e(R.string.sp_item_out_of_stock_buy_tip));
            return null;
        } else {
            AddCartMessage from = AddCartMessage.from(itemDetail, i);
            from.setHideStock(this.f20202c.isHideStock(from.shopID));
            return l.a(this.f20200a.getContext(), from, 7);
        }
    }

    public void a(ItemDetail itemDetail, int i) {
        AddCartMessage from = AddCartMessage.from(itemDetail, i);
        new g().a(from.itemID, 1, from.shopID, from);
    }

    public Dialog a(int i, int i2, long j) {
        return l.a(this.f20200a.getContext(), 7, j, i, i2);
    }

    public void a(com.shopee.app.network.c.d.a aVar) {
        String e2;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            e2 = aVar.f17893b;
        } else {
            int i = aVar.f17892a;
            if (i == -100) {
                e2 = b.e(R.string.sp_network_error);
            } else if (i == 9) {
                e2 = b.e(R.string.sp_error_account_banned);
            } else if (i == 4) {
                e2 = b.e(R.string.sp_err_ban_delete);
            } else if (i == 5) {
                com.shopee.app.ui.dialog.a.a(this.f20200a.getContext(), 0, (int) R.string.sp_error_exist_offer_in_chart, 0, (int) R.string.sp_label_ok, (f.b) new f.b() {
                    public void onNegative(f fVar) {
                    }

                    public void onPositive(f fVar) {
                    }
                });
                return;
            } else if (i != 6) {
                e2 = b.e(R.string.sp_unknown_error);
            } else {
                e2 = b.e(R.string.sp_item_out_of_stock_buy_tip);
            }
        }
        String str = e2;
        int i2 = aVar.f17892a;
        if (i2 == 9) {
            com.shopee.app.ui.dialog.a.a(this.f20200a.getContext(), this.f20201b);
        } else if (i2 != 28) {
            r.a().a(str);
        } else {
            com.shopee.app.ui.dialog.a.a(this.f20200a.getContext(), (String) null, str, (int) R.string.button_cancel, (int) R.string.sp_label_see_other_products, (f.b) new f.b() {
                public void onPositive(f fVar) {
                    ((HomeActivity_.a) HomeActivity_.a(a.this.f20200a.getContext()).k(67108864)).a("home?navRoute=eyJjdXJyZW50UGFnZVVybCI6Imh0dHA6Ly9tYWxsLnRlc3Quc2hvcGVlLnNnLyNqdXN0LWZvci15b3UifQ%3D%3D").a();
                }
            });
        }
    }

    public Dialog a(Cdo doVar, int i, ItemDetail itemDetail, VMOffer vMOffer, c.b bVar) {
        if (itemDetail.isDeList()) {
            r.a().a(b.e(R.string.sp_item_unlisted_error_msg));
            return null;
        } else if (itemDetail.isOutStock()) {
            r.a().a(b.e(R.string.sp_item_out_of_stock_buy_tip));
            return null;
        } else {
            final Cdo doVar2 = doVar;
            final ItemDetail itemDetail2 = itemDetail;
            final int i2 = i;
            final c.b bVar2 = bVar;
            return l.a(this.f20200a.getContext(), AddCartMessage.from(itemDetail, i), vMOffer, new c.b() {
                public void a(int i, long j, long j2) {
                    doVar2.a(0, itemDetail2.getId(), j2, itemDetail2.getShopId(), i2, j, i, 1, 0, itemDetail2);
                    c.b bVar = bVar2;
                    if (bVar != null) {
                        bVar.a(i, j, j2);
                    }
                }
            });
        }
    }

    public Dialog a(Cdo doVar, int i, ItemDetail itemDetail, VMOffer vMOffer) {
        return a(doVar, i, itemDetail, vMOffer, (c.b) null);
    }

    public Dialog b(Cdo doVar, int i, ItemDetail itemDetail, VMOffer vMOffer, c.b bVar) {
        final Cdo doVar2 = doVar;
        final ItemDetail itemDetail2 = itemDetail;
        final int i2 = i;
        final VMOffer vMOffer2 = vMOffer;
        final c.b bVar2 = bVar;
        return l.b(this.f20200a.getContext(), AddCartMessage.from(itemDetail, i), vMOffer, new c.b() {
            public void a(int i, long j, long j2) {
                doVar2.a(0, itemDetail2.getId(), j2, itemDetail2.getShopId(), i2, j, i, 1, vMOffer2.getOfferid(), itemDetail2);
                c.b bVar = bVar2;
                if (bVar != null) {
                    bVar.a(i, j, j2);
                }
            }
        });
    }

    public Dialog b(Cdo doVar, int i, ItemDetail itemDetail, VMOffer vMOffer) {
        return b(doVar, i, itemDetail, vMOffer, (c.b) null);
    }

    public Dialog b(int i, int i2, long j) {
        return l.a(this.f20200a.getContext(), j, i, i2, (c.b) new c.b() {
            public void a(int i, long j, long j2) {
            }
        });
    }

    public void b(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            int i = aVar.f17892a;
            if (i != 2) {
                if (i != 4) {
                    if (i == 6) {
                        str = b.e(R.string.sp_product_out_of_stock);
                    } else if (i == 9) {
                        str = b.e(R.string.sp_product_banned_label);
                    } else if (i != 13) {
                        str = b.e(R.string.sp_network_error);
                    }
                }
                str = b.e(R.string.sp_product_deleted_or_banned);
            } else {
                str = b.e(R.string.sp_offer_not_allowed);
            }
        }
        if (aVar.f17892a != 28) {
            r.a().a(str);
        } else {
            com.shopee.app.ui.dialog.a.a(this.f20200a.getContext(), (String) null, str, 0, (int) R.string.button_ok);
        }
    }
}
