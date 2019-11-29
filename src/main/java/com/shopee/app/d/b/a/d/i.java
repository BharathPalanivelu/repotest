package com.shopee.app.d.b.a.d;

import android.view.View;
import com.appsflyer.share.Constants;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.a.a;
import com.shopee.app.d.b.a.a.e.aa;
import com.shopee.app.d.b.a.b.e.ab;
import com.shopee.app.d.b.a.b.e.ac;
import com.shopee.app.d.b.a.b.e.ad;
import com.shopee.app.d.b.a.b.e.ae;
import com.shopee.app.d.b.a.b.e.h;
import com.shopee.app.d.b.a.b.e.j;
import com.shopee.app.d.b.a.b.e.k;
import com.shopee.app.d.b.a.b.e.l;
import com.shopee.app.d.b.a.b.e.m;
import com.shopee.app.d.b.a.b.e.n;
import com.shopee.app.d.b.a.b.e.o;
import com.shopee.app.d.b.a.b.e.p;
import com.shopee.app.d.b.a.b.e.q;
import com.shopee.app.d.b.a.b.e.r;
import com.shopee.app.d.b.a.b.e.s;
import com.shopee.app.d.b.a.b.e.t;
import com.shopee.app.d.b.a.b.e.u;
import com.shopee.app.d.b.a.b.e.v;
import com.shopee.app.d.b.a.b.e.w;
import com.shopee.app.d.b.a.b.e.x;
import com.shopee.app.d.b.a.b.e.y;
import com.shopee.app.d.b.a.b.e.z;
import com.shopee.app.d.b.a.b.f.b;
import com.shopee.app.d.b.a.b.f.c;
import com.shopee.app.d.b.a.b.f.d;
import com.shopee.app.d.b.a.b.f.e;
import com.shopee.app.d.b.a.b.f.f;
import com.shopee.app.d.b.a.b.f.g;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.ui.webview.WebPageActivity_;
import com.shopee.id.R;

public class i {
    public static com.shopee.app.d.b.a.a a(OrderDetail orderDetail) {
        int listType = orderDetail.getListType();
        if (listType == 3) {
            return e(orderDetail);
        }
        if (listType == 4) {
            return f(orderDetail);
        }
        if (listType == 7) {
            return c(orderDetail);
        }
        if (listType == 8) {
            return d(orderDetail);
        }
        if (listType != 9) {
            return g(orderDetail);
        }
        return b(orderDetail);
    }

    private static com.shopee.app.d.b.a.a b(OrderDetail orderDetail) {
        if (!orderDetail.isSelling() && orderDetail.getCheckoutItem() != null) {
            return h.a(orderDetail.getCheckoutItem());
        }
        int paymentMethod = orderDetail.getPaymentMethod();
        if (paymentMethod == 1) {
            return new c(orderDetail);
        }
        if (paymentMethod == 2) {
            return new com.shopee.app.d.b.a.b.f.a(orderDetail);
        }
        if (paymentMethod == 3) {
            return new f(orderDetail);
        }
        if (paymentMethod == 6) {
            return new b(orderDetail);
        }
        if (paymentMethod != 26) {
            if (paymentMethod == 29) {
                return new d(orderDetail);
            }
            if (!(paymentMethod == 14 || paymentMethod == 15 || paymentMethod == 17 || paymentMethod == 18)) {
                switch (paymentMethod) {
                    case 21:
                    case 22:
                    case 23:
                        break;
                    case 24:
                        return new e(orderDetail);
                    default:
                        return new g(orderDetail);
                }
            }
        }
        return new e(orderDetail);
    }

