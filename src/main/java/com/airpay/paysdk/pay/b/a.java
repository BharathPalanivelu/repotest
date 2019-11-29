package com.airpay.paysdk.pay.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.b.d;
import com.airpay.paysdk.base.bean.BPCheckoutInfo;
import com.airpay.paysdk.base.bean.BPEvent;
import com.airpay.paysdk.base.bean.BPOrderInfo;
import com.airpay.paysdk.base.bean.BPThirdPartyOrderDetail;
import com.airpay.paysdk.base.bean.BPThirdPartyStoreInfo;
import com.airpay.paysdk.base.d.h;
import com.airpay.paysdk.c;
import com.airpay.paysdk.qrcode.model.BPChannelDisplayInfo;
import com.airpay.paysdk.result.bean.BPShowTicketOrderDetail;
import com.airpay.paysdk.result.bean.BillRef;
import com.airpay.paysdk.result.bean.BillerConfig;
import com.airpay.paysdk.result.bean.b;
import com.facebook.common.util.UriUtil;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public static JSONObject i(String str) {
        return null;
    }

    public static JSONObject a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String a(String str, String str2) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return str2;
        }
        try {
            return a2.getJSONObject("payment").getString("account_id_original");
        } catch (JSONException unused) {
            return str2;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("payment").getJSONObject(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            if (jSONObject.getInt("type") != 1) {
                return null;
            }
            return jSONObject.getString(UriUtil.LOCAL_CONTENT_SCHEME);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static BPThirdPartyOrderDetail c(String str) {
        BPThirdPartyStoreInfo bPThirdPartyStoreInfo;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("extra_data");
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("store");
                bPThirdPartyStoreInfo = optJSONObject2 != null ? new BPThirdPartyStoreInfo(optJSONObject2.optString("store_id"), optJSONObject2.optString("store_type"), optJSONObject2.optString("store_name"), optJSONObject2.optString("store_memo"), optJSONObject2.optString("store_address"), optJSONObject2.optString("chain_store_id")) : null;
                str2 = optJSONObject.optString("transfer_purpose");
            } else {
                str2 = null;
                bPThirdPartyStoreInfo = null;
            }
            return new BPThirdPartyOrderDetail.Builder().app_id(jSONObject.getInt("app_id")).order_id(jSONObject.optString(BPOrderInfo.FIELD_ORDER_ID)).currency(jSONObject.optString("currency", com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_currency_name))).expiry_time(jSONObject.getInt("expiry_time")).payable_amount(jSONObject.optLong("payable_amount", -1)).item_name(jSONObject.getString("item_name")).image_url(jSONObject.optString("item_image")).channel_txn_key(jSONObject.optString("channel_txn_key")).rebate_desc(jSONObject.optString("cash_rebate_desc")).account_id(jSONObject.optString("account_id")).item_id(jSONObject.optString("item_id")).item_amount(jSONObject.optInt("item_amount", 1)).transfer_purpose(str2).raw_data(str).store(bPThirdPartyStoreInfo).build();
        } catch (JSONException e2) {
            com.airpay.paysdk.common.b.a.a((Throwable) e2);
            return null;
        }
    }

    public static BPShowTicketOrderDetail d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("payment").getJSONObject("show_ticket");
            return new BPShowTicketOrderDetail(jSONObject.getInt("status"), jSONObject.getInt("booking_id"), jSONObject.getInt("show_id"), jSONObject.getInt("location_id"));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static com.airpay.paysdk.result.bean.c e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("payment");
            int i = jSONObject.getInt("booking_id");
            JSONObject jSONObject2 = jSONObject.getJSONObject("order_details");
            return new com.airpay.paysdk.result.bean.c(jSONObject2.getInt("app_id"), i, jSONObject2.getString(BPOrderInfo.FIELD_ORDER_ID));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static BPThirdPartyOrderDetail f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("payment") || !jSONObject.getJSONObject("payment").has("order_details")) {
                return null;
            }
            String string = jSONObject.getJSONObject("payment").getString("order_details");
            if (string == null) {
                return null;
            }
            return c(string);
        } catch (JSONException e2) {
            com.airpay.paysdk.common.b.a.a((Throwable) e2);
            return null;
        }
    }

    public static String g(String str) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return "000";
        }
        try {
            return a2.getString("req_card_type");
        } catch (JSONException e2) {
            com.airpay.paysdk.common.b.a.a((Throwable) e2);
            return "000";
        }
    }

    public static String h(String str) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return null;
        }
        try {
            if (!a2.has("topup")) {
                return null;
            }
            return a2.getJSONObject("topup").getString("cash_refund");
        } catch (JSONException unused) {
            return null;
        }
    }

    public static int j(String str) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return 0;
        }
        try {
            if (!a2.has("payment")) {
                return 0;
            }
            JSONObject jSONObject = a2.getJSONObject("payment");
            if (!jSONObject.has("action")) {
                return 0;
            }
            return jSONObject.getInt("action");
        } catch (JSONException unused) {
            return 0;
        }
    }

    public static String k(String str) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return null;
        }
        try {
            return c(a2.getJSONObject("fail_reason"));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static int l(String str) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return 1;
        }
        try {
            return a2.getInt(AbTestingModule.KEY_RESULT);
        } catch (JSONException unused) {
            return 1;
        }
    }

    public static BPChannelDisplayInfo b(String str, String str2) {
        JSONObject a2 = a(str2);
        if (a2 == null) {
            return null;
        }
        try {
            JSONObject jSONObject = a2.getJSONObject(str);
            return new BPChannelDisplayInfo(jSONObject.optString("txt_desc", (String) null), jSONObject.optString("txt_title", (String) null), jSONObject.optString("url_instr", (String) null), jSONObject.optString("img_icon", (String) null), jSONObject.optString("img_card", (String) null), jSONObject.optString("txt_title_short", (String) null));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static b m(String str) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return null;
        }
        try {
            JSONObject jSONObject = a2.getJSONObject("payment").getJSONObject("item_details");
            return new b(jSONObject.getString("fv"), jSONObject.getString("fvc"));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String a(Context context, BPEvent bPEvent, String str) {
        if (bPEvent == null) {
            return null;
        }
        JSONObject a2 = a(bPEvent.getMessage());
        if (a2 == null) {
            return null;
        }
        try {
            return a2.getJSONObject(com.airpay.paysdk.pay.b.a()).getString(str);
        } catch (JSONException e2) {
            com.airpay.paysdk.common.b.a.a((Throwable) e2);
            return null;
        }
    }

    public static d<String> n(String str) {
        d<String> dVar = new d<>();
        JSONObject a2 = a(str);
        if (a2 == null) {
            return dVar;
        }
        try {
            JSONObject jSONObject = a2.getJSONObject("rebates");
            JSONObject optJSONObject = jSONObject.optJSONObject("channels");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("accounts");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        Long valueOf = Long.valueOf(Long.parseLong(next));
                        JSONObject optJSONObject3 = optJSONObject.optJSONObject(next);
                        if (optJSONObject3 != null) {
                            dVar.b(valueOf.longValue(), optJSONObject3.optString("desc"));
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            if (optJSONObject2 != null) {
                Iterator<String> keys2 = optJSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    try {
                        Long valueOf2 = Long.valueOf(Long.parseLong(next2));
                        JSONObject optJSONObject4 = optJSONObject2.optJSONObject(next2);
                        if (optJSONObject4 != null) {
                            dVar.b(valueOf2.longValue(), optJSONObject4.optString("desc"));
                        }
                    } catch (NumberFormatException unused2) {
                    }
                }
            }
        } catch (JSONException unused3) {
        }
        return dVar;
    }

    public static BPCheckoutInfo o(String str) {
        JSONObject a2 = a(str);
        if (a2 != null) {
            try {
                JSONObject jSONObject = a2.getJSONObject(ProductAction.ACTION_CHECKOUT);
                return new BPCheckoutInfo(jSONObject.getString("name"), jSONObject.getString("icon"));
            } catch (JSONException e2) {
                com.airpay.paysdk.common.b.a.a((Throwable) e2);
            }
        }
        return null;
    }

    public static List<com.airpay.paysdk.core.bean.a> p(String str) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = a2.getJSONArray("downtime");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                arrayList.add(new com.airpay.paysdk.core.bean.a(Integer.parseInt(jSONArray2.getString(0)), Integer.parseInt(jSONArray2.getString(1))));
            }
            return arrayList;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String q(String str) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return null;
        }
        try {
            String string = a2.getString("nickname");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return string;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static int r(String str) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return -1;
        }
        try {
            return a2.getInt("daily_limit");
        } catch (JSONException unused) {
            return -1;
        }
    }

    private static BPEvent a(JSONObject jSONObject) {
        try {
            return new BPEvent(jSONObject.getLong("event_id"), jSONObject.getInt("start_time"), jSONObject.getInt("end_time"), jSONObject.getInt("priority"), jSONObject.getInt("type"), jSONObject.getString("rule"), jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static d<BPEvent> s(String str) {
        d<BPEvent> dVar = new d<>();
        JSONObject a2 = a(str);
        if (a2 == null) {
            return dVar;
        }
        try {
            JSONObject jSONObject = a2.getJSONObject("events");
            JSONObject optJSONObject = jSONObject.optJSONObject("channels");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("accounts");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        dVar.b(Long.valueOf(Long.parseLong(next)).longValue(), a(optJSONObject.getJSONObject(next)));
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            if (optJSONObject2 != null) {
                Iterator<String> keys2 = optJSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    try {
                        dVar.b(Long.valueOf(Long.parseLong(next2)).longValue(), a(optJSONObject2.getJSONObject(next2)));
                    } catch (NumberFormatException unused2) {
                    }
                }
            }
        } catch (JSONException unused3) {
        }
        return dVar;
    }

    public static com.airpay.paysdk.result.a a(String str, boolean z) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return null;
        }
        try {
            JSONObject jSONObject = a2.getJSONObject(z ? "payment" : "topup").getJSONObject("transfer").getJSONObject(z ? "transferee" : "transferer");
            return new com.airpay.paysdk.result.a(jSONObject.optString("name", (String) null), jSONObject.optString("mobile_no", (String) null));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String b(String str, boolean z) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return null;
        }
        try {
            JSONObject jSONObject = a2.getJSONObject(z ? "payment" : "topup").getJSONObject("transfer").getJSONObject(z ? "transferee" : "transferer");
            return new com.airpay.paysdk.result.a(jSONObject.optString("name", (String) null), jSONObject.optString("mobile_no", (String) null)).c();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String c(String str, boolean z) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return null;
        }
        try {
            return a2.getJSONObject(z ? "payment" : "topup").getJSONObject("transfer").getString("purpose");
        } catch (JSONException unused) {
            return null;
        }
    }

    private static BillRef b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new BillRef(jSONObject.getString("name"), jSONObject.optString("description", (String) null), jSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE, (String) null), jSONObject.optString("pattern", (String) null), jSONObject.optBoolean("editable", false), jSONObject.optBoolean("required", false), jSONObject.optBoolean("verified", false), jSONObject.optBoolean("numerical", false));
        } catch (JSONException unused) {
            return null;
        }
    }

    private static List<BillRef> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                BillRef b2 = b(jSONArray.optJSONObject(i));
                if (b2 != null) {
                    arrayList.add(b2);
                }
            }
        }
        return arrayList;
    }

    public static BillerConfig t(String str) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return null;
        }
        try {
            JSONObject jSONObject = a2.getJSONObject("biller");
            int i = jSONObject.getInt(BPOrderInfo.FIELD_UPDATE_TIME);
            return new BillerConfig(jSONObject.optString("company_name", (String) null), jSONObject.optString("service_name", (String) null), jSONObject.optString("bill_code", (String) null), jSONObject.optString("description", (String) null), jSONObject.getInt("gateway"), jSONObject.optInt("flag", 0), jSONObject.optString("barcode", (String) null), a(jSONObject.getJSONArray("refs")), i, jSONObject.optString("extra_data", (String) null), jSONObject.optString("bill_addinfo", (String) null));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static int u(String str) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return 0;
        }
        try {
            return a2.getJSONObject("payment").getJSONObject("bill").optInt("gateway", 0);
        } catch (JSONException unused) {
            return 0;
        }
    }

    public static Integer v(String str) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return null;
        }
        try {
            return Integer.valueOf(a2.getJSONObject("payment").getJSONObject("order_details").getInt("verification_code"));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static int w(String str) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return 0;
        }
        try {
            return a2.getJSONObject("topup").getInt("valid_time");
        } catch (JSONException unused) {
            return 0;
        }
    }

    public static long x(String str) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return -1;
        }
        try {
            return a2.getLong("cash_point");
        } catch (JSONException unused) {
            return -1;
        }
    }

    public static String y(String str) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return "";
        }
        try {
            return c(a2.getJSONObject("payment").getJSONObject("bill").getJSONObject("note"));
        } catch (JSONException unused) {
            return "";
        }
    }

    public static String z(String str) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return null;
        }
        try {
            return c(a2.getJSONObject("payment").getJSONObject("receipt_msg"));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String A(String str) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return null;
        }
        try {
            return c(a2.getJSONObject("payment").getJSONObject("summary"));
        } catch (JSONException unused) {
            return null;
        }
    }

    private static String c(JSONObject jSONObject) {
        try {
            return jSONObject.getString(com.airpay.paysdk.base.different.a.a().d());
        } catch (JSONException e2) {
            com.airpay.paysdk.common.b.a.a((Throwable) e2);
            return null;
        }
    }

    public static String B(String str) {
        JSONObject a2 = a(str);
        if (a2 == null) {
            return null;
        }
        try {
            return a2.getJSONObject("topup").getJSONObject("virtual_card").getString("narrative");
        } catch (JSONException e2) {
            com.airpay.paysdk.common.b.a.a((Throwable) e2);
            return null;
        }
    }

    public static com.airpay.paysdk.core.bean.d C(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (com.airpay.paysdk.core.bean.d) h.a().b().a(str, com.airpay.paysdk.core.bean.d.class);
    }

    public static com.airpay.paysdk.result.bean.d D(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("topup");
            if (jSONObject.has("voucher")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("voucher");
                return new com.airpay.paysdk.result.bean.d(jSONObject2.optString("voucher_name"), jSONObject2.optString("voucher_code"));
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("collection_qr");
            JSONObject jSONObject4 = jSONObject3.getJSONObject("payer");
            String str2 = null;
            try {
                str2 = jSONObject4.getJSONObject("payment_method").getString(com.airpay.paysdk.base.different.a.a().d());
            } catch (JSONException unused) {
            }
            return new com.airpay.paysdk.result.bean.d(jSONObject4.getString("mobile_no"), str2, jSONObject3.optString("payer_icon"), jSONObject3.optLong("shop_id"), jSONObject3.optString("shop_name"), jSONObject3.optString("shop_icon"));
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static com.airpay.paysdk.result.bean.d E(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("payment").getJSONObject("collection_qr");
            return new com.airpay.paysdk.result.bean.d(jSONObject.optString("cqr_transfer_mask_phone_no"), jSONObject.optString("payer_icon"), jSONObject.optLong("shop_id", 0), jSONObject.optString("shop_name"), jSONObject.optLong("shop_owner", 0), jSONObject.optString("shop_qr_id"), jSONObject.optString("shop_icon"));
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static com.airpay.paysdk.result.b F(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("payment");
            return new com.airpay.paysdk.result.b(jSONObject.optString("shop_name"), jSONObject.optString("shop_info"));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String a(BPOrderInfo bPOrderInfo) {
        try {
            return new JSONObject(bPOrderInfo.getExtraData()).getJSONObject("payment").optString("return_url", (String) null);
        } catch (JSONException e2) {
            com.airpay.paysdk.common.b.a.a((Throwable) e2);
            return null;
        }
    }
}
