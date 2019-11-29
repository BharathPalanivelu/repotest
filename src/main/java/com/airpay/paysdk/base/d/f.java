package com.airpay.paysdk.base.d;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.widget.TextView;
import com.airpay.paysdk.a;
import com.airpay.paysdk.base.b.b;
import com.airpay.paysdk.base.bean.BPEvent;
import com.airpay.paysdk.base.bean.BPOrderInfo;
import com.airpay.paysdk.base.bean.EventCommonResult;
import com.airpay.paysdk.base.proto.PaymentOrderInitRequestProto;
import com.airpay.paysdk.c;
import com.airpay.paysdk.core.bean.ChannelInfo;
import com.airpay.paysdk.qrcode.model.BankAccountInfo;
import com.airpay.paysdk.result.bean.BillChannelInfo;
import com.facebook.appevents.AppEventsConstants;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.ijk.media.player.IjkMediaPlayer;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Marker;

public class f {
    private static int a(int i, int i2) {
        if (i < -4 || i > 11) {
            return 7;
        }
        if (i == -1) {
            return 4;
        }
        if (i == 0) {
            return 1;
        }
        if (i == 6) {
            return 5;
        }
        if (i == 11 || i == 8) {
            return 0;
        }
        return i != 9 ? 3 : 6;
    }

    public static String a(String str) {
        return str;
    }

    public static String a(long j, int i, boolean z, boolean z2) {
        BankAccountInfo a2 = b.a().a(j);
        if (a2 != null && !TextUtils.isEmpty(a2.n)) {
            return a2.n;
        }
        if (z2) {
            return a(a.a().b(), j, i, z);
        }
        return a(j, i, z);
    }

    public static String a(int i, boolean z) {
        int i2;
        if (i == 10000) {
            i2 = z ? c.i.com_garena_beepay_label_ktb_abbr : c.i.com_garena_beepay_label_ktb;
        } else if (i == 10001) {
            i2 = z ? c.i.com_garena_beepay_label_scb_abbr : c.i.com_garena_beepay_label_scb;
        } else if (i == 10005) {
            i2 = z ? c.i.com_garena_beepay_label_kbank_abbr : c.i.com_garena_beepay_label_kbank;
        } else if (i == 10006) {
            i2 = z ? c.i.com_garena_beepay_label_bbl_abbr : c.i.com_garena_beepay_label_bbl;
        } else if (i == 10009) {
            i2 = z ? c.i.com_garena_beepay_label_tmb_abbr : c.i.com_garena_beepay_label_tmb;
        } else if (i == 10433) {
            i2 = z ? c.i.airpay_label_bank_lhbank_short : c.i.airpay_label_bank_lhbank;
        } else if (i == 13406) {
            i2 = z ? c.i.airpay_label_bank_agri_short : c.i.airpay_label_bank_agri;
        } else if (i == 13408) {
            i2 = z ? c.i.airpay_label_bank_mbbank_short : c.i.airpay_label_bank_mbbank;
        } else if (i == 13410) {
            i2 = z ? c.i.airpay_label_bank_eximbank_short : c.i.airpay_label_bank_eximbank;
        } else if (i == 13412) {
            i2 = z ? c.i.airpay_label_bank_vibbank_short : c.i.airpay_label_bank_vibbank;
        } else if (i == 13414) {
            i2 = z ? c.i.airpay_label_bank_saigonbank_short : c.i.airpay_label_bank_saigonbank;
        } else if (i == 13435) {
            i2 = z ? c.i.airpay_label_bank_nama_short : c.i.airpay_label_bank_nama;
        } else if (i == 13437) {
            i2 = z ? c.i.airpay_label_bank_bacabank_short : c.i.airpay_label_bank_bacabank;
        } else if (i == 13440) {
            i2 = c.i.airpay_label_bank_Viet_capital;
        } else if (i == 10408) {
            i2 = z ? c.i.airpay_label_bank_tbank_short : c.i.airpay_label_bank_tbank;
        } else if (i == 10409) {
            i2 = z ? c.i.com_garena_beepay_label_bay_abbr : c.i.com_garena_beepay_label_bank_bay;
        } else if (i == 13421) {
            i2 = z ? c.i.airpay_label_bank_tpbank_short : c.i.airpay_label_bank_tpbank;
        } else if (i != 13422) {
            switch (i) {
                case 13400:
                    if (!z) {
                        i2 = c.i.airpay_label_bank_bidv;
                        break;
                    } else {
                        i2 = c.i.airpay_label_bank_bidv_short;
                        break;
                    }
                case 13401:
                    if (!z) {
                        i2 = c.i.airpay_label_bank_vcb;
                        break;
                    } else {
                        i2 = c.i.airpay_label_bank_vcb_short;
                        break;
                    }
                case 13402:
                    if (!z) {
                        i2 = c.i.airpay_label_bank_sacombank;
                        break;
                    } else {
                        i2 = c.i.airpay_label_bank_sacombank_short;
                        break;
                    }
                case 13403:
                    if (!z) {
                        i2 = c.i.airpay_label_bank_vtb;
                        break;
                    } else {
                        i2 = c.i.airpay_label_bank_vtb_short;
                        break;
                    }
                default:
                    switch (i) {
                        case 13424:
                            if (!z) {
                                i2 = c.i.airpay_label_bank_seabank;
                                break;
                            } else {
                                i2 = c.i.airpay_label_bank_seabank_short;
                                break;
                            }
                        case 13425:
                            if (!z) {
                                i2 = c.i.airpay_label_bank_ocb;
                                break;
                            } else {
                                i2 = c.i.airpay_label_bank_ocb_short;
                                break;
                            }
                        case 13426:
                            if (!z) {
                                i2 = c.i.airpay_label_bank_ncb;
                                break;
                            } else {
                                i2 = c.i.airpay_label_bank_ncb_short;
                                break;
                            }
                        default:
                            i2 = c.i.com_garena_beepay_label_bank_account;
                            break;
                    }
            }
        } else {
            i2 = z ? c.i.airpay_label_bank_abbank_short : c.i.airpay_label_bank_abbank;
        }
        return a.a().b().getString(i2);
    }