    private static com.shopee.app.d.b.a.a c(OrderDetail orderDetail) {
        if (!orderDetail.isEscrow() || !orderDetail.isCancelPending()) {
            if (!orderDetail.isEscrow() || !orderDetail.returnRequested()) {
                if (!orderDetail.isEscrow() || !orderDetail.isSupported3PL() || !orderDetail.logisticsReady() || !orderDetail.logisticsAutoConsign() || orderDetail.isShippingExtended()) {
                    if (!orderDetail.isEscrow() || !orderDetail.isSupported3PL() || !orderDetail.logisticsReady() || !orderDetail.logisticsAutoConsign() || !orderDetail.isShippingExtended()) {
                        if (!orderDetail.isEscrow() || !orderDetail.isSupported3PL() || ((!orderDetail.logisticsCreated() && !orderDetail.logisticsRetry()) || !orderDetail.logisticsAutoConsign() || orderDetail.isShippingExtended())) {
                            if (!orderDetail.isEscrow() || !orderDetail.isSupported3PL() || ((!orderDetail.logisticsCreated() && !orderDetail.logisticsRetry()) || !orderDetail.logisticsAutoConsign() || !orderDetail.isShippingExtended())) {
                                if (!orderDetail.noCODPaymentMethod() || !orderDetail.isEscrow() || !orderDetail.isSupported3PL() || !orderDetail.logisticsManual() || !orderDetail.logisticsReady() || orderDetail.isShippingExtended()) {
                                    if (!orderDetail.noCODPaymentMethod() || !orderDetail.isEscrow() || !orderDetail.isSupported3PL() || !orderDetail.logisticsManual() || !orderDetail.logisticsReady() || !orderDetail.isShippingExtended()) {
                                        if (!orderDetail.noCODPaymentMethod() || !orderDetail.isEscrow() || !orderDetail.isSupported3PL() || !orderDetail.logisticsManual() || !orderDetail.logisticsCreated() || orderDetail.isShippingExtended()) {
                                            if (!orderDetail.noCODPaymentMethod() || !orderDetail.isEscrow() || !orderDetail.isSupported3PL() || !orderDetail.logisticsManual() || !orderDetail.logisticsCreated() || !orderDetail.isShippingExtended()) {
                                                if (!orderDetail.noCODPaymentMethod() || !orderDetail.isEscrow() || !orderDetail.isSupported3PL() || !orderDetail.logisticsReady() || orderDetail.isShippingExtended()) {
                                                    if (!orderDetail.noCODPaymentMethod() || !orderDetail.isEscrow() || !orderDetail.isSupported3PL() || !orderDetail.logisticsReady() || !orderDetail.isShippingExtended()) {
                                                        if (!orderDetail.noCODPaymentMethod() || !orderDetail.isEscrow() || !orderDetail.isSupported3PL() || !orderDetail.logisticsCreated() || !orderDetail.beforePickupCutoffTime() || orderDetail.isShippingExtended()) {
                                                            if (!orderDetail.noCODPaymentMethod() || !orderDetail.isEscrow() || !orderDetail.isSupported3PL() || !orderDetail.logisticsCreated() || !orderDetail.afterPickupCutoffTime() || orderDetail.isShippingExtended()) {
                                                                if (!orderDetail.noCODPaymentMethod() || !orderDetail.isEscrow() || !orderDetail.isSupported3PL() || !orderDetail.logisticsCreated() || !orderDetail.beforePickupCutoffTime() || !orderDetail.isShippingExtended()) {
                                                                    if (!orderDetail.noCODPaymentMethod() || !orderDetail.isEscrow() || !orderDetail.isSupported3PL() || !orderDetail.logisticsCreated() || !orderDetail.afterPickupCutoffTime() || !orderDetail.isShippingExtended()) {
                                                                        if (!orderDetail.noCODPaymentMethod() || !orderDetail.isEscrow() || !orderDetail.isSupported3PL() || !orderDetail.logisticsRetry() || orderDetail.isShippingExtended()) {
                                                                            if (!orderDetail.noCODPaymentMethod() || !orderDetail.isEscrow() || !orderDetail.isSupported3PL() || !orderDetail.logisticsRetry() || !orderDetail.isShippingExtended()) {
                                                                                if (!orderDetail.noCODPaymentMethod() || !orderDetail.isEscrow() || !orderDetail.isNonSupported3PL() || !orderDetail.logisticsNotStarted() || orderDetail.isShippingExtended()) {
                                                                                    if (!orderDetail.noCODPaymentMethod() || !orderDetail.isEscrow() || !orderDetail.isNonSupported3PL() || !orderDetail.logisticsNotStarted() || !orderDetail.isShippingExtended()) {
                                                                                        if (!orderDetail.isCODPaymentMethod() || !orderDetail.logisticsReady() || orderDetail.isShippingExtended()) {
                                                                                            if (!orderDetail.isCODPaymentMethod() || !orderDetail.logisticsReady() || !orderDetail.isShippingExtended()) {
                                                                                                if (!orderDetail.isCODPaymentMethod() || !orderDetail.logisticsCreated() || !orderDetail.beforePickupCutoffTime() || orderDetail.isShippingExtended()) {
                                                                                                    if (!orderDetail.isCODPaymentMethod() || !orderDetail.logisticsCreated() || !orderDetail.afterPickupCutoffTime() || orderDetail.isShippingExtended()) {
                                                                                                        if (!orderDetail.isCODPaymentMethod() || !orderDetail.logisticsCreated() || !orderDetail.beforePickupCutoffTime() || !orderDetail.isShippingExtended()) {
                                                                                                            if (!orderDetail.isCODPaymentMethod() || !orderDetail.logisticsCreated() || !orderDetail.afterPickupCutoffTime() || !orderDetail.isShippingExtended()) {
                                                                                                                if (!orderDetail.isCODPaymentMethod() || !orderDetail.logisticsRetry() || orderDetail.isShippingExtended()) {
                                                                                                                    if (!orderDetail.isCODPaymentMethod() || !orderDetail.logisticsRetry() || !orderDetail.isShippingExtended()) {
                                                                                                                        if (!orderDetail.isNoDeliveryTime() || !orderDetail.isSimple()) {
                                                                                                                            return g(orderDetail);
                                                                                                                        }
                                                                                                                        if (orderDetail.isSelling()) {
                                                                                                                            return new com.shopee.app.d.b.a.b.e.a(orderDetail);
                                                                                                                        }
                                                                                                                        return new com.shopee.app.d.b.a.a.e.a(orderDetail);
                                                                                                                    } else if (orderDetail.isSelling()) {
                                                                                                                        return new h(orderDetail);
                                                                                                                    } else {
                                                                                                                        return new com.shopee.app.d.b.a.a.e.h(orderDetail);
                                                                                                                    }
                                                                                                                } else if (orderDetail.isSelling()) {
                                                                                                                    return new com.shopee.app.d.b.a.b.e.i(orderDetail);
                                                                                                                } else {
                                                                                                                    return new com.shopee.app.d.b.a.a.e.i(orderDetail);
                                                                                                                }
                                                                                                            } else if (orderDetail.isSelling()) {
                                                                                                                return new l(orderDetail);
                                                                                                            } else {
                                                                                                                return new com.shopee.app.d.b.a.a.e.l(orderDetail);
                                                                                                            }
                                                                                                        } else if (orderDetail.isSelling()) {
                                                                                                            return new m(orderDetail);
                                                                                                        } else {
                                                                                                            return new com.shopee.app.d.b.a.a.e.m(orderDetail);
                                                                                                        }
                                                                                                    } else if (orderDetail.isSelling()) {
                                                                                                        return new n(orderDetail);
                                                                                                    } else {
                                                                                                        return new com.shopee.app.d.b.a.a.e.n(orderDetail);
                                                                                                    }
                                                                                                } else if (orderDetail.isSelling()) {
                                                                                                    return new o(orderDetail);
                                                                                                } else {
                                                                                                    return new com.shopee.app.d.b.a.a.e.o(orderDetail);
                                                                                                }
                                                                                            } else if (orderDetail.isSelling()) {
                                                                                                return new j(orderDetail);
                                                                                            } else {
                                                                                                return new com.shopee.app.d.b.a.a.e.j(orderDetail);
                                                                                            }
                                                                                        } else if (orderDetail.isSelling()) {
                                                                                            return new k(orderDetail);
                                                                                        } else {
                                                                                            return new com.shopee.app.d.b.a.a.e.k(orderDetail);
                                                                                        }
                                                                                    } else if (orderDetail.isSelling()) {
                                                                                        return new y(orderDetail);
                                                                                    } else {
                                                                                        return new com.shopee.app.d.b.a.a.e.y(orderDetail);
                                                                                    }
                                                                                } else if (orderDetail.isSelling()) {
                                                                                    return new z(orderDetail);
                                                                                } else {
                                                                                    return new com.shopee.app.d.b.a.a.e.z(orderDetail);
                                                                                }
                                                                            } else if (orderDetail.isSelling()) {
                                                                                return new q(orderDetail);
                                                                            } else {
                                                                                return new com.shopee.app.d.b.a.a.e.q(orderDetail);
                                                                            }
                                                                        } else if (orderDetail.isSelling()) {
                                                                            return new r(orderDetail);
                                                                        } else {
                                                                            return new com.shopee.app.d.b.a.a.e.r(orderDetail);
                                                                        }
                                                                    } else if (orderDetail.isSelling()) {
                                                                        return new ab(orderDetail);
                                                                    } else {
                                                                        return new aa(orderDetail);
                                                                    }
                                                                } else if (orderDetail.isSelling()) {
                                                                    return new ac(orderDetail);
                                                                } else {
                                                                    return new com.shopee.app.d.b.a.a.e.ab(orderDetail);
                                                                }
                                                            } else if (orderDetail.isSelling()) {
                                                                return new ad(orderDetail);
                                                            } else {
                                                                return new com.shopee.app.d.b.a.a.e.ac(orderDetail);
                                                            }
                                                        } else if (orderDetail.isSelling()) {
                                                            return new ae(orderDetail);
                                                        } else {
                                                            return new com.shopee.app.d.b.a.a.e.ad(orderDetail);
                                                        }
                                                    } else if (orderDetail.isSelling()) {
                                                        return new w(orderDetail);
                                                    } else {
                                                        return new com.shopee.app.d.b.a.a.e.w(orderDetail);
                                                    }
                                                } else if (orderDetail.isSelling()) {
                                                    return new x(orderDetail);
                                                } else {
                                                    return new com.shopee.app.d.b.a.a.e.x(orderDetail);
                                                }
                                            } else if (orderDetail.isSelling()) {
                                                return new u(orderDetail);
                                            } else {
                                                return new com.shopee.app.d.b.a.a.e.u(orderDetail);
                                            }
                                        } else if (orderDetail.isSelling()) {
                                            return new v(orderDetail);
                                        } else {
                                            return new com.shopee.app.d.b.a.a.e.v(orderDetail);
                                        }
                                    } else if (orderDetail.isSelling()) {
                                        return new s(orderDetail);
                                    } else {
                                        return new com.shopee.app.d.b.a.a.e.s(orderDetail);
                                    }
                                } else if (orderDetail.isSelling()) {
                                    return new t(orderDetail);
                                } else {
                                    return new com.shopee.app.d.b.a.a.e.t(orderDetail);
                                }
                            } else if (orderDetail.isSelling()) {
                                return new com.shopee.app.d.b.a.b.e.c(orderDetail);
                            } else {
                                return new com.shopee.app.d.b.a.a.e.c(orderDetail);
                            }
                        } else if (orderDetail.isSelling()) {
                            return new com.shopee.app.d.b.a.b.e.f(orderDetail);
                        } else {
                            return new com.shopee.app.d.b.a.a.e.f(orderDetail);
                        }
                    } else if (orderDetail.isSelling()) {
                        return new com.shopee.app.d.b.a.b.e.d(orderDetail);
                    } else {
                        return new com.shopee.app.d.b.a.a.e.d(orderDetail);
                    }
                } else if (orderDetail.isSelling()) {
                    return new com.shopee.app.d.b.a.b.e.e(orderDetail);
                } else {
                    return new com.shopee.app.d.b.a.a.e.e(orderDetail);
                }
            } else if (orderDetail.isSelling()) {
                return new p(orderDetail);
            } else {
                return new com.shopee.app.d.b.a.a.e.p(orderDetail);
            }
        } else if (orderDetail.isSelling()) {
            return new com.shopee.app.d.b.a.b.e.g(orderDetail);
        } else {
            return new com.shopee.app.d.b.a.a.e.g(orderDetail);
        }
    }

