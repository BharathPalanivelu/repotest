package com.airpay.paysdk.result.bean;

import android.content.Context;
import android.text.Spannable;
import android.text.TextUtils;
import com.airpay.paysdk.base.bean.BPOrderInfo;
import com.airpay.paysdk.base.bean.BPThirdPartyOrderDetail;
import com.airpay.paysdk.base.d.f;
import com.airpay.paysdk.c;
import com.airpay.paysdk.core.bean.ChannelInfo;
import com.airpay.paysdk.pay.b;
import com.tencent.ijk.media.player.IjkMediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final BPOrderInfo f4473a;

    /* renamed from: b  reason: collision with root package name */
    private C0086a f4474b;

    /* renamed from: c  reason: collision with root package name */
    private ChannelInfo f4475c;

    /* renamed from: d  reason: collision with root package name */
    private ChannelInfo f4476d;

    /* renamed from: e  reason: collision with root package name */
    private String f4477e;

    /* renamed from: f  reason: collision with root package name */
    private String f4478f;

    /* renamed from: g  reason: collision with root package name */
    private String f4479g;
    private c h;

    public a(BPOrderInfo bPOrderInfo) {
        this.f4473a = bPOrderInfo;
        a();
        ChannelInfo channelInfo = this.f4475c;
        if (channelInfo != null) {
            int b2 = channelInfo.b();
            if (b2 == 10013) {
                I();
            } else if (b2 == 10016) {
                J();
            }
        }
    }

    public void a() {
        this.f4474b = u();
        this.f4475c = com.airpay.paysdk.qrcode.a.a().a(Integer.valueOf(this.f4473a.getPaymentChannelId()));
        this.f4476d = com.airpay.paysdk.qrcode.a.a().a(Integer.valueOf(this.f4473a.getTopupChannelId()));
    }

    public CharSequence b() {
        if (this.f4473a.getTopupChannelId() == 11080) {
            return f.a(this.f4473a.getPaymentPayableAmount(), this.f4473a.getCurrency());
        }
        int paymentChannelId = this.f4473a.getPaymentChannelId();
        if (paymentChannelId == 21000 || paymentChannelId == 21002 || paymentChannelId == 21070 || paymentChannelId == 21072) {
            return f.a(this.f4473a.getPaymentPayableAmount(), this.f4473a.getCurrency());
        }
        return f.a(this.f4473a.getTopupPayableAmount(), this.f4473a.getCurrency());
    }

    public CharSequence c() {
        if (this.f4473a.getStatus() != 8) {
            return "";
        }
        long paymentCashAmount = this.f4473a.getPaymentCashAmount();
        return paymentCashAmount != 0 ? f.a(paymentCashAmount, this.f4473a.getCurrency()) : "";
    }

    public CharSequence d() {
        if (this.f4473a.getTotal_amount() <= 0) {
            int status = this.f4473a.getStatus();
            if (status == -4 || status == -1 || status == 9) {
                String h2 = com.airpay.paysdk.pay.b.a.h(this.f4473a.getExtraData());
                if (!TextUtils.isEmpty(h2)) {
                    try {
                        long parseLong = Long.parseLong(h2);
                        if (parseLong != 0) {
                            return f.a(parseLong, this.f4473a.getCurrency());
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return "";
        } else if (this.f4473a.getTotal_amount() > 0) {
            return f.a(this.f4473a.getTotal_amount(), this.f4473a.getCurrency());
        } else {
            return "";
        }
    }

    public CharSequence e() {
        return this.f4473a.getFee_amount() > 0 ? f.a(this.f4473a.getFee_amount(), this.f4473a.getCurrency()) : "";
    }

    public Spannable a(Context context) {
        int t = t();
        String b2 = com.airpay.paysdk.pay.b.a.b(this.f4473a.getExtraData());
        if (TextUtils.isEmpty(b2) || t == 4 || t == 6) {
            return null;
        }
        return f.c(context, b2);
    }

    public String f() {
        return String.valueOf(this.f4473a.getOrderId());
    }

    public String g() {
        int topupChannelId = this.f4473a.getTopupChannelId();
        if (topupChannelId == 10007 || topupChannelId == 10008) {
            return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_merchant_ref, new Object[]{com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_counter)});
        }
        switch (this.f4473a.getPaymentChannelId()) {
            case 21003:
            case 21006:
            case 21008:
            case 21009:
            case 21011:
                if (this.f4476d != null) {
                    return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_merchant_ref, new Object[]{this.f4476d.h()});
                }
                break;
            case 21004:
            case 21005:
                return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_merchant_ref, new Object[]{com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_counter)});
        }
        return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_merchant_ref, new Object[]{com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_payment)});
    }

    public BPShowTicketOrderDetail h() {
        return com.airpay.paysdk.pay.b.a.d(this.f4473a.getExtraData());
    }

    public String i() {
        int paymentChannelId = this.f4473a.getPaymentChannelId();
        if (paymentChannelId == 20001) {
            return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_merchant_ref, new Object[]{com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_garena)});
        } else if (paymentChannelId == 20003) {
            return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_merchant_ref, new Object[]{com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_cyberpay)});
        } else if (paymentChannelId == 20005) {
            return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_merchant_ref, new Object[]{com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_ais)});
        } else if (paymentChannelId == 20007) {
            return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_merchant_ref, new Object[]{com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_dtac)});
        } else if (paymentChannelId == 20009) {
            return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_merchant_ref, new Object[]{com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_true_money)});
        } else if (paymentChannelId == 20011) {
            return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_merchant_ref, new Object[]{com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_ais)});
        } else if (paymentChannelId == 20013) {
            return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_merchant_ref, new Object[]{com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_dtac)});
        } else if (paymentChannelId != 20015) {
            return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_merchant_ref, new Object[]{com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_merchant)});
        } else {
            return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_merchant_ref, new Object[]{com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_true_move_h)});
        }
    }

    public String j() {
        return (TextUtils.isEmpty(this.f4473a.getPaymentChannelTxnId()) || this.f4473a.getPaymentChannelId() == 21001 || this.f4473a.getPaymentChannelId() == 21021) ? "" : this.f4473a.getPaymentChannelTxnId();
    }

    public String k() {
        String str;
        ChannelInfo channelInfo = this.f4475c;
        if (channelInfo == null) {
            return "";
        }
        if (channelInfo.b() == 10007 || this.f4475c.b() == 10011 || this.f4475c.b() == 10026) {
            BPThirdPartyOrderDetail f2 = com.airpay.paysdk.pay.b.a.f(this.f4473a.getExtraData());
            String str2 = null;
            if (f2 != null) {
                str2 = f2.getItemDisplayName();
                str = f2.getStoreName();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                str = this.f4475c.i();
            }
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            return str2 + " - " + str;
        }
        int a2 = this.f4475c.a();
        if (a2 == 20044) {
            String itemName = this.f4473a.getItemName();
            if (TextUtils.isEmpty(itemName)) {
                return this.f4475c.i();
            }
            return itemName + " - " + this.f4475c.i();
        } else if (a2 != 310039) {
            switch (a2) {
                case 21070:
                case 21072:
                    d D = com.airpay.paysdk.pay.b.a.D(this.f4473a.getExtraData());
                    return this.f4475c.i() + " - " + D.a();
                case 21071:
                    return com.airpay.paysdk.pay.b.a.E(this.f4473a.getExtraData()).b();
                default:
                    int b2 = this.f4475c.b();
                    if (b2 <= 11000 || b2 >= 11900) {
                        if (!(b2 == 10008 || b2 == 10020)) {
                            if (b2 != 10025) {
                                switch (b2) {
                                    case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /*10003*/:
                                        return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_product_name_with_face_value, new Object[]{this.f4475c.i(), String.valueOf(this.f4473a.getItemAmount()), com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_shells)});
                                    case IjkMediaPlayer.FFP_PROP_FLOAT_AVDELAY /*10004*/:
                                        return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_product_name_with_face_value, new Object[]{this.f4475c.i(), this.f4473a.getItemId(), b.b()});
                                    case IjkMediaPlayer.FFP_PROP_FLOAT_AVDIFF /*10005*/:
                                        return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_product_name_with_face_value, new Object[]{this.f4475c.i(), String.valueOf(this.f4473a.getItemAmount()), this.f4473a.getItemId()});
                                    case 10006:
                                        break;
                                    default:
                                        return this.f4475c.i();
                                }
                            } else {
                                String B = com.airpay.paysdk.pay.b.a.B(this.f4473a.getExtraData());
                                if (TextUtils.isEmpty(B)) {
                                    return this.f4475c.i();
                                }
                                return B;
                            }
                        }
                        b m = com.airpay.paysdk.pay.b.a.m(this.f4473a.getExtraData());
                        if (m == null) {
                            return this.f4475c.i();
                        }
                        return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_product_name_with_face_value, new Object[]{this.f4475c.i(), m.a(), m.b()});
                    }
                    return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_bill_payment_with, new Object[]{this.f4475c.i()});
            }
        } else {
            BPThirdPartyOrderDetail f3 = com.airpay.paysdk.pay.b.a.f(this.f4473a.getExtraData());
            if (f3 != null) {
                return f3.getProductName(this.f4475c.i());
            }
            return this.f4475c.i();
        }
    }

    public String l() {
        String A = com.airpay.paysdk.pay.b.a.A(this.f4473a.getExtraData());
        if (!TextUtils.isEmpty(A)) {
            return A;
        }
        return m();
    }

    public String m() {
        int i;
        String str;
        String z = com.airpay.paysdk.pay.b.a.z(this.f4473a.getExtraData());
        if (z != null) {
            return z;
        }
        int t = t();
        int paymentChannelId = this.f4473a.getPaymentChannelId();
        ChannelInfo a2 = com.airpay.paysdk.qrcode.a.a().a(Integer.valueOf(paymentChannelId));
        if (a2 != null) {
            i = a2.b();
        } else {
            i = 0;
        }
        if (t == 0) {
            if (a2 == null) {
                str = "";
            } else {
                str = a2.c(com.airpay.paysdk.base.different.a.a().d());
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            if (i == 10011) {
                Integer v = com.airpay.paysdk.pay.b.a.v(this.f4473a.getExtraData());
                if (v == null) {
                    return "";
                }
                return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_verification_code_colon, new Object[]{v});
            } else if (i == 10012) {
                return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_sf_proceed_to_hall);
            } else {
                if (i == 10013) {
                    return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_donation_thank_you);
                }
                if (i == 10014) {
                    if (paymentChannelId == 21020) {
                        return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_loan_principal_release_success);
                    }
                    if (paymentChannelId == 21021) {
                        return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_loan_repay_success);
                    }
                    return "";
                } else if (i > 11000 && i < 11900) {
                    return com.airpay.paysdk.pay.b.a.y(this.f4473a.getExtraData());
                } else {
                    if (i == 10020) {
                        return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_desc_game_topup_success);
                    }
                    if (i != 10031) {
                        return "";
                    }
                    if (paymentChannelId == 25001) {
                        return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_exat_order_completed);
                    }
                }
            }
        } else if (t == 1) {
            ChannelInfo channelInfo = this.f4476d;
            if (channelInfo != null && channelInfo.b() == 103) {
                return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_atm_top_up_instruction);
            }
            return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_payment_expires, new Object[]{com.airpay.paysdk.base.d.c.a(((long) this.f4473a.getExpiryDate()) * 1000)});
        } else if (t != 3) {
            if (t == 4) {
                return f.d(this.f4473a);
            }
            if (t != 5) {
                if (t == 6) {
                    ChannelInfo channelInfo2 = this.f4476d;
                    boolean z2 = channelInfo2 != null && channelInfo2.b() == 3;
                    int l = com.airpay.paysdk.pay.b.a.l(this.f4473a.getExtraData());
                    String d2 = f.d(this.f4473a);
                    if (z2) {
                        if (G()) {
                            if (l == 0) {
                                return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_refunded_credit_card_and_wallet_no_error);
                            }
                            return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_refunded_credit_card_and_wallet, new Object[]{d2});
                        } else if (l == 0) {
                            return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_refunded_credit_card_no_error);
                        } else {
                            return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_refunded_credit_card, new Object[]{d2});
                        }
                    } else if (l == 0) {
                        return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_refunded_wallet_no_error);
                    } else {
                        return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_refunded_wallet, new Object[]{d2});
                    }
                } else if (t != 7) {
                    return "";
                } else {
                    return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_download_latest_version);
                }
            } else if ((i == 10003 || i == 10004 || i == 10005) && com.airpay.paysdk.pay.b.a.j(this.f4473a.getExtraData()) == 1) {
                return f.c(this.f4473a);
            } else {
                return "";
            }
        }
        if (i == 10010) {
            if (paymentChannelId == 21000 || paymentChannelId == 21001) {
                if (com.airpay.paysdk.pay.b.a.l(this.f4473a.getExtraData()) == 212) {
                    return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_will_be_notified_when_user_sign_up);
                }
                return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_will_be_notified_when_transfer_completed);
            } else if (paymentChannelId == 21002) {
                return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_will_be_notified_when_withdrawal_complete);
            } else {
                if (paymentChannelId == 21003) {
                    return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_will_be_notified_when_topup_complete);
                }
            }
        } else if (i == 10014 && paymentChannelId == 21020) {
            return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_loan_principal_release_processing);
        }
        return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_will_be_notified_when_order_completed);
    }

    public String n() {
        int t = t();
        if (t == 0) {
            return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_completed);
        }
        if (t == 1 || t == 3) {
            return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_processing);
        }
        if (t == 4) {
            return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_status_failed);
        }
        if (t == 5) {
            return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_action_needed);
        }
        if (t != 6) {
            return t != 7 ? "" : com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_unknown);
        }
        return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_refunded);
    }

    public ChannelInfo o() {
        return this.f4475c;
    }

    public ChannelInfo p() {
        return this.f4476d;
    }

    public BPOrderInfo q() {
        return this.f4473a;
    }

    public int r() {
        return this.f4473a.getPaymentChannelId();
    }

    public Integer s() {
        return Integer.valueOf(this.f4473a.getTopupChannelId());
    }

    public int t() {
        return this.f4473a.getStatusLabel();
    }

    public C0086a u() {
        long j;
        long j2;
        long currencyAmount = this.f4473a.getCurrencyAmount() - this.f4473a.getPaymentPayableAmount();
        long topupPayableAmount = this.f4473a.getTopupPayableAmount() - this.f4473a.getCurrencyAmount();
        if (currencyAmount > 0 || topupPayableAmount < 0) {
            j2 = Math.min(0, currencyAmount) + Math.min(0, topupPayableAmount);
            j = Math.max(0, topupPayableAmount) + Math.max(0, currencyAmount);
        } else {
            j2 = currencyAmount;
            j = topupPayableAmount;
        }
        return new C0086a(j2, j);
    }

    public CharSequence a(String str) {
        if (this.f4474b.f4481b <= 0) {
            return "";
        }
        CharSequence a2 = f.a(this.f4474b.f4481b, this.f4473a.getCurrency());
        if (TextUtils.isEmpty(str)) {
            return a2;
        }
        return TextUtils.concat(new CharSequence[]{str, a2});
    }

    public CharSequence v() {
        return this.f4474b.f4480a < 0 ? f.a(this.f4474b.f4480a, this.f4473a.getCurrency()) : "";
    }

    private boolean G() {
        return this.f4473a.getTopupCashAmount() > 0;
    }

    public CharSequence w() {
        return G() ? f.a(this.f4473a.getTopupCashAmount(), this.f4473a.getCurrency()) : "";
    }

    private boolean H() {
        return this.f4473a.getTopupChannelId() == 11000;
    }

    public CharSequence x() {
        if (H()) {
            return "";
        }
        long topupPayableAmount = this.f4473a.getTopupPayableAmount() - this.f4473a.getTopupCashAmount();
        if (topupPayableAmount > 0) {
            return f.a(topupPayableAmount, this.f4473a.getCurrency());
        }
        return "";
    }

    public String y() {
        if (this.f4475c != null) {
            try {
                return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_paid_by, new Object[]{f.b(Long.valueOf(this.f4473a.getTopupAccountId()).longValue(), this.f4473a.getTopupChannelId(), false, true)});
            } catch (NumberFormatException e2) {
                com.airpay.paysdk.common.b.a.a((Throwable) e2);
            }
        }
        return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_other);
    }

    public String z() {
        if (this.f4475c != null) {
            try {
                return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_refunded_to, new Object[]{f.b(Long.valueOf(this.f4473a.getTopupAccountId()).longValue(), this.f4473a.getTopupChannelId(), false, true)});
            } catch (NumberFormatException e2) {
                com.airpay.paysdk.common.b.a.a((Throwable) e2);
            }
        }
        return com.airpay.paysdk.a.a().b().getString(c.i.com_garena_beepay_label_refunded);
    }

    public String A() {
        return this.f4473a.getPaymentAccountId();
    }

    private void I() {
        try {
            JSONObject jSONObject = new JSONObject(this.f4473a.getExtraData()).getJSONObject("payment").getJSONObject("donor_info");
            this.f4477e = jSONObject.getString("name");
            this.f4478f = jSONObject.getString("ic");
            this.f4479g = jSONObject.getString("address");
        } catch (JSONException e2) {
            com.airpay.paysdk.common.b.a.a((Throwable) e2);
        }
    }

    public String B() {
        return TextUtils.isEmpty(this.f4477e) ? "" : this.f4477e;
    }

    public String C() {
        return TextUtils.isEmpty(this.f4478f) ? "" : this.f4478f;
    }

    public String D() {
        return TextUtils.isEmpty(this.f4479g) ? "" : this.f4479g;
    }

    private void J() {
        this.h = com.airpay.paysdk.pay.b.a.e(this.f4473a.getExtraData());
    }

    public c E() {
        return this.h;
    }

    public int F() {
        return this.f4473a.getType();
    }

    /* renamed from: com.airpay.paysdk.result.bean.a$a  reason: collision with other inner class name */
    public static class C0086a {

        /* renamed from: a  reason: collision with root package name */
        public long f4480a;

        /* renamed from: b  reason: collision with root package name */
        public long f4481b;

        private C0086a(long j, long j2) {
            this.f4480a = j;
            this.f4481b = j2;
        }

        public String toString() {
            return "BreakDownInfo{discount=" + this.f4480a + ", fee=" + this.f4481b + '}';
        }
    }

    public String toString() {
        return "BPOrder{mOrder=" + this.f4473a + "\n mBreakDown=" + this.f4474b + "\n mPaymentChannel=" + this.f4475c + "\n mTopupChannel=" + this.f4476d + "\n mDonorName='" + this.f4477e + '\'' + "\n mDonorIc='" + this.f4478f + '\'' + "\n mDonorAddress='" + this.f4479g + '\'' + "\n mTransportOrderInfo=" + this.h + '}';
    }
}
