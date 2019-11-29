package com.shopee.app.data.viewmodel.chatP2P;

import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.ItemSnapshotInfo;

public class VMOfferHistory {
    private ItemDetail itemDetail;
    private VMOffer offer;
    private ItemSnapshotInfo snapshot;
    private String title;
    private int type;

    public VMOffer getOffer() {
        return this.offer;
    }

    public void setOffer(VMOffer vMOffer) {
        this.offer = vMOffer;
    }

    public ItemSnapshotInfo getSnapshot() {
        return this.snapshot;
    }

    public void setSnapshot(ItemSnapshotInfo itemSnapshotInfo) {
        this.snapshot = itemSnapshotInfo;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setItemDetail(ItemDetail itemDetail2) {
        this.itemDetail = itemDetail2;
    }

    public ItemDetail getItemDetail() {
        return this.itemDetail;
    }
}