    public static String a(long j, int i, boolean z) {
        return b(j, i, z, z);
    }

    public static String a(BankAccountInfo bankAccountInfo, int i, boolean z, boolean z2) {
        String str;
        ChannelInfo a2 = com.airpay.paysdk.qrcode.a.a().a(Integer.valueOf(i));
        if (a2 != null) {
            Context b2 = a.a().b();
            int b3 = a2.b();
            if (b3 == 1) {
                str = b2.getString(c.i.com_garena_beepay_label_cash_payment);
            } else if (b3 == 2) {
                str = a(a2.a(), z2);
            } else if (b3 != 3) {
                if (b3 == 7) {
                    str = b2.getString(c.i.com_garena_beepay_label_virtual_card);
                } else if (b3 != 101) {
                    int a3 = a2.a();
                    str = a3 != 10007 ? a3 != 10008 ? z2 ? a2.h() : a2.i() : b2.getString(c.i.com_garena_beepay_label_top_up_via_airpay_cashcard) : b2.getString(c.i.com_garena_beepay_label_top_up_via_airpay_counter);
                } else {
                    str = b2.getString(c.i.com_garena_beepay_label_seven_eleven_name);
                }
            } else if (bankAccountInfo == null) {
                str = b2.getString(c.i.com_garena_beepay_label_credit_card);
            } else {
                String g2 = com.airpay.paysdk.pay.b.a.g(bankAccountInfo.l);
                char c2 = 65535;
                switch (g2.hashCode()) {
                    case 47665:
                        if (g2.equals("001")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 47666:
                        if (g2.equals("002")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 47671:
                        if (g2.equals("007")) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                str = c2 != 0 ? c2 != 1 ? c2 != 2 ? b2.getString(c.i.com_garena_beepay_label_credit_card) : b2.getString(c.i.com_garena_beepay_label_jcb) : b2.getString(c.i.com_garena_beepay_label_master) : b2.getString(c.i.com_garena_beepay_label_visa);
            }
        } else {
            str = "";
        }
        if (!z || bankAccountInfo == null) {
            return str;
        }
        if (a2 == null) {
            return str + SQLBuilder.BLANK + bankAccountInfo.f4358d;
        } else if (a2.b() == 3) {
            return str + SQLBuilder.BLANK + a(bankAccountInfo.f4358d, 4, true);
        } else if (a2.b() == 2) {
            return str + SQLBuilder.BLANK + a(bankAccountInfo.f4358d, 6, false);
        } else {
            return str + SQLBuilder.BLANK + bankAccountInfo.f4358d;
        }
    }

    public static String b(long j, int i, boolean z, boolean z2) {
        return a(b.a().a(j), i, z, z2);
    }

    public static String a(Context context, long j, int i, boolean z) {
        String a2 = a(j, i, z);
        return TextUtils.isEmpty(a2) ? context.getString(c.i.com_garena_beepay_label_unknown) : a2;
    }

    public static Spannable a(String str, String str2, String str3) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (!TextUtils.isEmpty(str3)) {
            spannableStringBuilder.append(SQLBuilder.BLANK).append(String.valueOf(str3));
            if (!TextUtils.isEmpty(str2)) {
                SpannableString spannableString = new SpannableString(str2);
                spannableString.setSpan(new SuperscriptSpan(), 0, spannableString.length(), 33);
                spannableString.setSpan(new RelativeSizeSpan(0.6f), 0, spannableString.length(), 33);
                spannableStringBuilder.append(spannableString);
            }
        }
        return spannableStringBuilder;
    }

    public static CharSequence a(long j, String str) {
        if (str != null && str.equals(com.airpay.paysdk.pay.b.b())) {
            return com.airpay.paysdk.pay.b.b((double) j);
        }
        return String.format("%1$s %2$s", new Object[]{com.airpay.paysdk.pay.b.a((double) j), str});
    }

    public static String a(BPOrderInfo bPOrderInfo) {
        String paymentAccountId = bPOrderInfo.getPaymentAccountId();
        int paymentChannelId = bPOrderInfo.getPaymentChannelId();
        if (paymentChannelId == 20001) {
            String a2 = com.airpay.paysdk.pay.b.a.a(bPOrderInfo.getExtraData(), bPOrderInfo.getPaymentAccountId());
            return a2 != null ? a2 : paymentAccountId;
        } else if (paymentChannelId == 20003) {
            return a(bPOrderInfo.getPaymentAccountId());
        } else {
            switch (paymentChannelId) {
                case 21000:
                    return com.airpay.paysdk.pay.b.a.b(bPOrderInfo.getExtraData(), false);
                case 21001:
                    return com.airpay.paysdk.pay.b.a.b(bPOrderInfo.getExtraData(), true);
                case 21002:
                    BankAccountInfo bankAccountInfo = null;
                    try {
                        bankAccountInfo = b.a().a(Long.parseLong(paymentAccountId));
                    } catch (NumberFormatException unused) {
                    }
                    if (bankAccountInfo != null) {
                        return a(bankAccountInfo.f4355a, bankAccountInfo.f4357c, true, true);
                    }
                    return a.a().b().getString(c.i.com_garena_beepay_label_bank_account);
                default:
                    return paymentAccountId;
            }
        }
    }

    public static String a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return context.getResources().getString(c.i.com_garena_beepay_label_rebate) + SQLBuilder.BLANK + str;
    }

    public static String a(Context context, BPEvent bPEvent) {
        if (bPEvent == null) {
            return null;
        }
        String a2 = com.airpay.paysdk.pay.b.a.a(context, bPEvent, "promotion");
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return null;
    }

    public static Spanned a(Context context, long j, long j2, String str, boolean z) {
        String str2;
        String str3;
        long j3 = j;
        long j4 = j2;
        if (j3 <= 0 && j4 <= 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Resources resources = context.getResources();
        spannableStringBuilder.append(resources.getString(c.i.com_garena_beepay_label_transaction_fee));
        spannableStringBuilder.append(SQLBuilder.BLANK);
        String str4 = Marker.ANY_NON_NULL_MARKER;
        boolean z2 = false;
        if (j3 > 0) {
            StringBuilder sb = new StringBuilder();
            if (z) {
                str3 = str4;
            } else {
                str3 = "-";
            }
            sb.append(str3);
            sb.append(com.airpay.paysdk.pay.b.a((double) j3));
            SpannableString spannableString = new SpannableString(sb.toString());
            if (j3 > j4) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
            spannableStringBuilder.append(spannableString);
            z2 = true;
        }
        if (j3 > j4) {
            if (j4 == 0) {
                str2 = resources.getString(c.i.com_garena_beepay_label_free);
            } else {
                StringBuilder sb2 = new StringBuilder();
                if (!z) {
                    str4 = "-";
                }
                sb2.append(str4);
                sb2.append(com.airpay.paysdk.pay.b.a((double) j4));
                str2 = sb2.toString();
            }
            if (z2) {
                spannableStringBuilder.append(SQLBuilder.BLANK);
            }
            spannableStringBuilder.append(str2);
        }
        return spannableStringBuilder;
    }

    public static String a(Context context, long j, String str) {
        if (j == 0) {
            return null;
        }
        String str2 = com.airpay.paysdk.pay.b.a((double) j).toString();
        String string = context.getResources().getString(c.i.com_garena_beepay_label_discount);
        return string + SQLBuilder.BLANK + str2;
    }

    public static String a(Context context, ChannelInfo channelInfo) {
        BillChannelInfo billChannelInfo;
        if (channelInfo == null) {
            return context.getString(c.i.com_garena_beepay_label_merchant);
        }
        int b2 = channelInfo.b();
        if (b2 <= 11000 || b2 >= 11900) {
            switch (channelInfo.b()) {
                case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /*10003*/:
                    return context.getString(c.i.com_garena_beepay_label_garena);
                case IjkMediaPlayer.FFP_PROP_FLOAT_AVDELAY /*10004*/:
                    int a2 = channelInfo.a();
                    if (a2 == 20011) {
                        return context.getString(c.i.com_garena_beepay_label_ais_1_2_call);
                    }
                    if (a2 == 20013) {
                        return context.getString(c.i.com_garena_beepay_label_dtac_happy);
                    }
                    if (a2 == 20015) {
                        return context.getString(c.i.com_garena_beepay_label_true_move_h);
                    }
                    break;
                case IjkMediaPlayer.FFP_PROP_FLOAT_AVDIFF /*10005*/:
                    return context.getString(c.i.com_garena_beepay_label_cyberpay);
                case 10006:
                    int a3 = channelInfo.a();
                    if (a3 == 20005) {
                        return context.getString(c.i.com_garena_beepay_label_ais_1_2_call);
                    }
                    if (a3 == 20007) {
                        return context.getString(c.i.com_garena_beepay_label_dtac_happy);
                    }
                    if (a3 == 20009) {
                        return context.getString(c.i.com_garena_beepay_label_true_move_h);
                    }
                    break;
            }
            String i = channelInfo.i();
            return TextUtils.isEmpty(i) ? context.getString(c.i.com_garena_beepay_label_merchant) : i;
        }
        if (channelInfo instanceof BillChannelInfo) {
            billChannelInfo = (BillChannelInfo) channelInfo;
        } else {
            billChannelInfo = new BillChannelInfo(channelInfo);
        }
        return billChannelInfo.a(context, com.airpay.paysdk.pay.b.a());
    }

    public static int a(int i) {
        if (i == 10000) {
            return c.d.com_garena_beepay_icon_payment_ktb_page;
        }
        if (i == 10001) {
            return c.d.com_garena_beepay_icon_payment_scb_page;
        }
        if (i == 10005) {
            return c.d.com_garena_beepay_icon_payment_kbank_page;
        }
        if (i == 10006) {
            return c.d.com_garena_beepay_icon_payment_bbl_page;
        }
        if (i == 10009) {
            return c.d.com_garena_beepay_icon_payment_tmb_page;
        }
        if (i == 10433) {
            return c.d.com_garena_beepay_icon_payment_lhbank_page;
        }
        if (i == 13406) {
            return c.d.com_garena_beepay_logo_payment_agribank;
        }
        if (i == 13408) {
            return c.d.com_garena_beepay_logo_payment_mbb;
        }
        if (i == 13410) {
            return c.d.com_garena_beepay_logo_payment_exim;
        }
        if (i == 13412) {
            return c.d.com_garena_beepay_logo_payment_vib;
        }
        if (i == 13414) {
            return c.d.com_garena_beepay_logo_payment_saigonbank;
        }
        if (i == 13435) {
            return c.d.com_garena_beepay_icon_addbank_nab;
        }
        if (i == 13437) {
            return c.d.com_garena_beepay_icon_addbank_bac_a;
        }
        if (i == 13440) {
            return c.d.icon_viet_capital_bank;
        }
        if (i == 10408) {
            return c.d.com_garena_beepay_icon_payment_tbank_page;
        }
        if (i == 10409) {
            return c.d.icon_paymento_bay;
        }
        if (i == 13421) {
            return c.d.com_garena_beepay_logo_payment_tpb;
        }
        if (i == 13422) {
            return c.d.com_garena_beepay_logo_payment_abb;
        }
        switch (i) {
            case 13400:
                return c.d.com_garena_beepay_logo_payment_bidv;
            case 13401:
                return c.d.com_garena_beepay_logo_payment_vcb;
            case 13402:
                return c.d.com_garena_beepay_logo_payment_scb;
            case 13403:
                return c.d.com_garena_beepay_logo_payment_vtb;
            default:
                switch (i) {
                    case 13424:
                        return c.d.com_garena_beepay_logo_payment_seabank;
                    case 13425:
                        return c.d.com_garena_beepay_logo_payment_ocb;
                    case 13426:
                        return c.d.com_garena_beepay_logo_payment_ncb;
                    default:
                        return c.d.com_garena_beepay_logo_payment_unknown;
                }
        }
    }

    public static int b(int i) {
        if (i == 10000) {
            return c.d.com_garena_beepay_icon_payment_ktb_page_grey;
        }
        if (i == 10001) {
            return c.d.com_garena_beepay_icon_payment_scb_page_grey;
        }
        if (i == 10005) {
            return c.d.com_garena_beepay_icon_payment_kbank_page_grey;
        }
        if (i == 10006) {
            return c.d.com_garena_beepay_icon_payment_bbl_page_grey;
        }
        if (i == 10009) {
            return c.d.com_garena_beepay_icon_payment_tmb_page_grey;
        }
        if (i == 10433) {
            return c.d.com_garena_beepay_icon_payment_lhbank_page_grey;
        }
        if (i == 13410) {
            return c.d.com_garena_beepay_logo_payment_exim_grey;
        }
        if (i == 13412) {
            return c.d.com_garena_beepay_icon_payment_vib_page_grey;
        }
        if (i == 10408) {
            return c.d.com_garena_beepay_icon_payment_tbank_page_grey;
        }
        if (i == 10409) {
            return c.d.icon_paymento_bay_gray;
        }
        if (i == 13425) {
            return c.d.com_garena_beepay_logo_payment_ocb_grey;
        }
        if (i != 13426) {
            return c.d.com_garena_beepay_logo_payment_unknown_grey;
        }
        return c.d.com_garena_beepay_logo_payment_ncb_grey;
    }

    public static Spannable b(Context context, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int indexOf = str.indexOf("[");
        while (indexOf != -1) {
            int indexOf2 = str.indexOf("]");
            SpannableString spannableString = new SpannableString(str.substring(0, indexOf2).replace("[", "").replace("]", ""));
            URLSpan uRLSpan = new URLSpan("tel:" + str.substring(indexOf + 1, indexOf2).replace("#", "%23"));
            int i = indexOf2 + -1;
            spannableString.setSpan(uRLSpan, indexOf, i, 33);
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(c.b.com_garena_beepay_text_link_blue)), indexOf, i, 33);
            str = str.substring(indexOf2 + 1);
            indexOf = str.indexOf("[");
            spannableStringBuilder.append(spannableString);
        }
        spannableStringBuilder.append(str);
        return spannableStringBuilder;
    }

