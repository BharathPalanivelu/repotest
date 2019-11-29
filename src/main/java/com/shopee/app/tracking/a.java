package com.shopee.app.tracking;

import android.text.TextUtils;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.share.internal.ShareConstants;
import com.google.a.i;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.util.af;
import com.shopee.shopeetracker.Injection;
import com.shopee.shopeetracker.bimodel.FormRowValidateError;
import com.shopee.shopeetracker.bimodel.TrackingClick;
import com.shopee.shopeetracker.bimodel.TrackingClickEvent;
import com.shopee.shopeetracker.bimodel.TrackingEvent;
import com.shopee.shopeetracker.bimodel.TrackingForm;
import com.shopee.shopeetracker.bimodel.TrackingFormEvent;
import com.shopee.shopeetracker.bimodel.TrackingPageState;
import com.shopee.shopeetracker.bimodel.TrackingPageStateEvent;
import com.shopee.shopeetracker.bimodel.TrackingRequest;
import com.shopee.shopeetracker.bimodel.TrackingRequestEvent;
import com.shopee.shopeetracker.model.AppUserAction;
import com.shopee.shopeetracker.model.RNUserAction;
import com.shopee.shopeetracker.model.UserActionV2;
import java.util.Collections;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private UserInfo f19147a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f19148b;

    /* renamed from: c  reason: collision with root package name */
    private aa f19149c;

    public a(SettingConfigStore settingConfigStore, UserInfo userInfo, aa aaVar) {
        this.f19148b = settingConfigStore.biEnabled();
        this.f19147a = userInfo;
        this.f19149c = aaVar;
    }

    public void a(String str) {
        if (this.f19148b) {
            o oVar = new o();
            oVar.a("screenName", str);
            oVar.a("timestamp", (Number) Integer.valueOf(com.garena.android.appkit.tools.a.a.a()));
            a("screenView", oVar);
        }
    }

    public void a(long j) {
        if (this.f19148b) {
            o oVar = new o();
            oVar.a("actionID", (Number) Long.valueOf(j));
            oVar.a("timestamp", (Number) Integer.valueOf(com.garena.android.appkit.tools.a.a.a()));
            a("tapNewActionRequired", oVar);
        }
    }

    public void a(String str, String str2) {
        if (this.f19148b) {
            o oVar = new o();
            oVar.a("screenName", str2);
            oVar.a("param", str);
            oVar.a("timestamp", (Number) Integer.valueOf(com.garena.android.appkit.tools.a.a.a()));
            a("openAppViaDeeplink", oVar);
        }
    }

    private void a(String str, o oVar) {
        o oVar2 = new o();
        oVar2.a("device_fingerprint", this.f19149c.g());
        oVar2.a("client_timestamp", (Number) Long.valueOf(com.garena.android.appkit.tools.a.a.b()));
        oVar2.a("app_version", com.shopee.app.react.modules.app.appmanager.a.b());
        AppUserAction.create().add("action", str).add("data", oVar.toString()).add("meta", oVar2.toString()).log();
    }

    public void a(int i, int i2, String str, int i3) {
        if (this.f19148b) {
            o oVar = new o();
            oVar.a("sender_id", (Number) Integer.valueOf(i));
            oVar.a("receiver_id", (Number) Integer.valueOf(i2));
            oVar.a("msg_content", str);
            oVar.a("time", (Number) Integer.valueOf(i3));
            a("ScamAlert", oVar);
        }
    }

    public void a(int i) {
        if (this.f19148b) {
            o oVar = new o();
            oVar.a("tab_index", (Number) Integer.valueOf(i));
            a("tabView", oVar);
        }
    }

    public void a() {
        if (this.f19148b) {
            o oVar = new o();
            oVar.a("no_data", "no_data");
            a("tabstay", oVar);
        }
    }

    public void b(String str) {
        if (this.f19148b) {
            o oVar = new o();
            oVar.a("keyword", str);
            oVar.a("timestamp", (Number) Integer.valueOf(com.garena.android.appkit.tools.a.a.a()));
            a("searchShop", oVar);
        }
    }

    public void a(int i, int i2) {
        if (this.f19148b) {
            o oVar = new o();
            oVar.a("shopid", (Number) Integer.valueOf(i));
            oVar.a(ViewProps.POSITION, (Number) Integer.valueOf(i2));
            oVar.a("timestamp", (Number) Integer.valueOf(com.garena.android.appkit.tools.a.a.a()));
            a("viewSearchedShop", oVar);
        }
    }

    public void a(long j, int i, int i2, boolean z, int i3) {
        if (this.f19148b) {
            o oVar = new o();
            oVar.a("actionid", (Number) Long.valueOf(j));
            oVar.a("noticode", (Number) Integer.valueOf(i));
            oVar.a("type", (Number) Integer.valueOf(i2));
            oVar.a("was_unead", Boolean.valueOf(z));
            oVar.a(ViewProps.POSITION, (Number) Integer.valueOf(i3));
            oVar.a("timestamp", (Number) Integer.valueOf(com.garena.android.appkit.tools.a.a.a()));
            a("tapNotification", oVar);
        }
    }

    public void b(int i) {
        if (this.f19148b) {
            o oVar = new o();
            oVar.a("tabIndex", (Number) Integer.valueOf(i));
            oVar.a("timestamp", (Number) Integer.valueOf(com.garena.android.appkit.tools.a.a.a()));
            a("viewMyPurchasesTab", oVar);
        }
    }

    public void a(List<SearchProductItem> list, SearchProductItem searchProductItem, int i) {
        if (this.f19148b) {
            i iVar = new i();
            if (!af.a(list)) {
                list = list.subList(1, list.size());
            }
            for (SearchProductItem a2 : list) {
                iVar.a((l) a(a2));
            }
            o oVar = new o();
            oVar.a("suggestion_list", (l) iVar);
            oVar.a("clicked_word", (l) a(searchProductItem));
            oVar.a("last_seen_position", (Number) Integer.valueOf(i));
            oVar.a("timestamp", (Number) Integer.valueOf(com.garena.android.appkit.tools.a.a.a()));
            a("autoCompleteImpressionClick", oVar);
        }
    }

    private o a(SearchProductItem searchProductItem) {
        String categoryName = TextUtils.isEmpty(searchProductItem.getCategoryName()) ? "" : searchProductItem.getCategoryName();
        o oVar = new o();
        oVar.a("keyword", searchProductItem.getKeyword());
        oVar.a("category_name", categoryName);
        oVar.a("is_history", Boolean.valueOf(searchProductItem.isFromHistory()));
        return oVar;
    }

    public void c(int i) {
        if (this.f19148b) {
            o oVar = new o();
            oVar.a("from", (Number) Integer.valueOf(i));
            oVar.a("timestamp", (Number) Integer.valueOf(com.garena.android.appkit.tools.a.a.a()));
            a("sellFrom", oVar);
        }
    }

    public void a(String str, String str2, String str3) {
        if (this.f19148b && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            int f2 = f(str);
            if (f2 != -1) {
                o oVar = new o();
                oVar.a("button", (Number) Integer.valueOf(f2));
                oVar.a("url", str2);
                if (str2 != null) {
                    str3 = null;
                }
                oVar.a("screen_name", str3);
                oVar.a("timestamp", (Number) Integer.valueOf(com.garena.android.appkit.tools.a.a.a()));
                a("navMenuClick", oVar);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int f(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = r7.hashCode()
            r1 = 0
            r2 = -1
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case 3015911: goto L_0x002b;
                case 3208415: goto L_0x0021;
                case 3357525: goto L_0x0017;
                case 109400031: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0035
        L_0x000d:
            java.lang.String r0 = "share"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0035
            r7 = 2
            goto L_0x0036
        L_0x0017:
            java.lang.String r0 = "more"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0035
            r7 = 0
            goto L_0x0036
        L_0x0021:
            java.lang.String r0 = "home"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0035
            r7 = 1
            goto L_0x0036
        L_0x002b:
            java.lang.String r0 = "back"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0035
            r7 = 3
            goto L_0x0036
        L_0x0035:
            r7 = -1
        L_0x0036:
            if (r7 == 0) goto L_0x0042
            if (r7 == r5) goto L_0x0041
            if (r7 == r4) goto L_0x0040
            if (r7 == r3) goto L_0x003f
            return r2
        L_0x003f:
            return r3
        L_0x0040:
            return r4
        L_0x0041:
            return r5
        L_0x0042:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.tracking.a.f(java.lang.String):int");
    }

    public void b() {
        if (this.f19148b) {
            o oVar = new o();
            oVar.a("deviceid", ar.f().e().deviceStore().d());
            oVar.a("timestamp", (Number) Integer.valueOf(com.garena.android.appkit.tools.a.a.a()));
            a("nonGooglePlayServiceAppOpen", oVar);
            org.a.a.a.a((Runnable) new Runnable() {
                public void run() {
                    Injection.provideEventSender().loadAndSendEvents(0);
                }
            }, 1000);
        }
    }

    public void a(int i, int i2, boolean z) {
        if (this.f19148b) {
            o oVar = new o();
            oVar.a("userid", (Number) Integer.valueOf(i));
            oVar.a("filter", (Number) Integer.valueOf(i2));
            oVar.a("sorting", z ? "asc" : "desc");
            oVar.a("timestamp", (Number) Integer.valueOf(com.garena.android.appkit.tools.a.a.a()));
            a("orderListFilterClick", oVar);
        }
    }

    public void c(String str) {
        if (this.f19148b) {
            RNUserAction.create(str).log();
        }
    }

    public void d(String str) {
        if (this.f19148b) {
            UserActionV2.create(str).log();
        }
    }

    public void a(TrackingEvent trackingEvent) {
        if (this.f19148b) {
            UserActionV2.create(trackingEvent).log();
        }
    }

    public void a(String str, String str2, boolean z, String str3) {
        if (this.f19148b) {
            TrackingPageState trackingPageState = new TrackingPageState();
            trackingPageState.id = str;
            trackingPageState.pageType = str2;
            trackingPageState.initial = z;
            trackingPageState.isBack = !z;
            trackingPageState.pageParams = str3;
            TrackingPageStateEvent trackingPageStateEvent = new TrackingPageStateEvent();
            trackingPageStateEvent.pageState = trackingPageState;
            trackingPageStateEvent.pageId = str;
            a((TrackingEvent) trackingPageStateEvent);
        }
    }

    public void b(String str, String str2, String str3) {
        if (this.f19148b) {
            TrackingClickEvent trackingClickEvent = new TrackingClickEvent();
            TrackingClick trackingClick = new TrackingClick();
            trackingClick.targetType = str2;
            trackingClick.targetData = str3;
            trackingClickEvent.click = trackingClick;
            trackingClickEvent.pageId = str;
            a((TrackingEvent) trackingClickEvent);
        }
    }

    public void a(String str, ReturnItem returnItem) {
        if (this.f19148b) {
            o oVar = new o();
            oVar.a("status", (Number) Integer.valueOf(returnItem.getStatus()));
            oVar.a("isSelling", Boolean.valueOf(returnItem.isSelling()));
            oVar.a("userId", (Number) Integer.valueOf(returnItem.getUserId()));
            oVar.a("returnId", (Number) Long.valueOf(returnItem.getReturnId()));
            oVar.a("sellerId", (Number) Integer.valueOf(returnItem.getSellerId()));
            TrackingClickEvent trackingClickEvent = new TrackingClickEvent();
            TrackingClick trackingClick = new TrackingClick();
            trackingClick.targetType = "returnListItemClick";
            trackingClick.targetData = oVar.toString();
            trackingClickEvent.click = trackingClick;
            trackingClickEvent.pageId = str;
            a((TrackingEvent) trackingClickEvent);
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        if (this.f19148b) {
            TrackingForm trackingForm = new TrackingForm();
            trackingForm.targetType = str2;
            FormRowValidateError formRowValidateError = new FormRowValidateError();
            formRowValidateError.field = str3;
            formRowValidateError.error = str4;
            trackingForm.error = Collections.singletonList(formRowValidateError);
            TrackingFormEvent trackingFormEvent = new TrackingFormEvent();
            trackingFormEvent.form = trackingForm;
            trackingFormEvent.pageId = str;
            a((TrackingEvent) trackingFormEvent);
        }
    }

    public void a(String str, String str2, List<FormRowValidateError> list) {
        if (this.f19148b) {
            TrackingForm trackingForm = new TrackingForm();
            trackingForm.targetType = str2;
            trackingForm.error = list;
            TrackingFormEvent trackingFormEvent = new TrackingFormEvent();
            trackingFormEvent.form = trackingForm;
            trackingFormEvent.pageId = str;
            a((TrackingEvent) trackingFormEvent);
        }
    }

    public void a(String str, int i, String str2, Integer num, String str3) {
        if (this.f19148b) {
            a(str, String.valueOf(i), str2, num, str3);
        }
    }

    public void a(String str, String str2, String str3, Integer num, String str4) {
        if (this.f19148b) {
            TrackingRequest trackingRequest = new TrackingRequest();
            trackingRequest.requestTarget = str2;
            trackingRequest.targetType = str3;
            trackingRequest.error = num;
            trackingRequest.errorMsg = str4;
            TrackingRequestEvent trackingRequestEvent = new TrackingRequestEvent();
            trackingRequestEvent.request = trackingRequest;
            trackingRequestEvent.pageId = str;
            a((TrackingEvent) trackingRequestEvent);
        }
    }

    public void c() {
        if (this.f19148b) {
            o oVar = new o();
            oVar.a("deviceid", ar.f().e().deviceStore().d());
            oVar.a("timestamp", (Number) Integer.valueOf(com.garena.android.appkit.tools.a.a.a()));
            a("clickSignUpButton", oVar);
        }
    }

    public void e(String str) {
        if (this.f19148b) {
            o oVar = new o();
            String d2 = ar.f().e().deviceStore().d();
            oVar.a("screenName", str);
            oVar.a("deviceid", d2);
            oVar.a("timestamp", (Number) Integer.valueOf(com.garena.android.appkit.tools.a.a.a()));
            a("clickSignUpContinue", oVar);
        }
    }

    public void b(String str, String str2) {
        if (this.f19148b) {
            o oVar = new o();
            String d2 = ar.f().e().deviceStore().d();
            oVar.a("mode", str2);
            oVar.a("screenName", str);
            oVar.a("deviceid", d2);
            oVar.a("timestamp", (Number) Integer.valueOf(com.garena.android.appkit.tools.a.a.a()));
            a("clickFinalSignUp", oVar);
        }
    }

    public void a(int i, int i2, String str, String str2) {
        if (this.f19148b) {
            o oVar = new o();
            oVar.a(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, (Number) Integer.valueOf(i));
            oVar.a("userid", (Number) Integer.valueOf(this.f19147a.getUserId()));
            oVar.a("cat_name", str);
            oVar.a("tab_index", (Number) Integer.valueOf(i2));
            oVar.a("timestamp", (Number) Integer.valueOf(com.garena.android.appkit.tools.a.a.a()));
            oVar.a("screen", str2);
            a("officialShopPageTabClick", oVar);
        }
    }

    public void c(String str, String str2, String str3) {
        if (this.f19148b) {
            o oVar = new o();
            oVar.a("userid", (Number) Integer.valueOf(this.f19147a.getUserId()));
            oVar.a("tab_name", str);
            oVar.a("timestamp", (Number) Integer.valueOf(com.garena.android.appkit.tools.a.a.a()));
            oVar.a("section_type", str2);
            oVar.a("target_name", str3);
            a("trackMePageButtonClick", oVar);
        }
    }

    public void a(long j, long j2) {
        if (this.f19148b) {
            o oVar = new o();
            oVar.a("shop_id", (Number) Long.valueOf(j));
            oVar.a("product_id", (Number) Long.valueOf(j2));
            oVar.a("view", (Number) 0);
            a("update_wrong_category_edit", oVar);
        }
    }

    public void b(long j, long j2) {
        if (this.f19148b) {
            o oVar = new o();
            oVar.a("shop_id", (Number) Long.valueOf(j));
            oVar.a("product_id", (Number) Long.valueOf(j2));
            a("floating_banner_impression", oVar);
        }
    }
}
