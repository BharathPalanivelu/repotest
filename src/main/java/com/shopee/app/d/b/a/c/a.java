package com.shopee.app.d.b.a.c;

import android.app.Activity;
import android.view.View;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.ui.a.e;
import com.shopee.app.util.ak;
import com.shopee.app.util.bj;
import com.shopee.id.R;
import d.d.b.j;
import d.d.b.k;
import d.i;
import d.m;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f16328a = new a();

    private a() {
    }

    public final boolean a(SettingConfigStore settingConfigStore, ReturnItem returnItem) {
        j.b(settingConfigStore, "settingConfigStore");
        j.b(returnItem, "returnItem");
        return settingConfigStore.c2cReverseLogistics711Enabled() && !returnItem.isOfficialShop();
    }

    public final Object a(ReturnItem returnItem, c cVar) {
        j.b(returnItem, "returnItem");
        j.b(cVar, "viewDataType");
        try {
            ar f2 = ar.f();
            j.a((Object) f2, "ShopeeApplication.get()");
            SettingConfigStore settingConfigStore = f2.e().settingConfigStore();
            j.a((Object) settingConfigStore, "settingConfigStore");
            if (!a(settingConfigStore, returnItem)) {
                return null;
            }
            return cVar.getValue(new b(returnItem, cVar).invoke());
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    static final class b extends k implements d.d.a.a<Object> {
        final /* synthetic */ ReturnItem $returnItem;
        final /* synthetic */ c $viewDataType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ReturnItem returnItem, c cVar) {
            super(0);
            this.$returnItem = returnItem;
            this.$viewDataType = cVar;
        }

        public final Object invoke() {
            if (this.$returnItem.isLogisticPendingArrange() || this.$returnItem.isLogisticReady() || (this.$returnItem.isLogisticRequestCreated() && !this.$returnItem.hasTrackingNumber())) {
                if (!this.$returnItem.isSelling()) {
                    int i = b.f16333a[this.$viewDataType.ordinal()];
                    if (i == 1) {
                        return "";
                    }
                    if (i == 2) {
                        return a.f16328a.a(this.$returnItem);
                    }
                    if (i == 3) {
                        return com.garena.android.appkit.tools.b.e(R.string.order_list_return_pending);
                    }
                    throw new i();
                }
                int i2 = b.f16334b[this.$viewDataType.ordinal()];
                if (i2 == 1) {
                    return "";
                }
                if (i2 == 2) {
                    return a.f16328a.a(this.$returnItem);
                }
                if (i2 == 3) {
                    return com.garena.android.appkit.tools.b.e(R.string.order_list_return_pending);
                }
                throw new i();
            } else if (!this.$returnItem.isLogisticRequestCreated() || !this.$returnItem.hasTrackingNumber()) {
                if (!this.$returnItem.isPickupDone() || !this.$returnItem.isSupportedShippingMethod()) {
                    if (!this.$returnItem.isLogisticDeliveryDone() || !this.$returnItem.isSupportedShippingMethod()) {
                        if (this.$returnItem.isLogisticNotStarted()) {
                            if (!this.$returnItem.isSelling()) {
                                int i3 = b.i[this.$viewDataType.ordinal()];
                                if (i3 != 1) {
                                    if (i3 == 2) {
                                        return new a.C0251a(com.garena.android.appkit.tools.b.e(R.string.sp_label_input_shipping_information), 0, new View.OnClickListener(this) {

                                            /* renamed from: a  reason: collision with root package name */
                                            final /* synthetic */ b f16331a;

                                            {
                                                this.f16331a = r1;
                                            }

                                            public final void onClick(View view) {
                                                Activity a2 = bj.a(view);
                                                if (a2 != null) {
                                                    new ak(a2).i(this.f16331a.$returnItem.getReturnId());
                                                }
                                            }
                                        });
                                    }
                                    if (i3 == 3) {
                                        return com.garena.android.appkit.tools.b.e(R.string.order_list_return_pending);
                                    }
                                    throw new i();
                                } else if (this.$returnItem.getReturnShipDueDate() <= 0) {
                                    return "";
                                } else {
                                    return com.garena.android.appkit.tools.b.a(R.string.sp_return_to_seller_by_date, com.garena.android.appkit.tools.a.a.c(this.$returnItem.getReturnShipDueDate(), "ID"));
                                }
                            } else {
                                int i4 = b.j[this.$viewDataType.ordinal()];
                                if (i4 == 1) {
                                    return "";
                                }
                                if (i4 == 2) {
                                    return a.f16328a.a(this.$returnItem);
                                }
                                if (i4 == 3) {
                                    return com.garena.android.appkit.tools.b.e(R.string.order_list_return_pending);
                                }
                                throw new i();
                            }
                        } else if (!this.$returnItem.isLogisticDeliveryDone() || this.$returnItem.isSupportedShippingMethod()) {
                            return null;
                        } else {
                            if (!this.$returnItem.isSelling()) {
                                int i5 = b.k[this.$viewDataType.ordinal()];
                                if (i5 == 1) {
                                    return "";
                                }
                                if (i5 == 2) {
                                    return a.f16328a.a(this.$returnItem);
                                }
                                if (i5 == 3) {
                                    return com.garena.android.appkit.tools.b.e(R.string.order_list_return_pick_up_done);
                                }
                                throw new i();
                            }
                            int i6 = b.l[this.$viewDataType.ordinal()];
                            if (i6 != 1) {
                                if (i6 == 2) {
                                    return a.f16328a.a(this.$returnItem);
                                }
                                if (i6 == 3) {
                                    return com.garena.android.appkit.tools.b.e(R.string.order_list_return_pick_up_done);
                                }
                                throw new i();
                            } else if (this.$returnItem.getReturnSellerDueDate() <= 0) {
                                return "";
                            } else {
                                return com.garena.android.appkit.tools.b.a(R.string.sp_response_by_date, com.garena.android.appkit.tools.a.a.c(this.$returnItem.getReturnSellerDueDate(), "ID"));
                            }
                        }
                    } else if (!this.$returnItem.isSelling()) {
                        int i7 = b.f16339g[this.$viewDataType.ordinal()];
                        if (i7 == 1) {
                            return "";
                        }
                        if (i7 == 2) {
                            return a.f16328a.a(this.$returnItem);
                        }
                        if (i7 == 3) {
                            return com.garena.android.appkit.tools.b.e(R.string.order_list_return_delivery_up_done_seller);
                        }
                        throw new i();
                    } else {
                        int i8 = b.h[this.$viewDataType.ordinal()];
                        if (i8 != 1) {
                            if (i8 == 2) {
                                return new a.C0251a(com.garena.android.appkit.tools.b.e(R.string.sp_label_respond), 0, new View.OnClickListener(this) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ b f16330a;

                                    {
                                        this.f16330a = r1;
                                    }

                                    public final void onClick(View view) {
                                        Activity a2 = bj.a(view);
                                        if (a2 != null) {
                                            ar f2 = ar.f();
                                            j.a((Object) f2, "ShopeeApplication.get()");
                                            com.shopee.app.tracking.a actionTracker = f2.e().actionTracker();
                                            if (a2 != null) {
                                                actionTracker.a(((e) a2).A(), this.f16330a.$returnItem);
                                                new ak(a2).a(this.f16330a.$returnItem.isSelling(), this.f16330a.$returnItem.getReturnId());
                                                return;
                                            }
                                            throw new m("null cannot be cast to non-null type com.shopee.app.ui.base.BaseActivity");
                                        }
                                    }
                                });
                            }
                            if (i8 == 3) {
                                return com.garena.android.appkit.tools.b.e(R.string.order_list_return_delivery_up_done_seller);
                            }
                            throw new i();
                        } else if (this.$returnItem.getReturnSellerDueDate() <= 0) {
                            return "";
                        } else {
                            return com.garena.android.appkit.tools.b.a(R.string.sp_response_by_date, com.garena.android.appkit.tools.a.a.c(this.$returnItem.getReturnSellerDueDate(), "ID"));
                        }
                    }
                } else if (!this.$returnItem.isSelling()) {
                    int i9 = b.f16337e[this.$viewDataType.ordinal()];
                    if (i9 == 1) {
                        return "";
                    }
                    if (i9 == 2) {
                        return a.f16328a.a(this.$returnItem);
                    }
                    if (i9 == 3) {
                        return com.garena.android.appkit.tools.b.e(R.string.order_list_return_pick_up_done);
                    }
                    throw new i();
                } else {
                    int i10 = b.f16338f[this.$viewDataType.ordinal()];
                    if (i10 == 1) {
                        return "";
                    }
                    if (i10 == 2) {
                        return a.f16328a.a(this.$returnItem);
                    }
                    if (i10 == 3) {
                        return com.garena.android.appkit.tools.b.e(R.string.order_list_return_pick_up_done);
                    }
                    throw new i();
                }
            } else if (!this.$returnItem.isSelling()) {
                int i11 = b.f16335c[this.$viewDataType.ordinal()];
                if (i11 != 1) {
                    if (i11 == 2) {
                        return a.f16328a.a(this.$returnItem);
                    }
                    if (i11 == 3) {
                        return com.garena.android.appkit.tools.b.e(R.string.order_list_return_pending);
                    }
                    throw new i();
                } else if (this.$returnItem.getReturnShipDueDate() <= 0) {
                    return "";
                } else {
                    return com.garena.android.appkit.tools.b.a(R.string.sp_return_to_seller_by_date, com.garena.android.appkit.tools.a.a.c(this.$returnItem.getReturnShipDueDate(), "ID"));
                }
            } else {
                int i12 = b.f16336d[this.$viewDataType.ordinal()];
                if (i12 == 1) {
                    return "";
                }
                if (i12 == 2) {
                    return a.f16328a.a(this.$returnItem);
                }
                if (i12 == 3) {
                    return com.garena.android.appkit.tools.b.e(R.string.order_list_return_pending);
                }
                throw new i();
            }
        }
    }

    public final Object b(ReturnItem returnItem, c cVar) {
        j.b(returnItem, "returnItem");
        j.b(cVar, "viewDataType");
        try {
            ar f2 = ar.f();
            j.a((Object) f2, "ShopeeApplication.get()");
            SettingConfigStore settingConfigStore = f2.e().settingConfigStore();
            j.a((Object) settingConfigStore, "settingConfigStore");
            if (!a(settingConfigStore, returnItem)) {
                return null;
            }
            return cVar.getValue(new C0252a(cVar, returnItem).invoke());
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    /* renamed from: com.shopee.app.d.b.a.c.a$a  reason: collision with other inner class name */
    static final class C0252a extends k implements d.d.a.a<Object> {
        final /* synthetic */ ReturnItem $returnItem;
        final /* synthetic */ c $viewDataType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0252a(c cVar, ReturnItem returnItem) {
            super(0);
            this.$viewDataType = cVar;
            this.$returnItem = returnItem;
        }

        public final Object invoke() {
            int i = b.m[this.$viewDataType.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return new a.C0251a(com.garena.android.appkit.tools.b.e(R.string.sp_re_re_detail), 0, new View.OnClickListener(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ C0252a f16329a;

                        {
                            this.f16329a = r1;
                        }

                        public final void onClick(View view) {
                            Activity a2 = bj.a(view);
                            if (a2 != null) {
                                new ak(a2).a(this.f16329a.$returnItem.isSelling(), this.f16329a.$returnItem.getReturnId());
                            }
                        }
                    });
                }
                if (i == 3) {
                    return com.garena.android.appkit.tools.b.e(R.string.sp_request_pending);
                }
                throw new i();
            } else if (this.$returnItem.getSellerDueDay() <= 0) {
                return "";
            } else {
                return com.garena.android.appkit.tools.b.a(R.string.action_buyer_return_pending_summary_text, com.garena.android.appkit.tools.a.a.c(this.$returnItem.getSellerDueDay(), "ID"));
            }
        }
    }

    /* access modifiers changed from: private */
    public final a.C0251a a(ReturnItem returnItem) {
        return new a.C0251a(com.garena.android.appkit.tools.b.e(R.string.sp_re_re_detail), 0, new c(returnItem));
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReturnItem f16332a;

        c(ReturnItem returnItem) {
            this.f16332a = returnItem;
        }

        public final void onClick(View view) {
            Activity a2 = bj.a(view);
            if (a2 != null) {
                new ak(a2).a(this.f16332a.isSelling(), this.f16332a.getReturnId());
            }
        }
    }
}
