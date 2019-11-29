package com.airpay.paysdk.core.bean;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.airpay.paysdk.base.d.c;
import com.airpay.paysdk.base.proto.ChannelInfoProto;
import com.airpay.paysdk.c;
import com.airpay.paysdk.pay.b.a;
import com.airpay.paysdk.qrcode.model.BPChannelDisplayInfo;
import com.tencent.ijk.media.player.IjkMediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

public class ChannelInfo implements Parcelable {
    public static final Parcelable.Creator<ChannelInfo> CREATOR = new Parcelable.Creator<ChannelInfo>() {
        /* renamed from: a */
        public ChannelInfo createFromParcel(Parcel parcel) {
            return new ChannelInfo(parcel);
        }

        /* renamed from: a */
        public ChannelInfo[] newArray(int i) {
            return new ChannelInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    protected int f4103a;

    /* renamed from: b  reason: collision with root package name */
    protected String f4104b;

    /* renamed from: c  reason: collision with root package name */
    protected String f4105c;

    /* renamed from: d  reason: collision with root package name */
    protected String f4106d;

    /* renamed from: e  reason: collision with root package name */
    protected int f4107e;

    /* renamed from: f  reason: collision with root package name */
    protected int f4108f;

    /* renamed from: g  reason: collision with root package name */
    protected String f4109g;
    protected float h;
    protected String i;
    protected long j;
    protected long k;
    protected String l;
    protected int m;
    protected int n;
    protected int o;
    protected int p;
    protected long q;
    protected BPChannelDisplayInfo r;
    private TicketConfig s;
    private boolean t;

    public int describeContents() {
        return 0;
    }

    public ChannelInfo(ChannelInfoProto channelInfoProto) {
        this.f4103a = -1;
        this.f4107e = 0;
        this.f4108f = 0;
        this.j = 0;
        this.k = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.t = false;
        this.f4103a = channelInfoProto.channel_id.intValue();
        this.f4104b = channelInfoProto.name;
        this.f4105c = channelInfoProto.description;
        this.f4106d = channelInfoProto.icon;
        this.f4107e = channelInfoProto.type.intValue();
        this.f4108f = channelInfoProto.priority.intValue();
        this.f4109g = channelInfoProto.currency;
        this.h = channelInfoProto.discount.floatValue();
        this.i = channelInfoProto.extra_data;
        this.j = channelInfoProto.txn_min.longValue();
        this.k = channelInfoProto.txn_max.longValue();
        this.l = channelInfoProto.message;
        this.m = channelInfoProto.availability.intValue();
        if (channelInfoProto.min_version_android != null) {
            this.p = channelInfoProto.min_version_android.intValue();
        }
        if (channelInfoProto.flag != null) {
            this.q = channelInfoProto.flag.longValue();
        }
        this.o = c.a();
    }

    protected ChannelInfo(Parcel parcel) {
        this.f4103a = -1;
        boolean z = false;
        this.f4107e = 0;
        this.f4108f = 0;
        this.j = 0;
        this.k = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.t = false;
        this.f4103a = parcel.readInt();
        this.f4104b = parcel.readString();
        this.f4105c = parcel.readString();
        this.f4106d = parcel.readString();
        this.f4107e = parcel.readInt();
        this.f4108f = parcel.readInt();
        this.f4109g = parcel.readString();
        this.h = parcel.readFloat();
        this.i = parcel.readString();
        this.j = parcel.readLong();
        this.k = parcel.readLong();
        this.l = parcel.readString();
        this.m = parcel.readInt();
        this.n = parcel.readInt();
        this.o = parcel.readInt();
        this.p = parcel.readInt();
        this.q = parcel.readLong();
        this.r = (BPChannelDisplayInfo) parcel.readParcelable(BPChannelDisplayInfo.class.getClassLoader());
        this.s = (TicketConfig) parcel.readParcelable(TicketConfig.class.getClassLoader());
        this.t = parcel.readByte() != 0 ? true : z;
    }

    public ChannelInfo(ChannelInfo channelInfo) {
        this.f4103a = -1;
        this.f4107e = 0;
        this.f4108f = 0;
        this.j = 0;
        this.k = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.t = false;
        this.f4103a = channelInfo.f4103a;
        this.f4104b = channelInfo.f4104b;
        this.f4105c = channelInfo.f4105c;
        this.f4106d = channelInfo.f4106d;
        this.f4107e = channelInfo.f4107e;
        this.f4108f = channelInfo.f4108f;
        this.f4109g = channelInfo.f4109g;
        this.h = channelInfo.h;
        this.i = channelInfo.i;
        this.j = channelInfo.j;
        this.k = channelInfo.k;
        this.l = channelInfo.l;
        this.m = channelInfo.m;
        this.p = channelInfo.p;
        this.q = channelInfo.q;
        this.r = channelInfo.r;
        this.s = channelInfo.s;
        this.t = channelInfo.t;
        this.o = channelInfo.o;
        this.n = channelInfo.n;
    }

    public ChannelInfo(int i2, String str) {
        this.f4103a = -1;
        this.f4107e = 0;
        this.f4108f = 0;
        this.j = 0;
        this.k = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.t = false;
        this.f4103a = i2;
        this.f4109g = str;
    }

    public int a() {
        return this.f4103a;
    }

    public int b() {
        return this.f4107e;
    }

    public String c() {
        return this.f4109g;
    }

    public String d() {
        return this.i;
    }

    public long e() {
        return this.j;
    }

    public long f() {
        return this.k;
    }

    public BPChannelDisplayInfo a(String str) {
        if (!this.t) {
            this.r = a.b(str, this.f4106d);
            this.t = true;
        }
        return this.r;
    }

    public String b(String str) {
        if (!this.t) {
            this.r = a.b(str, this.f4106d);
            this.t = true;
        }
        BPChannelDisplayInfo bPChannelDisplayInfo = this.r;
        if (bPChannelDisplayInfo == null) {
            return null;
        }
        return bPChannelDisplayInfo.b();
    }

    public int g() {
        int i2 = this.f4107e;
        if (i2 == 20002) {
            return c.d.com_garena_beepay_icon_item_welcome_gift;
        }
        switch (i2) {
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /*10003*/:
                return c.d.com_garena_beepay_icon_garenashell;
            case IjkMediaPlayer.FFP_PROP_FLOAT_AVDELAY /*10004*/:
                int i3 = this.f4103a;
                if (i3 == 20011) {
                    return c.d.com_garena_beepay_icon_carrier_ais;
                }
                if (i3 == 20013) {
                    return c.d.com_garena_beepay_icon_item_dtac;
                }
                if (i3 == 20015) {
                    return c.d.com_garena_beepay_icon_carrier_true;
                }
                if (i3 == 20016) {
                    return c.d.com_garena_beepay_icon_myworld;
                }
                break;
            case IjkMediaPlayer.FFP_PROP_FLOAT_AVDIFF /*10005*/:
                return c.d.com_garena_beepay_icon_cyberpay;
            case 10006:
                int i4 = this.f4103a;
                if (i4 == 20005) {
                    return c.d.com_garena_beepay_icon_item_epin_ais;
                }
                if (i4 == 20007) {
                    return c.d.com_garena_beepay_icon_item_dtac;
                }
                if (i4 == 20009) {
                    return c.d.com_garena_beepay_icon_item_epin_true;
                }
                break;
            case IjkMediaPlayer.FFP_PROP_FLOAT_DROP_FRAME_RATE /*10007*/:
                return c.d.com_garena_beepay_icon_channel_default;
            case 10008:
                return c.d.com_garena_beepay_icon_item_gamecredits;
            case 10009:
                if (this.f4103a == 20041) {
                    return c.d.com_garena_beepay_icon_item_movie;
                }
                break;
            case 10010:
                switch (this.f4103a) {
                    case 21000:
                        return c.d.com_garena_beepay_icon_item_transfer_in;
                    case 21001:
                        return c.d.com_garena_beepay_icon_item_transfer_out;
                    case 21002:
                        return c.d.com_garena_beepay_icon_item_withdraw;
                    case 21003:
                    case 21004:
                    case 21005:
                        return c.d.com_garena_beepay_icon_item_cash_topup;
                    case 21007:
                        return c.d.icon_item_remittance;
                }
            default:
                switch (i2) {
                    case 11001:
                        return c.d.com_garena_beepay_icon_item_bill_general;
                    case 11002:
                        return c.d.com_garena_beepay_icon_item_bill_utilities;
                    case 11003:
                        return c.d.com_garena_beepay_icon_item_bill_creditcard;
                    case 11004:
                        return c.d.com_garena_beepay_icon_item_bill_telco;
                    case 11005:
                        return c.d.com_garena_beepay_icon_item_bill_insurance;
                    case 11006:
                        return c.d.com_garena_beepay_icon_item_bill_lease;
                    case 11007:
                        return c.d.com_garena_beepay_icon_item_bill_real_estate;
                    default:
                        if (this.f4103a == 20060) {
                            return c.d.com_garena_beepay_img_beetalk_topup;
                        }
                        break;
                }
        }
        return c.d.com_garena_beepay_icon_channel_default;
    }

    public String c(String str) {
        if (this.s == null) {
            this.s = d(str);
        }
        TicketConfig ticketConfig = this.s;
        if (ticketConfig == null) {
            return null;
        }
        return ticketConfig.f4120b;
    }

    private TicketConfig d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(d()).getJSONObject("ticket");
            JSONObject optJSONObject = jSONObject.optJSONObject("usage_instructions");
            String optString = optJSONObject != null ? optJSONObject.optString(str) : null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("refund_message");
            String optString2 = optJSONObject2 != null ? optJSONObject2.optString(str) : null;
            boolean z = false;
            int optInt = jSONObject.optInt("ticket_type", 0);
            if (jSONObject.optInt("usage_markable", 0) == 1) {
                z = true;
            }
            return new TicketConfig(optInt, optString, optString2, z);
        } catch (JSONException e2) {
            com.airpay.paysdk.common.b.a.a((Throwable) e2);
            return null;
        }
    }

