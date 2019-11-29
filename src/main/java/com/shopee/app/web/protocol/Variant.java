package com.shopee.app.web.protocol;

import com.shopee.app.data.viewmodel.chatP2P.VMOffer;
import java.util.List;

public class Variant {
    public final long modelID;
    public final String modelName;
    public final long modelPrice;
    public final long modelPriceBeforeDiscount;
    public final int modelStock;
    public final List<Integer> tierIndexes;

    public Variant(long j, String str, long j2, int i, long j3, List<Integer> list) {
        this.modelID = j;
        this.modelName = str;
        this.modelPrice = j2;
        this.modelStock = i;
        this.modelPriceBeforeDiscount = j3;
        this.tierIndexes = list;
    }

    public Variant newFromVMOffer(VMOffer vMOffer) {
        return new Variant(this.modelID, this.modelName, vMOffer.getOfferPrice(), this.modelStock, this.modelPriceBeforeDiscount, this.tierIndexes);
    }
}