    private static com.shopee.app.d.b.a.a d(OrderDetail orderDetail) {
        if (!orderDetail.isEscrow() || !orderDetail.returnRequested()) {
            if (!orderDetail.noCODPaymentMethod() || !orderDetail.isSupported3PL() || !orderDetail.isEscrow() || !orderDetail.logisticsDeliveryDone() || orderDetail.isEscrowExtended()) {
                if (!orderDetail.noCODPaymentMethod() || !orderDetail.isSupported3PL() || !orderDetail.isEscrow() || !orderDetail.logisticsDeliveryDone() || !orderDetail.isEscrowExtended()) {
                    if (!orderDetail.noCODPaymentMethod() || !orderDetail.isSupported3PL() || !orderDetail.isEscrow() || orderDetail.isEscrowExtended()) {
                        if (!orderDetail.noCODPaymentMethod() || !orderDetail.isSupported3PL() || !orderDetail.isEscrow() || !orderDetail.isEscrowExtended()) {
                            if (!orderDetail.isCODPaymentMethod() || !orderDetail.logisticsPickupDone()) {
                                if (!orderDetail.isCODPaymentMethod() || !orderDetail.logisticsDeliveryDone()) {
                                    if (!orderDetail.noCODPaymentMethod() || !orderDetail.isNonSupported3PL() || !orderDetail.isEscrow() || orderDetail.isEscrowExtended() || orderDetail.isBuyerSelfCollect()) {
                                        if (!orderDetail.noCODPaymentMethod() || !orderDetail.isNonSupported3PL() || !orderDetail.isEscrow() || !orderDetail.isEscrowExtended() || orderDetail.isBuyerSelfCollect()) {
                                            if (!orderDetail.noCODPaymentMethod() || !orderDetail.isNonSupported3PL() || !orderDetail.isEscrow() || orderDetail.isEscrowExtended() || !orderDetail.isBuyerSelfCollect()) {
                                                if (!orderDetail.noCODPaymentMethod() || !orderDetail.isNonSupported3PL() || !orderDetail.isEscrow() || !orderDetail.isEscrowExtended() || !orderDetail.isBuyerSelfCollect()) {
                                                    if (orderDetail.isNoDeliveryTime() || !orderDetail.isSimple()) {
                                                        return g(orderDetail);
                                                    }
                                                    if (orderDetail.isSelling()) {
                                                        return new com.shopee.app.d.b.a.b.d.b(orderDetail);
                                                    }
                                                    return new com.shopee.app.d.b.a.a.d.b(orderDetail);
                                                } else if (orderDetail.isSelling()) {
                                                    return new com.shopee.app.d.b.a.b.d.f(orderDetail);
                                                } else {
                                                    return new com.shopee.app.d.b.a.a.d.f(orderDetail);
                                                }
                                            } else if (orderDetail.isSelling()) {
                                                return new com.shopee.app.d.b.a.b.d.i(orderDetail);
                                            } else {
                                                return new com.shopee.app.d.b.a.a.d.i(orderDetail);
                                            }
                                        } else if (orderDetail.isSelling()) {
                                            return new com.shopee.app.d.b.a.b.d.g(orderDetail);
                                        } else {
                                            return new com.shopee.app.d.b.a.a.d.g(orderDetail);
                                        }
                                    } else if (orderDetail.isSelling()) {
                                        return new com.shopee.app.d.b.a.b.d.h(orderDetail);
                                    } else {
                                        return new com.shopee.app.d.b.a.a.d.h(orderDetail);
                                    }
                                } else if (orderDetail.isSelling()) {
                                    return new com.shopee.app.d.b.a.b.d.d(orderDetail);
                                } else {
                                    return new com.shopee.app.d.b.a.a.d.d(orderDetail);
                                }
                            } else if (orderDetail.isSelling()) {
                                return new com.shopee.app.d.b.a.b.d.e(orderDetail);
                            } else {
                                return new com.shopee.app.d.b.a.a.d.e(orderDetail);
                            }
                        } else if (orderDetail.isSelling()) {
                            return new com.shopee.app.d.b.a.b.d.j(orderDetail);
                        } else {
                            return new com.shopee.app.d.b.a.a.d.j(orderDetail);
                        }
                    } else if (orderDetail.isSelling()) {
                        return new com.shopee.app.d.b.a.b.d.k(orderDetail);
                    } else {
                        return new com.shopee.app.d.b.a.a.d.k(orderDetail);
                    }
                } else if (orderDetail.isSelling()) {
                    return new com.shopee.app.d.b.a.b.d.l(orderDetail);
                } else {
                    return new com.shopee.app.d.b.a.a.d.l(orderDetail);
                }
            } else if (orderDetail.isSelling()) {
                return new com.shopee.app.d.b.a.b.d.m(orderDetail);
            } else {
                return new com.shopee.app.d.b.a.a.d.m(orderDetail);
            }
        } else if (orderDetail.isSelling()) {
            return new com.shopee.app.d.b.a.b.d.a(orderDetail);
        } else {
            return new com.shopee.app.d.b.a.a.d.a(orderDetail);
        }
    }