    private static int a(int i, int i2, int i3) {
        if (i == 9 && (i2 == 21002 || i2 == 21001 || i2 == 21000 || i2 == 21003 || i2 == 21004 || i2 == 21005 || i2 == 21006 || i2 == 21008 || i2 == 21009)) {
            return 4;
        }
        return a(i, i3);
    }

    public static int b(BPOrderInfo bPOrderInfo) {
        return a(bPOrderInfo.getStatus(), bPOrderInfo.getPaymentChannelId(), bPOrderInfo.getExpiryDate());
    }

    private static String a(String str, int i, int i2, boolean z) {
        char[] cArr = new char[i];
        Arrays.fill(cArr, '*');
        StringBuilder sb = new StringBuilder(new String(cArr));
        int length = str.length();
        int min = length - Math.min(length, i2);
        if (z) {
            sb.append(SQLBuilder.BLANK);
        }
        sb.append(str.substring(min, length));
        return sb.toString();
    }

    public static String b(String str) {
        int length = str.length();
        return str.substring(length - Math.min(length, 4), length);
    }

    public static String a(String str, int i, boolean z) {
        return a(str, i, 4, z);
    }

    public static String b(String str, int i, boolean z) {
        int length = str.length();
        if (length <= i) {
            return a(str, length, 0, z);
        }
        return a(str, length - i, i, z);
    }

