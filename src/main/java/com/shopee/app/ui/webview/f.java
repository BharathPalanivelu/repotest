package com.shopee.app.ui.webview;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.afollestad.materialdialogs.f;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.widget.ShareDialog;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.google.a.i;
import com.google.a.l;
import com.google.a.o;
import com.google.a.p;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.ar;
import com.shopee.app.d.c.dl;
import com.shopee.app.d.c.du;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.WebDataStore;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.be;
import com.shopee.app.g.d;
import com.shopee.app.g.h;
import com.shopee.app.h.c.d;
import com.shopee.app.h.r;
import com.shopee.app.network.d.bb;
import com.shopee.app.network.d.bc;
import com.shopee.app.network.d.bn;
import com.shopee.app.react.modules.ui.product.a;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.auth.AuthTabActivity_;
import com.shopee.app.ui.common.a.c;
import com.shopee.app.ui.common.l;
import com.shopee.app.ui.common.passcode.PasscodeView;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.image.ImageBrowserActivity_;
import com.shopee.app.ui.image.MediaData;
import com.shopee.app.ui.image.j;
import com.shopee.app.ui.product.rating.RatingImageActivity_;
import com.shopee.app.ui.webview.WebPageActivity_;
import com.shopee.app.util.af;
import com.shopee.app.util.ak;
import com.shopee.app.util.aw;
import com.shopee.app.util.bi;
import com.shopee.app.util.c.b;
import com.shopee.app.util.n;
import com.shopee.app.util.y;
import com.shopee.app.web.MissingBankScamPopupMessage;
import com.shopee.app.web.WebEvent;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.bridge.WebBridge;
import com.shopee.app.web.bridge.modules.TraceUrls;
import com.shopee.app.web.protocol.AddCartMessage;
import com.shopee.app.web.protocol.CoinAnimationMessage;
import com.shopee.app.web.protocol.ConfigureButtonMessage;
import com.shopee.app.web.protocol.ConfigureNavBarMessage;
import com.shopee.app.web.protocol.ConfigurePageMessage;
import com.shopee.app.web.protocol.ConfigureRightDrawerMessage;
import com.shopee.app.web.protocol.CopyTextToClipboardMessage;
import com.shopee.app.web.protocol.DimActionBarMessage;
import com.shopee.app.web.protocol.DoCyberSourceProfileMessage;
import com.shopee.app.web.protocol.EditProductMessage;
import com.shopee.app.web.protocol.FullImageMessage;
import com.shopee.app.web.protocol.HasHandlerMessage;
import com.shopee.app.web.protocol.JumpMessage;
import com.shopee.app.web.protocol.LoadMessage;
import com.shopee.app.web.protocol.NavigateAppPath;
import com.shopee.app.web.protocol.NavigateMessage;
import com.shopee.app.web.protocol.OpenEmailComposer;
import com.shopee.app.web.protocol.OpenExternalLinkMessage;
import com.shopee.app.web.protocol.OpenRatingImagesMessage;
import com.shopee.app.web.protocol.OpenRouteMessage;
import com.shopee.app.web.protocol.OpenYoutubeVideoMessage;
import com.shopee.app.web.protocol.OrderChatMessage;
import com.shopee.app.web.protocol.PickImageMessage;
import com.shopee.app.web.protocol.PopWebViewMessage;
import com.shopee.app.web.protocol.PreloadMessage;
import com.shopee.app.web.protocol.RightItemMessage;
import com.shopee.app.web.protocol.SaveImageMessage;
import com.shopee.app.web.protocol.SaveMessage;
import com.shopee.app.web.protocol.SearchConfigMessage;
import com.shopee.app.web.protocol.ShareMessage;
import com.shopee.app.web.protocol.ShowCommentMessage;
import com.shopee.app.web.protocol.ShowDropDownMessage;
import com.shopee.app.web.protocol.ShowEditProductMessage;
import com.shopee.app.web.protocol.ShowMapMessage;
import com.shopee.app.web.protocol.ShowPinPopupMessage;
import com.shopee.app.web.protocol.ShowPopUpMessage;
import com.shopee.app.web.protocol.ShowToastMessage;
import com.shopee.app.web.protocol.ShowUserSearchMessage;
import com.shopee.app.web.protocol.StartChatMessage;
import com.shopee.app.web.protocol.StartTraceInfo;
import com.shopee.app.web.protocol.TrackBIEventMessage;
import com.shopee.app.web.protocol.TrackEventMessage;
import com.shopee.app.web.protocol.Variant;
import com.shopee.app.web.protocol.ViewOfferMessage;
import com.shopee.app.web.protocol.notification.LoginMessage;
import com.shopee.app.web.protocol.notification.ShowActionsMessage;
import com.shopee.app.web.protocol.notification.UpdateItemShippingMessage;
import com.shopee.app.web.protocol.notification.UserLocationChangeMessage;
import com.shopee.app.web2.WebPageActivity2_;
import com.shopee.id.R;
import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.ItemModel;
import com.shopee.web.sdk.bridge.protocol.configurepage.ConfigurePageRequest;
import com.tencent.imsdk.protocol.im_common;
import com.threatmetrix.TrustDefenderMobile.aa;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f extends q<g> {
    /* access modifiers changed from: private */
    public a A;
    private com.shopee.app.react.modules.app.FirebasePerf.a B;
    private boolean C = true;
    private e D = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((g) f.this.f19220b).setLogisticInfo((UpdateItemShippingMessage) aVar.data);
        }
    };
    private e E = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                NavigateAppPath navigateAppPath = (NavigateAppPath) aVar.data;
                f.this.x.a(navigateAppPath.getPath(), navigateAppPath.getParams());
                if (navigateAppPath.isPopSelf()) {
                    ((g) f.this.f19220b).getActivity().overridePendingTransition(0, 0);
                    ((g) f.this.f19220b).getActivity().finish();
                } else if (navigateAppPath.isTransparentPopup()) {
                    ((g) f.this.f19220b).setHasTransparentPopup(true);
                }
            }
        }
    };
    private e F = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                String unused = f.this.aM = ((WebEvent) aVar).callbackId;
                ((g) f.this.f19220b).H();
            }
        }
    };
    private e G = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                ((g) f.this.f19220b).a(((OpenExternalLinkMessage) aVar.data).getUrl(), ((WebEvent) aVar).callbackId);
            }
        }
    };
    private e H = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                WebEvent webEvent = (WebEvent) aVar;
                aa aaVar = new aa();
                aaVar.a(((DoCyberSourceProfileMessage) aVar.data).getSessionID());
                aaVar.a(((g) f.this.f19220b).getContext().getApplicationContext(), "k8vif92e", "h.online-metrix.net");
                aa.b bVar = aa.b.THM_OK;
            }
        }
    };
    private e I = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                WebEvent webEvent = (WebEvent) aVar;
                f.this.j.b();
                OpenYoutubeVideoMessage openYoutubeVideoMessage = (OpenYoutubeVideoMessage) aVar.data;
                if (openYoutubeVideoMessage.openExternalLink) {
                    f.this.h.r(openYoutubeVideoMessage.videoID);
                } else {
                    f.this.h.a(openYoutubeVideoMessage.videoID, f.this.t);
                }
                o oVar = new o();
                oVar.a("status", (Number) 1);
                ((g) f.this.f19220b).a(webEvent.callbackId, oVar);
            }
        }
    };
    private e J = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                ((g) f.this.f19220b).a((ConfigureRightDrawerMessage) aVar.data);
            }
        }
    };
    private e K = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                ((g) f.this.f19220b).L();
            }
        }
    };
    private e L = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                ((g) f.this.f19220b).q(((PopWebViewMessage) aVar.data).getData());
            }
        }
    };
    private e M = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                ((g) f.this.f19220b).a(((SearchConfigMessage) aVar.data).getSearchConfig());
            }
        }
    };
    private e N = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                ((g) f.this.f19220b).M();
            }
        }
    };
    private e O = new com.garena.android.appkit.b.f() {
        public void a(com.garena.android.appkit.b.a aVar) {
            com.shopee.app.util.g.a e2 = com.shopee.app.h.o.a().e(((d) aVar).b());
            if (e2 != null) {
                e2.a();
            }
        }
    };
    private e P = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                DimActionBarMessage dimActionBarMessage = (DimActionBarMessage) aVar.data;
                if (((g) f.this.f19220b).f25978d != null && (((g) f.this.f19220b).f25978d instanceof y)) {
                    y yVar = (y) ((g) f.this.f19220b).f25978d;
                    int i = 0;
                    if (dimActionBarMessage.isDim) {
                        try {
                            if (!dimActionBarMessage.color.startsWith("#")) {
                                dimActionBarMessage.color = "#" + dimActionBarMessage.color;
                            }
                            int parseColor = Color.parseColor(dimActionBarMessage.color);
                            i = Color.argb((int) (dimActionBarMessage.alpha * 255.0f), Color.red(parseColor), Color.green(parseColor), Color.blue(parseColor));
                        } catch (NumberFormatException unused) {
                        }
                    }
                    if (f.this.f19220b != null && ((g) f.this.f19220b).getParent() != null && yVar.b(-99281)) {
                        ((g) f.this.f19220b).getParent().requestDisallowInterceptTouchEvent(dimActionBarMessage.isDim);
                        yVar.a(dimActionBarMessage.isDim, i);
                    }
                }
            }
        }
    };
    private e Q = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                WebEvent webEvent = (WebEvent) aVar;
                GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
                int isGooglePlayServicesAvailable = instance.isGooglePlayServicesAvailable(((g) f.this.f19220b).getContext());
                if (isGooglePlayServicesAvailable != 0) {
                    if (instance.isUserResolvableError(isGooglePlayServicesAvailable)) {
                        instance.getErrorDialog(((g) f.this.f19220b).getActivity(), isGooglePlayServicesAvailable, 2404).show();
                    }
                    o oVar = new o();
                    oVar.a("status", (Number) 0);
                    ((g) f.this.f19220b).a(webEvent.callbackId, oVar);
                    return;
                }
                o oVar2 = new o();
                oVar2.a("status", (Number) 1);
                ((g) f.this.f19220b).a(webEvent.callbackId, oVar2);
            }
        }
    };
    private e R = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar) && f.this.k.m()) {
                final WebEvent webEvent = (WebEvent) aVar;
                com.shopee.app.ui.dialog.a.a(((g) f.this.f19220b).getContext(), (int) R.string.sp_warning_invisible_to_contact, (int) R.string.sp_label_may_be_later, (int) R.string.sp_label_yes, (a.C0318a) new a.C0318a() {
                    public void onPositive() {
                        f.this.k.n();
                        f.this.a(false, webEvent);
                    }

                    public void onNegative() {
                        f.this.k.n();
                        f.this.a(true, webEvent);
                    }
                });
            }
        }
    };
    private e S = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                ((g) f.this.f19220b).a((Dialog) com.shopee.app.ui.dialog.a.a(((g) f.this.f19220b).getContext(), ((MissingBankScamPopupMessage) aVar.data).getUrlQueryString()));
            }
        }
    };
    private e T = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                OpenRatingImagesMessage openRatingImagesMessage = (OpenRatingImagesMessage) aVar.data;
                RatingImageActivity_.a(((g) f.this.f19220b).getContext()).b(openRatingImagesMessage.getShopID()).a(openRatingImagesMessage.getItemID()).a(openRatingImagesMessage.getEventID()).a(openRatingImagesMessage.withCommentsOnly()).e(openRatingImagesMessage.getType()).d(openRatingImagesMessage.getImageIndex()).c(openRatingImagesMessage.getCommentIndex()).a(7222);
            }
        }
    };
    private e U = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                final WebEvent webEvent = (WebEvent) aVar;
                if (f.this.t.coinAnimationEnabled()) {
                    CoinAnimationMessage coinAnimationMessage = (CoinAnimationMessage) aVar.data;
                    new com.shopee.app.util.c.a(new b.a() {
                        public void a() {
                            o oVar = new o();
                            oVar.a("errorCode", (Number) 0);
                            ((g) f.this.f19220b).a(webEvent.callbackId, oVar);
                        }
                    }).a(((com.shopee.app.ui.a.b) ((g) f.this.f19220b).f25978d).x(), (long) coinAnimationMessage.getCurrentCoins(), (long) coinAnimationMessage.getCoinsToAdd(), f.this.l.coinMultiplier());
                }
            }
        }
    };
    private e V = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                PreloadMessage preloadMessage = (PreloadMessage) aVar.data;
                c.a(((g) f.this.f19220b).getActivity(), preloadMessage.getKey(), preloadMessage.getUrl());
            }
        }
    };
    private e W = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                ((g) f.this.f19220b).p(((ShowUserSearchMessage) aVar.data).getSearchStr());
            }
        }
    };
    private e X = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((g) f.this.f19220b).a((ShareMessage) aVar.data);
        }
    };
    private e Y = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((g) f.this.f19220b).i();
        }
    };
    private e Z = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((g) f.this.f19220b).a((c.b) aVar.data);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public boolean f25844a = false;
    private e aA = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((g) f.this.f19220b).m("edit");
        }
    };
    private e aB = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((g) f.this.f19220b).m("");
        }
    };
    private e aC = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (((g) f.this.f19220b).J()) {
                ((g) f.this.f19220b).m((String) aVar.data);
            }
        }
    };
    private e aD = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            String str;
            com.shopee.app.network.c.d.a aVar2 = (com.shopee.app.network.c.d.a) aVar.data;
            if (!TextUtils.isEmpty(aVar2.f17893b)) {
                str = aVar2.f17893b;
            } else if (aVar2.f17892a != -100) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
            } else {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
            }
            ((g) f.this.f19220b).a(str);
        }
    };
    private e aE = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((g) f.this.f19220b).r(com.garena.android.appkit.tools.b.e(R.string.sp_success_report_item));
        }
    };
    private e aF = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((g) f.this.f19220b).r(com.garena.android.appkit.tools.b.e(R.string.sp_success_report_user));
        }
    };
    private e aG = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            Pair pair = (Pair) aVar.data;
            if (((Boolean) pair.first).booleanValue()) {
                f.this.i();
            } else {
                f.this.b(((Boolean) pair.second).booleanValue());
            }
        }
    };
    private e aH = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                ((g) f.this.f19220b).a(((ShowEditProductMessage) aVar.data).getItemId());
            }
        }
    };
    private e aI = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            com.shopee.app.network.d.o oVar;
            if (f.this.a(aVar)) {
                EditProductMessage editProductMessage = (EditProductMessage) aVar.data;
                Item.Builder builder = new Item.Builder();
                builder.shopid(Integer.valueOf(editProductMessage.getShopId())).itemid(Long.valueOf(editProductMessage.getItemId())).stock(Integer.valueOf(editProductMessage.getStock()));
                List<Variant> variations = editProductMessage.getVariations();
                ArrayList arrayList = new ArrayList();
                if (!af.a(variations)) {
                    for (Variant next : variations) {
                        ItemModel.Builder builder2 = new ItemModel.Builder();
                        builder2.name(next.modelName).currency("IDR").price(Long.valueOf(next.modelPrice)).itemid(Long.valueOf(editProductMessage.getItemId())).modelid(Long.valueOf(next.modelID)).stock(Integer.valueOf(next.modelStock));
                        arrayList.add(builder2.build());
                    }
                }
                if (!af.a(arrayList)) {
                    oVar = new com.shopee.app.network.d.o(builder.build(), (List<ItemModel>) arrayList, ((g) f.this.f19220b).hashCode(), f.this.t.showProductWeight());
                } else {
                    oVar = new com.shopee.app.network.d.o(builder.build(), ((g) f.this.f19220b).hashCode(), f.this.t.showProductWeight());
                }
                oVar.h();
                oVar.g();
            }
        }
    };
    private e aJ = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ar.a aVar2 = (ar.a) aVar.data;
            String bn = f.this.aN;
            String unused = f.this.aN = null;
            o oVar = new o();
            com.google.a.q qVar = new com.google.a.q();
            try {
                oVar.a("thumb", aVar2.f16505b);
                oVar.a("image", aVar2.f16504a);
                oVar.a("thumbs", qVar.a(aVar2.f16506c.toString()));
                oVar.a("images", qVar.a(aVar2.f16507d.toString()));
                ((g) f.this.f19220b).a(bn, oVar);
            } catch (p e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
    };
    private e aK = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            com.shopee.app.ui.product.add.a aVar2 = (com.shopee.app.ui.product.add.a) aVar;
            if (aVar2.f23952e != null && String.valueOf(((g) f.this.f19220b).hashCode()).equals(Integer.toString(((com.shopee.app.network.d.o) aVar2.f23952e).d()))) {
                r.a().b((int) R.string.sp_item_edited);
                ((g) f.this.f19220b).onRefresh();
            }
        }
    };
    /* access modifiers changed from: private */
    public PickImageMessage aL = null;
    /* access modifiers changed from: private */
    public String aM = null;
    /* access modifiers changed from: private */
    public String aN = null;
    private String aO = null;
    /* access modifiers changed from: private */
    public String aP = null;
    /* access modifiers changed from: private */
    public String aQ = null;
    /* access modifiers changed from: private */
    public String aR = null;
    /* access modifiers changed from: private */
    public String aS = null;
    /* access modifiers changed from: private */
    public String aT = null;
    /* access modifiers changed from: private */
    public OpenEmailComposer aU = null;
    private e aV = new g() {
        /* JADX WARNING: Removed duplicated region for block: B:13:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x00c4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onEvent(com.garena.android.appkit.b.a r10) {
            /*
                r9 = this;
                com.shopee.app.ui.webview.f r0 = com.shopee.app.ui.webview.f.this
                boolean r0 = r0.a((com.garena.android.appkit.b.a) r10)
                if (r0 != 0) goto L_0x0009
                return
            L_0x0009:
                r0 = r10
                com.shopee.app.web.WebEvent r0 = (com.shopee.app.web.WebEvent) r0
                com.shopee.app.ui.webview.f r1 = com.shopee.app.ui.webview.f.this
                java.lang.String r0 = r0.callbackId
                java.lang.String unused = r1.aN = r0
                com.shopee.app.ui.webview.f r0 = com.shopee.app.ui.webview.f.this
                java.lang.Object r10 = r10.data
                com.shopee.app.web.protocol.PickImageMessage r10 = (com.shopee.app.web.protocol.PickImageMessage) r10
                com.shopee.app.web.protocol.PickImageMessage r10 = (com.shopee.app.web.protocol.PickImageMessage) r10
                com.shopee.app.web.protocol.PickImageMessage unused = r0.aL = r10
                com.shopee.app.ui.webview.f r10 = com.shopee.app.ui.webview.f.this
                com.shopee.app.web.protocol.PickImageMessage r10 = r10.aL
                boolean r10 = r10.needCrop()
                r0 = 0
                r1 = -1
                if (r10 == 0) goto L_0x0049
                com.shopee.app.ui.webview.f r2 = com.shopee.app.ui.webview.f.this
                com.shopee.app.web.protocol.PickImageMessage r2 = r2.aL
                double r2 = r2.getCropRatio()
                r4 = 4652007308841189376(0x408f400000000000, double:1000.0)
                double r2 = r2 * r4
                int r2 = (int) r2
                if (r2 <= 0) goto L_0x0047
                r1 = 1000(0x3e8, float:1.401E-42)
                r5 = r10
                r6 = r2
                r7 = 1000(0x3e8, float:1.401E-42)
                goto L_0x004c
            L_0x0047:
                r5 = 0
                goto L_0x004a
            L_0x0049:
                r5 = r10
            L_0x004a:
                r6 = -1
                r7 = -1
            L_0x004c:
                com.shopee.app.ui.webview.f r10 = com.shopee.app.ui.webview.f.this
                com.shopee.app.web.protocol.PickImageMessage r10 = r10.aL
                int r10 = r10.getType()
                r1 = 4
                r2 = 1
                if (r10 == r2) goto L_0x00c4
                r3 = 2
                if (r10 == r3) goto L_0x0092
                java.lang.CharSequence[] r10 = new java.lang.CharSequence[r3]
                r1 = 2131887685(0x7f120645, float:1.9409984E38)
                java.lang.String r1 = com.garena.android.appkit.tools.b.e(r1)
                r10[r0] = r1
                r0 = 2131888236(0x7f12086c, float:1.9411102E38)
                java.lang.String r0 = com.garena.android.appkit.tools.b.e(r0)
                r10[r2] = r0
                com.shopee.app.ui.webview.f r0 = com.shopee.app.ui.webview.f.this
                com.shopee.app.web.protocol.PickImageMessage r0 = r0.aL
                int r8 = r0.getMaxCount()
                com.shopee.app.ui.webview.f r0 = com.shopee.app.ui.webview.f.this
                java.lang.Object r0 = r0.f19220b
                com.shopee.app.ui.webview.g r0 = (com.shopee.app.ui.webview.g) r0
                android.content.Context r0 = r0.getContext()
                com.shopee.app.ui.webview.f$60$1 r1 = new com.shopee.app.ui.webview.f$60$1
                r3 = r1
                r4 = r9
                r3.<init>(r5, r6, r7, r8)
                com.shopee.app.ui.dialog.a.a((android.content.Context) r0, (java.lang.CharSequence[]) r10, (com.shopee.app.ui.dialog.a.c) r1)
                goto L_0x00f9
            L_0x0092:
                com.shopee.app.ui.webview.f r10 = com.shopee.app.ui.webview.f.this
                java.lang.Object r10 = r10.f19220b
                com.shopee.app.ui.webview.g r10 = (com.shopee.app.ui.webview.g) r10
                android.app.Activity r10 = r10.getActivity()
                com.shopee.app.ui.photo.PhotoProxyActivity_$a r10 = com.shopee.app.ui.photo.PhotoProxyActivity_.a(r10)
                com.shopee.app.ui.photo.PhotoProxyActivity_$a r10 = r10.d((boolean) r2)
                com.shopee.app.ui.photo.PhotoProxyActivity_$a r10 = r10.c((boolean) r5)
                com.shopee.app.ui.photo.PhotoProxyActivity_$a r10 = r10.d((int) r6)
                com.shopee.app.ui.photo.PhotoProxyActivity_$a r10 = r10.e((int) r7)
                com.shopee.app.ui.webview.f r0 = com.shopee.app.ui.webview.f.this
                com.shopee.app.web.protocol.PickImageMessage r0 = r0.aL
                int r0 = r0.getMaxCount()
                com.shopee.app.ui.photo.PhotoProxyActivity_$a r10 = r10.f((int) r0)
                r10.a((int) r1)
                goto L_0x00f9
            L_0x00c4:
                com.shopee.app.ui.webview.f r10 = com.shopee.app.ui.webview.f.this
                java.lang.Object r10 = r10.f19220b
                com.shopee.app.ui.webview.g r10 = (com.shopee.app.ui.webview.g) r10
                android.app.Activity r10 = r10.getActivity()
                com.shopee.app.ui.photo.PhotoProxyActivity_$a r10 = com.shopee.app.ui.photo.PhotoProxyActivity_.a(r10)
                com.shopee.app.ui.photo.PhotoProxyActivity_$a r10 = r10.a((boolean) r2)
                com.shopee.app.ui.photo.PhotoProxyActivity_$a r10 = r10.c((boolean) r5)
                com.shopee.app.ui.photo.PhotoProxyActivity_$a r10 = r10.f((boolean) r5)
                com.shopee.app.ui.photo.PhotoProxyActivity_$a r10 = r10.d((int) r6)
                com.shopee.app.ui.photo.PhotoProxyActivity_$a r10 = r10.e((int) r7)
                com.shopee.app.ui.webview.f r0 = com.shopee.app.ui.webview.f.this
                com.shopee.app.web.protocol.PickImageMessage r0 = r0.aL
                int r0 = r0.getMaxCount()
                com.shopee.app.ui.photo.PhotoProxyActivity_$a r10 = r10.f((int) r0)
                r10.a((int) r1)
            L_0x00f9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.webview.f.AnonymousClass60.onEvent(com.garena.android.appkit.b.a):void");
        }
    };
    private e aW = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                String str = ((WebEvent) aVar).callbackId;
                o oVar = new o();
                if (com.shopee.app.network.a.c(((g) f.this.f19220b).getContext())) {
                    oVar.a("networkType", (Number) 2);
                } else if (com.shopee.app.network.a.b(((g) f.this.f19220b).getContext())) {
                    oVar.a("networkType", (Number) 1);
                } else {
                    oVar.a("networkType", (Number) 0);
                }
                oVar.a("cellularType", com.shopee.app.network.a.e(((g) f.this.f19220b).getContext()));
                ((g) f.this.f19220b).a(str, oVar);
            }
        }
    };
    private e aX = new g() {
        @SuppressLint({"MissingPermission"})
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                String str = ((WebEvent) aVar).callbackId;
                o oVar = new o();
                oVar.a("deviceID", f.this.y.d());
                oVar.a("deviceFingerprint", f.this.y.g());
                try {
                    oVar.a("BCAXOWidgetDeviceID", ((TelephonyManager) com.shopee.app.application.ar.f().getSystemService("phone")).getDeviceId());
                } catch (Exception unused) {
                    oVar.a("BCAXOWidgetDeviceID", "");
                }
                ((g) f.this.f19220b).a(str, oVar);
            }
        }
    };
    private e aY = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                String str = ((WebEvent) aVar).callbackId;
                o oVar = new o();
                oVar.a(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, (Number) 297);
                oVar.a("appver", ((g) f.this.f19220b).getAppVer());
                ((g) f.this.f19220b).a(str, oVar);
            }
        }
    };
    private e aZ = new g() {
        public void onEvent(final com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                com.shopee.app.g.d.a(((g) f.this.f19220b).getActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 228, 0, R.string.msg_permission_location_map, R.string.sp_no_location_access, R.string.sp_to_allow_location_hint, new d.a() {
                    public void b() {
                    }

                    public void c() {
                    }

                    public void a() {
                        String str;
                        ShowMapMessage showMapMessage = (ShowMapMessage) aVar.data;
                        if (showMapMessage.getShopname().startsWith("@")) {
                            str = showMapMessage.getShopname().substring(1);
                        } else {
                            str = showMapMessage.getShopname();
                        }
                        f.this.h.a((float) showMapMessage.getLatitude(), (float) showMapMessage.getLongitude(), showMapMessage.getTitle(), str);
                    }
                });
            }
        }
    };
    private e aa = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((g) f.this.f19220b).a((String) aVar.data, 1, "", "");
        }
    };
    private e ab = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((g) f.this.f19220b).x();
        }
    };
    private e ac = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((g) f.this.f19220b).c("rating_image_load_more", (o) aVar.data);
        }
    };
    private e ad = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((g) f.this.f19220b).j();
        }
    };
    private e ae = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            int i;
            if (f.this.a(aVar)) {
                NavigateMessage navigateMessage = (NavigateMessage) aVar.data;
                if (!TextUtils.isEmpty(navigateMessage.getBackUrl())) {
                    boolean unused = f.this.a(navigateMessage.getBackUrl(), true);
                }
                String str = null;
                if (navigateMessage.getConfig() != null) {
                    str = navigateMessage.getConfig().toString();
                }
                String preloadKey = navigateMessage.getPreloadKey();
                boolean z = navigateMessage.getPresentModal() == 1;
                if (TextUtils.isEmpty(str)) {
                    a(navigateMessage, str, preloadKey, z);
                } else {
                    try {
                        i = ((ConfigurePageRequest.ConfigMessage) WebRegister.GSON.a(navigateMessage.getConfig(), ConfigurePageRequest.ConfigMessage.class)).getWebviewType();
                    } catch (Exception e2) {
                        com.garena.android.appkit.d.a.a(e2);
                        com.garena.b.a.a.b("WebPagePresenter", (Throwable) e2);
                        i = 0;
                    }
                    if (i == 0) {
                        a(navigateMessage, str, preloadKey, z);
                    } else {
                        WebPageActivity2_.a(((g) f.this.f19220b).getActivity()).a(navigateMessage.getNavbarStr()).b(navigateMessage.getUrl()).d(str).a(100);
                    }
                }
                boolean unused2 = f.this.z = true;
                if (z) {
                    ((g) f.this.f19220b).I();
                }
                if (navigateMessage.popSelf()) {
                    ((g) f.this.f19220b).getActivity().overridePendingTransition(0, 0);
                    ((g) f.this.f19220b).getActivity().finish();
                }
            }
        }

        private void a(NavigateMessage navigateMessage, String str, String str2, boolean z) {
            WebPageActivity_.a i = WebPageActivity_.a(((g) f.this.f19220b).getActivity()).a(navigateMessage.getNavbarStr()).b(navigateMessage.getUrl()).f(str).a(z).d(navigateMessage.getTabsStr()).e(navigateMessage.getTabRightButtonStr()).h(str2).b(navigateMessage.getPageType()).i(navigateMessage.getPopUpForBackButtonStr());
            if (!TextUtils.isEmpty(str)) {
                i.f(str);
            }
            i.a(100);
        }
    };
    private e af = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                FullImageMessage fullImageMessage = (FullImageMessage) aVar.data;
                if (af.a(fullImageMessage.getMediaList())) {
                    ArrayList arrayList = new ArrayList();
                    for (String newImageData : fullImageMessage.getImageUrls()) {
                        arrayList.add(MediaData.newImageData(newImageData));
                    }
                    j.f23021a = arrayList;
                }
                if (!af.a(fullImageMessage.getMediaList())) {
                    ArrayList arrayList2 = new ArrayList();
                    for (FullImageMessage.Media next : fullImageMessage.getMediaList()) {
                        if (next.isVideo()) {
                            arrayList2.add(MediaData.newVideoData(next.getImageUrl(), next.getMediaUrl(), 0, next.getCurTime()));
                        } else {
                            arrayList2.add(MediaData.newImageData(next.getImageUrl()));
                        }
                    }
                    j.f23021a = arrayList2;
                }
                ImageBrowserActivity_.a(((g) f.this.f19220b).getActivity()).b(fullImageMessage.getCurrentIndex()).a(7264);
            }
        }
    };
    private e ag = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((g) f.this.f19220b).o(((UserLocationChangeMessage) aVar.data).getFullAddress());
        }
    };
    private e ah = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                ShowCommentMessage showCommentMessage = (ShowCommentMessage) aVar.data;
                f.this.h.a(showCommentMessage.getItemId(), showCommentMessage.getShopId(), showCommentMessage.ratings);
            }
        }
    };
    private e ai = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                WebEvent webEvent = (WebEvent) aVar;
                LoginMessage loginMessage = (LoginMessage) aVar.data;
                if (f.this.f25845c.isLoggedIn()) {
                    o oVar = new o();
                    oVar.a("status", (Number) 1);
                    ((g) f.this.f19220b).a(webEvent.callbackId, oVar);
                } else if (!((g) f.this.f19220b).c()) {
                    com.shopee.app.react.g.a(loginMessage.getRedirectPath());
                    if (loginMessage.isHidingPopup()) {
                        AuthTabActivity_.a(((g) f.this.f19220b).getActivity()).b(loginMessage.getRedirectTab()).a();
                        return;
                    }
                    ((g) f.this.f19220b).a(com.shopee.app.ui.dialog.a.a(((g) f.this.f19220b).getContext(), (int) R.string.sp_login_msg_web_action, 0));
                }
            }
        }
    };
    private e aj = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                StartChatMessage startChatMessage = (StartChatMessage) aVar.data;
                f.this.f25846d.a(startChatMessage.getItemID());
                if (f.this.f25845c.isLoggedIn()) {
                    ((g) f.this.f19220b).a(startChatMessage.getItemID(), startChatMessage.getUserID(), startChatMessage.getShopID(), startChatMessage.getMessage());
                } else if (!((g) f.this.f19220b).c()) {
                    ((g) f.this.f19220b).a(com.shopee.app.ui.dialog.a.a(((g) f.this.f19220b).getContext(), (int) R.string.sp_login_msg_user_chat, 0));
                }
            }
        }
    };
    private e ak = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            WebEvent webEvent = new WebEvent();
            webEvent.data = aVar.data;
            webEvent.webPageViewId = String.valueOf(((g) f.this.f19220b).hashCode());
            f.this.o.a("startChat", (com.garena.android.appkit.b.a) webEvent);
            ((g) f.this.f19220b).e();
        }
    };
    private e al = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                f.this.A.a((AddCartMessage) aVar.data);
            }
        }
    };
    private e am = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                String unused = f.this.aS = ((WebEvent) aVar).callbackId;
                ShareMessage unused2 = f.this.q = (ShareMessage) aVar.data;
                ((g) f.this.f19220b).a(f.this.q, (h.b) new h.b() {
                    public void a(o oVar) {
                        if (oVar != null && f.this.aS != null) {
                            com.garena.android.appkit.d.a.b("OnShareCallback onReport shareId %s %s", f.this.aS, oVar.toString());
                            ((g) f.this.f19220b).a(f.this.aS, oVar);
                        }
                    }
                });
            }
        }
    };
    private e an = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((g) f.this.f19220b).r();
            f.this.A.c((AddCartMessage) aVar.data);
        }
    };
    private e ao = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((g) f.this.f19220b).r();
            ((g) f.this.f19220b).e();
            if (UserInfo.isLoggedIn(f.this.f25845c)) {
                ((g) f.this.f19220b).s();
            } else {
                ((g) f.this.f19220b).d();
            }
        }
    };
    private e ap = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((g) f.this.f19220b).z();
        }
    };
    private e aq = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            final Pair pair = (Pair) aVar.data;
            int intValue = ((Integer) pair.first).intValue();
            if (intValue == 0) {
                ((g) f.this.f19220b).m((String) pair.second);
            } else if (intValue == 1) {
                ((g) f.this.f19220b).t();
            } else if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue == 4) {
                        ((g) f.this.f19220b).m(((RightItemMessage) pair.second).getKey());
                    }
                } else if (((g) f.this.f19220b).c()) {
                } else {
                    if (f.this.f25845c.isLoggedIn()) {
                        ((g) f.this.f19220b).a(com.shopee.app.ui.dialog.a.a(((g) f.this.f19220b).getContext(), (int) R.string.sp_alert_report_product, (int) R.string.sp_label_cancel, (int) R.string.sp_label_ok, (a.b) new a.b() {
                            public void a() {
                            }

                            public void a(String str) {
                                RightItemMessage rightItemMessage = (RightItemMessage) pair.second;
                                new bb().a(rightItemMessage.getShopID(), rightItemMessage.getItemID(), str);
                            }
                        }));
                        return;
                    }
                    ((g) f.this.f19220b).a(com.shopee.app.ui.dialog.a.a(((g) f.this.f19220b).getContext(), (int) R.string.sp_login_msg_report, 0));
                }
            } else if (((g) f.this.f19220b).c()) {
            } else {
                if (f.this.f25845c.isLoggedIn()) {
                    ((g) f.this.f19220b).a(com.shopee.app.ui.dialog.a.a(((g) f.this.f19220b).getContext(), (int) R.string.sp_alert_report_user, (int) R.string.sp_label_cancel, (int) R.string.sp_label_ok, (a.b) new a.b() {
                        public void a() {
                        }

                        public void a(String str) {
                            new bc().a(((RightItemMessage) pair.second).getUserID(), str);
                        }
                    }));
                    return;
                }
                ((g) f.this.f19220b).a(com.shopee.app.ui.dialog.a.a(((g) f.this.f19220b).getContext(), (int) R.string.sp_login_msg_report, 0));
            }
        }
    };
    private e ar = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((g) f.this.f19220b).r();
            f.this.A.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };
    private e as = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                JumpMessage jumpMessage = (JumpMessage) aVar.data;
                if (jumpMessage.getPath().contains("addFriends?goHome=0")) {
                    ((g) f.this.f19220b).G();
                } else {
                    boolean unused = f.this.a(jumpMessage.getPath(), true);
                }
            }
        }
    };
    private e at = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                PopWebViewMessage popWebViewMessage = (PopWebViewMessage) aVar.data;
                ((g) f.this.f19220b).a(popWebViewMessage.getData(), popWebViewMessage.getCount());
            }
        }
    };
    private e au = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                String unused = f.this.aR = ((WebEvent) aVar).callbackId;
                com.shopee.app.g.d.a(((g) f.this.f19220b).getActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 228, 0, R.string.msg_permission_location_nearby, R.string.sp_no_location_access, R.string.sp_to_allow_location_hint, new d.a() {
                    public void a() {
                        f.this.e();
                    }

                    public void b() {
                        o oVar = new o();
                        oVar.a("status", (Number) 2);
                        oVar.a("latitude", (Number) 0);
                        oVar.a("longitude", (Number) 0);
                        ((g) f.this.f19220b).a(f.this.aR, oVar);
                    }

                    public void c() {
                        com.garena.android.appkit.f.f.a().a(new Runnable() {
                            public void run() {
                                if (androidx.core.content.b.b((Context) ((g) f.this.f19220b).getActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
                                    f.this.e();
                                    return;
                                }
                                o oVar = new o();
                                oVar.a("status", (Number) 2);
                                oVar.a("latitude", (Number) 0);
                                oVar.a("longitude", (Number) 0);
                                ((g) f.this.f19220b).a(f.this.aR, oVar);
                            }
                        }, 15000);
                    }
                });
            }
        }
    };
    private e av = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (!f.this.a(aVar)) {
            }
        }
    };
    private e aw = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                ViewOfferMessage viewOfferMessage = (ViewOfferMessage) aVar.data;
            }
        }
    };
    @Deprecated
    private e ax = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                TrackEventMessage trackEventMessage = (TrackEventMessage) aVar.data;
                if (!TextUtils.isEmpty(trackEventMessage.getValue())) {
                    f.this.f25846d.a(trackEventMessage.getName(), trackEventMessage.getValue());
                } else {
                    f.this.f25846d.a(trackEventMessage.getName(), trackEventMessage.getValueDict());
                }
            }
        }
    };
    private e ay = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                try {
                    String events = ((TrackBIEventMessage) aVar.data).getEvents();
                    if (!TextUtils.isEmpty(events)) {
                        i iVar = (i) WebRegister.GSON.a(events, i.class);
                        if (iVar != null && iVar.a() != 0) {
                            Iterator<l> it = iVar.iterator();
                            while (it.hasNext()) {
                                f.this.f25847e.d(WebRegister.GSON.a(it.next()));
                            }
                        }
                    }
                } catch (Exception e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
            }
        }
    };
    private e az = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((g) f.this.f19220b).m("");
        }
    };
    private e ba = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                WebEvent webEvent = (WebEvent) aVar;
                if (TextUtils.isEmpty(f.this.f25845c.getPhone())) {
                    ((g) f.this.f19220b).n(webEvent.callbackId);
                } else {
                    ((g) f.this.f19220b).e(webEvent.callbackId);
                }
            }
        }
    };
    private e bb = new g() {
        public void onEvent(final com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                ShowPopUpMessage showPopUpMessage = (ShowPopUpMessage) aVar.data;
                String title = showPopUpMessage.getTitle();
                String message = showPopUpMessage.getMessage();
                String okText = showPopUpMessage.getOkText();
                if (TextUtils.isEmpty(okText)) {
                    okText = ((g) f.this.f19220b).getContext().getString(R.string.sp_label_ok);
                }
                String str = okText;
                String cancelText = showPopUpMessage.getCancelText();
                if (!((g) f.this.f19220b).c()) {
                    Dialog b2 = com.shopee.app.ui.dialog.a.b(((g) f.this.f19220b).getContext(), title, message, str, cancelText, new a.C0318a() {
                        public void onPositive() {
                            f.this.a((WebEvent) aVar, 0);
                        }

                        public void onNegative() {
                            f.this.a((WebEvent) aVar, 1);
                        }
                    });
                    b2.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        public void onCancel(DialogInterface dialogInterface) {
                            f.this.a((WebEvent) aVar, 2);
                        }
                    });
                    ((g) f.this.f19220b).a(b2);
                }
            }
        }
    };
    private e bc = new g() {
        public void onEvent(final com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                com.shopee.app.g.d.a(((g) f.this.f19220b).getActivity(), new String[]{"android.permission.READ_CONTACTS"}, im_common.GRP_CONFERENCE, 0, 0, 0, 0, new d.a() {
                    public void b() {
                    }

                    public void c() {
                    }

                    public void a() {
                        String unused = f.this.aT = ((WebEvent) aVar).callbackId;
                        Intent intent = new Intent("android.intent.action.PICK", Uri.parse("content://contacts"));
                        intent.setType("vnd.android.cursor.dir/phone_v2");
                        ((g) f.this.f19220b).getActivity().startActivityForResult(intent, 3);
                    }
                });
            }
        }
    };
    private e bd = new g() {
        public void onEvent(final com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                ShowPinPopupMessage.Popup popUp = ((ShowPinPopupMessage) aVar.data).getPopUp();
                if (!((g) f.this.f19220b).c()) {
                    f.a c2 = new f.a(((g) f.this.f19220b).getActivity()).a((CharSequence) popUp.getTitle()).e((CharSequence) popUp.getCancelText()).c((CharSequence) popUp.getOkText());
                    RelativeLayout relativeLayout = (RelativeLayout) ((g) f.this.f19220b).getActivity().getLayoutInflater().inflate(R.layout.passcode_dialog_layout, (ViewGroup) null);
                    final PasscodeView passcodeView = (PasscodeView) relativeLayout.findViewById(R.id.edit_text);
                    passcodeView.a(popUp.getNumberOfDigits());
                    Button button = (Button) relativeLayout.findViewById(R.id.button);
                    if (popUp.getButton() == null) {
                        button.setVisibility(8);
                    } else {
                        final ShowPinPopupMessage.ButtonMessage button2 = popUp.getButton();
                        button.setText(button2.getTitle());
                        button.setTextColor(button2.getColor());
                        button.setTextSize(button2.getFontSize());
                        button.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                ((g) f.this.f19220b).m(button2.getEventID());
                            }
                        });
                    }
                    c2.a((View) relativeLayout, false);
                    c2.a((f.b) new f.b() {
                        public void onPositive(com.afollestad.materialdialogs.f fVar) {
                            super.onPositive(fVar);
                            fVar.dismiss();
                            f.this.a((WebEvent) aVar, 0, passcodeView.getPasscode());
                        }

                        public void onNegative(com.afollestad.materialdialogs.f fVar) {
                            super.onNegative(fVar);
                            fVar.dismiss();
                            f.this.a((WebEvent) aVar, 1);
                        }
                    });
                    c2.a((DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        public void onCancel(DialogInterface dialogInterface) {
                            f.this.a((WebEvent) aVar, 2);
                        }
                    });
                    com.afollestad.materialdialogs.f c3 = c2.c();
                    passcodeView.setDialog(c3);
                    ((g) f.this.f19220b).a((Dialog) c3);
                }
            }
        }
    };
    private e be = new g() {
        public void onEvent(final com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                ShowDropDownMessage showDropDownMessage = (ShowDropDownMessage) aVar.data;
                List<ShowDropDownMessage.DropDownItem> items = showDropDownMessage.getItems();
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (ShowDropDownMessage.DropDownItem next : items) {
                    l.a aVar2 = new l.a();
                    aVar2.f21297e = next.state;
                    aVar2.f21294b = next.title;
                    aVar2.f21295c = next.subTitle;
                    aVar2.f21296d = next.icon;
                    aVar2.f21293a = i;
                    arrayList.add(aVar2);
                    i++;
                }
                com.shopee.app.ui.common.l lVar = new com.shopee.app.ui.common.l(((g) f.this.f19220b).getContext());
                lVar.a((List<l.a>) arrayList);
                lVar.a((l.b) new l.b() {
                    public void a(l.a aVar) {
                        String str = ((WebEvent) aVar).callbackId;
                        o oVar = new o();
                        oVar.a("btnIndexTapped", (Number) Integer.valueOf(aVar.f21293a));
                        ((g) f.this.f19220b).a(str, oVar);
                    }
                });
                lVar.a((PopupWindow.OnDismissListener) new PopupWindow.OnDismissListener() {
                    public void onDismiss() {
                        String str = ((WebEvent) aVar).callbackId;
                        o oVar = new o();
                        oVar.a("btnIndexTapped", (Number) -1);
                        ((g) f.this.f19220b).a(str, oVar);
                    }
                });
                lVar.a((View) f.this.f19220b, showDropDownMessage.getxPosition(), showDropDownMessage.getyPosition());
            }
        }
    };
    private e bf = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                SaveMessage saveMessage = (SaveMessage) aVar.data;
                f.this.i.put(saveMessage.getKey(), saveMessage.getData(), saveMessage.getPersist() == 1);
                o oVar = new o();
                oVar.a("status", (Number) 1);
                ((g) f.this.f19220b).a(((WebEvent) aVar).callbackId, oVar);
            }
        }
    };
    private e bg = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                o oVar = new o();
                if (WebRegister.hasHandler(((HasHandlerMessage) aVar.data).getHandler())) {
                    oVar.a("status", (Number) 1);
                } else {
                    oVar.a("status", (Number) 0);
                }
                ((g) f.this.f19220b).a(((WebEvent) aVar).callbackId, oVar);
            }
        }
    };
    private e bh = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                o oVar = new o();
                if (f.this.a(((OpenRouteMessage) aVar.data).getRoute(), false)) {
                    oVar.a("status", (Number) 1);
                } else {
                    oVar.a("status", (Number) 0);
                }
                ((g) f.this.f19220b).a(((WebEvent) aVar).callbackId, oVar);
            }
        }
    };
    private e bi = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar) && ((g) f.this.f19220b).J()) {
                ConfigurePageMessage configurePageMessage = (ConfigurePageMessage) aVar.data;
                if (configurePageMessage.getConfig() != null) {
                    ((g) f.this.f19220b).g(configurePageMessage.getConfig().toString());
                }
                if (configurePageMessage.getNavbar() != null) {
                    ((g) f.this.f19220b).l(configurePageMessage.getNavbar().toString());
                }
            }
        }
    };
    private e bj = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                ConfigureNavBarMessage configureNavBarMessage = (ConfigureNavBarMessage) aVar.data;
                if (!TextUtils.isEmpty(configureNavBarMessage.getTitle())) {
                    ((g) f.this.f19220b).setTitle(configureNavBarMessage.getTitle());
                }
            }
        }
    };
    private e bk = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                ((ClipboardManager) com.shopee.app.application.ar.a().getSystemService("clipboard")).setText(((CopyTextToClipboardMessage) aVar.data).getText());
                r.a().b((int) R.string.sp_copy_text_done);
            }
        }
    };
    private e bl = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                ConfigureButtonMessage configureButtonMessage = (ConfigureButtonMessage) aVar.data;
                configureButtonMessage.setWebviewId(((g) f.this.f19220b).hashCode());
                ((g) f.this.f19220b).a(configureButtonMessage);
                f.this.o.a("FILTER", new com.garena.android.appkit.b.a(configureButtonMessage));
            }
        }
    };
    private e bm = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                r.a().a(((ShowToastMessage) aVar.data).getToast());
            }
        }
    };
    private e bn = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                OrderChatMessage orderChatMessage = (OrderChatMessage) aVar.data;
                if (f.this.f25845c.isLoggedIn()) {
                    o oVar = new o();
                    oVar.a("status", (Number) 1);
                    ((g) f.this.f19220b).a(((WebEvent) aVar).callbackId, oVar);
                    ((g) f.this.f19220b).a(orderChatMessage.getShopID(), orderChatMessage.getUserID(), orderChatMessage.getOrderID());
                } else if (!((g) f.this.f19220b).c()) {
                    ((g) f.this.f19220b).a(com.shopee.app.ui.dialog.a.a(((g) f.this.f19220b).getContext(), (int) R.string.sp_login_msg_make_offer, 0));
                }
            }
        }
    };
    private e bo = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                String str = f.this.i.get(((LoadMessage) aVar.data).getKey());
                o oVar = new o();
                oVar.a("data", str);
                ((g) f.this.f19220b).a(((WebEvent) aVar).callbackId, oVar);
            }
        }
    };
    private e bp = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                String unused = f.this.aP = ((WebEvent) aVar).callbackId;
                ShowActionsMessage showActionsMessage = (ShowActionsMessage) aVar.data;
                ((g) f.this.f19220b).a(showActionsMessage.getActionString(), showActionsMessage.getSheetTitle());
            }
        }
    };
    private e bq = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                String unused = f.this.aQ = ((WebEvent) aVar).callbackId;
                final SaveImageMessage saveImageMessage = (SaveImageMessage) aVar.data;
                SaveImageMessage unused2 = f.this.r = saveImageMessage;
                com.shopee.app.g.d.a(((g) f.this.f19220b).getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 512, 0, R.string.msg_permission_gallery, R.string.sp_no_storage_access, R.string.sp_to_allow_gallery_hint, new d.a() {
                    public void b() {
                    }

                    public void c() {
                    }

                    public void a() {
                        f.this.u.a(saveImageMessage.getImageUrl(), saveImageMessage.getFilename(), false);
                    }
                });
            }
        }
    };
    private e br = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (f.this.a(aVar)) {
                OpenEmailComposer unused = f.this.aU = (OpenEmailComposer) aVar.data;
                SaveImageMessage unused2 = f.this.r = new SaveImageMessage();
                f.this.r.setFilename(f.this.aU.getImageFilename());
                f.this.r.setImageUrl(f.this.aU.getImageUrl());
                com.shopee.app.g.d.a(((g) f.this.f19220b).getActivity(), new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 256, 0, R.string.msg_permission_gallery, R.string.sp_no_storage_access, R.string.sp_to_allow_gallery_hint, new d.a() {
                    public void b() {
                    }

                    public void c() {
                    }

                    public void a() {
                        f.this.u.a(f.this.r.getImageUrl(), f.this.r.getFilename(), true);
                    }
                });
            }
        }
    };
    private e bs = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((g) f.this.f19220b).F();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final UserInfo f25845c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final com.shopee.app.tracking.f f25846d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final com.shopee.app.tracking.a f25847e;

    /* renamed from: f  reason: collision with root package name */
    private final du f25848f;

    /* renamed from: g  reason: collision with root package name */
    private final WebBridge f25849g;
    /* access modifiers changed from: private */
    public ak h;
    /* access modifiers changed from: private */
    public final WebDataStore i;
    /* access modifiers changed from: private */
    public com.shopee.app.application.a.b j;
    /* access modifiers changed from: private */
    public final be k;
    /* access modifiers changed from: private */
    public final SettingConfigStore l;
    private final com.shopee.app.d.c.b m;
    private final al n;
    /* access modifiers changed from: private */
    public bi o;
    private final n p;
    /* access modifiers changed from: private */
    public ShareMessage q;
    /* access modifiers changed from: private */
    public SaveImageMessage r;
    private long s = 0;
    /* access modifiers changed from: private */
    public final SettingConfigStore t;
    /* access modifiers changed from: private */
    public final dl u;
    private final ar v;
    private final aw w;
    /* access modifiers changed from: private */
    public com.shopee.app.util.b x;
    /* access modifiers changed from: private */
    public final com.shopee.app.data.store.aa y;
    /* access modifiers changed from: private */
    public boolean z;

    public f(bi biVar, n nVar, com.shopee.app.tracking.f fVar, com.shopee.app.tracking.a aVar, ak akVar, com.shopee.app.data.store.aa aaVar, du duVar, UserInfo userInfo, WebDataStore webDataStore, SettingConfigStore settingConfigStore, al alVar, aw awVar, com.shopee.app.util.b bVar, dl dlVar, com.shopee.app.d.c.b bVar2, com.shopee.app.application.a.b bVar3, be beVar, ar arVar, SettingConfigStore settingConfigStore2, WebBridge webBridge, com.shopee.app.react.modules.ui.product.a aVar2, com.shopee.app.react.modules.app.FirebasePerf.a aVar3) {
        this.o = biVar;
        this.p = nVar;
        this.f25846d = fVar;
        this.f25847e = aVar;
        this.h = akVar;
        this.i = webDataStore;
        this.f25848f = duVar;
        this.t = settingConfigStore;
        this.f25845c = userInfo;
        this.n = alVar;
        this.w = awVar;
        this.u = dlVar;
        this.j = bVar3;
        this.k = beVar;
        this.l = settingConfigStore2;
        this.x = bVar;
        this.y = aaVar;
        this.m = bVar2;
        this.v = arVar;
        this.A = aVar2;
        this.f25849g = webBridge;
        this.B = aVar3;
    }

    public void a() {
        this.o.a("getLocation", this.au);
        this.p.a("rating_load_more", this.ac);
        this.p.a("ME_TAB_BADGE_UPDATE", this.ab);
        if (((g) this.f19220b).getActivity() instanceof com.shopee.app.ui.home.c) {
            this.o.a("preload", this.V);
        }
    }

    public void c() {
        ((g) this.f19220b).B();
        if (((g) this.f19220b).J()) {
            if (this.C) {
                String shouldStartTrace = TraceUrls.INSTANCE.shouldStartTrace(((g) this.f19220b).getCurrentUrl());
                if (!TextUtils.isEmpty(shouldStartTrace)) {
                    this.B.a(new StartTraceInfo(shouldStartTrace), true);
                }
                this.C = false;
            } else {
                if (!this.z) {
                    ((g) this.f19220b).A();
                }
                this.z = false;
            }
            ((g) this.f19220b).u();
        }
        ((g) this.f19220b).E();
        this.f25844a = true;
        this.o.a("navigate", this.ae);
        this.o.a("fullScreenImage", this.af);
        this.o.a("configureNavBarTitle", this.bj);
        this.o.a("startChat", this.aj);
        this.o.a("login", this.ai);
        this.o.a(ShareDialog.WEB_SHARE_DIALOG, this.am);
        this.o.a("showItemComments", this.ah);
        this.o.a("presentAddCart", this.al);
        this.o.a("jump", this.as);
        this.o.a("popWebView", this.at);
        this.o.a("viewOffer", this.aw);
        this.o.a("didPlaceNewOrder", this.av);
        this.o.a("trackEvent", this.ax);
        this.o.a("trackBIEvent", this.ay);
        this.o.a("showEditProduct", this.aH);
        this.o.a("editProduct", this.aI);
        this.o.a("pickImage", this.aV);
        this.o.a("getNetworkInfo", this.aW);
        this.o.a("showPopUp", this.bb);
        this.o.a("showDropdownMenu", this.be);
        this.o.a("showMapPage", this.aZ);
        this.o.a("checkVersion", this.aY);
        this.o.a("showVerifyPhone", this.ba);
        this.o.a("save", this.bf);
        this.o.a("load", this.bo);
        this.o.a("hasHandler", this.bg);
        this.o.a("canOpenRoute", this.bh);
        this.o.a("copyTextToClipboard", this.bk);
        this.o.a("configurePage", this.bi);
        this.o.a("configureButton", this.bl);
        this.o.a("showToast", this.bm);
        this.o.a("startOrderChat", this.bn);
        this.o.a("showActionSheet", this.bp);
        this.o.a("saveImage", this.bq);
        this.o.a("openEmailComposer", this.br);
        this.o.a("notifyDidUpdateUserAddress", this.ag);
        this.o.a("passDataItemShipping", this.D);
        this.o.a("showUserSearch", this.W);
        this.o.a("navigateAppPath", this.E);
        this.o.a("scanBarcode", this.F);
        this.o.a("openExternalLink", this.G);
        this.o.a("getAppInfo", this.aX);
        this.o.a("doCyberSourceProfile", this.H);
        this.o.a("openYoutubeVideo", this.I);
        this.o.a("configureRightDrawer", this.J);
        this.o.a("showRightDrawer", this.K);
        this.o.a("hideRightDrawer", this.L);
        this.o.a("configureSearch", this.M);
        this.o.a("didChangeWebviewHeight", this.N);
        this.o.a("showCoinCollectAnimation", this.U);
        this.o.a("showHideFromContactPopup", this.R);
        this.o.a("showMissingBankScamPopup", this.S);
        this.o.a("openRatingImages", this.T);
        this.o.a("dimNavbar", this.P);
        this.o.a("isMapAvailable", this.Q);
        this.o.a("showPinPopUp", this.bd);
        this.o.a("pickSystemContact", this.bc);
        this.f25849g.startListening();
        if (!(((g) this.f19220b).getActivity() instanceof com.shopee.app.ui.home.c)) {
            this.o.a("preload", this.V);
        }
        if (((g) this.f19220b).J()) {
            this.o.a("SEARCH_TAG_REMOVED", this.aa);
            this.o.a("CLICK", this.aq);
            this.o.a("ACTION_BAR_ACTION_BOX", this.ap);
            this.o.a("ACTION_BAR_CART", this.ao);
            this.o.a("FACEBOOK_SHARING_FB", this.X);
            this.o.a("ACTION_BAR_DONE", this.az);
            this.o.a("ACTION_BAR_EDIT", this.aA);
            this.o.a("ACTION_BAR_SKIP", this.aB);
            this.o.a("ACTION_BAR_GENERIC", this.aC);
            this.o.a("SEARCH", this.bs);
            this.o.a("PROCESSING_IMAGE_DONE", this.ad);
            this.o.a("PROCESSING_IMAGE", this.Y);
            this.o.a("ON_ADD_CART_ANIMATION", this.Z);
        }
        this.p.a("EDIT_ITEM_SUCCESS", this.aK);
        this.p.a("PICK_IMAGE_DATA", this.aJ);
        this.p.a("ADD_CART_ITEM_SUCCESS", this.an);
        this.p.a("ADD_CART_ITEM_FAIL", this.ar);
        this.p.a("REPORT_ITEM_FAIL", this.aD);
        this.p.a("REPORT_ITEM_SUCCESS", this.aE);
        this.p.a("REPORT_USER_FAIL", this.aD);
        this.p.a("REPORT_USER_SUCCESS", this.aF);
        this.p.a("WEB_IMAGE_SAVE", this.aG);
        this.p.a("BUY_NOW_SEND_OFFER", this.ak);
        this.p.a("SET_USER_INFO", this.O);
        com.shopee.app.util.h.a.a(((g) this.f19220b).getCurrentUrl());
    }

    public void d() {
        this.f25844a = false;
        ((g) this.f19220b).C();
        com.shopee.app.util.h.a.a((String) null);
        this.o.b("navigate", this.ae);
        this.o.b("fullScreenImage", this.af);
        this.o.b("configureNavBarTitle", this.bj);
        this.o.b("startChat", this.aj);
        this.o.b("login", this.ai);
        this.o.b(ShareDialog.WEB_SHARE_DIALOG, this.am);
        this.o.b("showItemComments", this.ah);
        this.o.b("presentAddCart", this.al);
        this.o.b("jump", this.as);
        this.o.b("popWebView", this.at);
        this.o.b("viewOffer", this.aw);
        this.o.b("trackEvent", this.ax);
        this.o.b("trackBIEvent", this.ay);
        this.o.b("didPlaceNewOrder", this.av);
        this.o.b("showEditProduct", this.aH);
        this.o.b("editProduct", this.aI);
        this.o.b("pickImage", this.aV);
        this.o.b("showPopUp", this.bb);
        this.o.b("showDropdownMenu", this.be);
        this.o.b("showMapPage", this.aZ);
        this.o.b("checkVersion", this.aY);
        this.o.b("showVerifyPhone", this.ba);
        this.o.b("save", this.bf);
        this.o.b("load", this.bo);
        this.o.b("canOpenRoute", this.bh);
        this.o.b("hasHandler", this.bg);
        this.o.b("configurePage", this.bi);
        this.o.b("copyTextToClipboard", this.bk);
        this.o.b("configureButton", this.bl);
        this.o.b("startOrderChat", this.bn);
        this.o.b("showActionSheet", this.bp);
        this.o.b("saveImage", this.bq);
        this.o.b("notifyDidUpdateUserAddress", this.ag);
        this.o.b("passDataItemShipping", this.D);
        this.o.b("openEmailComposer", this.br);
        this.o.b("showUserSearch", this.W);
        this.o.b("navigateAppPath", this.E);
        this.o.b("scanBarcode", this.F);
        this.o.b("openExternalLink", this.G);
        this.o.b("getAppInfo", this.aX);
        this.o.b("doCyberSourceProfile", this.H);
        this.o.b("openYoutubeVideo", this.I);
        this.o.b("configureRightDrawer", this.J);
        this.o.b("showRightDrawer", this.K);
        this.o.b("hideRightDrawer", this.L);
        this.o.b("configureSearch", this.M);
        this.o.b("didChangeWebviewHeight", this.N);
        this.o.b("showCoinCollectAnimation", this.U);
        this.o.b("showHideFromContactPopup", this.R);
        this.o.b("showMissingBankScamPopup", this.S);
        this.o.b("openRatingImages", this.T);
        this.o.b("dimNavbar", this.P);
        this.o.b("isMapAvailable", this.Q);
        this.o.b("showPinPopUp", this.bd);
        this.o.b("pickSystemContact", this.bc);
        this.f25849g.stopListening();
        if (!(((g) this.f19220b).getActivity() instanceof com.shopee.app.ui.home.c)) {
            this.o.b("preload", this.V);
        }
        this.o.b("CLICK", this.aq);
        this.o.b("ACTION_BAR_ACTION_BOX", this.ap);
        this.o.b("FACEBOOK_SHARING_FB", this.X);
        this.o.b("ACTION_BAR_DONE", this.az);
        this.o.b("ACTION_BAR_EDIT", this.aA);
        this.o.b("ACTION_BAR_SKIP", this.aB);
        this.o.b("ACTION_BAR_CART", this.ao);
        this.o.b("SEARCH", this.bs);
        this.o.b("ACTION_BAR_GENERIC", this.aC);
        this.o.b("PROCESSING_IMAGE_DONE", this.ad);
        this.o.b("PROCESSING_IMAGE", this.Y);
        this.o.b("ON_ADD_CART_ANIMATION", this.Z);
        this.o.b("SEARCH_TAG_REMOVED", this.aa);
        this.p.b("EDIT_ITEM_SUCCESS", this.aK);
        this.p.b("PICK_IMAGE_DATA", this.aJ);
        this.p.b("ADD_CART_ITEM_SUCCESS", this.an);
        this.p.b("ADD_CART_ITEM_FAIL", this.ar);
        this.p.b("REPORT_ITEM_FAIL", this.aD);
        this.p.b("REPORT_ITEM_SUCCESS", this.aE);
        this.p.b("REPORT_USER_FAIL", this.aD);
        this.p.b("REPORT_USER_SUCCESS", this.aF);
        this.p.b("WEB_IMAGE_SAVE", this.aG);
        this.p.b("BUY_NOW_SEND_OFFER", this.ak);
        this.p.b("SET_USER_INFO", this.O);
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, final WebEvent webEvent) {
        bn bnVar = new bn();
        com.shopee.app.h.o.a().a(bnVar.i().a(), (com.shopee.app.util.g.a) new com.shopee.app.util.g.a() {
            public void a() {
                o oVar = new o();
                oVar.a("status", (Number) 1);
                ((g) f.this.f19220b).a(webEvent.callbackId, oVar);
            }

            public void a(com.shopee.app.network.c.d.a aVar) {
                o oVar = new o();
                oVar.a("status", (Number) 1);
                ((g) f.this.f19220b).a(webEvent.callbackId, oVar);
            }
        });
        bnVar.a(z2);
    }

    public void b() {
        this.o.b("getLocation", this.au);
        this.p.b("ME_TAB_BADGE_UPDATE", this.ab);
        this.p.b("rating_load_more", this.ac);
        this.o.b("preload", this.V);
        this.B.a();
    }

    /* access modifiers changed from: private */
    public boolean a(com.garena.android.appkit.b.a aVar) {
        return (aVar instanceof WebEvent) && String.valueOf(((g) this.f19220b).hashCode()).equals(((WebEvent) aVar).webPageViewId);
    }

    public void a(g gVar) {
        super.a(gVar);
        this.A.a((com.shopee.app.react.modules.ui.product.e) gVar);
    }

    /* access modifiers changed from: private */
    public boolean a(String str, boolean z2) {
        if (this.w.a(str.contains("?") ? str.substring(0, str.indexOf("?")) : str)) {
            if (!z2) {
                return true;
            }
            ((g) this.f19220b).j(str);
        }
        return false;
    }

    public void e() {
        if (this.aR != null) {
            com.garena.c.a.i.a().a(false);
            com.garena.c.a.i.a().b(false);
            if (!com.garena.c.a.i.a().d()) {
                ((g) this.f19220b).c(this.f25844a);
            }
            com.garena.c.a.i.a().a((com.garena.c.a.j) new com.garena.c.a.j() {
                public void a(Location location) {
                    o oVar = new o();
                    oVar.a("status", (Number) 1);
                    oVar.a("latitude", (Number) Double.valueOf(location.getLatitude()));
                    oVar.a("longitude", (Number) Double.valueOf(location.getLongitude()));
                    ((g) f.this.f19220b).a(f.this.aR, oVar);
                }

                public void a(int i) {
                    com.shopee.app.react.modules.ui.location.a aVar = new com.shopee.app.react.modules.ui.location.a(i);
                    Location b2 = com.garena.c.a.i.a().b();
                    if (b2 == null) {
                        com.garena.android.appkit.d.a.a("no cache location..", new Object[0]);
                        ((g) f.this.f19220b).a(com.garena.android.appkit.tools.b.e(aVar.a()));
                        if (aVar.b() == 0 || aVar.b() == 2) {
                            o oVar = new o();
                            oVar.a("status", (Number) Integer.valueOf(aVar.b()));
                            oVar.a("latitude", (Number) 0);
                            oVar.a("longitude", (Number) 0);
                            ((g) f.this.f19220b).a(f.this.aR, oVar);
                        }
                    } else {
                        o oVar2 = new o();
                        oVar2.a("status", (Number) 1);
                        oVar2.a("latitude", (Number) Double.valueOf(b2.getLatitude()));
                        oVar2.a("longitude", (Number) Double.valueOf(b2.getLongitude()));
                        ((g) f.this.f19220b).a(f.this.aR, oVar2);
                    }
                    if (aVar.c()) {
                        com.garena.android.appkit.d.a.a("show location", new Object[0]);
                        ((g) f.this.f19220b).c(f.this.f25844a);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        if (this.aU != null) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("message/rfc822");
            intent.putExtra("android.intent.extra.SUBJECT", this.aU.getSubject());
            intent.putExtra("android.intent.extra.TEXT", this.aU.getBody());
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(com.shopee.app.h.l.b() + this.aU.getImageFilename())));
            ((g) this.f19220b).getActivity().startActivity(intent);
        }
    }

    public void a(List<String> list) {
        this.v.a(list, this.aL);
        this.aL = null;
    }

    /* access modifiers changed from: private */
    public void a(WebEvent webEvent, int i2, String str) {
        String str2 = webEvent.callbackId;
        o oVar = new o();
        oVar.a("buttonClicked", (Number) Integer.valueOf(i2));
        oVar.a(AppMeasurementSdk.ConditionalUserProperty.VALUE, str);
        ((g) this.f19220b).a(str2, oVar);
    }

    /* access modifiers changed from: private */
    public void a(WebEvent webEvent, int i2) {
        String str = webEvent.callbackId;
        o oVar = new o();
        oVar.a("buttonClicked", (Number) Integer.valueOf(i2));
        ((g) this.f19220b).a(str, oVar);
    }

    public void a(int i2) {
        if (i2 == 256) {
            this.u.a(this.r.getImageUrl(), this.r.getFilename(), true);
        } else if (i2 == 512) {
            this.u.a(this.r.getImageUrl(), this.r.getFilename(), false);
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        o oVar = new o();
        oVar.a("status", (Number) Integer.valueOf(z2 ? 1 : 0));
        ((g) this.f19220b).a(this.aQ, oVar);
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        String str = this.aP;
        this.aO = null;
        o oVar = new o();
        oVar.a("btnIndexTapped", (Number) Integer.valueOf(i2));
        ((g) this.f19220b).a(str, oVar);
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        String str2 = this.aM;
        this.aM = null;
        o oVar = new o();
        oVar.a("scannedText", str);
        ((g) this.f19220b).a(str2, oVar);
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        if (this.n.m()) {
            return this.t.isAggressiveCacheAllowed();
        }
        return this.n.l();
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.aR != null) {
            o oVar = new o();
            oVar.a("status", (Number) 2);
            oVar.a("latitude", (Number) 0);
            oVar.a("longitude", (Number) 0);
            ((g) this.f19220b).a(this.aR, oVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.z = z2;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, Intent intent) {
        if (i2 == -1) {
            ((g) this.f19220b).a(this.aT, new com.shopee.app.g.n(((g) this.f19220b).getActivity().getContentResolver(), intent.getData()).apply((Void) null));
            return;
        }
        o oVar = new o();
        oVar.a("status", (Number) 2);
        ((g) this.f19220b).a(this.aT, oVar);
    }

    public void h() {
        ((g) this.f19220b).i.b(this);
    }
}
