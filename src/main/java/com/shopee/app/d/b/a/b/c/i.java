package com.shopee.app.d.b.a.b.c;

import android.app.Activity;
import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.d.b.a.c.c;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.ui.a.e;
import com.shopee.app.util.ak;
import com.shopee.id.R;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class i extends a {

    /* renamed from: e  reason: collision with root package name */
    private static final List<Integer> f16212e = Arrays.asList(new Integer[]{2, 6, 11});

    public i(ReturnItem returnItem) {
        super(returnItem);
    }

    private boolean w() {
        return f16212e.contains(Integer.valueOf(this.f16206c.getLogisticStatus()));
    }

    private boolean x() {
        return this.f16206c.getLogisticStatus() == 5;
    }

    private a.C0251a a(String str) {
        return new a.C0251a(str, 0, new View.OnClickListener() {
            public void onClick(View view) {
                Activity a2 = i.this.a(view);
                if (a2 != null) {
                    ar.f().e().actionTracker().a(((e) a2).A(), i.this.f16206c);
                    new ak(a2).a(i.this.f16206c.isSelling(), i.this.f16206c.getReturnId());
                }
            }
        });
    }

    public a.C0251a d() {
        a.C0251a aVar = (a.C0251a) com.shopee.app.d.b.a.c.a.f16328a.a(this.f16206c, c.PRIMARY_BUTTON);
        if (aVar != null) {
            return aVar;
        }
        if (this.f16207d.nonIntegratedMallReturnEnabled() && this.f16206c.isShopeeHandle()) {
            return a(a((int) R.string.sp_re_re_detail));
        }
        if (!r()) {
            return new a.C0251a(a((int) R.string.sp_re_re_detail), 0, new View.OnClickListener() {
                public void onClick(View view) {
                    Activity a2 = i.this.a(view);
                    if (a2 != null) {
                        ar.f().e().actionTracker().a(((e) a2).A(), i.this.f16206c);
                        new ak(a2).a(i.this.f16206c.isSelling(), i.this.f16206c.getReturnId());
                    }
                }
            });
        }
        if (x()) {
            return new a.C0251a(a((int) R.string.order_list_refund), 0, new View.OnClickListener() {
                public void onClick(View view) {
                    Activity a2 = i.this.a(view);
                    if (a2 != null) {
                        ar.f().e().actionTracker().a(((e) a2).A(), i.this.f16206c);
                        new ak(a2).a(i.this.f16206c.isSelling(), i.this.f16206c.getReturnId());
                    }
                }
            });
        }
        return new a.C0251a(a((int) R.string.order_list_refund_without_return), 0, new View.OnClickListener() {
            public void onClick(View view) {
                Activity a2 = i.this.a(view);
                if (a2 != null) {
                    ar.f().e().actionTracker().a(((e) a2).A(), i.this.f16206c);
                    new ak(a2).a(i.this.f16206c.isSelling(), i.this.f16206c.getReturnId());
                }
            }
        });
    }

    public String j() {
        String str = (String) com.shopee.app.d.b.a.c.a.f16328a.a(this.f16206c, c.STATUS);
        if (str != null) {
            return str;
        }
        if (this.f16207d.nonIntegratedMallReturnEnabled() && this.f16206c.isShopeeHandle()) {
            if (this.f16206c.isBeforePickUpDone()) {
                return a((int) R.string.order_list_return_pending);
            }
            if (this.f16206c.isPickupDone()) {
                return a((int) R.string.order_list_return_pick_up_done);
            }
        }
        if (!r() || !this.f16206c.isSupportedShippingMethod()) {
            if (this.f16206c.isOfficialShop()) {
                if (u() && !this.f16207d.b2cReturnEnabled()) {
                    return a((int) R.string.order_list_return_pick_up_done);
                }
                if (!this.f16207d.c2cReturnOfficialEnabled()) {
                    return a((int) R.string.order_list_return_pick_up_done);
                }
            } else if (!this.f16207d.c2cReturnEnabled()) {
                return a((int) R.string.order_list_return_pick_up_done);
            }
            if (u() || this.f16206c.isBeforePickUpDone()) {
                return a((int) R.string.order_list_return_pending);
            }
            return a((int) R.string.order_list_return_pick_up_done);
        } else if (x()) {
            return a((int) R.string.order_list_return_delivery_up_done_seller);
        } else {
            if (w()) {
                return a((int) R.string.order_list_return_pick_up_done);
            }
            return a((int) R.string.order_list_return_pending);
        }
    }

    public String b() {
        String str = (String) com.shopee.app.d.b.a.c.a.f16328a.a(this.f16206c, c.SHORT_TEXT);
        if (str != null) {
            return str;
        }
        if (u() && this.f16207d.b2cReturnEnabled()) {
            return "";
        }
        if (this.f16207d.nonIntegratedMallReturnEnabled() && this.f16206c.isShopeeHandle()) {
            return "";
        }
        int deliveryDoneDate = this.f16206c.getDeliveryDoneDate() + ((int) TimeUnit.DAYS.toSeconds((long) SettingConfigStore.getInstance().deliveryDoneDateOffset()));
        if (!r() || !this.f16206c.isSupportedShippingMethod()) {
            if (this.f16206c.isOfficialShop()) {
                if (!this.f16207d.c2cReturnOfficialEnabled()) {
                    return a((int) R.string.order_list_return_in_progress_non_tw_official_shop_seller);
                }
            } else if (!this.f16207d.c2cReturnEnabled()) {
                return a((int) R.string.order_list_return_in_progress_non_tw_official_shop_seller);
            }
            if (this.f16206c.isBeforePickUpDone()) {
                return a((int) R.string.order_list_return_in_progress_non_tw_official_shop_seller);
            }
            return b.a(R.string.sp_response_by_date, com.garena.android.appkit.tools.a.a.c(this.f16206c.getReturnSellerDueDate(), "ID"));
        } else if (x()) {
            return b.a(R.string.order_list_return_in_progress_tw_official_shop_shipping_done_seller, com.garena.android.appkit.tools.a.a.c(deliveryDoneDate, "ID"));
        } else if (w()) {
            return a((int) R.string.order_list_return_in_progress_tw_official_shop_shipping_delivery_seller);
        } else {
            return a((int) R.string.order_list_return_in_progress_tw_official_shop_shipping_before_seller);
        }
    }
}