    public String h() {
        if (!this.t) {
            this.r = a(com.airpay.paysdk.base.different.a.a().d());
        }
        BPChannelDisplayInfo bPChannelDisplayInfo = this.r;
        if (bPChannelDisplayInfo != null) {
            String c2 = bPChannelDisplayInfo.c();
            if (!TextUtils.isEmpty(c2)) {
                return c2;
            }
        }
        Resources resources = com.airpay.paysdk.a.a().b().getResources();
        int i2 = this.f4107e;
        if (i2 == 10005) {
            return resources.getString(c.i.com_garena_beepay_label_account_topup);
        }
        if (i2 != 2) {
            return i();
        }
        int i3 = this.f4103a;
        if (i3 == 10000) {
            return resources.getString(c.i.com_garena_beepay_label_ktb_abbr);
        }
        if (i3 == 10001) {
            return resources.getString(c.i.com_garena_beepay_label_scb_abbr);
        }
        if (i3 == 10005) {
            return resources.getString(c.i.com_garena_beepay_label_kbank_abbr);
        }
        if (i3 == 10006) {
            return resources.getString(c.i.com_garena_beepay_label_bbl_abbr);
        }
        if (i3 != 10409) {
            return resources.getString(c.i.com_garena_beepay_label_bank_account);
        }
        return resources.getString(c.i.com_garena_beepay_label_bay_abbr);
    }

