package com.shopee.live.livestreaming.data.entity.require;

import com.shopee.live.livestreaming.b;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.util.z;
import java.io.Serializable;

public class VoucherCodeEntity implements Serializable {
    public static final int ERROR_CODE_EXIST = 5;
    public static final int ERROR_CODE_NOLOGIN = 19;
    public static final int ERROR_CODE_NOTFOUND = 4;
    public static final int ERROR_CODE_OK = 0;
    public static final int ERROR_CODE_PARAM = 1;
    public static final int ERROR_CODE_PERM = 2;
    public static final int ERROR_CODE_PROMOTION = 14;
    public static final int ERROR_CODE_UNKNOW = -1;
    public static final int VOUCHER_CODE_ALREADY_USED = 6;
    public static final int VOUCHER_CODE_CLAIM_NOT_START = 18;
    public static final int VOUCHER_CODE_CODE_EXPIRED = 3;
    public static final int VOUCHER_CODE_CREDIT_CARD_NOT_MATCH = 15;
    public static final int VOUCHER_CODE_FROM_SELLER_OWN_SHOP = 16;
    public static final int VOUCHER_CODE_INVALID = 1;
    public static final int VOUCHER_CODE_INVALID_COUNTRY = 9;
    public static final int VOUCHER_CODE_MIN_BUCKET_NOT_MET = 7;
    public static final int VOUCHER_CODE_MIN_BUCKET_NOT_MET_AFTER_VOUCHER = 11;
    public static final int VOUCHER_CODE_MIN_BUCKET_NOT_MET_MAYBE_CATEGORY = 13;
    public static final int VOUCHER_CODE_MIN_BUCKET_NOT_MET_MAYBE_SELLER_PROMOTION = 12;
    public static final int VOUCHER_CODE_NONE = 0;
    public static final int VOUCHER_CODE_NOT_COMPLETE_TASK = 10;
    public static final int VOUCHER_CODE_NOT_STARTED = 8;
    public static final int VOUCHER_CODE_NO_APPLICABLE = 5;
    public static final int VOUCHER_CODE_NO_QUOTA = 4;
    public static final int VOUCHER_CODE_PAYMENT_NOT_MATCH = 17;
    public static final int VOUCHER_CODE_UA_NO_MATCH = 14;
    public static final int VOUCHER_CODE_WRONG_CODE = 2;
    private int err_code;
    private int invalid_message_code;
    private long promotion_id;
    private String voucher_code;

    public int getErr_code() {
        return this.err_code;
    }

    public void setErr_code(int i) {
        this.err_code = i;
    }

    public int getInvalid_message_code() {
        return this.invalid_message_code;
    }

    public void setInvalid_message_code(int i) {
        this.invalid_message_code = i;
    }

    public long getPromotion_id() {
        return this.promotion_id;
    }

    public void setPromotion_id(long j) {
        this.promotion_id = j;
    }

    public String getVoucher_code() {
        String str = this.voucher_code;
        return str == null ? "" : str;
    }

    public void setVoucher_code(String str) {
        this.voucher_code = str;
    }

    public boolean handleVoucherCodeTips() {
        int i = this.err_code;
        if (i == -1) {
            z.b(b.b().f28742b, c.g.live_streaming_msg_voucher_wallet_unknown);
            return true;
        } else if (i == 14) {
            return handleVoucherPromoteCode(this.invalid_message_code);
        } else {
            if (i == 4) {
                z.b(b.b().f28742b, c.g.live_streaming_msg_voucher_wallet_voucher_not_found);
                return true;
            } else if (i != 5) {
                return false;
            } else {
                z.b(b.b().f28742b, c.g.live_streaming_msg_voucher_wallet_voucher_exist);
                return true;
            }
        }
    }

    private boolean handleVoucherPromoteCode(int i) {
        switch (i) {
            case 1:
                z.b(b.b().f28742b, c.g.live_streaming_msg_voucher_wallet_invalid);
                return true;
            case 2:
                z.b(b.b().f28742b, c.g.live_streaming_msg_voucher_wallet_wrong_code);
                return true;
            case 3:
                z.b(b.b().f28742b, c.g.live_streaming_msg_voucher_wallet_code_expired);
                return true;
            case 4:
                z.b(b.b().f28742b, c.g.live_streaming_msg_voucher_wallet_no_quota);
                return true;
            case 6:
                z.b(b.b().f28742b, c.g.live_streaming_msg_voucher_wallet_already_used);
                return true;
            case 8:
                z.b(b.b().f28742b, c.g.live_streaming_msg_voucher_wallet_not_started);
                return true;
            case 9:
                z.b(b.b().f28742b, c.g.live_streaming_msg_voucher_wallet_invalid_country);
                return true;
            case 10:
                z.b(b.b().f28742b, c.g.live_streaming_msg_voucher_wallet_not_complete_task);
                return true;
            case 11:
                z.b(b.b().f28742b, c.g.live_streaming_msg_voucher_wallet_min_bucket_not_met_after_voucher);
                return true;
            case 12:
                z.b(b.b().f28742b, c.g.live_streaming_msg_voucher_wallet_min_bucket_not_met_maybe_seller_promotion);
                return true;
            case 13:
                z.b(b.b().f28742b, c.g.live_streaming_msg_voucher_wallet_min_bucket_not_met_maybe_category);
                return true;
            case 14:
                z.b(b.b().f28742b, c.g.live_streaming_msg_voucher_wallet_ua_no_match);
                return true;
            case 16:
                z.b(b.b().f28742b, c.g.live_streaming_msg_voucher_wallet_from_seller_own_shop);
                return true;
            case 18:
                z.b(b.b().f28742b, c.g.live_streaming_msg_voucher_wallet_not_start_to_claim);
                return true;
            default:
                return false;
        }
    }
}
