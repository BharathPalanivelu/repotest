package com.shopee.app.d.b.a.a.c;

import android.app.Activity;
import android.view.View;
import com.garena.android.appkit.tools.a.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.d.b.a.c.c;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.util.ak;
import com.shopee.id.R;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class i extends a {

    /* renamed from: d  reason: collision with root package name */
    private static final List<Integer> f16044d = Arrays.asList(new Integer[]{2, 6, 11});
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ReturnItem f16045e;

    public i(ReturnItem returnItem) {
        super(returnItem);
        this.f16045e = returnItem;
    }

    public String b() {
        String c2 = a.c(this.f16045e.getAcceptedDate() + ((int) TimeUnit.DAYS.toSeconds((long) SettingConfigStore.getInstance().pickUpStartDateOffSet())), "ID");
        String str = (String) com.shopee.app.d.b.a.c.a.f16328a.a(this.f16045e, c.SHORT_TEXT);
        if (str != null) {
            return str;
        }
        if (this.f16027c.nonIntegratedMallReturnEnabled() && this.f16045e.isShopeeHandle()) {
            if (this.f16045e.isBeforePickUpDone()) {
                if (this.f16045e.getReturnShipDueDate() > 0) {
                    return b.a(R.string.sp_return_ship_back_to_shopee_by_date, a.c(this.f16045e.getReturnShipDueDate(), "ID"));
                }
            } else if (this.f16045e.isPickupDone()) {
                return "";
            }
        }
        if (!r() || !this.f16045e.isSupportedShippingMethod()) {
            if (this.f16045e.isOfficialShop()) {
                if (u() && !this.f16027c.b2cReturnEnabled()) {
                    return b.a(R.string.order_list_return_in_progress_non_tw_official_shop, c2);
                } else if (!this.f16027c.c2cReturnOfficialEnabled()) {
                    return b.a(R.string.order_list_return_in_progress_non_tw_official_shop, c2);
                }
            } else if (!this.f16027c.c2cReturnEnabled()) {
                return b.a(R.string.order_list_return_in_progress_non_tw_official_shop, c2);
            }
            if (u()) {
                if (this.f16045e.isSupportedShippingMethod() || !this.f16045e.isBeforePickUpDone() || this.f16045e.getReturnShipDueDate() <= 0) {
                    return "";
                }
                return b.a(R.string.sp_return_ship_back_to_shopee_by_date, a.c(this.f16045e.getReturnShipDueDate(), "ID"));
            } else if (w()) {
                if (this.f16045e.getReturnSellerDueDate() <= 0) {
                    return "";
                }
                return b.a(R.string.sp_return_pending_text_in_list_view_buyer, a.c(this.f16045e.getReturnSellerDueDate(), "ID"));
            } else if (this.f16045e.getReturnShipDueDate() <= 0) {
                return "";
            } else {
                return b.a(R.string.sp_return_to_seller_by_date, a.c(this.f16045e.getReturnShipDueDate(), "ID"));
            }
        } else if (x()) {
            return a((int) R.string.order_list_return_in_progress_tw_official_shop_shipping_done);
        } else {
            if (w()) {
                return a((int) R.string.order_list_return_in_progress_tw_official_shop_shipping_delivery);
            }
            return b.a(R.string.order_list_return_in_progress_tw_official_shop_shipping_before, c2);
        }
    }

    private boolean w() {
        return f16044d.contains(Integer.valueOf(this.f16045e.getLogisticStatus()));
    }

    private boolean x() {
        return this.f16045e.getLogisticStatus() == 5;
    }

    public a.C0251a d() {
        a.C0251a aVar = (a.C0251a) com.shopee.app.d.b.a.c.a.f16328a.a(this.f16045e, c.PRIMARY_BUTTON);
        if (aVar != null) {
            return aVar;
        }
        if (this.f16027c.nonIntegratedMallReturnEnabled() && this.f16045e.isShopeeHandle()) {
            if (this.f16045e.isBeforePickUpDone()) {
                return new a.C0251a(a((int) R.string.sp_label_input_shipping_information), 0, new View.OnClickListener() {
                    public void onClick(View view) {
                        Activity a2 = i.this.a(view);
                        if (a2 != null) {
                            new ak(a2).i(i.this.f16045e.getReturnId());
                        }
                    }
                });
            }
            if (this.f16045e.isPickupDone()) {
                return new a.C0251a(a((int) R.string.sp_re_re_detail), 0, new View.OnClickListener() {
                    public void onClick(View view) {
                        Activity a2 = i.this.a(view);
                        if (a2 != null) {
                            new ak(a2).a(i.this.f16045e.isSelling(), i.this.f16045e.getReturnId());
                        }
                    }
                });
            }
        }
        if (!r() || x() || w()) {
            return (!u() || !this.f16027c.b2cReturnEnabled() || this.f16045e.isSupportedShippingMethod() || !this.f16045e.isBeforePickUpDone()) ? new a.C0251a(a((int) R.string.sp_re_re_detail), 0, new View.OnClickListener() {
                public void onClick(View view) {
                    Activity a2 = i.this.a(view);
                    if (a2 != null) {
                        new ak(a2).a(i.this.f16045e.isSelling(), i.this.f16045e.getReturnId());
                    }
                }
            }) : new a.C0251a(a((int) R.string.sp_label_input_shipping_information), 0, new View.OnClickListener() {
                public void onClick(View view) {
                    Activity a2 = i.this.a(view);
                    if (a2 != null) {
                        new ak(a2).j(i.this.f16045e.getReturnId());
                    }
                }
            });
        }
        return new a.C0251a(a((int) R.string.order_list_cancel_return_refund), 0, new View.OnClickListener() {
            public void onClick(View view) {
                Activity a2 = i.this.a(view);
                if (a2 != null) {
                    new ak(a2).a(i.this.f16045e.isSelling(), i.this.f16045e.getReturnId());
                }
            }
        });
    }

    public String j() {
        String str = (String) com.shopee.app.d.b.a.c.a.f16328a.a(this.f16045e, c.STATUS);
        if (str != null) {
            return str;
        }
        if (this.f16027c.nonIntegratedMallReturnEnabled() && this.f16045e.isShopeeHandle()) {
            if (this.f16045e.isBeforePickUpDone()) {
                return a((int) R.string.order_list_return_pending);
            }
            if (this.f16045e.isPickupDone()) {
                return a((int) R.string.order_list_return_pick_up_done);
            }
        }
        if (u() && this.f16027c.b2cReturnEnabled()) {
            return a((int) R.string.order_list_return_pending);
        }
        if (!r() || !this.f16045e.isSupportedShippingMethod()) {
            if (this.f16045e.isOfficialShop()) {
                if (!this.f16027c.c2cReturnOfficialEnabled()) {
                    return a((int) R.string.action_buyer_return_accepted_bank_summary_text);
                }
            } else if (!this.f16027c.c2cReturnEnabled()) {
                return a((int) R.string.action_buyer_return_accepted_bank_summary_text);
            }
            if (this.f16045e.isBeforePickUpDone()) {
                return a((int) R.string.order_list_return_pending);
            }
            return a((int) R.string.order_list_return_pick_up_done);
        } else if (x()) {
            return a((int) R.string.order_list_return_delivery_up_done);
        } else {
            if (w()) {
                return a((int) R.string.order_list_return_pick_up_done);
            }
            return a((int) R.string.order_list_return_pending);
        }
    }
}
