package com.airpay.paysdk.pay;

import android.text.Editable;
import android.text.TextUtils;
import com.airpay.paysdk.base.bean.CollectionQrShop;
import com.airpay.paysdk.base.d.i;
import com.airpay.paysdk.base.proto.CollectionQRShopProto;
import com.airpay.paysdk.common.b.a;
import com.airpay.paysdk.pay.b.d;
import com.shopee.arcatch.data.common_bean.Country;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    public static double c(double d2) {
        return d2 / 1000000.0d;
    }

    public static CollectionQrShop a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("payment").getJSONObject("collection_qr");
            return new CollectionQrShop(new CollectionQRShopProto.Builder().shop_name(jSONObject.getString("shop_name")).owner_name(jSONObject.getString("merchant_name")).shop_icon(jSONObject.getString("shop_icon")).shop_id(Long.valueOf(jSONObject.getLong("shop_qr_id"))).build());
        } catch (JSONException unused) {
            return null;
        }
    }

    public static CharSequence a(String str, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        return charSequence.toString().trim().replace(d(str), "");
    }

    public static void a(String str, Editable editable) {
        String obj = editable.toString();
        if (!TextUtils.isEmpty(obj)) {
            String[] strArr = new String[0];
            if (Country.COUNTRY_TH.equals(str)) {
                strArr = obj.split("\\.");
                if (strArr.length != 0) {
                    obj = strArr[0];
                } else {
                    return;
                }
            }
            if (!TextUtils.isEmpty(obj)) {
                try {
                    String a2 = d.a(str).a(Double.parseDouble(obj.replace(d(str), "")));
                    if (a2.equalsIgnoreCase(obj)) {
                        return;
                    }
                    if (strArr.length == 2) {
                        int length = editable.length();
                        editable.replace(0, length, a2 + "." + strArr[1]);
                        return;
                    }
                    editable.replace(0, editable.length(), a2);
                } catch (Exception e2) {
                    a.a((Throwable) e2);
                }
            }
        }
    }

    public static double a(String str, String str2) throws NumberFormatException {
        return Double.parseDouble(str2.trim().replace(d(str), ""));
    }

    private static String d(String str) {
        return Country.COUNTRY_VN.equals(str) ? "." : ",";
    }

    public static String b(String str) {
        return Country.COUNTRY_VN.equals(str) ? "₫" : "฿";
    }

    public static Pattern c(String str) {
        if (Country.COUNTRY_TH.equals(str)) {
            return Pattern.compile("[0-9]{0,6}+((\\.[0-9]{0,2})?)||(\\.)?");
        }
        return Pattern.compile("[0-9]{0,11}");
    }

    public static String a() {
        return com.airpay.paysdk.base.different.a.a().d();
    }

    public static String a(double d2) {
        return b((double) i.a(d2));
    }

    public static String b(double d2) {
        return d.a(com.airpay.paysdk.base.different.a.a().b()).b(d2);
    }

    public static String b() {
        return com.airpay.paysdk.base.different.a.a().f();
    }
}
