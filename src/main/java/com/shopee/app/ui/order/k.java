package com.shopee.app.ui.order;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.garena.android.appkit.tools.b;
import com.shopee.app.d.c.cm;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.h.m;
import com.shopee.app.h.q;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.au;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.id.R;

public class k {
    private e A = new g() {
        public void onEvent(a aVar) {
            k.this.f23677d.a(((CheckoutItem) aVar.data).getCheckoutId());
        }
    };
    private e B = new g() {
        public void onEvent(a aVar) {
            k.this.f23677d.b(((CheckoutItem) aVar.data).getCheckoutId());
        }
    };
    private e C = new g() {
        public void onEvent(a aVar) {
            k.this.f23677d.c(((CheckoutItem) aVar.data).getCheckoutId());
        }
    };
    private e D = new g() {
        public void onEvent(a aVar) {
            OrderDetail orderDetail = (OrderDetail) aVar.data;
            k.this.f23677d.a(orderDetail.getShopId(), m.a(orderDetail.getShopId()) ? orderDetail.getUserId() : orderDetail.getSellerId(), orderDetail.getOrderId());
        }
    };
    private e E = new g() {
        public void onEvent(a aVar) {
            OrderDetail orderDetail = (OrderDetail) aVar.data;
            com.shopee.app.network.d.h.a aVar2 = new com.shopee.app.network.d.h.a();
            aVar2.h();
            aVar2.a(orderDetail.getOrderId(), orderDetail.isSelling() ? 2 : 1, orderDetail.isSelling());
        }
    };
    private e F = new g() {
        public void onEvent(a aVar) {
            k.this.f23678e.b();
            k.this.f23677d.f(((Boolean) aVar.data).booleanValue() ? b.e(R.string.sp_order_buy_again_error) : null);
        }
    };
    private e G = new g() {
        public void onEvent(a aVar) {
            k.this.f23677d.e(((CheckoutItem) aVar.data).getCheckoutId());
        }
    };
    private e H = new g() {
        public void onEvent(a aVar) {
            k.this.f23677d.a(((OrderDetail) aVar.data).getOrderId(), com.shopee.app.ui.order.b.e.f23572a);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final bi f23674a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final cm f23675b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Context f23676c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ak f23677d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final r f23678e;

    /* renamed from: f  reason: collision with root package name */
    private final n f23679f;

    /* renamed from: g  reason: collision with root package name */
    private final i f23680g;
    private e h = new g() {
        public void onEvent(a aVar) {
            final j jVar = (j) aVar;
            com.shopee.app.ui.dialog.a.a(k.this.f23676c, jVar.f23673b, (int) R.string.sp_label_not_yet, (int) R.string.sp_label_received, (a.C0318a) new a.C0318a() {
                public void onNegative() {
                }

                public void onPositive() {
                    com.shopee.app.ui.dialog.a.a(k.this.f23676c, (int) R.string.sp_label_cancel, (int) R.string.sp_label_confirm, (a.d) new a.d() {
                        public void a() {
                        }

                        public void a(long j, int i) {
                            k.this.f23678e.a();
                            k.this.f23675b.a(jVar.f23672a, j);
                        }
                    }, jVar.f23672a.getTotalPrice(), (int) R.color.common_grey_bg);
                }
            });
        }
    };
    private e i = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            final OrderDetail orderDetail = (OrderDetail) aVar.data;
            com.shopee.app.ui.dialog.a.a(k.this.f23676c, R.string.sp_label_skip, R.string.sp_label_cancel, R.string.sp_label_ship, new a.e() {
                public void a() {
                }

                public void a(String str, String str2) {
                    k.this.f23678e.a();
                    orderDetail.setActualCarrier(str);
                    orderDetail.setShippingTraceNo(str2);
                    k.this.f23675b.a(orderDetail);
                }
            }, orderDetail.getActualCarrier(), b.e(R.string.sp_label_logistic), b.e(R.string.sp_label_tracking_code), R.color.white);
        }
    };
    private e j = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            k.this.f23677d.b(((OrderDetail) aVar.data).getOrderId(), com.shopee.app.ui.order.b.e.f23572a);
        }
    };
    private e k = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            k.this.f23678e.a();
            k.this.f23675b.c((OrderDetail) aVar.data);
        }
    };
    private e l = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            k.this.f23677d.d((OrderDetail) aVar.data);
        }
    };
    private e m = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            final OrderDetail orderDetail = (OrderDetail) aVar.data;
            com.shopee.app.ui.dialog.a.a(k.this.f23676c, b.a(R.string.sp_release_money_to_seller, au.b(orderDetail.getTotalPrice())), b.e(R.string.sp_confirm_receive_product_info), b.e(R.string.sp_label_cancel), b.e(R.string.sp_label_confirm), (a.C0318a) new a.C0318a() {
                public void onNegative() {
                }

                public void onPositive() {
                    k.this.f23678e.a();
                    k.this.f23675b.b(orderDetail);
                }
            });
        }
    };
    private e n = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            com.shopee.app.ui.dialog.a.a(k.this.f23676c, (int) R.string.sp_make_payment, (int) R.string.sp_make_payment_disclaimer, 0, (int) R.string.sp_label_ok);
        }
    };
    private e o = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            OrderDetail orderDetail = (OrderDetail) aVar.data;
            k.this.f23677d.e(orderDetail.getShopId(), orderDetail.getOrderId());
        }
    };
    private e p = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            final CheckoutItem checkoutItem = (CheckoutItem) aVar.data;
            com.shopee.app.ui.dialog.a.a(k.this.f23676c, (int) R.string.sp_buyer_cancel_order_prompt, (int) R.string.sp_label_no, (int) R.string.sp_label_yes, (a.C0318a) new a.C0318a() {
                public void onNegative() {
                }

                public void onPositive() {
                    new com.shopee.app.network.d.e().a(checkoutItem.getCheckoutId());
                }
            });
        }
    };
    private e q = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            k.this.f23677d.a((OrderDetail) aVar.data);
        }
    };
    private e r = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            OrderDetail orderDetail = (OrderDetail) aVar.data;
            k.this.f23677d.d(orderDetail.getShopId(), orderDetail.getOrderId());
        }
    };
    private e s = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            final OrderDetail orderDetail = (OrderDetail) aVar.data;
            com.shopee.app.ui.dialog.a.a(k.this.f23676c, (int) R.string.sp_buyer_extend_escrow_prompt, (int) R.string.sp_label_no, (int) R.string.sp_label_yes, (a.C0318a) new a.C0318a() {
                public void onNegative() {
                }

                public void onPositive() {
                    k.this.f23678e.a();
                    k.this.f23675b.d(orderDetail);
                }
            });
        }
    };
    private e t = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            final OrderDetail orderDetail = (OrderDetail) aVar.data;
            com.shopee.app.ui.dialog.a.a(k.this.f23676c, (int) R.string.sp_buyer_extend_escrow_new_prompt, (int) R.string.sp_label_no, (int) R.string.sp_label_yes, (a.C0318a) new a.C0318a() {
                public void onNegative() {
                }

                public void onPositive() {
                    k.this.f23678e.a();
                    k.this.f23675b.d(orderDetail);
                }
            });
        }
    };
    private e u = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            k.this.f23677d.f(((OrderDetail) aVar.data).getOrderId());
        }
    };
    private e v = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ak d2 = k.this.f23677d;
            d2.n(com.shopee.app.util.i.f7040c + "buyer/refund/orderid/" + ((OrderDetail) aVar.data).getOrderId() + "/add_bank_account/");
        }
    };
    private e w = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            OrderDetail orderDetail = (OrderDetail) aVar.data;
            k.this.f23677d.a(orderDetail.getOrderId(), orderDetail.getShopId());
        }
    };
    private e x = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            OrderDetail orderDetail = (OrderDetail) aVar.data;
            k.this.f23677d.a(orderDetail.getShopId(), orderDetail.getOrderId(), orderDetail.isSelling());
        }
    };
    private e y = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            OrderDetail orderDetail = (OrderDetail) aVar.data;
            k.this.f23677d.f(orderDetail.getShopId(), orderDetail.getOrderId());
        }
    };
    private e z = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            OrderDetail orderDetail = (OrderDetail) aVar.data;
            k.this.f23677d.f(orderDetail.getShopId(), orderDetail.getOrderId());
        }
    };

    public k(Context context, ak akVar, r rVar, bi biVar, n nVar, cm cmVar) {
        this.f23676c = context;
        this.f23677d = akVar;
        this.f23678e = rVar;
        this.f23674a = biVar;
        this.f23679f = nVar;
        this.f23675b = cmVar;
        this.f23680g = com.garena.a.a.a.b.a(this);
    }

    public void a() {
        this.f23680g.a();
        this.f23680g.c();
        this.f23674a.a("ORDER_PAYMENT_RECEIVED", this.h);
        this.f23674a.a("ORDER_SHIPPED", this.i);
        this.f23674a.a("GOTO_SHIP_PAGE", this.j);
        this.f23674a.a("ORDER_CANCELLED_BUY", this.k);
        this.f23674a.a("ORDER_BUYER_RATE", this.l);
        this.f23674a.a("ORDER_SHIP_RECEIVED", this.m);
        this.f23674a.a("ORDER_PAY", this.n);
        this.f23674a.a("ORDER_CANCEL", this.o);
        this.f23674a.a("CANCEL_CHECKOUT_ACTION", this.p);
        this.f23674a.a("ORDER_REQUEST_RETURN_N_REFUND", this.q);
        this.f23674a.a("EXTEND_ESCROW", this.s);
        this.f23674a.a("ORDER_GOTO_DETAIL", this.w);
        this.f23674a.a("ORDER_GOTO_CANCEL_DETAIL", this.x);
        this.f23674a.a("ORDER_GOTO_REQUESTED_CANCEL_DETAIL", this.y);
        this.f23674a.a("ORDER_GOTO_RESPONSE_CANCEL", this.z);
        this.f23674a.a("ORDER_GOTO_CHECKOUT_DETAIL", this.A);
        this.f23674a.a("GOTO_PAY_CHECKOUT_PAGE", this.B);
        this.f23674a.a("GOTO_CHANGE_CHECKOUT_PAY", this.C);
        this.f23674a.a("ORDER_GOTO_CHAT", this.D);
        this.f23674a.a("ORDER_ARCHIVE", this.E);
        this.f23674a.a("GOTO_ORDER_RETURN_DETAIL", this.r);
        this.f23674a.a("ORDER_CHANGE_LOGISTICS", this.G);
        this.f23674a.a("GOTO_PICKUP_DETAIL_PAGE", this.H);
        this.f23674a.a("EXTEND_ESCROW_NEW", this.t);
        this.f23674a.a("ORDER_REVISE_SHIP_FEE", this.u);
        this.f23674a.a("ORDER_PROVIDE_BANK_ACCOUNT", this.v);
        this.f23679f.a("ORDER_BUY_AGAIN_SUCCESS", this.F);
    }

    public void b() {
        this.f23680g.b();
        this.f23680g.d();
        this.f23674a.b("ORDER_PAYMENT_RECEIVED", this.h);
        this.f23674a.b("ORDER_SHIPPED", this.i);
        this.f23674a.b("GOTO_SHIP_PAGE", this.j);
        this.f23674a.b("ORDER_CANCEL", this.o);
        this.f23674a.b("CANCEL_CHECKOUT_ACTION", this.p);
        this.f23674a.b("ORDER_REQUEST_RETURN_N_REFUND", this.q);
        this.f23674a.b("EXTEND_ESCROW", this.s);
        this.f23674a.b("ORDER_CANCELLED_BUY", this.k);
        this.f23674a.b("ORDER_BUYER_RATE", this.l);
        this.f23674a.b("ORDER_SHIP_RECEIVED", this.m);
        this.f23674a.b("ORDER_PAY", this.n);
        this.f23674a.b("ORDER_GOTO_DETAIL", this.w);
        this.f23674a.b("ORDER_GOTO_CANCEL_DETAIL", this.x);
        this.f23674a.b("ORDER_GOTO_REQUESTED_CANCEL_DETAIL", this.y);
        this.f23674a.b("ORDER_GOTO_RESPONSE_CANCEL", this.z);
        this.f23674a.b("ORDER_GOTO_CHECKOUT_DETAIL", this.A);
        this.f23674a.b("GOTO_PAY_CHECKOUT_PAGE", this.B);
        this.f23674a.b("GOTO_CHANGE_CHECKOUT_PAY", this.C);
        this.f23674a.b("ORDER_GOTO_CHAT", this.D);
        this.f23674a.b("ORDER_ARCHIVE", this.E);
        this.f23674a.b("GOTO_ORDER_RETURN_DETAIL", this.r);
        this.f23674a.b("ORDER_CHANGE_LOGISTICS", this.G);
        this.f23674a.b("GOTO_PICKUP_DETAIL_PAGE", this.H);
        this.f23674a.b("EXTEND_ESCROW_NEW", this.t);
        this.f23674a.b("ORDER_REVISE_SHIP_FEE", this.u);
        this.f23674a.b("ORDER_PROVIDE_BANK_ACCOUNT", this.v);
        this.f23679f.b("ORDER_BUY_AGAIN_SUCCESS", this.F);
    }

    /* access modifiers changed from: package-private */
    public void a(OrderDetail orderDetail) {
        this.f23677d.e(orderDetail);
    }

    /* access modifiers changed from: package-private */
    public void b(OrderDetail orderDetail) {
        this.f23677d.b(orderDetail);
    }

    /* access modifiers changed from: package-private */
    public void c(OrderDetail orderDetail) {
        this.f23677d.c(orderDetail);
    }

    /* access modifiers changed from: package-private */
    public void d(OrderDetail orderDetail) {
        this.f23677d.f(orderDetail);
    }

    /* access modifiers changed from: package-private */
    public void e(OrderDetail orderDetail) {
        this.f23677d.c(orderDetail);
    }

    /* access modifiers changed from: package-private */
    public void f(OrderDetail orderDetail) {
        this.f23677d.b(orderDetail);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else if (aVar.f17892a != -100) {
            str = b.e(R.string.sp_server_error);
        } else {
            str = b.e(R.string.sp_network_error);
        }
        this.f23678e.b();
        Context context = this.f23676c;
        while ((context instanceof ContextWrapper) && !(context instanceof Activity)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            q.a(((Activity) context).findViewById(16908290), str);
        }
    }
}