    public static String a(String str, float f2, boolean z) {
        int length = str.length();
        int ceil = (int) Math.ceil((double) (((float) length) * f2));
        return a(str, ceil, length - ceil, z);
    }

    public static String c(BPOrderInfo bPOrderInfo) {
        String a2 = a(bPOrderInfo);
        return a.a().b().getString(c.i.com_garena_beepay_error_airtime_action_needed, new Object[]{a2});
    }

    public static String b(Context context, ChannelInfo channelInfo) {
        if (channelInfo == null) {
            return context.getString(c.i.com_garena_beepay_error_invalid_payment_account_general);
        }
        int b2 = channelInfo.b();
        if (b2 != 10020) {
            switch (b2) {
                case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /*10003*/:
                case IjkMediaPlayer.FFP_PROP_FLOAT_AVDIFF /*10005*/:
                    break;
                case IjkMediaPlayer.FFP_PROP_FLOAT_AVDELAY /*10004*/:
                    return context.getString(c.i.com_garena_beepay_error_invalid_phone_number, new Object[]{a(context, channelInfo)});
                default:
                    return context.getString(c.i.com_garena_beepay_error_invalid_payment_account_general);
            }
        }
        return context.getString(c.i.com_garena_beepay_error_invalid_payment_account, new Object[]{a(context, channelInfo)});
    }