    public String i() {
        String e2 = e(com.airpay.paysdk.base.different.a.a().d());
        if (!TextUtils.isEmpty(e2)) {
            return e2;
        }
        Resources resources = com.airpay.paysdk.a.a().b().getResources();
        int i2 = this.f4107e;
        if (i2 == 20002) {
            return resources.getString(c.i.com_garena_beepay_label_welcome_gift);
        }
        switch (i2) {
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /*10003*/:
                return resources.getString(c.i.com_garena_beepay_label_garena_shell_topup);
            case IjkMediaPlayer.FFP_PROP_FLOAT_AVDELAY /*10004*/:
                int i3 = this.f4103a;
                if (i3 == 20011) {
                    return resources.getString(c.i.com_garena_beepay_label_ais_1_2_call);
                }
                if (i3 == 20013) {
                    return resources.getString(c.i.com_garena_beepay_label_dtac_happy);
                }
                if (i3 == 20015) {
                    return resources.getString(c.i.com_garena_beepay_label_true_move_h);
                }
                break;
            case IjkMediaPlayer.FFP_PROP_FLOAT_AVDIFF /*10005*/:
                return resources.getString(c.i.com_garena_beepay_label_cyber_pay_topup);
            case 10006:
                int i4 = this.f4103a;
                if (i4 == 20005) {
                    return resources.getString(c.i.com_garena_beepay_label_ais_1_2_call_cash_card);
                }
                if (i4 == 20007) {
                    return resources.getString(c.i.com_garena_beepay_label_dtac_happy_cash_card);
                }
                if (i4 == 20009) {
                    return resources.getString(c.i.com_garena_beepay_label_true_money_cash_card);
                }
                break;
            case IjkMediaPlayer.FFP_PROP_FLOAT_DROP_FRAME_RATE /*10007*/:
                if (TextUtils.isEmpty(this.f4104b)) {
                    return resources.getString(c.i.com_garena_beepay_label_third_party_merchant_purchase);
                }
                break;
            case 10008:
                break;
            case 10009:
                if (this.f4103a != 20041) {
                    return resources.getString(c.i.com_garena_beepay_label_movie_tickets);
                }
                return resources.getString(c.i.com_garena_beepay_label_major_cineplex);
            case 10010:
                switch (this.f4103a) {
                    case 21000:
                        return resources.getString(c.i.com_garena_beepay_label_transfer_in);
                    case 21001:
                        return resources.getString(c.i.com_garena_beepay_label_transfer_out);
                    case 21002:
                        return resources.getString(c.i.com_garena_beepay_label_cash_withdraw);
                    case 21003:
                    case 21004:
                    case 21005:
                    case 21006:
                        return resources.getString(c.i.com_garena_beepay_label_cash_top_up);
                    case 21007:
                        return resources.getString(c.i.com_garena_beepay_label_remittance);
                }
            default:
                int i5 = this.f4103a;
                if (i5 == 10007) {
                    return resources.getString(c.i.com_garena_beepay_label_top_up_via_airpay_counter);
                }
                if (i5 == 10008) {
                    return resources.getString(c.i.com_garena_beepay_label_top_up_via_airpay_cashcard);
                }
                break;
        }
        return this.f4104b;
    }

