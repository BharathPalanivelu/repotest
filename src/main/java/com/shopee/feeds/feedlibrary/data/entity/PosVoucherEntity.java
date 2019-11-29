package com.shopee.feeds.feedlibrary.data.entity;

import com.shopee.feeds.feedlibrary.editor.sticker.a.f;
import java.io.Serializable;

public class PosVoucherEntity implements Serializable {
    public static final int COMMENT_STICKER = 2;
    public static final int VOUCHER_STICKER = 1;
    private f oldInfo;
    private int type;
    private VoucherEntity voucherEntity;

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public f getOldInfo() {
        return this.oldInfo;
    }

    public void setOldInfo(f fVar) {
        this.oldInfo = fVar;
    }

    public VoucherEntity getVoucherEntity() {
        return this.voucherEntity;
    }

    public void setVoucherEntity(VoucherEntity voucherEntity2) {
        this.voucherEntity = voucherEntity2;
    }
}