    public static String a(Context context, BPOrderInfo bPOrderInfo) {
        switch (bPOrderInfo.getPaymentChannelId()) {
            case 21000:
            case 21001:
                return context.getString(c.i.com_garena_beepay_label_transfer_processing);
            case 21002:
                return context.getString(c.i.com_garena_beepay_label_withdrawal_processing);
            case 21003:
            case 21004:
            case 21005:
            case 21006:
            case 21008:
            case 21009:
            case 21010:
            case 21011:
                return context.getString(c.i.com_garena_beepay_label_topup_processing);
            default:
                return context.getString(c.i.com_garena_beepay_label_transaction_processing);
        }
    }

    public static String b(Context context, BPOrderInfo bPOrderInfo) {
        switch (bPOrderInfo.getPaymentChannelId()) {
            case 21001:
                return context.getString(c.i.com_garena_beepay_label_transfer_success);
            case 21002:
                return context.getString(c.i.com_garena_beepay_label_withdrawal_completed);
            case 21003:
            case 21004:
            case 21005:
            case 21006:
            case 21008:
            case 21009:
            case 21010:
            case 21011:
                return context.getString(c.i.com_garena_beepay_label_top_up_successful);
            case 21007:
                return context.getString(c.i.com_garena_beepay_label_remittance_completed);
            default:
                return context.getString(c.i.com_garena_beepay_label_transaction_success_title);
        }
    }

