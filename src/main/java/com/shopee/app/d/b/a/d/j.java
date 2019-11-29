package com.shopee.app.d.b.a.d;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.util.bi;
import com.shopee.id.R;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private SettingConfigStore f16358a;

    j(SettingConfigStore settingConfigStore) {
        this.f16358a = settingConfigStore;
    }

    public a.C0251a a(final OrderDetail orderDetail, final bi biVar) {
        if (orderDetail.hasCODDelay(this.f16358a.getCodArrangePickUpDelayInSecondsDelay())) {
            return new a.C0251a(a(orderDetail), 1, new View.OnClickListener() {
                public void onClick(View view) {
                    biVar.a("GOTO_PICKUP_DETAIL_PAGE", new com.garena.android.appkit.b.a(orderDetail));
                }
            });
        }
        return new a.C0251a(a(orderDetail), 0, new View.OnClickListener() {
            public void onClick(View view) {
                biVar.a("GOTO_PICKUP_DETAIL_PAGE", new com.garena.android.appkit.b.a(orderDetail));
            }
        });
    }

    public a.C0251a b(final OrderDetail orderDetail, final bi biVar) {
        if (this.f16358a.getCancelOrder()) {
            return new a.C0251a(a((int) R.string.sp_txt_cancel_this_order), 0, new View.OnClickListener() {
                public void onClick(View view) {
                    biVar.a("ORDER_CANCEL", new com.garena.android.appkit.b.a(orderDetail));
                }
            });
        }
        return new a.C0251a();
    }

    public a.C0251a c(final OrderDetail orderDetail, final bi biVar) {
        if (this.f16358a.getExtendShipping()) {
            return new a.C0251a(a((int) R.string.sp_label_extend_escrow), 0, new View.OnClickListener() {
                public void onClick(View view) {
                    biVar.a("EXTEND_ESCROW_NEW", new com.garena.android.appkit.b.a(orderDetail));
                }
            });
        }
        return new a.C0251a();
    }

    public a.C0251a d(final OrderDetail orderDetail, final bi biVar) {
        if (this.f16358a.getRequestReturn()) {
            return new a.C0251a(a((int) R.string.sp_request_return_refund), 0, new View.OnClickListener() {
                public void onClick(View view) {
                    biVar.a("ORDER_REQUEST_RETURN_N_REFUND", new com.garena.android.appkit.b.a(orderDetail));
                }
            });
        }
        return new a.C0251a();
    }

    public a.C0251a e(final OrderDetail orderDetail, final bi biVar) {
        if (this.f16358a.getOrderReceive()) {
            return new a.C0251a(a((int) R.string.sp_label_accept_order), 0, new View.OnClickListener() {
                public void onClick(View view) {
                    biVar.a("ORDER_SHIP_RECEIVED", new com.garena.android.appkit.b.a(orderDetail));
                }
            });
        }
        return new a.C0251a();
    }

    public a.C0251a f(final OrderDetail orderDetail, final bi biVar) {
        return new a.C0251a(a((int) R.string.sp_provide_bank_account), 0, new View.OnClickListener() {
            public void onClick(View view) {
                biVar.a("ORDER_PROVIDE_BANK_ACCOUNT", new com.garena.android.appkit.b.a(orderDetail));
            }
        });
    }

    public a.C0251a a(final CheckoutItem checkoutItem, final bi biVar) {
        if (this.f16358a.getChangePaymentOption()) {
            return new a.C0251a(a((int) R.string.sp_change_payment_method), 0, new View.OnClickListener() {
                public void onClick(View view) {
                    biVar.a("GOTO_CHANGE_CHECKOUT_PAY", new com.garena.android.appkit.b.a(checkoutItem));
                }
            });
        }
        return new a.C0251a();
    }

    /* access modifiers changed from: protected */
    public String a(int i) {
        return b.e(i);
    }

    public a.C0251a b(final CheckoutItem checkoutItem, final bi biVar) {
        if (this.f16358a.getChangeLogistics()) {
            return new a.C0251a(a((int) R.string.sp_label_change_logistics), 0, new View.OnClickListener() {
                public void onClick(View view) {
                    biVar.a("ORDER_CHANGE_LOGISTICS", new com.garena.android.appkit.b.a(checkoutItem));
                }
            });
        }
        return new a.C0251a();
    }

    public a.C0251a g(final OrderDetail orderDetail, final bi biVar) {
        if (!this.f16358a.getAllowLogistics() || !this.f16358a.getReviseShippingFee()) {
            return new a.C0251a();
        }
        return new a.C0251a(a((int) R.string.sp_label_revise_ship_fee), 0, new View.OnClickListener() {
            public void onClick(View view) {
                biVar.a("ORDER_REVISE_SHIP_FEE", new com.garena.android.appkit.b.a(orderDetail));
            }
        });
    }

    public String a(OrderDetail orderDetail) {
        if ((orderDetail.supportPickup() || orderDetail.supportShopeeGeneratingTrackingNumber() || orderDetail.supportDropOff()) && !orderDetail.shipmentArraged()) {
            return a((int) R.string.sp_arrange_shipment);
        }
        if ((orderDetail.supportPickup() || orderDetail.supportShopeeGeneratingTrackingNumber() || orderDetail.supportDropOff()) && orderDetail.shipmentArraged()) {
            return a((int) R.string.sp_view_shipment_details);
        }
        if (!orderDetail.supportPickup() && !orderDetail.supportShopeeGeneratingTrackingNumber() && !orderDetail.supportDropOff() && !orderDetail.logisticsCreated()) {
            return a((int) R.string.sp_label_ship);
        }
        if (orderDetail.supportPickup() || orderDetail.supportShopeeGeneratingTrackingNumber() || orderDetail.supportDropOff() || !orderDetail.logisticsCreated()) {
            return a((int) R.string.sp_contact_buyer);
        }
        return a((int) R.string.sp_view_shipping_details);
    }

    public String b(OrderDetail orderDetail) {
        return (String) d(orderDetail).first;
    }

    public boolean c(OrderDetail orderDetail) {
        return ((Boolean) d(orderDetail).second).booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0203, code lost:
        if (r0 >= (r12.getShipByDate() - 86400)) goto L_0x0295;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0226, code lost:
        if (r0 >= (r12.getAutoCancellationLayer1Date() - 86400)) goto L_0x0295;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0237, code lost:
        if (r0 >= (r12.getAutoCancellationLayer1Date() - 86400)) goto L_0x0295;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0259, code lost:
        if (r0 >= (r12.getAutoCancellationLayer1Date() - 86400)) goto L_0x0295;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0269, code lost:
        if (r0 >= (r12.getAutoCancellationLayer1Date() - 86400)) goto L_0x0295;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x02ce, code lost:
        if (r0 >= (r12.getShipByDate() - 86400)) goto L_0x02ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02e6, code lost:
        if (r0 >= (r12.getAutoCancellationLayer2Date() - 86400)) goto L_0x02ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d2, code lost:
        if (r0 >= (r12.getAutoCancellationLayer1Date() - 86400)) goto L_0x0295;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f6, code lost:
        if (r0 >= (r12.getShipByDate() - 86400)) goto L_0x0295;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0113, code lost:
        if (r0 >= (r12.getAutoCancellationLayer1Date() - 86400)) goto L_0x0295;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0136, code lost:
        if (r0 >= (r12.getAutoCancellationLayer1Date() - 86400)) goto L_0x0295;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0147, code lost:
        if (r0 >= (r12.getAutoCancellationLayer1Date() - 86400)) goto L_0x0295;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01d7, code lost:
        if (r0 >= (r12.getAutoCancellationLayer1Date() - 86400)) goto L_0x0295;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01f2, code lost:
        if (r0 >= (r12.getAutoCancellationLayer1Date() - 86400)) goto L_0x0295;
     */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02c1  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.util.Pair<java.lang.String, java.lang.Boolean> d(com.shopee.app.data.viewmodel.OrderDetail r12) {
        /*
            r11 = this;
            int r0 = com.garena.android.appkit.tools.a.a.a()
            boolean r1 = r12.isGHTK24h()
            r2 = 2131889084(0x7f120bbc, float:1.9412822E38)
            r3 = 2131889081(0x7f120bb9, float:1.9412815E38)
            r4 = 0
            r5 = 1
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r5)
            if (r1 == 0) goto L_0x0089
            boolean r1 = r12.logisticsCreated()
            if (r1 != 0) goto L_0x0025
            boolean r1 = r12.logisticsRetry()
            if (r1 == 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r1 = 0
            goto L_0x0026
        L_0x0025:
            r1 = 1
        L_0x0026:
            if (r1 != 0) goto L_0x003c
            int r7 = r12.getShipByDate()
            if (r0 >= r7) goto L_0x003c
            int r12 = r12.getShipByDate()
            java.lang.String r12 = b((int) r2, (int) r12)
            android.util.Pair r0 = new android.util.Pair
            r0.<init>(r12, r6)
            return r0
        L_0x003c:
            if (r1 != 0) goto L_0x0052
            int r7 = r12.getShipByDate()
            if (r0 < r7) goto L_0x0052
            int r12 = r12.getAutoCancellationLayer1Date()
            java.lang.String r12 = b((int) r3, (int) r12)
            android.util.Pair r0 = new android.util.Pair
            r0.<init>(r12, r6)
            return r0
        L_0x0052:
            if (r1 == 0) goto L_0x0089
            long r7 = r12.getLogisticFlag()
            r9 = 16
            long r7 = r7 & r9
            r9 = 0
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 <= 0) goto L_0x0089
            int r1 = r12.getAutoCancellationLayer1Date()
            if (r0 <= r1) goto L_0x0075
            int r12 = r12.getAutoCancellationLayer1Date()
            java.lang.String r12 = b((int) r3, (int) r12)
            android.util.Pair r0 = new android.util.Pair
            r0.<init>(r12, r6)
            return r0
        L_0x0075:
            int r1 = r12.getAutoCancellationLayer2Date()
            if (r0 <= r1) goto L_0x0089
            int r12 = r12.getAutoCancellationLayer2Date()
            java.lang.String r12 = b((int) r3, (int) r12)
            android.util.Pair r0 = new android.util.Pair
            r0.<init>(r12, r6)
            return r0
        L_0x0089:
            boolean r1 = r12.isSupported3PL()
            r6 = 2131889080(0x7f120bb8, float:1.9412813E38)
            r7 = 2131889083(0x7f120bbb, float:1.941282E38)
            r8 = 86400(0x15180, float:1.21072E-40)
            if (r1 == 0) goto L_0x02ac
            boolean r1 = r12.supportDropOff()
            if (r1 != 0) goto L_0x01b8
            boolean r1 = r12.logisticsManual()
            if (r1 == 0) goto L_0x00a6
            goto L_0x01b8
        L_0x00a6:
            boolean r1 = r12.supportPickup()
            if (r1 == 0) goto L_0x02ac
            boolean r1 = r12.logisticsReady()
            if (r1 == 0) goto L_0x014b
            int r1 = r12.getShipByDate()
            r9 = 2131887637(0x7f120615, float:1.9409887E38)
            if (r0 >= r1) goto L_0x00fa
            int r1 = r12.getShipByDate()
            int r3 = r12.getAutoCancellationLayer1Date()
            if (r1 < r3) goto L_0x00d6
            int r1 = r12.getAutoCancellationLayer1Date()
            java.lang.String r1 = a((int) r9, (int) r1)
            int r2 = r12.getAutoCancellationLayer1Date()
            int r2 = r2 - r8
            if (r0 < r2) goto L_0x02ae
            goto L_0x0295
        L_0x00d6:
            boolean r1 = r12.isGHTK24h()
            if (r1 == 0) goto L_0x00e6
            int r1 = r12.getShipByDate()
            java.lang.String r1 = b((int) r2, (int) r1)
            goto L_0x0295
        L_0x00e6:
            r1 = 2131887635(0x7f120613, float:1.9409883E38)
            int r2 = r12.getShipByDate()
            java.lang.String r1 = a((int) r1, (int) r2)
            int r2 = r12.getShipByDate()
            int r2 = r2 - r8
            if (r0 < r2) goto L_0x02ae
            goto L_0x0295
        L_0x00fa:
            int r1 = r12.getShipByDate()
            if (r0 <= r1) goto L_0x0117
            int r1 = r12.getAutoCancellationLayer1Date()
            if (r0 >= r1) goto L_0x0117
            int r1 = r12.getAutoCancellationLayer1Date()
            java.lang.String r1 = a((int) r9, (int) r1)
            int r2 = r12.getAutoCancellationLayer1Date()
            int r2 = r2 - r8
            if (r0 < r2) goto L_0x02ae
            goto L_0x0295
        L_0x0117:
            int r1 = r12.getAutoCancellationLayer1Date()
            if (r1 <= 0) goto L_0x02ac
            int r1 = r12.getAutoCancellationLayer1Date()
            if (r0 <= r1) goto L_0x02ac
            boolean r1 = r12.isGHTK24h()
            if (r1 == 0) goto L_0x013a
            int r1 = r12.getAutoCancellationLayer1Date()
            java.lang.String r1 = b((int) r3, (int) r1)
            int r2 = r12.getAutoCancellationLayer1Date()
            int r2 = r2 - r8
            if (r0 < r2) goto L_0x02ae
            goto L_0x0295
        L_0x013a:
            int r1 = r12.getAutoCancellationLayer1Date()
            java.lang.String r1 = a((int) r9, (int) r1)
            int r2 = r12.getAutoCancellationLayer1Date()
            int r2 = r2 - r8
            if (r0 < r2) goto L_0x02ae
            goto L_0x0295
        L_0x014b:
            boolean r1 = r12.logisticsCreated()
            if (r1 != 0) goto L_0x0157
            boolean r1 = r12.logisticsRetry()
            if (r1 == 0) goto L_0x02ac
        L_0x0157:
            int r1 = r12.getAutoCancellationLayer2Date()
            int r1 = r1 - r8
            if (r0 > r1) goto L_0x017f
            boolean r1 = r12.isGHTK24h()
            if (r1 == 0) goto L_0x016e
            int r1 = r12.getAutoCancellationLayer1Date()
            java.lang.String r1 = b((int) r3, (int) r1)
            goto L_0x0295
        L_0x016e:
            r1 = 2131888794(0x7f120a9a, float:1.9412233E38)
            java.lang.Object[] r2 = new java.lang.Object[r5]
            java.lang.String r3 = r12.getPickupTimeString()
            r2[r4] = r3
            java.lang.String r1 = com.garena.android.appkit.tools.b.a(r1, r2)
            goto L_0x02ae
        L_0x017f:
            int r1 = r12.getAutoCancellationLayer2Date()
            r2 = 2131888848(0x7f120ad0, float:1.9412343E38)
            if (r0 > r1) goto L_0x01a2
            boolean r1 = r12.isGHTK24h()
            if (r1 == 0) goto L_0x0198
            int r1 = r12.getAutoCancellationLayer2Date()
            java.lang.String r1 = b((int) r3, (int) r1)
            goto L_0x0295
        L_0x0198:
            int r1 = r12.getAutoCancellationLayer2Date()
            java.lang.String r1 = a((int) r2, (int) r1)
            goto L_0x0295
        L_0x01a2:
            int r1 = r12.getAutoCancellationLayer2Date()
            if (r1 <= 0) goto L_0x02ac
            int r1 = r12.getAutoCancellationLayer2Date()
            if (r0 <= r1) goto L_0x02ac
            int r1 = r12.getAutoCancellationLayer2Date()
            java.lang.String r1 = a((int) r2, (int) r1)
            goto L_0x0295
        L_0x01b8:
            boolean r1 = r12.logisticsReady()
            if (r1 == 0) goto L_0x026c
            int r1 = r12.getShipByDate()
            if (r0 >= r1) goto L_0x0207
            boolean r1 = r12.isGHTK24h()
            if (r1 == 0) goto L_0x01db
            int r1 = r12.getAutoCancellationLayer1Date()
            java.lang.String r1 = b((int) r2, (int) r1)
            int r2 = r12.getAutoCancellationLayer1Date()
            int r2 = r2 - r8
            if (r0 < r2) goto L_0x02ae
            goto L_0x0295
        L_0x01db:
            int r1 = r12.getShipByDate()
            int r2 = r12.getAutoCancellationLayer1Date()
            if (r1 < r2) goto L_0x01f6
            int r1 = r12.getAutoCancellationLayer1Date()
            java.lang.String r1 = a((int) r7, (int) r1)
            int r2 = r12.getAutoCancellationLayer1Date()
            int r2 = r2 - r8
            if (r0 < r2) goto L_0x02ae
            goto L_0x0295
        L_0x01f6:
            int r1 = r12.getShipByDate()
            java.lang.String r1 = a((int) r6, (int) r1)
            int r2 = r12.getShipByDate()
            int r2 = r2 - r8
            if (r0 < r2) goto L_0x02ae
            goto L_0x0295
        L_0x0207:
            int r1 = r12.getShipByDate()
            if (r0 <= r1) goto L_0x023a
            int r1 = r12.getAutoCancellationLayer1Date()
            if (r0 >= r1) goto L_0x023a
            boolean r1 = r12.isGHTK24h()
            if (r1 == 0) goto L_0x022a
            int r1 = r12.getAutoCancellationLayer1Date()
            java.lang.String r1 = b((int) r3, (int) r1)
            int r2 = r12.getAutoCancellationLayer1Date()
            int r2 = r2 - r8
            if (r0 < r2) goto L_0x02ae
            goto L_0x0295
        L_0x022a:
            int r1 = r12.getAutoCancellationLayer1Date()
            java.lang.String r1 = a((int) r7, (int) r1)
            int r2 = r12.getAutoCancellationLayer1Date()
            int r2 = r2 - r8
            if (r0 < r2) goto L_0x02ae
            goto L_0x0295
        L_0x023a:
            int r1 = r12.getAutoCancellationLayer1Date()
            if (r1 <= 0) goto L_0x02ac
            int r1 = r12.getAutoCancellationLayer1Date()
            if (r0 <= r1) goto L_0x02ac
            boolean r1 = r12.isGHTK24h()
            if (r1 == 0) goto L_0x025c
            int r1 = r12.getAutoCancellationLayer1Date()
            java.lang.String r1 = b((int) r3, (int) r1)
            int r2 = r12.getAutoCancellationLayer1Date()
            int r2 = r2 - r8
            if (r0 < r2) goto L_0x02ae
            goto L_0x0295
        L_0x025c:
            int r1 = r12.getAutoCancellationLayer1Date()
            java.lang.String r1 = a((int) r7, (int) r1)
            int r2 = r12.getAutoCancellationLayer1Date()
            int r2 = r2 - r8
            if (r0 < r2) goto L_0x02ae
            goto L_0x0295
        L_0x026c:
            boolean r1 = r12.logisticsCreated()
            if (r1 != 0) goto L_0x0278
            boolean r1 = r12.logisticsRetry()
            if (r1 == 0) goto L_0x02ac
        L_0x0278:
            int r1 = r12.getAutoCancellationLayer2Date()
            int r1 = r1 - r8
            if (r0 > r1) goto L_0x0287
            r1 = 2131889320(0x7f120ca8, float:1.94133E38)
            java.lang.String r1 = com.garena.android.appkit.tools.b.e(r1)
            goto L_0x02ae
        L_0x0287:
            int r1 = r12.getAutoCancellationLayer2Date()
            if (r0 > r1) goto L_0x0297
            int r1 = r12.getAutoCancellationLayer2Date()
            java.lang.String r1 = a((int) r7, (int) r1)
        L_0x0295:
            r2 = 1
            goto L_0x02af
        L_0x0297:
            int r1 = r12.getAutoCancellationLayer2Date()
            if (r1 <= 0) goto L_0x02ac
            int r1 = r12.getAutoCancellationLayer2Date()
            if (r0 <= r1) goto L_0x02ac
            int r1 = r12.getAutoCancellationLayer2Date()
            java.lang.String r1 = a((int) r7, (int) r1)
            goto L_0x0295
        L_0x02ac:
            java.lang.String r1 = ""
        L_0x02ae:
            r2 = 0
        L_0x02af:
            boolean r3 = r12.isNonSupported3PL()
            if (r3 == 0) goto L_0x02fe
            boolean r3 = r12.logisticsNotStarted()
            if (r3 == 0) goto L_0x02fe
            int r3 = r12.getShipByDate()
            if (r0 >= r3) goto L_0x02d3
            int r1 = r12.getShipByDate()
            java.lang.String r1 = a((int) r6, (int) r1)
            int r12 = r12.getShipByDate()
            int r12 = r12 - r8
            if (r0 < r12) goto L_0x02d1
            goto L_0x02ff
        L_0x02d1:
            r5 = 0
            goto L_0x02ff
        L_0x02d3:
            int r3 = r12.getAutoCancellationLayer2Date()
            if (r0 > r3) goto L_0x02e9
            int r1 = r12.getAutoCancellationLayer2Date()
            java.lang.String r1 = a((int) r7, (int) r1)
            int r12 = r12.getAutoCancellationLayer2Date()
            int r12 = r12 - r8
            if (r0 < r12) goto L_0x02d1
            goto L_0x02ff
        L_0x02e9:
            int r3 = r12.getAutoCancellationLayer2Date()
            if (r3 <= 0) goto L_0x02fe
            int r3 = r12.getAutoCancellationLayer2Date()
            if (r0 <= r3) goto L_0x02fe
            int r12 = r12.getAutoCancellationLayer2Date()
            java.lang.String r1 = a((int) r7, (int) r12)
            goto L_0x02ff
        L_0x02fe:
            r5 = r2
        L_0x02ff:
            android.util.Pair r12 = new android.util.Pair
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r5)
            r12.<init>(r1, r0)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.d.b.a.d.j.d(com.shopee.app.data.viewmodel.OrderDetail):android.util.Pair");
    }

    private static String a(int i, int i2) {
        return b.a(i, com.garena.android.appkit.tools.a.a.c(i2, "ID"));
    }

    private static String b(int i, int i2) {
        return b.a(i, com.garena.android.appkit.tools.a.a.a(i2, "ID"));
    }
}
