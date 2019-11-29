package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum PaymentMethod implements ProtoEnum {
    PAY_NONE(0),
    PAY_CYBERSOURCE(1),
    PAY_BANK_TRANSFER(2),
    PAY_OFFLINE_PAYMENT(3),
    PAY_IPAY88(4),
    PAY_FREE(5),
    PAY_COD(6),
    PAY_ESUN(7),
    PAY_BILL_PAYMENT(8),
    PAY_INDOMARET(13),
    PAY_KREDIVO(14),
    PAY_NICEPAY_CC(15),
    PAY_ESUN_CB(16),
    PAY_IPAY88_CC(17),
    PAY_AIRPAY_CC(18),
    PAY_BCA_ONE_KLIK(19),
    PAY_SHOPEE_WALLET(20),
    PAY_AKULAKU(21),
    PAY_STRIPE_CC(22),
    PAY_AIRPAY_CC_INSTALLMENT(23),
    PAY_SHOPEE_CREDIT(24),
    PAY_ALFAMART(25),
    PAY_CYBERSOURCE_INSTALLMENT(26),
    PAY_SHOPEE_WALLET_V2(27),
    PAY_AIRPAY_WALLET_V2(28),
    PAY_VN_IBANKING(29),
    PAY_AIRPAY_GIRO(30),
    PAY_SIPP_VA(31),
    PAY_WIRECARD_INSTALLMENT(32),
    PAY_JKO_PAY(33),
    PAY_MOLPAY_CASH(34),
    PAY_JKO_COD(35),
    PAY_JKO_BT(36),
    PAY_MOLPAY_IBANKING(37),
    PAY_EBANX_BOLETO(38),
    PAY_EBANX_CC(39),
    PAY_EBANX_IBANKING(40),
    PAY_SIPP_MIXED_VA(41),
    PAY_MPGS_CC(42);
    
    private final int value;

    private PaymentMethod(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