    public static String a(Context context, int i) {
        if (i == 21007) {
            return context.getString(c.i.com_garena_beepay_label_remittance_failed);
        }
        switch (i) {
            case 21001:
                return context.getString(c.i.com_garena_beepay_label_transfer_cancelled);
            case 21002:
                return context.getString(c.i.com_garena_beepay_label_withdrawal_failed);
            case 21003:
                return context.getString(c.i.com_garena_beepay_top_up_failed);
            default:
                return context.getString(c.i.com_garena_beepay_label_transaction_failed);
        }
    }

    public static String a(Context context, ChannelInfo channelInfo, ChannelInfo channelInfo2, EventCommonResult eventCommonResult, PaymentOrderInitRequestProto paymentOrderInitRequestProto) {
        Context context2 = context;
        ChannelInfo channelInfo3 = channelInfo;
        PaymentOrderInitRequestProto paymentOrderInitRequestProto2 = paymentOrderInitRequestProto;
        int a2 = channelInfo2 != null ? channelInfo2.a() : -1;
        long j = -1;
        if (paymentOrderInitRequestProto2 != null) {
            if (paymentOrderInitRequestProto2.topup_channel_id != null) {
                a2 = paymentOrderInitRequestProto2.topup_channel_id.intValue();
            }
            if (paymentOrderInitRequestProto2.bank_account_id != null) {
                j = paymentOrderInitRequestProto2.bank_account_id.longValue();
            }
        }
        if (eventCommonResult.getResultCode() == 153) {
            if (channelInfo2 != null) {
                List<com.airpay.paysdk.core.bean.a> p = com.airpay.paysdk.pay.b.a.p(channelInfo2.d());
                if (p != null) {
                    for (com.airpay.paysdk.core.bean.a next : p) {
                        if (next.a(c.b())) {
                            return context.getString(c.i.com_garena_beepay_error_channel_scheduled_maintenance, new Object[]{a(context, j, a2, false), next.a()});
                        }
                    }
                }
            }
            return context.getString(c.i.com_garena_beepay_error_topup_channel_unavailable, new Object[]{a(context, j, a2, false)});
        }
        if (eventCommonResult.getResultCode() == 2 && paymentOrderInitRequestProto2 != null) {
            int g2 = com.airpay.paysdk.base.different.a.a().g();
            if (channelInfo3 != null) {
                long j2 = (long) g2;
                if (channelInfo.e() >= j2 && paymentOrderInitRequestProto2.payment_payable_amount.longValue() < channelInfo.e()) {
                    return context.getString(c.i.com_garena_beepay_label_minimum_topup, new Object[]{channelInfo.i(), a(channelInfo.e(), channelInfo.c())});
                } else if (channelInfo.f() >= j2 && paymentOrderInitRequestProto2.payment_payable_amount.longValue() > channelInfo.f()) {
                    return context.getString(c.i.com_garena_beepay_label_maximum_topup, new Object[]{channelInfo.i(), a(channelInfo.f(), channelInfo.c())});
                }
            }
            if (channelInfo2 != null) {
                long longValue = paymentOrderInitRequestProto2.topup_payable_amount.longValue() - paymentOrderInitRequestProto2.topup_cash_amount.longValue();
                BankAccountInfo bankAccountInfo = null;
                if (paymentOrderInitRequestProto2.bank_account_id != null) {
                    bankAccountInfo = b.a().a(paymentOrderInitRequestProto2.bank_account_id.longValue());
                }
                long j3 = (long) g2;
                if (channelInfo2.e() >= j3 && longValue < channelInfo2.e()) {
                    return context.getString(c.i.com_garena_beepay_error_min_topup_txn_limit, new Object[]{a(bankAccountInfo, channelInfo2.a(), false, true), com.airpay.paysdk.pay.b.b((double) channelInfo2.e())});
                } else if (channelInfo2.f() >= j3 && longValue > channelInfo2.f()) {
                    return context.getString(c.i.com_garena_beepay_error_max_topup_txn_limit, new Object[]{a(bankAccountInfo, channelInfo2.a(), false, true), com.airpay.paysdk.pay.b.b((double) channelInfo2.f())});
                }
            }
        }
        return a(context, channelInfo, eventCommonResult);
    }