    private String e(String str) {
        if (!this.t) {
            this.r = a(str);
        }
        BPChannelDisplayInfo bPChannelDisplayInfo = this.r;
        if (bPChannelDisplayInfo == null) {
            return null;
        }
        return bPChannelDisplayInfo.a();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f4103a);
        parcel.writeString(this.f4104b);
        parcel.writeString(this.f4105c);
        parcel.writeString(this.f4106d);
        parcel.writeInt(this.f4107e);
        parcel.writeInt(this.f4108f);
        parcel.writeString(this.f4109g);
        parcel.writeFloat(this.h);
        parcel.writeString(this.i);
        parcel.writeLong(this.j);
        parcel.writeLong(this.k);
        parcel.writeString(this.l);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
        parcel.writeInt(this.p);
        parcel.writeLong(this.q);
        parcel.writeParcelable(this.r, i2);
        parcel.writeParcelable(this.s, i2);
        parcel.writeByte(this.t ? (byte) 1 : 0);
    }

    public String toString() {
        return "ChannelInfo{mChannelId=" + this.f4103a + ", mName='" + this.f4104b + '\'' + ", mDescription='" + this.f4105c + '\'' + ", mIcon='" + this.f4106d + '\'' + ", mType=" + this.f4107e + ", mPriority=" + this.f4108f + ", mCurrency='" + this.f4109g + '\'' + ", mDiscount=" + this.h + ", mExtraData='" + this.i + '\'' + ", mTxnMin=" + this.j + ", mTxnMax=" + this.k + ", mMessage='" + this.l + '\'' + ", mAvailability=" + this.m + ", mLastUsedAt=" + this.n + ", mLastUpdatedAt=" + this.o + ", mMinVersion=" + this.p + ", mFlag=" + this.q + ", mDisplayInfo=" + this.r + ", mTicketConfig=" + this.s + ", mHasLoadedDisplayInfo=" + this.t + '}';
    }
}