    private static com.shopee.app.d.b.a.a e(OrderDetail orderDetail) {
        if (ar.f().e().settingConfigStore().buyerRatingEnabled() || orderDetail.isRated()) {
            if (ar.f().e().settingConfigStore().buyerRatingEnabled() || !orderDetail.isRated()) {
                if (!ar.f().e().settingConfigStore().buyerRatingEnabled() || !orderDetail.noSellerRated() || !orderDetail.noBuyerRated() || !orderDetail.beforeRateByDate()) {
                    if (!ar.f().e().settingConfigStore().buyerRatingEnabled() || !orderDetail.noSellerRated() || !orderDetail.hasBuyerRated() || !orderDetail.beforeRateByDate()) {
                        if (!ar.f().e().settingConfigStore().buyerRatingEnabled() || !orderDetail.hasSellerRated() || !orderDetail.noBuyerRated() || !orderDetail.beforeRateByDate()) {
                            if (!ar.f().e().settingConfigStore().buyerRatingEnabled() || !orderDetail.hasSellerRated() || !orderDetail.hasBuyerRated()) {
                                if (!ar.f().e().settingConfigStore().buyerRatingEnabled() || !orderDetail.hasSellerRated() || !orderDetail.noBuyerRated() || !orderDetail.afterRateByDate()) {
                                    if (!ar.f().e().settingConfigStore().buyerRatingEnabled() || !orderDetail.noSellerRated() || !orderDetail.hasBuyerRated() || !orderDetail.afterRateByDate()) {
                                        if (!ar.f().e().settingConfigStore().buyerRatingEnabled() || !orderDetail.noSellerRated() || !orderDetail.noBuyerRated() || !orderDetail.afterRateByDate()) {
                                            return g(orderDetail);
                                        }
                                        if (orderDetail.isSelling()) {
                                            return new m(orderDetail);
                                        }
                                        return new b(orderDetail);
                                    } else if (orderDetail.isSelling()) {
                                        return new o(orderDetail);
                                    } else {
                                        return new d(orderDetail);
                                    }
                                } else if (orderDetail.isSelling()) {
                                    return new q(orderDetail);
                                } else {
                                    return new f(orderDetail);
                                }
                            } else if (orderDetail.isSelling()) {
                                return new r(orderDetail);
                            } else {
                                return new g(orderDetail);
                            }
                        } else if (orderDetail.isSelling()) {
                            return new p(orderDetail);
                        } else {
                            return new e(orderDetail);
                        }
                    } else if (orderDetail.isSelling()) {
                        return new n(orderDetail);
                    } else {
                        return new c(orderDetail);
                    }
                } else if (orderDetail.isSelling()) {
                    return new com.shopee.app.d.b.a.b.b.a(orderDetail);
                } else {
                    return new a(orderDetail);
                }
            } else if (orderDetail.isSelling()) {
                return new com.shopee.app.d.b.a.b.b.b(orderDetail);
            } else {
                return new com.shopee.app.d.b.a.a.b.a(orderDetail);
            }
        } else if (orderDetail.isSelling()) {
            return new com.shopee.app.d.b.a.b.b.c(orderDetail);
        } else {
            return new com.shopee.app.d.b.a.a.b.b(orderDetail);
        }
    }