    public static Spannable c(Context context, String str) {
        SpannableString spannableString;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int indexOf = str.indexOf("[");
        int indexOf2 = str.indexOf("{");
        int indexOf3 = str.indexOf("]");
        int indexOf4 = str.indexOf("}");
        while (true) {
            if ((indexOf <= -1 || indexOf3 <= -1) && (indexOf2 <= -1 || indexOf4 <= -1)) {
                spannableStringBuilder.append(str);
            } else {
                if (indexOf2 < 0 || (indexOf > -1 && indexOf < indexOf2)) {
                    SpannableString spannableString2 = new SpannableString(str.substring(0, indexOf3).replace("[", "").replace("]", "").replace("{", "").replace("}", ""));
                    spannableString2.setSpan(new ForegroundColorSpan(context.getResources().getColor(c.b.com_garena_beepay_text_link_blue)), indexOf, indexOf3 - 1, 33);
                    spannableString = spannableString2;
                } else {
                    spannableString = new SpannableString(str.substring(0, indexOf4).replace("[", "").replace("]", "").replace("{", "").replace("}", ""));
                    str.substring(indexOf2 + 1, indexOf4);
                    indexOf3 = indexOf4;
                }
                str = str.substring(indexOf3 + 1);
                spannableStringBuilder.append(spannableString);
                indexOf = str.indexOf("[");
                indexOf2 = str.indexOf("{");
                indexOf3 = str.indexOf("]");
                indexOf4 = str.indexOf("}");
            }
        }
        spannableStringBuilder.append(str);
        return spannableStringBuilder;
    }

