package com.airpay.paysdk.base.d;

import com.airpay.paysdk.c;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.imsdk.protocol.im_common;
import com.tencent.qalsdk.im_open.http;

public class g {
    public static int a(int i) {
        return a(-1, -1, i);
    }

    public static int a(int i, int i2, int i3) {
        if (i2 == 13424) {
            if (i3 == 535) {
                return c.i.airpay_error_535_bank_account_locked_seabank;
            }
            if (i3 == 549) {
                return c.i.airpay_error_549_bank_invalid_card_info_seabank;
            }
        } else if (i2 == 13401 && i3 == 533) {
            return c.i.airpay_error_533_bank_pin_card_try_max_limit_exceeded_vcb;
        }
        boolean z = (i == -1 && i2 == -1) ? false : true;
        if (i3 != 5) {
            if (i3 == 108) {
                return c.i.airpay_error_108_otp_required;
            }
            if (i3 != 151) {
                if (i3 == 343) {
                    return c.i.airpay_error_343_bank_account_registration_not_executed;
                }
                if (i3 != 101) {
                    if (i3 != 102) {
                        if (i3 == 358) {
                            return c.i.airpay_error_358_bank_account_suspended;
                        }
                        if (i3 == 359) {
                            return c.i.airpay_error_359_bank_account_expired;
                        }
                        if (i3 == 549) {
                            return c.i.airpay_error_549_bank_invalid_card_info;
                        }
                        if (i3 == 550) {
                            return c.i.airpay_error_550_bank_duplicate_ic_number;
                        }
                        switch (i3) {
                            case 347:
                                return c.i.airpay_error_347_bank_and_wallet_mobile_diff;
                            case 348:
                                return c.i.airpay_error_348_otp_retry;
                            case 349:
                                return c.i.airpay_error_349_bank_airpay_mobile_not_reg_ibanking;
                            default:
                                switch (i3) {
                                    case im_common.BU_FRIEND /*520*/:
                                        return c.i.airpay_error_520_bank_maximum_limit_exceeded;
                                    case 521:
                                        return c.i.airpay_error_521_bank_maximum_daily_limit_exceeded;
                                    case 522:
                                        return c.i.airpay_error_522_bank_maximum_txn_daily_limit_exceeded;
                                    case 523:
                                        return c.i.airpay_error_523_bank_lower_than_minimum_limit;
                                    case 524:
                                        return c.i.airpay_error_524_bank_remain_amount_too_low;
                                    case 525:
                                        return c.i.airpay_error_525_bank_not_enough_balance;
                                    case 526:
                                        return c.i.airpay_error_526_bank_info_not_found;
                                    default:
                                        switch (i3) {
                                            case 528:
                                                return c.i.airpay_error_528_bank_balance_not_found;
                                            case 529:
                                                return c.i.airpay_error_529_bank_need_phone_no_to_get_otp;
                                            case 530:
                                                return c.i.airpay_error_530_bank_invalid_card;
                                            case 531:
                                                return c.i.airpay_error_531_bank_otp_expired;
                                            case 532:
                                                return c.i.airpay_error_532_bank_otp_fail;
                                            case 533:
                                                return c.i.airpay_error_533_bank_pin_card_try_max_limit_exceeded;
                                            case 534:
                                                return c.i.airpay_error_534_bank_account_is_unauthorized;
                                            case 535:
                                                return c.i.airpay_error_535_bank_account_locked;
                                            case 536:
                                                return c.i.airpay_error_536_bank_txn_amount;
                                            default:
                                                switch (i3) {
                                                    case 538:
                                                        return c.i.airpay_error_538_bank_can_not_get_otp;
                                                    case 539:
                                                        return c.i.airpay_error_539_bank_txn_not_found;
                                                    case 540:
                                                        return c.i.airpay_error_540_bank_txn_cancelled;
                                                    case 541:
                                                        return c.i.airpay_error_541_bank_invalid_otp;
                                                    default:
                                                        switch (i3) {
                                                            case 543:
                                                                return c.i.airpay_error_543_bank_unknown_error;
                                                            case 544:
                                                                return c.i.airpay_error_544_bank_debit_card_not_found;
                                                            case 545:
                                                                return c.i.airpay_error_545_bank_account_is_not_connected;
                                                            case 546:
                                                                return c.i.airpay_error_546_bank_invalid_status;
                                                        }
                                                }
                                        }
                                }
                        }
                    } else if (z) {
                        return c.i.airpay_error_102_account_exist;
                    }
                } else if (z) {
                    return c.i.airpay_error_101_account_not_exist;
                }
            } else if (z) {
                return c.i.airpay_error_151_provider_txn_not_executed;
            }
        } else if (z) {
            return c.i.airpay_error_5_server;
        }
        if (i3 == 4) {
            return c.i.com_garena_beepay_unknown_error;
        }
        if (i3 == 5) {
            return c.i.com_garena_beepay_error_server;
        }
        if (i3 == 110) {
            return c.i.com_garena_beepay_error_device_not_bound;
        }
        if (i3 == 111) {
            return c.i.com_garena_beepay_error_invalid_payment_password;
        }
        if (i3 == 160) {
            return c.i.com_garena_beepay_error_wallet_limit_exceeded;
        }
        if (i3 == 161) {
            return c.i.com_garena_beepay_error_order_expired;
        }
        switch (i3) {
            case 2:
                return c.i.com_garena_beepay_error_parameter_error;
            case 107:
                return c.i.com_garena_beepay_label_incorrect_verification_code;
            case 113:
                return c.i.com_garena_beepay_error_payment_password_limit;
            case 124:
                break;
            case 125:
                return c.i.com_garena_beepay_error_channel_not_exist;
            case 126:
            case 127:
                return c.i.com_garena_beepay_error_item;
            case 128:
                return c.i.com_garena_beepay_error_topup;
            case 129:
                return c.i.com_garena_beepay_error_not_enough_balance;
            case 130:
                return c.i.com_garena_beepay_error_device_bind_time_limit;
            case 146:
                return c.i.com_garena_beepay_error_channel_connection;
            case 163:
                return c.i.com_garena_beepay_error_payment_channel_not_available_general;
            case 165:
                return c.i.com_garena_beepay_error_invalid_label;
            case 166:
                return c.i.com_garena_beepay_error_exceed_daily_purchase_limit;
            case 180:
            case 183:
                return c.i.com_garena_beepay_error_bill;
            case 181:
                return c.i.com_garena_beepay_error_bill_config;
            case 182:
                return c.i.com_garena_beepay_error_bill_amount;
            case 184:
                return c.i.com_garena_beepay_error_bill_overdue;
            case 185:
                return c.i.com_garena_beepay_error_no_outstanding_bill;
            case 186:
                return c.i.com_garena_beepay_error_paid_by_credit_card;
            case 187:
                return c.i.com_garena_beepay_error_too_frequent_bill_txn;
            case 188:
                return c.i.com_garena_beepay_error_outstanding_debt;
            case FacebookRequestErrorClassification.EC_INVALID_TOKEN /*190*/:
                return c.i.com_garena_beepay_invalid_bar_code;
            case 191:
                return c.i.com_garena_beepay_unrecognized_qr_code;
            case 210:
                return c.i.com_garena_beepay_error_cash_transferee_account;
            case JfifUtil.MARKER_RST7 /*215*/:
                return c.i.com_garena_beepay_error_cash_transfer_limit_exceeded;
            case 216:
                return c.i.com_garena_beepay_error_cash_transfer_user_request;
            case 220:
                return c.i.com_garena_beepay_error_gift_already_redeemed;
            case 221:
                return c.i.com_garena_beepay_error_gift_no_valid_topup_account;
            case 240:
            case 241:
            case 242:
            case 243:
            case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE /*244*/:
            case 245:
            case 250:
            case 251:
                return c.i.com_garena_beepay_cinema_ticket_session_not_found;
            case 246:
                return c.i.com_garena_beepay_sf_too_many_seats;
            case 247:
                return c.i.com_garena_beepay_sf_seat_not_available;
            case 248:
                return c.i.com_garena_beepay_sf_transaction_expired;
            case 252:
                return c.i.com_garena_beepay_sf_session_expired;
            case 280:
                return c.i.com_garena_beepay_error_voucher_not_exist;
            case 281:
                return c.i.com_garena_beepay_error_voucher_used;
            case 282:
                return c.i.com_garena_beepay_error_voucher_already_refunded;
            case 283:
            case 284:
                return c.i.com_garena_beepay_error_voucher_amount_incorrect;
            case 285:
                return c.i.com_garena_beepay_error_voucher_limit;
            case 286:
                return c.i.com_garena_beepay_error_voucher_not_ready;
            case 287:
                return c.i.com_garena_beepay_error_voucher_expired;
            case 300:
                return c.i.com_garena_beepay_loan_config_wrong;
            case 301:
                return c.i.com_garena_beepay_loan_created_failure;
            case 302:
                return c.i.com_garena_beepay_loan_max_unpaid_will_exceed;
            case 360:
                return c.i.com_garena_beepay_label_tp_session_expired;
            case 361:
                return c.i.com_garena_beepay_label_tp_error_seats;
            case 362:
                return c.i.com_garena_beepay_label_tp_error_seats_not_available;
            case 363:
                return c.i.com_garena_beepay_error_search_config;
            case 364:
                return c.i.com_garena_beepay_error_search_not_found;
            case 366:
                return c.i.com_garena_beepay_error_location_invalid;
            case 367:
                return c.i.com_garena_beepay_error_field_invalid;
            case 368:
                return c.i.com_garena_beepay_error_field_invalid_length;
            case 369:
                return c.i.com_garena_beepay_error_field_invalid_phone;
            case 370:
                return c.i.com_garena_beepay_error_field_invalid_email;
            case 390:
            case 391:
                return c.i.com_garena_beepay_error_ibanking_txn_failed;
            case 392:
                return c.i.com_garena_beepay_error_ibanking_txn_cancelled;
            case 400:
                return c.i.com_garena_beepay_error_withdrawal_daily_limit_exceeded;
            case 401:
                return c.i.com_garena_beepay_error_remittance_daily_limit_exceeded;
            case 410:
                return c.i.com_garena_beepay_error_virtual_card_not_exist;
            case 411:
                return c.i.com_garena_beepay_error_virtual_card_elevation_expired;
            case http.Request_Entity_Too_Large /*413*/:
                return c.i.com_garena_beepay_error_virtual_card_too_many;
            case http.Request_URI_Too_Long /*414*/:
                return c.i.com_garena_beepay_error_virtual_card_name_invalid;
            case 481:
                return c.i.com_garena_beepay_error_auth_verification_failed;
            default:
                switch (i3) {
                    case 101:
                        return c.i.com_garena_beepay_error_user_not_exist;
                    case 102:
                        return c.i.com_garena_beepay_error_account_existed;
                    case 103:
                        return c.i.com_garena_beepay_error_account_locked;
                    case 104:
                        return c.i.com_garena_beepay_error_number_carrier_not_match;
                    case 105:
                        return c.i.com_garena_beepay_error_otp_sent_fail;
                    default:
                        switch (i3) {
                            case 119:
                                return c.i.com_garena_beepay_error_bank_account_not_exist;
                            case 120:
                                return c.i.com_garena_beepay_error_bank_account_number_invalid;
                            case 121:
                                return c.i.com_garena_beepay_error_ic_not_verified;
                            case 122:
                                break;
                            default:
                                switch (i3) {
                                    case 135:
                                        return c.i.com_garena_beepay_error_payment_option;
                                    case 136:
                                        return c.i.com_garena_beepay_error_payment_option;
                                    case 137:
                                        return c.i.com_garena_beepay_error_payment_limit_exceed;
                                    default:
                                        switch (i3) {
                                            case 139:
                                                return c.i.com_garena_beepay_error_event_expired;
                                            case 140:
                                                return c.i.com_garena_beepay_error_provider_txn_not_found;
                                            case 141:
                                                return c.i.com_garena_beepay_error_event_error;
                                            case 142:
                                                return c.i.com_garena_beepay_error_version_too_low;
                                            case 143:
                                                return c.i.com_garena_beepay_error_billpayment_provider_transaction_not_comited;
                                            default:
                                                switch (i3) {
                                                    case 148:
                                                        return c.i.com_garena_beepay_error_payment_sold_out;
                                                    case 149:
                                                        return c.i.com_garena_beepay_error_too_many_reservations;
                                                    case 150:
                                                        return c.i.com_garena_beepay_error_provider_txn_expired;
                                                    case 151:
                                                        return c.i.com_garena_beepay_error_provider_txn_not_executed;
                                                    case 152:
                                                        return c.i.com_garena_beepay_error_credit_card_rejected;
                                                    default:
                                                        switch (i3) {
                                                            case 154:
                                                                return c.i.com_garena_beepay_error_payment_channel_not_available_general;
                                                            case 155:
                                                                return c.i.com_garena_beepay_error_risk_mgmt;
                                                            case 156:
                                                                return c.i.com_garena_beepay_error_insufficient_cash_balance;
                                                            case 157:
                                                                return c.i.com_garena_beepay_error_payment_password_change_period;
                                                            case 158:
                                                                return c.i.com_garena_beepay_error_daily_purchase_limit_exceeded;
                                                            default:
                                                                return c.i.com_garena_beepay_unknown_error;
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
        return c.i.com_garena_beepay_error_order_action_status_description;
    }
}
