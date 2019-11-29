package com.shopee.protocol.shop;

import com.shopee.live.livestreaming.data.entity.DanmaKuEntity;
import com.squareup.wire.ProtoEnum;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.imsdk.protocol.im_common;
import com.tencent.qalsdk.im_open.http;

public enum TransactionType implements ProtoEnum {
    ESCROW_VERIFIED_ADD(101),
    ESCROW_VERIFIED_MINUS(102),
    OFFLINE_ESCROW_ADD(103),
    WITHDRAWAL_CREATED(DanmaKuEntity.MESSAGE_PUBLIC),
    WITHDRAWAL_COMPLETED(202),
    WITHDRAWAL_CANCELLED(203),
    REFUND_VERIFIED_ADD(301),
    AUTO_REFUND_ADD(302),
    FOODY_REFUND_ADD(im_common.RICH_STATUS_TMP_MSG),
    ADJUSTMENT_ADD(401),
    ADJUSTMENT_MINUS(402),
    SHOPEE_BUDDY_ADD(403),
    PAID_ADS_CHARGE(450),
    PAID_ADS_REFUND(451),
    SHOPEE_WALLET_PAY(http.Not_Implemented),
    TOPUP_SUCCESS(601),
    TOPUP_FAILD(602),
    DP_REFUND_VERIFIED_ADD(IMediaPlayer.MEDIA_INFO_BUFFERING_START);
    
    private final int value;

    private TransactionType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