    private static com.shopee.app.d.b.a.a f(OrderDetail orderDetail) {
        if (!orderDetail.isBackendCancelledUnderPaid() || !orderDetail.needBankAccount()) {
            if (orderDetail.isBackendCancelledUnPaid()) {
                if (orderDetail.isSelling()) {
                    return new com.shopee.app.d.b.a.b.a.i(orderDetail);
                }
                return new com.shopee.app.d.b.a.a.a.h(orderDetail);
            } else if (orderDetail.isBackendCancelledUnderPaid()) {
                if (orderDetail.isSelling()) {
                    return new com.shopee.app.d.b.a.b.a.g(orderDetail);
                }
                return new com.shopee.app.d.b.a.a.a.f(orderDetail);
            } else if (!orderDetail.isSellerCancelled() || !orderDetail.needBankAccount()) {
                if (orderDetail.isBackendCancelledPaymentRejected()) {
                    if (orderDetail.isSelling()) {
                        return new com.shopee.app.d.b.a.b.a.f(orderDetail);
                    }
                    return new com.shopee.app.d.b.a.a.a.e(orderDetail);
                } else if (orderDetail.isSellerCancelled()) {
                    if (orderDetail.isSelling()) {
                        return new com.shopee.app.d.b.a.b.a.c(orderDetail);
                    }
                    return new com.shopee.app.d.b.a.a.a.b(orderDetail);
                } else if (orderDetail.isCancelPending() && orderDetail.isSelling()) {
                    return new com.shopee.app.d.b.a.b.a.a(orderDetail);
                } else {
                    if (orderDetail.isBuyerCancelled()) {
                        if (orderDetail.isSelling()) {
                            return new com.shopee.app.d.b.a.b.a.b(orderDetail);
                        }
                        return new com.shopee.app.d.b.a.a.a.a(orderDetail);
                    } else if (!orderDetail.isCancelledPickupFailed() || !orderDetail.needBankAccount()) {
                        if (orderDetail.isCancelledPickupFailed()) {
                            if (orderDetail.isSelling()) {
                                return new com.shopee.app.d.b.a.b.a.n(orderDetail);
                            }
                            return new com.shopee.app.d.b.a.a.a.m(orderDetail);
                        } else if (!orderDetail.isCancelledDeliveryFailed() || !orderDetail.needBankAccount()) {
                            if (!orderDetail.isCODPaymentMethod() || !orderDetail.logisticsDeliveryFailed()) {
                                if (orderDetail.isCancelledDeliveryFailed()) {
                                    if (orderDetail.isSelling()) {
                                        return new com.shopee.app.d.b.a.b.a.k(orderDetail);
                                    }
                                    return new com.shopee.app.d.b.a.a.a.j(orderDetail);
                                } else if (orderDetail.isCancelledCODRejected()) {
                                    if (orderDetail.isSelling()) {
                                        return new com.shopee.app.d.b.a.b.a.j(orderDetail);
                                    }
                                    return new com.shopee.app.d.b.a.a.a.i(orderDetail);
                                } else if (!orderDetail.isBackendCancelled()) {
                                    return g(orderDetail);
                                } else {
                                    if (orderDetail.isSelling()) {
                                        return new com.shopee.app.d.b.a.b.a.e(orderDetail);
                                    }
                                    return new com.shopee.app.d.b.a.a.a.d(orderDetail);
                                }
                            } else if (orderDetail.isSelling()) {
                                return new com.shopee.app.d.b.a.b.a.m(orderDetail);
                            } else {
                                return new com.shopee.app.d.b.a.a.a.l(orderDetail);
                            }
                        } else if (orderDetail.isSelling()) {
                            return new com.shopee.app.d.b.a.b.a.l(orderDetail);
                        } else {
                            return new com.shopee.app.d.b.a.a.a.k(orderDetail);
                        }
                    } else if (orderDetail.isSelling()) {
                        return new com.shopee.app.d.b.a.b.a.o(orderDetail);
                    } else {
                        return new com.shopee.app.d.b.a.a.a.n(orderDetail);
                    }
                }
            } else if (orderDetail.isSelling()) {
                return new com.shopee.app.d.b.a.b.a.d(orderDetail);
            } else {
                return new com.shopee.app.d.b.a.a.a.c(orderDetail);
            }
        } else if (orderDetail.isSelling()) {
            return new com.shopee.app.d.b.a.b.a.h(orderDetail);
        } else {
            return new com.shopee.app.d.b.a.a.a.g(orderDetail);
        }
    }

    private static com.shopee.app.d.b.a.a g(OrderDetail orderDetail) {
        return new a(orderDetail) {
            /* access modifiers changed from: protected */
            public String r() {
                return com.shopee.app.util.i.f7040c + "buyer/orders/others/shopid/" + this.f16356c.getShopId() + "/orderid/" + this.f16356c.getOrderId() + Constants.URL_PATH_DELIMITER;
            }
        };
    }

    private static abstract class a extends com.shopee.app.d.b.a.a {

        /* renamed from: c  reason: collision with root package name */
        protected final OrderDetail f16356c;

        /* access modifiers changed from: protected */
        public abstract String r();

        public a(OrderDetail orderDetail) {
            super(orderDetail);
            this.f16356c = orderDetail;
        }

        public long a() {
            return this.f16356c.getOrderId();
        }

        public a.C0251a d() {
            return new a.C0251a(a((int) R.string.sp_check_details), 0, new View.OnClickListener() {
                public void onClick(View view) {
                    WebPageActivity_.a(view.getContext()).b(a.this.r()).a();
                }
            });
        }
    }
}