    public static String a(Context context, ChannelInfo channelInfo, EventCommonResult eventCommonResult) {
        int resultCode = eventCommonResult.getResultCode();
        if (resultCode == 136) {
            return eventCommonResult.getMessage(b(context, channelInfo));
        }
        if (resultCode == 154) {
            return eventCommonResult.getMessage(context.getString(c.i.com_garena_beepay_error_payment_channel_unavailable, new Object[]{a(context, channelInfo)}));
        } else if (resultCode == 158) {
            return eventCommonResult.getMessage(d(context, channelInfo.d()));
        } else {
            if (resultCode == 211) {
                return eventCommonResult.getMessage(context.getString(c.i.com_garena_beepay_error_cash_transferee_registration_expired, new Object[]{7}));
            } else if (resultCode != 212) {
                return eventCommonResult.getMessage();
            } else {
                return eventCommonResult.getMessage(context.getString(c.i.com_garena_beepay_error_transferee_registration_pending, new Object[]{7}));
            }
        }
    }

    public static String d(BPOrderInfo bPOrderInfo) {
        return a(bPOrderInfo.getPaymentChannelId(), bPOrderInfo.getTopupChannelId(), bPOrderInfo.getExtraData(), bPOrderInfo.getTopupAccountId());
    }

    private static String a(int i, int i2, String str, String str2) {
        if (i == 21002 || i == 21020 || i == 21007) {
            String k = com.airpay.paysdk.pay.b.a.k(str);
            if (!TextUtils.isEmpty(k)) {
                return k;
            }
        }
        int l = com.airpay.paysdk.pay.b.a.l(str);
        ChannelInfo a2 = com.airpay.paysdk.qrcode.a.a().a(Integer.valueOf(i));
        if (l == 136) {
            return b(a.a().b(), a2);
        }
        if (l == 153) {
            if (TextUtils.isEmpty(str2)) {
                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            long j = 0;
            try {
                j = Long.parseLong(str2);
            } catch (NumberFormatException e2) {
                com.airpay.paysdk.common.b.a.a((Throwable) e2);
            }
            return a.a().b().getString(c.i.com_garena_beepay_error_topup_channel_unavailable, new Object[]{a(a.a().b(), j, i2, false)});
        } else if (l != 154) {
            return c(l);
        } else {
            return a.a().b().getString(c.i.com_garena_beepay_error_payment_channel_unavailable, new Object[]{a(a.a().b(), a2)});
        }
    }

    public static String c(int i) {
        int a2 = g.a(i);
        if (a2 <= 0 || a2 == c.i.com_garena_beepay_unknown_error) {
            return a.a().b().getString(c.i.com_garena_beepay_error_unknown);
        }
        return a.a().b().getString(a2);
    }

    public static String d(Context context, String str) {
        int r = com.airpay.paysdk.pay.b.a.r(str);
        if (r == -1) {
            return context.getString(c.i.com_garena_beepay_error_daily_purchase_limit_exceeded);
        }
        return context.getString(c.i.com_garena_beepay_error_daily_purchase_limit_exceeded_detailed, new Object[]{Integer.valueOf(r)});
    }

    public static void a(TextView textView) {
        textView.setSaveEnabled(false);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
